package p000;

import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ug2 extends FlowableProcessor {

    /* renamed from: b */
    public final FlowableProcessor f27259b;

    /* renamed from: c */
    public boolean f27260c;

    /* renamed from: d */
    public AppendOnlyLinkedArrayList f27261d;

    /* renamed from: e */
    public volatile boolean f27262e;

    public ug2(FlowableProcessor flowableProcessor) {
        this.f27259b = flowableProcessor;
    }

    /* renamed from: e */
    public final void m7704e() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f27261d;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f27260c = false;
                        return;
                    }
                    this.f27261d = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            appendOnlyLinkedArrayList.accept(this.f27259b);
        }
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public final Throwable getThrowable() {
        return this.f27259b.getThrowable();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public final boolean hasComplete() {
        return this.f27259b.hasComplete();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public final boolean hasSubscribers() {
        return this.f27259b.hasSubscribers();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public final boolean hasThrowable() {
        return this.f27259b.hasThrowable();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f27262e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f27262e) {
                    return;
                }
                this.f27262e = true;
                if (this.f27260c) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27261d;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f27261d = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.add(NotificationLite.complete());
                    return;
                }
                this.f27260c = true;
                this.f27259b.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27262e) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.f27262e) {
                    this.f27262e = true;
                    if (this.f27260c) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27261d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f27261d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.setFirst(NotificationLite.error(th));
                        return;
                    }
                    this.f27260c = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.f27259b.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27262e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f27262e) {
                    return;
                }
                if (this.f27260c) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27261d;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f27261d = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.add(NotificationLite.next(obj));
                    return;
                }
                this.f27260c = true;
                this.f27259b.onNext(obj);
                m7704e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.f27262e) {
            synchronized (this) {
                try {
                    if (!this.f27262e) {
                        if (this.f27260c) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f27261d;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                                this.f27261d = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                            return;
                        }
                        this.f27260c = true;
                        z = false;
                    }
                } finally {
                }
            }
        }
        if (z) {
            subscription.cancel();
        } else {
            this.f27259b.onSubscribe(subscription);
            m7704e();
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public final void subscribeActual(Subscriber subscriber) {
        this.f27259b.subscribe(subscriber);
    }
}
