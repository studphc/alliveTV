package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class wm2 extends ym2 implements MutableNetwork {
    @Override // com.google.common.graph.MutableNetwork
    public final boolean addEdge(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        Preconditions.checkNotNull(obj3, "edge");
        ue1 ue1Var = this.f29025g;
        if (ue1Var.m7702b(obj3)) {
            EndpointPair incidentNodes = incidentNodes(obj3);
            EndpointPair ordered = isDirected() ? EndpointPair.ordered(obj, obj2) : EndpointPair.unordered(obj, obj2);
            Preconditions.checkArgument(incidentNodes.equals(ordered), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", obj3, incidentNodes, ordered);
            return false;
        }
        ue1 ue1Var2 = this.f29024f;
        mr1 mr1Var = (mr1) ue1Var2.mo2094c(obj);
        if (!this.f29020b) {
            Preconditions.checkArgument(mr1Var == null || !mr1Var.mo4902b().contains(obj2), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", obj, obj2);
        }
        boolean equals = obj.equals(obj2);
        if (!this.f29021c) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", obj);
        }
        if (mr1Var == null) {
            mr1Var = m8068b(obj);
        }
        mr1Var.mo4910j(obj3, obj2);
        mr1 mr1Var2 = (mr1) ue1Var2.mo2094c(obj2);
        if (mr1Var2 == null) {
            mr1Var2 = m8068b(obj2);
        }
        mr1Var2.mo4911l(obj3, obj, equals);
        Preconditions.checkNotNull(obj3);
        Preconditions.checkNotNull(obj);
        ue1Var.mo2093a();
        ue1Var.f27239a.put(obj3, obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public final boolean addNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        if (this.f29024f.m7702b(obj)) {
            return false;
        }
        m8068b(obj);
        return true;
    }

    /* renamed from: b */
    public final mr1 m8068b(Object obj) {
        mr1 abstractC1218g3;
        boolean z = this.f29019a;
        boolean z2 = false;
        boolean z3 = this.f29020b;
        if (z) {
            if (z3) {
                abstractC1218g3 = new AbstractC2039z(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
            } else {
                abstractC1218g3 = new AbstractC2039z(HashBiMap.create(2), HashBiMap.create(2), 0);
            }
        } else if (z3) {
            abstractC1218g3 = new AbstractC1218g3(new HashMap(2, 1.0f));
        } else {
            abstractC1218g3 = new AbstractC1218g3(HashBiMap.create(2));
        }
        ue1 ue1Var = this.f29024f;
        ue1Var.getClass();
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(abstractC1218g3);
        ue1Var.mo2093a();
        if (ue1Var.f27239a.put(obj, abstractC1218g3) == null) {
            z2 = true;
        }
        Preconditions.checkState(z2);
        return abstractC1218g3;
    }

    @Override // com.google.common.graph.MutableNetwork
    public final boolean removeEdge(Object obj) {
        Preconditions.checkNotNull(obj, "edge");
        ue1 ue1Var = this.f29025g;
        Object mo2094c = ue1Var.mo2094c(obj);
        boolean z = false;
        if (mo2094c == null) {
            return false;
        }
        ue1 ue1Var2 = this.f29024f;
        mr1 mr1Var = (mr1) ue1Var2.mo2094c(mo2094c);
        Objects.requireNonNull(mr1Var);
        Object mo4906f = mr1Var.mo4906f(obj);
        mr1 mr1Var2 = (mr1) ue1Var2.mo2094c(mo4906f);
        Objects.requireNonNull(mr1Var2);
        mr1Var.mo4908h(obj);
        if (this.f29021c && mo2094c.equals(mo4906f)) {
            z = true;
        }
        mr1Var2.mo4904d(obj, z);
        Preconditions.checkNotNull(obj);
        ue1Var.mo2093a();
        ue1Var.f27239a.remove(obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public final boolean removeNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        ue1 ue1Var = this.f29024f;
        mr1 mr1Var = (mr1) ue1Var.mo2094c(obj);
        if (mr1Var == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf((Collection) mr1Var.mo4905e()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        Preconditions.checkNotNull(obj);
        ue1Var.mo2093a();
        ue1Var.f27239a.remove(obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public final boolean addEdge(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }
}
