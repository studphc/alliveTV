package p000;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class k32 {
    @DoNotInline
    /* renamed from: a */
    public static Interpolator m5496a(float f, float f2) {
        return new PathInterpolator(f, f2);
    }

    @DoNotInline
    /* renamed from: b */
    public static Interpolator m5497b(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }

    @DoNotInline
    /* renamed from: c */
    public static Interpolator m5498c(Path path) {
        return new PathInterpolator(path);
    }
}
