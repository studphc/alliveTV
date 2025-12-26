package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.a63;
import p000.b63;
import p000.c63;
import p000.w53;
import p000.y53;
import p000.ye0;
import p000.z53;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    @NonNull
    public static final WindowInsetsCompat CONSUMED;

    /* renamed from: a */
    public final C0220p f3941a;

    /* loaded from: classes.dex */
    public static final class Type {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes.dex */
        public @interface InsetsType {
        }

        /* renamed from: a */
        public static int m919a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return 1;
                }
                if (i == 4) {
                    return 2;
                }
                if (i != 8) {
                    if (i == 16) {
                        return 4;
                    }
                    if (i != 32) {
                        if (i != 64) {
                            if (i != 128) {
                                if (i == 256) {
                                    return 8;
                                }
                                throw new IllegalArgumentException(ye0.m8291k(i, "type needs to be >= FIRST and <= LAST, type="));
                            }
                            return 7;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 0;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = C0219o.f4015q;
        } else {
            CONSUMED = C0220p.f4016b;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f3941a = new C0219o(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.f3941a = new c63(this, windowInsets);
        } else if (i >= 28) {
            this.f3941a = new b63(this, windowInsets);
        } else {
            this.f3941a = new a63(this, windowInsets);
        }
    }

    /* renamed from: a */
    public static Insets m918a(Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.left - i);
        int max2 = Math.max(0, insets.top - i2);
        int max3 = Math.max(0, insets.right - i3);
        int max4 = Math.max(0, insets.bottom - i4);
        if (max == i && max2 == i2 && max3 == i3 && max4 == i4) {
            return insets;
        }
        return Insets.m828of(max, max2, max3, max4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.f3941a.mo993a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.f3941a.mo28b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.f3941a.mo29c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.f3941a, ((WindowInsetsCompat) obj).f3941a);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.f3941a.mo994f();
    }

    @NonNull
    public Insets getInsets(int i) {
        return this.f3941a.mo982g(i);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        return this.f3941a.mo983h(i);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.f3941a.mo995i();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.f3941a.mo30j().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.f3941a.mo30j().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.f3941a.mo30j().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.f3941a.mo30j().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.f3941a.mo30j();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.f3941a.mo996k();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.f3941a.mo984l().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.f3941a.mo984l().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.f3941a.mo984l().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.f3941a.mo984l().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.f3941a.mo984l();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.f3941a.mo997m();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(-1);
        Insets insets2 = Insets.NONE;
        if (insets.equals(insets2) && getInsetsIgnoringVisibility((-1) ^ Type.ime()).equals(insets2) && getDisplayCutout() == null) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.f3941a.mo30j().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.f3941a.mo984l().equals(Insets.NONE);
    }

    public int hashCode() {
        C0220p c0220p = this.f3941a;
        if (c0220p == null) {
            return 0;
        }
        return c0220p.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.f3941a.mo31o();
    }

    public boolean isRound() {
        return this.f3941a.mo986p();
    }

    public boolean isVisible(int i) {
        return this.f3941a.mo987q(i);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new Builder(this).setSystemWindowInsets(Insets.m828of(i, i2, i3, i4)).build();
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        C0220p c0220p = this.f3941a;
        if (c0220p instanceof C0218n) {
            return ((C0218n) c0220p).f4010c;
        }
        return null;
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            C0220p c0220p = windowInsetsCompat.f3941a;
            c0220p.mo990t(rootWindowInsets);
            c0220p.mo980d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        return this.f3941a.mo985n(i, i2, i3, i4);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.m829of(rect)).build();
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final AbstractC0217m f3942a;

        public Builder() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.f3942a = new z53();
            } else if (i >= 29) {
                this.f3942a = new y53();
            } else {
                this.f3942a = new w53();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.f3942a.mo966b();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f3942a.mo967c(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i, @NonNull Insets insets) {
            this.f3942a.mo968d(i, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
            this.f3942a.mo969e(i, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.f3942a.mo970f(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.f3942a.mo971g(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.f3942a.mo972h(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.f3942a.mo973i(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.f3942a.mo974j(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i, boolean z) {
            this.f3942a.mo975k(i, z);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.f3942a = new z53(windowInsetsCompat);
            } else if (i >= 29) {
                this.f3942a = new y53(windowInsetsCompat);
            } else {
                this.f3942a = new w53(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            C0220p c0220p = windowInsetsCompat.f3941a;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && (c0220p instanceof C0219o)) {
                this.f3941a = new C0219o(this, (C0219o) c0220p);
            } else if (i >= 29 && (c0220p instanceof c63)) {
                this.f3941a = new c63(this, (c63) c0220p);
            } else if (i >= 28 && (c0220p instanceof b63)) {
                this.f3941a = new b63(this, (b63) c0220p);
            } else if (c0220p instanceof a63) {
                this.f3941a = new a63(this, (a63) c0220p);
            } else if (c0220p instanceof C0218n) {
                this.f3941a = new C0218n(this, (C0218n) c0220p);
            } else {
                this.f3941a = new C0220p(this);
            }
            c0220p.mo981e(this);
            return;
        }
        this.f3941a = new C0220p(this);
    }
}
