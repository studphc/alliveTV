package p000;

import androidx.leanback.widget.ParallaxTarget;

/* loaded from: classes.dex */
public final class j20 extends ParallaxTarget {

    /* renamed from: a */
    public final /* synthetic */ m20 f20349a;

    public j20(m20 m20Var) {
        this.f20349a = m20Var;
    }

    @Override // androidx.leanback.widget.ParallaxTarget
    public final void update(float f) {
        m20 m20Var = this.f20349a;
        if (f == 1.0f) {
            if (2 != m20Var.f22772c) {
                m20Var.f22772c = 2;
                m20Var.m6008a();
                return;
            }
            return;
        }
        if (1 != m20Var.f22772c) {
            m20Var.f22772c = 1;
            m20Var.m6008a();
        }
    }
}
