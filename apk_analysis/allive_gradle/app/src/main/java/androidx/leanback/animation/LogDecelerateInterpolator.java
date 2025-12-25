package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class LogDecelerateInterpolator implements TimeInterpolator {

    /* renamed from: a */
    public final int f4719a;

    /* renamed from: b */
    public final int f4720b;

    /* renamed from: c */
    public final float f4721c;

    public LogDecelerateInterpolator(int i, int i2) {
        this.f4719a = i;
        this.f4720b = i2;
        this.f4721c = 1.0f / ((i2 * 1.0f) + (((float) (-Math.pow(i, -1.0f))) + 1.0f));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return ((this.f4720b * f) + ((float) (-Math.pow(this.f4719a, -f))) + 1.0f) * this.f4721c;
    }
}
