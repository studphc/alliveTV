package p000;

import com.hisona.allive.RxJobIntentService;
import io.reactivex.rxjava3.observers.DisposableObserver;

/* loaded from: classes2.dex */
public final class tt1 extends DisposableObserver {

    /* renamed from: b */
    public final /* synthetic */ int f26956b = 1;

    /* renamed from: c */
    public final Object f26957c;

    public tt1(ut1 ut1Var) {
        this.f26957c = ut1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f26956b) {
            case 0:
                ((ut1) this.f26957c).onComplete();
                return;
            default:
                ((C1540m9) this.f26957c).f22854b = null;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f26956b) {
            case 0:
                ((ut1) this.f26957c).onError(th);
                return;
            default:
                ((RxJobIntentService) ((C1540m9) this.f26957c).f22855c).m4468c();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f26956b) {
            case 0:
                ((ut1) this.f26957c).m7768S();
                return;
            default:
                ((RxJobIntentService) ((C1540m9) this.f26957c).f22855c).m4468c();
                return;
        }
    }

    public tt1(C1540m9 c1540m9) {
        this.f26957c = c1540m9;
    }
}
