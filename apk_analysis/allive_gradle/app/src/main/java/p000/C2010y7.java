package p000;

import android.graphics.drawable.Animatable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* renamed from: y7 */
/* loaded from: classes.dex */
public final class C2010y7 extends yy2 {

    /* renamed from: p */
    public final /* synthetic */ int f28852p;

    /* renamed from: q */
    public final Animatable f28853q;

    public /* synthetic */ C2010y7(Animatable animatable, int i) {
        this.f28852p = i;
        this.f28853q = animatable;
    }

    @Override // p000.yy2
    /* renamed from: N */
    public final void mo35N() {
        switch (this.f28852p) {
            case 0:
                this.f28853q.start();
                return;
            default:
                ((AnimatedVectorDrawableCompat) this.f28853q).start();
                return;
        }
    }

    @Override // p000.yy2
    /* renamed from: O */
    public final void mo36O() {
        switch (this.f28852p) {
            case 0:
                this.f28853q.stop();
                return;
            default:
                ((AnimatedVectorDrawableCompat) this.f28853q).stop();
                return;
        }
    }
}
