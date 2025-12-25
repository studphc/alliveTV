package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1223g8;
import p000.C1829tb;
import p000.C1891v;
import p000.eg2;
import p000.fg2;
import p000.gg2;
import p000.qw0;
import p000.w80;

/* loaded from: classes2.dex */
public abstract class SequencesKt__SequencesKt extends SequencesKt__SequenceBuilderKt {
    @NotNull
    public static <T> Sequence<T> asSequence(@NotNull final Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return constrainOnce(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return it;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Sequence<T> constrainOnce(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (!(sequence instanceof ConstrainedOnceSequence)) {
            return new ConstrainedOnceSequence(sequence);
        }
        return sequence;
    }

    @NotNull
    public static <T> Sequence<T> emptySequence() {
        return w80.f28097a;
    }

    @NotNull
    public static final <T, C, R> Sequence<R> flatMapIndexed(@NotNull Sequence<? extends T> source, @NotNull Function2<? super Integer, ? super T, ? extends C> transform, @NotNull Function1<? super C, ? extends Iterator<? extends R>> iterator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return SequencesKt__SequenceBuilderKt.sequence(new eg2(source, transform, iterator, null));
    }

    @NotNull
    public static final <T> Sequence<T> flatten(@NotNull Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        boolean z = sequence instanceof TransformingSequence;
        C1223g8 c1223g8 = C1223g8.f17581j;
        if (z) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(c1223g8);
        }
        return new FlatteningSequence(sequence, C1223g8.f17583l, c1223g8);
    }

    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        boolean z = sequence instanceof TransformingSequence;
        C1223g8 c1223g8 = C1223g8.f17582k;
        if (z) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(c1223g8);
        }
        return new FlatteningSequence(sequence, C1223g8.f17583l, c1223g8);
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return constrainOnce(new qw0(nextFunction, new C1891v(12, nextFunction)));
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Sequence<T> ifEmpty(@NotNull Sequence<? extends T> sequence, @NotNull Function0<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence(new fg2(sequence, defaultValue, null));
    }

    @NotNull
    public static <T> Sequence<T> sequenceOf(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return emptySequence();
        }
        return ArraysKt___ArraysKt.asSequence(elements);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return shuffled(sequence, Random.INSTANCE);
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.m5575to(arrayList, arrayList2);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static <T> Sequence<T> generateSequence(@Nullable T t, @NotNull Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (t == null) {
            return w80.f28097a;
        }
        return new qw0(new C1829tb(13, t), nextFunction);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull Sequence<? extends T> sequence, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt__SequenceBuilderKt.sequence(new gg2(sequence, random, null));
    }

    @NotNull
    public static <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> seedFunction, @NotNull Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new qw0(seedFunction, nextFunction);
    }
}
