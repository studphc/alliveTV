package p000;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import com.google.common.graph.Graphs;
import java.util.Set;

/* loaded from: classes2.dex */
public final class qx0 extends ct0 {

    /* renamed from: a */
    public final Graph f25787a;

    public qx0(Graph graph) {
        this.f25787a = graph;
    }

    @Override // p000.ct0
    /* renamed from: a */
    public final InterfaceC1304if mo4175a() {
        return this.f25787a;
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final boolean hasEdgeConnecting(Object obj, Object obj2) {
        return this.f25787a.hasEdgeConnecting(obj2, obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final int inDegree(Object obj) {
        return this.f25787a.outDegree(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final Set incidentEdges(Object obj) {
        return new px0(this, this, obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final int outDegree(Object obj) {
        return this.f25787a.inDegree(obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Iterable predecessors(Object obj) {
        return this.f25787a.successors((Graph) obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Iterable successors(Object obj) {
        return this.f25787a.predecessors((Graph) obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return this.f25787a.hasEdgeConnecting(Graphs.m4174c(endpointPair));
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Set predecessors(Object obj) {
        return this.f25787a.successors((Graph) obj);
    }

    @Override // p000.ct0, com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Set successors(Object obj) {
        return this.f25787a.predecessors((Graph) obj);
    }
}
