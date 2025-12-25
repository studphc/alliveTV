package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC0004a3;
import p000.AbstractC1930w1;
import p000.C1328ir;
import p000.C1484kr;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public final class HashMultimap<K, V> extends AbstractC0004a3 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient int f14658h;

    public HashMultimap(int i, int i2) {
        super(new C1328ir(i));
        boolean z;
        this.f14658h = 2;
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f14658h = i2;
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap<>(12, 2);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f14658h = 2;
        int readInt = objectInputStream.readInt();
        m7963n(new C1328ir(12));
        AbstractC0924q2.m4160c(this, objectInputStream, readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        AbstractC0924q2.m4163f(this, objectOutputStream);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f28031f.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: i */
    public final Collection mo2006i() {
        return new C1484kr(this.f14658h);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues(obj, iterable);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public int size() {
        return this.f28032g;
    }

    @Override // p000.AbstractC1143e2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K, V> HashMultimap<K, V> create(int i, int i2) {
        return new HashMultimap<>(i, i2);
    }

    public static <K, V> HashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        HashMultimap<K, V> hashMultimap = (HashMultimap<K, V>) new AbstractC1930w1(new C1328ir(multimap.keySet().size()));
        hashMultimap.f14658h = 2;
        hashMultimap.putAll(multimap);
        return hashMultimap;
    }
}
