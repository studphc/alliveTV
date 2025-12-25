package p000;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.OpenEndRange;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class q82 {
    public static final void checkStepIsPositive(boolean z, @NotNull Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@NotNull T t, @NotNull T that) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new C1647or(t, that);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(@NotNull T t, @NotNull T that) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new C1595nr(t, that);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Double> rangeTo(double d, double d2) {
        return new C1732qp(d, d2);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final OpenEndRange<Double> rangeUntil(double d, double d2) {
        return new f12(d, d2);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Float> rangeTo(float f, float f2) {
        return new C1769rp(f, f2);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final OpenEndRange<Float> rangeUntil(float f, float f2) {
        return new g12(f, f2);
    }
}
