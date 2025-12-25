package p000;

import com.google.common.base.Preconditions;
import com.google.common.graph.EndpointPair;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class d41 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f16240a = 1;

    /* renamed from: b */
    public final Object f16241b;

    /* renamed from: c */
    public final Object f16242c;

    public d41(AbstractC1373k abstractC1373k, Object obj) {
        this.f16242c = abstractC1373k;
        this.f16241b = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f16240a) {
            case 0:
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                AbstractC1373k abstractC1373k = (AbstractC1373k) this.f16242c;
                boolean isDirected = abstractC1373k.isDirected();
                Object obj2 = this.f16241b;
                if (isDirected) {
                    if (!endpointPair.isOrdered()) {
                        return false;
                    }
                    Object source = endpointPair.source();
                    Object target = endpointPair.target();
                    if ((!obj2.equals(source) || !abstractC1373k.successors(obj2).contains(target)) && (!obj2.equals(target) || !abstractC1373k.predecessors(obj2).contains(source))) {
                        return false;
                    }
                } else {
                    if (endpointPair.isOrdered()) {
                        return false;
                    }
                    Set adjacentNodes = abstractC1373k.adjacentNodes(obj2);
                    Object nodeU = endpointPair.nodeU();
                    Object nodeV = endpointPair.nodeV();
                    if ((!obj2.equals(nodeV) || !adjacentNodes.contains(nodeU)) && (!obj2.equals(nodeU) || !adjacentNodes.contains(nodeV))) {
                        return false;
                    }
                }
                return true;
            default:
                return this.f16241b.equals(((Map) this.f16242c).get(obj));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new C0566bq(this, ((Map) this.f16242c).entrySet().iterator(), 5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f16240a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        AbstractC1373k abstractC1373k = (AbstractC1373k) this.f16242c;
        boolean isDirected = abstractC1373k.isDirected();
        Object obj = this.f16241b;
        if (isDirected) {
            return (abstractC1373k.outDegree(obj) + abstractC1373k.inDegree(obj)) - (abstractC1373k.successors(obj).contains(obj) ? 1 : 0);
        }
        return abstractC1373k.adjacentNodes(obj).size();
    }

    public d41(Map map, Object obj) {
        this.f16242c = (Map) Preconditions.checkNotNull(map);
        this.f16241b = Preconditions.checkNotNull(obj);
    }
}
