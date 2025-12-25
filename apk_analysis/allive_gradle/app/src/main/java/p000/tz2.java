package p000;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongProgression;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class tz2 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m9304coerceAtLeast5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0) {
            return s2;
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m9305coerceAtLeastJ1ME1BU(int i, int i2) {
        if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) < 0) {
            return i2;
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m9306coerceAtLeastKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) < 0) {
            return b2;
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m9307coerceAtLeasteb3DHEI(long j, long j2) {
        if (Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) < 0) {
            return j2;
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m9308coerceAtMost5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0) {
            return s2;
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m9309coerceAtMostJ1ME1BU(int i, int i2) {
        if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) > 0) {
            return i2;
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m9310coerceAtMostKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) > 0) {
            return b2;
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m9311coerceAtMosteb3DHEI(long j, long j2) {
        if (Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) > 0) {
            return j2;
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m9312coerceInJPwROB0(long j, @NotNull ClosedRange<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) r82.coerceIn(ULong.m8569boximpl(j), (ClosedFloatingPointRange<ULong>) range)).getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
        }
        if (!range.isEmpty()) {
            long j2 = j ^ Long.MIN_VALUE;
            if (Long.compare(j2, range.getStart().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() ^ Long.MIN_VALUE) < 0) {
                return range.getStart().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            }
            if (Long.compare(j2, range.getEndInclusive().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() ^ Long.MIN_VALUE) > 0) {
                return range.getEndInclusive().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            }
            return j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m9313coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            if (Intrinsics.compare(i3, i) < 0) {
                return s2;
            }
            if (Intrinsics.compare(i3, i2) > 0) {
                return s3;
            }
            return s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UShort.m8598toStringimpl(s3)) + " is less than minimum " + ((Object) UShort.m8598toStringimpl(s2)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m9314coerceInWZ9TVnA(int i, int i2, int i3) {
        int i4 = i2 ^ Integer.MIN_VALUE;
        int i5 = i3 ^ Integer.MIN_VALUE;
        if (Integer.compare(i4, i5) <= 0) {
            int i6 = Integer.MIN_VALUE ^ i;
            if (Integer.compare(i6, i4) < 0) {
                return i2;
            }
            if (Integer.compare(i6, i5) > 0) {
                return i3;
            }
            return i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UInt.m8550toStringimpl(i3)) + " is less than minimum " + ((Object) UInt.m8550toStringimpl(i2)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m9315coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & 255;
            if (Intrinsics.compare(i3, i) < 0) {
                return b2;
            }
            if (Intrinsics.compare(i3, i2) > 0) {
                return b3;
            }
            return b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UByte.m8526toStringimpl(b3)) + " is less than minimum " + ((Object) UByte.m8526toStringimpl(b2)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m9316coerceInsambcqE(long j, long j2, long j3) {
        long j4 = j2 ^ Long.MIN_VALUE;
        long j5 = j3 ^ Long.MIN_VALUE;
        if (Long.compare(j4, j5) <= 0) {
            long j6 = Long.MIN_VALUE ^ j;
            if (Long.compare(j6, j4) < 0) {
                return j2;
            }
            if (Long.compare(j6, j5) > 0) {
                return j3;
            }
            return j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) ULong.m8574toStringimpl(j3)) + " is less than minimum " + ((Object) ULong.m8574toStringimpl(j2)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m9317coerceInwuiCnnA(int i, @NotNull ClosedRange<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) r82.coerceIn(UInt.m8545boximpl(i), (ClosedFloatingPointRange<UInt>) range)).getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
        }
        if (!range.isEmpty()) {
            int i2 = i ^ Integer.MIN_VALUE;
            if (Integer.compare(i2, range.getStart().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() ^ Integer.MIN_VALUE) < 0) {
                return range.getStart().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            }
            if (Integer.compare(i2, range.getEndInclusive().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() ^ Integer.MIN_VALUE) > 0) {
                return range.getEndInclusive().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            }
            return i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m9318contains68kG9v0(@NotNull UIntRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m8692containsWZ4Q5Ns(UInt.m8546constructorimpl(b & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m9319containsGab390E(@NotNull ULongRange contains, int i) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m8700containsVKZWuLQ(ULong.m8570constructorimpl(i & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m9320containsULbyJY(@NotNull ULongRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m8700containsVKZWuLQ(ULong.m8570constructorimpl(b & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m9321containsZsK3CEQ(@NotNull UIntRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m8692containsWZ4Q5Ns(UInt.m8546constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m9322containsfz5IDCE(@NotNull UIntRange contains, long j) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (ULong.m8570constructorimpl(j >>> 32) == 0 && contains.m8692containsWZ4Q5Ns(UInt.m8546constructorimpl((int) j))) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m9323containsuhHAxoY(@NotNull ULongRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m8700containsVKZWuLQ(ULong.m8570constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m9324downTo5PvTz6A(short s, short s2) {
        return UIntProgression.INSTANCE.m8690fromClosedRangeNkh28Cs(UInt.m8546constructorimpl(s & UShort.MAX_VALUE), UInt.m8546constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m9325downToJ1ME1BU(int i, int i2) {
        return UIntProgression.INSTANCE.m8690fromClosedRangeNkh28Cs(i, i2, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m9326downToKr8caGY(byte b, byte b2) {
        return UIntProgression.INSTANCE.m8690fromClosedRangeNkh28Cs(UInt.m8546constructorimpl(b & 255), UInt.m8546constructorimpl(b2 & 255), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m9327downToeb3DHEI(long j, long j2) {
        return ULongProgression.INSTANCE.m8698fromClosedRange7ftBX0g(j, j2, -1L);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt firstOrNull(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m8545boximpl(uIntProgression.getFirst());
    }

    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt lastOrNull(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m8545boximpl(uIntProgression.getLast());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int random(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UInt randomOrNull(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m8545boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final UIntProgression reversed(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.INSTANCE.m8690fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final UIntProgression step(@NotNull UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        q82.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m8690fromClosedRangeNkh28Cs(first, last, i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m9328until5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s2 & UShort.MAX_VALUE, 0) <= 0) {
            return UIntRange.INSTANCE.getEMPTY();
        }
        return new UIntRange(UInt.m8546constructorimpl(s & UShort.MAX_VALUE), UInt.m8546constructorimpl(UInt.m8546constructorimpl(r3) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-J1ME1BU, reason: not valid java name */
    public static final UIntRange m9329untilJ1ME1BU(int i, int i2) {
        if (Integer.compare(i2 ^ Integer.MIN_VALUE, Integer.MIN_VALUE) <= 0) {
            return UIntRange.INSTANCE.getEMPTY();
        }
        return new UIntRange(i, UInt.m8546constructorimpl(i2 - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m9330untilKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b2 & 255, 0) <= 0) {
            return UIntRange.INSTANCE.getEMPTY();
        }
        return new UIntRange(UInt.m8546constructorimpl(b & 255), UInt.m8546constructorimpl(UInt.m8546constructorimpl(r3) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-eb3DHEI, reason: not valid java name */
    public static final ULongRange m9331untileb3DHEI(long j, long j2) {
        if (Long.compare(j2 ^ Long.MIN_VALUE, Long.MIN_VALUE) <= 0) {
            return ULongRange.INSTANCE.getEMPTY();
        }
        return new ULongRange(j, ULong.m8570constructorimpl(j2 - ULong.m8570constructorimpl(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong firstOrNull(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m8569boximpl(uLongProgression.getFirst());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong lastOrNull(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m8569boximpl(uLongProgression.getLast());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final ULongProgression reversed(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.INSTANCE.m8698fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long random(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final ULong randomOrNull(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m8569boximpl(URandomKt.nextULong(random, uLongRange));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final ULongProgression step(@NotNull ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        q82.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m8698fromClosedRange7ftBX0g(first, last, j);
    }

    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }
}
