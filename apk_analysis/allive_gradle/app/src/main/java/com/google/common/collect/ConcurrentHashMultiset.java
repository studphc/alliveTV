package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import p000.AbstractC1848tu;
import p000.C1811su;
import p000.p63;

@GwtIncompatible
/* loaded from: classes.dex */
public final class ConcurrentHashMultiset<E> extends AbstractC0856d implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: c */
    public final transient ConcurrentMap f14624c;

    public ConcurrentHashMultiset(ConcurrentMap concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.f14624c = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        AbstractC1848tu.f26958a.m2001r(this, (ConcurrentMap) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f14624c);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: a */
    public final Set mo3837a() {
        return new C1811su(this.f14624c.keySet(), 0);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        ConcurrentMap concurrentMap;
        AtomicInteger atomicInteger;
        int i2;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e);
        if (i == 0) {
            return count(e);
        }
        p63.m6873q(i, "occurrences");
        do {
            concurrentMap = this.f14624c;
            atomicInteger = (AtomicInteger) Maps.m4052h(concurrentMap, e);
            if (atomicInteger == null && (atomicInteger = (AtomicInteger) concurrentMap.putIfAbsent(e, new AtomicInteger(i))) == null) {
                return 0;
            }
            do {
                i2 = atomicInteger.get();
                if (i2 != 0) {
                    try {
                    } catch (ArithmeticException unused) {
                        StringBuilder sb = new StringBuilder(65);
                        sb.append("Overflow adding ");
                        sb.append(i);
                        sb.append(" occurrences to a count of ");
                        sb.append(i2);
                        throw new IllegalArgumentException(sb.toString());
                    }
                } else {
                    atomicInteger2 = new AtomicInteger(i);
                    if (concurrentMap.putIfAbsent(e, atomicInteger2) == null) {
                        break;
                    }
                }
            } while (!atomicInteger.compareAndSet(i2, IntMath.checkedAdd(i2, i)));
            return i2;
        } while (!concurrentMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public final int mo3838b() {
        return this.f14624c.size();
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f14624c.clear();
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.m4052h(this.f14624c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.AbstractC0856d
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new C0911o(this);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0906n(this, new C0901m(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final ArrayList m3841e() {
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
        for (Multiset.Entry entry : entrySet()) {
            Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                newArrayListWithExpectedSize.add(element);
            }
        }
        return newArrayListWithExpectedSize;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f14624c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.m4062c(this);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        p63.m6873q(i, "occurrences");
        ConcurrentMap concurrentMap = this.f14624c;
        AtomicInteger atomicInteger = (AtomicInteger) Maps.m4052h(concurrentMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            concurrentMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@CheckForNull Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        p63.m6873q(i, "occurrences");
        ConcurrentMap concurrentMap = this.f14624c;
        AtomicInteger atomicInteger = (AtomicInteger) Maps.m4052h(concurrentMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            concurrentMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        ConcurrentMap concurrentMap;
        AtomicInteger atomicInteger;
        int i2;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e);
        p63.m6869m(i, "count");
        do {
            concurrentMap = this.f14624c;
            atomicInteger = (AtomicInteger) Maps.m4052h(concurrentMap, e);
            if (atomicInteger == null && (i == 0 || (atomicInteger = (AtomicInteger) concurrentMap.putIfAbsent(e, new AtomicInteger(i))) == null)) {
                return 0;
            }
            do {
                i2 = atomicInteger.get();
                if (i2 == 0) {
                    if (i != 0) {
                        atomicInteger2 = new AtomicInteger(i);
                        if (concurrentMap.putIfAbsent(e, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i2, i));
            if (i == 0) {
                concurrentMap.remove(e, atomicInteger);
            }
            return i2;
        } while (!concurrentMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long j = 0;
        while (this.f14624c.values().iterator().hasNext()) {
            j += ((AtomicInteger) r0.next()).get();
        }
        return Ints.saturatedCast(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return m3841e().toArray();
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) m3841e().toArray(tArr);
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        Preconditions.checkNotNull(e);
        p63.m6869m(i, "oldCount");
        p63.m6869m(i2, "newCount");
        ConcurrentMap concurrentMap = this.f14624c;
        AtomicInteger atomicInteger = (AtomicInteger) Maps.m4052h(concurrentMap, e);
        if (atomicInteger == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || concurrentMap.putIfAbsent(e, new AtomicInteger(i2)) == null;
        }
        int i3 = atomicInteger.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    concurrentMap.remove(e, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                return concurrentMap.putIfAbsent(e, atomicInteger2) == null || concurrentMap.replace(e, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i3, i2)) {
                if (i2 == 0) {
                    concurrentMap.remove(e, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
