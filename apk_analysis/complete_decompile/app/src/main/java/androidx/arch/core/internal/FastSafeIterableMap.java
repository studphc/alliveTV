package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import p000.wd2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: e */
    public final HashMap f1638e = new HashMap();

    @Nullable
    public Map.Entry<K, V> ceil(K k) {
        if (contains(k)) {
            return ((wd2) this.f1638e.get(k)).f28150d;
        }
        return null;
    }

    public boolean contains(K k) {
        return this.f1638e.containsKey(k);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    @Nullable
    public wd2 get(K k) {
        return (wd2) this.f1638e.get(k);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        wd2 wd2Var = get(k);
        if (wd2Var != null) {
            return (V) wd2Var.f28148b;
        }
        HashMap hashMap = this.f1638e;
        wd2 wd2Var2 = new wd2(k, v);
        this.f1642d++;
        wd2 wd2Var3 = this.f1640b;
        if (wd2Var3 == null) {
            this.f1639a = wd2Var2;
            this.f1640b = wd2Var2;
        } else {
            wd2Var3.f28149c = wd2Var2;
            wd2Var2.f28150d = wd2Var3;
            this.f1640b = wd2Var2;
        }
        hashMap.put(k, wd2Var2);
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K k) {
        V v = (V) super.remove(k);
        this.f1638e.remove(k);
        return v;
    }
}
