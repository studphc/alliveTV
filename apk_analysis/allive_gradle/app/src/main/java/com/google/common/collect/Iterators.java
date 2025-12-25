package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import p000.C0566bq;
import p000.C1982xg;
import p000.a61;
import p000.c61;
import p000.r51;
import p000.s51;
import p000.t51;
import p000.u51;
import p000.v51;
import p000.w51;
import p000.x51;
import p000.y51;
import p000.z51;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Iterators {
    /* renamed from: a */
    public static void m4033a(int i) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("position (");
        sb.append(i);
        sb.append(") must not be negative");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> it, int i) {
        boolean z;
        Preconditions.checkNotNull(it);
        int i2 = 0;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    public static <T> boolean all(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterator<T> it, Predicate<? super T> predicate) {
        if (indexOf(it, predicate) != -1) {
            return true;
        }
        return false;
    }

    public static <T> Enumeration<T> asEnumeration(Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new s51(it);
    }

    /* renamed from: b */
    public static void m4034b(Iterator it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    /* renamed from: c */
    public static Object m4035c(Iterator it) {
        if (it.hasNext()) {
            Object next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        return concat(new u51(new Iterator[]{it, it2}));
    }

    public static <T> Iterator<T> consumingIterator(Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new t51(it, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:
    
        if (r2.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
    
        if (r3.equals(r2.next()) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0001, code lost:
    
        if (r3 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
    
        if (r2.hasNext() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r2.next() != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean contains(Iterator<?> it, @CheckForNull Object obj) {
    }

    public static <T> Iterator<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new C1982xg(iterable);
    }

    public static boolean elementsEqual(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equal(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new C0566bq(it, predicate, 4);
    }

    public static <T> T find(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        boolean z;
        int length = tArr.length;
        if (length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkPositionIndexes(0, length, tArr.length);
        Preconditions.checkPositionIndex(0, length);
        if (length == 0) {
            return z51.f29250d;
        }
        return new z51(length, tArr);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new r51(enumeration);
    }

    public static int frequency(Iterator<?> it, @CheckForNull Object obj) {
        int i = 0;
        while (contains(it, obj)) {
            i++;
        }
        return i;
    }

    public static <T> T get(Iterator<T> it, int i) {
        m4033a(i);
        int advance = advance(it, i);
        if (it.hasNext()) {
            return it.next();
        }
        StringBuilder sb = new StringBuilder(91);
        sb.append("position (");
        sb.append(i);
        sb.append(") must be less than the number of elements that remained (");
        sb.append(advance);
        sb.append(")");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static <T> T getLast(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T getNext(Iterator<? extends T> it, T t) {
        if (it.hasNext()) {
            return it.next();
        }
        return t;
    }

    public static <T> T getOnlyElement(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder("expected one element but was: <");
        sb.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(Typography.greater);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> int indexOf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> Iterator<T> limit(Iterator<T> it, int i) {
        boolean z;
        Preconditions.checkNotNull(it);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "limit is negative");
        return new x51(it, i);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new r51(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> it, int i) {
        boolean z;
        Preconditions.checkNotNull(it);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new v51(it, i, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> it, int i) {
        boolean z;
        Preconditions.checkNotNull(it);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new v51(it, i, false);
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> it) {
        if (it instanceof c61) {
            return (c61) it;
        }
        return new c61(it);
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(T t) {
        return new y51(t);
    }

    public static int size(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.saturatedCast(j);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) Iterables.toArray(Lists.newArrayList(it), cls);
    }

    public static String toString(Iterator<?> it) {
        StringBuilder sb = new StringBuilder("[");
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new w51(it, function, 0);
    }

    public static <T> Optional<T> tryFind(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return Optional.m3770of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<? extends T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new t51(it, 0);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    public static <T> T getLast(Iterator<? extends T> it, T t) {
        return it.hasNext() ? (T) getLast(it) : t;
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> it, Class<T> cls) {
        return filter(it, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(new u51(new Iterator[]{it, it2, it3}));
    }

    public static <T> T get(Iterator<? extends T> it, int i, T t) {
        m4033a(i);
        advance(it, i);
        return (T) getNext(it, t);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @CheckForNull
    public static <T> T find(Iterator<? extends T> it, Predicate<? super T> predicate, @CheckForNull T t) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t;
    }

    public static <T> T getOnlyElement(Iterator<? extends T> it, T t) {
        return it.hasNext() ? (T) getOnlyElement(it) : t;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(new u51(new Iterator[]{it, it2, it3, it4}));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... itArr) {
        Iterator[] itArr2 = (Iterator[]) Arrays.copyOf(itArr, itArr.length);
        for (Iterator it : (Iterator[]) Preconditions.checkNotNull(itArr2)) {
            Preconditions.checkNotNull(it);
        }
        return concat(new u51(itArr2));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it) {
        a61 a61Var = (Iterator<T>) new Object();
        a61Var.f53b = z51.f29250d;
        a61Var.f54c = (Iterator) Preconditions.checkNotNull(it);
        return a61Var;
    }
}
