package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p000.ye0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class SubscriptionHelper implements Subscription {
    public static final SubscriptionHelper CANCELLED;

    /* renamed from: a */
    public static final /* synthetic */ SubscriptionHelper[] f19944a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper] */
    static {
        ?? r1 = new Enum("CANCELLED", 0);
        CANCELLED = r1;
        f19944a = new SubscriptionHelper[]{r1};
    }

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
            return;
        }
        if (validate(j)) {
            BackpressureHelper.add(atomicLong, j);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (setOnce(atomicReference, subscription)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                subscription.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        while (true) {
            Subscription subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
            while (!atomicReference.compareAndSet(subscription2, subscription)) {
                if (atomicReference.get() != subscription2) {
                    break;
                }
            }
            return true;
        }
    }

    public static void reportMoreProduced(long j) {
        RxJavaPlugins.onError(new ProtocolViolationException(ye0.m8294n(j, "More produced than requested: ")));
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        while (true) {
            Subscription subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
            while (!atomicReference.compareAndSet(subscription2, subscription)) {
                if (atomicReference.get() != subscription2) {
                    break;
                }
            }
            if (subscription2 != null) {
                subscription2.cancel();
                return true;
            }
            return true;
        }
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Objects.requireNonNull(subscription, "s is null");
        while (!atomicReference.compareAndSet(null, subscription)) {
            if (atomicReference.get() != null) {
                subscription.cancel();
                if (atomicReference.get() == CANCELLED) {
                    return false;
                }
                reportSubscriptionSet();
                return false;
            }
        }
        return true;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        reportSubscriptionSet();
        return false;
    }

    public static SubscriptionHelper valueOf(String str) {
        return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, str);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) f19944a.clone();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        RxJavaPlugins.onError(new IllegalArgumentException(ye0.m8294n(j, "n > 0 required but it was ")));
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, long j) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        subscription.request(j);
        return true;
    }
}
