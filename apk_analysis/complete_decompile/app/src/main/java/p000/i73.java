package p000;

import com.google.android.gms.common.api.internal.zaaw;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public abstract class i73 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ zaaw f18331a;

    public /* synthetic */ i73(zaaw zaawVar) {
        this.f18331a = zaawVar;
    }

    /* renamed from: a */
    public abstract void mo4668a();

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.f18331a;
        Lock lock = zaawVar.f13196b;
        Lock lock2 = zaawVar.f13196b;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    mo4668a();
                }
            } catch (RuntimeException e) {
                p73 p73Var = zaawVar.f13195a.f13246e;
                p73Var.sendMessage(p73Var.obtainMessage(2, e));
            }
        } finally {
            lock2.unlock();
        }
    }
}
