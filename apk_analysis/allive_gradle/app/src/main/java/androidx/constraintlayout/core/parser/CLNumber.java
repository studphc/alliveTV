package androidx.constraintlayout.core.parser;

import androidx.recyclerview.widget.RecyclerView;
import p000.ye0;

/* loaded from: classes.dex */
public class CLNumber extends CLElement {

    /* renamed from: c */
    public float f2281c;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.f2281c = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLNumber)) {
            return false;
        }
        float f = getFloat();
        float f2 = ((CLNumber) obj).getFloat();
        if ((Float.isNaN(f) && Float.isNaN(f2)) || f == f2) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.f2281c) && hasContent()) {
            this.f2281c = Float.parseFloat(content());
        }
        return this.f2281c;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.f2281c) && hasContent()) {
            this.f2281c = Integer.parseInt(content());
        }
        return (int) this.f2281c;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        float f = this.f2281c;
        if (f != RecyclerView.f7068F0) {
            i = Float.floatToIntBits(f);
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public boolean isInt() {
        if (((int) r0) == getFloat()) {
            return true;
        }
        return false;
    }

    public void putValue(float f) {
        this.f2281c = f;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        float f = getFloat();
        int i3 = (int) f;
        if (i3 == f) {
            sb.append(i3);
        } else {
            sb.append(f);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f = getFloat();
        int i = (int) f;
        if (i == f) {
            return ye0.m8291k(i, "");
        }
        return "" + f;
    }

    public CLNumber(float f) {
        super(null);
        this.f2281c = f;
    }
}
