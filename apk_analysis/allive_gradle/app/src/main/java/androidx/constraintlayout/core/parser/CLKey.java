package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Objects;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class CLKey extends CLContainer {

    /* renamed from: d */
    public static final ArrayList f2280d;

    static {
        ArrayList arrayList = new ArrayList();
        f2280d = arrayList;
        arrayList.add("ConstraintSets");
        arrayList.add("Variables");
        arrayList.add("Generate");
        arrayList.add(TypedValues.TransitionType.NAME);
        arrayList.add("KeyFrames");
        arrayList.add(TypedValues.AttributesType.NAME);
        arrayList.add("KeyPositions");
        arrayList.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLKey(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CLKey) && !Objects.equals(getName(), ((CLKey) obj).getName())) {
            return false;
        }
        return super.equals(obj);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.f2277c.size() > 0) {
            return (CLElement) this.f2277c.get(0);
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }

    public void set(CLElement cLElement) {
        if (this.f2277c.size() > 0) {
            this.f2277c.set(0, cLElement);
        } else {
            this.f2277c.add(cLElement);
        }
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(getDebugName());
        addIndent(sb, i);
        String content = content();
        if (this.f2277c.size() > 0) {
            sb.append(content);
            sb.append(": ");
            if (f2280d.contains(content)) {
                i2 = 3;
            }
            if (i2 > 0) {
                sb.append(((CLElement) this.f2277c.get(0)).toFormattedJSON(i, i2 - 1));
            } else {
                String json = ((CLElement) this.f2277c.get(0)).toJSON();
                if (json.length() + i < CLElement.sMaxLine) {
                    sb.append(json);
                } else {
                    sb.append(((CLElement) this.f2277c.get(0)).toFormattedJSON(i, i2 - 1));
                }
            }
            return sb.toString();
        }
        return AbstractC1726qj.m7057m(content, ": <> ");
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (this.f2277c.size() > 0) {
            return getDebugName() + content() + ": " + ((CLElement) this.f2277c.get(0)).toJSON();
        }
        return getDebugName() + content() + ": <> ";
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0L);
        cLKey.setEnd(str.length() - 1);
        cLKey.set(cLElement);
        return cLKey;
    }
}
