package p000;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

/* loaded from: classes2.dex */
public final class vm2 extends ct0 implements MutableGraph {

    /* renamed from: a */
    public final xm2 f27874a;

    public vm2(GraphBuilder graphBuilder) {
        this.f27874a = new xm2(graphBuilder);
    }

    @Override // p000.ct0
    /* renamed from: a */
    public final InterfaceC1304if mo4175a() {
        return this.f27874a;
    }

    @Override // com.google.common.graph.MutableGraph
    public final boolean addNode(Object obj) {
        return this.f27874a.addNode(obj);
    }

    @Override // com.google.common.graph.MutableGraph
    public final boolean putEdge(Object obj, Object obj2) {
        return this.f27874a.putEdgeValue(obj, obj2, nx0.f23520a) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public final boolean removeEdge(Object obj, Object obj2) {
        return this.f27874a.removeEdge(obj, obj2) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public final boolean removeNode(Object obj) {
        return this.f27874a.removeNode(obj);
    }

    @Override // com.google.common.graph.MutableGraph
    public final boolean putEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public final boolean removeEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
