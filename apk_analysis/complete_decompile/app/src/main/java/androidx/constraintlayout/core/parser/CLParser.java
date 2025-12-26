package androidx.constraintlayout.core.parser;

import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class CLParser {

    /* renamed from: a */
    public final String f2282a;

    /* renamed from: b */
    public boolean f2283b = false;

    /* renamed from: c */
    public int f2284c;

    public CLParser(String str) {
        this.f2282a = str;
    }

    public static CLObject parse(String str) {
        return new CLParser(str).parse();
    }

    /* renamed from: a */
    public final CLElement m448a(CLElement cLElement, int i, int i2, char[] cArr) {
        CLElement allocate;
        switch (AbstractC1726qj.m7041F(i2)) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                allocate = CLNumber.allocate(cArr);
                break;
            case 4:
                allocate = CLString.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.f2284c);
        allocate.setStart(i);
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }

    /* renamed from: b */
    public final CLElement m449b(int i, char c, CLElement cLElement, char[] cArr) {
        if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
            if (c != '\"' && c != '\'') {
                if (c != '[') {
                    if (c != ']') {
                        if (c != '{') {
                            if (c != '}') {
                                switch (c) {
                                    case '+':
                                    case '-':
                                    case '.':
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        return m448a(cLElement, i, 4, cArr);
                                    case ',':
                                    case ':':
                                        return cLElement;
                                    case '/':
                                        int i2 = i + 1;
                                        if (i2 < cArr.length && cArr[i2] == '/') {
                                            this.f2283b = true;
                                            return cLElement;
                                        }
                                        return cLElement;
                                    default:
                                        if ((cLElement instanceof CLContainer) && !(cLElement instanceof CLObject)) {
                                            CLElement m448a = m448a(cLElement, i, 7, cArr);
                                            CLToken cLToken = (CLToken) m448a;
                                            if (!cLToken.validate(c, i)) {
                                                throw new CLParsingException("incorrect token <" + c + "> at line " + this.f2284c, cLToken);
                                            }
                                            return m448a;
                                        }
                                        return m448a(cLElement, i, 6, cArr);
                                }
                            }
                        } else {
                            return m448a(cLElement, i, 2, cArr);
                        }
                    }
                    cLElement.setEnd(i - 1);
                    CLElement container = cLElement.getContainer();
                    container.setEnd(i);
                    return container;
                }
                return m448a(cLElement, i, 3, cArr);
            }
            if (cLElement instanceof CLObject) {
                return m448a(cLElement, i, 6, cArr);
            }
            return m448a(cLElement, i, 5, cArr);
        }
        return cLElement;
    }

    public CLObject parse() {
        char[] charArray = this.f2282a.toCharArray();
        int length = charArray.length;
        int i = 1;
        this.f2284c = 1;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            char c = charArray[i2];
            if (c == '{') {
                break;
            }
            if (c == '\n') {
                this.f2284c++;
            }
            i2++;
        }
        if (i2 != -1) {
            CLObject allocate = CLObject.allocate(charArray);
            allocate.setLine(this.f2284c);
            allocate.setStart(i2);
            int i3 = i2 + 1;
            CLElement cLElement = allocate;
            while (i3 < length) {
                char c2 = charArray[i3];
                if (c2 == '\n') {
                    this.f2284c += i;
                }
                if (this.f2283b) {
                    if (c2 == '\n') {
                        this.f2283b = z;
                    } else {
                        continue;
                        i3++;
                        i = 1;
                        z = false;
                    }
                }
                if (cLElement == null) {
                    break;
                }
                if (cLElement.isDone()) {
                    cLElement = m449b(i3, c2, cLElement, charArray);
                } else if (cLElement instanceof CLObject) {
                    if (c2 == '}') {
                        cLElement.setEnd(i3 - 1);
                    } else {
                        cLElement = m449b(i3, c2, cLElement, charArray);
                    }
                } else if (!(cLElement instanceof CLArray)) {
                    boolean z2 = cLElement instanceof CLString;
                    if (z2) {
                        long j = cLElement.mStart;
                        if (charArray[(int) j] == c2) {
                            cLElement.setStart(j + 1);
                            cLElement.setEnd(i3 - 1);
                        }
                    } else {
                        if (cLElement instanceof CLToken) {
                            CLToken cLToken = (CLToken) cLElement;
                            if (!cLToken.validate(c2, i3)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.f2284c, cLToken);
                            }
                        }
                        if ((cLElement instanceof CLKey) || z2) {
                            long j2 = cLElement.mStart;
                            char c3 = charArray[(int) j2];
                            if ((c3 == '\'' || c3 == '\"') && c3 == c2) {
                                cLElement.setStart(j2 + 1);
                                cLElement.setEnd(i3 - 1);
                            }
                        }
                        if (!cLElement.isDone() && (c2 == '}' || c2 == ']' || c2 == ',' || c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == ':')) {
                            long j3 = i3 - 1;
                            cLElement.setEnd(j3);
                            if (c2 == '}' || c2 == ']') {
                                cLElement = cLElement.getContainer();
                                cLElement.setEnd(j3);
                                if (cLElement instanceof CLKey) {
                                    cLElement = cLElement.getContainer();
                                    cLElement.setEnd(j3);
                                }
                            }
                        }
                    }
                } else if (c2 == ']') {
                    cLElement.setEnd(i3 - 1);
                } else {
                    cLElement = m449b(i3, c2, cLElement, charArray);
                }
                if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).f2277c.size() > 0)) {
                    cLElement = cLElement.getContainer();
                }
                i3++;
                i = 1;
                z = false;
            }
            while (cLElement != null && !cLElement.isDone()) {
                if (cLElement instanceof CLString) {
                    cLElement.setStart(((int) cLElement.mStart) + 1);
                }
                cLElement.setEnd(length - 1);
                cLElement = cLElement.getContainer();
            }
            return allocate;
        }
        throw new CLParsingException("invalid json content", null);
    }
}
