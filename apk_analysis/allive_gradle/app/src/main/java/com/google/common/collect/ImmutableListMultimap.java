package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;
import p000.b01;
import p000.j31;
import p000.t80;
import p000.ye0;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient ImmutableListMultimap f14664h;

    /* loaded from: classes.dex */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap) super.build();
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
            super.putAll((Builder<K, V>) k, (Object[]) vArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            super.putAll((Multimap) multimap);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return m3916of();
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) multimap;
            if (!immutableListMultimap.f14675f.mo3937h()) {
                return immutableListMultimap;
            }
        }
        return m3915i(null, multimap.asMap().entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.common.collect.ImmutableListMultimap, com.google.common.collect.ImmutableMultimap] */
    /* renamed from: i */
    public static ImmutableListMultimap m3915i(Comparator comparator, Collection collection) {
        ImmutableList sortedCopyOf;
        if (collection.isEmpty()) {
            return m3916of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                sortedCopyOf = ImmutableList.copyOf(collection2);
            } else {
                sortedCopyOf = ImmutableList.sortedCopyOf(comparator, collection2);
            }
            if (!sortedCopyOf.isEmpty()) {
                builder.put(key, sortedCopyOf);
                i = sortedCopyOf.size() + i;
            }
        }
        return new ImmutableMultimap(builder.buildOrThrow(), i);
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3916of() {
        return t80.f26717i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        builder2.add((ImmutableList.Builder) objectInputStream.readObject());
                    }
                    builder.put(readObject, builder2.build());
                    i += readInt2;
                } else {
                    throw new InvalidObjectException(ye0.m8290j(31, readInt2, "Invalid value count "));
                }
            }
            try {
                j31.f20360a.m2001r(this, builder.buildOrThrow());
                b01 b01Var = j31.f20361b;
                b01Var.getClass();
                try {
                    ((Field) b01Var.f7833b).set(this, Integer.valueOf(i));
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
        objectOutputStream.defaultWriteObject();
        AbstractC0924q2.m4163f(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3917of(K k, V v) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.f14664h;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        Builder builder = builder();
        UnmodifiableIterator<Map.Entry<K, V>> it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            builder.put((Builder) next.getValue(), (Object) next.getKey());
        }
        ImmutableListMultimap<V, K> build = builder.build();
        build.f14664h = this;
        this.f14664h = build;
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public ImmutableList<V> get(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.f14675f.get(k);
        return immutableList == null ? ImmutableList.m3902of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final ImmutableList<V> removeAll(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3918of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        return builder.build();
    }

    @Beta
    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().putAll((Iterable) iterable).build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3919of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3920of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        builder.put((Builder) k4, (K) v4);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3921of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        builder.put((Builder) k4, (K) v4);
        builder.put((Builder) k5, (K) v5);
        return builder.build();
    }
}
