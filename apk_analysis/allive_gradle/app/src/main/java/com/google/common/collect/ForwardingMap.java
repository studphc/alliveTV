package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.fg1;
import p000.hh1;
import p000.og1;
import p000.zg1;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    @Beta
    /* loaded from: classes.dex */
    public abstract class StandardEntrySet extends og1 {
        public StandardEntrySet() {
        }

        @Override // p000.og1
        /* renamed from: d */
        public final Map mo3859d() {
            return ForwardingMap.this;
        }
    }

    @Beta
    /* loaded from: classes.dex */
    public class StandardKeySet extends zg1 {
        public StandardKeySet(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    @Beta
    /* loaded from: classes.dex */
    public class StandardValues extends hh1 {
        public StandardValues(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        if (obj != this && !delegate().equals(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.m4034b(entrySet().iterator());
    }

    @Beta
    public boolean standardContainsKey(@CheckForNull Object obj) {
        return Iterators.contains(new fg1(entrySet().iterator(), 0), obj);
    }

    public boolean standardContainsValue(@CheckForNull Object obj) {
        return Iterators.contains(new fg1(entrySet().iterator(), 1), obj);
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int standardHashCode() {
        return Sets.m4070b(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Beta
    @CheckForNull
    public V standardRemove(@CheckForNull Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (Objects.equal(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return Maps.m4053i(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
