package p000;

import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class fn2 extends AbstractValueGraph {

    /* renamed from: a */
    public final boolean f17345a;

    /* renamed from: b */
    public final boolean f17346b;

    /* renamed from: c */
    public final ElementOrder f17347c;

    /* renamed from: d */
    public final ue1 f17348d;

    /* renamed from: e */
    public long f17349e;

    public fn2(AbstractC1929w0 abstractC1929w0, Map map, long j) {
        ue1 ue1Var;
        boolean z;
        this.f17345a = abstractC1929w0.f28023a;
        this.f17346b = abstractC1929w0.f28024b;
        ElementOrder elementOrder = abstractC1929w0.f28025c;
        elementOrder.getClass();
        this.f17347c = elementOrder;
        if (map instanceof TreeMap) {
            ue1Var = new ue1(map);
        } else {
            ue1Var = new ue1(map);
        }
        this.f17348d = ue1Var;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Not true that %s is non-negative.", j);
        this.f17349e = j;
    }

    /* renamed from: a */
    public final mx0 m4818a(Object obj) {
        mx0 mx0Var = (mx0) this.f17348d.mo2094c(obj);
        if (mx0Var != null) {
            return mx0Var;
        }
        Preconditions.checkNotNull(obj);
        String valueOf = String.valueOf(obj);
        throw new IllegalArgumentException(AbstractC1726qj.m7059o("Node ", valueOf, " is not an element of this graph.", valueOf.length() + 38));
    }

    @Override // p000.InterfaceC1304if
    public Set adjacentNodes(Object obj) {
        return m4818a(obj).mo4179a();
    }

    @Override // p000.InterfaceC1304if
    public boolean allowsSelfLoops() {
        return this.f17346b;
    }

    @Override // p000.AbstractC1373k
    public long edgeCount() {
        return this.f17349e;
    }

    public Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        Object checkNotNull = Preconditions.checkNotNull(obj);
        Object checkNotNull2 = Preconditions.checkNotNull(obj2);
        mx0 mx0Var = (mx0) this.f17348d.mo2094c(checkNotNull);
        Object mo4183e = mx0Var == null ? null : mx0Var.mo4183e(checkNotNull2);
        return mo4183e == null ? obj3 : mo4183e;
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        Object checkNotNull = Preconditions.checkNotNull(obj);
        Object checkNotNull2 = Preconditions.checkNotNull(obj2);
        mx0 mx0Var = (mx0) this.f17348d.mo2094c(checkNotNull);
        return mx0Var != null && mx0Var.mo4180b().contains(checkNotNull2);
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public Set incidentEdges(Object obj) {
        return new px0(this, obj, m4818a(obj));
    }

    @Override // p000.InterfaceC1304if
    public boolean isDirected() {
        return this.f17345a;
    }

    @Override // p000.InterfaceC1304if
    public ElementOrder nodeOrder() {
        return this.f17347c;
    }

    @Override // p000.InterfaceC1304if
    public Set nodes() {
        ue1 ue1Var = this.f17348d;
        ue1Var.getClass();
        return new C1251h(3, ue1Var);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return m4818a(obj).mo4181c();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return m4818a(obj).mo4180b();
    }

    public Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        Object nodeU = endpointPair.nodeU();
        Object nodeV = endpointPair.nodeV();
        mx0 mx0Var = (mx0) this.f17348d.mo2094c(nodeU);
        Object mo4183e = mx0Var == null ? null : mx0Var.mo4183e(nodeV);
        return mo4183e == null ? obj : mo4183e;
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.AbstractC1373k, p000.InterfaceC1304if, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (isOrderingCompatible(endpointPair)) {
            Object nodeU = endpointPair.nodeU();
            Object nodeV = endpointPair.nodeV();
            mx0 mx0Var = (mx0) this.f17348d.mo2094c(nodeU);
            if (mx0Var != null && mx0Var.mo4180b().contains(nodeV)) {
                return true;
            }
        }
        return false;
    }
}
