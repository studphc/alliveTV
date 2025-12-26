package p000;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: vr */
/* loaded from: classes2.dex */
public abstract class AbstractC1919vr {
    @NotNull
    public static final <T> Comparator<T> compareBy(@NotNull Function1<? super T, ? extends Comparable<?>>... selectors) {
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            return new C1882ur(0, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static <T extends Comparable<?>> int compareValues(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static <T> int compareValuesBy(T t, T t2, @NotNull Function1<? super T, ? extends Comparable<?>>... selectors) {
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            for (Function1<? super T, ? extends Comparable<?>> function1 : selectors) {
                int compareValues = compareValues(function1.invoke(t), function1.invoke(t2));
                if (compareValues != 0) {
                    return compareValues;
                }
            }
            return 0;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        hr1 hr1Var = hr1.f18151b;
        Intrinsics.checkNotNull(hr1Var, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return hr1Var;
    }

    @NotNull
    public static final <T> Comparator<T> nullsFirst(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new C1808sr(comparator, 1);
    }

    @NotNull
    public static final <T> Comparator<T> nullsLast(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new C1808sr(comparator, 0);
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        hr1 hr1Var = hr1.f18152c;
        Intrinsics.checkNotNull(hr1Var, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return hr1Var;
    }

    @NotNull
    public static final <T> Comparator<T> reversed(@NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        if (comparator instanceof oc2) {
            return ((oc2) comparator).f23765a;
        }
        Comparator<T> comparator2 = hr1.f18151b;
        boolean areEqual = Intrinsics.areEqual(comparator, comparator2);
        hr1 hr1Var = hr1.f18152c;
        if (areEqual) {
            Intrinsics.checkNotNull(hr1Var, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return hr1Var;
        }
        if (Intrinsics.areEqual(comparator, hr1Var)) {
            Intrinsics.checkNotNull(comparator2, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            comparator2 = new oc2(comparator);
        }
        return comparator2;
    }

    @NotNull
    public static final <T> Comparator<T> then(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new C1845tr(comparator, comparator2, 1);
    }

    @NotNull
    public static final <T> Comparator<T> thenDescending(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new C1845tr(comparator, comparator2, 0);
    }
}
