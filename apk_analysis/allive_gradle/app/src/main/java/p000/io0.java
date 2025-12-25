package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class io0 extends AbstractC1214g {
    private static final long serialVersionUID = 8255923705960622424L;

    /* renamed from: h */
    public final BiFunction f20165h;

    /* renamed from: i */
    public final Supplier f20166i;

    public io0(Subscriber subscriber, Supplier supplier, BiFunction biFunction) {
        super(subscriber);
        this.f20165h = biFunction;
        this.f20166i = supplier;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        AtomicReference atomicReference = this.f17500g;
        Object obj2 = atomicReference.get();
        if (obj2 != null) {
            obj2 = atomicReference.getAndSet(null);
        }
        BiFunction biFunction = this.f20165h;
        try {
            if (obj2 == null) {
                Object obj3 = this.f20166i.get();
                Objects.requireNonNull(obj3, "The supplier returned a null value");
                Object apply = biFunction.apply(obj3, obj);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                atomicReference.lazySet(apply);
            } else {
                Object apply2 = biFunction.apply(obj2, obj);
                Objects.requireNonNull(apply2, "The reducer returned a null value");
                atomicReference.lazySet(apply2);
            }
            m4894b();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f17495b.cancel();
            onError(th);
        }
    }
}
