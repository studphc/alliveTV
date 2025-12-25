package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class rm0 extends pm0 {
    private static final long serialVersionUID = -9082954702547571853L;

    /* renamed from: e */
    public final Subscriber f26025e;

    public rm0(Subscriber subscriber, Iterator it, AutoCloseable autoCloseable) {
        super(it, autoCloseable);
        this.f26025e = subscriber;
    }

    @Override // p000.pm0
    /* renamed from: a */
    public final void mo6918a(long j) {
        Iterator it = this.f25222a;
        Subscriber subscriber = this.f26025e;
        long j2 = 0;
        while (!this.f25224c) {
            try {
                Object next = it.next();
                Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                subscriber.onNext(next);
                if (this.f25224c) {
                    continue;
                } else {
                    try {
                        if (!it.hasNext()) {
                            subscriber.onComplete();
                            this.f25224c = true;
                        } else {
                            j2++;
                            if (j2 != j) {
                                continue;
                            } else {
                                j = get();
                                if (j2 != j) {
                                    continue;
                                } else if (compareAndSet(j, 0L)) {
                                    return;
                                } else {
                                    j = get();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        subscriber.onError(th);
                        this.f25224c = true;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscriber.onError(th2);
                this.f25224c = true;
            }
        }
        clear();
    }
}
