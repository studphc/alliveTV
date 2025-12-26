package p000;

import com.google.common.graph.AbstractGraph;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import java.util.Set;

/* renamed from: j2 */
/* loaded from: classes2.dex */
public final class C1339j2 extends AbstractGraph {

    /* renamed from: a */
    public final /* synthetic */ int f20347a;

    /* renamed from: b */
    public final /* synthetic */ Object f20348b;

    public /* synthetic */ C1339j2(int i, Object obj) {
        this.f20347a = i;
        this.f20348b = obj;
    }

    @Override // p000.InterfaceC1304if
    public final Set adjacentNodes(Object obj) {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).adjacentNodes(obj);
            default:
                return ((AbstractValueGraph) this.f20348b).adjacentNodes(obj);
        }
    }

    @Override // p000.InterfaceC1304if
    public final boolean allowsSelfLoops() {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).allowsSelfLoops();
            default:
                return ((AbstractValueGraph) this.f20348b).allowsSelfLoops();
        }
    }

    @Override // com.google.common.graph.AbstractGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public int degree(Object obj) {
        switch (this.f20347a) {
            case 1:
                return ((AbstractValueGraph) this.f20348b).degree(obj);
            default:
                return super.degree(obj);
        }
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final Set edges() {
        switch (this.f20347a) {
            case 0:
                if (((AbstractNetwork) this.f20348b).allowsParallelEdges()) {
                    return super.edges();
                }
                return new C1251h(1, this);
            default:
                return ((AbstractValueGraph) this.f20348b).edges();
        }
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public int inDegree(Object obj) {
        switch (this.f20347a) {
            case 1:
                return ((AbstractValueGraph) this.f20348b).inDegree(obj);
            default:
                return super.inDegree(obj);
        }
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final ElementOrder incidentEdgeOrder() {
        switch (this.f20347a) {
            case 0:
                return ElementOrder.unordered();
            default:
                return ((AbstractValueGraph) this.f20348b).incidentEdgeOrder();
        }
    }

    @Override // p000.InterfaceC1304if
    public final boolean isDirected() {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).isDirected();
            default:
                return ((AbstractValueGraph) this.f20348b).isDirected();
        }
    }

    @Override // p000.InterfaceC1304if
    public final ElementOrder nodeOrder() {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).nodeOrder();
            default:
                return ((AbstractValueGraph) this.f20348b).nodeOrder();
        }
    }

    @Override // p000.InterfaceC1304if
    public final Set nodes() {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).nodes();
            default:
                return ((AbstractValueGraph) this.f20348b).nodes();
        }
    }

    @Override // com.google.common.graph.AbstractGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public int outDegree(Object obj) {
        switch (this.f20347a) {
            case 1:
                return ((AbstractValueGraph) this.f20348b).outDegree(obj);
            default:
                return super.outDegree(obj);
        }
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Iterable predecessors(Object obj) {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).predecessors((AbstractNetwork) obj);
            default:
                return ((AbstractValueGraph) this.f20348b).predecessors((AbstractValueGraph) obj);
        }
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Iterable successors(Object obj) {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).successors((AbstractNetwork) obj);
            default:
                return ((AbstractValueGraph) this.f20348b).successors((AbstractValueGraph) obj);
        }
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public final Set predecessors(Object obj) {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).predecessors((AbstractNetwork) obj);
            default:
                return ((AbstractValueGraph) this.f20348b).predecessors((AbstractValueGraph) obj);
        }
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Set successors(Object obj) {
        switch (this.f20347a) {
            case 0:
                return ((AbstractNetwork) this.f20348b).successors((AbstractNetwork) obj);
            default:
                return ((AbstractValueGraph) this.f20348b).successors((AbstractValueGraph) obj);
        }
    }
}
