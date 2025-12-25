package p000;

import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graphs;
import com.google.common.graph.ValueGraph;
import java.util.Set;

/* loaded from: classes2.dex */
public final class sx0 extends AbstractValueGraph {

    /* renamed from: a */
    public final ValueGraph f26610a;

    public sx0(ValueGraph valueGraph) {
        this.f26610a = valueGraph;
    }

    @Override // p000.InterfaceC1304if
    public final Set adjacentNodes(Object obj) {
        return this.f26610a.adjacentNodes(obj);
    }

    @Override // p000.InterfaceC1304if
    public final boolean allowsSelfLoops() {
        return this.f26610a.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final int degree(Object obj) {
        return this.f26610a.degree(obj);
    }

    @Override // p000.AbstractC1373k
    public final long edgeCount() {
        return this.f26610a.edges().size();
    }

    @Override // com.google.common.graph.ValueGraph
    public final Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        return this.f26610a.edgeValueOrDefault(obj2, obj, obj3);
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final boolean hasEdgeConnecting(Object obj, Object obj2) {
        return this.f26610a.hasEdgeConnecting(obj2, obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final int inDegree(Object obj) {
        return this.f26610a.outDegree(obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final ElementOrder incidentEdgeOrder() {
        return this.f26610a.incidentEdgeOrder();
    }

    @Override // p000.InterfaceC1304if
    public final boolean isDirected() {
        return this.f26610a.isDirected();
    }

    @Override // p000.InterfaceC1304if
    public final ElementOrder nodeOrder() {
        return this.f26610a.nodeOrder();
    }

    @Override // p000.InterfaceC1304if
    public final Set nodes() {
        return this.f26610a.nodes();
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final int outDegree(Object obj) {
        return this.f26610a.inDegree(obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Iterable predecessors(Object obj) {
        return this.f26610a.successors((ValueGraph) obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Iterable successors(Object obj) {
        return this.f26610a.predecessors((ValueGraph) obj);
    }

    @Override // com.google.common.graph.ValueGraph
    public final Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
        return this.f26610a.edgeValueOrDefault(Graphs.m4174c(endpointPair), obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return this.f26610a.hasEdgeConnecting(Graphs.m4174c(endpointPair));
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Set predecessors(Object obj) {
        return this.f26610a.successors((ValueGraph) obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Set successors(Object obj) {
        return this.f26610a.predecessors((ValueGraph) obj);
    }
}
