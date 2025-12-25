package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1546mf;
import p000.C1328ir;
import p000.g31;
import p000.i31;
import p000.l31;
import p000.ng1;
import p000.p63;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public abstract class ImmutableMultimap<K, V> extends AbstractC1546mf implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final transient ImmutableMap f14675f;

    /* renamed from: g */
    public final transient int f14676g;

    public ImmutableMultimap(ImmutableMap immutableMap, int i) {
        this.f14675f = immutableMap;
        this.f14676g = i;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.f14675f.mo3937h()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((Multimap) multimap);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3941of() {
        return ImmutableListMultimap.m3916of();
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f14675f.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj != null && super.containsValue(obj)) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public final Collection mo3948d() {
        return new i31(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        throw new AssertionError("unreachable");
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return new C0852c0(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        return new l31(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public abstract ImmutableCollection<V> get(K k);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        return new g31(this);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f14676g;
    }

    @Override // p000.AbstractC1143e2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @DoNotMock
    /* loaded from: classes.dex */
    public static class Builder<K, V> {

        /* renamed from: a */
        public final C1328ir f14677a = C1328ir.m5340g();

        /* renamed from: b */
        public Comparator f14678b;

        /* renamed from: c */
        public Comparator f14679c;

        /* renamed from: a */
        public Collection mo3953a() {
            return new ArrayList();
        }

        public ImmutableMultimap<K, V> build() {
            Collection entrySet = this.f14677a.entrySet();
            Comparator comparator = this.f14678b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onResultOf(ng1.f23353a).immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.m3915i(this.f14679c, entrySet);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            this.f14678b = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            this.f14679c = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            p63.m6863g(k, v);
            C1328ir c1328ir = this.f14677a;
            Collection collection = (Collection) c1328ir.get(k);
            if (collection == null) {
                collection = mo3953a();
                c1328ir.put(k, collection);
            }
            collection.add(v);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            if (k == null) {
                String valueOf = String.valueOf(Iterables.toString(iterable));
                throw new NullPointerException(valueOf.length() != 0 ? "null key in entry: null=".concat(valueOf) : new String("null key in entry: null="));
            }
            C1328ir c1328ir = this.f14677a;
            Collection collection = (Collection) c1328ir.get(k);
            if (collection != null) {
                for (V v : iterable) {
                    p63.m6863g(k, v);
                    collection.add(v);
                }
                return this;
            }
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection mo3953a = mo3953a();
            while (it.hasNext()) {
                V next = it.next();
                p63.m6863g(k, next);
                mo3953a.add(next);
            }
            c1328ir.put(k, mo3953a);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, V... vArr) {
            return putAll((Builder<K, V>) k, Arrays.asList(vArr));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3942of(K k, V v) {
        return ImmutableListMultimap.m3917of((Object) k, (Object) v);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.f14675f;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.f14675f.keySet();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public ImmutableCollection<V> removeAll(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3943of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.m3918of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3944of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.m3919of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3945of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.m3920of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m3946of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.m3921of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }
}
