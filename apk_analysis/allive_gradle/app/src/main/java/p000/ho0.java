package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ho0 extends AbstractC1214g {
    private static final long serialVersionUID = 821363947659780367L;

    /* renamed from: h */
    public final BiFunction f18110h;

    public ho0(Subscriber subscriber, BiFunction biFunction) {
        super(subscriber);
        this.f18110h = biFunction;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        AtomicReference atomicReference = this.f17500g;
        Object obj2 = atomicReference.get();
        if (obj2 != null) {
            obj2 = atomicReference.getAndSet(null);
        }
        if (obj2 == null) {
            atomicReference.lazySet(obj);
        } else {
            try {
                Object apply = this.f18110h.apply(obj2, obj);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                atomicReference.lazySet(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f17495b.cancel();
                onError(th);
                return;
            }
        }
        m4894b();
    }
}
