package androidx.core.view;

import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsControllerCompat;

/* renamed from: androidx.core.view.r */
/* loaded from: classes.dex */
public abstract class AbstractC0222r extends AbstractC0224t {

    /* renamed from: a */
    public final Window f4018a;

    /* renamed from: b */
    public final SoftwareKeyboardControllerCompat f4019b;

    public AbstractC0222r(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
        this.f4018a = window;
        this.f4019b = softwareKeyboardControllerCompat;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: a */
    public final void mo999a(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: b */
    public final void mo1000b(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: c */
    public final int mo1001c() {
        return 0;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: d */
    public final void mo1002d(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 8) {
                            this.f4019b.hide();
                        }
                    } else {
                        m1006l(2);
                    }
                } else {
                    m1006l(4);
                }
            }
        }
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: g */
    public final void mo1003g(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: j */
    public final void mo1004j(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    m1007m(2048);
                    m1006l(4096);
                    return;
                }
                return;
            }
            m1007m(4096);
            m1006l(2048);
            return;
        }
        m1007m(6144);
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: k */
    public final void mo1005k(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 8) {
                            this.f4019b.show();
                        }
                    } else {
                        m1007m(2);
                    }
                } else {
                    m1007m(4);
                    this.f4018a.clearFlags(1024);
                }
            }
        }
    }

    /* renamed from: l */
    public final void m1006l(int i) {
        View decorView = this.f4018a.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    /* renamed from: m */
    public final void m1007m(int i) {
        View decorView = this.f4018a.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
