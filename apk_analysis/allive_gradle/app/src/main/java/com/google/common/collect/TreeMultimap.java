package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.CheckForNull;
import p000.AbstractC0543b3;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public class TreeMultimap<K, V> extends AbstractC0543b3 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient Comparator f14751h;

    /* renamed from: i */
    public transient Comparator f14752i;

    public TreeMultimap(Comparator comparator, Comparator comparator2) {
        super(new TreeMap(comparator));
        this.f14751h = comparator;
        this.f14752i = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap<>(Ordering.natural(), Ordering.natural());
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f14751h = (Comparator) Preconditions.checkNotNull((Comparator) objectInputStream.readObject());
        this.f14752i = (Comparator) Preconditions.checkNotNull((Comparator) objectInputStream.readObject());
        m7963n(new TreeMap(this.f14751h));
        AbstractC0924q2.m4160c(this, objectInputStream, objectInputStream.readInt());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(keyComparator());
        objectOutputStream.writeObject(valueComparator());
        AbstractC0924q2.m4163f(this, objectOutputStream);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) ((SortedMap) super.asMap());
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return m7961k();
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

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return m7962l();
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC0543b3, p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @GwtIncompatible
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((TreeMultimap<K, V>) obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: j */
    public final Collection mo4036j(Object obj) {
        if (obj == null) {
            keyComparator().compare(obj, obj);
        }
        return mo2006i();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.f14751h;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public NavigableSet<K> keySet() {
        return (NavigableSet) ((SortedSet) super.keySet());
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

    @Override // p000.AbstractC0543b3, p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ SortedSet removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    @Override // p000.AbstractC0543b3, p000.AbstractC0004a3, p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ SortedSet replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues(obj, iterable);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public int size() {
        return this.f28032g;
    }

    @Override // p000.AbstractC0543b3
    /* renamed from: t */
    public final SortedSet mo2006i() {
        return new TreeSet(this.f14752i);
    }

    @Override // p000.AbstractC1143e2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public Comparator<? super V> valueComparator() {
        return this.f14752i;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<>((Comparator) Preconditions.checkNotNull(comparator), (Comparator) Preconditions.checkNotNull(comparator2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC0543b3, p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @GwtIncompatible
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((TreeMultimap<K, V>) obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        TreeMultimap<K, V> treeMultimap = new TreeMultimap<>(Ordering.natural(), Ordering.natural());
        treeMultimap.putAll(multimap);
        return treeMultimap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC0543b3, p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @GwtIncompatible
    public /* bridge */ /* synthetic */ SortedSet get(Object obj) {
        return get((TreeMultimap<K, V>) obj);
    }

    @Override // p000.AbstractC0543b3, p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @GwtIncompatible
    public NavigableSet<V> get(K k) {
        return (NavigableSet) super.get((Object) k);
    }
}
