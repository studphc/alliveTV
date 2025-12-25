package p000;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.cache.ConcurrentMapC0840e;
import com.google.common.collect.AbstractC0881i;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: c2 */
/* loaded from: classes.dex */
public class C0578c2 extends AbstractCollection {

    /* renamed from: a */
    public final /* synthetic */ int f8231a;

    /* renamed from: b */
    public final Object f8232b;

    public /* synthetic */ C0578c2(int i, Object obj) {
        this.f8231a = i;
        this.f8232b = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        switch (this.f8231a) {
            case 0:
                ((AbstractC1143e2) this.f8232b).clear();
                return;
            case 1:
                ((AbstractC1930w1) this.f8232b).clear();
                return;
            case 2:
                ((AbstractC0881i) this.f8232b).clear();
                return;
            case 3:
            default:
                super.clear();
                return;
            case 4:
                ((C1328ir) this.f8232b).clear();
                return;
            case 5:
                ((ud0) this.f8232b).clear();
                return;
            case 6:
                ((ConcurrentMapC0840e) this.f8232b).clear();
                return;
            case 7:
                ((zf1) this.f8232b).clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f8231a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return ((AbstractC1143e2) this.f8232b).containsEntry(entry.getKey(), entry.getValue());
                }
                return false;
            case 1:
                return ((AbstractC1930w1) this.f8232b).containsValue(obj);
            case 2:
                return ((AbstractC0881i) this.f8232b).containsValue(obj);
            case 3:
                if (obj instanceof List) {
                    return Collections2.m3834a((ImmutableList) this.f8232b, (List) obj);
                }
                return false;
            case 4:
            default:
                return super.contains(obj);
            case 5:
                return ((AbstractC1143e2) ((ud0) this.f8232b)).containsValue(obj);
            case 6:
                return ((ConcurrentMapC0840e) this.f8232b).containsValue(obj);
            case 7:
                return ((zf1) this.f8232b).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f8231a) {
            case 3:
                return false;
            case 4:
            case 5:
            default:
                return super.isEmpty();
            case 6:
                return ((ConcurrentMapC0840e) this.f8232b).isEmpty();
            case 7:
                return ((zf1) this.f8232b).isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f8231a) {
            case 0:
                return ((AbstractC1143e2) this.f8232b).mo3952h();
            case 1:
                return ((AbstractC1930w1) this.f8232b).mo4037p();
            case 2:
                return ((AbstractC0881i) this.f8232b).mo3832d();
            case 3:
                return new C1094cq((ImmutableList) this.f8232b);
            case 4:
                C1328ir c1328ir = (C1328ir) this.f8232b;
                Map m5346i = c1328ir.m5346i();
                if (m5346i != null) {
                    return m5346i.values().iterator();
                }
                return new C1242gr(c1328ir, 2);
            case 5:
                return new fg1(((ud0) this.f8232b).entries().iterator(), 1);
            case 6:
                return new hb1((ConcurrentMapC0840e) this.f8232b, 2);
            default:
                return new af1((zf1) this.f8232b, 2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f8231a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return ((AbstractC1143e2) this.f8232b).remove(entry.getKey(), entry.getValue());
                }
                return false;
            case 5:
                ud0 ud0Var = (ud0) this.f8232b;
                Predicate mo6137c = ud0Var.mo6137c();
                Iterator it = ud0Var.mo6136a().entries().iterator();
                while (it.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it.next();
                    if (mo6137c.apply(entry2) && Objects.equal(entry2.getValue(), obj)) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f8231a) {
            case 5:
                ud0 ud0Var = (ud0) this.f8232b;
                return Iterables.removeIf(ud0Var.mo6136a().entries(), Predicates.and(ud0Var.mo6137c(), Predicates.compose(Predicates.m3777in(collection), ng1.f23354b)));
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f8231a) {
            case 5:
                ud0 ud0Var = (ud0) this.f8232b;
                return Iterables.removeIf(ud0Var.mo6136a().entries(), Predicates.and(ud0Var.mo6137c(), Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23354b)));
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f8231a) {
            case 0:
                return ((AbstractC1143e2) this.f8232b).size();
            case 1:
                return ((AbstractC1930w1) this.f8232b).size();
            case 2:
                return ((AbstractC0881i) this.f8232b).size();
            case 3:
                return IntMath.factorial(((ImmutableList) this.f8232b).size());
            case 4:
                return ((C1328ir) this.f8232b).size();
            case 5:
                return ((ud0) this.f8232b).size();
            case 6:
                return ((ConcurrentMapC0840e) this.f8232b).size();
            default:
                return ((zf1) this.f8232b).size();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        switch (this.f8231a) {
            case 6:
                return ConcurrentMapC0840e.m3821a(this).toArray();
            case 7:
                return zf1.m8413a(this).toArray();
            default:
                return super.toArray();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        switch (this.f8231a) {
            case 3:
                String valueOf = String.valueOf((ImmutableList) this.f8232b);
                return AbstractC1726qj.m7059o("permutations(", valueOf, ")", valueOf.length() + 14);
            default:
                return super.toString();
        }
    }

    public C0578c2(ud0 ud0Var) {
        this.f8231a = 5;
        this.f8232b = (ud0) Preconditions.checkNotNull(ud0Var);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        switch (this.f8231a) {
            case 6:
                return ConcurrentMapC0840e.m3821a(this).toArray(objArr);
            case 7:
                return zf1.m8413a(this).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }

    public C0578c2(ImmutableList immutableList) {
        this.f8231a = 3;
        this.f8232b = immutableList;
    }
}
