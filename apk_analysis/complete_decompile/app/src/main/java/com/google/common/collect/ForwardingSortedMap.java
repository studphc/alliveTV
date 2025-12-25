package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import p000.dh1;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    @Beta
    /* loaded from: classes.dex */
    public class StandardKeySet extends dh1 {
        public StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
            super(forwardingSortedMap);
        }
    }

    @Override // java.util.SortedMap
    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return delegate().headMap(k);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    @Beta
    public boolean standardContainsKey(@CheckForNull Object obj) {
        int compare;
        try {
            K firstKey = tailMap(obj).firstKey();
            Comparator<? super K> comparator = comparator();
            if (comparator == null) {
                compare = ((Comparable) firstKey).compareTo(obj);
            } else {
                compare = comparator.compare(firstKey, obj);
            }
            if (compare != 0) {
                return false;
            }
            return true;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public SortedMap<K, V> standardSubMap(K k, K k2) {
        int compare;
        boolean z;
        Comparator<? super K> comparator = comparator();
        if (comparator == null) {
            compare = ((Comparable) k).compareTo(k2);
        } else {
            compare = comparator.compare(k, k2);
        }
        if (compare <= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return delegate().subMap(k, k2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return delegate().tailMap(k);
    }
}
