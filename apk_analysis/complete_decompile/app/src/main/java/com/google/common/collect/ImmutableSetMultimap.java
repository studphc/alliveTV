package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.C1484kr;
import p000.a41;
import p000.b01;
import p000.j31;
import p000.ng1;
import p000.u80;
import p000.ye0;
import p000.z31;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final transient ImmutableSet f14698h;

    /* renamed from: i */
    public transient ImmutableSetMultimap f14699i;

    /* renamed from: j */
    public transient z31 f14700j;

    /* loaded from: classes.dex */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        /* renamed from: a */
        public final Collection mo3953a() {
            return C1484kr.m5765d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableSetMultimap<K, V> build() {
            Collection entrySet = this.f14677a.entrySet();
            Comparator comparator = this.f14678b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onResultOf(ng1.f23353a).immutableSortedCopy(entrySet);
            }
            return ImmutableSetMultimap.m3979i(this.f14679c, entrySet);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            super.orderKeysBy((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            super.orderValuesBy((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            super.put((Builder<K, V>) k, (K) v);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object obj, Iterable iterable) {
            return putAll((Builder<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object obj, Object[] objArr) {
            return putAll((Builder<K, V>) obj, objArr);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            super.putAll((Builder<K, V>) k, (Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, V... vArr) {
            return putAll((Builder<K, V>) k, (Iterable) Arrays.asList(vArr));
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }
    }

    public ImmutableSetMultimap(ImmutableMap immutableMap, int i, Comparator comparator) {
        super(immutableMap, i);
        ImmutableSet m4015l;
        if (comparator == null) {
            m4015l = ImmutableSet.m3971of();
        } else {
            m4015l = ImmutableSortedSet.m4015l(comparator);
        }
        this.f14698h = m4015l;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty()) {
            return m3980of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.f14675f.mo3937h()) {
                return immutableSetMultimap;
            }
        }
        return m3979i(null, multimap.asMap().entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public static ImmutableSetMultimap m3979i(Comparator comparator, Collection collection) {
        AbstractCollection copyOf;
        if (collection.isEmpty()) {
            return m3980of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                copyOf = ImmutableSet.copyOf(collection2);
            } else {
                copyOf = ImmutableSortedSet.copyOf(comparator, collection2);
            }
            if (!copyOf.isEmpty()) {
                builder.put(key, copyOf);
                i = copyOf.size() + i;
            }
        }
        return new ImmutableSetMultimap(builder.buildOrThrow(), i, comparator);
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3980of() {
        return u80.f27146k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        Object m4015l;
        ImmutableCollection.Builder builder;
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Builder builder2 = ImmutableMap.builder();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    if (comparator == null) {
                        builder = new ImmutableSet.Builder();
                    } else {
                        builder = new ImmutableSortedSet.Builder(comparator);
                    }
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        builder.add((ImmutableCollection.Builder) objectInputStream.readObject());
                    }
                    ImmutableSet build = builder.build();
                    if (build.size() == readInt2) {
                        builder2.put(readObject, build);
                        i += readInt2;
                    } else {
                        String valueOf = String.valueOf(readObject);
                        throw new InvalidObjectException(AbstractC1726qj.m7054j(valueOf.length() + 40, "Duplicate key-value pairs exist for key ", valueOf));
                    }
                } else {
                    throw new InvalidObjectException(ye0.m8290j(31, readInt2, "Invalid value count "));
                }
            }
            try {
                j31.f20360a.m2001r(this, builder2.buildOrThrow());
                b01 b01Var = j31.f20361b;
                b01Var.getClass();
                try {
                    ((Field) b01Var.f7833b).set(this, Integer.valueOf(i));
                    b01 b01Var2 = a41.f37a;
                    if (comparator == null) {
                        m4015l = ImmutableSet.m3971of();
                    } else {
                        m4015l = ImmutableSortedSet.m4015l(comparator);
                    }
                    b01Var2.m2001r(this, m4015l);
                    return;
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        }
        throw new InvalidObjectException(ye0.m8290j(29, readInt, "Invalid key count "));
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        Comparator comparator;
        objectOutputStream.defaultWriteObject();
        ImmutableSet immutableSet = this.f14698h;
        if (immutableSet instanceof ImmutableSortedSet) {
            comparator = ((ImmutableSortedSet) immutableSet).comparator();
        } else {
            comparator = null;
        }
        objectOutputStream.writeObject(comparator);
        AbstractC0924q2.m4163f(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3981of(K k, V v) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.f14699i;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        Builder builder = builder();
        UnmodifiableIterator<Map.Entry<K, V>> it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            builder.put((Builder) next.getValue(), (Object) next.getKey());
        }
        ImmutableSetMultimap<V, K> build = builder.build();
        build.f14699i = this;
        this.f14699i = build;
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        z31 z31Var = this.f14700j;
        if (z31Var != null) {
            return z31Var;
        }
        z31 z31Var2 = new z31((ImmutableSetMultimap) this);
        this.f14700j = z31Var2;
        return z31Var2;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public ImmutableSet<V> get(K k) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.f14675f.get(k), this.f14698h);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final ImmutableSet<V> removeAll(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3982of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        return builder.build();
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().putAll((Iterable) iterable).build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3983of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3984of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        builder.put((Builder) k4, (K) v4);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3985of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        builder.put((Builder) k4, (K) v4);
        builder.put((Builder) k5, (K) v5);
        return builder.build();
    }
}
