package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p000.d63;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;

    /* renamed from: a */
    public final AbstractC0224t f3943a;

    /* loaded from: classes.dex */
    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i);
    }

    public WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        this.f3943a = new C0223s(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    @NonNull
    @RequiresApi(30)
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f3943a.mo999a(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i, long j, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.f3943a.mo1000b(i, j, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.f3943a.mo1001c();
    }

    public void hide(int i) {
        this.f3943a.mo1002d(i);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.f3943a.mo1008e();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.f3943a.mo1009f();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f3943a.mo1003g(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z) {
        this.f3943a.mo1010h(z);
    }

    public void setAppearanceLightStatusBars(boolean z) {
        this.f3943a.mo1011i(z);
    }

    public void setSystemBarsBehavior(int i) {
        this.f3943a.mo1004j(i);
    }

    public void show(int i) {
        this.f3943a.mo1005k(i);
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            C0223s c0223s = new C0223s(d63.m4539d(window), this, softwareKeyboardControllerCompat);
            c0223s.f4024e = window;
            this.f3943a = c0223s;
        } else if (i >= 26) {
            this.f3943a = new AbstractC0222r(window, softwareKeyboardControllerCompat);
        } else {
            this.f3943a = new AbstractC0222r(window, softwareKeyboardControllerCompat);
        }
    }
}
