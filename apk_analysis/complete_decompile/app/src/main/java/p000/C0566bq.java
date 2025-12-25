package p000;

import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.C0855c3;
import com.google.common.collect.C0932s2;
import com.google.common.collect.C0936t2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeTraverser;
import com.google.common.graph.EndpointPair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: bq */
/* loaded from: classes.dex */
public final class C0566bq extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ int f8123c;

    /* renamed from: d */
    public Object f8124d;

    /* renamed from: e */
    public final Object f8125e;

    public /* synthetic */ C0566bq(Object obj, Iterator it, int i) {
        this.f8123c = i;
        this.f8125e = obj;
        this.f8124d = it;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Comparator comparator;
        j40 j40Var;
        EndpointPair endpointPair;
        Object key;
        Collection m6135i;
        Object next;
        Map.Entry entry;
        Object next2;
        Object next3;
        Map.Entry entry2;
        gw2 gw2Var;
        Range range;
        AbstractC1814sx abstractC1814sx;
        jw2 jw2Var;
        switch (this.f8123c) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f8124d;
                if (arrayList == null) {
                    return (List) endOfData();
                }
                ImmutableList copyOf = ImmutableList.copyOf((Collection) arrayList);
                Objects.requireNonNull((ArrayList) this.f8124d);
                int size = ((ArrayList) this.f8124d).size() - 2;
                while (true) {
                    comparator = (Comparator) this.f8125e;
                    if (size >= 0) {
                        if (comparator.compare(((ArrayList) this.f8124d).get(size), ((ArrayList) this.f8124d).get(size + 1)) >= 0) {
                            size--;
                        }
                    } else {
                        size = -1;
                    }
                }
                if (size == -1) {
                    this.f8124d = null;
                    return copyOf;
                }
                Objects.requireNonNull((ArrayList) this.f8124d);
                Objects.requireNonNull((ArrayList) this.f8124d);
                Object obj = ((ArrayList) this.f8124d).get(size);
                for (int size2 = ((ArrayList) this.f8124d).size() - 1; size2 > size; size2--) {
                    if (comparator.compare(obj, ((ArrayList) this.f8124d).get(size2)) < 0) {
                        Collections.swap((ArrayList) this.f8124d, size, size2);
                        Collections.reverse(((ArrayList) this.f8124d).subList(size + 1, ((ArrayList) this.f8124d).size()));
                        return copyOf;
                    }
                }
                throw new AssertionError("this statement should be unreachable");
            case 1:
                do {
                    Iterator it = (Iterator) this.f8124d;
                    if (it.hasNext()) {
                        j40Var = (j40) it.next();
                    } else {
                        return endOfData();
                    }
                } while (!((HashSet) this.f8125e).add(j40Var.f20368a));
                return j40Var.f20368a;
            case 2:
                do {
                    Iterator it2 = (Iterator) this.f8124d;
                    if (it2.hasNext()) {
                        endpointPair = (EndpointPair) it2.next();
                        if (!endpointPair.nodeU().equals(endpointPair.nodeV())) {
                            return endpointPair;
                        }
                    } else {
                        return (EndpointPair) endOfData();
                    }
                } while (((AtomicBoolean) this.f8125e).getAndSet(true));
                return endpointPair;
            case 3:
                do {
                    Iterator it3 = (Iterator) this.f8124d;
                    if (it3.hasNext()) {
                        Map.Entry entry3 = (Map.Entry) it3.next();
                        key = entry3.getKey();
                        m6135i = md0.m6135i((Collection) entry3.getValue(), new ld0((md0) ((kd0) ((C1290i1) this.f8125e).f18247b).f20824e, key));
                    } else {
                        return (Map.Entry) endOfData();
                    }
                } while (m6135i.isEmpty());
                return Maps.immutableEntry(key, m6135i);
            case 4:
                do {
                    Iterator it4 = (Iterator) this.f8124d;
                    if (it4.hasNext()) {
                        next = it4.next();
                    } else {
                        return endOfData();
                    }
                } while (!((Predicate) this.f8125e).apply(next));
                return next;
            case 5:
                do {
                    Iterator it5 = (Iterator) this.f8124d;
                    if (it5.hasNext()) {
                        entry = (Map.Entry) it5.next();
                    } else {
                        return endOfData();
                    }
                } while (!((d41) this.f8125e).f16241b.equals(entry.getValue()));
                return entry.getKey();
            case 6:
                do {
                    Iterator it6 = (Iterator) this.f8124d;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                    } else {
                        return endOfData();
                    }
                } while (!((C0932s2) this.f8125e).f14961b.contains(next2));
                return next2;
            case 7:
                do {
                    Iterator it7 = (Iterator) this.f8124d;
                    if (it7.hasNext()) {
                        next3 = it7.next();
                    } else {
                        return endOfData();
                    }
                } while (((C0936t2) this.f8125e).f14967b.contains(next3));
                return next3;
            case 8:
                BitSet bitSet = (BitSet) this.f8124d;
                boolean isEmpty = bitSet.isEmpty();
                ih2 ih2Var = (ih2) this.f8125e;
                if (isEmpty) {
                    bitSet.set(0, ih2Var.f18416c);
                } else {
                    int nextSetBit = bitSet.nextSetBit(0);
                    int nextClearBit = bitSet.nextClearBit(nextSetBit);
                    if (nextClearBit == ih2Var.f18415b.size()) {
                        return (Set) endOfData();
                    }
                    int i = (nextClearBit - nextSetBit) - 1;
                    bitSet.set(0, i);
                    bitSet.clear(i, nextClearBit);
                    bitSet.set(nextClearBit);
                }
                return new x70(this, (BitSet) bitSet.clone());
            case 9:
                do {
                    Iterator it8 = (Iterator) this.f8124d;
                    if (it8.hasNext()) {
                        entry2 = (Map.Entry) it8.next();
                    } else {
                        return (Map.Entry) endOfData();
                    }
                } while (!((Map) entry2.getValue()).containsKey(((ig1) this.f8125e).f18404e));
                return new bn2(this, entry2);
            case 10:
                Iterator it9 = (Iterator) this.f8124d;
                if (it9.hasNext()) {
                    gw2 gw2Var2 = (gw2) it9.next();
                    AbstractC1814sx abstractC1814sx2 = gw2Var2.f17854a.f14748b;
                    hw2 hw2Var = (hw2) this.f8125e;
                    if (abstractC1814sx2.compareTo(hw2Var.f18206b.f20665a.f14747a) <= 0) {
                        return (Map.Entry) endOfData();
                    }
                    return Maps.immutableEntry(gw2Var2.f17854a.intersection(hw2Var.f18206b.f20665a), gw2Var2.f17855b);
                }
                return (Map.Entry) endOfData();
            case 11:
                do {
                    Iterator it10 = (Iterator) this.f8124d;
                    if (it10.hasNext()) {
                        gw2Var = (gw2) it10.next();
                        AbstractC1814sx abstractC1814sx3 = gw2Var.f17854a.f14747a;
                        iw2 iw2Var = (iw2) this.f8125e;
                        if (abstractC1814sx3.compareTo(iw2Var.f20296a.f20665a.f14748b) >= 0) {
                            return (Map.Entry) endOfData();
                        }
                        range = gw2Var.f17854a;
                        abstractC1814sx = range.f14748b;
                        jw2Var = iw2Var.f20296a;
                    } else {
                        return (Map.Entry) endOfData();
                    }
                } while (abstractC1814sx.compareTo(jw2Var.f20665a.f14747a) <= 0);
                return Maps.immutableEntry(range.intersection(jw2Var.f20665a), gw2Var.f17855b);
            case 12:
                Iterator it11 = (Iterator) this.f8124d;
                if (!it11.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range2 = (Range) it11.next();
                if (((Range) ((ah1) this.f8125e).f190c).f14748b.mo6741h(range2.f14748b)) {
                    return (Map.Entry) endOfData();
                }
                return Maps.immutableEntry(range2.f14748b, range2);
            case 13:
                PeekingIterator peekingIterator = (PeekingIterator) this.f8124d;
                if (!peekingIterator.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range3 = (Range) peekingIterator.next();
                if (((Range) ((ah1) this.f8125e).f190c).f14747a.mo6741h(range3.f14748b)) {
                    return Maps.immutableEntry(range3.f14748b, range3);
                }
                return (Map.Entry) endOfData();
            case 14:
                Iterator it12 = (Iterator) this.f8124d;
                if (!it12.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range4 = (Range) it12.next();
                pw2 pw2Var = (pw2) this.f8125e;
                if (pw2Var.f25326b.f14747a.compareTo(range4.f14748b) >= 0) {
                    return (Map.Entry) endOfData();
                }
                Range intersection = range4.intersection(pw2Var.f25326b);
                if (pw2Var.f25325a.contains(intersection.f14747a)) {
                    return Maps.immutableEntry(intersection.f14747a, intersection);
                }
                return (Map.Entry) endOfData();
            default:
                while (true) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f8124d;
                    if (!arrayDeque.isEmpty()) {
                        tw2 tw2Var = (tw2) arrayDeque.getLast();
                        if (tw2Var.f27009b.hasNext()) {
                            Object next4 = tw2Var.f27009b.next();
                            arrayDeque.addLast(new tw2(((TreeTraverser) this.f8125e).children(next4).iterator(), next4));
                        } else {
                            arrayDeque.removeLast();
                            return tw2Var.f27008a;
                        }
                    } else {
                        return endOfData();
                    }
                }
        }
    }

    public /* synthetic */ C0566bq(Iterator it, Object obj, int i) {
        this.f8123c = i;
        this.f8124d = it;
        this.f8125e = obj;
    }

    public C0566bq(TreeTraverser treeTraverser, Object obj) {
        this.f8123c = 15;
        this.f8125e = treeTraverser;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f8124d = arrayDeque;
        arrayDeque.addLast(new tw2(treeTraverser.children(obj).iterator(), obj));
    }

    public C0566bq(C1290i1 c1290i1) {
        this.f8123c = 3;
        this.f8125e = c1290i1;
        this.f8124d = ((md0) ((kd0) c1290i1.f18247b).f20824e).f22895f.asMap().entrySet().iterator();
    }

    public C0566bq(List list, Comparator comparator) {
        this.f8123c = 0;
        this.f8124d = Lists.newArrayList(list);
        this.f8125e = comparator;
    }

    public C0566bq(ig1 ig1Var) {
        this.f8123c = 9;
        this.f8125e = ig1Var;
        this.f8124d = ((C0855c3) ig1Var.f18405f).f14788c.entrySet().iterator();
    }

    public C0566bq(C0932s2 c0932s2) {
        this.f8123c = 6;
        this.f8125e = c0932s2;
        this.f8124d = c0932s2.f14960a.iterator();
    }

    public C0566bq(C0936t2 c0936t2) {
        this.f8123c = 7;
        this.f8125e = c0936t2;
        this.f8124d = c0936t2.f14966a.iterator();
    }

    public C0566bq(ih2 ih2Var) {
        this.f8123c = 8;
        this.f8125e = ih2Var;
        this.f8124d = new BitSet(ih2Var.f18415b.size());
    }
}
