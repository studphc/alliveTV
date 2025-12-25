package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.ns1;
import p000.os1;
import p000.ps1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class NotificationLite {
    public static final NotificationLite COMPLETE;

    /* renamed from: a */
    public static final /* synthetic */ NotificationLite[] f19960a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.util.NotificationLite] */
    static {
        ?? r1 = new Enum("COMPLETE", 0);
        COMPLETE = r1;
        f19960a = new NotificationLite[]{r1};
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof os1) {
            subscriber.onError(((os1) obj).f24895a);
            return true;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof os1) {
            subscriber.onError(((os1) obj).f24895a);
            return true;
        }
        if (obj instanceof ps1) {
            subscriber.onSubscribe(((ps1) obj).f25278a);
            return false;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable disposable) {
        return new ns1(disposable);
    }

    public static Object error(Throwable th) {
        return new os1(th);
    }

    public static Disposable getDisposable(Object obj) {
        return ((ns1) obj).f23480a;
    }

    public static Throwable getError(Object obj) {
        return ((os1) obj).f24895a;
    }

    public static Subscription getSubscription(Object obj) {
        return ((ps1) obj).f25278a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        if (obj == COMPLETE) {
            return true;
        }
        return false;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof ns1;
    }

    public static boolean isError(Object obj) {
        return obj instanceof os1;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof ps1;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(Subscription subscription) {
        return new ps1(subscription);
    }

    public static NotificationLite valueOf(String str) {
        return (NotificationLite) Enum.valueOf(NotificationLite.class, str);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) f19960a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (obj instanceof os1) {
            observer.onError(((os1) obj).f24895a);
            return true;
        }
        observer.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (obj instanceof os1) {
            observer.onError(((os1) obj).f24895a);
            return true;
        }
        if (obj instanceof ns1) {
            observer.onSubscribe(((ns1) obj).f23480a);
            return false;
        }
        observer.onNext(obj);
        return false;
    }
}
