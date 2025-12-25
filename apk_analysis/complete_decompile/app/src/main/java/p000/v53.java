package p000;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class v53 {

    /* renamed from: a */
    public final int f27656a;

    /* renamed from: b */
    public float f27657b;

    /* renamed from: c */
    public final Interpolator f27658c;

    /* renamed from: d */
    public final long f27659d;

    /* renamed from: e */
    public float f27660e;

    public v53(int i, Interpolator interpolator, long j) {
        this.f27656a = i;
        this.f27658c = interpolator;
        this.f27659d = j;
    }

    /* renamed from: a */
    public long mo959a() {
        return this.f27659d;
    }

    /* renamed from: b */
    public float mo960b() {
        return this.f27657b;
    }

    /* renamed from: c */
    public float mo961c() {
        Interpolator interpolator = this.f27658c;
        if (interpolator != null) {
            return interpolator.getInterpolation(this.f27657b);
        }
        return this.f27657b;
    }

    /* renamed from: d */
    public Interpolator mo962d() {
        return this.f27658c;
    }

    /* renamed from: e */
    public int mo963e() {
        return this.f27656a;
    }

    /* renamed from: f */
    public void mo964f(float f) {
        this.f27657b = f;
    }
}
