package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class mm0 extends lm0 {
    private static final long serialVersionUID = -6022804456014692607L;

    /* renamed from: d */
    public final ConditionalSubscriber f22984d;

    public mm0(ConditionalSubscriber conditionalSubscriber, Iterator it) {
        super(it);
        this.f22984d = conditionalSubscriber;
    }

    @Override // p000.lm0
    /* renamed from: a */
    public final void mo5956a() {
        Iterator it = this.f22562a;
        ConditionalSubscriber conditionalSubscriber = this.f22984d;
        while (!this.f22563b) {
            try {
                Object next = it.next();
                if (this.f22563b) {
                    return;
                }
                if (next == null) {
                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                }
                conditionalSubscriber.tryOnNext(next);
                if (this.f22563b) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        if (!this.f22563b) {
                            conditionalSubscriber.onComplete();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    conditionalSubscriber.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                conditionalSubscriber.onError(th2);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005b, code lost:
    
        r9 = addAndGet(-r4);
     */
    @Override // p000.lm0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo5957e(long j) {
        Iterator it = this.f22562a;
        ConditionalSubscriber conditionalSubscriber = this.f22984d;
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
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        boolean tryOnNext = conditionalSubscriber.tryOnNext(next);
                        if (this.f22563b) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!this.f22563b) {
                                    conditionalSubscriber.onComplete();
                                    return;
                                }
                                return;
                            } else if (tryOnNext) {
                                j2++;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            conditionalSubscriber.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        conditionalSubscriber.onError(th2);
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
