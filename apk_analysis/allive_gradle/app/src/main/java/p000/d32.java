package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class d32 extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = 3481980673745556697L;

    /* renamed from: a */
    public final Subscriber f16227a;

    /* renamed from: b */
    public final c32[] f16228b;

    /* renamed from: c */
    public final List[] f16229c;

    /* renamed from: d */
    public final int[] f16230d;

    /* renamed from: e */
    public final Comparator f16231e;

    /* renamed from: g */
    public volatile boolean f16233g;

    /* renamed from: f */
    public final AtomicLong f16232f = new AtomicLong();

    /* renamed from: h */
    public final AtomicInteger f16234h = new AtomicInteger();

    /* renamed from: i */
    public final AtomicReference f16235i = new AtomicReference();

    public d32(Subscriber subscriber, int i, Comparator comparator) {
        this.f16227a = subscriber;
        this.f16231e = comparator;
        c32[] c32VarArr = new c32[i];
        for (int i2 = 0; i2 < i; i2++) {
            c32VarArr[i2] = new c32(this, i2);
        }
        this.f16228b = c32VarArr;
        this.f16229c = new List[i];
        this.f16230d = new int[i];
        this.f16234h.lazySet(i);
    }

    /* renamed from: a */
    public final void m4517a() {
        for (c32 c32Var : this.f16228b) {
            c32Var.getClass();
            SubscriptionHelper.cancel(c32Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
    
        if (r16.f16233g == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b1, code lost:
    
        r7 = (java.lang.Throwable) r16.f16235i.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ba, code lost:
    
        if (r7 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c6, code lost:
    
        if (r14 >= r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d0, code lost:
    
        if (r0[r14] == r3[r14].size()) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d6, code lost:
    
        if (r11 == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d8, code lost:
    
        io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r16.f16232f, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dd, code lost:
    
        r6 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ea, code lost:
    
        java.util.Arrays.fill(r3, (java.lang.Object) null);
        r2.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00bc, code lost:
    
        m4517a();
        java.util.Arrays.fill(r3, (java.lang.Object) null);
        r2.onError(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ac, code lost:
    
        java.util.Arrays.fill(r3, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b0, code lost:
    
        return;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4518b() {
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f16227a;
        List[] listArr = this.f16229c;
        int[] iArr = this.f16230d;
        int length = iArr.length;
        int i = 1;
        do {
            long j = this.f16232f.get();
            long j2 = 0;
            while (true) {
                int i2 = 0;
                if (j2 == j) {
                    break;
                }
                if (this.f16233g) {
                    Arrays.fill(listArr, (Object) null);
                    return;
                }
                Throwable th = (Throwable) this.f16235i.get();
                if (th != null) {
                    m4517a();
                    Arrays.fill(listArr, (Object) null);
                    subscriber.onError(th);
                    return;
                }
                int i3 = -1;
                Object obj = null;
                while (i2 < length) {
                    List list = listArr[i2];
                    int i4 = iArr[i2];
                    if (list.size() != i4) {
                        if (obj == null) {
                            obj = list.get(i4);
                        } else {
                            Object obj2 = list.get(i4);
                            try {
                                if (this.f16231e.compare(obj, obj2) > 0) {
                                    obj = obj2;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                m4517a();
                                boolean z = false;
                                Arrays.fill(listArr, (Object) null);
                                AtomicReference atomicReference = this.f16235i;
                                while (true) {
                                    if (atomicReference.compareAndSet(z, th2)) {
                                        break;
                                    }
                                    if (atomicReference.get() != null) {
                                        RxJavaPlugins.onError(th2);
                                        break;
                                    }
                                    z = false;
                                }
                                subscriber.onError((Throwable) this.f16235i.get());
                                return;
                            }
                        }
                        i3 = i2;
                    }
                    i2++;
                }
                if (obj == null) {
                    Arrays.fill(listArr, (Object) null);
                    subscriber.onComplete();
                    return;
                } else {
                    subscriber.onNext(obj);
                    iArr[i3] = iArr[i3] + 1;
                    j2++;
                }
            }
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f16233g) {
            this.f16233g = true;
            m4517a();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.f16229c, (Object) null);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16232f, j);
            if (this.f16234h.get() == 0) {
                m4518b();
            }
        }
    }
}
