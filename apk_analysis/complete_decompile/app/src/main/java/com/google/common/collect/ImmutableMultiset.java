package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.n31;
import p000.o63;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public abstract class ImmutableMultiset<E> extends n31 implements Multiset<E> {

    /* renamed from: d */
    public static final /* synthetic */ int f14680d = 0;

    /* renamed from: b */
    public transient ImmutableList f14681b;

    /* renamed from: c */
    public transient ImmutableSet f14682c;

    /* loaded from: classes.dex */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {

        /* renamed from: a */
        public C0869f2 f14683a;

        /* renamed from: b */
        public boolean f14684b;

        /* renamed from: c */
        public boolean f14685c;

        public Builder(int i) {
            this.f14684b = false;
            this.f14685c = false;
            this.f14683a = new C0869f2(i, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e, int i) {
            Objects.requireNonNull(this.f14683a);
            if (i == 0) {
                return this;
            }
            if (this.f14684b) {
                this.f14683a = new C0869f2(this.f14683a);
                this.f14685c = false;
            }
            this.f14684b = false;
            Preconditions.checkNotNull(e);
            C0869f2 c0869f2 = this.f14683a;
            c0869f2.m4101m(c0869f2.m4092d(e) + i, e);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e, int i) {
            Objects.requireNonNull(this.f14683a);
            if (i == 0 && !this.f14685c) {
                C0869f2 c0869f2 = this.f14683a;
                C0869f2 c0869f22 = new C0869f2();
                c0869f22.mo4096h(c0869f2.f14821c);
                for (int mo4091c = c0869f2.mo4091c(); mo4091c != -1; mo4091c = c0869f2.mo4099k(mo4091c)) {
                    c0869f22.m4101m(c0869f2.m4094f(mo4091c), c0869f2.m4093e(mo4091c));
                }
                this.f14683a = c0869f22;
                this.f14685c = true;
            } else if (this.f14684b) {
                this.f14683a = new C0869f2(this.f14683a);
                this.f14685c = false;
            }
            this.f14684b = false;
            Preconditions.checkNotNull(e);
            if (i == 0) {
                C0869f2 c0869f23 = this.f14683a;
                c0869f23.getClass();
                c0869f23.m4102n(e, o63.m6454N(e));
            } else {
                this.f14683a.m4101m(i, Preconditions.checkNotNull(e));
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            Objects.requireNonNull(this.f14683a);
            C0869f2 c0869f2 = this.f14683a;
            if (c0869f2.f14821c == 0) {
                return ImmutableMultiset.m3955of();
            }
            if (this.f14685c) {
                this.f14683a = new C0869f2(c0869f2);
                this.f14685c = false;
            }
            this.f14684b = true;
            return new C0894k2(this.f14683a);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            return addCopies(e, 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            C0869f2 c0869f2;
            Objects.requireNonNull(this.f14683a);
            if (iterable instanceof Multiset) {
                Multiset multiset = (Multiset) iterable;
                if (multiset instanceof C0894k2) {
                    c0869f2 = ((C0894k2) multiset).f14867e;
                } else {
                    c0869f2 = multiset instanceof AbstractC0846b ? ((AbstractC0846b) multiset).f14773c : null;
                }
                if (c0869f2 != null) {
                    C0869f2 c0869f22 = this.f14683a;
                    c0869f22.m4090b(Math.max(c0869f22.f14821c, c0869f2.f14821c));
                    for (int mo4091c = c0869f2.mo4091c(); mo4091c >= 0; mo4091c = c0869f2.mo4099k(mo4091c)) {
                        addCopies(c0869f2.m4093e(mo4091c), c0869f2.m4094f(mo4091c));
                    }
                } else {
                    Set<Multiset.Entry<E>> entrySet = multiset.entrySet();
                    C0869f2 c0869f23 = this.f14683a;
                    c0869f23.m4090b(Math.max(c0869f23.f14821c, entrySet.size()));
                    for (Multiset.Entry<E> entry : multiset.entrySet()) {
                        addCopies(entry.getElement(), entry.getCount());
                    }
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        public Builder() {
            this(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return m3954f(eArr);
    }

    /* renamed from: f */
    public static ImmutableMultiset m3954f(Object... objArr) {
        return new Builder().add(objArr).build();
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3955of() {
        return C0894k2.f14866h;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f14681b;
        if (immutableList == null) {
            ImmutableList<E> asList = super.asList();
            this.f14681b = asList;
            return asList;
        }
        return immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@CheckForNull Object obj) {
        return Multisets.m4061b(this, obj);
    }

    /* renamed from: g */
    public abstract Multiset.Entry mo3962g(int i);

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.m4070b(entrySet());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int remove(@CheckForNull Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.mo7e()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(iterable instanceof Multiset ? ((Multiset) iterable).elementSet().size() : 11);
        builder.addAll((Iterable) iterable);
        return builder.build();
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3956of(E e) {
        return m3954f(e);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.f14682c;
        if (immutableSet == null) {
            immutableSet = isEmpty() ? ImmutableSet.m3971of() : new C0862e0(this);
            this.f14682c = immutableSet;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return new C0857d0(entrySet().iterator());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3957of(E e, E e2) {
        return m3954f(e, e2);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3958of(E e, E e2, E e3) {
        return m3954f(e, e2, e3);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3959of(E e, E e2, E e3, E e4) {
        return m3954f(e, e2, e3, e4);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3960of(E e, E e2, E e3, E e4, E e5) {
        return m3954f(e, e2, e3, e4, e5);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3961of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new Builder().add((Builder) e).add((Builder<E>) e2).add((Builder<E>) e3).add((Builder<E>) e4).add((Builder<E>) e5).add((Builder<E>) e6).add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new Builder().addAll((Iterator) it).build();
    }
}
