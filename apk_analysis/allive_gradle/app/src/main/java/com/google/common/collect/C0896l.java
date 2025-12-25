package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p000.C1126dl;

/* renamed from: com.google.common.collect.l */
/* loaded from: classes.dex */
public final class C0896l extends AbstractList implements RandomAccess {

    /* renamed from: c */
    public static final /* synthetic */ int f14871c = 0;

    /* renamed from: a */
    public final transient ImmutableList f14872a;

    /* renamed from: b */
    public final transient int[] f14873b;

    public C0896l(ImmutableList immutableList) {
        this.f14872a = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = IntMath.checkedMultiply(iArr[size + 1], ((List) immutableList.get(size)).size());
            }
            this.f14873b = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    /* renamed from: a */
    public static int m4126a(C0896l c0896l, int i, int i2) {
        return (i / c0896l.f14873b[i2 + 1]) % ((List) c0896l.f14872a.get(i2)).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = list.size();
        ImmutableList immutableList = this.f14872a;
        if (size != immutableList.size()) {
            return false;
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!((List) immutableList.get(i)).contains(it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, this.f14873b[0]);
        return new C1126dl(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        int size = list.size();
        ImmutableList immutableList = this.f14872a;
        if (size != immutableList.size()) {
            return -1;
        }
        ListIterator listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int indexOf = ((List) immutableList.get(nextIndex)).indexOf(listIterator.next());
            if (indexOf == -1) {
                return -1;
            }
            i += indexOf * this.f14873b[nextIndex + 1];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        int size = list.size();
        ImmutableList immutableList = this.f14872a;
        if (size != immutableList.size()) {
            return -1;
        }
        ListIterator listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int lastIndexOf = ((List) immutableList.get(nextIndex)).lastIndexOf(listIterator.next());
            if (lastIndexOf == -1) {
                return -1;
            }
            i += lastIndexOf * this.f14873b[nextIndex + 1];
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14873b[0];
    }
}
