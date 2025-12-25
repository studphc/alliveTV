package p000;

import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graphs;
import com.google.common.graph.Network;
import java.util.Set;

/* loaded from: classes2.dex */
public final class rx0 extends AbstractNetwork {

    /* renamed from: a */
    public final Network f26174a;

    public rx0(Network network) {
        this.f26174a = network;
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final Set adjacentEdges(Object obj) {
        return this.f26174a.adjacentEdges(obj);
    }

    @Override // com.google.common.graph.Network
    public final Set adjacentNodes(Object obj) {
        return this.f26174a.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.Network
    public final boolean allowsParallelEdges() {
        return this.f26174a.allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public final boolean allowsSelfLoops() {
        return this.f26174a.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final int degree(Object obj) {
        return this.f26174a.degree(obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final Object edgeConnectingOrNull(Object obj, Object obj2) {
        return this.f26174a.edgeConnectingOrNull(obj2, obj);
    }

    @Override // com.google.common.graph.Network
    public final ElementOrder edgeOrder() {
        return this.f26174a.edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public final Set edges() {
        return this.f26174a.edges();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final Set edgesConnecting(Object obj, Object obj2) {
        return this.f26174a.edgesConnecting(obj2, obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final boolean hasEdgeConnecting(Object obj, Object obj2) {
        return this.f26174a.hasEdgeConnecting(obj2, obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final int inDegree(Object obj) {
        return this.f26174a.outDegree(obj);
    }

    @Override // com.google.common.graph.Network
    public final Set inEdges(Object obj) {
        return this.f26174a.outEdges(obj);
    }

    @Override // com.google.common.graph.Network
    public final Set incidentEdges(Object obj) {
        return this.f26174a.incidentEdges(obj);
    }

    @Override // com.google.common.graph.Network
    public final EndpointPair incidentNodes(Object obj) {
        Network network = this.f26174a;
        EndpointPair incidentNodes = network.incidentNodes(obj);
        Object nodeV = incidentNodes.nodeV();
        Object nodeU = incidentNodes.nodeU();
        if (network.isDirected()) {
            return EndpointPair.ordered(nodeV, nodeU);
        }
        return EndpointPair.unordered(nodeV, nodeU);
    }

    @Override // com.google.common.graph.Network
    public final boolean isDirected() {
        return this.f26174a.isDirected();
    }

    @Override // com.google.common.graph.Network
    public final ElementOrder nodeOrder() {
        return this.f26174a.nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public final Set nodes() {
        return this.f26174a.nodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final int outDegree(Object obj) {
        return this.f26174a.inDegree(obj);
    }

    @Override // com.google.common.graph.Network
    public final Set outEdges(Object obj) {
        return this.f26174a.inEdges(obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Iterable predecessors(Object obj) {
        return this.f26174a.successors((Network) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Iterable successors(Object obj) {
        return this.f26174a.predecessors((Network) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final Object edgeConnectingOrNull(EndpointPair endpointPair) {
        return this.f26174a.edgeConnectingOrNull(Graphs.m4174c(endpointPair));
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final Set edgesConnecting(EndpointPair endpointPair) {
        return this.f26174a.edgesConnecting(Graphs.m4174c(endpointPair));
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public final boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return this.f26174a.hasEdgeConnecting(Graphs.m4174c(endpointPair));
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Set predecessors(Object obj) {
        return this.f26174a.successors((Network) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Set successors(Object obj) {
        return this.f26174a.predecessors((Network) obj);
    }
}
