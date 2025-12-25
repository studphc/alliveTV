package androidx.core.view;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import p000.p12;
import p000.u53;
import p000.v53;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {

    /* renamed from: a */
    public v53 f3935a;

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;

        /* renamed from: a */
        public WindowInsets f3938a;

        /* renamed from: b */
        public final int f3939b;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes.dex */
        public @interface DispatchMode {
        }

        public Callback(int i) {
            this.f3939b = i;
        }

        public final int getDispatchMode() {
            return this.f3939b;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    public WindowInsetsAnimationCompat(int i, @Nullable Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3935a = new C0215k(u53.m7553i(i, interpolator, j));
        } else {
            this.f3935a = new v53(i, interpolator, j);
        }
    }

    @FloatRange(from = 0.0d, m152to = 1.0d)
    public float getAlpha() {
        return this.f3935a.f27660e;
    }

    public long getDurationMillis() {
        return this.f3935a.mo959a();
    }

    @FloatRange(from = 0.0d, m152to = 1.0d)
    public float getFraction() {
        return this.f3935a.mo960b();
    }

    public float getInterpolatedFraction() {
        return this.f3935a.mo961c();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.f3935a.mo962d();
    }

    public int getTypeMask() {
        return this.f3935a.mo963e();
    }

    public void setAlpha(@FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        this.f3935a.f27660e = f;
    }

    public void setFraction(@FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        this.f3935a.mo964f(f);
    }

    /* loaded from: classes.dex */
    public static final class BoundsCompat {

        /* renamed from: a */
        public final Insets f3936a;

        /* renamed from: b */
        public final Insets f3937b;

        public BoundsCompat(@NonNull Insets insets, @NonNull Insets insets2) {
            this.f3936a = insets;
            this.f3937b = insets2;
        }

        @NonNull
        @RequiresApi(30)
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        @NonNull
        public Insets getLowerBound() {
            return this.f3936a;
        }

        @NonNull
        public Insets getUpperBound() {
            return this.f3937b;
        }

        @NonNull
        public BoundsCompat inset(@NonNull Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.m918a(this.f3936a, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.m918a(this.f3937b, insets.left, insets.top, insets.right, insets.bottom));
        }

        @NonNull
        @RequiresApi(30)
        public WindowInsetsAnimation.Bounds toBounds() {
            p12.m6792t();
            return p12.m6786n(getLowerBound().toPlatformInsets(), getUpperBound().toPlatformInsets());
        }

        public String toString() {
            return "Bounds{lower=" + this.f3936a + " upper=" + this.f3937b + "}";
        }

        public BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            android.graphics.Insets lowerBound;
            android.graphics.Insets upperBound;
            lowerBound = bounds.getLowerBound();
            this.f3936a = Insets.toCompatInsets(lowerBound);
            upperBound = bounds.getUpperBound();
            this.f3937b = Insets.toCompatInsets(upperBound);
        }
    }
}
