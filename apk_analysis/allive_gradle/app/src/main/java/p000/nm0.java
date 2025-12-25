package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class nm0 extends lm0 {
    private static final long serialVersionUID = -6022804456014692607L;

    /* renamed from: d */
    public final Subscriber f23402d;

    public nm0(Subscriber subscriber, Iterator it) {
        super(it);
        this.f23402d = subscriber;
    }

    @Override // p000.lm0
    /* renamed from: a */
    public final void mo5956a() {
        Iterator it = this.f22562a;
        Subscriber subscriber = this.f23402d;
        while (!this.f22563b) {
            try {
                Object next = it.next();
                if (this.f22563b) {
                    return;
                }
                if (next == null) {
                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                }
                subscriber.onNext(next);
                if (this.f22563b) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        if (!this.f22563b) {
                            subscriber.onComplete();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscriber.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscriber.onError(th2);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0058, code lost:
    
        r9 = addAndGet(-r4);
     */
    @Override // p000.lm0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo5957e(long j) {
        Iterator it = this.f22562a;
        Subscriber subscriber = this.f23402d;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j) {
                    if (this.f22563b) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        if (this.f22563b) {
                            return;
                        }
                        if (next == null) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(next);
                        if (this.f22563b) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!this.f22563b) {
                                    subscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            subscriber.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        subscriber.onError(th2);
                        return;
                    }
                } else {
                    j = get();
                    if (j2 == j) {
                        break;
                    }
                }
            }
        } while (j != 0);
    }
}
