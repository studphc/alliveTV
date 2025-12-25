package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.a90;

@Immutable(containerOf = {"N"})
@Beta
/* loaded from: classes2.dex */
public abstract class EndpointPair<N> implements Iterable<N> {

    /* renamed from: a */
    public final Object f15034a;

    /* renamed from: b */
    public final Object f15035b;

    public EndpointPair(Object obj, Object obj2) {
        this.f15034a = Preconditions.checkNotNull(obj);
        this.f15035b = Preconditions.checkNotNull(obj2);
    }

    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new a90(0, n, n2);
    }

    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new a90(1, n2, n);
    }

    public final N adjacentNode(N n) {
        N n2 = (N) this.f15034a;
        boolean equals = n.equals(n2);
        N n3 = (N) this.f15035b;
        if (equals) {
            return n3;
        }
        if (n.equals(n3)) {
            return n2;
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(n);
        throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 36, "EndpointPair ", valueOf, " does not contain node ", valueOf2));
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final N nodeU() {
        return (N) this.f15034a;
    }

    public final N nodeV() {
        return (N) this.f15035b;
    }

    public abstract N source();

    public abstract N target();

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.f15034a, this.f15035b);
    }
}
