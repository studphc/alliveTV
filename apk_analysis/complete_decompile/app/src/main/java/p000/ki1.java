package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ki1 extends AtomicInteger implements Disposable {

    /* renamed from: a */
    public final SingleObserver f20859a;

    /* renamed from: b */
    public final li1 f20860b;

    /* renamed from: c */
    public final li1 f20861c;

    /* renamed from: d */
    public final BiPredicate f20862d;

    public ki1(SingleObserver singleObserver, BiPredicate biPredicate) {
        super(2);
        this.f20859a = singleObserver;
        this.f20862d = biPredicate;
        this.f20860b = new li1(this);
        this.f20861c = new li1(this);
    }

    /* renamed from: a */
    public final void m5559a() {
        boolean z;
        if (decrementAndGet() == 0) {
            Object obj = this.f20860b.f22512b;
            Object obj2 = this.f20861c.f22512b;
            SingleObserver singleObserver = this.f20859a;
            if (obj != null && obj2 != null) {
                try {
                    singleObserver.onSuccess(Boolean.valueOf(this.f20862d.test(obj, obj2)));
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleObserver.onError(th);
                    return;
                }
            }
            if (obj == null && obj2 == null) {
                z = true;
            } else {
                z = false;
            }
            singleObserver.onSuccess(Boolean.valueOf(z));
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        li1 li1Var = this.f20860b;
        li1Var.getClass();
        DisposableHelper.dispose(li1Var);
        li1 li1Var2 = this.f20861c;
        li1Var2.getClass();
        DisposableHelper.dispose(li1Var2);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f20860b.get());
    }
}
