package p000;

import java.util.Collection;

/* loaded from: classes2.dex */
public final class dj0 implements Runnable {

    /* renamed from: a */
    public final Collection f16383a;

    /* renamed from: b */
    public final /* synthetic */ ej0 f16384b;

    public dj0(ej0 ej0Var, Collection collection) {
        this.f16384b = ej0Var;
        this.f16383a = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16384b) {
            this.f16384b.f16843B.remove(this.f16383a);
        }
        ej0 ej0Var = this.f16384b;
        ej0Var.fastPathOrderedEmitMax(this.f16383a, false, ej0Var.f16842A);
    }
}
