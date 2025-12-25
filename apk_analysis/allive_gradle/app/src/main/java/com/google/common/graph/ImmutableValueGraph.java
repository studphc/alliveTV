package com.google.common.graph;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1929w0;
import p000.fn2;
import p000.mx0;
import p000.p31;

@Immutable(containerOf = {"N", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@Beta
/* loaded from: classes2.dex */
public final class ImmutableValueGraph<N, V> extends fn2 {

    /* loaded from: classes2.dex */
    public static class Builder<N, V> {

        /* renamed from: a */
        public final MutableValueGraph f15039a;

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.graph.ValueGraphBuilder, w0] */
        public Builder(ValueGraphBuilder valueGraphBuilder) {
            ?? abstractC1929w0 = new AbstractC1929w0(valueGraphBuilder.f28023a);
            abstractC1929w0.f28024b = valueGraphBuilder.f28024b;
            abstractC1929w0.f28025c = valueGraphBuilder.f28025c;
            abstractC1929w0.f28027e = valueGraphBuilder.f28027e;
            abstractC1929w0.f28026d = valueGraphBuilder.f28026d;
            this.f15039a = abstractC1929w0.incidentEdgeOrder(ElementOrder.stable()).build();
        }

        @CanIgnoreReturnValue
        public Builder<N, V> addNode(N n) {
            this.f15039a.addNode(n);
            return this;
        }

        public ImmutableValueGraph<N, V> build() {
            return ImmutableValueGraph.copyOf(this.f15039a);
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(N n, N n2, V v) {
            this.f15039a.putEdgeValue(n, n2, v);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(EndpointPair<N> endpointPair, V v) {
            this.f15039a.putEdgeValue(endpointPair, v);
            return this;
        }
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        mx0 c0966e;
        if (valueGraph instanceof ImmutableValueGraph) {
            return (ImmutableValueGraph) valueGraph;
        }
        ValueGraphBuilder from = ValueGraphBuilder.from(valueGraph);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n : valueGraph.nodes()) {
            p31 p31Var = new p31(1, valueGraph, n);
            if (valueGraph.isDirected()) {
                c0966e = C0963b.m4178j(n, valueGraph.incidentEdges(n), p31Var);
            } else {
                c0966e = new C0966e(ImmutableMap.copyOf(Maps.asMap(valueGraph.adjacentNodes(n), p31Var)));
            }
            builder.put(n, c0966e);
        }
        return (ImmutableValueGraph<N, V>) new fn2(from, builder.buildOrThrow(), valueGraph.edges().size());
    }

    @Override // p000.fn2, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // p000.fn2, p000.InterfaceC1304if
    public boolean allowsSelfLoops() {
        return this.f17346b;
    }

    @Override // p000.fn2, com.google.common.graph.ValueGraph
    @CheckForNull
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, @CheckForNull Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    @Override // p000.fn2, com.google.common.graph.AbstractValueGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.stable();
    }

    @Override // p000.fn2, com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    @Override // p000.fn2, p000.InterfaceC1304if
    public boolean isDirected() {
        return this.f17345a;
    }

    @Override // p000.fn2, p000.InterfaceC1304if
    public ElementOrder nodeOrder() {
        return this.f17347c;
    }

    @Override // p000.fn2, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    @Override // p000.fn2, com.google.common.graph.AbstractValueGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    @Override // p000.fn2, com.google.common.graph.AbstractValueGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    @Override // p000.fn2, com.google.common.graph.ValueGraph
    @CheckForNull
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, @CheckForNull Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    @Override // p000.fn2, com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }
}
