package p000;

import com.google.common.math.LinearTransformation;

/* loaded from: classes2.dex */
public final class l81 extends LinearTransformation {

    /* renamed from: a */
    public final double f22384a;

    /* renamed from: b */
    public final double f22385b;

    /* renamed from: c */
    public LinearTransformation f22386c;

    public l81(double d, double d2) {
        this.f22384a = d;
        this.f22385b = d2;
        this.f22386c = null;
    }

    @Override // com.google.common.math.LinearTransformation
    public final LinearTransformation inverse() {
        LinearTransformation linearTransformation = this.f22386c;
        if (linearTransformation == null) {
            double d = this.f22384a;
            double d2 = this.f22385b;
            if (d != 0.0d) {
                linearTransformation = new l81(1.0d / d, (d2 * (-1.0d)) / d, this);
            } else {
                linearTransformation = new m81(d2, this);
            }
            this.f22386c = linearTransformation;
        }
        return linearTransformation;
    }

    @Override // com.google.common.math.LinearTransformation
    public final boolean isHorizontal() {
        if (this.f22384a == 0.0d) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.math.LinearTransformation
    public final boolean isVertical() {
        return false;
    }

    @Override // com.google.common.math.LinearTransformation
    public final double slope() {
        return this.f22384a;
    }

    public final String toString() {
        return String.format("y = %g * x + %g", Double.valueOf(this.f22384a), Double.valueOf(this.f22385b));
    }

    @Override // com.google.common.math.LinearTransformation
    public final double transform(double d) {
        return (d * this.f22384a) + this.f22385b;
    }

    public l81(double d, double d2, LinearTransformation linearTransformation) {
        this.f22384a = d;
        this.f22385b = d2;
        this.f22386c = linearTransformation;
    }
}
