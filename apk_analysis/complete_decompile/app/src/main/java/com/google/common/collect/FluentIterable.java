package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import p000.ps0;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public abstract class FluentIterable<E> implements Iterable<E> {

    /* renamed from: a */
    public final Optional f14637a;

    public FluentIterable() {
        this.f14637a = Optional.absent();
    }

    /* renamed from: a */
    public static ps0 m3855a(Iterable... iterableArr) {
        for (Iterable iterable : iterableArr) {
            Preconditions.checkNotNull(iterable);
        }
        return new ps0(4, iterableArr);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return m3855a(iterable, iterable2);
    }

    public static <E> FluentIterable<E> from(Iterable<E> iterable) {
        if (iterable instanceof FluentIterable) {
            return (FluentIterable) iterable;
        }
        return new ps0(iterable, iterable);
    }

    @Beta
    /* renamed from: of */
    public static <E> FluentIterable<E> m3856of() {
        return from(Collections.emptyList());
    }

    public final boolean allMatch(Predicate<? super E> predicate) {
        return Iterables.all(m3858b(), predicate);
    }

    public final boolean anyMatch(Predicate<? super E> predicate) {
        return Iterables.any(m3858b(), predicate);
    }

    @Beta
    public final FluentIterable<E> append(Iterable<? extends E> iterable) {
        return concat(m3858b(), iterable);
    }

    /* renamed from: b */
    public final Iterable m3858b() {
        return (Iterable) this.f14637a.mo3773or((Optional) this);
    }

    public final boolean contains(@CheckForNull Object obj) {
        return Iterables.contains(m3858b(), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C copyInto(C c) {
        Preconditions.checkNotNull(c);
        Iterable m3858b = m3858b();
        if (m3858b instanceof Collection) {
            c.addAll((Collection) m3858b);
        } else {
            Iterator it = m3858b.iterator();
            while (it.hasNext()) {
                c.add(it.next());
            }
        }
        return c;
    }

    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(m3858b()));
    }

    public final FluentIterable<E> filter(Predicate<? super E> predicate) {
        return from(Iterables.filter(m3858b(), predicate));
    }

    public final Optional<E> first() {
        Iterator it = m3858b().iterator();
        if (it.hasNext()) {
            return Optional.m3770of(it.next());
        }
        return Optional.absent();
    }

    public final Optional<E> firstMatch(Predicate<? super E> predicate) {
        return Iterables.tryFind(m3858b(), predicate);
    }

    public final E get(int i) {
        return (E) Iterables.get(m3858b(), i);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> function) {
        return Multimaps.index(m3858b(), function);
    }

    public final boolean isEmpty() {
        return !m3858b().iterator().hasNext();
    }

    @Beta
    public final String join(Joiner joiner) {
        return joiner.join(this);
    }

    public final Optional<E> last() {
        Object next;
        Iterable m3858b = m3858b();
        if (m3858b instanceof List) {
            List list = (List) m3858b;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.m3770of(list.get(list.size() - 1));
        }
        Iterator it = m3858b.iterator();
        if (!it.hasNext()) {
            return Optional.absent();
        }
        if (m3858b instanceof SortedSet) {
            return Optional.m3770of(((SortedSet) m3858b).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return Optional.m3770of(next);
    }

    public final FluentIterable<E> limit(int i) {
        return from(Iterables.limit(m3858b(), i));
    }

    public final int size() {
        return Iterables.size(m3858b());
    }

    public final FluentIterable<E> skip(int i) {
        return from(Iterables.skip(m3858b(), i));
    }

    @GwtIncompatible
    public final E[] toArray(Class<E> cls) {
        return (E[]) Iterables.toArray(m3858b(), cls);
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(m3858b());
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> function) {
        return Maps.toMap(m3858b(), function);
    }

    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(m3858b());
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(m3858b());
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(m3858b());
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, m3858b());
    }

    public String toString() {
        return Iterables.toString(m3858b());
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> function) {
        return from(Iterables.transform(m3858b(), function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function) {
        return concat(transform(function));
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> function) {
        return Maps.uniqueIndex(m3858b(), function);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return m3855a(iterable, iterable2, iterable3);
    }

    @Beta
    /* renamed from: of */
    public static <E> FluentIterable<E> m3857of(E e, E... eArr) {
        return from(Lists.asList(e, eArr));
    }

    @Beta
    public final FluentIterable<E> append(E... eArr) {
        return concat(m3858b(), Arrays.asList(eArr));
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> filter(Class<T> cls) {
        return from(Iterables.filter((Iterable<?>) m3858b(), cls));
    }

    public FluentIterable(Iterable iterable) {
        this.f14637a = Optional.m3770of(iterable);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return m3855a(iterable, iterable2, iterable3, iterable4);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T>... iterableArr) {
        return m3855a((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    @Beta
    public static <E> FluentIterable<E> from(E[] eArr) {
        return from(Arrays.asList(eArr));
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new ps0(1, iterable);
    }

    @InlineMe(replacement = "checkNotNull(iterable)", staticImports = {"com.google.common.base.Preconditions.checkNotNull"})
    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> fluentIterable) {
        return (FluentIterable) Preconditions.checkNotNull(fluentIterable);
    }
}
