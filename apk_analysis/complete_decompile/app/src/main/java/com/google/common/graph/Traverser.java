package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import p000.InterfaceC1304if;
import p000.ge3;
import p000.wv2;
import p000.xv2;

@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
@Beta
/* loaded from: classes2.dex */
public abstract class Traverser<N> {

    /* renamed from: a */
    public final SuccessorsFunction f15043a;

    public Traverser(SuccessorsFunction successorsFunction) {
        this.f15043a = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        return new wv2(successorsFunction, successorsFunction, 0);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        if (successorsFunction instanceof InterfaceC1304if) {
            Preconditions.checkArgument(((InterfaceC1304if) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new wv2(successorsFunction, successorsFunction, 1);
    }

    /* renamed from: a */
    public abstract ge3 mo4176a();

    /* renamed from: b */
    public final ImmutableSet m4177b(Iterable iterable) {
        ImmutableSet copyOf = ImmutableSet.copyOf(iterable);
        UnmodifiableIterator it = copyOf.iterator();
        while (it.hasNext()) {
            this.f15043a.successors(it.next());
        }
        return copyOf;
    }

    public final Iterable<N> breadthFirst(N n) {
        return breadthFirst((Iterable) ImmutableSet.m3972of(n));
    }

    public final Iterable<N> depthFirstPostOrder(N n) {
        return depthFirstPostOrder((Iterable) ImmutableSet.m3972of(n));
    }

    public final Iterable<N> depthFirstPreOrder(N n) {
        return depthFirstPreOrder((Iterable) ImmutableSet.m3972of(n));
    }

    public final Iterable<N> breadthFirst(Iterable<? extends N> iterable) {
        return new xv2(this, m4177b(iterable), 0);
    }

    public final Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable) {
        return new xv2(this, m4177b(iterable), 2);
    }

    public final Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable) {
        return new xv2(this, m4177b(iterable), 1);
    }
}
