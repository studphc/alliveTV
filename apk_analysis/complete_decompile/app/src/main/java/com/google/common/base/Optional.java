package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.C1177f;
import p000.i12;
import p000.i72;

@DoNotMock("Use Optional.of(value) or Optional.absent()")
@GwtCompatible(serializable = true)
/* loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return C1177f.f17048a;
    }

    public static <T> Optional<T> fromNullable(@CheckForNull T t) {
        if (t == null) {
            return absent();
        }
        return new i72(t);
    }

    /* renamed from: of */
    public static <T> Optional<T> m3770of(T t) {
        return new i72(Preconditions.checkNotNull(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new i12(iterable, 0);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    /* renamed from: or */
    public abstract Optional<T> mo3771or(Optional<? extends T> optional);

    @Beta
    /* renamed from: or */
    public abstract T mo3772or(Supplier<? extends T> supplier);

    /* renamed from: or */
    public abstract T mo3773or(T t);

    @CheckForNull
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
