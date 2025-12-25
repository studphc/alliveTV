package p000;

import androidx.collection.ArrayMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.EndpointPair;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: h */
/* loaded from: classes2.dex */
public final class C1251h extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f17895a;

    /* renamed from: b */
    public final /* synthetic */ Object f17896b;

    public /* synthetic */ C1251h(int i, Object obj) {
        this.f17895a = i;
        this.f17896b = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        switch (this.f17895a) {
            case 4:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    ((yd3) this.f17896b).put((Comparable) entry.getKey(), entry.getValue());
                    return true;
                }
                return false;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f17895a) {
            case 4:
                ((yd3) this.f17896b).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f17895a) {
            case 0:
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                AbstractC1373k abstractC1373k = (AbstractC1373k) this.f17896b;
                if (!abstractC1373k.isOrderingCompatible(endpointPair) || !abstractC1373k.nodes().contains(endpointPair.nodeU()) || !abstractC1373k.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            case 1:
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair2 = (EndpointPair) obj;
                C1339j2 c1339j2 = (C1339j2) this.f17896b;
                if (!c1339j2.isOrderingCompatible(endpointPair2) || !((AbstractNetwork) c1339j2.f20348b).nodes().contains(endpointPair2.nodeU())) {
                    return false;
                }
                if (!((AbstractNetwork) c1339j2.f20348b).successors((AbstractNetwork) endpointPair2.nodeU()).contains(endpointPair2.nodeV())) {
                    return false;
                }
                return true;
            case 2:
            default:
                return super.contains(obj);
            case 3:
                return ((ue1) this.f17896b).m7702b(obj);
            case 4:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((yd3) this.f17896b).get(entry.getKey());
                Object value = entry.getValue();
                boolean z = true;
                if (obj2 != value) {
                    if (obj2 != null) {
                        if (!obj2.equals(value)) {
                            return false;
                        }
                    } else {
                        z = false;
                    }
                }
                return z;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, d90, c90] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f17895a) {
            case 0:
                AbstractC1373k abstractC1373k = (AbstractC1373k) this.f17896b;
                if (abstractC1373k.isDirected()) {
                    return new d90(abstractC1373k);
                }
                ?? d90Var = new d90(abstractC1373k);
                d90Var.f8293g = Sets.newHashSetWithExpectedSize(abstractC1373k.nodes().size() + 1);
                return d90Var;
            case 1:
                return Iterators.transform(((AbstractNetwork) ((C1339j2) this.f17896b).f20348b).edges().iterator(), new C1291i2(0, this));
            case 2:
                return new C1263hb((ArrayMap) this.f17896b);
            case 3:
                return new h31(this, ((ue1) this.f17896b).f27239a.entrySet().iterator());
            default:
                return new ae3((yd3) this.f17896b);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f17895a) {
            case 0:
                throw new UnsupportedOperationException();
            case 4:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    ((yd3) this.f17896b).remove(entry.getKey());
                    return true;
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f17895a) {
            case 0:
                return Ints.saturatedCast(((AbstractC1373k) this.f17896b).edgeCount());
            case 1:
                return ((AbstractNetwork) ((C1339j2) this.f17896b).f20348b).edges().size();
            case 2:
                return ((ArrayMap) this.f17896b).getF1755c();
            case 3:
                return ((ue1) this.f17896b).f27239a.size();
            default:
                return ((yd3) this.f17896b).size();
        }
    }
}
