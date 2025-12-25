package kotlin.collections;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.internal.HidesMembers;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1167eq;
import p000.AbstractC1204fq;
import p000.AbstractC1278hq;
import p000.AbstractC1327iq;
import p000.AbstractC1483kq;
import p000.AbstractC1726qj;
import p000.AbstractC1919vr;
import p000.C1520lq;
import p000.C1829tb;
import p000.a10;
import p000.kh1;
import p000.ko2;
import p000.r82;
import p000.rh2;
import p000.sh2;
import p000.ye0;

/* loaded from: classes2.dex */
public abstract class CollectionsKt___CollectionsKt extends AbstractC1483kq {
    public static final <T> boolean all(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    @NotNull
    public static <T> Sequence<T> asSequence(@NotNull final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(AbstractC1204fq.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(AbstractC1204fq.collectionSizeOrDefault(iterable, 10)), 16));
        for (T t : iterable) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : iterable) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull Iterable<? extends K> iterable, @NotNull Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(AbstractC1204fq.collectionSizeOrDefault(iterable, 10)), 16));
        for (K k : iterable) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Iterable<? extends K> iterable, @NotNull M destination, @NotNull Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k : iterable) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(@NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double d = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().byteValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double d = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().doubleValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double d = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().floatValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double d = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().intValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(@NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double d = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().longValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(@NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double d = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().shortValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<List<T>> chunked(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return windowed(iterable, i, i, true);
    }

    public static <T> boolean contains(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        if (indexOf(iterable, t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> int count(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    @NotNull
    public static final <T> List<T> distinct(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return toList(toMutableSet(iterable));
    }

    @NotNull
    public static final <T, K> List<T> distinctBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (hashSet.add(selector.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> drop(@NotNull Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return toList(iterable);
            }
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                if (size == 1) {
                    return AbstractC1167eq.listOf(last(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            int i2 = 0;
            for (T t : iterable) {
                if (i2 >= i) {
                    arrayList.add(t);
                } else {
                    i2++;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static <T> List<T> dropLast(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i >= 0) {
            return take(list, r82.coerceAtLeast(list.size() - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> dropLastWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!predicate.invoke(listIterator.previous()).booleanValue()) {
                    return take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <T> List<T> dropWhile(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : iterable) {
            if (z) {
                arrayList.add(t);
            } else if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    public static final <T> T elementAt(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) elementAtOrElse(iterable, i, new C1520lq(i, 0));
    }

    public static final <T> T elementAtOrElse(@NotNull Iterable<? extends T> iterable, int i, @NotNull Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i >= 0 && i <= CollectionsKt__CollectionsKt.getLastIndex(list)) {
                return (T) list.get(i);
            }
            return defaultValue.invoke(Integer.valueOf(i));
        }
        if (i < 0) {
            return defaultValue.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    @Nullable
    public static final <T> T elementAtOrNull(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) getOrNull((List) iterable, i);
        }
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> filter(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(Integer.valueOf(i), t).booleanValue()) {
                arrayList.add(t);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(Integer.valueOf(i), t).booleanValue()) {
                destination.add(t);
            }
            i = i2;
        }
        return destination;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Iterable<?> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T> List<T> filterNot(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNotNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : iterable) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : iterable) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static final <T> T first(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @Nullable
    public static <T> T firstOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @NotNull
    public static final <T, R> List<R> flatMap(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> List<R> flatMapSequence(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R> R fold(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            r = operation.invoke(Integer.valueOf(i), r, t);
            i = i2;
        }
        return r;
    }

    public static final <T, R> R foldRight(@NotNull List<? extends T> list, R r, @NotNull Function2<? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = operation.invoke(listIterator.previous(), r);
            }
        }
        return r;
    }

    public static final <T, R> R foldRightIndexed(@NotNull List<? extends T> list, R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r);
            }
        }
        return r;
    }

    @HidesMembers
    public static final <T> void forEach(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    public static final <T> void forEachIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i), t);
            i = i2;
        }
    }

    @Nullable
    public static final <T> T getOrNull(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i >= 0 && i <= CollectionsKt__CollectionsKt.getLastIndex(list)) {
            return list.get(i);
        }
        return null;
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(t);
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull final Iterable<? extends T> iterable, @NotNull final Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new Grouping<T, K>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$groupingBy$1
            @Override // kotlin.collections.Grouping
            public K keyOf(T element) {
                return (K) keySelector.invoke(element);
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<T> sourceIterator() {
                return iterable.iterator();
            }
        };
    }

    public static final <T> int indexOf(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (T t : iterable) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(t).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = -1;
        int i2 = 0;
        for (T t : iterable) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(t).booleanValue()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @NotNull
    public static final <T> Set<T> intersect(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull Iterable<? extends T> iterable, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            ko2.appendElement(buffer, t, function1);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable joinTo$default(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Function1 function12;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(iterable, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, function12);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> T last(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> int lastIndexOf(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t);
        }
        int i = -1;
        int i2 = 0;
        for (T t2 : iterable) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, t2)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @NotNull
    public static final <T, R> List<R> map(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexedNotNull(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            R invoke = transform.invoke(Integer.valueOf(i), t);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            R invoke = transform.invoke(Integer.valueOf(i), t);
            if (invoke != null) {
                destination.add(invoke);
            }
            i = i2;
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            destination.add(transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return destination;
    }

    @NotNull
    public static final <T, R> List<R> mapNotNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Iterable<? extends T> iterable, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            R invoke = selector.invoke(next);
            do {
                T next2 = it.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it.hasNext());
            return (T) next;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m8621maxOrNull(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double maxOrThrow(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (it.hasNext()) {
            double doubleValue = it.next().doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, it.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T> T maxWithOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T maxWithOrThrow(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                Object obj2 = (T) it.next();
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (T) obj2;
                }
            }
            return (T) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T minByOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T minByOrThrow(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            R invoke = selector.invoke(next);
            do {
                T next2 = it.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it.hasNext());
            return (T) next;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m8625minOrNull(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double minOrThrow(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (it.hasNext()) {
            double doubleValue = it.next().doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, it.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T> T minWithOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T minWithOrThrow(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                Object obj2 = (T) it.next();
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (T) obj2;
                }
            }
            return (T) obj;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(iterable, 10));
        boolean z = false;
        for (T t2 : iterable) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> boolean none(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, C extends Iterable<? extends T>> C onEach(@NotNull C c, @NotNull Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return c;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(@NotNull C c, @NotNull Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        for (T t : c) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i), t);
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object) t);
        }
        ArrayList arrayList = new ArrayList();
        AbstractC1327iq.addAll(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T random(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!collection.isEmpty()) {
            return (T) elementAt(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <T> T randomOrNull(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) elementAt(collection, random.nextInt(collection.size()));
    }

    public static final <S, T extends S> S reduce(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            S next = it.next();
            while (it.hasNext()) {
                next = operation.invoke(next, it.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            S next = it.next();
            int i = 1;
            while (it.hasNext()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                next = operation.invoke(Integer.valueOf(i), next, it.next());
                i = i2;
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceIndexedOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i = 1;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            next = operation.invoke(Integer.valueOf(i), next, it.next());
            i = i2;
        }
        return next;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <S, T extends S> S reduceOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceRight(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S previous = listIterator.previous();
            while (listIterator.hasPrevious()) {
                previous = operation.invoke(listIterator.previous(), previous);
            }
            return previous;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S previous = listIterator.previous();
            while (listIterator.hasPrevious()) {
                previous = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
            }
            return previous;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceRightIndexedOrNull(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
        }
        return previous;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <S, T extends S> S reduceRightOrNull(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(listIterator.previous(), previous);
        }
        return previous;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Iterable<T> requireNoNulls(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    @NotNull
    public static final <T> List<T> reversed(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFold(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
            arrayList.add(r);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFoldIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            r = operation.invoke(Integer.valueOf(i), r, it.next());
            arrayList.add(r);
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <S, T extends S> List<S> runningReduce(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S, T extends S> List<S> runningReduceIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        int i = 1;
        while (it.hasNext()) {
            next = operation.invoke(Integer.valueOf(i), next, it.next());
            arrayList.add(next);
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, R> List<R> scan(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
            arrayList.add(r);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, R> List<R> scanIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            r = operation.invoke(Integer.valueOf(i), r, it.next());
            arrayList.add(r);
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void shuffle(@NotNull List<T> list, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            list.set(nextInt, list.set(lastIndex, list.get(nextInt)));
        }
    }

    public static <T> T single(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull List<? extends T> list, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : toList(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (list.size() > 1) {
            AbstractC1278hq.sortWith(list, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (list.size() > 1) {
            AbstractC1278hq.sortWith(list, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        AbstractC1278hq.sortWith(list, AbstractC1919vr.reverseOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            ArraysKt___ArraysJvmKt.sort((Comparable[]) array);
            return ArraysKt___ArraysJvmKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        AbstractC1278hq.sort(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return sortedWith(iterable, AbstractC1919vr.reverseOrder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> sortedWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            ArraysKt___ArraysJvmKt.sortWith(array, comparator);
            return ArraysKt___ArraysJvmKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        AbstractC1278hq.sortWith(mutableList, comparator);
        return mutableList;
    }

    @NotNull
    public static final <T> Set<T> subtract(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += selector.invoke(it.next()).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += selector.invoke(it.next()).doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(@NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().byteValue();
        }
        return i;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += it.next().doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float f = RecyclerView.f7068F0;
        while (it.hasNext()) {
            f += it.next().floatValue();
        }
        return f;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(@NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().longValue();
        }
        return j;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(@NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().shortValue();
        }
        return i;
    }

    @NotNull
    public static final <T> List<T> take(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return toList(iterable);
                }
                if (i == 1) {
                    return AbstractC1167eq.listOf(first(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator<? extends T> it = iterable.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                arrayList.add(it.next());
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> takeLast(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int size = list.size();
            if (i >= size) {
                return toList(list);
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(last((List) list));
            }
            ArrayList arrayList = new ArrayList(i);
            if (list instanceof RandomAccess) {
                for (int i2 = size - i; i2 < size; i2++) {
                    arrayList.add(list.get(i2));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> takeLastWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!predicate.invoke(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return toList(list);
    }

    @NotNull
    public static final <T> List<T> takeWhile(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!predicate.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @NotNull
    public static final boolean[] toBooleanArray(@NotNull Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = it.next().booleanValue();
            i++;
        }
        return zArr;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = it.next().byteValue();
            i++;
        }
        return bArr;
    }

    @NotNull
    public static final char[] toCharArray(@NotNull Collection<Character> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            cArr[i] = it.next().charValue();
            i++;
        }
        return cArr;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @NotNull
    public static final double[] toDoubleArray(@NotNull Collection<Double> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            dArr[i] = it.next().doubleValue();
            i++;
        }
        return dArr;
    }

    @NotNull
    public static final float[] toFloatArray(@NotNull Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = it.next().floatValue();
            i++;
        }
        return fArr;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (HashSet) toCollection(iterable, new HashSet(kh1.mapCapacity(AbstractC1204fq.collectionSizeOrDefault(iterable, 12))));
    }

    @NotNull
    public static final int[] toIntArray(@NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    @NotNull
    public static <T> List<T> toList(@NotNull Iterable<? extends T> iterable) {
        Object next;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return toMutableList(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return AbstractC1167eq.listOf(next);
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
    }

    @NotNull
    public static final long[] toLongArray(@NotNull Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return toMutableList((Collection) iterable);
        }
        return (List) toCollection(iterable, new ArrayList());
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) toCollection(iterable, new LinkedHashSet());
    }

    @NotNull
    public static <T> Set<T> toSet(@NotNull Iterable<? extends T> iterable) {
        Object next;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return (Set) toCollection(iterable, new LinkedHashSet(kh1.mapCapacity(collection.size())));
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return rh2.setOf(next);
            }
            return sh2.emptySet();
        }
        return sh2.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
    }

    @NotNull
    public static final short[] toShortArray(@NotNull Collection<Short> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            sArr[i] = it.next().shortValue();
            i++;
        }
        return sArr;
    }

    @NotNull
    public static final <T> Set<T> union(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<List<T>> windowed(@NotNull Iterable<? extends T> iterable, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            ArrayList arrayList = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
            int i3 = 0;
            while (i3 >= 0 && i3 < size) {
                int coerceAtMost = r82.coerceAtMost(i, size - i3);
                if (coerceAtMost < i && !z) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList(coerceAtMost);
                for (int i4 = 0; i4 < coerceAtMost; i4++) {
                    arrayList2.add(list.get(i4 + i3));
                }
                arrayList.add(arrayList2);
                i3 += i2;
            }
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i2, z, false);
        while (windowedIterator.hasNext()) {
            arrayList3.add((List) windowedIterator.next());
        }
        return arrayList3;
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i, i2, z);
    }

    @NotNull
    public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new C1829tb(5, iterable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> iterable, @NotNull R[] other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (T t : iterable) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(t, other[i]));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> zipWithNext(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super T, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        a10 next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(transform.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> chunked(@NotNull Iterable<? extends T> iterable, int i, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return windowed(iterable, i, i, true, transform);
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i, i2, z, function1);
    }

    public static final <T> boolean any(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : iterable) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    public static final <T> int count(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue() && (i = i + 1) < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> boolean none(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> requireNoNulls(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull List<? extends T> list, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    public static final <T> int indexOfFirst(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (predicate.invoke(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @NotNull
    public static <T> List<T> toMutableList(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(AbstractC1204fq.collectionSizeOrDefault(iterable, 10)), 16));
        for (T t : iterable) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <T> int indexOf(@NotNull List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.indexOf(t);
    }

    public static final <T> int lastIndexOf(@NotNull List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.lastIndexOf(t);
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull T[] elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!ArraysKt___ArraysKt.contains(elements, t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> plus(@NotNull Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(iterable, 10), AbstractC1204fq.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(transform.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> T first(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static <T> T singleOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Nullable
    public static <T> T firstOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T singleOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z = false;
        T t = null;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T firstOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static <T> T last(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T lastOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m8622maxOrNull(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    /* renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m8623maxOrThrow(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float floatValue = it.next().floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, it.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m8626minOrNull(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    /* renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m8627minOrThrow(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float floatValue = it.next().floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, it.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull T[] elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object[]) elements);
        }
        ArrayList arrayList = new ArrayList();
        AbstractC1327iq.addAll(arrayList, iterable);
        AbstractC1327iq.addAll(arrayList, elements);
        return arrayList;
    }

    public static final <T> T single(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<Pair<T, T>> zipWithNext(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(TuplesKt.m5575to(next, next2));
            next = next2;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T first(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Iterable<? extends T> iterable, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T lastOrNull(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection convertToListIfNotCollection = AbstractC1327iq.convertToListIfNotCollection(elements);
        if (convertToListIfNotCollection.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!convertToListIfNotCollection.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> iterable, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (T t : iterable) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(t, other[i]));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T last(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        AbstractC1327iq.addAll(arrayList, elements);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T single(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> windowed(@NotNull Iterable<? extends T> iterable, int i, int i2, boolean z, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i3 = 0;
            ArrayList arrayList = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
            MovingSubList movingSubList = new MovingSubList(list);
            while (i3 >= 0 && i3 < size) {
                int coerceAtMost = r82.coerceAtMost(i, size - i3);
                if (!z && coerceAtMost < i) {
                    break;
                }
                movingSubList.move(i3, coerceAtMost + i3);
                arrayList.add(transform.invoke(movingSubList));
                i3 += i2;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i2, z, true);
        while (windowedIterator.hasNext()) {
            arrayList2.add(transform.invoke((List) windowedIterator.next()));
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T last(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T extends Comparable<? super T>> T maxOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    @NotNull
    /* renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m8624maxOrThrow(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static <T extends Comparable<? super T>> T minOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    @NotNull
    /* renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m8628minOrThrow(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Iterable) elements);
        }
        ArrayList arrayList = new ArrayList();
        AbstractC1327iq.addAll(arrayList, iterable);
        AbstractC1327iq.addAll(arrayList, elements);
        return arrayList;
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(iterable, 10), AbstractC1204fq.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.m5575to(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        List list = SequencesKt___SequencesKt.toList(elements);
        if (list.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!list.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        AbstractC1327iq.addAll(arrayList2, elements);
        return arrayList2;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList();
        AbstractC1327iq.addAll(arrayList, iterable);
        AbstractC1327iq.addAll(arrayList, elements);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        AbstractC1327iq.addAll(arrayList, elements);
        return arrayList;
    }
}
