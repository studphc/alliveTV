package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

/* loaded from: classes2.dex */
public final class nv1 extends BasicFuseableObserver {

    /* renamed from: a */
    public final /* synthetic */ int f23505a;

    /* renamed from: b */
    public final Object f23506b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nv1(Observer observer, Object obj, int i) {
        super(observer);
        this.f23505a = i;
        this.f23506b = obj;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f23505a) {
            case 0:
                this.downstream.onNext(obj);
                if (this.sourceMode == 0) {
                    try {
                        ((Consumer) this.f23506b).accept(obj);
                        return;
                    } catch (Throwable th) {
                        fail(th);
                        return;
                    }
                }
                return;
            default:
                if (this.sourceMode == 0) {
                    try {
                        if (((Predicate) this.f23506b).test(obj)) {
                            this.downstream.onNext(obj);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        fail(th2);
                        return;
                    }
                }
                this.downstream.onNext(null);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll;
        switch (this.f23505a) {
            case 0:
                Object poll2 = this.f18587qd.poll();
                if (poll2 != null) {
                    ((Consumer) this.f23506b).accept(poll2);
                }
                return poll2;
        }
        do {
            poll = this.f18587qd.poll();
            if (poll != null) {
            }
            return poll;
        } while (!((Predicate) this.f23506b).test(poll));
        return poll;
    }
}
