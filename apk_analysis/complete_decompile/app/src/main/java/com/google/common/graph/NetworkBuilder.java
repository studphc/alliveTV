package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;
import p000.AbstractC1929w0;
import p000.ym2;

@Beta
/* loaded from: classes2.dex */
public final class NetworkBuilder<N, E> extends AbstractC1929w0 {

    /* renamed from: f */
    public boolean f15040f;

    /* renamed from: g */
    public ElementOrder f15041g;

    /* renamed from: h */
    public Optional f15042h;

    public NetworkBuilder(boolean z) {
        super(z);
        this.f15040f = false;
        this.f15041g = ElementOrder.insertion();
        this.f15042h = Optional.absent();
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> network) {
        return new NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.f15040f = z;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.f28024b = z;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return (MutableNetwork<N1, E1>) new ym2(this, this.f28025c.m4171a(((Integer) this.f28027e.mo3773or((Optional) 10)).intValue()), this.f15041g.m4171a(((Integer) this.f15042h.mo3773or((Optional) 20)).intValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        this.f15041g = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int i) {
        Graphs.m4172a(i);
        this.f15042h = Optional.m3770of(Integer.valueOf(i));
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int i) {
        Graphs.m4172a(i);
        this.f28027e = Optional.m3770of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        this.f28025c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }
}
