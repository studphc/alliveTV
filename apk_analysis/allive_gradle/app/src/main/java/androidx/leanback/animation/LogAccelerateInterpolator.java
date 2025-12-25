package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class LogAccelerateInterpolator implements TimeInterpolator {

    /* renamed from: a */
    public final int f4716a;

    /* renamed from: b */
    public final int f4717b;

    /* renamed from: c */
    public final float f4718c;

    public LogAccelerateInterpolator(int i, int i2) {
        this.f4716a = i;
        this.f4717b = i2;
        this.f4718c = 1.0f / ((i2 * 1.0f) + (((float) (-Math.pow(i, -1.0f))) + 1.0f));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return 1.0f - (((this.f4717b * (1.0f - f)) + (((float) (-Math.pow(this.f4716a, -r8))) + 1.0f)) * this.f4718c);
    }
}
