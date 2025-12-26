package p000;

import androidx.constraintlayout.core.motion.utils.CurveFit;

/* renamed from: bx */
/* loaded from: classes.dex */
public final class C0573bx extends CurveFit {

    /* renamed from: a */
    public double f8171a;

    /* renamed from: b */
    public double[] f8172b;

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void getPos(double d, double[] dArr) {
        double[] dArr2 = this.f8172b;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void getSlope(double d, double[] dArr) {
        for (int i = 0; i < this.f8172b.length; i++) {
            dArr[i] = 0.0d;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] getTimePoints() {
        return new double[]{this.f8171a};
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void getPos(double d, float[] fArr) {
        int i = 0;
        while (true) {
            double[] dArr = this.f8172b;
            if (i >= dArr.length) {
                return;
            }
            fArr[i] = (float) dArr[i];
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double getSlope(double d, int i) {
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double getPos(double d, int i) {
        return this.f8172b[i];
    }
}
