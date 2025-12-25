package kotlin.sequences;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
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
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1278hq;
import p000.AbstractC1327iq;
import p000.AbstractC1726qj;
import p000.AbstractC1919vr;
import p000.C1223g8;
import p000.C1520lq;
import p000.C1807sq;
import p000.C1891v;
import p000.C1952wn;
import p000.a10;
import p000.h10;
import p000.hd0;
import p000.hg2;
import p000.ig2;
import p000.jg2;
import p000.kg2;
import p000.ko2;
import p000.lg2;
import p000.mg2;
import p000.ng2;
import p000.og2;
import p000.pg2;
import p000.qg2;
import p000.sh2;
import p000.vf0;
import p000.ye0;

/* loaded from: classes2.dex */
public abstract class SequencesKt___SequencesKt extends hg2 {
    public static final <T> boolean all(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        while (m8304x.hasNext()) {
            if (!function1.invoke((Object) m8304x.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        while (m8304x.hasNext()) {
            if (function1.invoke((Object) m8304x.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static <T> Iterable<T> asIterable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Sequence<? extends T> sequence, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : sequence) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Sequence<? extends T> sequence, @NotNull M destination, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull Sequence<? extends K> sequence, @NotNull Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k : sequence) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Sequence<? extends K> sequence, @NotNull M destination, @NotNull Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k : sequence) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(@NotNull Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Byte> it = sequence.iterator();
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
    public static final double averageOfDouble(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it = sequence.iterator();
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
    public static final double averageOfFloat(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it = sequence.iterator();
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
    public static final double averageOfInt(@NotNull Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Integer> it = sequence.iterator();
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
    public static final double averageOfLong(@NotNull Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Long> it = sequence.iterator();
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
    public static final double averageOfShort(@NotNull Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Short> it = sequence.iterator();
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
    public static final <T> Sequence<List<T>> chunked(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return windowed(sequence, i, i, true);
    }

    public static <T> boolean contains(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (indexOf(sequence, t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> int count(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        int i = 0;
        while (m8304x.hasNext()) {
            if (function1.invoke((Object) m8304x.next()).booleanValue() && (i = i + 1) < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    @NotNull
    public static final <T> Sequence<T> distinct(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return distinctBy(sequence, C1223g8.f17584m);
    }

    @NotNull
    public static final <T, K> Sequence<T> distinctBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new DistinctSequence(sequence, selector);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Sequence<T> drop(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i >= 0) {
            if (i != 0) {
                if (sequence instanceof DropTakeSequence) {
                    return ((DropTakeSequence) sequence).drop(i);
                }
                return new DropSequence(sequence, i);
            }
            return sequence;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> Sequence<T> dropWhile(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new DropWhileSequence(sequence, predicate);
    }

    public static final <T> T elementAt(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (T) elementAtOrElse(sequence, i, new C1520lq(i, 1));
    }

    public static final <T> T elementAtOrElse(@NotNull Sequence<? extends T> sequence, int i, @NotNull Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (i < 0) {
            return defaultValue.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    @Nullable
    public static final <T> T elementAtOrNull(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return null;
    }

    @NotNull
    public static <T> Sequence<T> filter(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    @NotNull
    public static final <T> Sequence<T> filterIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new TransformingSequence(new FilteringSequence(new IndexingSequence(sequence), true, new C1891v(14, predicate)), C1223g8.f17585n);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (T t : sequence) {
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

    public static final /* synthetic */ <R> Sequence<R> filterIsInstance(Sequence<?> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.needClassReification();
        Sequence<R> filter = filter(sequence, new Function1<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable Object obj) {
                Intrinsics.reifiedOperationMarker(3, "R");
                return Boolean.valueOf(obj instanceof Object);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return filter;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Sequence<?> sequence, C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : sequence) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T> Sequence<T> filterNot(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    @NotNull
    public static final <T> Sequence<T> filterNotNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Sequence<T> filterNot = filterNot(sequence, C1223g8.f17586o);
        Intrinsics.checkNotNull(filterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return filterNot;
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : sequence) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T first(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        while (m8304x.hasNext()) {
            ?? r0 = (Object) m8304x.next();
            if (function1.invoke(r0).booleanValue()) {
                return r0;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T firstOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        while (m8304x.hasNext()) {
            ?? r0 = (Object) m8304x.next();
            if (function1.invoke(r0).booleanValue()) {
                return r0;
            }
        }
        return null;
    }

    @NotNull
    public static final <T, R> Sequence<R> flatMap(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new FlatteningSequence(sequence, transform, jg2.f20498h);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIndexedIterable")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> Sequence<R> flatMapIndexedIterable(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(sequence, transform, kg2.f20849h);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIndexedSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> Sequence<R> flatMapIndexedSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(sequence, transform, lg2.f22498h);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIterable")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> Sequence<R> flatMapIterable(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new FlatteningSequence(sequence, transform, ig2.f18406h);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIterableTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R> R fold(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i = 0;
        for (T t : sequence) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            r = operation.invoke(Integer.valueOf(i), r, t);
            i = i2;
        }
        return r;
    }

    public static final <T> void forEach(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Unit> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "action");
        while (m8304x.hasNext()) {
            function1.invoke((Object) m8304x.next());
        }
    }

    public static final <T> void forEachIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        for (T t : sequence) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i), t);
            i = i2;
        }
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
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
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Sequence<? extends T> sequence, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : sequence) {
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
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull final Sequence<? extends T> sequence, @NotNull final Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new Grouping<T, K>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$groupingBy$1
            @Override // kotlin.collections.Grouping
            public K keyOf(T element) {
                return (K) keySelector.invoke(element);
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<T> sourceIterator() {
                return sequence.iterator();
            }
        };
    }

    public static final <T> int indexOf(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (T t2 : sequence) {
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

    public static final <T> int indexOfFirst(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        int i = 0;
        while (m8304x.hasNext()) {
            a10 a10Var = (Object) m8304x.next();
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (function1.invoke(a10Var).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        int i = -1;
        int i2 = 0;
        while (m8304x.hasNext()) {
            a10 a10Var = (Object) m8304x.next();
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (function1.invoke(a10Var).booleanValue()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull Sequence<? extends T> sequence, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : sequence) {
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

    public static /* synthetic */ Appendable joinTo$default(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinTo(sequence, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, function12);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull Sequence<? extends T> sequence, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) joinTo(sequence, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(sequence, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T last(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        T t = null;
        boolean z = false;
        while (m8304x.hasNext()) {
            ?? r2 = (Object) m8304x.next();
            if (function1.invoke(r2).booleanValue()) {
                z = true;
                t = r2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = -1;
        int i2 = 0;
        for (T t2 : sequence) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    @Nullable
    public static final <T> T lastOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        T t = null;
        while (m8304x.hasNext()) {
            ?? r1 = (Object) m8304x.next();
            if (function1.invoke(r1).booleanValue()) {
                t = r1;
            }
        }
        return t;
    }

    @NotNull
    public static <T, R> Sequence<R> map(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    @NotNull
    public static final <T, R> Sequence<R> mapIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new TransformingIndexedSequence(sequence, transform);
    }

    @NotNull
    public static final <T, R> Sequence<R> mapIndexedNotNull(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return filterNotNull(new TransformingIndexedSequence(sequence, transform));
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        for (T t : sequence) {
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
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        for (T t : sequence) {
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
    public static <T, R> Sequence<R> mapNotNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return filterNotNull(new TransformingSequence(sequence, transform));
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Sequence<? extends T> sequence, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "selector");
        if (!m8304x.hasNext()) {
            return null;
        }
        ?? r0 = (Object) m8304x.next();
        if (!m8304x.hasNext()) {
            return r0;
        }
        R invoke = function1.invoke(r0);
        do {
            Object obj = (Object) m8304x.next();
            R invoke2 = function1.invoke(obj);
            r0 = r0;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                r0 = (T) obj;
            }
        } while (m8304x.hasNext());
        return (T) r0;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "selector");
        if (m8304x.hasNext()) {
            ?? r0 = (Object) m8304x.next();
            if (!m8304x.hasNext()) {
                return r0;
            }
            R invoke = function1.invoke(r0);
            do {
                Object obj = (Object) m8304x.next();
                R invoke2 = function1.invoke(obj);
                r0 = r0;
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                    r0 = (T) obj;
                }
            } while (m8304x.hasNext());
            return (T) r0;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull */
    public static final Double m8704maxOrNull(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it = sequence.iterator();
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
    public static final double maxOrThrow(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it = sequence.iterator();
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
    public static final <T> T maxWithOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final <T> T maxWithOrThrow(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = sequence.iterator();
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
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T minByOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "selector");
        if (!m8304x.hasNext()) {
            return null;
        }
        ?? r0 = (Object) m8304x.next();
        if (!m8304x.hasNext()) {
            return r0;
        }
        R invoke = function1.invoke(r0);
        do {
            Object obj = (Object) m8304x.next();
            R invoke2 = function1.invoke(obj);
            r0 = r0;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                r0 = (T) obj;
            }
        } while (m8304x.hasNext());
        return (T) r0;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T minByOrThrow(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "selector");
        if (m8304x.hasNext()) {
            ?? r0 = (Object) m8304x.next();
            if (!m8304x.hasNext()) {
                return r0;
            }
            R invoke = function1.invoke(r0);
            do {
                Object obj = (Object) m8304x.next();
                R invoke2 = function1.invoke(obj);
                r0 = r0;
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                    r0 = (T) obj;
                }
            } while (m8304x.hasNext());
            return (T) r0;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull */
    public static final Double m8708minOrNull(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it = sequence.iterator();
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
    public static final double minOrThrow(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it = sequence.iterator();
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
    public static final <T> T minWithOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final <T> T minWithOrThrow(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final <T> Sequence<T> minus(@NotNull final Sequence<? extends T> sequence, final T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return SequencesKt___SequencesKt.filter(Sequence.this, new C1807sq(5, new Ref.BooleanRef(), t)).iterator();
            }
        };
    }

    public static final <T> boolean none(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        while (m8304x.hasNext()) {
            if (function1.invoke((Object) m8304x.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> Sequence<T> onEach(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return map(sequence, new vf0(1, action));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> onEachIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return mapIndexed(sequence, new hd0(1, action));
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, SequencesKt__SequencesKt.sequenceOf(t)));
    }

    public static final <S, T extends S> S reduce(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            S next = it.next();
            while (it.hasNext()) {
                next = operation.invoke(next, it.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = sequence.iterator();
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
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceIndexedOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final <S, T extends S> S reduceOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @NotNull
    public static final <T> Sequence<T> requireNoNulls(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return map(sequence, new C1891v(17, sequence));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> Sequence<R> runningFold(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new mg2(r, sequence, operation, null));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> Sequence<R> runningFoldIndexed(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new ng2(r, sequence, operation, null));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <S, T extends S> Sequence<S> runningReduce(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new og2(sequence, operation, null));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S, T extends S> Sequence<S> runningReduceIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new pg2(sequence, operation, null));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, R> Sequence<R> scan(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return runningFold(sequence, r, operation);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T, R> Sequence<R> scanIndexed(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return runningFoldIndexed(sequence, r, operation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T single(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        T t = null;
        boolean z = false;
        while (m8304x.hasNext()) {
            ?? r2 = (Object) m8304x.next();
            if (function1.invoke(r2).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                z = true;
                t = r2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T singleOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "predicate");
        boolean z = false;
        T t = null;
        while (m8304x.hasNext()) {
            ?? r3 = (Object) m8304x.next();
            if (function1.invoke(r3).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = r3;
            }
        }
        if (z) {
            return t;
        }
        return null;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Sequence<T> sorted(@NotNull final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (Sequence<T>) new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$sorted$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                List mutableList = SequencesKt___SequencesKt.toMutableList(Sequence.this);
                AbstractC1278hq.sort(mutableList);
                return mutableList.iterator();
            }
        };
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sortedWith(sequence, AbstractC1919vr.reverseOrder());
    }

    @NotNull
    public static <T> Sequence<T> sortedWith(@NotNull final Sequence<? extends T> sequence, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$sortedWith$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                List mutableList = SequencesKt___SequencesKt.toMutableList(Sequence.this);
                AbstractC1278hq.sortWith(mutableList, comparator);
                return mutableList.iterator();
            }
        };
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Integer> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "selector");
        int i = 0;
        while (m8304x.hasNext()) {
            i += function1.invoke((Object) m8304x.next()).intValue();
        }
        return i;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Double> function1) {
        Iterator m8304x = ye0.m8304x(sequence, "<this>", function1, "selector");
        double d = 0.0d;
        while (m8304x.hasNext()) {
            d += function1.invoke((Object) m8304x.next()).doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(@NotNull Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Byte> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().byteValue();
        }
        return i;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it = sequence.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += it.next().doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it = sequence.iterator();
        float f = RecyclerView.f7068F0;
        while (it.hasNext()) {
            f += it.next().floatValue();
        }
        return f;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(@NotNull Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Integer> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(@NotNull Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Long> it = sequence.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().longValue();
        }
        return j;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(@NotNull Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Short> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().shortValue();
        }
        return i;
    }

    @NotNull
    public static final <T> Sequence<T> take(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return SequencesKt__SequencesKt.emptySequence();
            }
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).take(i);
            }
            return new TakeSequence(sequence, i);
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @NotNull
    public static final <T> Sequence<T> takeWhile(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new TakeWhileSequence(sequence, predicate);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Sequence<? extends T> sequence, @NotNull C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    @NotNull
    public static <T> List<T> toList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(sequence));
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (List) toCollection(sequence, new ArrayList());
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sh2.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<List<T>> windowed(@NotNull Sequence<? extends T> sequence, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SlidingWindowKt.windowedSequence(sequence, i, i2, z, false);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i, i2, z);
    }

    @NotNull
    public static final <T> Sequence<IndexedValue<T>> withIndex(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new IndexingSequence(sequence);
    }

    @NotNull
    public static final <T, R> Sequence<Pair<T, R>> zip(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends R> other) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new MergingSequence(sequence, other, C1952wn.f28250i);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<Pair<T, T>> zipWithNext(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return zipWithNext(sequence, C1952wn.f28251j);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> Sequence<R> chunked(@NotNull Sequence<? extends T> sequence, int i, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return windowed(sequence, i, i, true, transform);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Sequence<T> minus(@NotNull final Sequence<? extends T> sequence, @NotNull final T[] elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? sequence : new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$2
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return SequencesKt___SequencesKt.filterNot(Sequence.this, new C1891v(15, elements)).iterator();
            }
        };
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull T[] elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return plus((Sequence) sequence, (Iterable) ArraysKt___ArraysJvmKt.asList(elements));
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> Sequence<R> windowed(@NotNull Sequence<? extends T> sequence, int i, int i2, boolean z, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return map(SlidingWindowKt.windowedSequence(sequence, i, i2, z, true), transform);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i, i2, z, function1);
    }

    @NotNull
    public static final <T, R, V> Sequence<V> zip(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends R> other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new MergingSequence(sequence, other, transform);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> Sequence<R> zipWithNext(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super T, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt__SequenceBuilderKt.sequence(new qg2(sequence, transform, null));
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Sequence<? extends T> sequence, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : sequence) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, CollectionsKt___CollectionsKt.asSequence(elements)));
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull final Sequence<? extends T> sequence, @NotNull final Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                Collection convertToListIfNotCollection = AbstractC1327iq.convertToListIfNotCollection(elements);
                boolean isEmpty = convertToListIfNotCollection.isEmpty();
                Sequence sequence2 = sequence;
                if (isEmpty) {
                    return sequence2.iterator();
                }
                return SequencesKt___SequencesKt.filterNot(sequence2, new h10(convertToListIfNotCollection, 1)).iterator();
            }
        };
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, elements));
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull final Sequence<? extends T> sequence, @NotNull final Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$4
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                List list = SequencesKt___SequencesKt.toList(Sequence.this);
                boolean isEmpty = list.isEmpty();
                Sequence sequence2 = sequence;
                if (isEmpty) {
                    return sequence2.iterator();
                }
                return SequencesKt___SequencesKt.filterNot(sequence2, new C1891v(16, list)).iterator();
            }
        };
    }

    public static final <T> boolean any(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence.iterator().hasNext();
    }

    public static <T> int count(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
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

    @Nullable
    public static <T> T firstOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T> boolean none(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return !sequence.iterator().hasNext();
    }

    public static final <T> T first(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> T last(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull */
    public static final Float m8705maxOrNull(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it = sequence.iterator();
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
    /* renamed from: maxOrThrow */
    public static final float m8706maxOrThrow(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it = sequence.iterator();
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
    /* renamed from: minOrNull */
    public static final Float m8709minOrNull(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it = sequence.iterator();
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
    /* renamed from: minOrThrow */
    public static final float m8710minOrThrow(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it = sequence.iterator();
        if (it.hasNext()) {
            float floatValue = it.next().floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, it.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T> T single(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Sequence has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Sequence<? extends T> sequence, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : sequence) {
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
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = AbstractC1726qj.m7066v(linkedHashMap, invoke);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T extends Comparable<? super T>> T maxOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
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
    /* renamed from: maxOrThrow */
    public static final <T extends Comparable<? super T>> T m8707maxOrThrow(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final <T extends Comparable<? super T>> T minOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
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
    /* renamed from: minOrThrow */
    public static final <T extends Comparable<? super T>> T m8711minOrThrow(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
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
}
