package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.NetworkBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public abstract class ym2 extends AbstractNetwork {

    /* renamed from: a */
    public final boolean f29019a;

    /* renamed from: b */
    public final boolean f29020b;

    /* renamed from: c */
    public final boolean f29021c;

    /* renamed from: d */
    public final ElementOrder f29022d;

    /* renamed from: e */
    public final ElementOrder f29023e;

    /* renamed from: f */
    public final ue1 f29024f;

    /* renamed from: g */
    public final ue1 f29025g;

    public ym2(NetworkBuilder networkBuilder, Map map, Map map2) {
        ue1 ue1Var;
        this.f29019a = networkBuilder.f28023a;
        this.f29020b = networkBuilder.f15040f;
        this.f29021c = networkBuilder.f28024b;
        ElementOrder elementOrder = networkBuilder.f28025c;
        elementOrder.getClass();
        this.f29022d = elementOrder;
        ElementOrder elementOrder2 = networkBuilder.f15041g;
        elementOrder2.getClass();
        this.f29023e = elementOrder2;
        if (map instanceof TreeMap) {
            ue1Var = new ue1(map);
        } else {
            ue1Var = new ue1(map);
        }
        this.f29024f = ue1Var;
        this.f29025g = new ue1(map2);
    }

    /* renamed from: a */
    public final mr1 m8312a(Object obj) {
        mr1 mr1Var = (mr1) this.f29024f.mo2094c(obj);
        if (mr1Var != null) {
            return mr1Var;
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", obj));
    }

    @Override // com.google.common.graph.Network
    public Set adjacentNodes(Object obj) {
        return m8312a(obj).mo6243a();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.f29020b;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.f29021c;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder edgeOrder() {
        return this.f29023e;
    }

    @Override // com.google.common.graph.Network
    public Set edges() {
        ue1 ue1Var = this.f29025g;
        ue1Var.getClass();
        return new C1251h(3, ue1Var);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set edgesConnecting(Object obj, Object obj2) {
        mr1 m8312a = m8312a(obj);
        if (!this.f29021c && obj == obj2) {
            return ImmutableSet.m3971of();
        }
        Preconditions.checkArgument(this.f29024f.m7702b(obj2), "Node %s is not an element of this graph.", obj2);
        return m8312a.mo6050k(obj2);
    }

    @Override // com.google.common.graph.Network
    public Set inEdges(Object obj) {
        return m8312a(obj).mo4907g();
    }

    @Override // com.google.common.graph.Network
    public Set incidentEdges(Object obj) {
        return m8312a(obj).mo4905e();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair incidentNodes(Object obj) {
        Object mo2094c = this.f29025g.mo2094c(obj);
        if (mo2094c != null) {
            mr1 mr1Var = (mr1) this.f29024f.mo2094c(mo2094c);
            Objects.requireNonNull(mr1Var);
            Object mo4906f = mr1Var.mo4906f(obj);
            if (isDirected()) {
                return EndpointPair.ordered(mo2094c, mo4906f);
            }
            return EndpointPair.unordered(mo2094c, mo4906f);
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", obj));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.f29019a;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder nodeOrder() {
        return this.f29022d;
    }

    @Override // com.google.common.graph.Network
    public Set nodes() {
        ue1 ue1Var = this.f29024f;
        ue1Var.getClass();
        return new C1251h(3, ue1Var);
    }

    @Override // com.google.common.graph.Network
    public Set outEdges(Object obj) {
        return m8312a(obj).mo4909i();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return m8312a(obj).mo4903c();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return m8312a(obj).mo4902b();
    }
}
