package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.dv0;
import p000.w90;
import p000.x90;
import p000.y90;
import p000.z12;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class Equivalence<T> {

    /* loaded from: classes.dex */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        public final Equivalence f14474a;

        /* renamed from: b */
        public final Object f14475b;

        public Wrapper(Equivalence equivalence, Object obj) {
            this.f14474a = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.f14475b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Wrapper) {
                Wrapper wrapper = (Wrapper) obj;
                Equivalence equivalence = wrapper.f14474a;
                Equivalence equivalence2 = this.f14474a;
                if (equivalence2.equals(equivalence)) {
                    return equivalence2.equivalent(this.f14475b, wrapper.f14475b);
                }
                return false;
            }
            return false;
        }

        public T get() {
            return (T) this.f14475b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            return this.f14474a.hash(this.f14475b);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f14474a);
            String valueOf2 = String.valueOf(this.f14475b);
            return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 7, valueOf, ".wrap(", valueOf2, ")");
        }
    }

    public static Equivalence<Object> equals() {
        return w90.f28101a;
    }

    public static Equivalence<Object> identity() {
        return y90.f28871a;
    }

    @ForOverride
    public abstract boolean doEquivalent(T t, T t2);

    @ForOverride
    public abstract int doHash(T t);

    public final boolean equivalent(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return true;
        }
        if (t != null && t2 != null) {
            return doEquivalent(t, t2);
        }
        return false;
    }

    public final Predicate<T> equivalentTo(@CheckForNull T t) {
        return new x90(this, t);
    }

    public final int hash(@CheckForNull T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(Function<? super F, ? extends T> function) {
        return new dv0(function, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new z12(this);
    }

    public final <S extends T> Wrapper<S> wrap(S s) {
        return new Wrapper<>(this, s);
    }
}
