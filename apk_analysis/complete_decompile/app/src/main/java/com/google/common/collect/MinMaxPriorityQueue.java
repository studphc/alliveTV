package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.CheckForNull;
import p000.ag1;
import p000.ho1;
import p000.jz2;

@Beta
@GwtCompatible
/* loaded from: classes.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {

    /* renamed from: a */
    public final jz2 f14736a;

    /* renamed from: b */
    public final jz2 f14737b;

    /* renamed from: c */
    public final int f14738c;

    /* renamed from: d */
    public Object[] f14739d;

    /* renamed from: e */
    public int f14740e;

    /* renamed from: f */
    public int f14741f;

    @Beta
    /* loaded from: classes.dex */
    public static final class Builder<B> {

        /* renamed from: a */
        public final Comparator f14742a;

        /* renamed from: b */
        public int f14743b = -1;

        /* renamed from: c */
        public int f14744c = Integer.MAX_VALUE;

        public Builder(Comparator comparator) {
            this.f14742a = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i) {
            boolean z;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f14743b = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i) {
            boolean z;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f14744c = i;
            return this;
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            int i = this.f14743b;
            int i2 = this.f14744c;
            if (i == -1) {
                i = 11;
            }
            if (iterable instanceof Collection) {
                i = Math.max(i, ((Collection) iterable).size());
            }
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, Math.min(i - 1, i2) + 1);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }
    }

    public MinMaxPriorityQueue(Builder builder, int i) {
        Ordering from = Ordering.from(builder.f14742a);
        jz2 jz2Var = new jz2(this, from, 7);
        this.f14736a = jz2Var;
        jz2 jz2Var2 = new jz2(this, from.reverse(), 7);
        this.f14737b = jz2Var2;
        jz2Var.f20699c = jz2Var2;
        jz2Var2.f20699c = jz2Var;
        this.f14738c = builder.f14744c;
        this.f14739d = new Object[i];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static Builder<Comparable> expectedSize(int i) {
        return new Builder(Ordering.natural()).expectedSize(i);
    }

    public static Builder<Comparable> maximumSize(int i) {
        return new Builder(Ordering.natural()).maximumSize(i);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    /* renamed from: a */
    public final Object m4054a(int i) {
        Object obj = this.f14739d[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public final int m4055b() {
        int i = this.f14740e;
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            jz2 jz2Var = this.f14737b;
            MinMaxPriorityQueue minMaxPriorityQueue = (MinMaxPriorityQueue) jz2Var.f20700d;
            if (((Ordering) jz2Var.f20698b).compare(minMaxPriorityQueue.m4054a(1), minMaxPriorityQueue.m4054a(2)) <= 0) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    /* renamed from: c */
    public final jz2 m4056c(int i) {
        boolean z = true;
        int i2 = ~(~(i + 1));
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkState(z, "negative index");
        if ((1431655765 & i2) > (i2 & (-1431655766))) {
            return this.f14736a;
        }
        return this.f14737b;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.f14740e; i++) {
            this.f14739d[i] = null;
        }
        this.f14740e = 0;
    }

    public Comparator<? super E> comparator() {
        return (Ordering) this.f14736a.f20698b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ag1 m4057d(int i) {
        int i2;
        int i3;
        int m5471i;
        MinMaxPriorityQueue minMaxPriorityQueue;
        Object m4054a;
        Preconditions.checkPositionIndex(i, this.f14740e);
        this.f14741f++;
        int i4 = this.f14740e - 1;
        this.f14740e = i4;
        ag1 ag1Var = null;
        if (i4 == i) {
            this.f14739d[i4] = null;
            return null;
        }
        Object m4054a2 = m4054a(i4);
        jz2 m4056c = m4056c(this.f14740e);
        MinMaxPriorityQueue minMaxPriorityQueue2 = (MinMaxPriorityQueue) m4056c.f20700d;
        int m5468j = jz2.m5468j(minMaxPriorityQueue2.f14740e);
        if (m5468j != 0 && (i2 = (jz2.m5468j(m5468j) * 2) + 2) != m5468j && (i2 * 2) + 1 >= minMaxPriorityQueue2.f14740e) {
            Object m4054a3 = minMaxPriorityQueue2.m4054a(i2);
            if (((Ordering) m4056c.f20698b).compare(m4054a3, m4054a2) < 0) {
                Object[] objArr = minMaxPriorityQueue2.f14739d;
                objArr[i2] = m4054a2;
                objArr[minMaxPriorityQueue2.f14740e] = m4054a3;
                if (i2 != i) {
                    this.f14739d[this.f14740e] = null;
                    return null;
                }
                Object m4054a4 = m4054a(this.f14740e);
                this.f14739d[this.f14740e] = null;
                jz2 m4056c2 = m4056c(i);
                int i5 = i;
                while (true) {
                    m4056c2.getClass();
                    i3 = (i5 * 2) + 1;
                    if (i3 < 0) {
                        m5471i = -1;
                    } else {
                        m5471i = m4056c2.m5471i((i3 * 2) + 1, 4);
                    }
                    minMaxPriorityQueue = (MinMaxPriorityQueue) m4056c2.f20700d;
                    if (m5471i <= 0) {
                        break;
                    }
                    minMaxPriorityQueue.f14739d[i5] = minMaxPriorityQueue.m4054a(m5471i);
                    i5 = m5471i;
                }
                int m5469g = m4056c2.m5469g(i5, m4054a4);
                if (m5469g == i5) {
                    int m5471i2 = m4056c2.m5471i(i3, 2);
                    if (m5471i2 > 0) {
                        if (((Ordering) m4056c2.f20698b).compare(minMaxPriorityQueue.m4054a(m5471i2), m4054a4) < 0) {
                            minMaxPriorityQueue.f14739d[i5] = minMaxPriorityQueue.m4054a(m5471i2);
                            minMaxPriorityQueue.f14739d[m5471i2] = m4054a4;
                            if (m5471i2 != i5) {
                                if (m5471i2 < i) {
                                    m4054a = minMaxPriorityQueue.m4054a(i);
                                } else {
                                    m4054a = minMaxPriorityQueue.m4054a(jz2.m5468j(i));
                                }
                                if (((jz2) m4056c2.f20699c).m5469g(m5471i2, m4054a4) < i) {
                                    ag1Var = new ag1(m4054a4, m4054a);
                                }
                            }
                        }
                    }
                    m5471i2 = m4056c2.m5470h(i5, m4054a4);
                    if (m5471i2 != i5) {
                    }
                } else if (m5469g < i) {
                    ag1Var = new ag1(m4054a4, m4054a(i));
                }
                if (i2 < i) {
                    if (ag1Var == null) {
                        return new ag1(m4054a2, m4054a4);
                    }
                    return new ag1(m4054a2, ag1Var.f181b);
                }
                return ag1Var;
            }
        }
        i2 = minMaxPriorityQueue2.f14740e;
        if (i2 != i) {
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new ho1(this);
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e) {
        int checkedMultiply;
        Preconditions.checkNotNull(e);
        this.f14741f++;
        int i = this.f14740e;
        int i2 = i + 1;
        this.f14740e = i2;
        Object[] objArr = this.f14739d;
        int length = objArr.length;
        int i3 = this.f14738c;
        if (i2 > length) {
            int length2 = objArr.length;
            if (length2 < 64) {
                checkedMultiply = (length2 + 1) * 2;
            } else {
                checkedMultiply = IntMath.checkedMultiply(length2 / 2, 3);
            }
            Object[] objArr2 = new Object[Math.min(checkedMultiply - 1, i3) + 1];
            Object[] objArr3 = this.f14739d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f14739d = objArr2;
        }
        jz2 m4056c = m4056c(i);
        int m5470h = m4056c.m5470h(i, e);
        if (m5470h != i) {
            m4056c = (jz2) m4056c.f20699c;
            i = m5470h;
        }
        m4056c.m5469g(i, e);
        if (this.f14740e <= i3 || pollLast() != e) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) m4054a(0);
    }

    @CheckForNull
    public E peekFirst() {
        return peek();
    }

    @CheckForNull
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return (E) m4054a(m4055b());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) m4054a(0);
        m4057d(0);
        return e;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        int m4055b = m4055b();
        E e = (E) m4054a(m4055b);
        m4057d(m4055b);
        return e;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            int m4055b = m4055b();
            E e = (E) m4054a(m4055b);
            m4057d(m4055b);
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f14740e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = this.f14740e;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f14739d, 0, objArr, 0, i);
        return objArr;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
