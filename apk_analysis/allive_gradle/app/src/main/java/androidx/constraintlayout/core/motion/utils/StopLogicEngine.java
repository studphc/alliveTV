package androidx.constraintlayout.core.motion.utils;

import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {

    /* renamed from: a */
    public float f2225a;

    /* renamed from: b */
    public float f2226b;

    /* renamed from: c */
    public float f2227c;

    /* renamed from: d */
    public float f2228d;

    /* renamed from: e */
    public float f2229e;

    /* renamed from: f */
    public float f2230f;

    /* renamed from: g */
    public float f2231g;

    /* renamed from: h */
    public float f2232h;

    /* renamed from: i */
    public float f2233i;

    /* renamed from: j */
    public int f2234j;

    /* renamed from: k */
    public String f2235k;

    /* renamed from: l */
    public boolean f2236l = false;

    /* renamed from: m */
    public float f2237m;

    /* renamed from: n */
    public float f2238n;

    /* renamed from: o */
    public float f2239o;

    /* renamed from: a */
    public final void m446a(float f, float f2, float f3, float f4, float f5) {
        this.f2233i = f2;
        if (f == RecyclerView.f7068F0) {
            f = 1.0E-4f;
        }
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < RecyclerView.f7068F0) {
            float sqrt = (float) Math.sqrt((f2 - ((((-f) / f3) * f) / 2.0f)) * f3);
            if (sqrt < f4) {
                this.f2235k = "backward accelerate, decelerate";
                this.f2234j = 2;
                this.f2225a = f;
                this.f2226b = sqrt;
                this.f2227c = RecyclerView.f7068F0;
                float f8 = (sqrt - f) / f3;
                this.f2228d = f8;
                this.f2229e = sqrt / f3;
                this.f2231g = ((f + sqrt) * f8) / 2.0f;
                this.f2232h = f2;
                this.f2233i = f2;
                return;
            }
            this.f2235k = "backward accelerate cruse decelerate";
            this.f2234j = 3;
            this.f2225a = f;
            this.f2226b = f4;
            this.f2227c = f4;
            float f9 = (f4 - f) / f3;
            this.f2228d = f9;
            float f10 = f4 / f3;
            this.f2230f = f10;
            float f11 = ((f + f4) * f9) / 2.0f;
            float f12 = (f10 * f4) / 2.0f;
            this.f2229e = ((f2 - f11) - f12) / f4;
            this.f2231g = f11;
            this.f2232h = f2 - f12;
            this.f2233i = f2;
            return;
        }
        if (f7 >= f2) {
            this.f2235k = "hard stop";
            this.f2234j = 1;
            this.f2225a = f;
            this.f2226b = RecyclerView.f7068F0;
            this.f2231g = f2;
            this.f2228d = (2.0f * f2) / f;
            return;
        }
        float f13 = f2 - f7;
        float f14 = f13 / f;
        if (f14 + f6 < f5) {
            this.f2235k = "cruse decelerate";
            this.f2234j = 2;
            this.f2225a = f;
            this.f2226b = f;
            this.f2227c = RecyclerView.f7068F0;
            this.f2231g = f13;
            this.f2232h = f2;
            this.f2228d = f14;
            this.f2229e = f6;
            return;
        }
        float sqrt2 = (float) Math.sqrt(((f * f) / 2.0f) + (f3 * f2));
        float f15 = (sqrt2 - f) / f3;
        this.f2228d = f15;
        float f16 = sqrt2 / f3;
        this.f2229e = f16;
        if (sqrt2 < f4) {
            this.f2235k = "accelerate decelerate";
            this.f2234j = 2;
            this.f2225a = f;
            this.f2226b = sqrt2;
            this.f2227c = RecyclerView.f7068F0;
            this.f2228d = f15;
            this.f2229e = f16;
            this.f2231g = ((f + sqrt2) * f15) / 2.0f;
            this.f2232h = f2;
            return;
        }
        this.f2235k = "accelerate cruse decelerate";
        this.f2234j = 3;
        this.f2225a = f;
        this.f2226b = f4;
        this.f2227c = f4;
        float f17 = (f4 - f) / f3;
        this.f2228d = f17;
        float f18 = f4 / f3;
        this.f2230f = f18;
        float f19 = ((f + f4) * f17) / 2.0f;
        float f20 = (f18 * f4) / 2.0f;
        this.f2229e = ((f2 - f19) - f20) / f4;
        this.f2231g = f19;
        this.f2232h = f2 - f20;
        this.f2233i = f2;
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        this.f2237m = f;
        if (f > f2) {
            z = true;
        } else {
            z = false;
        }
        this.f2236l = z;
        if (z) {
            m446a(-f3, f - f2, f5, f6, f4);
        } else {
            m446a(f3, f2 - f, f5, f6, f4);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        String str2;
        StringBuilder m8303w = ye0.m8303w(AbstractC1726qj.m7061q(ye0.m8303w(str, " ===== "), this.f2235k, "\n"), str);
        if (this.f2236l) {
            str2 = "backwards";
        } else {
            str2 = "forward ";
        }
        m8303w.append(str2);
        m8303w.append(" time = ");
        m8303w.append(f);
        m8303w.append("  stages ");
        String str3 = ye0.m8298r(m8303w, "\n", this.f2234j) + str + " dur " + this.f2228d + " vel " + this.f2225a + " pos " + this.f2231g + "\n";
        if (this.f2234j > 1) {
            str3 = str3 + str + " dur " + this.f2229e + " vel " + this.f2226b + " pos " + this.f2232h + "\n";
        }
        if (this.f2234j > 2) {
            str3 = str3 + str + " dur " + this.f2230f + " vel " + this.f2227c + " pos " + this.f2233i + "\n";
        }
        float f2 = this.f2228d;
        if (f <= f2) {
            return AbstractC1726qj.m7058n(str3, str, "stage 0\n");
        }
        int i = this.f2234j;
        if (i == 1) {
            return AbstractC1726qj.m7058n(str3, str, "end stage 0\n");
        }
        float f3 = f - f2;
        float f4 = this.f2229e;
        if (f3 < f4) {
            return AbstractC1726qj.m7058n(str3, str, " stage 1\n");
        }
        if (i == 2) {
            return AbstractC1726qj.m7058n(str3, str, "end stage 1\n");
        }
        if (f3 - f4 < this.f2230f) {
            return AbstractC1726qj.m7058n(str3, str, " stage 2\n");
        }
        return AbstractC1726qj.m7058n(str3, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        float f2;
        float f3 = this.f2228d;
        if (f <= f3) {
            float f4 = this.f2225a;
            f2 = ((((this.f2226b - f4) * f) * f) / (f3 * 2.0f)) + (f4 * f);
        } else {
            int i = this.f2234j;
            if (i == 1) {
                f2 = this.f2231g;
            } else {
                float f5 = f - f3;
                float f6 = this.f2229e;
                if (f5 < f6) {
                    float f7 = this.f2231g;
                    float f8 = this.f2226b;
                    f2 = ((((this.f2227c - f8) * f5) * f5) / (f6 * 2.0f)) + (f8 * f5) + f7;
                } else if (i == 2) {
                    f2 = this.f2232h;
                } else {
                    float f9 = f5 - f6;
                    float f10 = this.f2230f;
                    if (f9 <= f10) {
                        float f11 = this.f2232h;
                        float f12 = this.f2227c * f9;
                        f2 = (f11 + f12) - ((f12 * f9) / (f10 * 2.0f));
                    } else {
                        f2 = this.f2233i;
                    }
                }
            }
        }
        this.f2238n = f2;
        this.f2239o = f;
        if (this.f2236l) {
            return this.f2237m - f2;
        }
        return this.f2237m + f2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        float f2;
        float f3;
        float f4 = this.f2228d;
        if (f <= f4) {
            f2 = this.f2225a;
            f3 = this.f2226b;
        } else {
            int i = this.f2234j;
            if (i == 1) {
                return RecyclerView.f7068F0;
            }
            f -= f4;
            f4 = this.f2229e;
            if (f >= f4) {
                if (i == 2) {
                    return RecyclerView.f7068F0;
                }
                float f5 = f - f4;
                float f6 = this.f2230f;
                if (f5 >= f6) {
                    return RecyclerView.f7068F0;
                }
                float f7 = this.f2227c;
                return f7 - ((f5 * f7) / f6);
            }
            f2 = this.f2226b;
            f3 = this.f2227c;
        }
        return (((f3 - f2) * f) / f4) + f2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        if (getVelocity() < 1.0E-5f && Math.abs(this.f2233i - this.f2238n) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class Decelerate implements StopEngine {

        /* renamed from: a */
        public float f2240a;

        /* renamed from: b */
        public float f2241b;

        /* renamed from: c */
        public float f2242c;

        /* renamed from: d */
        public float f2243d;

        /* renamed from: e */
        public float f2244e;

        /* renamed from: f */
        public float f2245f;

        /* renamed from: g */
        public boolean f2246g = false;

        public void config(float f, float f2, float f3) {
            this.f2246g = false;
            this.f2240a = f2;
            this.f2241b = f3;
            this.f2245f = f;
            float f4 = (f2 - f) / (f3 / 2.0f);
            this.f2244e = f4;
            this.f2242c = (-f3) / f4;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public String debug(String str, float f) {
            return this.f2244e + " " + this.f2243d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getInterpolation(float f) {
            if (f > this.f2244e) {
                this.f2246g = true;
                return this.f2240a;
            }
            getVelocity(f);
            return ((((this.f2242c * f) / 2.0f) + this.f2241b) * f) + this.f2245f;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity(float f) {
            if (f > this.f2244e) {
                return RecyclerView.f7068F0;
            }
            float f2 = (this.f2242c * f) + this.f2241b;
            this.f2243d = f2;
            return f2;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public boolean isStopped() {
            return this.f2246g;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity() {
            return this.f2243d;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.f2236l ? -getVelocity(this.f2239o) : getVelocity(this.f2239o);
    }
}
