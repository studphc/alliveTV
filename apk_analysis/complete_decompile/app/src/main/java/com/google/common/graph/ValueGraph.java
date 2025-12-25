package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.InterfaceC1304if;

@Beta
/* loaded from: classes2.dex */
public interface ValueGraph<N, V> extends InterfaceC1304if {
    @Override // p000.InterfaceC1304if
    Set<N> adjacentNodes(N n);

    @Override // p000.InterfaceC1304if
    boolean allowsSelfLoops();

    Graph<N> asGraph();

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    int degree(N n);

    @CheckForNull
    V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v);

    @CheckForNull
    V edgeValueOrDefault(N n, N n2, @CheckForNull V v);

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    Set<EndpointPair<N>> edges();

    boolean equals(@CheckForNull Object obj);

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    int inDegree(N n);

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    ElementOrder<N> incidentEdgeOrder();

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    Set<EndpointPair<N>> incidentEdges(N n);

    @Override // p000.InterfaceC1304if
    boolean isDirected();

    @Override // p000.InterfaceC1304if
    ElementOrder<N> nodeOrder();

    @Override // p000.InterfaceC1304if
    Set<N> nodes();

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    int outDegree(N n);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // p000.InterfaceC1304if, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // p000.InterfaceC1304if, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);
}
