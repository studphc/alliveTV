package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.InterfaceC1304if;

@DoNotMock("Use GraphBuilder to create a real instance")
@Beta
/* loaded from: classes2.dex */
public interface Graph<N> extends InterfaceC1304if {
    @Override // p000.InterfaceC1304if
    Set<N> adjacentNodes(N n);

    @Override // p000.InterfaceC1304if
    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean equals(@CheckForNull Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N n);

    @Override // p000.InterfaceC1304if
    boolean isDirected();

    @Override // p000.InterfaceC1304if
    ElementOrder<N> nodeOrder();

    @Override // p000.InterfaceC1304if
    Set<N> nodes();

    int outDegree(N n);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // p000.InterfaceC1304if, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // p000.InterfaceC1304if, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);
}
