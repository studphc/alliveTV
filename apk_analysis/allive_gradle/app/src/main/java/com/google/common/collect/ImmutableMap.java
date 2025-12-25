package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import p000.ng1;
import p000.p63;
import p000.u21;
import p000.y21;

@DoNotMock("Use ImmutableMap.of or another implementation")
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: e */
    public static final Map.Entry[] f14665e = new Map.Entry[0];

    /* renamed from: a */
    public transient ImmutableSet f14666a;

    /* renamed from: b */
    public transient ImmutableSet f14667b;

    /* renamed from: c */
    public transient ImmutableCollection f14668c;

    /* renamed from: d */
    public transient ImmutableSetMultimap f14669d;

    @DoNotMock
    /* loaded from: classes.dex */
    public static class Builder<K, V> {

        /* renamed from: a */
        public Comparator f14670a;

        /* renamed from: b */
        public Object[] f14671b;

        /* renamed from: c */
        public int f14672c;

        /* renamed from: d */
        public boolean f14673d;

        /* renamed from: e */
        public C0842a0 f14674e;

        public Builder() {
            this(4);
        }

        /* renamed from: b */
        public static void m3939b(int i, Comparator comparator, Object[] objArr) {
            Map.Entry[] entryArr = new Map.Entry[i];
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * 2;
                Object obj = objArr[i3];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i3 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i2] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i, Ordering.from(comparator).onResultOf(ng1.f23354b));
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * 2;
                objArr[i5] = entryArr[i4].getKey();
                objArr[i5 + 1] = entryArr[i4].getValue();
            }
        }

        /* renamed from: a */
        public final C0884i2 m3940a(boolean z) {
            Object[] objArr;
            C0842a0 c0842a0;
            C0842a0 c0842a02;
            if (z && (c0842a02 = this.f14674e) != null) {
                throw c0842a02.m4080a();
            }
            int i = this.f14672c;
            if (this.f14670a == null) {
                objArr = this.f14671b;
            } else {
                if (this.f14673d) {
                    this.f14671b = Arrays.copyOf(this.f14671b, i * 2);
                }
                objArr = this.f14671b;
                if (!z) {
                    int i2 = this.f14672c;
                    HashSet hashSet = new HashSet();
                    BitSet bitSet = new BitSet();
                    for (int i3 = i2 - 1; i3 >= 0; i3--) {
                        Object obj = objArr[i3 * 2];
                        Objects.requireNonNull(obj);
                        if (!hashSet.add(obj)) {
                            bitSet.set(i3);
                        }
                    }
                    if (!bitSet.isEmpty()) {
                        Object[] objArr2 = new Object[(i2 - bitSet.cardinality()) * 2];
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < i2 * 2) {
                            if (bitSet.get(i4 >>> 1)) {
                                i4 += 2;
                            } else {
                                int i6 = i5 + 1;
                                int i7 = i4 + 1;
                                Object obj2 = objArr[i4];
                                Objects.requireNonNull(obj2);
                                objArr2[i5] = obj2;
                                i5 += 2;
                                i4 += 2;
                                Object obj3 = objArr[i7];
                                Objects.requireNonNull(obj3);
                                objArr2[i6] = obj3;
                            }
                        }
                        objArr = objArr2;
                    }
                    if (objArr.length < this.f14671b.length) {
                        i = objArr.length >>> 1;
                    }
                }
                m3939b(i, this.f14670a, objArr);
            }
            this.f14673d = true;
            C0884i2 m4117j = C0884i2.m4117j(i, objArr, this);
            if (z && (c0842a0 = this.f14674e) != null) {
                throw c0842a0.m4080a();
            }
            return m4117j;
        }

        public ImmutableMap<K, V> build() {
            return buildOrThrow();
        }

        public ImmutableMap<K, V> buildKeepingLast() {
            return m3940a(false);
        }

        public ImmutableMap<K, V> buildOrThrow() {
            return m3940a(true);
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            boolean z;
            if (this.f14670a == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "valueComparator was already set");
            this.f14670a = (Comparator) Preconditions.checkNotNull(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            int i = (this.f14672c + 1) * 2;
            Object[] objArr = this.f14671b;
            if (i > objArr.length) {
                this.f14671b = Arrays.copyOf(objArr, ImmutableCollection.Builder.m3900a(objArr.length, i));
                this.f14673d = false;
            }
            p63.m6863g(k, v);
            Object[] objArr2 = this.f14671b;
            int i2 = this.f14672c;
            int i3 = i2 * 2;
            objArr2[i3] = k;
            objArr2[i3 + 1] = v;
            this.f14672c = i2 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }

        public Builder(int i) {
            this.f14671b = new Object[i * 2];
            this.f14672c = 0;
            this.f14673d = false;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                int size = (((Collection) iterable).size() + this.f14672c) * 2;
                Object[] objArr = this.f14671b;
                if (size > objArr.length) {
                    this.f14671b = Arrays.copyOf(objArr, ImmutableCollection.Builder.m3900a(objArr.length, size));
                    this.f14673d = false;
                }
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i) {
        p63.m6869m(i, "expectedSize");
        return new Builder<>(i);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.mo3937h()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    /* renamed from: f */
    public static AbstractMap.SimpleImmutableEntry m3922f(Object obj, Object obj2) {
        p63.m6863g(obj, obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3923of() {
        return C0884i2.f14851i;
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    /* renamed from: a */
    public abstract ImmutableSet mo3934a();

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.m3980of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.f14669d;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new y21(this), size(), null);
            this.f14669d = immutableSetMultimap2;
            return immutableSetMultimap2;
        }
        return immutableSetMultimap;
    }

    /* renamed from: c */
    public abstract ImmutableSet mo3935c();

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    /* renamed from: e */
    public abstract ImmutableCollection mo3893e();

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo3936g() {
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        if (v2 != null) {
            return v2;
        }
        return v;
    }

    /* renamed from: h */
    public abstract boolean mo3937h();

    @Override // java.util.Map
    public int hashCode() {
        return Sets.m4070b(entrySet());
    }

    /* renamed from: i */
    public UnmodifiableIterator mo3938i() {
        return new u21(entrySet().iterator(), 0);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.m4053i(this);
    }

    public Object writeReplace() {
        return new C0847b0(this);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3924of(K k, V v) {
        p63.m6863g(k, v);
        return C0884i2.m4117j(1, new Object[]{k, v}, null);
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f14666a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> mo3934a = mo3934a();
        this.f14666a = mo3934a;
        return mo3934a;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f14667b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> mo3935c = mo3935c();
        this.f14667b = mo3935c;
        return mo3935c;
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f14668c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> mo3893e = mo3893e();
        this.f14668c = mo3893e;
        return mo3893e;
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.putAll(iterable);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3925of(K k, V v, K k2, V v2) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        return C0884i2.m4117j(2, new Object[]{k, v, k2, v2}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3926of(K k, V v, K k2, V v2, K k3, V v3) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        return C0884i2.m4117j(3, new Object[]{k, v, k2, v2, k3, v3}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3927of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        return C0884i2.m4117j(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3928of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        return C0884i2.m4117j(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3929of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        return C0884i2.m4117j(6, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3930of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        return C0884i2.m4117j(7, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3931of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        p63.m6863g(k8, v8);
        return C0884i2.m4117j(8, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3932of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        p63.m6863g(k8, v8);
        p63.m6863g(k9, v9);
        return C0884i2.m4117j(9, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9}, null);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3933of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        p63.m6863g(k8, v8);
        p63.m6863g(k9, v9);
        p63.m6863g(k10, v10);
        return C0884i2.m4117j(10, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10}, null);
    }
}
