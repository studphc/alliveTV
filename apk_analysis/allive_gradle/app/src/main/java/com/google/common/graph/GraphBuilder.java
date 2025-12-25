package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableGraph;
import com.google.errorprone.annotations.DoNotMock;
import p000.AbstractC1929w0;
import p000.vm2;

@DoNotMock
@Beta
/* loaded from: classes2.dex */
public final class GraphBuilder<N> extends AbstractC1929w0 {
    /* JADX WARN: Type inference failed for: r0v0, types: [w0, com.google.common.graph.GraphBuilder<java.lang.Object>] */
    public static GraphBuilder<Object> directed() {
        return new AbstractC1929w0(true);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [w0, com.google.common.graph.GraphBuilder] */
    public static <N> GraphBuilder<N> from(Graph<N> graph) {
        return new AbstractC1929w0(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder()).incidentEdgeOrder(graph.incidentEdgeOrder());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [w0, com.google.common.graph.GraphBuilder<java.lang.Object>] */
    public static GraphBuilder<Object> undirected() {
        return new AbstractC1929w0(false);
    }

    public GraphBuilder<N> allowsSelfLoops(boolean z) {
        this.f28024b = z;
        return this;
    }

    public <N1 extends N> MutableGraph<N1> build() {
        return new vm2(this);
    }

    public GraphBuilder<N> expectedNodeCount(int i) {
        Graphs.m4172a(i);
        this.f28027e = Optional.m3770of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N> ImmutableGraph.Builder<N1> immutable() {
        return new ImmutableGraph.Builder<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> GraphBuilder<N1> incidentEdgeOrder(ElementOrder<N1> elementOrder) {
        boolean z;
        if (elementOrder.type() != ElementOrder.Type.UNORDERED && elementOrder.type() != ElementOrder.Type.STABLE) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        this.f28026d = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> elementOrder) {
        this.f28025c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }
}
