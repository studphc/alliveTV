package p000;

import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class fw2 extends yg1 {

    /* renamed from: a */
    public final Collection f17422a;

    /* renamed from: b */
    public final /* synthetic */ TreeRangeMap f17423b;

    public fw2(TreeRangeMap treeRangeMap, Collection collection) {
        this.f17423b = treeRangeMap;
        this.f17422a = collection;
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        return this.f17422a.iterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj instanceof Range) {
            Range range = (Range) obj;
            gw2 gw2Var = (gw2) this.f17423b.f14758a.get(range.f14747a);
            if (gw2Var != null && gw2Var.f17854a.equals(range)) {
                return gw2Var.f17855b;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f17423b.f14758a.size();
    }
}
