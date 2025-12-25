package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: kq */
/* loaded from: classes2.dex */
public abstract class AbstractC1483kq extends AbstractC1363jq {
    @NotNull
    public static final <R> List<R> filterIsInstance(@NotNull Iterable<?> iterable, @NotNull Class<R> klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), klass);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Iterable<?> iterable, @NotNull C destination, @NotNull Class<R> klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m8911max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m8621maxOrNull((Iterable<Double>) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
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
        }
        return next;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object maxWith(Iterable iterable, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt___CollectionsKt.maxWithOrNull(iterable, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m8913min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m8625minOrNull((Iterable<Double>) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
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
        }
        return next;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object minWith(Iterable iterable, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt___CollectionsKt.minWithOrNull(iterable, comparator);
    }

    public static <T> void reverse(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.reverse(list);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet());
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m8912max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m8622maxOrNull((Iterable<Float>) iterable);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m8914min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m8626minOrNull((Iterable<Float>) iterable);
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet(comparator));
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.maxOrNull(iterable);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.minOrNull(iterable);
    }
}
