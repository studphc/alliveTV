package p000;

import com.google.common.collect.BiMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class fr2 extends lr2 implements BiMap {
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public transient sr2 f17379f;

    /* renamed from: g */
    public transient fr2 f17380g;

    public fr2(BiMap biMap, Object obj, fr2 fr2Var) {
        super(biMap, obj);
        this.f17380g = fr2Var;
    }

    @Override // p000.lr2
    /* renamed from: e */
    public final Map mo4828e() {
        return (BiMap) ((Map) this.f25272a);
    }

    @Override // com.google.common.collect.BiMap
    public final Object forcePut(Object obj, Object obj2) {
        Object forcePut;
        synchronized (this.f25273b) {
            forcePut = ((BiMap) ((Map) this.f25272a)).forcePut(obj, obj2);
        }
        return forcePut;
    }

    @Override // com.google.common.collect.BiMap
    public final BiMap inverse() {
        fr2 fr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f17380g == null) {
                    this.f17380g = new fr2(((BiMap) ((Map) this.f25272a)).inverse(), this.f25273b, this);
                }
                fr2Var = this.f17380g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fr2Var;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, sr2] */
    @Override // p000.lr2, java.util.Map
    public final Set values() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f17379f == null) {
                    this.f17379f = new pr2(((BiMap) ((Map) this.f25272a)).values(), this.f25273b);
                }
                sr2Var = this.f17379f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }
}
