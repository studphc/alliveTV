package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import p000.bh1;
import p000.kg1;

@GwtIncompatible
/* loaded from: classes.dex */
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    @Beta
    /* loaded from: classes.dex */
    public class StandardDescendingMap extends kg1 {
        public StandardDescendingMap() {
        }

        @Override // p000.kg1
        /* renamed from: e */
        public final NavigableMap mo3861e() {
            return ForwardingNavigableMap.this;
        }

        @Override // p000.kg1
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new C0949x(this);
        }
    }

    @Beta
    /* loaded from: classes.dex */
    public class StandardNavigableKeySet extends bh1 {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k) {
        return delegate().ceilingEntry(k);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(K k) {
        return delegate().ceilingKey(k);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract NavigableMap<K, V> delegate();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k) {
        return delegate().floorEntry(k);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(K k) {
        return delegate().floorKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        return delegate().headMap(k, z);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k) {
        return delegate().higherEntry(k);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(K k) {
        return delegate().higherKey(k);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k) {
        return delegate().lowerEntry(k);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(K k) {
        return delegate().lowerKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> standardCeilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    @CheckForNull
    public K standardCeilingKey(K k) {
        return (K) Maps.m4050f(ceilingEntry(k));
    }

    @Beta
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @CheckForNull
    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> standardFloorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    @CheckForNull
    public K standardFloorKey(K k) {
        return (K) Maps.m4050f(floorEntry(k));
    }

    public SortedMap<K, V> standardHeadMap(K k) {
        return headMap(k, false);
    }

    @CheckForNull
    public Map.Entry<K, V> standardHigherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    @CheckForNull
    public K standardHigherKey(K k) {
        return (K) Maps.m4050f(higherEntry(k));
    }

    @CheckForNull
    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> standardLowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    @CheckForNull
    public K standardLowerKey(K k) {
        return (K) Maps.m4050f(lowerEntry(k));
    }

    @CheckForNull
    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.m4035c(entrySet().iterator());
    }

    @CheckForNull
    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.m4035c(descendingMap().entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    public SortedMap<K, V> standardSubMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    public SortedMap<K, V> standardTailMap(K k) {
        return tailMap(k, true);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return delegate().subMap(k, z, k2, z2);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return delegate().tailMap(k, z);
    }
}
