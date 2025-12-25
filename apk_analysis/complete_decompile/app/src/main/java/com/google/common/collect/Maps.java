package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;
import p000.ah1;
import p000.eh1;
import p000.fr2;
import p000.gh1;
import p000.ig1;
import p000.jg1;
import p000.k21;
import p000.m21;
import p000.ng1;
import p000.p63;
import p000.pr2;
import p000.qg1;
import p000.sg1;
import p000.ug1;
import p000.wg1;
import p000.x21;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Maps {

    /* loaded from: classes.dex */
    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(K k, V1 v1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static Map m4045a(AbstractMap abstractMap) {
        if (abstractMap instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) abstractMap);
        }
        return Collections.unmodifiableMap(abstractMap);
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> biMap) {
        return new jg1(biMap);
    }

    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        return new ig1(set, function);
    }

    /* renamed from: b */
    public static x21 m4046b(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        Preconditions.checkNotNull(entry);
        return new x21(entry, 1);
    }

    /* renamed from: c */
    public static int m4047c(int i) {
        if (i < 3) {
            p63.m6869m(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: d */
    public static void m4048d(Map map, Map map2, Equivalence equivalence, AbstractMap abstractMap, AbstractMap abstractMap2, AbstractMap abstractMap3, AbstractMap abstractMap4) {
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (map2.containsKey(key)) {
                Object remove = abstractMap2.remove(key);
                if (equivalence.equivalent(value, remove)) {
                    abstractMap3.put(key, value);
                } else {
                    abstractMap4.put(key, new C0950x0(value, remove));
                }
            } else {
                abstractMap.put(key, value);
            }
        }
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        if (map instanceof SortedMap) {
            return difference((SortedMap) map, (Map) map2);
        }
        return difference(map, map2, Equivalence.equals());
    }

    /* renamed from: e */
    public static ImmutableMap m4049e(Collection collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            builder.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return builder.buildOrThrow();
    }

    /* renamed from: f */
    public static Object m4050f(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (map instanceof sg1) {
            sg1 sg1Var = (sg1) map;
            return new sg1(sg1Var.f26415d, Predicates.and(sg1Var.f26416e, predicate));
        }
        return new sg1((Map) Preconditions.checkNotNull(map), predicate);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return filterEntries((NavigableMap) navigableMap, Predicates.compose(predicate, ng1.f23353a));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return filterEntries((BiMap) biMap, Predicates.compose(predicate, ng1.f23354b));
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            Object nextElement = propertyNames.nextElement();
            Objects.requireNonNull(nextElement);
            String str = (String) nextElement;
            String property = properties.getProperty(str);
            Objects.requireNonNull(property);
            builder.put(str, property);
        }
        return builder.buildOrThrow();
    }

    /* renamed from: g */
    public static boolean m4051g(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: h */
    public static Object m4052h(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: i */
    public static String m4053i(Map map) {
        int size = map.size();
        p63.m6869m(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> immutableEntry(K k, V v) {
        return new k21(k, v);
    }

    @GwtCompatible(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof m21) {
            return (m21) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.m3923of();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        p63.m6863g(key, value);
        EnumMap enumMap = new EnumMap(key.getDeclaringClass());
        enumMap.put((EnumMap) key, (K) value);
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            p63.m6863g(key2, value2);
            enumMap.put((EnumMap) key2, (K) value2);
        }
        int size = enumMap.size();
        if (size != 0) {
            if (size != 1) {
                return new m21(enumMap);
            }
            Map.Entry entry = (Map.Entry) Iterables.getOnlyElement(enumMap.entrySet());
            return ImmutableMap.m3924of((Enum) entry.getKey(), entry.getValue());
        }
        return ImmutableMap.m3923of();
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> cls) {
        return new EnumMap<>((Class) Preconditions.checkNotNull(cls));
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(m4047c(i));
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new LinkedHashMap<>(m4047c(i));
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> navigableMap, Range<K> range) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            if (navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            if (lowerBoundType == boundType) {
                z = true;
            } else {
                z = false;
            }
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() == boundType) {
                z3 = true;
            }
            return navigableMap.subMap(lowerEndpoint, z, upperEndpoint, z3);
        }
        if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() == BoundType.CLOSED) {
                z3 = true;
            }
            return navigableMap.tailMap(lowerEndpoint2, z3);
        }
        if (range.hasUpperBound()) {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() == BoundType.CLOSED) {
                z3 = true;
            }
            return navigableMap.headMap(upperEndpoint2, z3);
        }
        return (NavigableMap) Preconditions.checkNotNull(navigableMap);
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> biMap) {
        if (!(biMap instanceof fr2) && !(biMap instanceof ImmutableBiMap)) {
            return new fr2(biMap, null, null);
        }
        return biMap;
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return (NavigableMap<K, V>) new pr2(navigableMap, null);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> iterable, Function<? super K, V> function) {
        return toMap(iterable.iterator(), function);
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new C0938u0(map, entryTransformer);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> map, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries(map, new C0926r0(function));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> iterable, Function<? super V, K> function) {
        return uniqueIndex(iterable.iterator(), function);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> biMap) {
        return new eh1(biMap, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        if (navigableMap instanceof gh1) {
            return navigableMap;
        }
        return new gh1(navigableMap);
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return (SortedMap<K, V>) new ig1(sortedSet, function);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> it, Function<? super K, V> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            K next = it.next();
            builder.put(next, function.apply(next));
        }
        return builder.buildKeepingLast();
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return (SortedMap<K, V2>) new C0938u0(sortedMap, entryTransformer);
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.buildOrThrow();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.valueOf(e.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return filterEntries((SortedMap) sortedMap, Predicates.compose(predicate, ng1.f23353a));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> map, Predicate<? super V> predicate) {
        return filterEntries(map, Predicates.compose(predicate, ng1.f23354b));
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@CheckForNull Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new ah1(navigableSet, function);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return (NavigableMap<K, V2>) new C0938u0(navigableMap, entryTransformer);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> navigableMap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((NavigableMap) navigableMap, (EntryTransformer) new C0926r0(function));
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap newLinkedHashMap2 = newLinkedHashMap();
        LinkedHashMap newLinkedHashMap3 = newLinkedHashMap();
        m4048d(map, map2, equivalence, newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
        return new C0930s0(newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> map, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        Predicate compose = Predicates.compose(predicate, ng1.f23353a);
        if (map instanceof sg1) {
            sg1 sg1Var = (sg1) map;
            return new sg1(sg1Var.f26415d, Predicates.and(sg1Var.f26416e, compose));
        }
        return new sg1((Map) Preconditions.checkNotNull(map), predicate, compose);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return filterEntries((NavigableMap) navigableMap, Predicates.compose(predicate, ng1.f23354b));
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (sortedMap instanceof wg1) {
            wg1 wg1Var = (wg1) sortedMap;
            return (SortedMap<K, V>) new sg1((SortedMap) wg1Var.f26415d, Predicates.and(wg1Var.f26416e, predicate));
        }
        return (SortedMap<K, V>) new sg1((SortedMap) Preconditions.checkNotNull(sortedMap), predicate);
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return filterEntries((SortedMap) sortedMap, Predicates.compose(predicate, ng1.f23354b));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((SortedMap) sortedMap, (EntryTransformer) new C0926r0(function));
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = Ordering.natural();
        }
        TreeMap newTreeMap = newTreeMap(comparator);
        TreeMap newTreeMap2 = newTreeMap(comparator);
        newTreeMap2.putAll(map);
        TreeMap newTreeMap3 = newTreeMap(comparator);
        TreeMap newTreeMap4 = newTreeMap(comparator);
        m4048d(sortedMap, map, Equivalence.equals(), newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
        return (SortedMapDifference<K, V>) new C0930s0(newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        return filterEntries((BiMap) biMap, Predicates.compose(predicate, ng1.f23353a));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (navigableMap instanceof ug1) {
            ug1 ug1Var = (ug1) navigableMap;
            return new ug1(ug1Var.f27256a, Predicates.and(ug1Var.f27257b, predicate));
        }
        return new ug1((NavigableMap) Preconditions.checkNotNull(navigableMap), predicate);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        if (biMap instanceof qg1) {
            qg1 qg1Var = (qg1) biMap;
            return new qg1((BiMap) qg1Var.f26415d, Predicates.and(qg1Var.f26416e, predicate));
        }
        return new qg1(biMap, predicate);
    }
}
