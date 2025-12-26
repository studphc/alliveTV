package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import org.reactivestreams.Subscriber;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class EmptySubscription implements QueueSubscription<Object> {
    public static final EmptySubscription INSTANCE;

    /* renamed from: a */
    public static final /* synthetic */ EmptySubscription[] f19934a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.subscriptions.EmptySubscription] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        INSTANCE = r1;
        f19934a = new EmptySubscription[]{r1};
    }

    public static void complete(Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onComplete();
    }

    public static void error(Throwable th, Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onError(th);
    }

    public static EmptySubscription valueOf(String str) {
        return (EmptySubscription) Enum.valueOf(EmptySubscription.class, str);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) f19934a.clone();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public Object poll() {
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
