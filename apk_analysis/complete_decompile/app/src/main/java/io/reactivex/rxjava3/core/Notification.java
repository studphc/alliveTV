package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class Notification<T> {

    /* renamed from: b */
    public static final Notification f18489b = new Notification(null);

    /* renamed from: a */
    public final Object f18490a;

    public Notification(Object obj) {
        this.f18490a = obj;
    }

    @NonNull
    public static <T> Notification<T> createOnComplete() {
        return f18489b;
    }

    @NonNull
    public static <T> Notification<T> createOnError(@NonNull Throwable th) {
        Objects.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    @NonNull
    public static <T> Notification<T> createOnNext(T t) {
        Objects.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return Objects.equals(this.f18490a, ((Notification) obj).f18490a);
        }
        return false;
    }

    @Nullable
    public Throwable getError() {
        Object obj = this.f18490a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        T t = (T) this.f18490a;
        if (t != null && !NotificationLite.isError(t)) {
            return t;
        }
        return null;
    }

    public int hashCode() {
        Object obj = this.f18490a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isOnComplete() {
        if (this.f18490a == null) {
            return true;
        }
        return false;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.f18490a);
    }

    public boolean isOnNext() {
        Object obj = this.f18490a;
        if (obj != null && !NotificationLite.isError(obj)) {
            return true;
        }
        return false;
    }

    public String toString() {
        Object obj = this.f18490a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + obj + "]";
    }
}
