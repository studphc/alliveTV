package kotlin.streams.jdk8;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, m5569d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, m5570k = 2, m5571mv = {1, 8, 0}, m5572pn = "kotlin.streams", m5573xi = 48)
@JvmName(name = "StreamsKt")
/* loaded from: classes2.dex */
public final class StreamsKt {
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull final Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "<this>");
        return new Sequence<T>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                Iterator<T> it;
                it = stream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [ho2] */
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Stream<T> asStream(@NotNull final Sequence<? extends T> sequence) {
        Stream<T> stream;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        stream = StreamSupport.stream(new Supplier() { // from class: ho2
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator spliteratorUnknownSize;
                Sequence this_asStream = Sequence.this;
                Intrinsics.checkNotNullParameter(this_asStream, "$this_asStream");
                spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(this_asStream.iterator(), 16);
                return spliteratorUnknownSize;
            }
        }, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return stream;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> toList(@NotNull Stream<T> stream) {
        Collector list;
        Object collect;
        Intrinsics.checkNotNullParameter(stream, "<this>");
        list = Collectors.toList();
        collect = stream.collect(list);
        Intrinsics.checkNotNullExpressionValue(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Integer> asSequence(@NotNull final IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, "<this>");
        return new Sequence<Integer>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Integer> iterator() {
                PrimitiveIterator.OfInt it;
                it = intStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Integer> toList(@NotNull IntStream intStream) {
        int[] array;
        Intrinsics.checkNotNullParameter(intStream, "<this>");
        array = intStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Long> asSequence(@NotNull final LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, "<this>");
        return new Sequence<Long>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Long> iterator() {
                PrimitiveIterator.OfLong it;
                it = longStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Long> toList(@NotNull LongStream longStream) {
        long[] array;
        Intrinsics.checkNotNullParameter(longStream, "<this>");
        array = longStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Double> asSequence(@NotNull final DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, "<this>");
        return new Sequence<Double>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Double> iterator() {
                PrimitiveIterator.OfDouble it;
                it = doubleStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Double> toList(@NotNull DoubleStream doubleStream) {
        double[] array;
        Intrinsics.checkNotNullParameter(doubleStream, "<this>");
        array = doubleStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }
}
