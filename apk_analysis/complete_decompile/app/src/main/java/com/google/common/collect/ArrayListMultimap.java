package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1179f1;
import p000.C1328ir;
import p000.p63;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public final class ArrayListMultimap<K, V> extends AbstractC1179f1 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient int f14612h;

    public ArrayListMultimap(int i, int i2) {
        super(new C1328ir(i));
        p63.m6869m(i2, "expectedValuesPerKey");
        this.f14612h = i2;
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap<>(12, 3);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f14612h = 3;
        int readInt = objectInputStream.readInt();
        m7963n(C1328ir.m5340g());
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

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // p000.AbstractC1179f1, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return super.get(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: i */
    public final Collection mo2006i() {
        return new ArrayList(this.f14612h);
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

    @Override // p000.AbstractC1179f1, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ List removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    @Override // p000.AbstractC1179f1, p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
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

    @Deprecated
    public void trimToSize() {
        Iterator<V> it = this.f28031f.values().iterator();
        while (it.hasNext()) {
            ((ArrayList) ((Collection) it.next())).trimToSize();
        }
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

    public static <K, V> ArrayListMultimap<K, V> create(int i, int i2) {
        return new ArrayListMultimap<>(i, i2);
    }

    public static <K, V> ArrayListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        ArrayListMultimap<K, V> arrayListMultimap = new ArrayListMultimap<>(multimap.keySet().size(), multimap instanceof ArrayListMultimap ? ((ArrayListMultimap) multimap).f14612h : 3);
        arrayListMultimap.putAll(multimap);
        return arrayListMultimap;
    }
}
