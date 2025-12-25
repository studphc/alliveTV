package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes.dex */
public final class cw2 extends en2 implements SortedMap {

    /* renamed from: d */
    public final Object f16157d;

    /* renamed from: e */
    public final Object f16158e;

    /* renamed from: f */
    public transient SortedMap f16159f;

    /* renamed from: g */
    public final /* synthetic */ TreeBasedTable f16160g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw2(TreeBasedTable treeBasedTable, Object obj, Object obj2, Object obj3) {
        super(treeBasedTable, obj);
        boolean z;
        this.f16160g = treeBasedTable;
        this.f16157d = obj2;
        this.f16158e = obj3;
        if (obj2 != null && obj3 != null && treeBasedTable.columnComparator().compare(obj2, obj3) > 0) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
    }

    @Override // p000.en2
    /* renamed from: c */
    public final Map mo4491c() {
        m4494h();
        SortedMap sortedMap = this.f16159f;
        if (sortedMap != null) {
            Object obj = this.f16157d;
            if (obj != null) {
                sortedMap = sortedMap.tailMap(obj);
            }
            Object obj2 = this.f16158e;
            if (obj2 != null) {
                return sortedMap.headMap(obj2);
            }
            return sortedMap;
        }
        return null;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return this.f16160g.columnComparator();
    }

    @Override // p000.en2, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (m4493g(obj) && super.containsKey(obj)) {
            return true;
        }
        return false;
    }

    @Override // p000.en2
    /* renamed from: e */
    public final void mo4492e() {
        m4494h();
        SortedMap sortedMap = this.f16159f;
        if (sortedMap != null && sortedMap.isEmpty()) {
            this.f16160g.f14788c.remove(this.f16917a);
            this.f16159f = null;
            this.f16918b = null;
        }
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        m4736f();
        Map map = this.f16918b;
        if (map != null) {
            return ((SortedMap) map).firstKey();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: g */
    public final boolean m4493g(Object obj) {
        Object obj2;
        if (obj != null) {
            TreeBasedTable treeBasedTable = this.f16160g;
            Object obj3 = this.f16157d;
            if ((obj3 == null || treeBasedTable.columnComparator().compare(obj3, obj) <= 0) && ((obj2 = this.f16158e) == null || treeBasedTable.columnComparator().compare(obj2, obj) > 0)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public final void m4494h() {
        SortedMap sortedMap = this.f16159f;
        Object obj = this.f16917a;
        TreeBasedTable treeBasedTable = this.f16160g;
        if (sortedMap == null || (sortedMap.isEmpty() && treeBasedTable.f14788c.containsKey(obj))) {
            this.f16159f = (SortedMap) treeBasedTable.f14788c.get(obj);
        }
    }

    @Override // java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        Preconditions.checkArgument(m4493g(Preconditions.checkNotNull(obj)));
        return new cw2(this.f16160g, this.f16917a, this.f16157d, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return new zg1(this);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        m4736f();
        Map map = this.f16918b;
        if (map != null) {
            return ((SortedMap) map).lastKey();
        }
        throw new NoSuchElementException();
    }

    @Override // p000.en2, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Preconditions.checkArgument(m4493g(Preconditions.checkNotNull(obj)));
        return super.put(obj, obj2);
    }

    @Override // java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        boolean z;
        if (m4493g(Preconditions.checkNotNull(obj)) && m4493g(Preconditions.checkNotNull(obj2))) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new cw2(this.f16160g, this.f16917a, obj, obj2);
    }

    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        Preconditions.checkArgument(m4493g(Preconditions.checkNotNull(obj)));
        return new cw2(this.f16160g, this.f16917a, obj, this.f16158e);
    }
}
