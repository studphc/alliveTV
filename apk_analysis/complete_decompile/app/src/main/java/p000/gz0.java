package p000;

import com.google.common.base.Objects;
import com.google.common.collect.HashBiMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class gz0 extends kz0 {

    /* renamed from: c */
    public final /* synthetic */ int f17885c;

    /* renamed from: d */
    public final /* synthetic */ HashBiMap f17886d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gz0(HashBiMap hashBiMap, int i) {
        super(hashBiMap);
        this.f17885c = i;
        this.f17886d = hashBiMap;
    }

    @Override // p000.kz0
    /* renamed from: a */
    public final Object mo5027a(int i) {
        switch (this.f17885c) {
            case 0:
                return new fz0(this.f17886d, i, 0);
            case 1:
                return this.f17886d.f14642a[i];
            default:
                return this.f17886d.f14643b[i];
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f17885c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                HashBiMap hashBiMap = this.f17886d;
                hashBiMap.getClass();
                int m3868h = hashBiMap.m3868h(o63.m6454N(key), key);
                if (m3868h == -1 || !Objects.equal(value, hashBiMap.f14643b[m3868h])) {
                    return false;
                }
                return true;
            case 1:
                return this.f17886d.containsKey(obj);
            default:
                return this.f17886d.containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f17885c) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    int m6454N = o63.m6454N(key);
                    HashBiMap hashBiMap = this.f17886d;
                    int m3868h = hashBiMap.m3868h(m6454N, key);
                    if (m3868h != -1 && Objects.equal(value, hashBiMap.f14643b[m3868h])) {
                        hashBiMap.m3876p(m3868h, m6454N);
                        return true;
                    }
                }
                return false;
            case 1:
                int m6454N2 = o63.m6454N(obj);
                HashBiMap hashBiMap2 = this.f17886d;
                int m3868h2 = hashBiMap2.m3868h(m6454N2, obj);
                if (m3868h2 != -1) {
                    hashBiMap2.m3876p(m3868h2, m6454N2);
                    return true;
                }
                return false;
            default:
                int m6454N3 = o63.m6454N(obj);
                HashBiMap hashBiMap3 = this.f17886d;
                int m3869i = hashBiMap3.m3869i(m6454N3, obj);
                if (m3869i != -1) {
                    hashBiMap3.m3877q(m3869i, m6454N3);
                    return true;
                }
                return false;
        }
    }
}
