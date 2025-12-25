package p000;

import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnit;
import kotlin.time.DurationUnitKt__DurationUnitJvmKt$WhenMappings;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class f70 {
    @SinceKotlin(version = "1.3")
    public static final double convertDurationUnit(double d, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit().convert(1L, sourceUnit.getTimeUnit());
        return convert > 0 ? d * convert : d / sourceUnit.getTimeUnit().convert(1L, targetUnit.getTimeUnit());
    }

    @SinceKotlin(version = "1.5")
    public static final long convertDurationUnitOverflow(long j, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j, sourceUnit.getTimeUnit());
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static final DurationUnit toDurationUnit(@NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "<this>");
        switch (DurationUnitKt__DurationUnitJvmKt$WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static final TimeUnit toTimeUnit(@NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "<this>");
        return durationUnit.getTimeUnit();
    }

    @SinceKotlin(version = "1.5")
    public static final long convertDurationUnit(long j, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j, sourceUnit.getTimeUnit());
    }
}
