package p000;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.lang.ref.SoftReference;
import java.util.Map;

/* loaded from: classes2.dex */
public final class l40 extends d41 {

    /* renamed from: d */
    public final /* synthetic */ int f22320d;

    /* renamed from: e */
    public final /* synthetic */ Object f22321e;

    /* renamed from: f */
    public final /* synthetic */ mr1 f22322f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l40(mr1 mr1Var, Map map, Object obj, Object obj2, int i) {
        super(map, obj);
        this.f22320d = i;
        this.f22322f = mr1Var;
        this.f22321e = obj2;
    }

    @Override // p000.d41, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Object obj;
        switch (this.f22320d) {
            case 0:
                m40 m40Var = (m40) this.f22322f;
                Multiset multiset = (Multiset) m40.m6049m(m40Var.f22787e);
                if (multiset == null) {
                    multiset = HashMultiset.create(m40Var.f29204b.values());
                    m40Var.f22787e = new SoftReference(multiset);
                }
                return multiset.count(this.f22321e);
            default:
                xz2 xz2Var = (xz2) this.f22322f;
                SoftReference softReference = xz2Var.f28777b;
                if (softReference == null) {
                    obj = null;
                } else {
                    obj = softReference.get();
                }
                Multiset multiset2 = (Multiset) obj;
                if (multiset2 == null) {
                    multiset2 = HashMultiset.create(xz2Var.f17536a.values());
                    xz2Var.f28777b = new SoftReference(multiset2);
                }
                return multiset2.count(this.f22321e);
        }
    }
}
