package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.C1845tr;
import p000.ds2;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ImmutableTable<R, C, V> extends AbstractC0881i implements Serializable {

    @DoNotMock
    /* loaded from: classes.dex */
    public static final class Builder<R, C, V> {

        /* renamed from: a */
        public final ArrayList f14718a = Lists.newArrayList();

        /* renamed from: b */
        public Comparator f14719b;

        /* renamed from: c */
        public Comparator f14720c;

        public ImmutableTable<R, C, V> build() {
            return buildOrThrow();
        }

        public ImmutableTable<R, C, V> buildOrThrow() {
            ImmutableSet copyOf;
            ImmutableSet copyOf2;
            ArrayList<Table.Cell> arrayList = this.f14718a;
            int size = arrayList.size();
            if (size != 0) {
                if (size != 1) {
                    Comparator comparator = this.f14719b;
                    Comparator comparator2 = this.f14720c;
                    Preconditions.checkNotNull(arrayList);
                    if (comparator != null || comparator2 != null) {
                        Collections.sort(arrayList, new C1845tr(comparator, comparator2, 2));
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    ImmutableList copyOf3 = ImmutableList.copyOf((Iterable) arrayList);
                    for (Table.Cell cell : arrayList) {
                        linkedHashSet.add(cell.getRowKey());
                        linkedHashSet2.add(cell.getColumnKey());
                    }
                    if (comparator == null) {
                        copyOf = ImmutableSet.copyOf((Collection) linkedHashSet);
                    } else {
                        copyOf = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
                    }
                    if (comparator2 == null) {
                        copyOf2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
                    } else {
                        copyOf2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
                    }
                    return AbstractC0919p2.m4157j(copyOf3, copyOf, copyOf2);
                }
                Table.Cell cell2 = (Table.Cell) Iterables.getOnlyElement(arrayList);
                return new C0948w2(cell2.getRowKey(), cell2.getColumnKey(), cell2.getValue());
            }
            return ImmutableTable.m4024of();
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> comparator) {
            this.f14720c = (Comparator) Preconditions.checkNotNull(comparator, "columnComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> orderRowsBy(Comparator<? super R> comparator) {
            this.f14719b = (Comparator) Preconditions.checkNotNull(comparator, "rowComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> put(R r, C c, V v) {
            this.f14718a.add(ImmutableTable.m4023e(r, c, v));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> table) {
            Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> it = table.cellSet().iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof ds2) {
                ds2 ds2Var = (ds2) cell;
                Preconditions.checkNotNull(ds2Var.f16530a, "row");
                Preconditions.checkNotNull(ds2Var.f16531b, "column");
                Preconditions.checkNotNull(ds2Var.f16532c, "value");
                this.f14718a.add(cell);
            } else {
                put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder<>();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> table) {
        if (table instanceof ImmutableTable) {
            return (ImmutableTable) table;
        }
        Set<Table.Cell<? extends R, ? extends C, ? extends V>> cellSet = table.cellSet();
        Builder builder = builder();
        Iterator<T> it = cellSet.iterator();
        while (it.hasNext()) {
            builder.put((Table.Cell) it.next());
        }
        return builder.build();
    }

    /* renamed from: e */
    public static Table.Cell m4023e(Object obj, Object obj2, Object obj3) {
        return Tables.immutableCell(Preconditions.checkNotNull(obj, "rowKey"), Preconditions.checkNotNull(obj2, "columnKey"), Preconditions.checkNotNull(obj3, "value"));
    }

    /* renamed from: of */
    public static <R, C, V> ImmutableTable<R, C, V> m4024of() {
        return C0845a3.f14768g;
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: a */
    public final Iterator mo3830a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Table
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (get(obj, obj2) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: d */
    public final Iterator mo3832d() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet mo4026b();

    /* renamed from: g */
    public abstract C0902m0 mo4029g();

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableCollection mo4027c();

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.AbstractC0881i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final Object writeReplace() {
        return mo4029g();
    }

    /* renamed from: of */
    public static <R, C, V> ImmutableTable<R, C, V> m4025of(R r, C c, V v) {
        return new C0948w2(r, c, v);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c, "columnKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) columnMap().get(c), ImmutableMap.m3923of());
    }

    @Override // com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<C, V> row(R r) {
        Preconditions.checkNotNull(r, "rowKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) rowMap().get(r), ImmutableMap.m3923of());
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }
}
