package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i2 <= 0 && json.length() + i < CLElement.sMaxLine) {
            sb.append(json);
        } else {
            sb.append("[\n");
            Iterator it = this.f2277c.iterator();
            boolean z = true;
            while (it.hasNext()) {
                CLElement cLElement = (CLElement) it.next();
                if (!z) {
                    sb.append(",\n");
                } else {
                    z = false;
                }
                addIndent(sb, CLElement.sBaseIndent + i);
                sb.append(cLElement.toFormattedJSON(CLElement.sBaseIndent + i, i2 - 1));
            }
            sb.append("\n");
            addIndent(sb, i);
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z = true;
        for (int i = 0; i < this.f2277c.size(); i++) {
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(((CLElement) this.f2277c.get(i)).toJSON());
        }
        return ((Object) sb) + "]";
    }
}
