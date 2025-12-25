package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class o22 extends n22 {
    private static final long serialVersionUID = -5737965195918321883L;

    @Override // p000.n22
    /* renamed from: c */
    public final void mo6010c() {
        if (getAndIncrement() != 0) {
            return;
        }
        m6408g();
    }

    @Override // p000.n22
    /* renamed from: d */
    public final void mo6011d() {
        this.f23206f.decrementAndGet();
        mo6010c();
    }

    @Override // p000.n22
    /* renamed from: e */
    public final void mo6012e(Throwable th) {
        if (this.f23203c.tryAddThrowableOrReport(th)) {
            this.f23206f.decrementAndGet();
            mo6010c();
        }
    }

    @Override // p000.n22
    /* renamed from: f */
    public final void mo6013f(l22 l22Var, Object obj) {
        int i = get();
        AtomicInteger atomicInteger = this.f23206f;
        AtomicThrowable atomicThrowable = this.f23203c;
        if (i == 0 && compareAndSet(0, 1)) {
            AtomicLong atomicLong = this.f23204d;
            if (atomicLong.get() != 0) {
                this.f23201a.onNext(obj);
                if (atomicLong.get() != Long.MAX_VALUE) {
                    atomicLong.decrementAndGet();
                }
                long j = l22Var.f22306d + 1;
                if (j >= l22Var.f22305c) {
                    l22Var.f22306d = 0L;
                    ((Subscription) l22Var.get()).request(j);
                } else {
                    l22Var.f22306d = j;
                }
            } else if (!l22Var.m5817a().offer(obj)) {
                SubscriptionHelper.cancel(l22Var);
                atomicThrowable.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                atomicInteger.decrementAndGet();
                m6408g();
                return;
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            if (!l22Var.m5817a().offer(obj)) {
                SubscriptionHelper.cancel(l22Var);
                atomicThrowable.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                atomicInteger.decrementAndGet();
            }
            if (getAndIncrement() != 0) {
                return;
            }
        }
        m6408g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x004b, code lost:
    
        if (r12 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x004d, code lost:
    
        if (r15 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004f, code lost:
    
        r18.f23203c.tryTerminateConsumer(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0054, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0055, code lost:
    
        if (r15 == false) goto L70;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6408g() {
        boolean z;
        boolean z2;
        boolean z3;
        Object poll;
        l22[] l22VarArr = this.f23202b;
        int length = l22VarArr.length;
        Subscriber<?> subscriber = this.f23201a;
        int i = 1;
        do {
            long j = this.f23204d.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.f23205e) {
                    m6272b();
                    return;
                }
                if (this.f23206f.get() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i2 = 0;
                boolean z4 = true;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    l22 l22Var = l22VarArr[i2];
                    SpscArrayQueue spscArrayQueue = l22Var.f22307e;
                    if (spscArrayQueue != null && (poll = spscArrayQueue.poll()) != null) {
                        subscriber.onNext(poll);
                        l22Var.m5818b();
                        j2++;
                        if (j2 == j) {
                            break;
                        } else {
                            z4 = false;
                        }
                    }
                    i2++;
                }
            }
            if (j2 == j) {
                if (this.f23205e) {
                    m6272b();
                    return;
                }
                if (this.f23206f.get() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        SpscArrayQueue spscArrayQueue2 = l22VarArr[i3].f22307e;
                        if (spscArrayQueue2 != null && !spscArrayQueue2.isEmpty()) {
                            z2 = false;
                            break;
                        }
                        i3++;
                    } else {
                        z2 = true;
                        break;
                    }
                }
                if (z && z2) {
                    this.f23203c.tryTerminateConsumer(subscriber);
                    return;
                }
            }
            if (j2 != 0) {
                BackpressureHelper.produced(this.f23204d, j2);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }
}
