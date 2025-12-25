package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: a */
    public final Subscriber f20155a;

    /* renamed from: b */
    public final boolean f20156b;

    /* renamed from: c */
    public Subscription f20157c;

    /* renamed from: d */
    public boolean f20158d;

    /* renamed from: e */
    public AppendOnlyLinkedArrayList f20159e;

    /* renamed from: f */
    public volatile boolean f20160f;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    /* renamed from: a */
    public final void m5329a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f20159e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f20158d = false;
                        return;
                    }
                    this.f20159e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!appendOnlyLinkedArrayList.accept(this.f20155a));
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f20157c.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f20160f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f20160f) {
                    return;
                }
                if (this.f20158d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f20159e;
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList;
                    if (appendOnlyLinkedArrayList == null) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                        this.f20159e = appendOnlyLinkedArrayList3;
                        appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList3;
                    }
                    appendOnlyLinkedArrayList2.add(NotificationLite.complete());
                    return;
                }
                this.f20160f = true;
                this.f20158d = true;
                this.f20155a.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f20160f) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.f20160f) {
                    if (this.f20158d) {
                        this.f20160f = true;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f20159e;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList;
                        if (appendOnlyLinkedArrayList == null) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                            this.f20159e = appendOnlyLinkedArrayList3;
                            appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList3;
                        }
                        Object error = NotificationLite.error(th);
                        if (this.f20156b) {
                            appendOnlyLinkedArrayList2.add(error);
                        } else {
                            appendOnlyLinkedArrayList2.setFirst(error);
                        }
                        return;
                    }
                    this.f20160f = true;
                    this.f20158d = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.f20155a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        if (this.f20160f) {
            return;
        }
        if (t == null) {
            this.f20157c.cancel();
            onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f20160f) {
                    return;
                }
                if (this.f20158d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f20159e;
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList;
                    if (appendOnlyLinkedArrayList == null) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                        this.f20159e = appendOnlyLinkedArrayList3;
                        appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList3;
                    }
                    appendOnlyLinkedArrayList2.add(NotificationLite.next(t));
                    return;
                }
                this.f20158d = true;
                this.f20155a.onNext(t);
                m5329a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20157c, subscription)) {
            this.f20157c = subscription;
            this.f20155a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.f20157c.request(j);
    }

    public SerializedSubscriber(@NonNull Subscriber<? super T> subscriber, boolean z) {
        this.f20155a = subscriber;
        this.f20156b = z;
    }
}
