package androidx.constraintlayout.core.parser;

import p000.EnumC1763rj;

/* loaded from: classes.dex */
public class CLToken extends CLElement {

    /* renamed from: c */
    public int f2288c;

    /* renamed from: d */
    public EnumC1763rj f2289d;

    /* renamed from: e */
    public final char[] f2290e;

    /* renamed from: f */
    public final char[] f2291f;

    /* renamed from: g */
    public final char[] f2292g;

    public CLToken(char[] cArr) {
        super(cArr);
        this.f2288c = 0;
        this.f2289d = EnumC1763rj.f25988a;
        this.f2290e = "true".toCharArray();
        this.f2291f = "false".toCharArray();
        this.f2292g = "null".toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() {
        EnumC1763rj enumC1763rj = this.f2289d;
        if (enumC1763rj == EnumC1763rj.f25989b) {
            return true;
        }
        if (enumC1763rj == EnumC1763rj.f25990c) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public EnumC1763rj getType() {
        return this.f2289d;
    }

    public boolean isNull() {
        if (this.f2289d == EnumC1763rj.f25991d) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        return content();
    }

    public boolean validate(char c, long j) {
        int ordinal = this.f2289d.ordinal();
        char[] cArr = this.f2290e;
        char[] cArr2 = this.f2291f;
        char[] cArr3 = this.f2292g;
        boolean z = false;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        int i = this.f2288c;
                        if (cArr3[i] == c) {
                            z = true;
                        }
                        if (z && i + 1 == cArr3.length) {
                            setEnd(j);
                        }
                    }
                } else {
                    int i2 = this.f2288c;
                    if (cArr2[i2] == c) {
                        z = true;
                    }
                    if (z && i2 + 1 == cArr2.length) {
                        setEnd(j);
                    }
                }
            } else {
                int i3 = this.f2288c;
                if (cArr[i3] == c) {
                    z = true;
                }
                if (z && i3 + 1 == cArr.length) {
                    setEnd(j);
                }
            }
        } else {
            int i4 = this.f2288c;
            if (cArr[i4] == c) {
                this.f2289d = EnumC1763rj.f25989b;
            } else if (cArr2[i4] == c) {
                this.f2289d = EnumC1763rj.f25990c;
            } else if (cArr3[i4] == c) {
                this.f2289d = EnumC1763rj.f25991d;
            }
            z = true;
        }
        this.f2288c++;
        return z;
    }
}
