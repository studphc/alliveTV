package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: i1 */
/* loaded from: classes.dex */
public final class C1290i1 extends og1 {

    /* renamed from: a */
    public final /* synthetic */ int f18246a;

    /* renamed from: b */
    public final /* synthetic */ Map f18247b;

    public /* synthetic */ C1290i1(Map map, int i) {
        this.f18246a = i;
        this.f18247b = map;
    }

    @Override // p000.og1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f18246a) {
            case 0:
                return Collections2.m3836c(((C1338j1) this.f18247b).f20336d.entrySet(), obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // p000.og1
    /* renamed from: d */
    public final Map mo3859d() {
        switch (this.f18246a) {
            case 0:
                return (C1338j1) this.f18247b;
            case 1:
                return (kd0) this.f18247b;
            case 2:
                return (ig1) this.f18247b;
            case 3:
                return (kg1) this.f18247b;
            case 4:
                return (yg1) this.f18247b;
            case 5:
                return (kd0) this.f18247b;
            default:
                return (iw2) this.f18247b;
        }
    }

    @Override // p000.og1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch (this.f18246a) {
            case 6:
                return !((iw2) this.f18247b).mo5135c().hasNext();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f18246a) {
            case 0:
                return new C1493l((C1338j1) this.f18247b);
            case 1:
                return new C0566bq(this);
            case 2:
                ig1 ig1Var = (ig1) this.f18247b;
                return new w51(ig1Var.mo2233f().iterator(), (Function) ig1Var.f18405f, 1);
            case 3:
                return ((kg1) this.f18247b).entryIterator();
            case 4:
                return ((yg1) this.f18247b).mo84a();
            case 5:
                Set keySet = ((kd0) this.f18247b).f20824e.keySet();
                return new w51(keySet.iterator(), new C1291i2(5, this), 1);
            default:
                return ((iw2) this.f18247b).mo5135c();
        }
    }

    @Override // p000.og1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Object obj2;
        switch (this.f18246a) {
            case 0:
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractC1930w1 abstractC1930w1 = ((C1338j1) this.f18247b).f20337e;
                Object key = entry.getKey();
                Map map = abstractC1930w1.f28031f;
                Preconditions.checkNotNull(map);
                try {
                    obj2 = map.remove(key);
                } catch (ClassCastException | NullPointerException unused) {
                    obj2 = null;
                }
                Collection collection = (Collection) obj2;
                if (collection != null) {
                    int size = collection.size();
                    collection.clear();
                    abstractC1930w1.f28032g -= size;
                }
                return true;
            case 5:
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry2 = (Map.Entry) obj;
                Objects.requireNonNull(entry2);
                ((kd0) this.f18247b).f20824e.keySet().remove(entry2.getKey());
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // p000.og1, p000.oh2, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        switch (this.f18246a) {
            case 1:
                return ((md0) ((kd0) this.f18247b).f20824e).m6138j(Predicates.m3777in(collection));
            default:
                return super.removeAll(collection);
        }
    }

    @Override // p000.og1, p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        switch (this.f18246a) {
            case 1:
                return ((md0) ((kd0) this.f18247b).f20824e).m6138j(Predicates.not(Predicates.m3777in(collection)));
            case 6:
                return iw2.m5368a((iw2) this.f18247b, Predicates.not(Predicates.m3777in(collection)));
            default:
                return super.retainAll(collection);
        }
    }

    @Override // p000.og1, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        switch (this.f18246a) {
            case 1:
                return Iterators.size(new C0566bq(this));
            case 6:
                return Iterators.size(((iw2) this.f18247b).mo5135c());
            default:
                return super.size();
        }
    }
}
