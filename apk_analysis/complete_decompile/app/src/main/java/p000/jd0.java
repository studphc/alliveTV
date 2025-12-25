package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.C0855c3;
import com.google.common.collect.Lists;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class jd0 extends hh1 {

    /* renamed from: b */
    public final /* synthetic */ int f20466b;

    /* renamed from: c */
    public final /* synthetic */ AbstractMap f20467c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jd0(ih1 ih1Var, int i) {
        super(ih1Var);
        this.f20466b = i;
        this.f20467c = ih1Var;
    }

    @Override // p000.hh1, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f20466b) {
            case 0:
                if (obj instanceof Collection) {
                    Collection collection = (Collection) obj;
                    kd0 kd0Var = (kd0) this.f20467c;
                    Iterator it = ((md0) kd0Var.f20824e).f22895f.asMap().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Collection m6135i = md0.m6135i((Collection) entry.getValue(), new ld0((md0) kd0Var.f20824e, entry.getKey()));
                        if (!m6135i.isEmpty() && collection.equals(m6135i)) {
                            if (m6135i.size() == ((Collection) entry.getValue()).size()) {
                                it.remove();
                            } else {
                                m6135i.clear();
                            }
                            return true;
                        }
                    }
                }
                return false;
            case 1:
                if (obj != null) {
                    if (((ig1) this.f20467c).m5239g(Predicates.compose(Predicates.equalTo(obj), ng1.f23354b))) {
                        return true;
                    }
                }
                return false;
            case 2:
                dn2 dn2Var = (dn2) this.f20467c;
                for (Map.Entry entry2 : dn2Var.entrySet()) {
                    if (((Map) entry2.getValue()).equals(obj)) {
                        C0855c3.m4085e(dn2Var.f16446e, entry2.getKey());
                        return true;
                    }
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // p000.hh1, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f20466b) {
            case 0:
                return ((md0) ((kd0) this.f20467c).f20824e).m6138j(Predicates.compose(Predicates.m3777in(collection), ng1.f23354b));
            case 1:
                return ((ig1) this.f20467c).m5239g(Predicates.compose(Predicates.m3777in(collection), ng1.f23354b));
            case 2:
                Preconditions.checkNotNull(collection);
                dn2 dn2Var = (dn2) this.f20467c;
                Iterator it = Lists.newArrayList(dn2Var.f16446e.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    C0855c3 c0855c3 = dn2Var.f16446e;
                    if (collection.contains(c0855c3.column(next))) {
                        C0855c3.m4085e(c0855c3, next);
                        z = true;
                    }
                }
                return z;
            default:
                return iw2.m5368a((iw2) this.f20467c, Predicates.compose(Predicates.m3777in(collection), ng1.f23354b));
        }
    }

    @Override // p000.hh1, java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f20466b) {
            case 0:
                return ((md0) ((kd0) this.f20467c).f20824e).m6138j(Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23354b));
            case 1:
                return ((ig1) this.f20467c).m5239g(Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23354b));
            case 2:
                Preconditions.checkNotNull(collection);
                dn2 dn2Var = (dn2) this.f20467c;
                Iterator it = Lists.newArrayList(dn2Var.f16446e.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    C0855c3 c0855c3 = dn2Var.f16446e;
                    if (!collection.contains(c0855c3.column(next))) {
                        C0855c3.m4085e(c0855c3, next);
                        z = true;
                    }
                }
                return z;
            default:
                return iw2.m5368a((iw2) this.f20467c, Predicates.compose(Predicates.not(Predicates.m3777in(collection)), ng1.f23354b));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd0(iw2 iw2Var, iw2 iw2Var2) {
        super(iw2Var2);
        this.f20466b = 3;
        this.f20467c = iw2Var;
    }
}
