package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;
import p000.p63;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    /* loaded from: classes.dex */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @DoNotCall
        @Deprecated
        public ImmutableBiMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> buildOrThrow() {
            int i = this.f14672c;
            if (i == 0) {
                return ImmutableBiMap.m3882of();
            }
            if (this.f14670a != null) {
                if (this.f14673d) {
                    this.f14671b = Arrays.copyOf(this.f14671b, i * 2);
                }
                ImmutableMap.Builder.m3939b(this.f14672c, this.f14670a, this.f14671b);
            }
            this.f14673d = true;
            return new C0874g2(this.f14672c, this.f14671b);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            super.put((Builder<K, V>) k, (K) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i) {
        p63.m6869m(i, "expectedSize");
        return (Builder<K, V>) new ImmutableMap.Builder(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.mo3937h()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3882of() {
        return C0874g2.f14830k;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: e */
    public final ImmutableCollection mo3893e() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new C0847b0(this);
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3883of(K k, V v) {
        p63.m6863g(k, v);
        return new C0874g2(1, new Object[]{k, v});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3884of(K k, V v, K k2, V v2) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        return new C0874g2(2, new Object[]{k, v, k2, v2});
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new ImmutableMap.Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3885of(K k, V v, K k2, V v2, K k3, V v3) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        return new C0874g2(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3886of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        return new C0874g2(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3887of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        return new C0874g2(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3888of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        return new C0874g2(6, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3889of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        return new C0874g2(7, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3890of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        p63.m6863g(k8, v8);
        return new C0874g2(8, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3891of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        p63.m6863g(k, v);
        p63.m6863g(k2, v2);
        p63.m6863g(k3, v3);
        p63.m6863g(k4, v4);
        p63.m6863g(k5, v5);
        p63.m6863g(k6, v6);
        p63.m6863g(k7, v7);
        p63.m6863g(k8, v8);
        p63.m6863g(k9, v9);
        return new C0874g2(9, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3892of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
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
        return new C0874g2(10, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10});
    }
}
