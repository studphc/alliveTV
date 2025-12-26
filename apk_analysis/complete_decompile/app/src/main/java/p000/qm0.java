package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class qm0 extends pm0 {
    private static final long serialVersionUID = -9082954702547571853L;

    /* renamed from: e */
    public final ConditionalSubscriber f25685e;

    public qm0(ConditionalSubscriber conditionalSubscriber, Iterator it, AutoCloseable autoCloseable) {
        super(it, autoCloseable);
        this.f25685e = conditionalSubscriber;
    }

    @Override // p000.pm0
    /* renamed from: a */
    public final void mo6918a(long j) {
        Iterator it = this.f25222a;
        ConditionalSubscriber conditionalSubscriber = this.f25685e;
        long j2 = 0;
        while (!this.f25224c) {
            try {
                Object next = it.next();
                Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                if (conditionalSubscriber.tryOnNext(next)) {
                    j2++;
                }
                if (this.f25224c) {
                    continue;
                } else {
                    try {
                        if (!it.hasNext()) {
                            conditionalSubscriber.onComplete();
                            this.f25224c = true;
                        } else if (j2 != j) {
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
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        conditionalSubscriber.onError(th);
                        this.f25224c = true;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                conditionalSubscriber.onError(th2);
                this.f25224c = true;
            }
        }
        clear();
    }
}
