package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class m22 extends n22 {
    private static final long serialVersionUID = 6312374661811000451L;

    @Override // p000.n22
    /* renamed from: c */
    public final void mo6010c() {
        if (getAndIncrement() != 0) {
            return;
        }
        m6014g();
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
        AtomicThrowable atomicThrowable = this.f23203c;
        if (atomicThrowable.compareAndSet(null, th)) {
            m6271a();
            mo6010c();
        } else if (th != atomicThrowable.get()) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // p000.n22
    /* renamed from: f */
    public final void mo6013f(l22 l22Var, Object obj) {
        if (get() == 0 && compareAndSet(0, 1)) {
            AtomicLong atomicLong = this.f23204d;
            long j = atomicLong.get();
            Subscriber subscriber = this.f23201a;
            if (j != 0) {
                subscriber.onNext(obj);
                if (atomicLong.get() != Long.MAX_VALUE) {
                    atomicLong.decrementAndGet();
                }
                long j2 = l22Var.f22306d + 1;
                if (j2 >= l22Var.f22305c) {
                    l22Var.f22306d = 0L;
                    ((Subscription) l22Var.get()).request(j2);
                } else {
                    l22Var.f22306d = j2;
                }
            } else if (!l22Var.m5817a().offer(obj)) {
                m6271a();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                if (this.f23203c.compareAndSet(null, missingBackpressureException)) {
                    subscriber.onError(missingBackpressureException);
                    return;
                } else {
                    RxJavaPlugins.onError(missingBackpressureException);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else if (!l22Var.m5817a().offer(obj)) {
            m6271a();
            mo6012e(new MissingBackpressureException("Queue full?!"));
            return;
        } else if (getAndIncrement() != 0) {
            return;
        }
        m6014g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x005d, code lost:
    
        if (r12 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005f, code lost:
    
        if (r15 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0061, code lost:
    
        r3.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0064, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0065, code lost:
    
        if (r15 == false) goto L81;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6014g() {
        boolean z;
        boolean z2;
        boolean z3;
        E poll;
        l22[] l22VarArr = this.f23202b;
        int length = l22VarArr.length;
        Subscriber subscriber = this.f23201a;
        int i = 1;
        do {
            long j = this.f23204d.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.f23205e) {
                    m6272b();
                    return;
                }
                Throwable th = this.f23203c.get();
                if (th != null) {
                    m6272b();
                    subscriber.onError(th);
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
                    if (i2 >= l22VarArr.length) {
                        break;
                    }
                    l22 l22Var = l22VarArr[i2];
                    SpscArrayQueue spscArrayQueue = l22Var.f22307e;
                    if (spscArrayQueue != null && (poll = spscArrayQueue.poll()) != 0) {
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
                Throwable th2 = this.f23203c.get();
                if (th2 != null) {
                    m6272b();
                    subscriber.onError(th2);
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
                    subscriber.onComplete();
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
