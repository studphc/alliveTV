package androidx.core.view;

import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.C0223s;
import androidx.core.view.WindowInsetsControllerCompat;
import p000.d63;
import p000.h63;

/* renamed from: androidx.core.view.s */
/* loaded from: classes.dex */
public final class C0223s extends AbstractC0224t {

    /* renamed from: a */
    public final WindowInsetsControllerCompat f4020a;

    /* renamed from: b */
    public final WindowInsetsController f4021b;

    /* renamed from: c */
    public final SoftwareKeyboardControllerCompat f4022c;

    /* renamed from: d */
    public final SimpleArrayMap f4023d = new SimpleArrayMap();

    /* renamed from: e */
    public Window f4024e;

    public C0223s(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
        this.f4021b = windowInsetsController;
        this.f4020a = windowInsetsControllerCompat;
        this.f4022c = softwareKeyboardControllerCompat;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [g63, java.lang.Object] */
    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: a */
    public final void mo999a(final WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        SimpleArrayMap simpleArrayMap = this.f4023d;
        if (simpleArrayMap.containsKey(onControllableInsetsChangedListener)) {
            return;
        }
        ?? r1 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: g63
            @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
            public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
                C0223s c0223s = C0223s.this;
                WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = onControllableInsetsChangedListener;
                if (c0223s.f4021b == windowInsetsController) {
                    onControllableInsetsChangedListener2.onControllableInsetsChanged(c0223s.f4020a, i);
                }
            }
        };
        simpleArrayMap.put(onControllableInsetsChangedListener, r1);
        this.f4021b.addOnControllableInsetsChangedListener(r1);
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: b */
    public final void mo1000b(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.f4021b.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, new h63(windowInsetsAnimationControlListenerCompat));
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: c */
    public final int mo1001c() {
        int systemBarsBehavior;
        systemBarsBehavior = this.f4021b.getSystemBarsBehavior();
        return systemBarsBehavior;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: d */
    public final void mo1002d(int i) {
        if ((i & 8) != 0) {
            this.f4022c.hide();
        }
        this.f4021b.hide(i & (-9));
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: e */
    public final boolean mo1008e() {
        int systemBarsAppearance;
        this.f4021b.setSystemBarsAppearance(0, 0);
        systemBarsAppearance = this.f4021b.getSystemBarsAppearance();
        if ((systemBarsAppearance & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: f */
    public final boolean mo1009f() {
        int systemBarsAppearance;
        this.f4021b.setSystemBarsAppearance(0, 0);
        systemBarsAppearance = this.f4021b.getSystemBarsAppearance();
        if ((systemBarsAppearance & 8) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: g */
    public final void mo1003g(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        WindowInsetsController.OnControllableInsetsChangedListener m4538c = d63.m4538c(this.f4023d.remove(onControllableInsetsChangedListener));
        if (m4538c != null) {
            this.f4021b.removeOnControllableInsetsChangedListener(m4538c);
        }
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: h */
    public final void mo1010h(boolean z) {
        Window window = this.f4024e;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f4021b.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f4021b.setSystemBarsAppearance(0, 16);
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: i */
    public final void mo1011i(boolean z) {
        Window window = this.f4024e;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f4021b.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f4021b.setSystemBarsAppearance(0, 8);
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: j */
    public final void mo1004j(int i) {
        this.f4021b.setSystemBarsBehavior(i);
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: k */
    public final void mo1005k(int i) {
        if ((i & 8) != 0) {
            this.f4022c.show();
        }
        this.f4021b.show(i & (-9));
    }
}
