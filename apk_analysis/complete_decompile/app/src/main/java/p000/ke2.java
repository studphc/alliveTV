package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;

/* loaded from: classes2.dex */
public final class ke2 extends me2 {

    /* renamed from: a */
    public final Runnable f20838a;

    public ke2(Runnable runnable) {
        this.f20838a = runnable;
    }

    @Override // p000.me2
    /* renamed from: a */
    public final Disposable mo5441a(Scheduler.Worker worker, CompletableObserver completableObserver) {
        return worker.schedule(new xy1(13, this.f20838a, completableObserver));
    }
}
