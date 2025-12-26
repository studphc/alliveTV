package p000;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class iw2 extends AbstractMap {

    /* renamed from: a */
    public final /* synthetic */ jw2 f20296a;

    public iw2(jw2 jw2Var) {
        this.f20296a = jw2Var;
    }

    /* renamed from: a */
    public static boolean m5368a(iw2 iw2Var, Predicate predicate) {
        iw2Var.getClass();
        ArrayList newArrayList = Lists.newArrayList();
        new C1290i1(iw2Var, 6);
        UnmodifiableIterator mo5135c = iw2Var.mo5135c();
        while (mo5135c.hasNext()) {
            Map.Entry entry = (Map.Entry) mo5135c.next();
            if (predicate.apply(entry)) {
                newArrayList.add((Range) entry.getKey());
            }
        }
        Iterator it = newArrayList.iterator();
        while (it.hasNext()) {
            iw2Var.f20296a.f20666b.remove((Range) it.next());
        }
        return !newArrayList.isEmpty();
    }

    /* renamed from: c */
    public UnmodifiableIterator mo5135c() {
        jw2 jw2Var = this.f20296a;
        if (jw2Var.f20665a.isEmpty()) {
            return z51.f29250d;
        }
        TreeRangeMap treeRangeMap = jw2Var.f20666b;
        TreeMap treeMap = treeRangeMap.f14758a;
        Range range = jw2Var.f20665a;
        return new C0566bq(this, treeRangeMap.f14758a.tailMap((AbstractC1814sx) MoreObjects.firstNonNull((AbstractC1814sx) treeMap.floorKey(range.f14747a), range.f14747a), true).values().iterator(), 11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f20296a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return new C1290i1(this, 6);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        gw2 gw2Var;
        jw2 jw2Var = this.f20296a;
        try {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                Range range2 = jw2Var.f20665a;
                Range range3 = jw2Var.f20665a;
                if (range2.encloses(range)) {
                    boolean isEmpty = range.isEmpty();
                    AbstractC1814sx abstractC1814sx = range.f14747a;
                    if (!isEmpty) {
                        int compareTo = abstractC1814sx.compareTo(range3.f14747a);
                        TreeRangeMap treeRangeMap = jw2Var.f20666b;
                        if (compareTo == 0) {
                            Map.Entry floorEntry = treeRangeMap.f14758a.floorEntry(abstractC1814sx);
                            if (floorEntry != null) {
                                gw2Var = (gw2) floorEntry.getValue();
                            } else {
                                gw2Var = null;
                            }
                        } else {
                            gw2Var = (gw2) treeRangeMap.f14758a.get(abstractC1814sx);
                        }
                        if (gw2Var != null) {
                            Range range4 = gw2Var.f17854a;
                            if (range4.isConnected(range3) && range4.intersection(range3).equals(range)) {
                                return gw2Var.f17855b;
                            }
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return new C1375k1(this, this, 4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Object obj2 = get(obj);
        if (obj2 != null) {
            Objects.requireNonNull(obj);
            this.f20296a.f20666b.remove((Range) obj);
            return obj2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return new jd0(this, this);
    }
}
