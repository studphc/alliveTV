package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bÁ\u0002\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0011\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0016"}, m5569d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "", "toString", "()Ljava/lang/String;", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "markNow", "timeMark", "Lkotlin/time/Duration;", "elapsedFrom-6eNON_k", "(J)J", "elapsedFrom", "one", "another", "differenceBetween-fRLX17w", "(JJ)J", "differenceBetween", TypedValues.TransitionType.S_DURATION, "adjustReading-6QKq23U", "adjustReading", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalTime
/* loaded from: classes2.dex */
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {

    @NotNull
    public static final MonotonicTimeSource INSTANCE = new Object();

    /* renamed from: a */
    public static final long f21377a = System.nanoTime();

    /* renamed from: adjustReading-6QKq23U, reason: not valid java name */
    public final long m8819adjustReading6QKq23U(long timeMark, long duration) {
        return TimeSource.Monotonic.ValueTimeMark.m8830constructorimpl(LongSaturatedMathKt.m8818saturatingAddpTJri5U(timeMark, duration));
    }

    /* renamed from: differenceBetween-fRLX17w, reason: not valid java name */
    public final long m8820differenceBetweenfRLX17w(long one, long another) {
        return LongSaturatedMathKt.saturatingOriginsDiff(one, another);
    }

    /* renamed from: elapsedFrom-6eNON_k, reason: not valid java name */
    public final long m8821elapsedFrom6eNON_k(long timeMark) {
        return LongSaturatedMathKt.saturatingDiff(System.nanoTime() - f21377a, timeMark);
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m8827boximpl(m8822markNowz9LOYto());
    }

    /* renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m8822markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m8830constructorimpl(System.nanoTime() - f21377a);
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m8827boximpl(m8822markNowz9LOYto());
    }
}
