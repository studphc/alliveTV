package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.ai2;
import p000.b01;
import p000.dw2;
import p000.ow0;
import p000.p63;
import p000.rv2;
import p000.ye0;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class TreeMultiset<E> extends AbstractC0866f implements Serializable {

    /* renamed from: h */
    public static final /* synthetic */ int f14753h = 0;

    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: e */
    public final transient ai2 f14754e;

    /* renamed from: f */
    public final transient ow0 f14755f;

    /* renamed from: g */
    public final transient C0915o3 f14756g;

    public TreeMultiset(ai2 ai2Var, ow0 ow0Var, C0915o3 c0915o3) {
        super(ow0Var.f24929a);
        this.f14754e = ai2Var;
        this.f14755f = ow0Var;
        this.f14756g = c0915o3;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        AbstractC0924q2.m4158a(AbstractC0866f.class, "comparator").m2001r(this, comparator);
        b01 m4158a = AbstractC0924q2.m4158a(TreeMultiset.class, "range");
        BoundType boundType = BoundType.OPEN;
        m4158a.m2001r(this, new ow0(comparator, false, null, boundType, false, null, boundType));
        AbstractC0924q2.m4158a(TreeMultiset.class, "rootReference").m2001r(this, new ai2(7));
        C0915o3 c0915o3 = new C0915o3();
        AbstractC0924q2.m4158a(TreeMultiset.class, "header").m2001r(this, c0915o3);
        c0915o3.f14925i = c0915o3;
        c0915o3.f14924h = c0915o3;
        AbstractC0924q2.m4161d(this, objectInputStream, objectInputStream.readInt());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        AbstractC0924q2.m4164g(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        Preconditions.checkArgument(this.f14755f.m6732a(e));
        ai2 ai2Var = this.f14754e;
        C0915o3 c0915o3 = (C0915o3) ai2Var.f216b;
        if (c0915o3 == null) {
            comparator().compare(e, e);
            C0915o3 c0915o32 = new C0915o3(i, e);
            C0915o3 c0915o33 = this.f14756g;
            c0915o33.f14925i = c0915o32;
            c0915o32.f14924h = c0915o33;
            c0915o32.f14925i = c0915o33;
            c0915o33.f14924h = c0915o32;
            ai2Var.m95d(c0915o3, c0915o32);
            return 0;
        }
        int[] iArr = new int[1];
        ai2Var.m95d(c0915o3, c0915o3.m4139a(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public final int mo3838b() {
        return Ints.saturatedCast(m4076g(2));
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        return new rv2(new C0905m3(this));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ow0 ow0Var = this.f14755f;
        if (!ow0Var.f24930b && !ow0Var.f24933e) {
            C0915o3 c0915o3 = this.f14756g;
            C0915o3 c0915o32 = c0915o3.f14925i;
            Objects.requireNonNull(c0915o32);
            while (c0915o32 != c0915o3) {
                C0915o3 c0915o33 = c0915o32.f14925i;
                Objects.requireNonNull(c0915o33);
                c0915o32.f14918b = 0;
                c0915o32.f14922f = null;
                c0915o32.f14923g = null;
                c0915o32.f14924h = null;
                c0915o32.f14925i = null;
                c0915o32 = c0915o33;
            }
            c0915o3.f14925i = c0915o3;
            c0915o3.f14924h = c0915o3;
            this.f14754e.f216b = null;
            return;
        }
        Iterators.m4034b(new C0905m3(this));
    }

    @Override // com.google.common.collect.SortedMultiset, p000.fl2
    public Comparator comparator() {
        return this.f14814c;
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        try {
            C0915o3 c0915o3 = (C0915o3) this.f14754e.f216b;
            if (this.f14755f.m6732a(obj) && c0915o3 != null) {
                return c0915o3.m4143e(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0905m3(this);
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    /* renamed from: e */
    public final long m4074e(int i, C0915o3 c0915o3) {
        long m8283c;
        long m4074e;
        if (c0915o3 == null) {
            return 0L;
        }
        Comparator comparator = comparator();
        ow0 ow0Var = this.f14755f;
        int compare = comparator.compare(ow0Var.f24934f, c0915o3.f14917a);
        if (compare > 0) {
            return m4074e(i, c0915o3.f14923g);
        }
        if (compare == 0) {
            int i2 = dw2.f16569a[ow0Var.f24935g.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return ye0.m8283c(i, c0915o3.f14923g);
                }
                throw new AssertionError();
            }
            m8283c = ye0.m8281a(i, c0915o3);
            m4074e = ye0.m8283c(i, c0915o3.f14923g);
        } else {
            m8283c = ye0.m8283c(i, c0915o3.f14923g) + ye0.m8281a(i, c0915o3);
            m4074e = m4074e(i, c0915o3.f14922f);
        }
        return m4074e + m8283c;
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* renamed from: f */
    public final long m4075f(int i, C0915o3 c0915o3) {
        long m8283c;
        long m4075f;
        if (c0915o3 == null) {
            return 0L;
        }
        Comparator comparator = comparator();
        ow0 ow0Var = this.f14755f;
        int compare = comparator.compare(ow0Var.f24931c, c0915o3.f14917a);
        if (compare < 0) {
            return m4075f(i, c0915o3.f14922f);
        }
        if (compare == 0) {
            int i2 = dw2.f16569a[ow0Var.f24932d.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return ye0.m8283c(i, c0915o3.f14922f);
                }
                throw new AssertionError();
            }
            m8283c = ye0.m8281a(i, c0915o3);
            m4075f = ye0.m8283c(i, c0915o3.f14922f);
        } else {
            m8283c = ye0.m8283c(i, c0915o3.f14922f) + ye0.m8281a(i, c0915o3);
            m4075f = m4075f(i, c0915o3.f14923g);
        }
        return m4075f + m8283c;
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    /* renamed from: g */
    public final long m4076g(int i) {
        C0915o3 c0915o3 = (C0915o3) this.f14754e.f216b;
        long m8283c = ye0.m8283c(i, c0915o3);
        ow0 ow0Var = this.f14755f;
        if (ow0Var.f24930b) {
            m8283c -= m4075f(i, c0915o3);
        }
        if (ow0Var.f24933e) {
            return m8283c - m4074e(i, c0915o3);
        }
        return m8283c;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return new TreeMultiset(this.f14754e, this.f14755f.m6733b(new ow0(comparator(), false, null, BoundType.OPEN, true, e, boundType)), this.f14756g);
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.m4062c(this);
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i) {
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        ai2 ai2Var = this.f14754e;
        C0915o3 c0915o3 = (C0915o3) ai2Var.f216b;
        int[] iArr = new int[1];
        try {
            if (this.f14755f.m6732a(obj) && c0915o3 != null) {
                ai2Var.m95d(c0915o3, c0915o3.m4149k(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        p63.m6869m(i, "count");
        if (!this.f14755f.m6732a(e)) {
            Preconditions.checkArgument(i == 0);
            return 0;
        }
        ai2 ai2Var = this.f14754e;
        C0915o3 c0915o3 = (C0915o3) ai2Var.f216b;
        if (c0915o3 == null) {
            if (i > 0) {
                add(e, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        ai2Var.m95d(c0915o3, c0915o3.m4155q(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(m4076g(1));
    }

    @Override // com.google.common.collect.AbstractC0866f, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return new TreeMultiset(this.f14754e, this.f14755f.m6733b(new ow0(comparator(), true, e, boundType, false, null, BoundType.OPEN)), this.f14756g);
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(Ordering.natural());
        }
        return new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    public TreeMultiset(Comparator comparator) {
        super(comparator);
        BoundType boundType = BoundType.OPEN;
        this.f14755f = new ow0(comparator, false, null, boundType, false, null, boundType);
        C0915o3 c0915o3 = new C0915o3();
        this.f14756g = c0915o3;
        c0915o3.f14925i = c0915o3;
        c0915o3.f14924h = c0915o3;
        this.f14754e = new ai2(7);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        p63.m6869m(i2, "newCount");
        p63.m6869m(i, "oldCount");
        Preconditions.checkArgument(this.f14755f.m6732a(e));
        ai2 ai2Var = this.f14754e;
        C0915o3 c0915o3 = (C0915o3) ai2Var.f216b;
        if (c0915o3 != null) {
            int[] iArr = new int[1];
            ai2Var.m95d(c0915o3, c0915o3.m4154p(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e, i2);
        }
        return true;
    }
}
