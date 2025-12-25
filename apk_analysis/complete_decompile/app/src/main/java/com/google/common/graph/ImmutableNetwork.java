package com.google.common.graph;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;
import p000.AbstractC1218g3;
import p000.AbstractC2039z;
import p000.p31;
import p000.ym2;

@Immutable(containerOf = {"N", ExifInterface.LONGITUDE_EAST})
@Beta
/* loaded from: classes2.dex */
public final class ImmutableNetwork<N, E> extends ym2 {

    /* loaded from: classes2.dex */
    public static class Builder<N, E> {

        /* renamed from: a */
        public final MutableNetwork f15038a;

        public Builder(NetworkBuilder networkBuilder) {
            this.f15038a = networkBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(N n, N n2, E e) {
            this.f15038a.addEdge(n, n2, e);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addNode(N n) {
            this.f15038a.addNode(n);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.f15038a);
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e) {
            this.f15038a.addEdge(endpointPair, e);
            return this;
        }
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(final Network<N, E> network) {
        Object abstractC1218g3;
        Object obj;
        if (network instanceof ImmutableNetwork) {
            return (ImmutableNetwork) network;
        }
        NetworkBuilder from = NetworkBuilder.from(network);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n : network.nodes()) {
            if (network.isDirected()) {
                final int i = 0;
                Map asMap = Maps.asMap(network.inEdges(n), new Function() { // from class: o31
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj2) {
                        switch (i) {
                            case 0:
                                return network.incidentNodes(obj2).source();
                            default:
                                return network.incidentNodes(obj2).target();
                        }
                    }
                });
                final int i2 = 1;
                Map asMap2 = Maps.asMap(network.outEdges(n), new Function() { // from class: o31
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj2) {
                        switch (i2) {
                            case 0:
                                return network.incidentNodes(obj2).source();
                            default:
                                return network.incidentNodes(obj2).target();
                        }
                    }
                });
                int size = network.edgesConnecting(n, n).size();
                if (network.allowsParallelEdges()) {
                    obj = new AbstractC2039z(ImmutableMap.copyOf(asMap), ImmutableMap.copyOf(asMap2), size);
                } else {
                    obj = new AbstractC2039z(ImmutableBiMap.copyOf(asMap), ImmutableBiMap.copyOf(asMap2), size);
                }
            } else {
                Map asMap3 = Maps.asMap(network.incidentEdges(n), new p31(0, network, n));
                if (network.allowsParallelEdges()) {
                    abstractC1218g3 = new AbstractC1218g3(ImmutableMap.copyOf(asMap3));
                } else {
                    abstractC1218g3 = new AbstractC1218g3(ImmutableBiMap.copyOf(asMap3));
                }
                obj = abstractC1218g3;
            }
            builder.put(n, obj);
        }
        ImmutableMap buildOrThrow = builder.buildOrThrow();
        ImmutableMap.Builder builder2 = ImmutableMap.builder();
        for (E e : network.edges()) {
            builder2.put(e, network.incidentNodes(e).nodeU());
        }
        return (ImmutableNetwork<N, E>) new ym2(from, buildOrThrow, builder2.buildOrThrow());
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.f29020b;
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.f29021c;
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public ElementOrder edgeOrder() {
        return this.f29023e;
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    @Override // p000.ym2, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public boolean isDirected() {
        return this.f29019a;
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public ElementOrder nodeOrder() {
        return this.f29022d;
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    @Override // p000.ym2, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    @Override // p000.ym2, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    @Override // p000.ym2, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }
}
