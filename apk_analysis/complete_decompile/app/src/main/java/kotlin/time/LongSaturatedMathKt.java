package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;

@Metadata(m5568d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\"\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0005\u001a\"\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5569d2 = {"", "longNs", "Lkotlin/time/Duration;", TypedValues.TransitionType.S_DURATION, "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAdd", "valueNs", "originNs", "saturatingDiff", "origin1Ns", "origin2Ns", "saturatingOriginsDiff", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,75:1\n74#1:76\n74#1:77\n74#1:78\n74#1:79\n74#1:80\n74#1:81\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n15#1:76\n18#1:77\n36#1:78\n45#1:79\n52#1:80\n56#1:81\n*E\n"})
/* loaded from: classes2.dex */
public final class LongSaturatedMathKt {
    /* renamed from: a */
    public static final long m5650a(long j, long j2) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            long j4 = 1000000;
            long j5 = (j / j4) - (j2 / j4);
            long j6 = (j % j4) - (j2 % j4);
            Duration.Companion companion = Duration.INSTANCE;
            return Duration.m8750plusLRDsOJo(DurationKt.toDuration(j5, DurationUnit.MILLISECONDS), DurationKt.toDuration(j6, DurationUnit.NANOSECONDS));
        }
        Duration.Companion companion2 = Duration.INSTANCE;
        return DurationKt.toDuration(j3, DurationUnit.NANOSECONDS);
    }

    /* renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m8818saturatingAddpTJri5U(long j, long j2) {
        long m8739getInWholeNanosecondsimpl = Duration.m8739getInWholeNanosecondsimpl(j2);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            if (Duration.m8746isInfiniteimpl(j2) && (j ^ m8739getInWholeNanosecondsimpl) < 0) {
                throw new IllegalArgumentException("Summing infinities of different signs");
            }
            return j;
        }
        if (((m8739getInWholeNanosecondsimpl - 1) | 1) == Long.MAX_VALUE) {
            long m8722divUwyO8pc = Duration.m8722divUwyO8pc(j2, 2);
            if ((1 | (Duration.m8739getInWholeNanosecondsimpl(m8722divUwyO8pc) - 1)) == Long.MAX_VALUE) {
                return (long) (Duration.m8757toDoubleimpl(j2, DurationUnit.NANOSECONDS) + j);
            }
            return m8818saturatingAddpTJri5U(m8818saturatingAddpTJri5U(j, m8722divUwyO8pc), Duration.m8749minusLRDsOJo(j2, m8722divUwyO8pc));
        }
        long j3 = j + m8739getInWholeNanosecondsimpl;
        if (((m8739getInWholeNanosecondsimpl ^ j3) & (j ^ j3)) < 0) {
            if (j >= 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
        return j3;
    }

    public static final long saturatingDiff(long j, long j2) {
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return Duration.m8766unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS));
        }
        return m5650a(j, j2);
    }

    public static final long saturatingOriginsDiff(long j, long j2) {
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return Duration.INSTANCE.m8795getZEROUwyO8pc();
            }
            return Duration.m8766unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS));
        }
        if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }
        return m5650a(j, j2);
    }
}
