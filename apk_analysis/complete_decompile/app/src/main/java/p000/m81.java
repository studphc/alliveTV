package p000;

import com.google.common.math.LinearTransformation;

/* loaded from: classes2.dex */
public final class m81 extends LinearTransformation {

    /* renamed from: a */
    public final double f22846a;

    /* renamed from: b */
    public l81 f22847b;

    public m81(double d) {
        this.f22846a = d;
        this.f22847b = null;
    }

    @Override // com.google.common.math.LinearTransformation
    public final LinearTransformation inverse() {
        l81 l81Var = this.f22847b;
        if (l81Var == null) {
            l81 l81Var2 = new l81(0.0d, this.f22846a, this);
            this.f22847b = l81Var2;
            return l81Var2;
        }
        return l81Var;
    }

    @Override // com.google.common.math.LinearTransformation
    public final boolean isHorizontal() {
        return false;
    }

    @Override // com.google.common.math.LinearTransformation
    public final boolean isVertical() {
        return true;
    }

    @Override // com.google.common.math.LinearTransformation
    public final double slope() {
        throw new IllegalStateException();
    }

    public final String toString() {
        return String.format("x = %g", Double.valueOf(this.f22846a));
    }

    @Override // com.google.common.math.LinearTransformation
    public final double transform(double d) {
        throw new IllegalStateException();
    }

    public m81(double d, l81 l81Var) {
        this.f22846a = d;
        this.f22847b = l81Var;
    }
}
