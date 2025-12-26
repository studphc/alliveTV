package p000;

import java.util.Collection;

/* loaded from: classes2.dex */
public final class xt1 implements Runnable {

    /* renamed from: a */
    public final Collection f28731a;

    /* renamed from: b */
    public final /* synthetic */ zt1 f28732b;

    public xt1(zt1 zt1Var, Collection collection) {
        this.f28732b = zt1Var;
        this.f28731a = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f28732b) {
            this.f28732b.f29519l.remove(this.f28731a);
        }
        zt1 zt1Var = this.f28732b;
        zt1Var.fastPathOrderedEmit(this.f28731a, false, zt1Var.f29518k);
    }
}
