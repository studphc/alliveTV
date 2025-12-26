package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, m5569d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalTime
/* loaded from: classes2.dex */
public interface TimeSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f21379a;

    @Metadata(m5568d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m5569d2 = {"Lkotlin/time/TimeSource$Companion;", "", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* renamed from: a */
        public static final /* synthetic */ Companion f21379a = new Object();
    }

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tJ\u0015\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\n"}, m5569d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "markNow", "", "toString", "()Ljava/lang/String;", "ValueTimeMark", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Monotonic implements WithComparableMarks {

        @NotNull
        public static final Monotonic INSTANCE = new Object();

        @SinceKotlin(version = "1.7")
        @Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ\u001b\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010!\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010$\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010(\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'\u0088\u0001\u0004\u0092\u0001\u00060\u0002j\u0002`\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006)"}, m5569d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "", "Lkotlin/time/ValueTimeMarkReading;", "reading", "constructor-impl", "(J)J", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "elapsedNow", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(JJ)J", "plus", "minus-LRDsOJo", "minus", "", "hasPassedNow-impl", "(J)Z", "hasPassedNow", "hasNotPassedNow-impl", "hasNotPassedNow", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "", "compareTo-6eNON_k", "(JJ)I", "compareTo", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "hashCode-impl", "(J)I", "hashCode", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
        @JvmInline
        @ExperimentalTime
        /* loaded from: classes2.dex */
        public static final class ValueTimeMark implements ComparableTimeMark {

            /* renamed from: a */
            public final long f21380a;

            public /* synthetic */ ValueTimeMark(long j) {
                this.f21380a = j;
            }

            /* renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m8827boximpl(long j) {
                return new ValueTimeMark(j);
            }

            /* renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m8828compareTo6eNON_k(long j, long j2) {
                return Duration.m8718compareToLRDsOJo(m8837minus6eNON_k(j, j2), Duration.INSTANCE.m8795getZEROUwyO8pc());
            }

            /* renamed from: compareTo-impl, reason: not valid java name */
            public static int m8829compareToimpl(long j, @NotNull ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m8827boximpl(j).compareTo(other);
            }

            /* renamed from: constructor-impl, reason: not valid java name */
            public static long m8830constructorimpl(long j) {
                return j;
            }

            /* renamed from: equals-impl, reason: not valid java name */
            public static boolean m8832equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).getF21380a();
            }

            /* renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m8833equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m8834hasNotPassedNowimpl(long j) {
                return Duration.m8747isNegativeimpl(m8831elapsedNowUwyO8pc(j));
            }

            /* renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m8835hasPassedNowimpl(long j) {
                return !Duration.m8747isNegativeimpl(m8831elapsedNowUwyO8pc(j));
            }

            /* renamed from: hashCode-impl, reason: not valid java name */
            public static int m8836hashCodeimpl(long j) {
                return (int) (j ^ (j >>> 32));
            }

            /* renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m8837minus6eNON_k(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m8820differenceBetweenfRLX17w(j, j2);
            }

            /* renamed from: toString-impl, reason: not valid java name */
            public static String m8841toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo8481elapsedNowUwyO8pc() {
                return m8831elapsedNowUwyO8pc(this.f21380a);
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object obj) {
                return m8832equalsimpl(this.f21380a, obj);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m8834hasNotPassedNowimpl(this.f21380a);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m8835hasPassedNowimpl(this.f21380a);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m8836hashCodeimpl(this.f21380a);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo8482minusLRDsOJo(long j) {
                return m8827boximpl(m8842minusLRDsOJo(j));
            }

            @Override // kotlin.time.ComparableTimeMark
            /* renamed from: minus-UwyO8pc */
            public long mo8483minusUwyO8pc(@NotNull ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m8839minusUwyO8pc(this.f21380a, other);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo8484plusLRDsOJo(long j) {
                return m8827boximpl(m8843plusLRDsOJo(j));
            }

            public String toString() {
                return m8841toStringimpl(this.f21380a);
            }

            /* renamed from: unbox-impl, reason: not valid java name and from getter */
            public final /* synthetic */ long getF21380a() {
                return this.f21380a;
            }

            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m8831elapsedNowUwyO8pc(long j) {
                return MonotonicTimeSource.INSTANCE.m8821elapsedFrom6eNON_k(j);
            }

            /* renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m8839minusUwyO8pc(long j, @NotNull ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (other instanceof ValueTimeMark) {
                    return m8837minus6eNON_k(j, ((ValueTimeMark) other).getF21380a());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m8841toStringimpl(j)) + " and " + other);
            }

            @Override // java.lang.Comparable
            public int compareTo(@NotNull ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo8482minusLRDsOJo(long j) {
                return m8827boximpl(m8842minusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo8484plusLRDsOJo(long j) {
                return m8827boximpl(m8843plusLRDsOJo(j));
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m8842minusLRDsOJo(long j) {
                return m8838minusLRDsOJo(this.f21380a, j);
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m8843plusLRDsOJo(long j) {
                return m8840plusLRDsOJo(this.f21380a, j);
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m8838minusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m8819adjustReading6QKq23U(j, Duration.m8766unaryMinusUwyO8pc(j2));
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m8840plusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m8819adjustReading6QKq23U(j, j2);
            }
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m8827boximpl(m8826markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m8826markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m8822markNowz9LOYto();
        }

        @NotNull
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m8827boximpl(m8826markNowz9LOYto());
        }
    }

    @SinceKotlin(version = "1.8")
    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m5569d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @ExperimentalTime
    /* loaded from: classes2.dex */
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        @NotNull
        ComparableTimeMark markNow();
    }

    @NotNull
    TimeMark markNow();
}
