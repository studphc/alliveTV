package kotlin.collections;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC0002a1;
import p000.AbstractC1167eq;
import p000.AbstractC1204fq;
import p000.AbstractC1327iq;
import p000.AbstractC1483kq;
import p000.AbstractC1726qj;
import p000.AbstractC1755rb;
import p000.AbstractC1919vr;
import p000.C1829tb;
import p000.C1866ub;
import p000.C1903vb;
import p000.C1940wb;
import p000.C1977xb;
import p000.kh1;
import p000.ko2;
import p000.r82;
import p000.rh2;
import p000.sh2;
import p000.ye0;

/* loaded from: classes2.dex */
public abstract class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static final <T> boolean all(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return !(tArr.length == 0);
    }

    @NotNull
    public static <T> Iterable<T> asIterable(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    @NotNull
    public static <T> Sequence<T> asSequence(@NotNull final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(tArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(tArr.length), 16));
        for (AbstractC0002a1 abstractC0002a1 : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(abstractC0002a1);
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : tArr) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(t);
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull K[] kArr, @NotNull Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(kArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(kArr.length), 16));
        for (K k : kArr) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull K[] kArr, @NotNull M destination, @NotNull Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(kArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k : kArr) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    public static final double average(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (byte b : bArr) {
            d += b;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(@NotNull Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (Byte b : bArr) {
            d += b.byteValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (Double d2 : dArr) {
            d += d2.doubleValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (Float f : fArr) {
            d += f.floatValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (Integer num : numArr) {
            d += num.intValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(@NotNull Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (Long l : lArr) {
            d += l.longValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(@NotNull Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (Short sh : shArr) {
            d += sh.shortValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static <T> boolean contains(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return indexOf(tArr, t) >= 0;
    }

    public static final <T> int count(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final <T> List<T> distinct(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(tArr));
    }

    @NotNull
    public static final <T, K> List<T> distinctBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (hashSet.add(selector.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> drop(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i >= 0) {
            return takeLast(tArr, r82.coerceAtLeast(tArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> dropLast(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i >= 0) {
            return take(tArr, r82.coerceAtLeast(tArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> dropLastWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(tArr[lastIndex]).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <T> List<T> dropWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : tArr) {
            if (z) {
                arrayList.add(t);
            } else if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filter(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = tArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), t).booleanValue()) {
                arrayList.add(t);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = tArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), t).booleanValue()) {
                destination.add(t);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Object[] objArr, C destination) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T> List<T> filterNot(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> filterNotNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull T[] tArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : tArr) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static final <T> T first(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    @NotNull
    public static final <T, R> List<R> flatMap(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(t));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> List<R> flatMapSequence(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(t));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(t));
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(t));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R fold(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (AbstractC0002a1 abstractC0002a1 : tArr) {
            r = operation.invoke(r, abstractC0002a1);
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, tArr[i]);
            i++;
            i2++;
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRight(@NotNull T[] tArr, R r, @NotNull Function2<? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(tArr[lastIndex], r);
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRightIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r);
        }
        return r;
    }

    public static final <T> void forEach(@NotNull T[] tArr, @NotNull Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (T t : tArr) {
            action.invoke(t);
        }
    }

    public static final <T> void forEachIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), tArr[i]);
            i++;
            i2++;
        }
    }

    @NotNull
    public static final <T> IntRange getIndices(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IntRange(0, getLastIndex(tArr));
    }

    public static <T> int getLastIndex(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    @Nullable
    public static <T> T getOrNull(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0 || i > getLastIndex(tArr)) {
            return null;
        }
        return tArr[i];
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
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
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : tArr) {
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
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull final T[] tArr, @NotNull final Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new Grouping<T, K>() { // from class: kotlin.collections.ArraysKt___ArraysKt$groupingBy$1
            @Override // kotlin.collections.Grouping
            public K keyOf(T element) {
                return (K) keySelector.invoke(element);
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<T> sourceIterator() {
                return ArrayIteratorKt.iterator(tArr);
            }
        };
    }

    public static <T> int indexOf(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (Intrinsics.areEqual(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(tArr[i]).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T> Set<T> intersect(@NotNull T[] tArr, @NotNull Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull T[] tArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : tArr) {
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

    @NotNull
    public static final <T> String joinToString(@NotNull T[] tArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> T last(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> int lastIndexOf(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (t == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (Intrinsics.areEqual(t, tArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @NotNull
    public static final <T, R> List<R> map(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(transform.invoke(t));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexedNotNull(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            R invoke = transform.invoke(Integer.valueOf(i2), tArr[i]);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            R invoke = transform.invoke(Integer.valueOf(i2), tArr[i]);
            if (invoke != null) {
                destination.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <T, R> List<R> mapNotNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            destination.add(transform.invoke(t));
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            T t2 = tArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(t2);
            if (invoke.compareTo(invoke2) < 0) {
                t = t2;
                invoke = invoke2;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length != 0) {
            T t = tArr[0];
            int lastIndex = getLastIndex(tArr);
            if (lastIndex == 0) {
                return t;
            }
            R invoke = selector.invoke(t);
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                T t2 = tArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) < 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double maxOrNull(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, dArr[it.nextInt()].doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double maxOrThrow(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            double doubleValue = dArr[0].doubleValue();
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, dArr[it.nextInt()].doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T> T maxWithOrNull(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (comparator.compare(t, t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T maxWithOrThrow(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length != 0) {
            T t = tArr[0];
            ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (comparator.compare(t, t2) < 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T minByOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            T t2 = tArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(t2);
            if (invoke.compareTo(invoke2) > 0) {
                t = t2;
                invoke = invoke2;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T minByOrThrow(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length != 0) {
            T t = tArr[0];
            int lastIndex = getLastIndex(tArr);
            if (lastIndex == 0) {
                return t;
            }
            R invoke = selector.invoke(t);
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                T t2 = tArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) > 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double minOrNull(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, dArr[it.nextInt()].doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double minOrThrow(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            double doubleValue = dArr[0].doubleValue();
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, dArr[it.nextInt()].doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T> T minWithOrNull(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (comparator.compare(t, t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T minWithOrThrow(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length != 0) {
            T t = tArr[0];
            ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (comparator.compare(t, t2) > 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    public static final <T> boolean none(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T random(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length != 0) {
            return tArr[random.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <T> T randomOrNull(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.nextInt(tArr.length)];
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final <S, T extends S> S reduce(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length != 0) {
            S s = (S) tArr[0];
            ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                s = operation.invoke(s, (Object) tArr[it.nextInt()]);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final <S, T extends S> S reduceIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length != 0) {
            S s = (S) tArr[0];
            ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                s = operation.invoke(Integer.valueOf(nextInt), s, (Object) tArr[nextInt]);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceIndexedOrNull(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s = (S) tArr[0];
        ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            s = operation.invoke(Integer.valueOf(nextInt), s, (Object) tArr[nextInt]);
        }
        return s;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <S, T extends S> S reduceOrNull(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s = (S) tArr[0];
        ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
        while (it.hasNext()) {
            s = operation.invoke(s, (Object) tArr[it.nextInt()]);
        }
        return s;
    }

    public static final <S, T extends S> S reduceRight(@NotNull T[] tArr, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            S s = (S) tArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                s = operation.invoke((Object) tArr[i], s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            S s = (S) tArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                s = operation.invoke(Integer.valueOf(i), (Object) tArr[i], s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceRightIndexedOrNull(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s = (S) tArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            s = operation.invoke(Integer.valueOf(i), (Object) tArr[i], s);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <S, T extends S> S reduceRightOrNull(@NotNull T[] tArr, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s = (S) tArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            s = operation.invoke((Object) tArr[i], s);
        }
        return s;
    }

    @NotNull
    public static final <T> T[] requireNoNulls(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        for (T t : tArr) {
            if (t == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    public static final <T> void reverse(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(tArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            T t = tArr[nextInt];
            tArr[nextInt] = tArr[lastIndex];
            tArr[lastIndex] = t;
            lastIndex--;
        }
    }

    @NotNull
    public static final <T> List<T> reversed(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T> T[] reversedArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) AbstractC1755rb.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            tArr2[lastIndex - nextInt] = tArr[nextInt];
        }
        return tArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFold(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        for (AbstractC0002a1 abstractC0002a1 : tArr) {
            r = operation.invoke(r, abstractC0002a1);
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFoldIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, tArr[i]);
            arrayList.add(r);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <S, T extends S> List<S> runningReduce(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        S s = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s);
        int length = tArr.length;
        for (int i = 1; i < length; i++) {
            s = operation.invoke(s, (Object) tArr[i]);
            arrayList.add(s);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S, T extends S> List<S> runningReduceIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        S s = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s);
        int length = tArr.length;
        for (int i = 1; i < length; i++) {
            s = operation.invoke(Integer.valueOf(i), s, (Object) tArr[i]);
            arrayList.add(s);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, R> List<R> scan(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        for (AbstractC0002a1 abstractC0002a1 : tArr) {
            r = operation.invoke(r, abstractC0002a1);
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, R> List<R> scanIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return AbstractC1167eq.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, tArr[i]);
            arrayList.add(r);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> void shuffle(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        shuffle(tArr, Random.INSTANCE);
    }

    public static final <T> T single(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static <T> T singleOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull T[] tArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T> T[] sliceArray(@NotNull T[] tArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        T[] tArr2 = (T[]) AbstractC1755rb.arrayOfNulls(tArr, indices.size());
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            tArr2[i] = tArr[it.next().intValue()];
            i++;
        }
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt___ArraysJvmKt.sortWith(tArr, AbstractC1919vr.reverseOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt___ArraysJvmKt.asList(sortedArray(tArr));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] sortedArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        ArraysKt___ArraysJvmKt.sort(tArr2);
        return tArr2;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        ArraysKt___ArraysJvmKt.sortWith(tArr2, AbstractC1919vr.reverseOrder());
        return tArr2;
    }

    @NotNull
    public static final <T> T[] sortedArrayWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return sortedWith(tArr, AbstractC1919vr.reverseOrder());
    }

    @NotNull
    public static final <T> List<T> sortedWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysJvmKt.asList(sortedArrayWith(tArr, comparator));
    }

    @NotNull
    public static final <T> Set<T> subtract(@NotNull T[] tArr, @NotNull Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sum(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i = 0;
        for (byte b : bArr) {
            i += b;
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(@NotNull T[] tArr, @NotNull Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (T t : tArr) {
            i += selector.invoke(t).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(@NotNull T[] tArr, @NotNull Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (T t : tArr) {
            d += selector.invoke(t).doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(@NotNull Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i = 0;
        for (Byte b : bArr) {
            i += b.byteValue();
        }
        return i;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d = 0.0d;
        for (Double d2 : dArr) {
            d += d2.doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float f = RecyclerView.f7068F0;
        for (Float f2 : fArr) {
            f += f2.floatValue();
        }
        return f;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        int i = 0;
        for (Integer num : numArr) {
            i += num.intValue();
        }
        return i;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(@NotNull Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        long j = 0;
        for (Long l : lArr) {
            j += l.longValue();
        }
        return j;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(@NotNull Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        int i = 0;
        for (Short sh : shArr) {
            i += sh.shortValue();
        }
        return i;
    }

    @NotNull
    public static final <T> List<T> take(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= tArr.length) {
            return toList(tArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (T t : tArr) {
            arrayList.add(t);
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> takeLast(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = tArr.length;
        if (i >= length) {
            return toList(tArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(tArr[i2]);
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> takeLastWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(tArr[lastIndex]).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    @NotNull
    public static final <T> List<T> takeWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @NotNull
    public static final boolean[] toBooleanArray(@NotNull Boolean[] boolArr) {
        Intrinsics.checkNotNullParameter(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    @NotNull
    public static final char[] toCharArray(@NotNull Character[] chArr) {
        Intrinsics.checkNotNullParameter(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull T[] tArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : tArr) {
            destination.add(t);
        }
        return destination;
    }

    @NotNull
    public static final double[] toDoubleArray(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i = 0; i < length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    @NotNull
    public static final float[] toFloatArray(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (HashSet) toCollection(tArr, new HashSet(kh1.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final int[] toIntArray(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    @NotNull
    public static <T> List<T> toList(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(tArr);
        }
        return AbstractC1167eq.listOf(tArr[0]);
    }

    @NotNull
    public static final long[] toLongArray(@NotNull Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    @NotNull
    public static <T> List<T> toMutableList(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (Set) toCollection(tArr, new LinkedHashSet(kh1.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(tArr, new LinkedHashSet(kh1.mapCapacity(tArr.length)));
        }
        return rh2.setOf(tArr[0]);
    }

    @NotNull
    public static final short[] toShortArray(@NotNull Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    @NotNull
    public static final <T> Set<T> union(@NotNull T[] tArr, @NotNull Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IndexingIterable(new C1829tb(0, tArr));
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull T[] tArr, @NotNull R[] other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(tArr[i], other[i]));
        }
        return arrayList;
    }

    public static final boolean all(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final double average(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (short s : sArr) {
            d += s;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static boolean contains(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return indexOf(bArr, b) >= 0;
    }

    public static final int count(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Byte> distinct(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(bArr));
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterNotTo(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterTo(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
        }
        return destination;
    }

    @Nullable
    public static final Byte firstOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    public static final <R> R fold(@NotNull byte[] bArr, R r, @NotNull Function2<? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (byte b : bArr) {
            r = operation.invoke(r, Byte.valueOf(b));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull byte[] bArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Byte.valueOf(bArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final void forEach(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (byte b : bArr) {
            action.invoke(Byte.valueOf(b));
        }
    }

    public static final void forEachIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static IntRange getIndices(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new IntRange(0, getLastIndex(bArr));
    }

    public static int getLastIndex(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length - 1;
    }

    @Nullable
    public static final Byte getOrNull(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i < 0 || i > getLastIndex(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i]);
    }

    @NotNull
    public static final String joinToString(@NotNull byte[] bArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Byte, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Byte lastOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    public static final boolean none(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        shuffle(bArr, (Random) Random.INSTANCE);
    }

    @Nullable
    public static final Byte singleOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final void sortDescending(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(bArr);
            reverse(bArr);
        }
    }

    @NotNull
    public static final List<Byte> sorted(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Byte> sortedDescending(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Byte> sortedWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final int sum(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i = 0;
        for (short s : sArr) {
            i += s;
        }
        return i;
    }

    @NotNull
    public static final HashSet<Byte> toHashSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (HashSet) toCollection(bArr, new HashSet(kh1.mapCapacity(bArr.length)));
    }

    @NotNull
    public static final List<Byte> toMutableList(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Byte> toMutableSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (Set) toCollection(bArr, new LinkedHashSet(kh1.mapCapacity(bArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Byte>> withIndex(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new IndexingIterable(new C1866ub(bArr, 0));
    }

    public static final boolean all(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return !(sArr.length == 0);
    }

    @NotNull
    public static final Iterable<Byte> asIterable(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2(bArr);
    }

    @NotNull
    public static final Sequence<Byte> asSequence(@NotNull final byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Byte>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Byte> iterator() {
                return ArrayIteratorsKt.iterator(bArr);
            }
        };
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (byte b : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final double average(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (int i2 : iArr) {
            d += i2;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static boolean contains(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return indexOf(sArr, s) >= 0;
    }

    public static final int count(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Short> distinct(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(sArr));
    }

    @NotNull
    public static final List<Byte> filter(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterIndexedTo(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Byte.valueOf(b)).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Byte> filterNot(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterNotTo(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                destination.add(Short.valueOf(s));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterTo(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                destination.add(Short.valueOf(s));
            }
        }
        return destination;
    }

    @Nullable
    public static final Short firstOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R fold(@NotNull short[] sArr, R r, @NotNull Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (short s : sArr) {
            r = operation.invoke(r, Short.valueOf(s));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull short[] sArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Short.valueOf(sArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull byte[] bArr, R r, @NotNull Function2<? super Byte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Byte.valueOf(bArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull byte[] bArr, R r, @NotNull Function3<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull short[] sArr, @NotNull Function1<? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (short s : sArr) {
            action.invoke(Short.valueOf(s));
        }
    }

    public static final void forEachIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static IntRange getIndices(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new IntRange(0, getLastIndex(sArr));
    }

    public static int getLastIndex(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length - 1;
    }

    @Nullable
    public static final Short getOrNull(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i < 0 || i > getLastIndex(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i]);
    }

    public static final int indexOfFirst(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Byte.valueOf(bArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Byte> intersect(@NotNull byte[] bArr, @NotNull Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final String joinToString(@NotNull short[] sArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(sArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(sArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Short, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Short lastOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b : bArr) {
            destination.add(transform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    public static final boolean none(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Byte randomOrNull(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.nextInt(bArr.length)]);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        shuffle(sArr, (Random) Random.INSTANCE);
    }

    @Nullable
    public static final Short singleOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Byte> slice(@NotNull byte[] bArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Short> sorted(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final byte[] sortedArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final byte[] sortedArrayDescending(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> sortedBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Short> sortedDescending(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Short> sortedWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Byte> subtract(@NotNull byte[] bArr, @NotNull Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sum(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Integer> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (byte b : bArr) {
            i += selector.invoke(Byte.valueOf(b)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (byte b : bArr) {
            d += selector.invoke(Byte.valueOf(b)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C toCollection(@NotNull byte[] bArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (byte b : bArr) {
            destination.add(Byte.valueOf(b));
        }
        return destination;
    }

    @NotNull
    public static final HashSet<Short> toHashSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (HashSet) toCollection(sArr, new HashSet(kh1.mapCapacity(sArr.length)));
    }

    @NotNull
    public static final Set<Short> toMutableSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (Set) toCollection(sArr, new LinkedHashSet(kh1.mapCapacity(sArr.length)));
    }

    @NotNull
    public static final Set<Byte> union(@NotNull byte[] bArr, @NotNull Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Short>> withIndex(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new IndexingIterable(new C1903vb(sArr, 0));
    }

    public static final boolean all(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final double average(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (long j : jArr) {
            d += j;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static boolean contains(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return indexOf(iArr, i) >= 0;
    }

    public static final int count(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Integer> distinct(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(iArr));
    }

    @NotNull
    public static final List<Byte> filterIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterNotTo(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                destination.add(Integer.valueOf(i));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterTo(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                destination.add(Integer.valueOf(i));
            }
        }
        return destination;
    }

    public static final byte first(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Integer firstOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b : bArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    public static final <R> R fold(@NotNull int[] iArr, R r, @NotNull Function2<? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int i : iArr) {
            r = operation.invoke(r, Integer.valueOf(i));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull int[] iArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Integer.valueOf(iArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final void forEach(@NotNull int[] iArr, @NotNull Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (int i : iArr) {
            action.invoke(Integer.valueOf(i));
        }
    }

    public static final void forEachIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static IntRange getIndices(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IntRange(0, getLastIndex(iArr));
    }

    public static int getLastIndex(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length - 1;
    }

    @Nullable
    public static final Integer getOrNull(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i < 0 || i > getLastIndex(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    @NotNull
    public static final String joinToString(@NotNull int[] iArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(iArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(iArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Integer, ? extends CharSequence>) function1);
    }

    public static final byte last(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Integer lastOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(transform.invoke(Byte.valueOf(b)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    public static final boolean none(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final byte random(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length != 0) {
            return bArr[random.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte reduceRightIndexedOrNull(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte b = bArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            b = operation.invoke(Integer.valueOf(i), Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
        }
        return Byte.valueOf(b);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Byte reduceRightOrNull(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte b = bArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            b = operation.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
        }
        return Byte.valueOf(b);
    }

    @NotNull
    public static final List<Byte> reversed(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        shuffle(iArr, (Random) Random.INSTANCE);
    }

    @Nullable
    public static final Integer singleOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    @NotNull
    public static byte[] sliceArray(@NotNull byte[] bArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr2[i] = bArr[it.next().intValue()];
            i++;
        }
        return bArr2;
    }

    @NotNull
    public static final List<Integer> sorted(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Integer> sortedDescending(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Integer> sortedWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final long sum(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    @NotNull
    public static final HashSet<Integer> toHashSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (HashSet) toCollection(iArr, new HashSet(kh1.mapCapacity(iArr.length)));
    }

    @NotNull
    public static final List<Short> toMutableList(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Integer> toMutableSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (Set) toCollection(iArr, new LinkedHashSet(kh1.mapCapacity(iArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Integer>> withIndex(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IndexingIterable(new C1940wb(iArr, 0));
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull byte[] bArr, @NotNull R[] other, @NotNull Function2<? super Byte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i]), other[i]));
        }
        return arrayList;
    }

    public static final boolean all(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return !(jArr.length == 0);
    }

    @NotNull
    public static final Iterable<Short> asIterable(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3(sArr);
    }

    @NotNull
    public static final Sequence<Short> asSequence(@NotNull final short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Short>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Short> iterator() {
                return ArrayIteratorsKt.iterator(sArr);
            }
        };
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(bArr.length), 16));
        for (byte b : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Byte> associateBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (short s : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final double average(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (float f : fArr) {
            d += f;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static boolean contains(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return indexOf(jArr, j) >= 0;
    }

    public static final int count(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Long> distinct(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(jArr));
    }

    @NotNull
    public static final List<Byte> dropLastWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Short> filter(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterIndexedTo(@NotNull short[] sArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            short s = sArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Short.valueOf(s)).booleanValue()) {
                destination.add(Short.valueOf(s));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Short> filterNot(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterNotTo(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                destination.add(Long.valueOf(j));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterTo(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                destination.add(Long.valueOf(j));
            }
        }
        return destination;
    }

    @Nullable
    public static final Long firstOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Byte.valueOf(b)));
        }
        return arrayList;
    }

    public static final <R> R fold(@NotNull long[] jArr, R r, @NotNull Function2<? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (long j : jArr) {
            r = operation.invoke(r, Long.valueOf(j));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull long[] jArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Long.valueOf(jArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull short[] sArr, R r, @NotNull Function2<? super Short, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Short.valueOf(sArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull short[] sArr, R r, @NotNull Function3<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull long[] jArr, @NotNull Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (long j : jArr) {
            action.invoke(Long.valueOf(j));
        }
    }

    public static final void forEachIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static IntRange getIndices(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new IntRange(0, getLastIndex(jArr));
    }

    public static int getLastIndex(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length - 1;
    }

    @Nullable
    public static final Long getOrNull(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i < 0 || i > getLastIndex(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i]);
    }

    public static int indexOf(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Short.valueOf(sArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Short> intersect(@NotNull short[] sArr, @NotNull Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final String joinToString(@NotNull long[] jArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(jArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(jArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Long, ? extends CharSequence>) function1);
    }

    public static int lastIndexOf(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @Nullable
    public static final Long lastOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull short[] sArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s : sArr) {
            destination.add(transform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    public static final boolean none(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Short randomOrNull(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.nextInt(sArr.length)]);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte reduceIndexedOrNull(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            b = operation.invoke(Integer.valueOf(nextInt), Byte.valueOf(b), Byte.valueOf(bArr[nextInt])).byteValue();
        }
        return Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Byte reduceOrNull(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
        while (it.hasNext()) {
            b = operation.invoke(Byte.valueOf(b), Byte.valueOf(bArr[it.nextInt()])).byteValue();
        }
        return Byte.valueOf(b);
    }

    public static final byte reduceRight(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b = bArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                b = operation.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceRightIndexed(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b = bArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                b = operation.invoke(Integer.valueOf(i), Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        shuffle(jArr, (Random) Random.INSTANCE);
    }

    public static final byte single(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static final Long singleOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Short> slice(@NotNull short[] sArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(sArr);
            reverse(sArr);
        }
    }

    @NotNull
    public static final List<Long> sorted(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final short[] sortedArray(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final short[] sortedArrayDescending(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> sortedBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Long> sortedDescending(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Long> sortedWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Short> subtract(@NotNull short[] sArr, @NotNull Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final float sum(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float f = RecyclerView.f7068F0;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull short[] sArr, @NotNull Function1<? super Short, Integer> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (short s : sArr) {
            i += selector.invoke(Short.valueOf(s)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull short[] sArr, @NotNull Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (short s : sArr) {
            d += selector.invoke(Short.valueOf(s)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final List<Byte> takeLastWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    @NotNull
    public static final List<Byte> takeWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C toCollection(@NotNull short[] sArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (short s : sArr) {
            destination.add(Short.valueOf(s));
        }
        return destination;
    }

    @NotNull
    public static final HashSet<Long> toHashSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (HashSet) toCollection(jArr, new HashSet(kh1.mapCapacity(jArr.length)));
    }

    @NotNull
    public static final List<Byte> toList(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return AbstractC1167eq.listOf(Byte.valueOf(bArr[0]));
    }

    @NotNull
    public static final Set<Long> toMutableSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (Set) toCollection(jArr, new LinkedHashSet(kh1.mapCapacity(jArr.length)));
    }

    @NotNull
    public static final Set<Byte> toSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(bArr, new LinkedHashSet(kh1.mapCapacity(bArr.length)));
        }
        return rh2.setOf(Byte.valueOf(bArr[0]));
    }

    @NotNull
    public static final Set<Short> union(@NotNull short[] sArr, @NotNull Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Long>> withIndex(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new IndexingIterable(new C1977xb(jArr, 0));
    }

    public static final boolean all(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static final double average(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d = 0.0d;
        int i = 0;
        for (double d2 : dArr) {
            d += d2;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static final boolean contains(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return indexOf(zArr, z) >= 0;
    }

    public static final int count(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Float> distinct(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(fArr));
    }

    @NotNull
    public static final List<Byte> dropWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (byte b : bArr) {
            if (z) {
                arrayList.add(Byte.valueOf(b));
            } else if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterNotTo(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                destination.add(Float.valueOf(f));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterTo(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                destination.add(Float.valueOf(f));
            }
        }
        return destination;
    }

    @Nullable
    public static final Float firstOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R fold(@NotNull float[] fArr, R r, @NotNull Function2<? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (float f : fArr) {
            r = operation.invoke(r, Float.valueOf(f));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull float[] fArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Float.valueOf(fArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final void forEach(@NotNull float[] fArr, @NotNull Function1<? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (float f : fArr) {
            action.invoke(Float.valueOf(f));
        }
    }

    public static final void forEachIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new IntRange(0, getLastIndex(fArr));
    }

    public static final int getLastIndex(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length - 1;
    }

    @Nullable
    public static final Float getOrNull(@NotNull float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i < 0 || i > getLastIndex(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i]);
    }

    @NotNull
    public static final String joinToString(@NotNull float[] fArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(fArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(fArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Float, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Float lastOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte maxWithOrNull(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) < 0) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte minWithOrNull(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) > 0) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    public static final boolean none(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final byte reduce(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length != 0) {
            byte b = bArr[0];
            ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
            while (it.hasNext()) {
                b = operation.invoke(Byte.valueOf(b), Byte.valueOf(bArr[it.nextInt()])).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final byte reduceIndexed(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length != 0) {
            byte b = bArr[0];
            ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                b = operation.invoke(Integer.valueOf(nextInt), Byte.valueOf(b), Byte.valueOf(bArr[nextInt])).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        shuffle(fArr, (Random) Random.INSTANCE);
    }

    @Nullable
    public static final Float singleOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Float> sorted(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> sortedBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Float> sortedDescending(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Float> sortedWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final double sum(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        return d;
    }

    @NotNull
    public static final HashSet<Float> toHashSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (HashSet) toCollection(fArr, new HashSet(kh1.mapCapacity(fArr.length)));
    }

    @NotNull
    public static final List<Integer> toMutableList(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Float> toMutableSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (Set) toCollection(fArr, new LinkedHashSet(kh1.mapCapacity(fArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Float>> withIndex(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new IndexingIterable(new C1829tb(1, fArr));
    }

    public static final boolean all(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return !(dArr.length == 0);
    }

    @NotNull
    public static final Iterable<Integer> asIterable(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$4(iArr);
    }

    @NotNull
    public static final Sequence<Integer> asSequence(@NotNull final int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Integer>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Integer> iterator() {
                return ArrayIteratorsKt.iterator(iArr);
            }
        };
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i)), Integer.valueOf(i));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static boolean contains(@NotNull char[] cArr, char c) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return indexOf(cArr, c) >= 0;
    }

    public static final int count(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Double> distinct(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(dArr));
    }

    @NotNull
    public static final <K> List<Byte> distinctBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (hashSet.add(selector.invoke(Byte.valueOf(b)))) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> filter(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> filterIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            short s = sArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterIndexedTo(@NotNull int[] iArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Integer.valueOf(i3)).booleanValue()) {
                destination.add(Integer.valueOf(i3));
            }
            i++;
            i2 = i4;
        }
        return destination;
    }

    @NotNull
    public static final List<Integer> filterNot(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterNotTo(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterTo(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
        }
        return destination;
    }

    public static final short first(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Double firstOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s : sArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    public static final <R> R fold(@NotNull double[] dArr, R r, @NotNull Function2<? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (double d : dArr) {
            r = operation.invoke(r, Double.valueOf(d));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull double[] dArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Double.valueOf(dArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull int[] iArr, R r, @NotNull Function2<? super Integer, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(iArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull int[] iArr, R r, @NotNull Function3<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull double[] dArr, @NotNull Function1<? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (double d : dArr) {
            action.invoke(Double.valueOf(d));
        }
    }

    public static final void forEachIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new IntRange(0, getLastIndex(dArr));
    }

    public static final int getLastIndex(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length - 1;
    }

    @Nullable
    public static final Double getOrNull(@NotNull double[] dArr, int i) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i < 0 || i > getLastIndex(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i]);
    }

    public static int indexOf(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Integer.valueOf(iArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Integer> intersect(@NotNull int[] iArr, @NotNull Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull byte[] bArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b)));
            } else {
                buffer.append(String.valueOf((int) b));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @NotNull
    public static final String joinToString(@NotNull double[] dArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(dArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(dArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Double, ? extends CharSequence>) function1);
    }

    public static final short last(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[getLastIndex(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int lastIndexOf(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (s == sArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @Nullable
    public static final Double lastOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(transform.invoke(Short.valueOf(s)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull int[] iArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i : iArr) {
            destination.add(transform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float maxOrNull(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, fArr[it.nextInt()].floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final float maxOrThrow(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float floatValue = fArr[0].floatValue();
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, fArr[it.nextInt()].floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final byte maxWithOrThrow(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length != 0) {
            byte b = bArr[0];
            ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) < 0) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float minOrNull(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, fArr[it.nextInt()].floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final float minOrThrow(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float floatValue = fArr[0].floatValue();
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, fArr[it.nextInt()].floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final byte minWithOrThrow(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length != 0) {
            byte b = bArr[0];
            ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) > 0) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final short random(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length != 0) {
            return sArr[random.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer randomOrNull(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.nextInt(iArr.length)]);
    }

    @NotNull
    public static final List<Short> reversed(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        shuffle(dArr, Random.INSTANCE);
    }

    @Nullable
    public static final Double singleOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Integer> slice(@NotNull int[] iArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static short[] sliceArray(@NotNull short[] sArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            sArr2[i] = sArr[it.next().intValue()];
            i++;
        }
        return sArr2;
    }

    @NotNull
    public static final List<Double> sorted(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final int[] sortedArray(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final int[] sortedArrayDescending(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> sortedBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Double> sortedDescending(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Double> sortedWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Integer> subtract(@NotNull int[] iArr, @NotNull Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, Integer> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (int i2 : iArr) {
            i += selector.invoke(Integer.valueOf(i2)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull int[] iArr, @NotNull Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (int i : iArr) {
            d += selector.invoke(Integer.valueOf(i)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C toCollection(@NotNull int[] iArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (int i : iArr) {
            destination.add(Integer.valueOf(i));
        }
        return destination;
    }

    @NotNull
    public static final HashSet<Double> toHashSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (HashSet) toCollection(dArr, new HashSet(kh1.mapCapacity(dArr.length)));
    }

    @NotNull
    public static final Set<Double> toMutableSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (Set) toCollection(dArr, new LinkedHashSet(kh1.mapCapacity(dArr.length)));
    }

    @NotNull
    public static final Set<Integer> union(@NotNull int[] iArr, @NotNull Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Double>> withIndex(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new IndexingIterable(new C1829tb(2, dArr));
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull short[] sArr, @NotNull R[] other, @NotNull Function2<? super Short, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i]), other[i]));
        }
        return arrayList;
    }

    public static final boolean all(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return !(zArr.length == 0);
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "any { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean contains(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        for (float f2 : fArr) {
            if (f2 == f) {
                return true;
            }
        }
        return false;
    }

    public static final int count(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Boolean> distinct(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(zArr));
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterNotTo(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterTo(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
        }
        return destination;
    }

    @Nullable
    public static final Boolean firstOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    public static final <R> R fold(@NotNull boolean[] zArr, R r, @NotNull Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (boolean z : zArr) {
            r = operation.invoke(r, Boolean.valueOf(z));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull boolean[] zArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Boolean.valueOf(zArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final void forEach(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (boolean z : zArr) {
            action.invoke(Boolean.valueOf(z));
        }
    }

    public static final void forEachIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new IntRange(0, getLastIndex(zArr));
    }

    public static final int getLastIndex(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length - 1;
    }

    @Nullable
    public static final Boolean getOrNull(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i < 0 || i > getLastIndex(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i]);
    }

    @NotNull
    public static final String joinToString(@NotNull boolean[] zArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(zArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(zArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Boolean, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Boolean lastOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    public static final boolean none(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0;
    }

    @NotNull
    public static final Pair<List<Byte>, List<Byte>> partition(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            } else {
                arrayList2.add(Byte.valueOf(b));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short reduceRightIndexedOrNull(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short s = sArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            s = operation.invoke(Integer.valueOf(i), Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Short reduceRightOrNull(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short s = sArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            s = operation.invoke(Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        shuffle(zArr, Random.INSTANCE);
    }

    @Nullable
    public static final Boolean singleOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    public static final void sortDescending(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(iArr);
            reverse(iArr);
        }
    }

    @NotNull
    public static final List<Character> sorted(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Character> sortedDescending(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Boolean> sortedWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Boolean[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(zArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final HashSet<Boolean> toHashSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (HashSet) toCollection(zArr, new HashSet(kh1.mapCapacity(zArr.length)));
    }

    @NotNull
    public static final List<Long> toMutableList(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Boolean> toMutableSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (Set) toCollection(zArr, new LinkedHashSet(kh1.mapCapacity(zArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Boolean>> withIndex(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new IndexingIterable(new C1829tb(3, zArr));
    }

    public static final boolean all(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return !(cArr.length == 0);
    }

    @NotNull
    public static final Iterable<Long> asIterable(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$5(jArr);
    }

    @NotNull
    public static final Sequence<Long> asSequence(@NotNull final long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Long>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Long> iterator() {
                return ArrayIteratorsKt.iterator(jArr);
            }
        };
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Short> associateBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (long j : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "any { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean contains(double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static final int count(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<Character> distinct(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(cArr));
    }

    @NotNull
    public static final List<Short> dropLastWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Long> filter(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterIndexedTo(@NotNull long[] jArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            long j = jArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Long.valueOf(j)).booleanValue()) {
                destination.add(Long.valueOf(j));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Long> filterNot(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterNotTo(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterTo(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
        }
        return destination;
    }

    @Nullable
    public static final Character firstOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Short.valueOf(s)));
        }
        return arrayList;
    }

    public static final <R> R fold(@NotNull char[] cArr, R r, @NotNull Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (char c : cArr) {
            r = operation.invoke(r, Character.valueOf(c));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull char[] cArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, Character.valueOf(cArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull long[] jArr, R r, @NotNull Function2<? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Long.valueOf(jArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull long[] jArr, R r, @NotNull Function3<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull char[] cArr, @NotNull Function1<? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (char c : cArr) {
            action.invoke(Character.valueOf(c));
        }
    }

    public static final void forEachIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i]));
            i++;
            i2++;
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new IntRange(0, getLastIndex(cArr));
    }

    public static final int getLastIndex(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length - 1;
    }

    @Nullable
    public static final Character getOrNull(@NotNull char[] cArr, int i) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i < 0 || i > getLastIndex(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i]);
    }

    public static int indexOf(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Long.valueOf(jArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Long> intersect(@NotNull long[] jArr, @NotNull Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final String joinToString(@NotNull char[] cArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(cArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
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
        return joinToString(cArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Character, ? extends CharSequence>) function1);
    }

    public static int lastIndexOf(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    @Nullable
    public static final Character lastOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull long[] jArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j : jArr) {
            destination.add(transform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    public static final boolean none(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long randomOrNull(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.nextInt(jArr.length)]);
    }

    public static final short reduceRight(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short s = sArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                s = operation.invoke(Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRightIndexed(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short s = sArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                s = operation.invoke(Integer.valueOf(i), Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        shuffle(cArr, (Random) Random.INSTANCE);
    }

    public static final short single(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static final Character singleOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Long> slice(@NotNull long[] jArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final long[] sortedArray(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final long[] sortedArrayDescending(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> sortedBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final List<Character> sortedWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Long> subtract(@NotNull long[] jArr, @NotNull Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull long[] jArr, @NotNull Function1<? super Long, Integer> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (long j : jArr) {
            i += selector.invoke(Long.valueOf(j)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull long[] jArr, @NotNull Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (long j : jArr) {
            d += selector.invoke(Long.valueOf(j)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final List<Short> takeLastWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    @NotNull
    public static final List<Short> takeWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C toCollection(@NotNull long[] jArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (long j : jArr) {
            destination.add(Long.valueOf(j));
        }
        return destination;
    }

    @NotNull
    public static final HashSet<Character> toHashSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (HashSet) toCollection(cArr, new HashSet(kh1.mapCapacity(r82.coerceAtMost(cArr.length, 128))));
    }

    @NotNull
    public static final List<Short> toList(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return AbstractC1167eq.listOf(Short.valueOf(sArr[0]));
    }

    @NotNull
    public static final Set<Character> toMutableSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (Set) toCollection(cArr, new LinkedHashSet(kh1.mapCapacity(r82.coerceAtMost(cArr.length, 128))));
    }

    @NotNull
    public static final Set<Short> toSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(sArr, new LinkedHashSet(kh1.mapCapacity(sArr.length)));
        }
        return rh2.setOf(Short.valueOf(sArr[0]));
    }

    @NotNull
    public static final Set<Long> union(@NotNull long[] jArr, @NotNull Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Character>> withIndex(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new IndexingIterable(new C1829tb(4, cArr));
    }

    public static final <T> boolean any(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<Byte> drop(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i >= 0) {
            return takeLast(bArr, r82.coerceAtLeast(bArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Byte> dropLast(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i >= 0) {
            return take(bArr, r82.coerceAtLeast(bArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Integer> filterIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Integer.valueOf(i3)).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
            }
            i++;
            i2 = i4;
        }
        return arrayList;
    }

    public static final int first(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i : iArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Byte.valueOf(b));
        }
        return destination;
    }

    public static final int last(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[getLastIndex(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            T t = tArr[length];
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @NotNull
    public static final <R> List<R> map(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(transform.invoke(Integer.valueOf(i)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    public static final <T> boolean none(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final int random(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length != 0) {
            return iArr[random.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short reduceIndexedOrNull(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            s = operation.invoke(Integer.valueOf(nextInt), Short.valueOf(s), Short.valueOf(sArr[nextInt])).shortValue();
        }
        return Short.valueOf(s);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Short reduceOrNull(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
        while (it.hasNext()) {
            s = operation.invoke(Short.valueOf(s), Short.valueOf(sArr[it.nextInt()])).shortValue();
        }
        return Short.valueOf(s);
    }

    @NotNull
    public static final List<Integer> reversed(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final byte[] reversedArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            bArr2[lastIndex - nextInt] = bArr[nextInt];
        }
        return bArr2;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> void shuffle(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(tArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            T t = tArr[lastIndex];
            tArr[lastIndex] = tArr[nextInt];
            tArr[nextInt] = t;
        }
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
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

    @NotNull
    public static int[] sliceArray(@NotNull int[] iArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr2[i] = iArr[it.next().intValue()];
            i++;
        }
        return iArr2;
    }

    @NotNull
    public static final List<Float> toMutableList(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull int[] iArr, @NotNull R[] other, @NotNull Function2<? super Integer, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i]), other[i]));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Float> asIterable(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$6(fArr);
    }

    @NotNull
    public static final Sequence<Float> asSequence(@NotNull final float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Float>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$6
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Float> iterator() {
                return ArrayIteratorsKt.iterator(fArr);
            }
        };
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (float f : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f)), Float.valueOf(f));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @NotNull
    public static final List<Short> dropWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (short s : sArr) {
            if (z) {
                arrayList.add(Short.valueOf(s));
            } else if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filter(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterIndexedTo(@NotNull float[] fArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Float.valueOf(f)).booleanValue()) {
                destination.add(Float.valueOf(f));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Float> filterNot(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Byte firstOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    public static final <R> R foldRight(@NotNull float[] fArr, R r, @NotNull Function2<? super Float, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Float.valueOf(fArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull float[] fArr, R r, @NotNull Function3<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r);
        }
        return r;
    }

    @NotNull
    public static final <K> Map<K, List<Byte>> groupBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    public static int indexOf(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Float.valueOf(fArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Float> intersect(@NotNull float[] fArr, @NotNull Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static int lastIndexOf(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (j == jArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull float[] fArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f : fArr) {
            destination.add(transform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    public static final boolean none(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Float randomOrNull(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.nextInt(fArr.length)]);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final short reduce(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length != 0) {
            short s = sArr[0];
            ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
            while (it.hasNext()) {
                s = operation.invoke(Short.valueOf(s), Short.valueOf(sArr[it.nextInt()])).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final short reduceIndexed(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length != 0) {
            short s = sArr[0];
            ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                s = operation.invoke(Integer.valueOf(nextInt), Short.valueOf(s), Short.valueOf(sArr[nextInt])).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(bArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            byte b = bArr[nextInt];
            bArr[nextInt] = bArr[lastIndex];
            bArr[lastIndex] = b;
            lastIndex--;
        }
    }

    @NotNull
    public static final List<Float> slice(@NotNull float[] fArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(jArr);
            reverse(jArr);
        }
    }

    @NotNull
    public static final float[] sortedArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final float[] sortedArrayDescending(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Float> subtract(@NotNull float[] fArr, @NotNull Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull float[] fArr, @NotNull Function1<? super Float, Integer> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (float f : fArr) {
            i += selector.invoke(Float.valueOf(f)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull float[] fArr, @NotNull Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (float f : fArr) {
            d += selector.invoke(Float.valueOf(f)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C toCollection(@NotNull float[] fArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (float f : fArr) {
            destination.add(Float.valueOf(f));
        }
        return destination;
    }

    @NotNull
    public static final Set<Float> union(@NotNull float[] fArr, @NotNull Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final Short firstOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return Short.valueOf(s);
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short maxWithOrNull(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) < 0) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short minWithOrNull(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) > 0) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    public static final boolean none(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer reduceRightIndexedOrNull(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int i = iArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            i = operation.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
        }
        return Integer.valueOf(i);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer reduceRightOrNull(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int i = iArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            i = operation.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
        }
        return Integer.valueOf(i);
    }

    @Nullable
    public static final Byte singleOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Byte b = null;
        boolean z = false;
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                if (z) {
                    return null;
                }
                b = Byte.valueOf(b2);
                z = true;
            }
        }
        if (z) {
            return b;
        }
        return null;
    }

    @NotNull
    public static final List<Double> toMutableList(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Double> asIterable(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$7(dArr);
    }

    @NotNull
    public static final Sequence<Double> asSequence(@NotNull final double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Double>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Double> iterator() {
                return ArrayIteratorsKt.iterator(dArr);
            }
        };
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(iArr.length), 16));
        for (int i : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Integer> associateBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i)), Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (double d : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @NotNull
    public static final <K> List<Short> distinctBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (hashSet.add(selector.invoke(Short.valueOf(s)))) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> dropLastWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Double> filter(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> filterIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            long j = jArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterIndexedTo(@NotNull double[] dArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            double d = dArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Double.valueOf(d)).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Double> filterNot(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    public static final long first(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Integer firstOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Integer.valueOf(i)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j : jArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    public static final <R> R foldRight(@NotNull double[] dArr, R r, @NotNull Function2<? super Double, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Double.valueOf(dArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull double[] dArr, R r, @NotNull Function3<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r);
        }
        return r;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfFirst { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int indexOf(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (f == fArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Double.valueOf(dArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Double> intersect(@NotNull double[] dArr, @NotNull Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final long last(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[getLastIndex(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfLast { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int lastIndexOf(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (f == fArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @Nullable
    public static final Byte lastOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            byte b = bArr[length];
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return Byte.valueOf(b);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @NotNull
    public static final <R> List<R> map(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(transform.invoke(Long.valueOf(j)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull double[] dArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d : dArr) {
            destination.add(transform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Byte maxByOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b);
        }
        R invoke = selector.invoke(Byte.valueOf(b));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            byte b2 = bArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) < 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T extends Comparable<? super T>> T maxOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (t.compareTo(t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOrThrow(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            T t = tArr[0];
            ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (t.compareTo(t2) < 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final short maxWithOrThrow(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length != 0) {
            short s = sArr[0];
            ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) < 0) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Byte minByOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b);
        }
        R invoke = selector.invoke(Byte.valueOf(b));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            byte b2 = bArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) > 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T extends Comparable<? super T>> T minOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (t.compareTo(t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOrThrow(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            T t = tArr[0];
            ?? it = new IntRange(1, getLastIndex(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final short minWithOrThrow(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length != 0) {
            short s = sArr[0];
            ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) > 0) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final long random(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length != 0) {
            return jArr[random.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Double randomOrNull(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.nextInt(dArr.length)]);
    }

    public static final int reduceRight(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i = iArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                i = operation.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i = iArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                i = operation.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final List<Long> reversed(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    public static final int single(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final List<Double> slice(@NotNull double[] dArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static long[] sliceArray(@NotNull long[] jArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr2[i] = jArr[it.next().intValue()];
            i++;
        }
        return jArr2;
    }

    @NotNull
    public static final double[] sortedArray(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final double[] sortedArrayDescending(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Double> subtract(@NotNull double[] dArr, @NotNull Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull double[] dArr, @NotNull Function1<? super Double, Integer> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (double d : dArr) {
            i += selector.invoke(Double.valueOf(d)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull double[] dArr, @NotNull Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (double d2 : dArr) {
            d += selector.invoke(Double.valueOf(d2)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final List<Integer> takeLastWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    @NotNull
    public static final List<Integer> takeWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C toCollection(@NotNull double[] dArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (double d : dArr) {
            destination.add(Double.valueOf(d));
        }
        return destination;
    }

    @NotNull
    public static final List<Integer> toList(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return AbstractC1167eq.listOf(Integer.valueOf(iArr[0]));
    }

    @NotNull
    public static final Set<Integer> toSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(iArr, new LinkedHashSet(kh1.mapCapacity(iArr.length)));
        }
        return rh2.setOf(Integer.valueOf(iArr[0]));
    }

    @NotNull
    public static final Set<Double> union(@NotNull double[] dArr, @NotNull Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull long[] jArr, @NotNull R[] other, @NotNull Function2<? super Long, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i]), other[i]));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final Long firstOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return Long.valueOf(j);
            }
        }
        return null;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull short[] sArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (short s : sArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Short.valueOf(s)));
            } else {
                buffer.append(String.valueOf((int) s));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> byte maxByOrThrow(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex == 0) {
                return b;
            }
            R invoke = selector.invoke(Byte.valueOf(b));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                byte b2 = bArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Byte.valueOf(b2));
                if (invoke.compareTo(invoke2) < 0) {
                    b = b2;
                    invoke = invoke2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> byte minByOrThrow(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex == 0) {
                return b;
            }
            R invoke = selector.invoke(Byte.valueOf(b));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                byte b2 = bArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Byte.valueOf(b2));
                if (invoke.compareTo(invoke2) > 0) {
                    b = b2;
                    invoke = invoke2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final void sortDescending(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(fArr);
            reverse(fArr);
        }
    }

    @NotNull
    public static final List<Boolean> toMutableList(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Boolean> asIterable(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8(zArr);
    }

    @NotNull
    public static final Sequence<Boolean> asSequence(@NotNull final boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Boolean>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$8
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Boolean> iterator() {
                return ArrayIteratorsKt.iterator(zArr);
            }
        };
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (boolean z : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @NotNull
    public static final List<Boolean> filter(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            boolean z = zArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Boolean> filterNot(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Float firstOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return Float.valueOf(f);
            }
        }
        return null;
    }

    public static final <R> R foldRight(@NotNull boolean[] zArr, R r, @NotNull Function2<? super Boolean, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Boolean.valueOf(zArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull boolean[] zArr, R r, @NotNull Function3<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r);
        }
        return r;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfFirst { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int indexOf(double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (d == dArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Boolean.valueOf(zArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Boolean> intersect(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfLast { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int lastIndexOf(double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (d == dArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z : zArr) {
            destination.add(transform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final boolean none(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final Pair<List<Short>, List<Short>> partition(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            } else {
                arrayList2.add(Short.valueOf(s));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Boolean randomOrNull(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.nextInt(zArr.length)]);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer reduceIndexedOrNull(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            i = operation.invoke(Integer.valueOf(nextInt), Integer.valueOf(i), Integer.valueOf(iArr[nextInt])).intValue();
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer reduceOrNull(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            i = operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[it.nextInt()])).intValue();
        }
        return Integer.valueOf(i);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(bArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            byte b = bArr[lastIndex];
            bArr[lastIndex] = bArr[nextInt];
            bArr[nextInt] = b;
        }
    }

    @Nullable
    public static final Short singleOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                if (z) {
                    return null;
                }
                sh = Short.valueOf(s);
                z = true;
            }
        }
        if (z) {
            return sh;
        }
        return null;
    }

    @NotNull
    public static final List<Boolean> slice(@NotNull boolean[] zArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final char[] sortedArray(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final char[] sortedArrayDescending(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Boolean> subtract(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Integer> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (boolean z : zArr) {
            i += selector.invoke(Boolean.valueOf(z)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (boolean z : zArr) {
            d += selector.invoke(Boolean.valueOf(z)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final List<Byte> take(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= bArr.length) {
            return toList(bArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> takeLast(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = bArr.length;
        if (i >= length) {
            return toList(bArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Byte.valueOf(bArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C toCollection(@NotNull boolean[] zArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (boolean z : zArr) {
            destination.add(Boolean.valueOf(z));
        }
        return destination;
    }

    @NotNull
    public static final Set<Boolean> union(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<Integer> dropWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i : iArr) {
            if (z) {
                arrayList.add(Integer.valueOf(i));
            } else if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filterIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final float first(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Double firstOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f : fArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    public static final float last(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Short lastOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            short s = sArr[length];
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return Short.valueOf(s);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @NotNull
    public static final <R> List<R> map(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(transform.invoke(Float.valueOf(f)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    public static final boolean none(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final float random(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length != 0) {
            return fArr[random.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final int reduce(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length != 0) {
            int i = iArr[0];
            ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                i = operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[it.nextInt()])).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final int reduceIndexed(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length != 0) {
            int i = iArr[0];
            ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                i = operation.invoke(Integer.valueOf(nextInt), Integer.valueOf(i), Integer.valueOf(iArr[nextInt])).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long reduceRightIndexedOrNull(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long j = jArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            j = operation.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long reduceRightOrNull(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long j = jArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            j = operation.invoke(Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
        }
        return Long.valueOf(j);
    }

    @NotNull
    public static final List<Float> reversed(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final float[] sliceArray(@NotNull float[] fArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr2[i] = fArr[it.next().intValue()];
            i++;
        }
        return fArr2;
    }

    @NotNull
    public static final List<Character> toMutableList(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull float[] fArr, @NotNull R[] other, @NotNull Function2<? super Float, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i]), other[i]));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Character> asIterable(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$9(cArr);
    }

    @NotNull
    public static final Sequence<Character> asSequence(@NotNull final char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new Sequence<Character>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Character> iterator() {
                return ArrayIteratorsKt.iterator(cArr);
            }
        };
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Long> associateBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (char c : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @NotNull
    public static final List<Long> dropLastWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Character> filter(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterIndexedTo(@NotNull char[] cArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = cArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(c)).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @NotNull
    public static final List<Character> filterNot(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Boolean firstOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Long.valueOf(j)));
        }
        return arrayList;
    }

    public static final <R> R foldRight(@NotNull char[] cArr, R r, @NotNull Function2<? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Character.valueOf(cArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull char[] cArr, R r, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r);
        }
        return r;
    }

    public static final int indexOf(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Character.valueOf(cArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Character> intersect(@NotNull char[] cArr, @NotNull Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        AbstractC1327iq.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final int lastIndexOf(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (z == zArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull char[] cArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c : cArr) {
            destination.add(transform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    public static final boolean none(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character randomOrNull(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.nextInt(cArr.length)]);
    }

    public static final long reduceRight(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j = jArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                j = operation.invoke(Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j = jArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                j = operation.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long single(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final List<Character> slice(@NotNull char[] cArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(dArr);
            reverse(dArr);
        }
    }

    @NotNull
    public static final Set<Character> subtract(@NotNull char[] cArr, @NotNull Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        AbstractC1327iq.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(@NotNull char[] cArr, @NotNull Function1<? super Character, Integer> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (char c : cArr) {
            i += selector.invoke(Character.valueOf(c)).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(@NotNull char[] cArr, @NotNull Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (char c : cArr) {
            d += selector.invoke(Character.valueOf(c)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final List<Long> takeLastWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    @NotNull
    public static final List<Long> takeWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C toCollection(@NotNull char[] cArr, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (char c : cArr) {
            destination.add(Character.valueOf(c));
        }
        return destination;
    }

    @NotNull
    public static final List<Long> toList(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return AbstractC1167eq.listOf(Long.valueOf(jArr[0]));
    }

    @NotNull
    public static final Set<Long> toSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(jArr, new LinkedHashSet(kh1.mapCapacity(jArr.length)));
        }
        return rh2.setOf(Long.valueOf(jArr[0]));
    }

    @NotNull
    public static final Set<Character> union(@NotNull char[] cArr, @NotNull Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        AbstractC1327iq.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final Character firstOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte maxOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (b < b2) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer maxWithOrNull(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) < 0) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte minOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (b > b2) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer minWithOrNull(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) > 0) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    public static final boolean none(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static final Integer singleOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                if (z) {
                    return null;
                }
                num = Integer.valueOf(i);
                z = true;
            }
        }
        if (z) {
            return num;
        }
        return null;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : tArr) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    @NotNull
    public static final <K> List<Integer> distinctBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (hashSet.add(selector.invoke(Integer.valueOf(i)))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> drop(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i >= 0) {
            return takeLast(sArr, r82.coerceAtLeast(sArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Short> dropLast(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i >= 0) {
            return take(sArr, r82.coerceAtLeast(sArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Double> filterIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            double d = dArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final double first(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d : dArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return destination;
    }

    public static final int indexOf(@NotNull char[] cArr, char c) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final double last(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(@NotNull char[] cArr, char c) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (c == cArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @Nullable
    public static final Integer lastOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            int i2 = iArr[length];
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return Integer.valueOf(i2);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @NotNull
    public static final <R> List<R> map(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(transform.invoke(Double.valueOf(d)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final byte maxOrThrow(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            byte b = bArr[0];
            ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (b < b2) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final int maxWithOrThrow(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length != 0) {
            int i = iArr[0];
            ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) < 0) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final byte minOrThrow(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            byte b = bArr[0];
            ?? it = new IntRange(1, getLastIndex(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (b > b2) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final int minWithOrThrow(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length != 0) {
            int i = iArr[0];
            ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) > 0) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.3")
    public static final double random(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length != 0) {
            return dArr[random.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final List<Double> reversed(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final short[] reversedArray(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            sArr2[lastIndex - nextInt] = sArr[nextInt];
        }
        return sArr2;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull T[] tArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    @NotNull
    public static final double[] sliceArray(@NotNull double[] dArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            dArr2[i] = dArr[it.next().intValue()];
            i++;
        }
        return dArr2;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull double[] dArr, @NotNull R[] other, @NotNull Function2<? super Double, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i]), other[i]));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long reduceIndexedOrNull(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            j = operation.invoke(Integer.valueOf(nextInt), Long.valueOf(j), Long.valueOf(jArr[nextInt])).longValue();
        }
        return Long.valueOf(j);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long reduceOrNull(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
        while (it.hasNext()) {
            j = operation.invoke(Long.valueOf(j), Long.valueOf(jArr[it.nextInt()])).longValue();
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float reduceRightIndexedOrNull(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float f = fArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            f = operation.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
        }
        return Float.valueOf(f);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Float reduceRightOrNull(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float f = fArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            f = operation.invoke(Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
        }
        return Float.valueOf(f);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(sArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            short s = sArr[lastIndex];
            sArr[lastIndex] = sArr[nextInt];
            sArr[nextInt] = s;
        }
    }

    public static final void sortDescending(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(cArr);
            reverse(cArr);
        }
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(fArr.length), 16));
        for (float f : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Float> associateBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f)), Float.valueOf(f));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (byte b : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b)), valueTransform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @NotNull
    public static final List<Float> dropLastWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Long> dropWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (long j : jArr) {
            if (z) {
                arrayList.add(Long.valueOf(j));
            } else if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Float.valueOf(f)));
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Short>> groupBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull int[] iArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (int i3 : iArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Integer.valueOf(i3)));
            } else {
                buffer.append(String.valueOf(i3));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final long reduce(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length != 0) {
            long j = jArr[0];
            ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
            while (it.hasNext()) {
                j = operation.invoke(Long.valueOf(j), Long.valueOf(jArr[it.nextInt()])).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final long reduceIndexed(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length != 0) {
            long j = jArr[0];
            ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                j = operation.invoke(Integer.valueOf(nextInt), Long.valueOf(j), Long.valueOf(jArr[nextInt])).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRight(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f = fArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                f = operation.invoke(Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f = fArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                f = operation.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(sArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            short s = sArr[nextInt];
            sArr[nextInt] = sArr[lastIndex];
            sArr[lastIndex] = s;
            lastIndex--;
        }
    }

    public static final float single(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static final Long singleOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                if (z) {
                    return null;
                }
                l = Long.valueOf(j);
                z = true;
            }
        }
        if (z) {
            return l;
        }
        return null;
    }

    @NotNull
    public static final List<Float> takeLastWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    @NotNull
    public static final List<Float> takeWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> toList(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return AbstractC1167eq.listOf(Float.valueOf(fArr[0]));
    }

    @NotNull
    public static final Set<Float> toSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(fArr, new LinkedHashSet(kh1.mapCapacity(fArr.length)));
        }
        return rh2.setOf(Float.valueOf(fArr[0]));
    }

    @NotNull
    public static final List<Boolean> filterIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            boolean z = zArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final boolean first(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z : zArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final boolean last(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[getLastIndex(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Long lastOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            long j = jArr[length];
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return Long.valueOf(j);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @NotNull
    public static final <R> List<R> map(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(transform.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final Pair<List<Integer>, List<Integer>> partition(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            } else {
                arrayList2.add(Integer.valueOf(i));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.3")
    public static final boolean random(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length != 0) {
            return zArr[random.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final List<Boolean> reversed(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final boolean[] sliceArray(@NotNull boolean[] zArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr2[i] = zArr[it.next().intValue()];
            i++;
        }
        return zArr2;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull boolean[] zArr, @NotNull R[] other, @NotNull Function2<? super Boolean, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i]), other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (short s : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s)), valueTransform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short maxOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (s < s2) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short minOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (s > s2) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt___ArraysJvmKt.sortWith(tArr, AbstractC1919vr.reverseOrder(), i, i2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final short maxOrThrow(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            short s = sArr[0];
            ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (s < s2) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long maxWithOrNull(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) < 0) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final short minOrThrow(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            short s = sArr[0];
            ?? it = new IntRange(1, getLastIndex(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (s > s2) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long minWithOrNull(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) > 0) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double reduceRightIndexedOrNull(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double d = dArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            d = operation.invoke(Integer.valueOf(i), Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
        }
        return Double.valueOf(d);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Double reduceRightOrNull(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double d = dArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            d = operation.invoke(Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final Float singleOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Float f = null;
        boolean z = false;
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                if (z) {
                    return null;
                }
                f = Float.valueOf(f2);
                z = true;
            }
        }
        if (z) {
            return f;
        }
        return null;
    }

    @NotNull
    public static final List<Byte> slice(@NotNull byte[] bArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(bArr, i, i2);
        reverse(bArr, i, i2);
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(dArr.length), 16));
        for (double d : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Double> associateBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i)), valueTransform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @NotNull
    public static final <K> List<Long> distinctBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (hashSet.add(selector.invoke(Long.valueOf(j)))) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> dropLastWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Character> filterIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = cArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final char first(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Double.valueOf(d)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c : cArr) {
            AbstractC1327iq.addAll(destination, transform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    public static final char last(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Float lastOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            float f = fArr[length];
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return Float.valueOf(f);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @NotNull
    public static final <R> List<R> map(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(transform.invoke(Character.valueOf(c)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final long maxWithOrThrow(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length != 0) {
            long j = jArr[0];
            ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) < 0) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final long minWithOrThrow(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length != 0) {
            long j = jArr[0];
            ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) > 0) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length != 0) {
            return cArr[random.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float reduceIndexedOrNull(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            f = operation.invoke(Integer.valueOf(nextInt), Float.valueOf(f), Float.valueOf(fArr[nextInt])).floatValue();
        }
        return Float.valueOf(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Float reduceOrNull(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            f = operation.invoke(Float.valueOf(f), Float.valueOf(fArr[it.nextInt()])).floatValue();
        }
        return Float.valueOf(f);
    }

    public static final double reduceRight(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d = dArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                d = operation.invoke(Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d = dArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                d = operation.invoke(Integer.valueOf(i), Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final List<Character> reversed(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(iArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            int i = iArr[lastIndex];
            iArr[lastIndex] = iArr[nextInt];
            iArr[nextInt] = i;
        }
    }

    public static final double single(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final char[] sliceArray(@NotNull char[] cArr, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            cArr2[i] = cArr[it.next().intValue()];
            i++;
        }
        return cArr2;
    }

    @NotNull
    public static final List<Double> takeLastWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    @NotNull
    public static final List<Double> takeWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> toList(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return AbstractC1167eq.listOf(Double.valueOf(dArr[0]));
    }

    @NotNull
    public static final Set<Double> toSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(dArr, new LinkedHashSet(kh1.mapCapacity(dArr.length)));
        }
        return rh2.setOf(Double.valueOf(dArr[0]));
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull char[] cArr, @NotNull R[] other, @NotNull Function2<? super Character, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i]), other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> dropWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (float f : fArr) {
            if (z) {
                arrayList.add(Float.valueOf(f));
            } else if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final float reduce(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length != 0) {
            float f = fArr[0];
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                f = operation.invoke(Float.valueOf(f), Float.valueOf(fArr[it.nextInt()])).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final float reduceIndexed(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length != 0) {
            float f = fArr[0];
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                f = operation.invoke(Integer.valueOf(nextInt), Float.valueOf(f), Float.valueOf(fArr[nextInt])).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(sArr, i, i2);
        reverse(sArr, i, i2);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (long j : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j)), valueTransform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Short maxByOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s);
        }
        R invoke = selector.invoke(Short.valueOf(s));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            short s2 = sArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Short.valueOf(s2));
            if (invoke.compareTo(invoke2) < 0) {
                s = s2;
                invoke = invoke2;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> short maxByOrThrow(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            short s = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (lastIndex == 0) {
                return s;
            }
            R invoke = selector.invoke(Short.valueOf(s));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                short s2 = sArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Short.valueOf(s2));
                if (invoke.compareTo(invoke2) < 0) {
                    s = s2;
                    invoke = invoke2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Short minByOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s);
        }
        R invoke = selector.invoke(Short.valueOf(s));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            short s2 = sArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Short.valueOf(s2));
            if (invoke.compareTo(invoke2) > 0) {
                s = s2;
                invoke = invoke2;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> short minByOrThrow(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            short s = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (lastIndex == 0) {
                return s;
            }
            R invoke = selector.invoke(Short.valueOf(s));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                short s2 = sArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Short.valueOf(s2));
                if (invoke.compareTo(invoke2) > 0) {
                    s = s2;
                    invoke = invoke2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @Nullable
    public static final Double singleOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Double d = null;
        boolean z = false;
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                if (z) {
                    return null;
                }
                d = Double.valueOf(d2);
                z = true;
            }
        }
        if (z) {
            return d;
        }
        return null;
    }

    @NotNull
    public static final List<Integer> drop(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i >= 0) {
            return takeLast(iArr, r82.coerceAtLeast(iArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Integer> dropLast(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i >= 0) {
            return take(iArr, r82.coerceAtLeast(iArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    public static final <T> T first(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Integer.valueOf(i));
        }
        return destination;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull long[] jArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (long j : jArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Long.valueOf(j)));
            } else {
                buffer.append(String.valueOf(j));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> T last(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                T t = tArr[length];
                if (!predicate.invoke(t).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return t;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public static final Double lastOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            double d = dArr[length];
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return Double.valueOf(d);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer maxOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (i < i2) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer minOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (i > i2) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean reduceRightIndexedOrNull(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean z = zArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            z = operation.invoke(Integer.valueOf(i), Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Boolean reduceRightOrNull(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean z = zArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            z = operation.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @NotNull
    public static final int[] reversedArray(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            iArr2[lastIndex - nextInt] = iArr[nextInt];
        }
        return iArr2;
    }

    @NotNull
    public static final <T> T[] sliceArray(@NotNull T[] tArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, 0, 0) : (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static void sortDescending(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(iArr, i, i2);
        reverse(iArr, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull T[] tArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(tArr[i], r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Boolean> associateBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (float f : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f)), valueTransform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @NotNull
    public static final List<Boolean> dropLastWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final int maxOrThrow(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            int i = iArr[0];
            ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (i < i2) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final int minOrThrow(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            int i = iArr[0];
            ?? it = new IntRange(1, getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (i > i2) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final Pair<List<Long>, List<Long>> partition(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            } else {
                arrayList2.add(Long.valueOf(j));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean reduceRight(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean z = zArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                z = operation.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRightIndexed(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean z = zArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                z = operation.invoke(Integer.valueOf(i), Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean single(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final List<Short> slice(@NotNull short[] sArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> take(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= sArr.length) {
            return toList(sArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> takeLast(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = sArr.length;
        if (i >= length) {
            return toList(sArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Short.valueOf(sArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> takeLastWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    @NotNull
    public static final List<Boolean> takeWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> toList(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return AbstractC1167eq.listOf(Boolean.valueOf(zArr[0]));
    }

    @NotNull
    public static final Set<Boolean> toSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(zArr, new LinkedHashSet(kh1.mapCapacity(zArr.length)));
        }
        return rh2.setOf(Boolean.valueOf(zArr[0]));
    }

    public static final byte first(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return b;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float maxWithOrNull(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) < 0) {
                f = f2;
            }
        }
        return Float.valueOf(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float minWithOrNull(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) > 0) {
                f = f2;
            }
        }
        return Float.valueOf(f);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double reduceIndexedOrNull(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            d = operation.invoke(Integer.valueOf(nextInt), Double.valueOf(d), Double.valueOf(dArr[nextInt])).doubleValue();
        }
        return Double.valueOf(d);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Double reduceOrNull(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            d = operation.invoke(Double.valueOf(d), Double.valueOf(dArr[it.nextInt()])).doubleValue();
        }
        return Double.valueOf(d);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(jArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            long j = jArr[lastIndex];
            jArr[lastIndex] = jArr[nextInt];
            jArr[nextInt] = j;
        }
    }

    @Nullable
    public static final Boolean singleOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (z) {
                    return null;
                }
                bool = Boolean.valueOf(z2);
                z = true;
            }
        }
        if (z) {
            return bool;
        }
        return null;
    }

    @NotNull
    public static byte[] sliceArray(@NotNull byte[] bArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new byte[0] : ArraysKt___ArraysJvmKt.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static void sortDescending(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(jArr, i, i2);
        reverse(jArr, i, i2);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (double d : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d)), valueTransform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @NotNull
    public static final <K> List<Float> distinctBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (hashSet.add(selector.invoke(Float.valueOf(f)))) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> dropWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (double d : dArr) {
            if (z) {
                arrayList.add(Double.valueOf(d));
            } else if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Integer>> groupBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    @Nullable
    public static final Boolean lastOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            boolean z = zArr[length];
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final float maxWithOrThrow(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length != 0) {
            float f = fArr[0];
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                float f2 = fArr[it.nextInt()];
                if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) < 0) {
                    f = f2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final float minWithOrThrow(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length != 0) {
            float f = fArr[0];
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                float f2 = fArr[it.nextInt()];
                if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) > 0) {
                    f = f2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final double reduce(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length != 0) {
            double d = dArr[0];
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                d = operation.invoke(Double.valueOf(d), Double.valueOf(dArr[it.nextInt()])).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final double reduceIndexed(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length != 0) {
            double d = dArr[0];
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                d = operation.invoke(Integer.valueOf(nextInt), Double.valueOf(d), Double.valueOf(dArr[nextInt])).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(iArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            int i = iArr[nextInt];
            iArr[nextInt] = iArr[lastIndex];
            iArr[lastIndex] = i;
            lastIndex--;
        }
    }

    public static final short first(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return s;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte last(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                byte b = bArr[length];
                if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return b;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character reduceRightIndexedOrNull(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char c = cArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            c = operation.invoke(Integer.valueOf(i), Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
        }
        return Character.valueOf(c);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character reduceRightOrNull(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char c = cArr[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            c = operation.invoke(Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
        }
        return Character.valueOf(c);
    }

    @NotNull
    public static short[] sliceArray(@NotNull short[] sArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new short[0] : ArraysKt___ArraysJvmKt.copyOfRange(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static void sortDescending(@NotNull float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(fArr, i, i2);
        reverse(fArr, i, i2);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull byte[] bArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Byte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(cArr.length), 16));
        for (char c : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Character> associateBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(cArr.length), 16));
        for (char c : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (boolean z : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z)), valueTransform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    @NotNull
    public static final List<Character> dropLastWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            AbstractC1327iq.addAll(arrayList, transform.invoke(Character.valueOf(c)));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long maxOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (j < j2) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long minOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (j > j2) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    public static final char reduceRight(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c = cArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                c = operation.invoke(Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c = cArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                c = operation.invoke(Integer.valueOf(i), Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static char single(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static final Character singleOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(c);
                z = true;
            }
        }
        if (z) {
            return ch;
        }
        return null;
    }

    @NotNull
    public static final List<Character> takeLastWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    @NotNull
    public static final List<Character> takeWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> toList(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return AbstractC1167eq.listOf(Character.valueOf(cArr[0]));
    }

    @NotNull
    public static final Set<Character> toSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return sh2.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(cArr, new LinkedHashSet(kh1.mapCapacity(r82.coerceAtMost(cArr.length, 128))));
        }
        return rh2.setOf(Character.valueOf(cArr[0]));
    }

    public static final int first(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public static final Character lastOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            char c = cArr[length];
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return Character.valueOf(c);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final long maxOrThrow(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            long j = jArr[0];
            ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (j < j2) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final long minOrThrow(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            long j = jArr[0];
            ?? it = new IntRange(1, getLastIndex(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (j > j2) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final List<Integer> slice(@NotNull int[] iArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static int[] sliceArray(@NotNull int[] iArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new int[0] : ArraysKt___ArraysJvmKt.copyOfRange(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(dArr, i, i2);
        reverse(dArr, i, i2);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (char c : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c)), valueTransform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull float[] fArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (float f : fArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Float.valueOf(f)));
            } else {
                buffer.append(String.valueOf(f));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean reduceIndexedOrNull(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            z = operation.invoke(Integer.valueOf(nextInt), Boolean.valueOf(z), Boolean.valueOf(zArr[nextInt])).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Boolean reduceOrNull(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
        while (it.hasNext()) {
            z = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[it.nextInt()])).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(fArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            float f = fArr[lastIndex];
            fArr[lastIndex] = fArr[nextInt];
            fArr[nextInt] = f;
        }
    }

    @NotNull
    public static final List<Boolean> dropWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (boolean z2 : zArr) {
            if (z) {
                arrayList.add(Boolean.valueOf(z2));
            } else if (!predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
                z = true;
            }
        }
        return arrayList;
    }

    public static final long first(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short last(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                short s = sArr[length];
                if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return s;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double maxWithOrNull(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) < 0) {
                d = d2;
            }
        }
        return Double.valueOf(d);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double minWithOrNull(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) > 0) {
                d = d2;
            }
        }
        return Double.valueOf(d);
    }

    @NotNull
    public static final Pair<List<Float>, List<Float>> partition(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            } else {
                arrayList2.add(Float.valueOf(f));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final boolean reduce(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
            while (it.hasNext()) {
                z = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[it.nextInt()])).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final boolean reduceIndexed(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                z = operation.invoke(Integer.valueOf(nextInt), Boolean.valueOf(z), Boolean.valueOf(zArr[nextInt])).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static long[] sliceArray(@NotNull long[] jArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new long[0] : ArraysKt___ArraysJvmKt.copyOfRange(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(cArr, i, i2);
        reverse(cArr, i, i2);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull short[] sArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Short, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Short.valueOf(sArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> List<Double> distinctBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (hashSet.add(selector.invoke(Double.valueOf(d)))) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> drop(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i >= 0) {
            return takeLast(jArr, r82.coerceAtLeast(jArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Long> dropLast(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i >= 0) {
            return take(jArr, r82.coerceAtLeast(jArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final double maxWithOrThrow(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length != 0) {
            double d = dArr[0];
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                double d2 = dArr[it.nextInt()];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) < 0) {
                    d = d2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final double minWithOrThrow(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length != 0) {
            double d = dArr[0];
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                double d2 = dArr[it.nextInt()];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) > 0) {
                    d = d2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final long[] reversedArray(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            jArr2[lastIndex - nextInt] = jArr[nextInt];
        }
        return jArr2;
    }

    public static final <T> T single(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return f;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float maxOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            f = Math.max(f, fArr[it.nextInt()]);
        }
        return Float.valueOf(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float minOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
        while (it.hasNext()) {
            f = Math.min(f, fArr[it.nextInt()]);
        }
        return Float.valueOf(f);
    }

    @NotNull
    public static final float[] sliceArray(@NotNull float[] fArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new float[0] : ArraysKt___ArraysJvmKt.copyOfRange(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final float maxOrThrow(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float f = fArr[0];
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                f = Math.max(f, fArr[it.nextInt()]);
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final float minOrThrow(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float f = fArr[0];
            ?? it = new IntRange(1, getLastIndex(fArr)).iterator();
            while (it.hasNext()) {
                f = Math.min(f, fArr[it.nextInt()]);
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final List<Long> slice(@NotNull long[] jArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final double first(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return d;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                int i2 = iArr[length];
                if (!predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return i2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> int maxByOrThrow(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            int i = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex == 0) {
                return i;
            }
            R invoke = selector.invoke(Integer.valueOf(i));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                int i2 = iArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Integer.valueOf(i2));
                if (invoke.compareTo(invoke2) < 0) {
                    i = i2;
                    invoke = invoke2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> int minByOrThrow(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            int i = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex == 0) {
                return i;
            }
            R invoke = selector.invoke(Integer.valueOf(i));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                int i2 = iArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Integer.valueOf(i2));
                if (invoke.compareTo(invoke2) > 0) {
                    i = i2;
                    invoke = invoke2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character reduceIndexedOrNull(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            c = operation.invoke(Integer.valueOf(nextInt), Character.valueOf(c), Character.valueOf(cArr[nextInt])).charValue();
        }
        return Character.valueOf(c);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character reduceOrNull(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
        while (it.hasNext()) {
            c = operation.invoke(Character.valueOf(c), Character.valueOf(cArr[it.nextInt()])).charValue();
        }
        return Character.valueOf(c);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(dArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            double d = dArr[lastIndex];
            dArr[lastIndex] = dArr[nextInt];
            dArr[nextInt] = d;
        }
    }

    @NotNull
    public static final double[] sliceArray(@NotNull double[] dArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new double[0] : ArraysKt___ArraysJvmKt.copyOfRange(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull int[] iArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Integer, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b)), valueTransform.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final List<Character> dropWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (char c : cArr) {
            if (z) {
                arrayList.add(Character.valueOf(c));
            } else if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Long>> groupBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Integer maxByOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i);
        }
        R invoke = selector.invoke(Integer.valueOf(i));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            int i2 = iArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) < 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return Integer.valueOf(i);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Integer minByOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i);
        }
        R invoke = selector.invoke(Integer.valueOf(i));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            int i2 = iArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) > 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final char reduce(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length != 0) {
            char c = cArr[0];
            ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
            while (it.hasNext()) {
                c = operation.invoke(Character.valueOf(c), Character.valueOf(cArr[it.nextInt()])).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final char reduceIndexed(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length != 0) {
            char c = cArr[0];
            ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                c = operation.invoke(Integer.valueOf(nextInt), Character.valueOf(c), Character.valueOf(cArr[nextInt])).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(jArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            long j = jArr[nextInt];
            jArr[nextInt] = jArr[lastIndex];
            jArr[lastIndex] = j;
            lastIndex--;
        }
    }

    public static final byte single(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Byte b = null;
        boolean z = false;
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                if (!z) {
                    b = Byte.valueOf(b2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(b, "null cannot be cast to non-null type kotlin.Byte");
            return b.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean first(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return z;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull double[] dArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (double d : dArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Double.valueOf(d)));
            } else {
                buffer.append(String.valueOf(d));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean maxWithOrNull(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                z = z2;
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean minWithOrNull(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                z = z2;
            }
        }
        return Boolean.valueOf(z);
    }

    @NotNull
    public static final boolean[] sliceArray(@NotNull boolean[] zArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : ArraysKt___ArraysJvmKt.copyOfRange(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <K> List<Boolean> distinctBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (hashSet.add(selector.invoke(Boolean.valueOf(z)))) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final boolean maxWithOrThrow(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
            while (it.hasNext()) {
                boolean z2 = zArr[it.nextInt()];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                    z = z2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final boolean minWithOrThrow(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            ?? it = new IntRange(1, getLastIndex(zArr)).iterator();
            while (it.hasNext()) {
                boolean z2 = zArr[it.nextInt()];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                    z = z2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final Pair<List<Double>, List<Double>> partition(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            } else {
                arrayList2.add(Double.valueOf(d));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final List<Integer> take(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= iArr.length) {
            return toList(iArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (int i3 : iArr) {
            arrayList.add(Integer.valueOf(i3));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> takeLast(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = iArr.length;
        if (i >= length) {
            return toList(iArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Integer.valueOf(iArr[i2]));
        }
        return arrayList;
    }

    public static final char first(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return c;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                long j = jArr[length];
                if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return j;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double maxOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            d = Math.max(d, dArr[it.nextInt()]);
        }
        return Double.valueOf(d);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double minOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
        while (it.hasNext()) {
            d = Math.min(d, dArr[it.nextInt()]);
        }
        return Double.valueOf(d);
    }

    @NotNull
    public static final List<Float> slice(@NotNull float[] fArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final char[] sliceArray(@NotNull char[] cArr, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new char[0] : ArraysKt___ArraysJvmKt.copyOfRange(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull long[] jArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Long, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Long.valueOf(jArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s)), valueTransform.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double maxOrThrow(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            double d = dArr[0];
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                d = Math.max(d, dArr[it.nextInt()]);
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double minOrThrow(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            double d = dArr[0];
            ?? it = new IntRange(1, getLastIndex(dArr)).iterator();
            while (it.hasNext()) {
                d = Math.min(d, dArr[it.nextInt()]);
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(zArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            boolean z = zArr[lastIndex];
            zArr[lastIndex] = zArr[nextInt];
            zArr[nextInt] = z;
        }
    }

    @NotNull
    public static final List<Float> drop(@NotNull float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i >= 0) {
            return takeLast(fArr, r82.coerceAtLeast(fArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Float> dropLast(@NotNull float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i >= 0) {
            return take(fArr, r82.coerceAtLeast(fArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        return destination;
    }

    @NotNull
    public static final float[] reversedArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            fArr2[lastIndex - nextInt] = fArr[nextInt];
        }
        return fArr2;
    }

    public static final short single(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                if (!z) {
                    sh = Short.valueOf(s);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(sh, "null cannot be cast to non-null type kotlin.Short");
            return sh.shortValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                float f = fArr[length];
                if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return f;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character maxWithOrNull(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) < 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character minWithOrNull(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) > 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull float[] fArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Float, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Float.valueOf(fArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i)), valueTransform.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> List<Character> distinctBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (hashSet.add(selector.invoke(Character.valueOf(c)))) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull boolean[] zArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (boolean z : zArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Boolean.valueOf(z)));
            } else {
                buffer.append(String.valueOf(z));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final char maxWithOrThrow(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length != 0) {
            char c = cArr[0];
            ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) < 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final char minWithOrThrow(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length != 0) {
            char c = cArr[0];
            ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) > 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final List<Double> slice(@NotNull double[] dArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character maxOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (Intrinsics.compare((int) c, (int) c2) < 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character minOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (Intrinsics.compare((int) c, (int) c2) > 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    @NotNull
    public static final Pair<List<Boolean>, List<Boolean>> partition(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            } else {
                arrayList2.add(Boolean.valueOf(z));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(cArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            char c = cArr[lastIndex];
            cArr[lastIndex] = cArr[nextInt];
            cArr[nextInt] = c;
        }
    }

    @NotNull
    public static final <K> Map<K, List<Float>> groupBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final char maxOrThrow(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            char c = cArr[0];
            ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (Intrinsics.compare((int) c, (int) c2) < 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final char minOrThrow(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            char c = cArr[0];
            ?? it = new IntRange(1, getLastIndex(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (Intrinsics.compare((int) c, (int) c2) > 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static final void reverse(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(fArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            float f = fArr[nextInt];
            fArr[nextInt] = fArr[lastIndex];
            fArr[lastIndex] = f;
            lastIndex--;
        }
    }

    public static final double last(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                double d = dArr[length];
                if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return d;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull double[] dArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Double, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Double.valueOf(dArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j)), valueTransform.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> long maxByOrThrow(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            long j = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (lastIndex == 0) {
                return j;
            }
            R invoke = selector.invoke(Long.valueOf(j));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                long j2 = jArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Long.valueOf(j2));
                if (invoke.compareTo(invoke2) < 0) {
                    j = j2;
                    invoke = invoke2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> long minByOrThrow(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            long j = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (lastIndex == 0) {
                return j;
            }
            R invoke = selector.invoke(Long.valueOf(j));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                long j2 = jArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Long.valueOf(j2));
                if (invoke.compareTo(invoke2) > 0) {
                    j = j2;
                    invoke = invoke2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    public static final int single(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                if (!z) {
                    num = Integer.valueOf(i);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
            return num.intValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final List<Boolean> slice(@NotNull boolean[] zArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> drop(@NotNull double[] dArr, int i) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i >= 0) {
            return takeLast(dArr, r82.coerceAtLeast(dArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Double> dropLast(@NotNull double[] dArr, int i) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i >= 0) {
            return take(dArr, r82.coerceAtLeast(dArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Double.valueOf(d));
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Long maxByOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j);
        }
        R invoke = selector.invoke(Long.valueOf(j));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            long j2 = jArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Long.valueOf(j2));
            if (invoke.compareTo(invoke2) < 0) {
                j = j2;
                invoke = invoke2;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Long minByOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j);
        }
        R invoke = selector.invoke(Long.valueOf(j));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            long j2 = jArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Long.valueOf(j2));
            if (invoke.compareTo(invoke2) > 0) {
                j = j2;
                invoke = invoke2;
            }
        }
        return Long.valueOf(j);
    }

    @NotNull
    public static final double[] reversedArray(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            dArr2[lastIndex - nextInt] = dArr[nextInt];
        }
        return dArr2;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull char[] cArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (char c : cArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Character.valueOf(c)));
            } else {
                buffer.append(c);
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean last(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                boolean z = zArr[length];
                if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return z;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Boolean, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f)), valueTransform.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Pair<List<Character>, List<Character>> partition(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            } else {
                arrayList2.add(Character.valueOf(c));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final List<Long> take(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= jArr.length) {
            return toList(jArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> takeLast(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = jArr.length;
        if (i >= length) {
            return toList(jArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Long.valueOf(jArr[i2]));
        }
        return arrayList;
    }

    public static final long single(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                if (!z) {
                    l = Long.valueOf(j);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(l, "null cannot be cast to non-null type kotlin.Long");
            return l.longValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final List<Character> slice(@NotNull char[] cArr, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char last(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char c = cArr[length];
                if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return c;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull char[] cArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Character, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Character.valueOf(cArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d)), valueTransform.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Double>> groupBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Double.valueOf(d));
        }
        return linkedHashMap;
    }

    public static final void reverse(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(dArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            double d = dArr[nextInt];
            dArr[nextInt] = dArr[lastIndex];
            dArr[lastIndex] = d;
            lastIndex--;
        }
    }

    @NotNull
    public static final List<Boolean> drop(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i >= 0) {
            return takeLast(zArr, r82.coerceAtLeast(zArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Boolean> dropLast(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i >= 0) {
            return take(zArr, r82.coerceAtLeast(zArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return destination;
    }

    @NotNull
    public static final boolean[] reversedArray(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            zArr2[lastIndex - nextInt] = zArr[nextInt];
        }
        return zArr2;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull byte[] bArr, @NotNull byte[] other, @NotNull Function2<? super Byte, ? super Byte, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z)), valueTransform.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    public static final float single(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Float f = null;
        boolean z = false;
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                if (!z) {
                    f = Float.valueOf(f2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(f, "null cannot be cast to non-null type kotlin.Float");
            return f.floatValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> float maxByOrThrow(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            float f = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex == 0) {
                return f;
            }
            R invoke = selector.invoke(Float.valueOf(f));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                float f2 = fArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Float.valueOf(f2));
                if (invoke.compareTo(invoke2) < 0) {
                    f = f2;
                    invoke = invoke2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> float minByOrThrow(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            float f = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex == 0) {
                return f;
            }
            R invoke = selector.invoke(Float.valueOf(f));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                float f2 = fArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Float.valueOf(f2));
                if (invoke.compareTo(invoke2) > 0) {
                    f = f2;
                    invoke = invoke2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull short[] sArr, @NotNull short[] other, @NotNull Function2<? super Short, ? super Short, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i]), Short.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(cArr.length), 16));
        for (char c : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c)), valueTransform.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Float maxByOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f);
        }
        R invoke = selector.invoke(Float.valueOf(f));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            float f2 = fArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Float.valueOf(f2));
            if (invoke.compareTo(invoke2) < 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return Float.valueOf(f);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Float minByOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f);
        }
        R invoke = selector.invoke(Float.valueOf(f));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            float f2 = fArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Float.valueOf(f2));
            if (invoke.compareTo(invoke2) > 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return Float.valueOf(f);
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull int[] iArr, @NotNull int[] other, @NotNull Function2<? super Integer, ? super Integer, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i]), Integer.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Boolean>> groupBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    public static final void reverse(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(zArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            boolean z = zArr[nextInt];
            zArr[nextInt] = zArr[lastIndex];
            zArr[lastIndex] = z;
            lastIndex--;
        }
    }

    public static final double single(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Double d = null;
        boolean z = false;
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                if (!z) {
                    d = Double.valueOf(d2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(d, "null cannot be cast to non-null type kotlin.Double");
            return d.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final List<Float> take(@NotNull float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= fArr.length) {
            return toList(fArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> takeLast(@NotNull float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = fArr.length;
        if (i >= length) {
            return toList(fArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Float.valueOf(fArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> drop(@NotNull char[] cArr, int i) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i >= 0) {
            return takeLast(cArr, r82.coerceAtLeast(cArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final List<Character> dropLast(@NotNull char[] cArr, int i) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i >= 0) {
            return take(cArr, r82.coerceAtLeast(cArr.length - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(Character.valueOf(c));
        }
        return destination;
    }

    @NotNull
    public static final char[] reversedArray(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, lastIndex);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            cArr2[lastIndex - nextInt] = cArr[nextInt];
        }
        return cArr2;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull long[] jArr, @NotNull long[] other, @NotNull Function2<? super Long, ? super Long, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i]), Long.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull float[] fArr, @NotNull float[] other, @NotNull Function2<? super Float, ? super Float, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i]), Float.valueOf(other[i])));
        }
        return arrayList;
    }

    public static final boolean single(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (!z) {
                    bool = Boolean.valueOf(z2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
            return bool.booleanValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> double maxByOrThrow(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex == 0) {
                return d;
            }
            R invoke = selector.invoke(Double.valueOf(d));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                double d2 = dArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Double.valueOf(d2));
                if (invoke.compareTo(invoke2) < 0) {
                    d = d2;
                    invoke = invoke2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> double minByOrThrow(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex == 0) {
                return d;
            }
            R invoke = selector.invoke(Double.valueOf(d));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                double d2 = dArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Double.valueOf(d2));
                if (invoke.compareTo(invoke2) > 0) {
                    d = d2;
                    invoke = invoke2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull double[] dArr, @NotNull double[] other, @NotNull Function2<? super Double, ? super Double, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i]), Double.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Character>> groupBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(Character.valueOf(c));
        }
        return linkedHashMap;
    }

    public static final void reverse(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(cArr);
        IntIterator m7068x = AbstractC1726qj.m7068x(0, length);
        while (m7068x.hasNext()) {
            int nextInt = m7068x.nextInt();
            char c = cArr[nextInt];
            cArr[nextInt] = cArr[lastIndex];
            cArr[lastIndex] = c;
            lastIndex--;
        }
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return destination;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull boolean[] zArr, @NotNull boolean[] other, @NotNull Function2<? super Boolean, ? super Boolean, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(other[i])));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Double maxByOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d);
        }
        R invoke = selector.invoke(Double.valueOf(d));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            double d2 = dArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Double.valueOf(d2));
            if (invoke.compareTo(invoke2) < 0) {
                d = d2;
                invoke = invoke2;
            }
        }
        return Double.valueOf(d);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Double minByOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d);
        }
        R invoke = selector.invoke(Double.valueOf(d));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            double d2 = dArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Double.valueOf(d2));
            if (invoke.compareTo(invoke2) > 0) {
                d = d2;
                invoke = invoke2;
            }
        }
        return Double.valueOf(d);
    }

    public static final char single(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(c);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(ch, "null cannot be cast to non-null type kotlin.Char");
            return ch.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final List<Double> take(@NotNull double[] dArr, int i) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= dArr.length) {
            return toList(dArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> takeLast(@NotNull double[] dArr, int i) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = dArr.length;
        if (i >= length) {
            return toList(dArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Double.valueOf(dArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull char[] cArr, @NotNull char[] other, @NotNull Function2<? super Character, ? super Character, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i]), Character.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] tArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(tArr[i], other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> void reverse(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, tArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            T t = tArr[i];
            tArr[i] = tArr[i4];
            tArr[i4] = t;
            i4--;
            i++;
        }
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> boolean maxByOrThrow(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (lastIndex == 0) {
                return z;
            }
            R invoke = selector.invoke(Boolean.valueOf(z));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                boolean z2 = zArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Boolean.valueOf(z2));
                if (invoke.compareTo(invoke2) < 0) {
                    z = z2;
                    invoke = invoke2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> boolean minByOrThrow(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (lastIndex == 0) {
                return z;
            }
            R invoke = selector.invoke(Boolean.valueOf(z));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                boolean z2 = zArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Boolean.valueOf(z2));
                if (invoke.compareTo(invoke2) > 0) {
                    z = z2;
                    invoke = invoke2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] bArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            byte b = bArr[i];
            arrayList.add(TuplesKt.m5575to(Byte.valueOf(b), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static void reverse(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, bArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            byte b = bArr[i];
            bArr[i] = bArr[i4];
            bArr[i4] = b;
            i4--;
            i++;
        }
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Boolean maxByOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z);
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            boolean z2 = zArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) < 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Boolean minByOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z);
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            boolean z2 = zArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) > 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return Boolean.valueOf(z);
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> zip(@NotNull short[] sArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            short s = sArr[i];
            arrayList.add(TuplesKt.m5575to(Short.valueOf(s), other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> take(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= zArr.length) {
            return toList(zArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> takeLast(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = zArr.length;
        if (i >= length) {
            return toList(zArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Boolean.valueOf(zArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    public static void reverse(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, sArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            short s = sArr[i];
            sArr[i] = sArr[i4];
            sArr[i4] = s;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] iArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            int i2 = iArr[i];
            arrayList.add(TuplesKt.m5575to(Integer.valueOf(i2), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char maxByOrThrow(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex == 0) {
                return c;
            }
            R invoke = selector.invoke(Character.valueOf(c));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                char c2 = cArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Character.valueOf(c2));
                if (invoke.compareTo(invoke2) < 0) {
                    c = c2;
                    invoke = invoke2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char minByOrThrow(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex == 0) {
                return c;
            }
            R invoke = selector.invoke(Character.valueOf(c));
            IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
            while (m7068x.hasNext()) {
                char c2 = cArr[m7068x.nextInt()];
                R invoke2 = selector.invoke(Character.valueOf(c2));
                if (invoke.compareTo(invoke2) > 0) {
                    c = c2;
                    invoke = invoke2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    public static void reverse(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, iArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            int i5 = iArr[i];
            iArr[i] = iArr[i4];
            iArr[i4] = i5;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> zip(@NotNull long[] jArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            long j = jArr[i];
            arrayList.add(TuplesKt.m5575to(Long.valueOf(j), other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Character maxByOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c);
        }
        R invoke = selector.invoke(Character.valueOf(c));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            char c2 = cArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Character.valueOf(c2));
            if (invoke.compareTo(invoke2) < 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(c);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Character minByOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c);
        }
        R invoke = selector.invoke(Character.valueOf(c));
        IntIterator m7068x = AbstractC1726qj.m7068x(1, lastIndex);
        while (m7068x.hasNext()) {
            char c2 = cArr[m7068x.nextInt()];
            R invoke2 = selector.invoke(Character.valueOf(c2));
            if (invoke.compareTo(invoke2) > 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(c);
    }

    @SinceKotlin(version = "1.4")
    public static void reverse(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, jArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            long j = jArr[i];
            jArr[i] = jArr[i4];
            jArr[i4] = j;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final List<Character> take(@NotNull char[] cArr, int i) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i >= cArr.length) {
            return toList(cArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> takeLast(@NotNull char[] cArr, int i) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = cArr.length;
        if (i >= length) {
            return toList(cArr);
        }
        if (i == 1) {
            return AbstractC1167eq.listOf(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Character.valueOf(cArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> zip(@NotNull float[] fArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            float f = fArr[i];
            arrayList.add(TuplesKt.m5575to(Float.valueOf(f), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, fArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            float f = fArr[i];
            fArr[i] = fArr[i4];
            fArr[i4] = f;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> zip(@NotNull double[] dArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            double d = dArr[i];
            arrayList.add(TuplesKt.m5575to(Double.valueOf(d), other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, dArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            double d = dArr[i];
            dArr[i] = dArr[i4];
            dArr[i4] = d;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] zArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            boolean z = zArr[i];
            arrayList.add(TuplesKt.m5575to(Boolean.valueOf(z), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull boolean[] zArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, zArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            boolean z = zArr[i];
            zArr[i] = zArr[i4];
            zArr[i4] = z;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> zip(@NotNull char[] cArr, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            char c = cArr[i];
            arrayList.add(TuplesKt.m5575to(Character.valueOf(c), other[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, cArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            char c = cArr[i];
            cArr[i] = cArr[i4];
            cArr[i4] = c;
            i4--;
            i++;
        }
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] tArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(tArr[i], r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] bArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Byte.valueOf(bArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> zip(@NotNull short[] sArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Short.valueOf(sArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] iArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Integer.valueOf(iArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7067w(destination, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> zip(@NotNull long[] jArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Long.valueOf(jArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> zip(@NotNull float[] fArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Float.valueOf(fArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> zip(@NotNull double[] dArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Double.valueOf(dArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Boolean.valueOf(zArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> zip(@NotNull char[] cArr, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(Character.valueOf(cArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Byte, Byte>> zip(@NotNull byte[] bArr, @NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Byte.valueOf(bArr[i]), Byte.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Short, Short>> zip(@NotNull short[] sArr, @NotNull short[] other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Short.valueOf(sArr[i]), Short.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Integer, Integer>> zip(@NotNull int[] iArr, @NotNull int[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Integer.valueOf(iArr[i]), Integer.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Long, Long>> zip(@NotNull long[] jArr, @NotNull long[] other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Long.valueOf(jArr[i]), Long.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Float, Float>> zip(@NotNull float[] fArr, @NotNull float[] other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Float.valueOf(fArr[i]), Float.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Double, Double>> zip(@NotNull double[] dArr, @NotNull double[] other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Double.valueOf(dArr[i]), Double.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Boolean, Boolean>> zip(@NotNull boolean[] zArr, @NotNull boolean[] other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Boolean.valueOf(zArr[i]), Boolean.valueOf(other[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Character, Character>> zip(@NotNull char[] cArr, @NotNull char[] other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(Character.valueOf(cArr[i]), Character.valueOf(other[i])));
        }
        return arrayList;
    }
}
