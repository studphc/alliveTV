package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import p000.k32;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return k32.m5498c(path);
    }

    @NonNull
    public static Interpolator create(float f, float f2) {
        return k32.m5496a(f, f2);
    }

    @NonNull
    public static Interpolator create(float f, float f2, float f3, float f4) {
        return k32.m5497b(f, f2, f3, f4);
    }
}
