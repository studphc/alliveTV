package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import p000.vd2;
import p000.wd2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    public wd2 f1639a;

    /* renamed from: b */
    public wd2 f1640b;

    /* renamed from: c */
    public final WeakHashMap f1641c = new WeakHashMap();

    /* renamed from: d */
    public int f1642d = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        public wd2 f1643a;

        /* renamed from: b */
        public boolean f1644b = true;

        public IteratorWithAdditions() {
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        /* renamed from: a */
        public final void mo324a(wd2 wd2Var) {
            boolean z;
            wd2 wd2Var2 = this.f1643a;
            if (wd2Var == wd2Var2) {
                wd2 wd2Var3 = wd2Var2.f28150d;
                this.f1643a = wd2Var3;
                if (wd2Var3 == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.f1644b = z;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1644b) {
                if (SafeIterableMap.this.f1639a == null) {
                    return false;
                }
                return true;
            }
            wd2 wd2Var = this.f1643a;
            if (wd2Var == null || wd2Var.f28149c == null) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f1644b) {
                this.f1644b = false;
                this.f1643a = SafeIterableMap.this.f1639a;
            } else {
                wd2 wd2Var = this.f1643a;
                this.f1643a = wd2Var != null ? wd2Var.f28149c : null;
            }
            return this.f1643a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static abstract class SupportRemove<K, V> {
        /* renamed from: a */
        public abstract void mo324a(wd2 wd2Var);
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        vd2 vd2Var = new vd2(this.f1640b, this.f1639a, 1);
        this.f1641c.put(vd2Var, Boolean.FALSE);
        return vd2Var;
    }

    @Nullable
    public Map.Entry<K, V> eldest() {
        return this.f1639a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        return false;
    }

    @Nullable
    public wd2 get(K k) {
        wd2 wd2Var = this.f1639a;
        while (wd2Var != null && !wd2Var.f28147a.equals(k)) {
            wd2Var = wd2Var.f28149c;
        }
        return wd2Var;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        vd2 vd2Var = new vd2(this.f1639a, this.f1640b, 0);
        this.f1641c.put(vd2Var, Boolean.FALSE);
        return vd2Var;
    }

    @NonNull
    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.f1641c.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    @Nullable
    public Map.Entry<K, V> newest() {
        return this.f1640b;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        wd2 wd2Var = get(k);
        if (wd2Var != null) {
            return (V) wd2Var.f28148b;
        }
        wd2 wd2Var2 = new wd2(k, v);
        this.f1642d++;
        wd2 wd2Var3 = this.f1640b;
        if (wd2Var3 == null) {
            this.f1639a = wd2Var2;
            this.f1640b = wd2Var2;
            return null;
        }
        wd2Var3.f28149c = wd2Var2;
        wd2Var2.f28150d = wd2Var3;
        this.f1640b = wd2Var2;
        return null;
    }

    public V remove(@NonNull K k) {
        wd2 wd2Var = get(k);
        if (wd2Var == null) {
            return null;
        }
        this.f1642d--;
        WeakHashMap weakHashMap = this.f1641c;
        if (!weakHashMap.isEmpty()) {
            Iterator<K> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((SupportRemove) it.next()).mo324a(wd2Var);
            }
        }
        wd2 wd2Var2 = wd2Var.f28150d;
        if (wd2Var2 != null) {
            wd2Var2.f28149c = wd2Var.f28149c;
        } else {
            this.f1639a = wd2Var.f28149c;
        }
        wd2 wd2Var3 = wd2Var.f28149c;
        if (wd2Var3 != null) {
            wd2Var3.f28150d = wd2Var2;
        } else {
            this.f1640b = wd2Var2;
        }
        wd2Var.f28149c = null;
        wd2Var.f28150d = null;
        return (V) wd2Var.f28148b;
    }

    public int size() {
        return this.f1642d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
