package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableValueGraph;
import p000.AbstractC1929w0;
import p000.xm2;

@Beta
/* loaded from: classes2.dex */
public final class ValueGraphBuilder<N, V> extends AbstractC1929w0 {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.graph.ValueGraphBuilder<java.lang.Object, java.lang.Object>, w0] */
    public static ValueGraphBuilder<Object, Object> directed() {
        return new AbstractC1929w0(true);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.graph.ValueGraphBuilder, w0] */
    public static <N, V> ValueGraphBuilder<N, V> from(ValueGraph<N, V> valueGraph) {
        return new AbstractC1929w0(valueGraph.isDirected()).allowsSelfLoops(valueGraph.allowsSelfLoops()).nodeOrder(valueGraph.nodeOrder()).incidentEdgeOrder(valueGraph.incidentEdgeOrder());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.graph.ValueGraphBuilder<java.lang.Object, java.lang.Object>, w0] */
    public static ValueGraphBuilder<Object, Object> undirected() {
        return new AbstractC1929w0(false);
    }

    public ValueGraphBuilder<N, V> allowsSelfLoops(boolean z) {
        this.f28024b = z;
        return this;
    }

    public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> build() {
        return new xm2(this);
    }

    public ValueGraphBuilder<N, V> expectedNodeCount(int i) {
        Graphs.m4172a(i);
        this.f28027e = Optional.m3770of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N, V1 extends V> ImmutableValueGraph.Builder<N1, V1> immutable() {
        return new ImmutableValueGraph.Builder<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> ValueGraphBuilder<N1, V> incidentEdgeOrder(ElementOrder<N1> elementOrder) {
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
    public <N1 extends N> ValueGraphBuilder<N1, V> nodeOrder(ElementOrder<N1> elementOrder) {
        this.f28025c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }
}
