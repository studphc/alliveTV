package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.CheckForNull;
import p000.an2;
import p000.bw2;
import p000.cb0;
import p000.cw2;
import p000.gh2;
import p000.ig1;

@GwtCompatible(serializable = true)
/* loaded from: classes.dex */
public class TreeBasedTable<R, C, V> extends an2 {
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final Comparator f14750h;

    public TreeBasedTable(Comparator comparator, Comparator comparator2) {
        super(new TreeMap(comparator), new bw2(comparator2));
        this.f14750h = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public Map column(Object obj) {
        return new ig1(this, obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.f14750h;
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.C0855c3
    /* renamed from: f */
    public final Iterator mo4073f() {
        Comparator<? super C> columnComparator = columnComparator();
        return new gh2(Iterators.mergeSorted(Iterables.transform(this.f14788c.values(), new cb0(5)), columnComparator), columnComparator);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.f14788c.isEmpty();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC0881i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public SortedMap<C, V> row(R r) {
        return new cw2(this, r, null, null);
    }

    @Override // p000.an2, com.google.common.collect.C0855c3, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // p000.an2, com.google.common.collect.C0855c3, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
