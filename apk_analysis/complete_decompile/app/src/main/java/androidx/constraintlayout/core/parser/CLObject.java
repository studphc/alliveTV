package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import java.util.Iterator;
import p000.C1689pj;

/* loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {
    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        C1689pj c1689pj = new C1689pj();
        c1689pj.f25194b = 0;
        c1689pj.f25195c = this;
        return c1689pj;
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "{ ");
        Iterator it = this.f2277c.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(cLElement.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(getDebugName());
        sb.append("{\n");
        Iterator it = this.f2277c.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(",\n");
            }
            sb.append(cLElement.toFormattedJSON(CLElement.sBaseIndent + i, i2 - 1));
        }
        sb.append("\n");
        addIndent(sb, i);
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    @NonNull
    /* renamed from: clone */
    public CLObject mo8475clone() {
        return (CLObject) super.mo8475clone();
    }
}
