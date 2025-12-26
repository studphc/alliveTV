package p000;

import com.google.common.base.Predicates;
import com.google.common.collect.C0855c3;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: k1 */
/* loaded from: classes.dex */
public class C1375k1 extends zg1 {

    /* renamed from: b */
    public final /* synthetic */ int f20713b;

    /* renamed from: c */
    public final /* synthetic */ Object f20714c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1375k1(ih1 ih1Var, int i) {
        super(ih1Var);
        this.f20713b = i;
        this.f20714c = ih1Var;
    }

    @Override // p000.zg1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f20713b) {
            case 0:
                Iterators.m4034b(iterator());
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // p000.zg1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f20713b) {
            case 3:
                ig1 ig1Var = (ig1) this.f20714c;
                return ((C0855c3) ig1Var.f18405f).contains(obj, ig1Var.f18404e);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f20713b) {
            case 0:
                return this.f29371a.keySet().containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        switch (this.f20713b) {
            case 0:
                if (this != obj && !this.f29371a.keySet().equals(obj)) {
                    return false;
                }
                return true;
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        switch (this.f20713b) {
            case 0:
                return this.f29371a.keySet().hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // p000.zg1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch (this.f20713b) {
            case 0:
                return new C1493l(this, this.f29371a.entrySet().iterator(), 2);
            default:
                return super.iterator();
        }
    }

    @Override // p000.zg1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i;
        switch (this.f20713b) {
            case 0:
                Collection collection = (Collection) this.f29371a.remove(obj);
                if (collection != null) {
                    i = collection.size();
                    collection.clear();
                    ((AbstractC1930w1) this.f20714c).f28032g -= i;
                } else {
                    i = 0;
                }
                if (i <= 0) {
                    return false;
                }
                return true;
            case 1:
                if (((kd0) this.f20714c).m5521g(obj) != null) {
                    return true;
                }
                return false;
            case 2:
                sg1 sg1Var = (sg1) this.f20714c;
                if (sg1Var.containsKey(obj)) {
                    sg1Var.f26415d.remove(obj);
                    return true;
                }
                return false;
            case 3:
                ig1 ig1Var = (ig1) this.f20714c;
                if (((C0855c3) ig1Var.f18405f).remove(obj, ig1Var.f18404e) != null) {
                    return true;
                }
                return false;
            default:
                if (((iw2) this.f20714c).remove(obj) != null) {
                    return true;
                }
                return false;
        }
    }

    @Override // p000.oh2, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        switch (this.f20713b) {
            case 1:
                return ((md0) ((kd0) this.f20714c).f20824e).m6138j(Predicates.compose(Predicates.m3777in(collection), ng1.f23353a));
            case 2:
                sg1 sg1Var = (sg1) this.f20714c;
                return sg1.m7370h(sg1Var.f26415d, sg1Var.f26416e, collection);
            default:
                return super.removeAll(collection);
        }
    }

    @Override // p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        switch (this.f20713b) {
            case 1:
                return ((md0) ((kd0) this.f20714c).f20824e).m6138j(Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23353a));
            case 2:
                sg1 sg1Var = (sg1) this.f20714c;
                return sg1.m7371i(sg1Var.f26415d, sg1Var.f26416e, collection);
            case 3:
                return ((ig1) this.f20714c).m5239g(Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23353a));
            case 4:
                return iw2.m5368a((iw2) this.f20714c, Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23353a));
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch (this.f20713b) {
            case 2:
                return Lists.newArrayList(iterator()).toArray();
            default:
                return super.toArray();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1375k1(Object obj, Map map, int i) {
        super(map);
        this.f20713b = i;
        this.f20714c = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        switch (this.f20713b) {
            case 2:
                return Lists.newArrayList(iterator()).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}
