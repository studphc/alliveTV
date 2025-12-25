package p000;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class qz2 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m9288maxOf5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0) {
            return s2;
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m9289maxOfJ1ME1BU(int i, int i2) {
        if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) < 0) {
            return i2;
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m9290maxOfKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) < 0) {
            return b2;
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m9291maxOfMd2H83M(int i, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8560getSizeimpl = UIntArray.m8560getSizeimpl(other);
        for (int i2 = 0; i2 < m8560getSizeimpl; i2++) {
            i = m9289maxOfJ1ME1BU(i, UIntArray.m8559getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m9292maxOfR03FKyM(long j, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8584getSizeimpl = ULongArray.m8584getSizeimpl(other);
        for (int i = 0; i < m8584getSizeimpl; i++) {
            j = m9294maxOfeb3DHEI(j, ULongArray.m8583getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m9293maxOfWr6uiD8(byte b, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8536getSizeimpl = UByteArray.m8536getSizeimpl(other);
        for (int i = 0; i < m8536getSizeimpl; i++) {
            b = m9290maxOfKr8caGY(b, UByteArray.m8535getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m9294maxOfeb3DHEI(long j, long j2) {
        if (Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) < 0) {
            return j2;
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m9295maxOft1qELG4(short s, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8608getSizeimpl = UShortArray.m8608getSizeimpl(other);
        for (int i = 0; i < m8608getSizeimpl; i++) {
            s = m9288maxOf5PvTz6A(s, UShortArray.m8607getMh2AYeg(other, i));
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m9296minOf5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0) {
            return s2;
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m9297minOfJ1ME1BU(int i, int i2) {
        if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) > 0) {
            return i2;
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m9298minOfKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) > 0) {
            return b2;
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m9299minOfMd2H83M(int i, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8560getSizeimpl = UIntArray.m8560getSizeimpl(other);
        for (int i2 = 0; i2 < m8560getSizeimpl; i2++) {
            i = m9297minOfJ1ME1BU(i, UIntArray.m8559getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m9300minOfR03FKyM(long j, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8584getSizeimpl = ULongArray.m8584getSizeimpl(other);
        for (int i = 0; i < m8584getSizeimpl; i++) {
            j = m9302minOfeb3DHEI(j, ULongArray.m8583getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m9301minOfWr6uiD8(byte b, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8536getSizeimpl = UByteArray.m8536getSizeimpl(other);
        for (int i = 0; i < m8536getSizeimpl; i++) {
            b = m9298minOfKr8caGY(b, UByteArray.m8535getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m9302minOfeb3DHEI(long j, long j2) {
        if (Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) > 0) {
            return j2;
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m9303minOft1qELG4(short s, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m8608getSizeimpl = UShortArray.m8608getSizeimpl(other);
        for (int i = 0; i < m8608getSizeimpl; i++) {
            s = m9296minOf5PvTz6A(s, UShortArray.m8607getMh2AYeg(other, i));
        }
        return s;
    }
}
