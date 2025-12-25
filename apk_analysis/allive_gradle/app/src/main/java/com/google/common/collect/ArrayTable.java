package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.C1505lb;
import p000.C1616ob;
import p000.C1681pb;

@Beta
@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class ArrayTable<R, C, V> extends AbstractC0881i implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public final ImmutableList f14613c;

    /* renamed from: d */
    public final ImmutableList f14614d;

    /* renamed from: e */
    public final ImmutableMap f14615e;

    /* renamed from: f */
    public final ImmutableMap f14616f;

    /* renamed from: g */
    public final Object[][] f14617g;

    /* renamed from: h */
    public transient C1681pb f14618h;

    /* renamed from: i */
    public transient C1681pb f14619i;

    public ArrayTable(Iterable iterable, Iterable iterable2) {
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        this.f14613c = copyOf;
        ImmutableList copyOf2 = ImmutableList.copyOf(iterable2);
        this.f14614d = copyOf2;
        Preconditions.checkArgument(copyOf.isEmpty() == copyOf2.isEmpty());
        this.f14615e = Maps.m4049e(copyOf);
        this.f14616f = Maps.m4049e(copyOf2);
        this.f14617g = (Object[][]) Array.newInstance((Class<?>) Object.class, copyOf.size(), copyOf2.size());
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: a */
    public final Iterator mo3830a() {
        return new C0886j(this, size());
    }

    @CheckForNull
    /* renamed from: at */
    public V m3831at(int i, int i2) {
        Preconditions.checkElementIndex(i, this.f14613c.size());
        Preconditions.checkElementIndex(i2, this.f14614d.size());
        return (V) this.f14617g[i][i2];
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.Table
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        Integer num = (Integer) this.f14616f.get(c);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new C1616ob(this, num.intValue(), 0);
    }

    public ImmutableList<C> columnKeyList() {
        return this.f14614d;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        C1681pb c1681pb = this.f14618h;
        if (c1681pb == null) {
            C1681pb c1681pb2 = new C1681pb(this, 0);
            this.f14618h = c1681pb2;
            return c1681pb2;
        }
        return c1681pb;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (containsRow(obj) && containsColumn(obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object obj) {
        return this.f14616f.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object obj) {
        return this.f14615e.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        for (Object[] objArr : this.f14617g) {
            for (Object obj2 : objArr) {
                if (Objects.equal(obj, obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: d */
    public final Iterator mo3832d() {
        return new C1505lb(size(), 0, this);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V erase(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = (Integer) this.f14615e.get(obj);
        Integer num2 = (Integer) this.f14616f.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (Object[] objArr : this.f14617g) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = (Integer) this.f14615e.get(obj);
        Integer num2 = (Integer) this.f14616f.get(obj2);
        if (num != null && num2 != null) {
            return m3831at(num.intValue(), num2.intValue());
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean isEmpty() {
        if (!this.f14613c.isEmpty() && !this.f14614d.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r, C c, @CheckForNull V v) {
        boolean z;
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Integer num = (Integer) this.f14615e.get(r);
        boolean z2 = false;
        if (num != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Row %s not in %s", r, this.f14613c);
        Integer num2 = (Integer) this.f14616f.get(c);
        if (num2 != null) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Column %s not in %s", c, this.f14614d);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.Table
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer num = (Integer) this.f14615e.get(r);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new C1616ob(this, num.intValue(), 1);
    }

    public ImmutableList<R> rowKeyList() {
        return this.f14613c;
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public Map<R, Map<C, V>> rowMap() {
        C1681pb c1681pb = this.f14619i;
        if (c1681pb == null) {
            C1681pb c1681pb2 = new C1681pb(this, 1);
            this.f14619i = c1681pb2;
            return c1681pb2;
        }
        return c1681pb;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V set(int i, int i2, @CheckForNull V v) {
        Preconditions.checkElementIndex(i, this.f14613c.size());
        Preconditions.checkElementIndex(i2, this.f14614d.size());
        Object[] objArr = this.f14617g[i];
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.f14614d.size() * this.f14613c.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        ImmutableList immutableList = this.f14613c;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, immutableList.size(), this.f14614d.size()));
        for (int i = 0; i < immutableList.size(); i++) {
            Object[] objArr = this.f14617g[i];
            System.arraycopy(objArr, 0, vArr[i], 0, objArr.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractC0881i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, ? extends V> table) {
        if (table instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) table);
        }
        ArrayTable<R, C, V> arrayTable = new ArrayTable<>(table.rowKeySet(), table.columnKeySet());
        arrayTable.putAll(table);
        return arrayTable;
    }

    @Override // com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.f14616f.keySet();
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public ImmutableSet<R> rowKeySet() {
        return this.f14615e.keySet();
    }

    public ArrayTable(ArrayTable arrayTable) {
        ImmutableList immutableList = arrayTable.f14613c;
        this.f14613c = immutableList;
        ImmutableList immutableList2 = arrayTable.f14614d;
        this.f14614d = immutableList2;
        this.f14615e = arrayTable.f14615e;
        this.f14616f = arrayTable.f14616f;
        Object[][] objArr = (Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size());
        this.f14617g = objArr;
        for (int i = 0; i < this.f14613c.size(); i++) {
            Object[] objArr2 = arrayTable.f14617g[i];
            System.arraycopy(objArr2, 0, objArr[i], 0, objArr2.length);
        }
    }
}
