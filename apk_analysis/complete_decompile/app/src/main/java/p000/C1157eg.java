package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.processors.BehaviorProcessor;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* renamed from: eg */
/* loaded from: classes2.dex */
public final class C1157eg extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate {
    private static final long serialVersionUID = 3293175281126227086L;

    /* renamed from: a */
    public final Subscriber f16800a;

    /* renamed from: b */
    public final BehaviorProcessor f16801b;

    /* renamed from: c */
    public boolean f16802c;

    /* renamed from: d */
    public boolean f16803d;

    /* renamed from: e */
    public AppendOnlyLinkedArrayList f16804e;

    /* renamed from: f */
    public boolean f16805f;

    /* renamed from: g */
    public volatile boolean f16806g;

    /* renamed from: h */
    public long f16807h;

    public C1157eg(Subscriber subscriber, BehaviorProcessor behaviorProcessor) {
        this.f16800a = subscriber;
        this.f16801b = behaviorProcessor;
    }

    /* renamed from: a */
    public final void m4718a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (!this.f16806g) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f16804e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f16803d = false;
                        return;
                    }
                    this.f16804e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
    }

    /* renamed from: b */
    public final void m4719b(Object obj, long j) {
        if (this.f16806g) {
            return;
        }
        if (!this.f16805f) {
            synchronized (this) {
                try {
                    if (this.f16806g) {
                        return;
                    }
                    if (this.f16807h == j) {
                        return;
                    }
                    if (this.f16803d) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f16804e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f16804e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.f16802c = true;
                    this.f16805f = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        test(obj);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f16806g) {
            this.f16806g = true;
            this.f16801b.m5310e(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }

    @Override // io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.rxjava3.functions.Predicate
    public final boolean test(Object obj) {
        if (this.f16806g) {
            return true;
        }
        if (NotificationLite.isComplete(obj)) {
            this.f16800a.onComplete();
            return true;
        }
        if (NotificationLite.isError(obj)) {
            this.f16800a.onError(NotificationLite.getError(obj));
            return true;
        }
        long j = get();
        if (j != 0) {
            this.f16800a.onNext(NotificationLite.getValue(obj));
            if (j != Long.MAX_VALUE) {
                decrementAndGet();
                return false;
            }
            return false;
        }
        cancel();
        this.f16800a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        return true;
    }
}
