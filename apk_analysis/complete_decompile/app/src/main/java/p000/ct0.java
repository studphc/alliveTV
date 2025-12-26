package p000;

import com.google.common.graph.AbstractGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class ct0 extends AbstractGraph {
    /* renamed from: a */
    public abstract InterfaceC1304if mo4175a();

    @Override // p000.InterfaceC1304if
    public Set adjacentNodes(Object obj) {
        return mo4175a().adjacentNodes(obj);
    }

    @Override // p000.InterfaceC1304if
    public boolean allowsSelfLoops() {
        return mo4175a().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public int degree(Object obj) {
        return mo4175a().degree(obj);
    }

    @Override // p000.AbstractC1373k
    public long edgeCount() {
        return mo4175a().edges().size();
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        return mo4175a().hasEdgeConnecting(obj, obj2);
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public int inDegree(Object obj) {
        return mo4175a().inDegree(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public ElementOrder incidentEdgeOrder() {
        return mo4175a().incidentEdgeOrder();
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public Set incidentEdges(Object obj) {
        return mo4175a().incidentEdges(obj);
    }

    @Override // p000.InterfaceC1304if
    public boolean isDirected() {
        return mo4175a().isDirected();
    }

    @Override // p000.InterfaceC1304if
    public ElementOrder nodeOrder() {
        return mo4175a().nodeOrder();
    }

    @Override // p000.InterfaceC1304if
    public Set nodes() {
        return mo4175a().nodes();
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public int outDegree(Object obj) {
        return mo4175a().outDegree(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return mo4175a().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return mo4175a().predecessors(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return mo4175a().successors(obj);
    }
}
