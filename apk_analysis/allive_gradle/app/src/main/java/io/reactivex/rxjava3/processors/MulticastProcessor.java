package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.sp1;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport(SchedulerSupport.NONE)
/* loaded from: classes2.dex */
public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: m */
    public static final sp1[] f20051m = new sp1[0];

    /* renamed from: n */
    public static final sp1[] f20052n = new sp1[0];

    /* renamed from: e */
    public final int f20056e;

    /* renamed from: f */
    public final int f20057f;

    /* renamed from: g */
    public final boolean f20058g;

    /* renamed from: h */
    public volatile SimpleQueue f20059h;

    /* renamed from: i */
    public volatile boolean f20060i;

    /* renamed from: j */
    public volatile Throwable f20061j;

    /* renamed from: k */
    public int f20062k;

    /* renamed from: l */
    public int f20063l;

    /* renamed from: b */
    public final AtomicInteger f20053b = new AtomicInteger();

    /* renamed from: d */
    public final AtomicReference f20055d = new AtomicReference(f20051m);

    /* renamed from: c */
    public final AtomicReference f20054c = new AtomicReference();

    public MulticastProcessor(int i, boolean z) {
        this.f20056e = i;
        this.f20057f = i - (i >> 2);
        this.f20058g = z;
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(Flowable.bufferSize(), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0150, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0171, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0153, code lost:
    
        r0 = (p000.sp1[]) r2.getAndSet(r11);
        r2 = r0.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x015b, code lost:
    
        if (r12 >= r2) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x015d, code lost:
    
        r3 = r0[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0167, code lost:
    
        if (r3.get() == Long.MIN_VALUE) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0169, code lost:
    
        r3.f26519a.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x016e, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0172, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x011c, code lost:
    
        r7.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x011f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ce, code lost:
    
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0112, code lost:
    
        if (r14 != 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0114, code lost:
    
        r0 = (p000.sp1[]) r2.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x011a, code lost:
    
        if (r0 != r11) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0120, code lost:
    
        if (r8 == r0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0129, code lost:
    
        if (r24.f20060i == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x012f, code lost:
    
        if (r7.isEmpty() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0131, code lost:
    
        r0 = r24.f20061j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0133, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0135, code lost:
    
        r2 = (p000.sp1[]) r2.getAndSet(r11);
        r3 = r2.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x013d, code lost:
    
        if (r12 >= r3) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x013f, code lost:
    
        r4 = r2[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0149, code lost:
    
        if (r4.get() == Long.MIN_VALUE) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x014b, code lost:
    
        r4.f26519a.onError(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5312e() {
        int i;
        Object obj;
        boolean z;
        if (this.f20053b.getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f20055d;
        int i2 = this.f20062k;
        int i3 = this.f20057f;
        int i4 = this.f20063l;
        boolean z2 = true;
        int i5 = 1;
        while (true) {
            SimpleQueue simpleQueue = this.f20059h;
            if (simpleQueue != null) {
                sp1[] sp1VarArr = (sp1[]) atomicReference.get();
                if (sp1VarArr.length != 0) {
                    int length = sp1VarArr.length;
                    long j = -1;
                    long j2 = -1;
                    int i6 = 0;
                    while (i6 < length) {
                        sp1 sp1Var = sp1VarArr[i6];
                        long j3 = sp1Var.get();
                        if (j3 >= 0) {
                            if (j2 == j) {
                                j2 = j3 - sp1Var.f26521c;
                            } else {
                                j2 = Math.min(j2, j3 - sp1Var.f26521c);
                            }
                        }
                        i6++;
                        j = -1;
                    }
                    int i7 = i2;
                    while (true) {
                        sp1[] sp1VarArr2 = f20052n;
                        if (j2 <= 0) {
                            break;
                        }
                        sp1[] sp1VarArr3 = (sp1[]) atomicReference.get();
                        if (sp1VarArr3 == sp1VarArr2) {
                            simpleQueue.clear();
                            return;
                        }
                        if (sp1VarArr != sp1VarArr3) {
                            i = i5;
                            break;
                        }
                        boolean z3 = this.f20060i;
                        try {
                            obj = simpleQueue.poll();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            SubscriptionHelper.cancel(this.f20054c);
                            this.f20061j = th;
                            this.f20060i = z2;
                            obj = null;
                            z3 = z2;
                        }
                        Object obj2 = obj;
                        if (obj2 == null) {
                            z = z2;
                        } else {
                            z = false;
                        }
                        if (z3 && z) {
                            Throwable th2 = this.f20061j;
                            if (th2 != null) {
                                for (sp1 sp1Var2 : (sp1[]) atomicReference.getAndSet(sp1VarArr2)) {
                                    if (sp1Var2.get() != Long.MIN_VALUE) {
                                        sp1Var2.f26519a.onError(th2);
                                    }
                                }
                                return;
                            }
                            for (sp1 sp1Var3 : (sp1[]) atomicReference.getAndSet(sp1VarArr2)) {
                                if (sp1Var3.get() != Long.MIN_VALUE) {
                                    sp1Var3.f26519a.onComplete();
                                }
                            }
                            return;
                        }
                        if (z) {
                            break;
                        }
                        int length2 = sp1VarArr.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            sp1 sp1Var4 = sp1VarArr[i8];
                            int i9 = i5;
                            if (sp1Var4.get() != Long.MIN_VALUE) {
                                sp1Var4.f26521c++;
                                sp1Var4.f26519a.onNext(obj2);
                            }
                            i8++;
                            i5 = i9;
                        }
                        int i10 = i5;
                        j2--;
                        z2 = true;
                        if (i4 != 1 && (i7 = i7 + 1) == i3) {
                            ((Subscription) this.f20054c.get()).request(i3);
                            i7 = 0;
                        }
                        i5 = i10;
                    }
                    i2 = i7;
                    i5 = i;
                }
            }
            i = i5;
            this.f20062k = i2;
            i5 = this.f20053b.addAndGet(-i);
            if (i5 == 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public final void m5313f(sp1 sp1Var) {
        while (true) {
            sp1[] sp1VarArr = (sp1[]) this.f20055d.get();
            int length = sp1VarArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (sp1VarArr[i] == sp1Var) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i >= 0) {
                if (length == 1) {
                    if (this.f20058g) {
                        AtomicReference atomicReference = this.f20055d;
                        sp1[] sp1VarArr2 = f20052n;
                        while (!atomicReference.compareAndSet(sp1VarArr, sp1VarArr2)) {
                            if (atomicReference.get() != sp1VarArr) {
                                break;
                            }
                        }
                        SubscriptionHelper.cancel(this.f20054c);
                        this.f20060i = true;
                        return;
                    }
                    AtomicReference atomicReference2 = this.f20055d;
                    sp1[] sp1VarArr3 = f20051m;
                    while (!atomicReference2.compareAndSet(sp1VarArr, sp1VarArr3)) {
                        if (atomicReference2.get() != sp1VarArr) {
                            break;
                        }
                    }
                    return;
                }
                sp1[] sp1VarArr4 = new sp1[length - 1];
                System.arraycopy(sp1VarArr, 0, sp1VarArr4, 0, i);
                System.arraycopy(sp1VarArr, i + 1, sp1VarArr4, i, (length - i) - 1);
                AtomicReference atomicReference3 = this.f20055d;
                while (!atomicReference3.compareAndSet(sp1VarArr, sp1VarArr4)) {
                    if (atomicReference3.get() != sp1VarArr) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.f20060i) {
            return this.f20061j;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        if (this.f20060i && this.f20061j == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        if (((sp1[]) this.f20055d.get()).length != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        if (this.f20060i && this.f20061j != null) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        if (this.f20060i) {
            return false;
        }
        if (this.f20063l == 0) {
            if (!this.f20059h.offer(t)) {
                return false;
            }
            m5312e();
            return true;
        }
        throw new IllegalStateException("offer() should not be called in fusion mode!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f20060i = true;
        m5312e();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!this.f20060i) {
            this.f20061j = th;
            this.f20060i = true;
            m5312e();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        if (this.f20060i) {
            return;
        }
        if (this.f20063l == 0) {
            ExceptionHelper.nullCheck(t, "onNext called with a null value.");
            if (!this.f20059h.offer(t)) {
                SubscriptionHelper.cancel(this.f20054c);
                onError(new MissingBackpressureException());
                return;
            }
        }
        m5312e();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f20054c, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f20063l = requestFusion;
                    this.f20059h = queueSubscription;
                    this.f20060i = true;
                    m5312e();
                    return;
                }
                if (requestFusion == 2) {
                    this.f20063l = requestFusion;
                    this.f20059h = queueSubscription;
                    subscription.request(this.f20056e);
                    return;
                }
            }
            this.f20059h = new SpscArrayQueue(this.f20056e);
            subscription.request(this.f20056e);
        }
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.f20054c, EmptySubscription.INSTANCE)) {
            this.f20059h = new SpscArrayQueue(this.f20056e);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.f20054c, EmptySubscription.INSTANCE)) {
            this.f20059h = new SpscLinkedArrayQueue(this.f20056e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        Throwable th;
        sp1 sp1Var = new sp1(subscriber, this);
        subscriber.onSubscribe(sp1Var);
        while (true) {
            AtomicReference atomicReference = this.f20055d;
            sp1[] sp1VarArr = (sp1[]) atomicReference.get();
            if (sp1VarArr == f20052n) {
                if (this.f20060i && (th = this.f20061j) != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            int length = sp1VarArr.length;
            sp1[] sp1VarArr2 = new sp1[length + 1];
            System.arraycopy(sp1VarArr, 0, sp1VarArr2, 0, length);
            sp1VarArr2[length] = sp1Var;
            while (!atomicReference.compareAndSet(sp1VarArr, sp1VarArr2)) {
                if (atomicReference.get() != sp1VarArr) {
                    break;
                }
            }
            if (sp1Var.get() == Long.MIN_VALUE) {
                m5313f(sp1Var);
                return;
            } else {
                m5312e();
                return;
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(boolean z) {
        return new MulticastProcessor<>(Flowable.bufferSize(), z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new MulticastProcessor<>(i, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i, boolean z) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new MulticastProcessor<>(i, z);
    }
}
