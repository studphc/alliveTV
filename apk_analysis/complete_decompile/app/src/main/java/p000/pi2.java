package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.single.SingleDelay;

/* loaded from: classes2.dex */
public final class pi2 implements SingleObserver {

    /* renamed from: a */
    public final SequentialDisposable f25190a;

    /* renamed from: b */
    public final SingleObserver f25191b;

    /* renamed from: c */
    public final /* synthetic */ SingleDelay f25192c;

    public pi2(SingleDelay singleDelay, SequentialDisposable sequentialDisposable, SingleObserver singleObserver) {
        this.f25192c = singleDelay;
        this.f25190a = sequentialDisposable;
        this.f25191b = singleObserver;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        long j;
        SingleDelay singleDelay = this.f25192c;
        Scheduler scheduler = singleDelay.f19724d;
        xy1 xy1Var = new xy1(17, this, th);
        if (singleDelay.f19725e) {
            j = singleDelay.f19722b;
        } else {
            j = 0;
        }
        this.f25190a.replace(scheduler.scheduleDirect(xy1Var, j, singleDelay.f19723c));
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        this.f25190a.replace(disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        SingleDelay singleDelay = this.f25192c;
        this.f25190a.replace(singleDelay.f19724d.scheduleDirect(new xy1(18, this, obj), singleDelay.f19722b, singleDelay.f19723c));
    }
}
