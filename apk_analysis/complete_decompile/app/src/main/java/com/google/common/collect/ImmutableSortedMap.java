package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.p63;
import p000.v21;
import p000.we0;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public final class ImmutableSortedMap<K, V> extends AbstractC0877h0 implements NavigableMap<K, V> {

    /* renamed from: i */
    public static final Ordering f14701i = Ordering.natural();

    /* renamed from: j */
    public static final ImmutableSortedMap f14702j = new ImmutableSortedMap(ImmutableSortedSet.m4015l(Ordering.natural()), ImmutableList.m3902of(), null);
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final transient C0909n2 f14703f;

    /* renamed from: g */
    public final transient ImmutableList f14704g;

    /* renamed from: h */
    public final transient ImmutableSortedMap f14705h;

    /* loaded from: classes.dex */
    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {

        /* renamed from: f */
        public transient Object[] f14706f = new Object[4];

        /* renamed from: g */
        public transient Object[] f14707g = new Object[4];

        /* renamed from: h */
        public final Comparator f14708h;

        public Builder(Comparator<? super K> comparator) {
            this.f14708h = (Comparator) Preconditions.checkNotNull(comparator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @DoNotCall
        @Deprecated
        public final ImmutableSortedMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> buildOrThrow() {
            int i = this.f14672c;
            Comparator comparator = this.f14708h;
            if (i == 0) {
                return ImmutableSortedMap.m3988l(comparator);
            }
            if (i != 1) {
                Object[] copyOf = Arrays.copyOf(this.f14706f, i);
                Arrays.sort(copyOf, comparator);
                int i2 = this.f14672c;
                Object[] objArr = new Object[i2];
                for (int i3 = 0; i3 < this.f14672c; i3++) {
                    if (i3 > 0) {
                        int i4 = i3 - 1;
                        if (comparator.compare(copyOf[i4], copyOf[i3]) == 0) {
                            String valueOf = String.valueOf(copyOf[i4]);
                            String valueOf2 = String.valueOf(copyOf[i3]);
                            throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 57, "keys required to be distinct but compared as equal: ", valueOf, " and ", valueOf2));
                        }
                    }
                    Object obj = this.f14706f[i3];
                    Objects.requireNonNull(obj);
                    int binarySearch = Arrays.binarySearch(copyOf, obj, comparator);
                    Object obj2 = this.f14707g[i3];
                    Objects.requireNonNull(obj2);
                    objArr[binarySearch] = obj2;
                }
                return new ImmutableSortedMap<>(new C0909n2(ImmutableList.m3901f(copyOf.length, copyOf), comparator), ImmutableList.m3901f(i2, objArr), null);
            }
            Object obj3 = this.f14706f[0];
            Objects.requireNonNull(obj3);
            Object obj4 = this.f14707g[0];
            Objects.requireNonNull(obj4);
            return ImmutableSortedMap.m4002p(obj3, obj4, comparator);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @Beta
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        @CanIgnoreReturnValue
        public final Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            int i = this.f14672c + 1;
            Object[] objArr = this.f14706f;
            if (i > objArr.length) {
                int m3900a = ImmutableCollection.Builder.m3900a(objArr.length, i);
                this.f14706f = Arrays.copyOf(this.f14706f, m3900a);
                this.f14707g = Arrays.copyOf(this.f14707g, m3900a);
            }
            p63.m6863g(k, v);
            Object[] objArr2 = this.f14706f;
            int i2 = this.f14672c;
            objArr2[i2] = k;
            this.f14707g[i2] = v;
            this.f14672c = i2 + 1;
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
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }
    }

    public ImmutableSortedMap(C0909n2 c0909n2, ImmutableList immutableList, ImmutableSortedMap immutableSortedMap) {
        this.f14703f = c0909n2;
        this.f14704g = immutableList;
        this.f14705h = immutableSortedMap;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return m3987k(map, f14701i);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = f14701i;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.mo3937h()) {
                return immutableSortedMap;
            }
        }
        Collection entrySet = sortedMap.entrySet();
        Map.Entry[] entryArr = ImmutableMap.f14665e;
        if (!(entrySet instanceof Collection)) {
            entrySet = Lists.newArrayList(entrySet.iterator());
        }
        Map.Entry[] entryArr2 = (Map.Entry[]) entrySet.toArray(entryArr);
        return m3989m(comparator, true, entryArr2, entryArr2.length);
    }

    /* renamed from: k */
    public static ImmutableSortedMap m3987k(Map map, Comparator comparator) {
        boolean z = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 == null) {
                if (comparator == f14701i) {
                    z = true;
                }
            } else {
                z = comparator.equals(comparator2);
            }
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.mo3937h()) {
                return immutableSortedMap;
            }
        }
        Collection entrySet = map.entrySet();
        Map.Entry[] entryArr = ImmutableMap.f14665e;
        if (!(entrySet instanceof Collection)) {
            entrySet = Lists.newArrayList(entrySet.iterator());
        }
        Map.Entry[] entryArr2 = (Map.Entry[]) entrySet.toArray(entryArr);
        return m3989m(comparator, z, entryArr2, entryArr2.length);
    }

    /* renamed from: l */
    public static ImmutableSortedMap m3988l(Comparator comparator) {
        if (Ordering.natural().equals(comparator)) {
            return m3991of();
        }
        return new ImmutableSortedMap(ImmutableSortedSet.m4015l(comparator), ImmutableList.m3902of(), null);
    }

    /* renamed from: m */
    public static ImmutableSortedMap m3989m(Comparator comparator, boolean z, Map.Entry[] entryArr, int i) {
        if (i != 0) {
            int i2 = 1;
            if (i != 1) {
                Object[] objArr = new Object[i];
                Object[] objArr2 = new Object[i];
                if (z) {
                    for (int i3 = 0; i3 < i; i3++) {
                        Map.Entry entry = entryArr[i3];
                        Objects.requireNonNull(entry);
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        p63.m6863g(key, value);
                        objArr[i3] = key;
                        objArr2[i3] = value;
                    }
                } else {
                    Arrays.sort(entryArr, 0, i, new we0(1, comparator));
                    Map.Entry entry2 = entryArr[0];
                    Objects.requireNonNull(entry2);
                    Object key2 = entry2.getKey();
                    objArr[0] = key2;
                    Object value2 = entry2.getValue();
                    objArr2[0] = value2;
                    p63.m6863g(objArr[0], value2);
                    while (i2 < i) {
                        Map.Entry entry3 = entryArr[i2 - 1];
                        Objects.requireNonNull(entry3);
                        Map.Entry entry4 = entryArr[i2];
                        Objects.requireNonNull(entry4);
                        Object key3 = entry4.getKey();
                        Object value3 = entry4.getValue();
                        p63.m6863g(key3, value3);
                        objArr[i2] = key3;
                        objArr2[i2] = value3;
                        if (comparator.compare(key2, key3) != 0) {
                            i2++;
                            key2 = key3;
                        } else {
                            String valueOf = String.valueOf(entry3);
                            String valueOf2 = String.valueOf(entry4);
                            throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 37, "Multiple entries with same key: ", valueOf, " and ", valueOf2));
                        }
                    }
                }
                return new ImmutableSortedMap(new C0909n2(ImmutableList.m3901f(i, objArr), comparator), ImmutableList.m3901f(i, objArr2), null);
            }
            Map.Entry entry5 = entryArr[0];
            Objects.requireNonNull(entry5);
            return m4002p(entry5.getKey(), entry5.getValue(), comparator);
        }
        return m3988l(comparator);
    }

    /* renamed from: n */
    public static ImmutableSortedMap m3990n(Map.Entry... entryArr) {
        return m3989m(Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    /* renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m3991of() {
        return f14702j;
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    /* renamed from: p */
    public static ImmutableSortedMap m4002p(Object obj, Object obj2, Comparator comparator) {
        return new ImmutableSortedMap(new C0909n2(ImmutableList.m3903of(obj), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.m3903of(obj2), null);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: a */
    public final ImmutableSet mo3934a() {
        if (isEmpty()) {
            return ImmutableSet.m3971of();
        }
        return new v21(this, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: c */
    public final ImmutableSet mo3935c() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(K k) {
        return (K) Maps.m4050f(ceilingEntry(k));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: e */
    public final ImmutableCollection mo3893e() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(K k) {
        return (K) Maps.m4050f(floorEntry(k));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int indexOf = this.f14703f.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.f14704g.get(indexOf);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        if (!this.f14703f.f14907e.mo7e() && !this.f14704g.mo7e()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
        return headMap((ImmutableSortedMap<K, V>) obj, z);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(K k) {
        return (K) Maps.m4050f(higherEntry(k));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(K k) {
        return (K) Maps.m4050f(lowerEntry(k));
    }

    /* renamed from: o */
    public final ImmutableSortedMap m4003o(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return m3988l(comparator());
        }
        return new ImmutableSortedMap(this.f14703f.m4136p(i, i2), this.f14704g.subList(i, i2), null);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f14704g.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return subMap((boolean) obj, z, (boolean) obj2, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
        return tailMap((ImmutableSortedMap<K, V>) obj, z);
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new C0872g0(this);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3992of(Comparable comparable, Object obj) {
        return m4002p(comparable, obj, Ordering.natural());
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.f14703f.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.f14705h;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return m3988l(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap<>((C0909n2) this.f14703f.descendingSet(), this.f14704g.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.f14703f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        return this.f14704g;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return m3987k(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3993of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f14703f;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap((boolean) k, true, (boolean) k2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, true);
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, f14701i);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3994of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3));
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return m4003o(0, this.f14703f.m4137q(Preconditions.checkNotNull(k), z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(k2);
        Preconditions.checkArgument(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return headMap((ImmutableSortedMap<K, V>) k2, z2).tailMap((ImmutableSortedMap<K, V>) k, z);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return m4003o(this.f14703f.m4138r(Preconditions.checkNotNull(k), z), size());
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3995of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4));
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        Collection newArrayList;
        Comparator comparator2 = (Comparator) Preconditions.checkNotNull(comparator);
        Map.Entry[] entryArr = ImmutableMap.f14665e;
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = Lists.newArrayList(iterable.iterator());
        }
        Map.Entry[] entryArr2 = (Map.Entry[]) newArrayList.toArray(entryArr);
        return m3989m(comparator2, false, entryArr2, entryArr2.length);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3996of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4), ImmutableMap.m3922f(comparable5, obj5));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3997of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4), ImmutableMap.m3922f(comparable5, obj5), ImmutableMap.m3922f(comparable6, obj6));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3998of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4), ImmutableMap.m3922f(comparable5, obj5), ImmutableMap.m3922f(comparable6, obj6), ImmutableMap.m3922f(comparable7, obj7));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3999of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4), ImmutableMap.m3922f(comparable5, obj5), ImmutableMap.m3922f(comparable6, obj6), ImmutableMap.m3922f(comparable7, obj7), ImmutableMap.m3922f(comparable8, obj8));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m4000of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8, Comparable comparable9, Object obj9) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4), ImmutableMap.m3922f(comparable5, obj5), ImmutableMap.m3922f(comparable6, obj6), ImmutableMap.m3922f(comparable7, obj7), ImmutableMap.m3922f(comparable8, obj8), ImmutableMap.m3922f(comparable9, obj9));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m4001of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8, Comparable comparable9, Object obj9, Comparable comparable10, Object obj10) {
        return m3990n(ImmutableMap.m3922f(comparable, obj), ImmutableMap.m3922f(comparable2, obj2), ImmutableMap.m3922f(comparable3, obj3), ImmutableMap.m3922f(comparable4, obj4), ImmutableMap.m3922f(comparable5, obj5), ImmutableMap.m3922f(comparable6, obj6), ImmutableMap.m3922f(comparable7, obj7), ImmutableMap.m3922f(comparable8, obj8), ImmutableMap.m3922f(comparable9, obj9), ImmutableMap.m3922f(comparable10, obj10));
    }
}
