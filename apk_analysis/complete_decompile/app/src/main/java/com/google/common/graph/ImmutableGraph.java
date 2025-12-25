package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
import p000.AbstractC1929w0;
import p000.InterfaceC1304if;
import p000.ct0;
import p000.fn2;
import p000.mx0;
import p000.nx0;

@Immutable(containerOf = {"N"})
@Beta
/* loaded from: classes2.dex */
public class ImmutableGraph<N> extends ct0 {

    /* renamed from: a */
    public final InterfaceC1304if f15036a;

    /* loaded from: classes2.dex */
    public static class Builder<N> {

        /* renamed from: a */
        public final MutableGraph f15037a;

        /* JADX WARN: Type inference failed for: r0v0, types: [w0, com.google.common.graph.GraphBuilder] */
        public Builder(GraphBuilder graphBuilder) {
            ?? abstractC1929w0 = new AbstractC1929w0(graphBuilder.f28023a);
            abstractC1929w0.f28024b = graphBuilder.f28024b;
            abstractC1929w0.f28025c = graphBuilder.f28025c;
            abstractC1929w0.f28027e = graphBuilder.f28027e;
            abstractC1929w0.f28026d = graphBuilder.f28026d;
            this.f15037a = abstractC1929w0.incidentEdgeOrder(ElementOrder.stable()).build();
        }

        @CanIgnoreReturnValue
        public Builder<N> addNode(N n) {
            this.f15037a.addNode(n);
            return this;
        }

        public ImmutableGraph<N> build() {
            return ImmutableGraph.copyOf(this.f15037a);
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(N n, N n2) {
            this.f15037a.putEdge(n, n2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(EndpointPair<N> endpointPair) {
            this.f15037a.putEdge(endpointPair);
            return this;
        }
    }

    public ImmutableGraph(InterfaceC1304if interfaceC1304if) {
        this.f15036a = interfaceC1304if;
    }

    public static <N> ImmutableGraph<N> copyOf(Graph<N> graph) {
        mx0 c0966e;
        if (graph instanceof ImmutableGraph) {
            return (ImmutableGraph) graph;
        }
        GraphBuilder from = GraphBuilder.from(graph);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n : graph.nodes()) {
            Function constant = Functions.constant(nx0.f23520a);
            if (graph.isDirected()) {
                c0966e = C0963b.m4178j(n, graph.incidentEdges(n), constant);
            } else {
                c0966e = new C0966e(ImmutableMap.copyOf(Maps.asMap(graph.adjacentNodes(n), constant)));
            }
            builder.put(n, c0966e);
        }
        return new ImmutableGraph<>(new fn2(from, builder.buildOrThrow(), graph.edges().size()));
    }

    @Override // p000.ct0
    /* renamed from: a */
    public final InterfaceC1304if mo4175a() {
        return this.f15036a;
    }

    @Override // p000.ct0, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // p000.ct0, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.stable();
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    @Override // p000.ct0, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // p000.ct0, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // p000.ct0, p000.InterfaceC1304if
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Deprecated
    public static <N> ImmutableGraph<N> copyOf(ImmutableGraph<N> immutableGraph) {
        return (ImmutableGraph) Preconditions.checkNotNull(immutableGraph);
    }
}
