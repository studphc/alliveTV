package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1373k;
import p000.C1251h;
import p000.d41;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractGraph<N> extends AbstractC1373k implements Graph<N> {
    @Override // p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public Set edges() {
        return new C1251h(0, this);
    }

    @Override // com.google.common.graph.Graph
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Graph)) {
            return false;
        }
        Graph graph = (Graph) obj;
        if (isDirected() == graph.isDirected() && nodes().equals(graph.nodes()) && edges().equals(graph.edges())) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.Graph
    public final int hashCode() {
        return edges().hashCode();
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public int inDegree(Object obj) {
        if (isDirected()) {
            return predecessors(obj).size();
        }
        return degree(obj);
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public ElementOrder incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public Set incidentEdges(Object obj) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkArgument(nodes().contains(obj), "Node %s is not an element of this graph.", obj);
        return new d41(this, obj);
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public int outDegree(Object obj) {
        if (isDirected()) {
            return successors(obj).size();
        }
        return degree(obj);
    }

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        Iterable predecessors;
        predecessors = predecessors((AbstractGraph<N>) ((Graph) obj));
        return predecessors;
    }

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        Iterable successors;
        successors = successors((AbstractGraph<N>) ((Graph) obj));
        return successors;
    }

    public String toString() {
        boolean isDirected = isDirected();
        boolean allowsSelfLoops = allowsSelfLoops();
        String valueOf = String.valueOf(nodes());
        String valueOf2 = String.valueOf(edges());
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 59);
        sb.append("isDirected: ");
        sb.append(isDirected);
        sb.append(", allowsSelfLoops: ");
        sb.append(allowsSelfLoops);
        sb.append(", nodes: ");
        sb.append(valueOf);
        sb.append(", edges: ");
        sb.append(valueOf2);
        return sb.toString();
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        return nodes().contains(obj) && successors(obj).contains(obj2);
    }
}
