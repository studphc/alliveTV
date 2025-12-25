package p000;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractC0962a;
import com.google.common.graph.AbstractC0965d;
import com.google.common.graph.C0963b;
import com.google.common.graph.C0966e;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableValueGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class xm2 extends fn2 implements MutableValueGraph {

    /* renamed from: f */
    public final ElementOrder f28630f;

    public xm2(AbstractC1929w0 abstractC1929w0) {
        super(abstractC1929w0, abstractC1929w0.f28025c.m4171a(((Integer) abstractC1929w0.f28027e.mo3773or((Optional) 10)).intValue()), 0L);
        ElementOrder elementOrder = abstractC1929w0.f28026d;
        elementOrder.getClass();
        this.f28630f = elementOrder;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public final boolean addNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        if (this.f17348d.m7702b(obj)) {
            return false;
        }
        m8173b(obj);
        return true;
    }

    /* renamed from: b */
    public final mx0 m8173b(Object obj) {
        C0966e c0966e;
        mx0 mx0Var;
        ArrayList arrayList;
        boolean z = this.f17345a;
        boolean z2 = false;
        ElementOrder elementOrder = this.f28630f;
        if (z) {
            int i = AbstractC0962a.f15044a[elementOrder.type().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    arrayList = new ArrayList();
                } else {
                    throw new AssertionError(elementOrder.type());
                }
            } else {
                arrayList = null;
            }
            mx0Var = new C0963b(new HashMap(4, 1.0f), arrayList, 0, 0);
        } else {
            int i2 = AbstractC0965d.f15051a[elementOrder.type().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    c0966e = new C0966e(new LinkedHashMap(2, 1.0f));
                } else {
                    throw new AssertionError(elementOrder.type());
                }
            } else {
                c0966e = new C0966e(new HashMap(2, 1.0f));
            }
            mx0Var = c0966e;
        }
        ue1 ue1Var = this.f17348d;
        ue1Var.getClass();
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(mx0Var);
        ue1Var.mo2093a();
        if (ue1Var.f27239a.put(obj, mx0Var) == null) {
            z2 = true;
        }
        Preconditions.checkState(z2);
        return mx0Var;
    }

    @Override // com.google.common.graph.AbstractValueGraph, p000.InterfaceC1304if, com.google.common.graph.Graph
    public final ElementOrder incidentEdgeOrder() {
        return this.f28630f;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public final Object putEdgeValue(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        Preconditions.checkNotNull(obj3, "value");
        if (!this.f17346b) {
            Preconditions.checkArgument(!obj.equals(obj2), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", obj);
        }
        ue1 ue1Var = this.f17348d;
        mx0 mx0Var = (mx0) ue1Var.mo2094c(obj);
        if (mx0Var == null) {
            mx0Var = m8173b(obj);
        }
        Object mo4186h = mx0Var.mo4186h(obj2, obj3);
        mx0 mx0Var2 = (mx0) ue1Var.mo2094c(obj2);
        if (mx0Var2 == null) {
            mx0Var2 = m8173b(obj2);
        }
        mx0Var2.mo4187i(obj, obj3);
        if (mo4186h == null) {
            long j = this.f17349e + 1;
            this.f17349e = j;
            Preconditions.checkArgument(j > 0, "Not true that %s is positive.", j);
        }
        return mo4186h;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public final Object removeEdge(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        ue1 ue1Var = this.f17348d;
        mx0 mx0Var = (mx0) ue1Var.mo2094c(obj);
        mx0 mx0Var2 = (mx0) ue1Var.mo2094c(obj2);
        if (mx0Var == null || mx0Var2 == null) {
            return null;
        }
        Object mo4182d = mx0Var.mo4182d(obj2);
        if (mo4182d != null) {
            mx0Var2.mo4184f(obj);
            long j = this.f17349e - 1;
            this.f17349e = j;
            Preconditions.checkArgument(j >= 0, "Not true that %s is non-negative.", j);
        }
        return mo4182d;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public final boolean removeNode(Object obj) {
        Map map;
        boolean z;
        Preconditions.checkNotNull(obj, "node");
        ue1 ue1Var = this.f17348d;
        mx0 mx0Var = (mx0) ue1Var.mo2094c(obj);
        boolean z2 = false;
        if (mx0Var == null) {
            return false;
        }
        if (this.f17346b && mx0Var.mo4182d(obj) != null) {
            mx0Var.mo4184f(obj);
            this.f17349e--;
        }
        Iterator it = mx0Var.mo4180b().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            map = ue1Var.f27239a;
            if (!hasNext) {
                break;
            }
            Object next = it.next();
            Preconditions.checkNotNull(next);
            mx0 mx0Var2 = (mx0) map.get(next);
            Objects.requireNonNull(mx0Var2);
            mx0Var2.mo4184f(obj);
            this.f17349e--;
        }
        if (this.f17345a) {
            for (Object obj2 : mx0Var.mo4181c()) {
                Preconditions.checkNotNull(obj2);
                mx0 mx0Var3 = (mx0) map.get(obj2);
                Objects.requireNonNull(mx0Var3);
                if (mx0Var3.mo4182d(obj) != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                this.f17349e--;
            }
        }
        Preconditions.checkNotNull(obj);
        ue1Var.mo2093a();
        map.remove(obj);
        long j = this.f17349e;
        if (j >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Not true that %s is non-negative.", j);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public final Object removeEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    public final Object putEdgeValue(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }
}
