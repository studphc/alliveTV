package p000;

import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class ie1 implements Interpolator {

    /* renamed from: a */
    public final float[] f18383a;

    /* renamed from: b */
    public final float f18384b;

    public ie1(float[] fArr) {
        this.f18383a = fArr;
        this.f18384b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= RecyclerView.f7068F0) {
            return RecyclerView.f7068F0;
        }
        float[] fArr = this.f18383a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f18384b;
        float f3 = (f - (min * f2)) / f2;
        float f4 = fArr[min];
        return AbstractC1726qj.m7051g(fArr[min + 1], f4, f3, f4);
    }
}
