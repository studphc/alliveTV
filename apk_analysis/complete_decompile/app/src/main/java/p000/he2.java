package p000;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;

/* loaded from: classes2.dex */
public final class he2 extends Completable {

    /* renamed from: a */
    public final me2 f18041a;

    /* renamed from: b */
    public final /* synthetic */ ie2 f18042b;

    public he2(ie2 ie2Var, me2 me2Var) {
        this.f18042b = ie2Var;
        this.f18041a = me2Var;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        ne2 ne2Var;
        me2 me2Var = this.f18041a;
        completableObserver.onSubscribe(me2Var);
        Scheduler.Worker worker = this.f18042b.f18385a;
        Disposable disposable = (Disposable) me2Var.get();
        if (disposable != SchedulerWhen.f19869g && disposable == (ne2Var = SchedulerWhen.f19868f)) {
            Disposable mo5441a = me2Var.mo5441a(worker, completableObserver);
            if (!me2Var.compareAndSet(ne2Var, mo5441a)) {
                mo5441a.dispose();
            }
        }
    }
}
