package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import p000.C1505lb;
import p000.o63;
import p000.p63;
import p000.r80;
import p000.y31;
import p000.ye0;
import p000.z31;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* renamed from: b */
    public transient ImmutableList f14695b;

    /* loaded from: classes.dex */
    public static class Builder<E> extends AbstractC0957z {

        /* renamed from: d */
        public Object[] f14696d;

        /* renamed from: e */
        public int f14697e;

        public Builder() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ AbstractC0957z add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> m3970g;
            int i = this.f14994b;
            if (i == 0) {
                return ImmutableSet.m3971of();
            }
            if (i != 1) {
                if (this.f14696d != null && ImmutableSet.m3969f(i) == this.f14696d.length) {
                    int i2 = this.f14994b;
                    Object[] objArr = this.f14993a;
                    int length = objArr.length;
                    if (i2 < (length >> 1) + (length >> 2)) {
                        objArr = Arrays.copyOf(objArr, i2);
                    }
                    int i3 = this.f14697e;
                    m3970g = new C0899l2(objArr, this.f14696d, i3, r5.length - 1, this.f14994b);
                } else {
                    m3970g = ImmutableSet.m3970g(this.f14994b, this.f14993a);
                    this.f14994b = m3970g.size();
                }
                this.f14995c = true;
                this.f14696d = null;
                return m3970g;
            }
            Object obj = this.f14993a[0];
            Objects.requireNonNull(obj);
            return ImmutableSet.m3972of(obj);
        }

        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.f14696d != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((Builder<E>) it.next());
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            Preconditions.checkNotNull(e);
            if (this.f14696d != null) {
                int m3969f = ImmutableSet.m3969f(this.f14994b);
                Object[] objArr = this.f14696d;
                if (m3969f <= objArr.length) {
                    Objects.requireNonNull(objArr);
                    int length = this.f14696d.length - 1;
                    int hashCode = e.hashCode();
                    int m6453M = o63.m6453M(hashCode);
                    while (true) {
                        int i = m6453M & length;
                        Object[] objArr2 = this.f14696d;
                        Object obj = objArr2[i];
                        if (obj == null) {
                            objArr2[i] = e;
                            this.f14697e += hashCode;
                            super.add((Object) e);
                            break;
                        }
                        if (obj.equals(e)) {
                            break;
                        }
                        m6453M = i + 1;
                    }
                    return this;
                }
            }
            this.f14696d = null;
            super.add((Object) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            Preconditions.checkNotNull(it);
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.AbstractC0957z, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            if (this.f14696d != null) {
                for (E e : eArr) {
                    add((Builder<E>) e);
                }
            } else {
                super.add((Object[]) eArr);
            }
            return this;
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i) {
        p63.m6869m(i, "expectedSize");
        Builder<E> builder = (Builder<E>) new AbstractC0957z(i);
        builder.f14696d = new Object[m3969f(i)];
        return builder;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.mo7e()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return m3970g(array.length, array);
    }

    /* renamed from: f */
    public static int m3969f(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        Preconditions.checkArgument(z, "collection too large");
        return 1073741824;
    }

    /* renamed from: g */
    public static ImmutableSet m3970g(int i, Object... objArr) {
        if (i != 0) {
            if (i != 1) {
                int m3969f = m3969f(i);
                Object[] objArr2 = new Object[m3969f];
                int i2 = m3969f - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object obj = objArr[i5];
                    if (obj != null) {
                        int hashCode = obj.hashCode();
                        int m6453M = o63.m6453M(hashCode);
                        while (true) {
                            int i6 = m6453M & i2;
                            Object obj2 = objArr2[i6];
                            if (obj2 == null) {
                                objArr[i4] = obj;
                                objArr2[i6] = obj;
                                i3 += hashCode;
                                i4++;
                                break;
                            }
                            if (obj2.equals(obj)) {
                                break;
                            }
                            m6453M++;
                        }
                    } else {
                        throw new NullPointerException(ye0.m8290j(20, i5, "at index "));
                    }
                }
                Arrays.fill(objArr, i4, i, (Object) null);
                if (i4 == 1) {
                    Object obj3 = objArr[0];
                    Objects.requireNonNull(obj3);
                    return new z31(obj3);
                }
                if (m3969f(i4) < m3969f / 2) {
                    return m3970g(i4, objArr);
                }
                int length = objArr.length;
                if (i4 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new C0899l2(objArr, objArr2, i3, i2, i4);
            }
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return m3972of(obj4);
        }
        return m3971of();
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3971of() {
        return C0899l2.f14875i;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f14695b;
        if (immutableList == null) {
            ImmutableList<E> mo3978h = mo3978h();
            this.f14695b = mo3978h;
            return mo3978h;
        }
        return immutableList;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && mo8i() && ((ImmutableSet) obj).mo8i() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.m4069a(this, obj);
    }

    /* renamed from: h */
    public ImmutableList mo3978h() {
        Object[] array = toArray();
        C1505lb c1505lb = ImmutableList.f14663b;
        return ImmutableList.m3901f(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.m4070b(this);
    }

    /* renamed from: i */
    public boolean mo8i() {
        return this instanceof r80;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new y31(toArray());
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3972of(E e) {
        return new z31(e);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3973of(E e, E e2) {
        return m3970g(2, e, e2);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3974of(E e, E e2, E e3) {
        return m3970g(3, e, e2, e3);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3975of(E e, E e2, E e3, E e4) {
        return m3970g(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3976of(E e, E e2, E e3, E e4, E e5) {
        return m3970g(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    /* renamed from: of */
    public static <E> ImmutableSet<E> m3977of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return m3970g(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m3971of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return m3972of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return m3971of();
        }
        if (length != 1) {
            return m3970g(eArr.length, (Object[]) eArr.clone());
        }
        return m3972of((Object) eArr[0]);
    }
}
