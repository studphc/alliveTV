package p000;

import java.util.Collection;

/* loaded from: classes2.dex */
public final class yt1 implements Runnable {

    /* renamed from: a */
    public final Collection f29130a;

    /* renamed from: b */
    public final /* synthetic */ zt1 f29131b;

    public yt1(zt1 zt1Var, Collection collection) {
        this.f29131b = zt1Var;
        this.f29130a = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f29131b) {
            this.f29131b.f29519l.remove(this.f29130a);
        }
        zt1 zt1Var = this.f29131b;
        zt1Var.fastPathOrderedEmit(this.f29130a, false, zt1Var.f29518k);
    }
}
