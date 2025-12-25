package p000;

import com.google.common.base.Objects;
import com.google.common.collect.HashBiMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class iz0 extends kz0 {
    @Override // p000.kz0
    /* renamed from: a */
    public final Object mo5027a(int i) {
        return new fz0((HashBiMap) this.f22253b, i, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        HashBiMap hashBiMap = (HashBiMap) this.f22253b;
        hashBiMap.getClass();
        int m3869i = hashBiMap.m3869i(o63.m6454N(key), key);
        if (m3869i == -1 || !Objects.equal(hashBiMap.f14642a[m3869i], value)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int m6454N = o63.m6454N(key);
            HashBiMap hashBiMap = (HashBiMap) this.f22253b;
            int m3869i = hashBiMap.m3869i(m6454N, key);
            if (m3869i != -1 && Objects.equal(hashBiMap.f14642a[m3869i], value)) {
                hashBiMap.m3877q(m3869i, m6454N);
                return true;
            }
            return false;
        }
        return false;
    }
}
