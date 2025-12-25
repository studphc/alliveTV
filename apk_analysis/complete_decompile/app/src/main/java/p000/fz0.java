package p000;

import com.google.common.base.Objects;
import com.google.common.collect.HashBiMap;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class fz0 extends AbstractC2041z1 {

    /* renamed from: a */
    public final /* synthetic */ int f17481a;

    /* renamed from: b */
    public final AbstractMap f17482b;

    /* renamed from: c */
    public final Object f17483c;

    /* renamed from: d */
    public int f17484d;

    public fz0(C1328ir c1328ir, int i) {
        this.f17481a = 2;
        this.f17482b = c1328ir;
        Object obj = C1328ir.f20226j;
        this.f17483c = c1328ir.m5358u()[i];
        this.f17484d = i;
    }

    /* renamed from: d */
    public void m4888d() {
        int i = this.f17484d;
        Object obj = this.f17483c;
        HashBiMap hashBiMap = (HashBiMap) this.f17482b;
        if (i == -1 || i > hashBiMap.f14644c || !Objects.equal(hashBiMap.f14642a[i], obj)) {
            hashBiMap.getClass();
            this.f17484d = hashBiMap.m3868h(o63.m6454N(obj), obj);
        }
    }

    /* renamed from: e */
    public void m4889e() {
        int i = this.f17484d;
        Object obj = this.f17483c;
        HashBiMap hashBiMap = (HashBiMap) this.f17482b;
        if (i == -1 || i > hashBiMap.f14644c || !Objects.equal(obj, hashBiMap.f14643b[i])) {
            hashBiMap.getClass();
            this.f17484d = hashBiMap.m3869i(o63.m6454N(obj), obj);
        }
    }

    /* renamed from: f */
    public void m4890f() {
        int i = this.f17484d;
        Object obj = this.f17483c;
        C1328ir c1328ir = (C1328ir) this.f17482b;
        if (i != -1 && i < c1328ir.size()) {
            if (Objects.equal(obj, c1328ir.m5358u()[this.f17484d])) {
                return;
            }
        }
        Object obj2 = C1328ir.f20226j;
        this.f17484d = c1328ir.m5351n(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.f17481a) {
            case 0:
                return this.f17483c;
            case 1:
                return this.f17483c;
            default:
                return this.f17483c;
        }
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        switch (this.f17481a) {
            case 0:
                m4888d();
                int i = this.f17484d;
                if (i == -1) {
                    return null;
                }
                return ((HashBiMap) this.f17482b).f14643b[i];
            case 1:
                m4889e();
                int i2 = this.f17484d;
                if (i2 == -1) {
                    return null;
                }
                return ((HashBiMap) this.f17482b).f14642a[i2];
            default:
                C1328ir c1328ir = (C1328ir) this.f17482b;
                Map m5346i = c1328ir.m5346i();
                if (m5346i != null) {
                    return m5346i.get(this.f17483c);
                }
                m4890f();
                int i3 = this.f17484d;
                if (i3 == -1) {
                    return null;
                }
                return c1328ir.m5359v()[i3];
        }
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        switch (this.f17481a) {
            case 0:
                m4888d();
                int i = this.f17484d;
                HashBiMap hashBiMap = (HashBiMap) this.f17482b;
                if (i == -1) {
                    hashBiMap.put(this.f17483c, obj);
                    return null;
                }
                Object obj2 = hashBiMap.f14643b[i];
                if (!Objects.equal(obj2, obj)) {
                    hashBiMap.m3879s(obj, this.f17484d, false);
                    return obj2;
                }
                return obj;
            case 1:
                m4889e();
                int i2 = this.f17484d;
                HashBiMap hashBiMap2 = (HashBiMap) this.f17482b;
                if (i2 == -1) {
                    hashBiMap2.m3874n(this.f17483c, obj, false);
                    return null;
                }
                Object obj3 = hashBiMap2.f14642a[i2];
                if (!Objects.equal(obj3, obj)) {
                    hashBiMap2.m3878r(obj, this.f17484d, false);
                    return obj3;
                }
                return obj;
            default:
                C1328ir c1328ir = (C1328ir) this.f17482b;
                Map m5346i = c1328ir.m5346i();
                Object obj4 = this.f17483c;
                if (m5346i != null) {
                    return m5346i.put(obj4, obj);
                }
                m4890f();
                int i3 = this.f17484d;
                if (i3 == -1) {
                    c1328ir.put(obj4, obj);
                    return null;
                }
                Object obj5 = c1328ir.m5359v()[i3];
                c1328ir.m5359v()[this.f17484d] = obj;
                return obj5;
        }
    }

    public fz0(HashBiMap hashBiMap, int i, int i2) {
        this.f17481a = i2;
        switch (i2) {
            case 1:
                this.f17482b = hashBiMap;
                this.f17483c = hashBiMap.f14643b[i];
                this.f17484d = i;
                return;
            default:
                this.f17482b = hashBiMap;
                this.f17483c = hashBiMap.f14642a[i];
                this.f17484d = i;
                return;
        }
    }
}
