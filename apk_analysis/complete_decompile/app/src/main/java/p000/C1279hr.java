package p000;

import com.google.common.base.Objects;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: hr */
/* loaded from: classes.dex */
public final class C1279hr extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f18135a;

    /* renamed from: b */
    public final /* synthetic */ C1328ir f18136b;

    public /* synthetic */ C1279hr(C1328ir c1328ir, int i) {
        this.f18135a = i;
        this.f18136b = c1328ir;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f18135a) {
            case 0:
                this.f18136b.clear();
                return;
            default:
                this.f18136b.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f18135a) {
            case 0:
                C1328ir c1328ir = this.f18136b;
                Map m5346i = c1328ir.m5346i();
                if (m5346i != null) {
                    return m5346i.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int m5351n = c1328ir.m5351n(entry.getKey());
                    if (m5351n != -1 && Objects.equal(c1328ir.m5359v()[m5351n], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return this.f18136b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f18135a) {
            case 0:
                C1328ir c1328ir = this.f18136b;
                Map m5346i = c1328ir.m5346i();
                if (m5346i != null) {
                    return m5346i.entrySet().iterator();
                }
                return new C1242gr(c1328ir, 1);
            default:
                C1328ir c1328ir2 = this.f18136b;
                Map m5346i2 = c1328ir2.m5346i();
                if (m5346i2 != null) {
                    return m5346i2.keySet().iterator();
                }
                return new C1242gr(c1328ir2, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f18135a) {
            case 0:
                C1328ir c1328ir = this.f18136b;
                Map m5346i = c1328ir.m5346i();
                if (m5346i != null) {
                    return m5346i.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!c1328ir.m5355r()) {
                        int m5349l = c1328ir.m5349l();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = c1328ir.f20227a;
                        java.util.Objects.requireNonNull(obj2);
                        int m8340L = yy2.m8340L(key, value, m5349l, obj2, c1328ir.m5357t(), c1328ir.m5358u(), c1328ir.m5359v());
                        if (m8340L != -1) {
                            c1328ir.mo5354q(m8340L, m5349l);
                            c1328ir.f20232f--;
                            c1328ir.m5350m();
                            return true;
                        }
                    }
                }
                return false;
            default:
                C1328ir c1328ir2 = this.f18136b;
                Map m5346i2 = c1328ir2.m5346i();
                if (m5346i2 != null) {
                    return m5346i2.keySet().remove(obj);
                }
                if (c1328ir2.m5356s(obj) != C1328ir.f20226j) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f18135a) {
            case 0:
                return this.f18136b.size();
            default:
                return this.f18136b.size();
        }
    }
}
