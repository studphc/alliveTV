package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000.C1226gb;
import p000.C1251h;
import p000.C1300ib;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: d */
    public C1251h f1648d;

    /* renamed from: e */
    public C1226gb f1649e;

    /* renamed from: f */
    public C1300ib f1650f;

    public ArrayMap() {
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return super.containsKey(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        C1251h c1251h = this.f1648d;
        if (c1251h == null) {
            C1251h c1251h2 = new C1251h(2, this);
            this.f1648d = c1251h2;
            return c1251h2;
        }
        return c1251h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V get(@Nullable Object obj) {
        return (V) super.get(obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<K> keySet() {
        C1226gb c1226gb = this.f1649e;
        if (c1226gb == null) {
            C1226gb c1226gb2 = new C1226gb(this);
            this.f1649e = c1226gb2;
            return c1226gb2;
        }
        return c1226gb;
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size() + getF1755c());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V remove(@Nullable Object obj) {
        return (V) super.remove(obj);
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        int f1755c = getF1755c();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        if (f1755c != getF1755c()) {
            return true;
        }
        return false;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        int f1755c = getF1755c();
        for (int f1755c2 = getF1755c() - 1; f1755c2 >= 0; f1755c2--) {
            if (!collection.contains(keyAt(f1755c2))) {
                removeAt(f1755c2);
            }
        }
        if (f1755c != getF1755c()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    @NonNull
    public Collection<V> values() {
        C1300ib c1300ib = this.f1650f;
        if (c1300ib == null) {
            C1300ib c1300ib2 = new C1300ib(this);
            this.f1650f = c1300ib2;
            return c1300ib2;
        }
        return c1300ib;
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(@Nullable SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
