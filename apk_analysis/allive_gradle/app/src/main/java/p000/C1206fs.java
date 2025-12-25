package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* renamed from: fs */
/* loaded from: classes2.dex */
public final class C1206fs extends AtomicInteger implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = 9032184911934499404L;

    /* renamed from: a */
    public final CompletableObserver f17381a;

    /* renamed from: b */
    public final int f17382b;

    /* renamed from: c */
    public final int f17383c;

    /* renamed from: d */
    public final C1169es f17384d = new C1169es(this);

    /* renamed from: e */
    public final AtomicBoolean f17385e = new AtomicBoolean();

    /* renamed from: f */
    public int f17386f;

    /* renamed from: g */
    public int f17387g;

    /* renamed from: h */
    public SimpleQueue f17388h;

    /* renamed from: i */
    public Subscription f17389i;

    /* renamed from: j */
    public volatile boolean f17390j;

    /* renamed from: k */
    public volatile boolean f17391k;

    public C1206fs(CompletableObserver completableObserver, int i) {
        this.f17381a = completableObserver;
        this.f17382b = i;
        this.f17383c = i - (i >> 2);
    }

    /* renamed from: a */
    public final void m4829a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        while (!isDisposed()) {
            if (!this.f17391k) {
                boolean z2 = this.f17390j;
                try {
                    CompletableSource completableSource = (CompletableSource) this.f17388h.poll();
                    if (completableSource == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f17381a.onComplete();
                        return;
                    }
                    if (!z) {
                        this.f17391k = true;
                        completableSource.subscribe(this.f17384d);
                        if (this.f17386f != 1) {
                            int i = this.f17387g + 1;
                            if (i == this.f17383c) {
                                this.f17387g = 0;
                                this.f17389i.request(i);
                            } else {
                                this.f17387g = i;
                            }
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (this.f17385e.compareAndSet(false, true)) {
                        this.f17389i.cancel();
                        this.f17381a.onError(th);
                        return;
                    } else {
                        RxJavaPlugins.onError(th);
                        return;
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f17389i.cancel();
        DisposableHelper.dispose(this.f17384d);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f17384d.get());
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f17390j = true;
        m4829a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f17385e.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.f17384d);
            this.f17381a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        CompletableSource completableSource = (CompletableSource) obj;
        if (this.f17386f == 0 && !this.f17388h.offer(completableSource)) {
            onError(new MissingBackpressureException());
        } else {
            m4829a();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        long j;
        if (SubscriptionHelper.validate(this.f17389i, subscription)) {
            this.f17389i = subscription;
            int i = this.f17382b;
            if (i == Integer.MAX_VALUE) {
                j = Long.MAX_VALUE;
            } else {
                j = i;
            }
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f17386f = requestFusion;
                    this.f17388h = queueSubscription;
                    this.f17390j = true;
                    this.f17381a.onSubscribe(this);
                    m4829a();
                    return;
                }
                if (requestFusion == 2) {
                    this.f17386f = requestFusion;
                    this.f17388h = queueSubscription;
                    this.f17381a.onSubscribe(this);
                    subscription.request(j);
                    return;
                }
            }
            if (this.f17382b == Integer.MAX_VALUE) {
                this.f17388h = new SpscLinkedArrayQueue(Flowable.bufferSize());
            } else {
                this.f17388h = new SpscArrayQueue(this.f17382b);
            }
            this.f17381a.onSubscribe(this);
            subscription.request(j);
        }
    }
}
