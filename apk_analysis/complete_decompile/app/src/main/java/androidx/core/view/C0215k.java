package androidx.core.view;

import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import p000.v53;

/* renamed from: androidx.core.view.k */
/* loaded from: classes.dex */
public final class C0215k extends v53 {

    /* renamed from: f */
    public final WindowInsetsAnimation f3998f;

    public C0215k(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f3998f = windowInsetsAnimation;
    }

    @Override // p000.v53
    /* renamed from: a */
    public final long mo959a() {
        long durationMillis;
        durationMillis = this.f3998f.getDurationMillis();
        return durationMillis;
    }

    @Override // p000.v53
    /* renamed from: b */
    public final float mo960b() {
        float fraction;
        fraction = this.f3998f.getFraction();
        return fraction;
    }

    @Override // p000.v53
    /* renamed from: c */
    public final float mo961c() {
        float interpolatedFraction;
        interpolatedFraction = this.f3998f.getInterpolatedFraction();
        return interpolatedFraction;
    }

    @Override // p000.v53
    /* renamed from: d */
    public final Interpolator mo962d() {
        Interpolator interpolator;
        interpolator = this.f3998f.getInterpolator();
        return interpolator;
    }

    @Override // p000.v53
    /* renamed from: e */
    public final int mo963e() {
        int typeMask;
        typeMask = this.f3998f.getTypeMask();
        return typeMask;
    }

    @Override // p000.v53
    /* renamed from: f */
    public final void mo964f(float f) {
        this.f3998f.setFraction(f);
    }
}
