package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.UArraySortingKt;
import kotlin.collections.unsigned.UArraysKt___UArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class oz2 extends UArraysKt___UArraysJvmKt {
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m9080contentEqualsFGO6Aew(@Nullable short[] sArr, @Nullable short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m9081contentEqualsKJPZfPQ(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-ctEhBpI, reason: not valid java name */
    public static final /* synthetic */ boolean m9082contentEqualsctEhBpI(int[] contentEquals, int[] other) {
        Intrinsics.checkNotNullParameter(contentEquals, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        return m9081contentEqualsKJPZfPQ(contentEquals, other);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m9083contentEqualskV0jMPg(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-kdPth3s, reason: not valid java name */
    public static final /* synthetic */ boolean m9084contentEqualskdPth3s(byte[] contentEquals, byte[] other) {
        Intrinsics.checkNotNullParameter(contentEquals, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        return m9083contentEqualskV0jMPg(contentEquals, other);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m9085contentEqualslec5QzE(@Nullable long[] jArr, @Nullable long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-mazbYpA, reason: not valid java name */
    public static final /* synthetic */ boolean m9086contentEqualsmazbYpA(short[] contentEquals, short[] other) {
        Intrinsics.checkNotNullParameter(contentEquals, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        return m9080contentEqualsFGO6Aew(contentEquals, other);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-us8wMrg, reason: not valid java name */
    public static final /* synthetic */ boolean m9087contentEqualsus8wMrg(long[] contentEquals, long[] other) {
        Intrinsics.checkNotNullParameter(contentEquals, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        return m9085contentEqualslec5QzE(contentEquals, other);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentHashCode--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ int m9088contentHashCodeajY9A(int[] contentHashCode) {
        Intrinsics.checkNotNullParameter(contentHashCode, "$this$contentHashCode");
        return m9092contentHashCodeXUkPCBk(contentHashCode);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m9089contentHashCode2csIQuQ(@Nullable byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentHashCode-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ int m9090contentHashCodeGBYM_sE(byte[] contentHashCode) {
        Intrinsics.checkNotNullParameter(contentHashCode, "$this$contentHashCode");
        return m9089contentHashCode2csIQuQ(contentHashCode);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentHashCode-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ int m9091contentHashCodeQwZRm1k(long[] contentHashCode) {
        Intrinsics.checkNotNullParameter(contentHashCode, "$this$contentHashCode");
        return m9095contentHashCodeuLth9ew(contentHashCode);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m9092contentHashCodeXUkPCBk(@Nullable int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m9093contentHashCoded6D3K8(@Nullable short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentHashCode-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ int m9094contentHashCoderL5Bavg(short[] contentHashCode) {
        Intrinsics.checkNotNullParameter(contentHashCode, "$this$contentHashCode");
        return m9093contentHashCoded6D3K8(contentHashCode);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m9095contentHashCodeuLth9ew(@Nullable long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentToString--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ String m9096contentToStringajY9A(int[] contentToString) {
        Intrinsics.checkNotNullParameter(contentToString, "$this$contentToString");
        return m9100contentToStringXUkPCBk(contentToString);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m9097contentToString2csIQuQ(@Nullable byte[] bArr) {
        String joinToString$default;
        if (bArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UByteArray.m8528boximpl(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentToString-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ String m9098contentToStringGBYM_sE(byte[] contentToString) {
        Intrinsics.checkNotNullParameter(contentToString, "$this$contentToString");
        return m9097contentToString2csIQuQ(contentToString);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentToString-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ String m9099contentToStringQwZRm1k(long[] contentToString) {
        Intrinsics.checkNotNullParameter(contentToString, "$this$contentToString");
        return m9103contentToStringuLth9ew(contentToString);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m9100contentToStringXUkPCBk(@Nullable int[] iArr) {
        String joinToString$default;
        if (iArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UIntArray.m8552boximpl(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m9101contentToStringd6D3K8(@Nullable short[] sArr) {
        String joinToString$default;
        if (sArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UShortArray.m8600boximpl(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentToString-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ String m9102contentToStringrL5Bavg(short[] contentToString) {
        Intrinsics.checkNotNullParameter(contentToString, "$this$contentToString");
        return m9101contentToStringd6D3K8(contentToString);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m9103contentToStringuLth9ew(@Nullable long[] jArr) {
        String joinToString$default;
        if (jArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(ULongArray.m8576boximpl(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<UByte> m9104dropPpDY95g(@NotNull byte[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i >= 0) {
            return m9264takeLastPpDY95g(drop, r82.coerceAtLeast(UByteArray.m8536getSizeimpl(drop) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<UShort> m9105dropnggk6HY(@NotNull short[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i >= 0) {
            return m9265takeLastnggk6HY(drop, r82.coerceAtLeast(UShortArray.m8608getSizeimpl(drop) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m9106dropqFRl0hI(@NotNull int[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i >= 0) {
            return m9266takeLastqFRl0hI(drop, r82.coerceAtLeast(UIntArray.m8560getSizeimpl(drop) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<ULong> m9107dropr7IrZao(@NotNull long[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i >= 0) {
            return m9267takeLastr7IrZao(drop, r82.coerceAtLeast(ULongArray.m8584getSizeimpl(drop) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m9108dropLastPpDY95g(@NotNull byte[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i >= 0) {
            return m9260takePpDY95g(dropLast, r82.coerceAtLeast(UByteArray.m8536getSizeimpl(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m9109dropLastnggk6HY(@NotNull short[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i >= 0) {
            return m9261takenggk6HY(dropLast, r82.coerceAtLeast(UShortArray.m8608getSizeimpl(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m9110dropLastqFRl0hI(@NotNull int[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i >= 0) {
            return m9262takeqFRl0hI(dropLast, r82.coerceAtLeast(UIntArray.m8560getSizeimpl(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m9111dropLastr7IrZao(@NotNull long[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i >= 0) {
            return m9263taker7IrZao(dropLast, r82.coerceAtLeast(ULongArray.m8584getSizeimpl(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m9112fill2fe2U9s(@NotNull int[] fill, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, i, i2, i3);
    }

    /* renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m9113fill2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m8560getSizeimpl(iArr);
        }
        m9112fill2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m9114fillEtDCXyQ(@NotNull short[] fill, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, s, i, i2);
    }

    /* renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m9115fillEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m8608getSizeimpl(sArr);
        }
        m9114fillEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m9116fillK6DWlUc(@NotNull long[] fill, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, j, i, i2);
    }

    /* renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m9117fillK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m8584getSizeimpl(jArr);
        }
        m9116fillK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m9118fillWpHrYlw(@NotNull byte[] fill, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(fill, b, i, i2);
    }

    /* renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m9119fillWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m8536getSizeimpl(bArr);
        }
        m9118fillWpHrYlw(bArr, b, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m9120firstOrNullajY9A(@NotNull int[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UIntArray.m8562isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m9121firstOrNullGBYM_sE(@NotNull byte[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UByteArray.m8538isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m9122firstOrNullQwZRm1k(@NotNull long[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (ULongArray.m8586isEmptyimpl(firstOrNull)) {
            return null;
        }
        return ULong.m8569boximpl(ULongArray.m8583getsVKNKU(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m9123firstOrNullrL5Bavg(@NotNull short[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UShortArray.m8610isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(firstOrNull, 0));
    }

    @NotNull
    /* renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final IntRange m9124getIndicesajY9A(@NotNull int[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    @NotNull
    /* renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final IntRange m9126getIndicesGBYM_sE(@NotNull byte[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    @NotNull
    /* renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final IntRange m9128getIndicesQwZRm1k(@NotNull long[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    @NotNull
    /* renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final IntRange m9130getIndicesrL5Bavg(@NotNull short[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(indices);
    }

    /* renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m9132getLastIndexajY9A(@NotNull int[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m9134getLastIndexGBYM_sE(@NotNull byte[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m9136getLastIndexQwZRm1k(@NotNull long[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    /* renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m9138getLastIndexrL5Bavg(@NotNull short[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final UByte m9140getOrNullPpDY95g(@NotNull byte[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.getLastIndex(getOrNull)) {
            return UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(getOrNull, i));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final UShort m9141getOrNullnggk6HY(@NotNull short[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.getLastIndex(getOrNull)) {
            return UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(getOrNull, i));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final UInt m9142getOrNullqFRl0hI(@NotNull int[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.getLastIndex(getOrNull)) {
            return UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(getOrNull, i));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final ULong m9143getOrNullr7IrZao(@NotNull long[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.getLastIndex(getOrNull)) {
            return ULong.m8569boximpl(ULongArray.m8583getsVKNKU(getOrNull, i));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m9144lastOrNullajY9A(@NotNull int[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UIntArray.m8562isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(lastOrNull, UIntArray.m8560getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m9145lastOrNullGBYM_sE(@NotNull byte[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UByteArray.m8538isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(lastOrNull, UByteArray.m8536getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m9146lastOrNullQwZRm1k(@NotNull long[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (ULongArray.m8586isEmptyimpl(lastOrNull)) {
            return null;
        }
        return ULong.m8569boximpl(ULongArray.m8583getsVKNKU(lastOrNull, ULongArray.m8584getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m9147lastOrNullrL5Bavg(@NotNull short[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UShortArray.m8610isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(lastOrNull, UShortArray.m8608getSizeimpl(lastOrNull) - 1));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m9148maxOrNullajY9A(@NotNull int[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UIntArray.m8562isEmptyimpl(maxOrNull)) {
            return null;
        }
        int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(maxOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxOrNull)).iterator();
        while (it.hasNext()) {
            int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(maxOrNull, it.nextInt());
            if (Integer.compare(m8559getpVg5ArA ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ m8559getpVg5ArA2) < 0) {
                m8559getpVg5ArA = m8559getpVg5ArA2;
            }
        }
        return UInt.m8545boximpl(m8559getpVg5ArA);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m9149maxOrNullGBYM_sE(@NotNull byte[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UByteArray.m8538isEmptyimpl(maxOrNull)) {
            return null;
        }
        byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(maxOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxOrNull)).iterator();
        while (it.hasNext()) {
            byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(maxOrNull, it.nextInt());
            if (Intrinsics.compare(m8535getw2LRezQ & 255, m8535getw2LRezQ2 & 255) < 0) {
                m8535getw2LRezQ = m8535getw2LRezQ2;
            }
        }
        return UByte.m8521boximpl(m8535getw2LRezQ);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m9150maxOrNullQwZRm1k(@NotNull long[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (ULongArray.m8586isEmptyimpl(maxOrNull)) {
            return null;
        }
        long m8583getsVKNKU = ULongArray.m8583getsVKNKU(maxOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxOrNull)).iterator();
        while (it.hasNext()) {
            long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(maxOrNull, it.nextInt());
            if (Long.compare(m8583getsVKNKU ^ Long.MIN_VALUE, Long.MIN_VALUE ^ m8583getsVKNKU2) < 0) {
                m8583getsVKNKU = m8583getsVKNKU2;
            }
        }
        return ULong.m8569boximpl(m8583getsVKNKU);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m9151maxOrNullrL5Bavg(@NotNull short[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UShortArray.m8610isEmptyimpl(maxOrNull)) {
            return null;
        }
        short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(maxOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxOrNull)).iterator();
        while (it.hasNext()) {
            short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(maxOrNull, it.nextInt());
            if (Intrinsics.compare(m8607getMh2AYeg & UShort.MAX_VALUE, 65535 & m8607getMh2AYeg2) < 0) {
                m8607getMh2AYeg = m8607getMh2AYeg2;
            }
        }
        return UShort.m8593boximpl(m8607getMh2AYeg);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m9153maxOrThrowU(@NotNull int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (!UIntArray.m8562isEmptyimpl(max)) {
            int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(max, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(max)).iterator();
            while (it.hasNext()) {
                int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(max, it.nextInt());
                if (Integer.compare(m8559getpVg5ArA ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ m8559getpVg5ArA2) < 0) {
                    m8559getpVg5ArA = m8559getpVg5ArA2;
                }
            }
            return m8559getpVg5ArA;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m9156maxWithOrNullXMRcp5o(@NotNull byte[] maxWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m8538isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(maxWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(maxWithOrNull, it.nextInt());
            if (comparator.compare(UByte.m8521boximpl(m8535getw2LRezQ), UByte.m8521boximpl(m8535getw2LRezQ2)) < 0) {
                m8535getw2LRezQ = m8535getw2LRezQ2;
            }
        }
        return UByte.m8521boximpl(m8535getw2LRezQ);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m9157maxWithOrNullYmdZ_VM(@NotNull int[] maxWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m8562isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(maxWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(maxWithOrNull, it.nextInt());
            if (comparator.compare(UInt.m8545boximpl(m8559getpVg5ArA), UInt.m8545boximpl(m8559getpVg5ArA2)) < 0) {
                m8559getpVg5ArA = m8559getpVg5ArA2;
            }
        }
        return UInt.m8545boximpl(m8559getpVg5ArA);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m9158maxWithOrNulleOHTfZs(@NotNull short[] maxWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m8610isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(maxWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(maxWithOrNull, it.nextInt());
            if (comparator.compare(UShort.m8593boximpl(m8607getMh2AYeg), UShort.m8593boximpl(m8607getMh2AYeg2)) < 0) {
                m8607getMh2AYeg = m8607getMh2AYeg2;
            }
        }
        return UShort.m8593boximpl(m8607getMh2AYeg);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m9159maxWithOrNullzrEWJaI(@NotNull long[] maxWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m8586isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        long m8583getsVKNKU = ULongArray.m8583getsVKNKU(maxWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(maxWithOrNull, it.nextInt());
            if (comparator.compare(ULong.m8569boximpl(m8583getsVKNKU), ULong.m8569boximpl(m8583getsVKNKU2)) < 0) {
                m8583getsVKNKU = m8583getsVKNKU2;
            }
        }
        return ULong.m8569boximpl(m8583getsVKNKU);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m9161maxWithOrThrowU(@NotNull int[] maxWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UIntArray.m8562isEmptyimpl(maxWith)) {
            int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(maxWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWith)).iterator();
            while (it.hasNext()) {
                int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(maxWith, it.nextInt());
                if (comparator.compare(UInt.m8545boximpl(m8559getpVg5ArA), UInt.m8545boximpl(m8559getpVg5ArA2)) < 0) {
                    m8559getpVg5ArA = m8559getpVg5ArA2;
                }
            }
            return m8559getpVg5ArA;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m9164minOrNullajY9A(@NotNull int[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UIntArray.m8562isEmptyimpl(minOrNull)) {
            return null;
        }
        int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(minOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minOrNull)).iterator();
        while (it.hasNext()) {
            int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(minOrNull, it.nextInt());
            if (Integer.compare(m8559getpVg5ArA ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ m8559getpVg5ArA2) > 0) {
                m8559getpVg5ArA = m8559getpVg5ArA2;
            }
        }
        return UInt.m8545boximpl(m8559getpVg5ArA);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m9165minOrNullGBYM_sE(@NotNull byte[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UByteArray.m8538isEmptyimpl(minOrNull)) {
            return null;
        }
        byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(minOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minOrNull)).iterator();
        while (it.hasNext()) {
            byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(minOrNull, it.nextInt());
            if (Intrinsics.compare(m8535getw2LRezQ & 255, m8535getw2LRezQ2 & 255) > 0) {
                m8535getw2LRezQ = m8535getw2LRezQ2;
            }
        }
        return UByte.m8521boximpl(m8535getw2LRezQ);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m9166minOrNullQwZRm1k(@NotNull long[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (ULongArray.m8586isEmptyimpl(minOrNull)) {
            return null;
        }
        long m8583getsVKNKU = ULongArray.m8583getsVKNKU(minOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minOrNull)).iterator();
        while (it.hasNext()) {
            long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(minOrNull, it.nextInt());
            if (Long.compare(m8583getsVKNKU ^ Long.MIN_VALUE, Long.MIN_VALUE ^ m8583getsVKNKU2) > 0) {
                m8583getsVKNKU = m8583getsVKNKU2;
            }
        }
        return ULong.m8569boximpl(m8583getsVKNKU);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m9167minOrNullrL5Bavg(@NotNull short[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UShortArray.m8610isEmptyimpl(minOrNull)) {
            return null;
        }
        short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(minOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minOrNull)).iterator();
        while (it.hasNext()) {
            short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(minOrNull, it.nextInt());
            if (Intrinsics.compare(m8607getMh2AYeg & UShort.MAX_VALUE, 65535 & m8607getMh2AYeg2) > 0) {
                m8607getMh2AYeg = m8607getMh2AYeg2;
            }
        }
        return UShort.m8593boximpl(m8607getMh2AYeg);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m9169minOrThrowU(@NotNull int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (!UIntArray.m8562isEmptyimpl(min)) {
            int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(min, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(min)).iterator();
            while (it.hasNext()) {
                int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(min, it.nextInt());
                if (Integer.compare(m8559getpVg5ArA ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ m8559getpVg5ArA2) > 0) {
                    m8559getpVg5ArA = m8559getpVg5ArA2;
                }
            }
            return m8559getpVg5ArA;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m9172minWithOrNullXMRcp5o(@NotNull byte[] minWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m8538isEmptyimpl(minWithOrNull)) {
            return null;
        }
        byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(minWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWithOrNull)).iterator();
        while (it.hasNext()) {
            byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(minWithOrNull, it.nextInt());
            if (comparator.compare(UByte.m8521boximpl(m8535getw2LRezQ), UByte.m8521boximpl(m8535getw2LRezQ2)) > 0) {
                m8535getw2LRezQ = m8535getw2LRezQ2;
            }
        }
        return UByte.m8521boximpl(m8535getw2LRezQ);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m9173minWithOrNullYmdZ_VM(@NotNull int[] minWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m8562isEmptyimpl(minWithOrNull)) {
            return null;
        }
        int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(minWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWithOrNull)).iterator();
        while (it.hasNext()) {
            int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(minWithOrNull, it.nextInt());
            if (comparator.compare(UInt.m8545boximpl(m8559getpVg5ArA), UInt.m8545boximpl(m8559getpVg5ArA2)) > 0) {
                m8559getpVg5ArA = m8559getpVg5ArA2;
            }
        }
        return UInt.m8545boximpl(m8559getpVg5ArA);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m9174minWithOrNulleOHTfZs(@NotNull short[] minWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m8610isEmptyimpl(minWithOrNull)) {
            return null;
        }
        short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(minWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWithOrNull)).iterator();
        while (it.hasNext()) {
            short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(minWithOrNull, it.nextInt());
            if (comparator.compare(UShort.m8593boximpl(m8607getMh2AYeg), UShort.m8593boximpl(m8607getMh2AYeg2)) > 0) {
                m8607getMh2AYeg = m8607getMh2AYeg2;
            }
        }
        return UShort.m8593boximpl(m8607getMh2AYeg);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m9175minWithOrNullzrEWJaI(@NotNull long[] minWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m8586isEmptyimpl(minWithOrNull)) {
            return null;
        }
        long m8583getsVKNKU = ULongArray.m8583getsVKNKU(minWithOrNull, 0);
        ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWithOrNull)).iterator();
        while (it.hasNext()) {
            long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(minWithOrNull, it.nextInt());
            if (comparator.compare(ULong.m8569boximpl(m8583getsVKNKU), ULong.m8569boximpl(m8583getsVKNKU2)) > 0) {
                m8583getsVKNKU = m8583getsVKNKU2;
            }
        }
        return ULong.m8569boximpl(m8583getsVKNKU);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m9177minWithOrThrowU(@NotNull int[] minWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UIntArray.m8562isEmptyimpl(minWith)) {
            int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(minWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWith)).iterator();
            while (it.hasNext()) {
                int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(minWith, it.nextInt());
                if (comparator.compare(UInt.m8545boximpl(m8559getpVg5ArA), UInt.m8545boximpl(m8559getpVg5ArA2)) > 0) {
                    m8559getpVg5ArA = m8559getpVg5ArA2;
                }
            }
            return m8559getpVg5ArA;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m9180plusCFIt9YE(@NotNull int[] plus, @NotNull Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int m8560getSizeimpl = UIntArray.m8560getSizeimpl(plus);
        int[] copyOf = Arrays.copyOf(plus, elements.size() + UIntArray.m8560getSizeimpl(plus));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Iterator<UInt> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[m8560getSizeimpl] = it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            m8560getSizeimpl++;
        }
        return UIntArray.m8554constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m9181pluskzHmqpY(@NotNull long[] plus, @NotNull Collection<ULong> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int m8584getSizeimpl = ULongArray.m8584getSizeimpl(plus);
        long[] copyOf = Arrays.copyOf(plus, elements.size() + ULongArray.m8584getSizeimpl(plus));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Iterator<ULong> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[m8584getSizeimpl] = it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            m8584getSizeimpl++;
        }
        return ULongArray.m8578constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m9182plusojwP5H8(@NotNull short[] plus, @NotNull Collection<UShort> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int m8608getSizeimpl = UShortArray.m8608getSizeimpl(plus);
        short[] copyOf = Arrays.copyOf(plus, elements.size() + UShortArray.m8608getSizeimpl(plus));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Iterator<UShort> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[m8608getSizeimpl] = it.next().getData();
            m8608getSizeimpl++;
        }
        return UShortArray.m8602constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m9183plusxo_DsdI(@NotNull byte[] plus, @NotNull Collection<UByte> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int m8536getSizeimpl = UByteArray.m8536getSizeimpl(plus);
        byte[] copyOf = Arrays.copyOf(plus, elements.size() + UByteArray.m8536getSizeimpl(plus));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Iterator<UByte> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[m8536getSizeimpl] = it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
            m8536getSizeimpl++;
        }
        return UByteArray.m8530constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m9184random2D5oskM(@NotNull int[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (!UIntArray.m8562isEmptyimpl(random)) {
            return UIntArray.m8559getpVg5ArA(random, random2.nextInt(UIntArray.m8560getSizeimpl(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m9185randomJzugnMA(@NotNull long[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (!ULongArray.m8586isEmptyimpl(random)) {
            return ULongArray.m8583getsVKNKU(random, random2.nextInt(ULongArray.m8584getSizeimpl(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m9186randomoSF2wD8(@NotNull byte[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (!UByteArray.m8538isEmptyimpl(random)) {
            return UByteArray.m8535getw2LRezQ(random, random2.nextInt(UByteArray.m8536getSizeimpl(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m9187randoms5X_as8(@NotNull short[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (!UShortArray.m8610isEmptyimpl(random)) {
            return UShortArray.m8607getMh2AYeg(random, random2.nextInt(UShortArray.m8608getSizeimpl(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final UInt m9188randomOrNull2D5oskM(@NotNull int[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.m8562isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(randomOrNull, random.nextInt(UIntArray.m8560getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final ULong m9189randomOrNullJzugnMA(@NotNull long[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.m8586isEmptyimpl(randomOrNull)) {
            return null;
        }
        return ULong.m8569boximpl(ULongArray.m8583getsVKNKU(randomOrNull, random.nextInt(ULongArray.m8584getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final UByte m9190randomOrNulloSF2wD8(@NotNull byte[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.m8538isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(randomOrNull, random.nextInt(UByteArray.m8536getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final UShort m9191randomOrNulls5X_as8(@NotNull short[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.m8610isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(randomOrNull, random.nextInt(UShortArray.m8608getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<UInt> m9192reversedajY9A(@NotNull int[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UIntArray.m8562isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UInt> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UIntArray.m8552boximpl(reversed));
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m9193reversedGBYM_sE(@NotNull byte[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UByteArray.m8538isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UByte> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UByteArray.m8528boximpl(reversed));
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m9194reversedQwZRm1k(@NotNull long[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (ULongArray.m8586isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<ULong> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ULongArray.m8576boximpl(reversed));
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m9195reversedrL5Bavg(@NotNull short[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UShortArray.m8610isEmptyimpl(reversed)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UShort> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UShortArray.m8600boximpl(reversed));
        AbstractC1483kq.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m9196shuffleajY9A(@NotNull int[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m9197shuffle2D5oskM(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m9197shuffle2D5oskM(@NotNull int[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(shuffle, lastIndex);
            UIntArray.m8564setVXSXFK8(shuffle, lastIndex, UIntArray.m8559getpVg5ArA(shuffle, nextInt));
            UIntArray.m8564setVXSXFK8(shuffle, nextInt, m8559getpVg5ArA);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m9198shuffleGBYM_sE(@NotNull byte[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m9201shuffleoSF2wD8(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m9199shuffleJzugnMA(@NotNull long[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            long m8583getsVKNKU = ULongArray.m8583getsVKNKU(shuffle, lastIndex);
            ULongArray.m8588setk8EXiF4(shuffle, lastIndex, ULongArray.m8583getsVKNKU(shuffle, nextInt));
            ULongArray.m8588setk8EXiF4(shuffle, nextInt, m8583getsVKNKU);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m9200shuffleQwZRm1k(@NotNull long[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m9199shuffleJzugnMA(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m9201shuffleoSF2wD8(@NotNull byte[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(shuffle, lastIndex);
            UByteArray.m8540setVurrAj0(shuffle, lastIndex, UByteArray.m8535getw2LRezQ(shuffle, nextInt));
            UByteArray.m8540setVurrAj0(shuffle, nextInt, m8535getw2LRezQ);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m9202shufflerL5Bavg(@NotNull short[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m9203shuffles5X_as8(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m9203shuffles5X_as8(@NotNull short[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(shuffle, lastIndex);
            UShortArray.m8612set01HTLdE(shuffle, lastIndex, UShortArray.m8607getMh2AYeg(shuffle, nextInt));
            UShortArray.m8612set01HTLdE(shuffle, nextInt, m8607getMh2AYeg);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m9204singleOrNullajY9A(@NotNull int[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UIntArray.m8560getSizeimpl(singleOrNull) == 1) {
            return UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m9205singleOrNullGBYM_sE(@NotNull byte[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UByteArray.m8536getSizeimpl(singleOrNull) == 1) {
            return UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m9206singleOrNullQwZRm1k(@NotNull long[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (ULongArray.m8584getSizeimpl(singleOrNull) == 1) {
            return ULong.m8569boximpl(ULongArray.m8583getsVKNKU(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m9207singleOrNullrL5Bavg(@NotNull short[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UShortArray.m8608getSizeimpl(singleOrNull) == 1) {
            return UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<ULong> m9208sliceF7u83W8(@NotNull long[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<UInt> m9209sliceHwE9HBo(@NotNull int[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<UShort> m9210sliceJGPC0M(@NotNull short[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<UByte> m9211sliceJQknh5Q(@NotNull byte[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = AbstractC1204fq.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<UShort> m9212sliceQ6IL4kU(@NotNull short[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m8636asListrL5Bavg(UShortArray.m8602constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<ULong> m9213sliceZRhS8yI(@NotNull long[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m8635asListQwZRm1k(ULongArray.m8578constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<UByte> m9214slicec0bezYM(@NotNull byte[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m8634asListGBYM_sE(UByteArray.m8530constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<UInt> m9215slicetAntMlw(@NotNull int[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m8633asListajY9A(UIntArray.m8554constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m9216sliceArrayCFIt9YE(@NotNull int[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m8554constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m9217sliceArrayQ6IL4kU(@NotNull short[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m8602constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m9218sliceArrayZRhS8yI(@NotNull long[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m8578constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m9219sliceArrayc0bezYM(@NotNull byte[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m8530constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m9220sliceArraykzHmqpY(@NotNull long[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m8578constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m9221sliceArrayojwP5H8(@NotNull short[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m8602constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m9222sliceArraytAntMlw(@NotNull int[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m8554constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m9223sliceArrayxo_DsdI(@NotNull byte[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m8530constructorimpl(ArraysKt___ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m9224sortajY9A(@NotNull int[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UIntArray.m8560getSizeimpl(sort) > 1) {
            UArraySortingKt.m8632sortArrayoBK06Vg(sort, 0, UIntArray.m8560getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m9225sortnroSd4(@NotNull long[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m8584getSizeimpl(sort));
        UArraySortingKt.m8629sortArraynroSd4(sort, i, i2);
    }

    /* renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m9226sortnroSd4$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = ULongArray.m8584getSizeimpl(jArr);
        }
        m9225sortnroSd4(jArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m9227sort4UcCI2c(@NotNull byte[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m8536getSizeimpl(sort));
        UArraySortingKt.m8630sortArray4UcCI2c(sort, i, i2);
    }

    /* renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m9228sort4UcCI2c$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m8536getSizeimpl(bArr);
        }
        m9227sort4UcCI2c(bArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m9229sortAa5vz7o(@NotNull short[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m8608getSizeimpl(sort));
        UArraySortingKt.m8631sortArrayAa5vz7o(sort, i, i2);
    }

    /* renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m9230sortAa5vz7o$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UShortArray.m8608getSizeimpl(sArr);
        }
        m9229sortAa5vz7o(sArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m9231sortGBYM_sE(@NotNull byte[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UByteArray.m8536getSizeimpl(sort) > 1) {
            UArraySortingKt.m8630sortArray4UcCI2c(sort, 0, UByteArray.m8536getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m9232sortQwZRm1k(@NotNull long[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (ULongArray.m8584getSizeimpl(sort) > 1) {
            UArraySortingKt.m8629sortArraynroSd4(sort, 0, ULongArray.m8584getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m9233sortoBK06Vg(@NotNull int[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UIntArray.m8560getSizeimpl(sort));
        UArraySortingKt.m8632sortArrayoBK06Vg(sort, i, i2);
    }

    /* renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m9234sortoBK06Vg$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UIntArray.m8560getSizeimpl(iArr);
        }
        m9233sortoBK06Vg(iArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m9235sortrL5Bavg(@NotNull short[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UShortArray.m8608getSizeimpl(sort) > 1) {
            UArraySortingKt.m8631sortArrayAa5vz7o(sort, 0, UShortArray.m8608getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m9236sortDescendingajY9A(@NotNull int[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UIntArray.m8560getSizeimpl(sortDescending) > 1) {
            m9224sortajY9A(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m9237sortDescendingnroSd4(@NotNull long[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m9225sortnroSd4(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m9238sortDescending4UcCI2c(@NotNull byte[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m9227sort4UcCI2c(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m9239sortDescendingAa5vz7o(@NotNull short[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m9229sortAa5vz7o(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m9240sortDescendingGBYM_sE(@NotNull byte[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UByteArray.m8536getSizeimpl(sortDescending) > 1) {
            m9231sortGBYM_sE(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m9241sortDescendingQwZRm1k(@NotNull long[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (ULongArray.m8584getSizeimpl(sortDescending) > 1) {
            m9232sortQwZRm1k(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m9242sortDescendingoBK06Vg(@NotNull int[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m9233sortoBK06Vg(sortDescending, i, i2);
        ArraysKt___ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m9243sortDescendingrL5Bavg(@NotNull short[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UShortArray.m8608getSizeimpl(sortDescending) > 1) {
            m9235sortrL5Bavg(sortDescending);
            ArraysKt___ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<UInt> m9244sortedajY9A(@NotNull int[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        int[] copyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int[] m8554constructorimpl = UIntArray.m8554constructorimpl(copyOf);
        m9224sortajY9A(m8554constructorimpl);
        return UArraysKt___UArraysJvmKt.m8633asListajY9A(m8554constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m9245sortedGBYM_sE(@NotNull byte[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        byte[] copyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        byte[] m8530constructorimpl = UByteArray.m8530constructorimpl(copyOf);
        m9231sortGBYM_sE(m8530constructorimpl);
        return UArraysKt___UArraysJvmKt.m8634asListGBYM_sE(m8530constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m9246sortedQwZRm1k(@NotNull long[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        long[] copyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        long[] m8578constructorimpl = ULongArray.m8578constructorimpl(copyOf);
        m9232sortQwZRm1k(m8578constructorimpl);
        return UArraysKt___UArraysJvmKt.m8635asListQwZRm1k(m8578constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m9247sortedrL5Bavg(@NotNull short[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        short[] copyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        short[] m8602constructorimpl = UShortArray.m8602constructorimpl(copyOf);
        m9235sortrL5Bavg(m8602constructorimpl);
        return UArraysKt___UArraysJvmKt.m8636asListrL5Bavg(m8602constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m9248sortedArrayajY9A(@NotNull int[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UIntArray.m8562isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        int[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int[] m8554constructorimpl = UIntArray.m8554constructorimpl(copyOf);
        m9224sortajY9A(m8554constructorimpl);
        return m8554constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m9249sortedArrayGBYM_sE(@NotNull byte[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UByteArray.m8538isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        byte[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        byte[] m8530constructorimpl = UByteArray.m8530constructorimpl(copyOf);
        m9231sortGBYM_sE(m8530constructorimpl);
        return m8530constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m9250sortedArrayQwZRm1k(@NotNull long[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (ULongArray.m8586isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        long[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        long[] m8578constructorimpl = ULongArray.m8578constructorimpl(copyOf);
        m9232sortQwZRm1k(m8578constructorimpl);
        return m8578constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m9251sortedArrayrL5Bavg(@NotNull short[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UShortArray.m8610isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        short[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        short[] m8602constructorimpl = UShortArray.m8602constructorimpl(copyOf);
        m9235sortrL5Bavg(m8602constructorimpl);
        return m8602constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m9252sortedArrayDescendingajY9A(@NotNull int[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UIntArray.m8562isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int[] m8554constructorimpl = UIntArray.m8554constructorimpl(copyOf);
        m9236sortDescendingajY9A(m8554constructorimpl);
        return m8554constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m9253sortedArrayDescendingGBYM_sE(@NotNull byte[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UByteArray.m8538isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        byte[] m8530constructorimpl = UByteArray.m8530constructorimpl(copyOf);
        m9240sortDescendingGBYM_sE(m8530constructorimpl);
        return m8530constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m9254sortedArrayDescendingQwZRm1k(@NotNull long[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (ULongArray.m8586isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        long[] m8578constructorimpl = ULongArray.m8578constructorimpl(copyOf);
        m9241sortDescendingQwZRm1k(m8578constructorimpl);
        return m8578constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m9255sortedArrayDescendingrL5Bavg(@NotNull short[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UShortArray.m8610isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        short[] m8602constructorimpl = UShortArray.m8602constructorimpl(copyOf);
        m9243sortDescendingrL5Bavg(m8602constructorimpl);
        return m8602constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<UInt> m9256sortedDescendingajY9A(@NotNull int[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        int[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int[] m8554constructorimpl = UIntArray.m8554constructorimpl(copyOf);
        m9224sortajY9A(m8554constructorimpl);
        return m9192reversedajY9A(m8554constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m9257sortedDescendingGBYM_sE(@NotNull byte[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        byte[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        byte[] m8530constructorimpl = UByteArray.m8530constructorimpl(copyOf);
        m9231sortGBYM_sE(m8530constructorimpl);
        return m9193reversedGBYM_sE(m8530constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m9258sortedDescendingQwZRm1k(@NotNull long[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        long[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        long[] m8578constructorimpl = ULongArray.m8578constructorimpl(copyOf);
        m9232sortQwZRm1k(m8578constructorimpl);
        return m9194reversedQwZRm1k(m8578constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m9259sortedDescendingrL5Bavg(@NotNull short[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        short[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        short[] m8602constructorimpl = UShortArray.m8602constructorimpl(copyOf);
        m9235sortrL5Bavg(m8602constructorimpl);
        return m9195reversedrL5Bavg(m8602constructorimpl);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int i = 0;
        for (UByte uByte : uByteArr) {
            i = UInt.m8546constructorimpl(UInt.m8546constructorimpl(uByte.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() & 255) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int i = 0;
        for (UInt uInt : uIntArr) {
            i = UInt.m8546constructorimpl(uInt.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        long j = 0;
        for (ULong uLong : uLongArr) {
            j = ULong.m8570constructorimpl(uLong.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() + j);
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int i = 0;
        for (UShort uShort : uShortArr) {
            i = UInt.m8546constructorimpl(UInt.m8546constructorimpl(uShort.getData() & UShort.MAX_VALUE) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<UByte> m9260takePpDY95g(@NotNull byte[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i >= UByteArray.m8536getSizeimpl(take)) {
                return CollectionsKt___CollectionsKt.toList(UByteArray.m8528boximpl(take));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int m8536getSizeimpl = UByteArray.m8536getSizeimpl(take);
            int i2 = 0;
            for (int i3 = 0; i3 < m8536getSizeimpl; i3++) {
                arrayList.add(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<UShort> m9261takenggk6HY(@NotNull short[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i >= UShortArray.m8608getSizeimpl(take)) {
                return CollectionsKt___CollectionsKt.toList(UShortArray.m8600boximpl(take));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int m8608getSizeimpl = UShortArray.m8608getSizeimpl(take);
            int i2 = 0;
            for (int i3 = 0; i3 < m8608getSizeimpl; i3++) {
                arrayList.add(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m9262takeqFRl0hI(@NotNull int[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i >= UIntArray.m8560getSizeimpl(take)) {
                return CollectionsKt___CollectionsKt.toList(UIntArray.m8552boximpl(take));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int m8560getSizeimpl = UIntArray.m8560getSizeimpl(take);
            int i2 = 0;
            for (int i3 = 0; i3 < m8560getSizeimpl; i3++) {
                arrayList.add(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<ULong> m9263taker7IrZao(@NotNull long[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i >= ULongArray.m8584getSizeimpl(take)) {
                return CollectionsKt___CollectionsKt.toList(ULongArray.m8576boximpl(take));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int m8584getSizeimpl = ULongArray.m8584getSizeimpl(take);
            int i2 = 0;
            for (int i3 = 0; i3 < m8584getSizeimpl; i3++) {
                arrayList.add(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m9264takeLastPpDY95g(@NotNull byte[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int m8536getSizeimpl = UByteArray.m8536getSizeimpl(takeLast);
            if (i >= m8536getSizeimpl) {
                return CollectionsKt___CollectionsKt.toList(UByteArray.m8528boximpl(takeLast));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(takeLast, m8536getSizeimpl - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = m8536getSizeimpl - i; i2 < m8536getSizeimpl; i2++) {
                arrayList.add(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m9265takeLastnggk6HY(@NotNull short[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int m8608getSizeimpl = UShortArray.m8608getSizeimpl(takeLast);
            if (i >= m8608getSizeimpl) {
                return CollectionsKt___CollectionsKt.toList(UShortArray.m8600boximpl(takeLast));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(takeLast, m8608getSizeimpl - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = m8608getSizeimpl - i; i2 < m8608getSizeimpl; i2++) {
                arrayList.add(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m9266takeLastqFRl0hI(@NotNull int[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int m8560getSizeimpl = UIntArray.m8560getSizeimpl(takeLast);
            if (i >= m8560getSizeimpl) {
                return CollectionsKt___CollectionsKt.toList(UIntArray.m8552boximpl(takeLast));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(takeLast, m8560getSizeimpl - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = m8560getSizeimpl - i; i2 < m8560getSizeimpl; i2++) {
                arrayList.add(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m9267takeLastr7IrZao(@NotNull long[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int m8584getSizeimpl = ULongArray.m8584getSizeimpl(takeLast);
            if (i >= m8584getSizeimpl) {
                return CollectionsKt___CollectionsKt.toList(ULongArray.m8576boximpl(takeLast));
            }
            if (i == 1) {
                return AbstractC1167eq.listOf(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(takeLast, m8584getSizeimpl - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = m8584getSizeimpl - i; i2 < m8584getSizeimpl; i2++) {
                arrayList.add(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m9268toTypedArrayajY9A(@NotNull int[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int m8560getSizeimpl = UIntArray.m8560getSizeimpl(toTypedArray);
        UInt[] uIntArr = new UInt[m8560getSizeimpl];
        for (int i = 0; i < m8560getSizeimpl; i++) {
            uIntArr[i] = UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(toTypedArray, i));
        }
        return uIntArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m9269toTypedArrayGBYM_sE(@NotNull byte[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int m8536getSizeimpl = UByteArray.m8536getSizeimpl(toTypedArray);
        UByte[] uByteArr = new UByte[m8536getSizeimpl];
        for (int i = 0; i < m8536getSizeimpl; i++) {
            uByteArr[i] = UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(toTypedArray, i));
        }
        return uByteArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m9270toTypedArrayQwZRm1k(@NotNull long[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int m8584getSizeimpl = ULongArray.m8584getSizeimpl(toTypedArray);
        ULong[] uLongArr = new ULong[m8584getSizeimpl];
        for (int i = 0; i < m8584getSizeimpl; i++) {
            uLongArr[i] = ULong.m8569boximpl(ULongArray.m8583getsVKNKU(toTypedArray, i));
        }
        return uLongArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m9271toTypedArrayrL5Bavg(@NotNull short[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int m8608getSizeimpl = UShortArray.m8608getSizeimpl(toTypedArray);
        UShort[] uShortArr = new UShort[m8608getSizeimpl];
        for (int i = 0; i < m8608getSizeimpl; i++) {
            uShortArr[i] = UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(toTypedArray, i));
        }
        return uShortArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] toUByteArray(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int length = uByteArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = uByteArr[i].getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
        }
        return UByteArray.m8530constructorimpl(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] toUIntArray(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int length = uIntArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = uIntArr[i].getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
        }
        return UIntArray.m8554constructorimpl(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] toULongArray(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        int length = uLongArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = uLongArr[i].getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
        }
        return ULongArray.m8578constructorimpl(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] toUShortArray(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int length = uShortArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = uShortArr[i].getData();
        }
        return UShortArray.m8602constructorimpl(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m9272withIndexajY9A(@NotNull int[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new C1940wb(withIndex, 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m9273withIndexGBYM_sE(@NotNull byte[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new C1866ub(withIndex, 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m9274withIndexQwZRm1k(@NotNull long[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new C1977xb(withIndex, 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m9275withIndexrL5Bavg(@NotNull short[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new C1903vb(withIndex, 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m9276zipCE_24M(@NotNull int[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(UIntArray.m8560getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(zip, i);
            arrayList.add(TuplesKt.m5575to(UInt.m8545boximpl(m8559getpVg5ArA), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m9277zipF7u83W8(@NotNull long[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int m8584getSizeimpl = ULongArray.m8584getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), m8584getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= m8584getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m9278zipHwE9HBo(@NotNull int[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int m8560getSizeimpl = UIntArray.m8560getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), m8560getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= m8560getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m9279zipJGPC0M(@NotNull short[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int m8608getSizeimpl = UShortArray.m8608getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), m8608getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= m8608getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m9280zipJQknh5Q(@NotNull byte[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int m8536getSizeimpl = UByteArray.m8536getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(AbstractC1204fq.collectionSizeOrDefault(other, 10), m8536getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= m8536getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m5575to(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m9281zipctEhBpI(@NotNull int[] zip, @NotNull int[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(UIntArray.m8560getSizeimpl(zip), UIntArray.m8560getSizeimpl(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(zip, i)), UInt.m8545boximpl(UIntArray.m8559getpVg5ArA(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m9282zipf7H3mmw(@NotNull long[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(ULongArray.m8584getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            long m8583getsVKNKU = ULongArray.m8583getsVKNKU(zip, i);
            arrayList.add(TuplesKt.m5575to(ULong.m8569boximpl(m8583getsVKNKU), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m9283zipkdPth3s(@NotNull byte[] zip, @NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(UByteArray.m8536getSizeimpl(zip), UByteArray.m8536getSizeimpl(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(zip, i)), UByte.m8521boximpl(UByteArray.m8535getw2LRezQ(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m9284zipmazbYpA(@NotNull short[] zip, @NotNull short[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(UShortArray.m8608getSizeimpl(zip), UShortArray.m8608getSizeimpl(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(zip, i)), UShort.m8593boximpl(UShortArray.m8607getMh2AYeg(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m9285zipnl983wc(@NotNull byte[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(UByteArray.m8536getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(zip, i);
            arrayList.add(TuplesKt.m5575to(UByte.m8521boximpl(m8535getw2LRezQ), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m9286zipuaTIQ5s(@NotNull short[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(UShortArray.m8608getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(zip, i);
            arrayList.add(TuplesKt.m5575to(UShort.m8593boximpl(m8607getMh2AYeg), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m9287zipus8wMrg(@NotNull long[] zip, @NotNull long[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(ULongArray.m8584getSizeimpl(zip), ULongArray.m8584getSizeimpl(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.m5575to(ULong.m8569boximpl(ULongArray.m8583getsVKNKU(zip, i)), ULong.m8569boximpl(ULongArray.m8583getsVKNKU(other, i))));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m9154maxOrThrowU(@NotNull long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (!ULongArray.m8586isEmptyimpl(max)) {
            long m8583getsVKNKU = ULongArray.m8583getsVKNKU(max, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(max)).iterator();
            while (it.hasNext()) {
                long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(max, it.nextInt());
                if (Long.compare(m8583getsVKNKU ^ Long.MIN_VALUE, Long.MIN_VALUE ^ m8583getsVKNKU2) < 0) {
                    m8583getsVKNKU = m8583getsVKNKU2;
                }
            }
            return m8583getsVKNKU;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m9162maxWithOrThrowU(@NotNull long[] maxWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!ULongArray.m8586isEmptyimpl(maxWith)) {
            long m8583getsVKNKU = ULongArray.m8583getsVKNKU(maxWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWith)).iterator();
            while (it.hasNext()) {
                long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(maxWith, it.nextInt());
                if (comparator.compare(ULong.m8569boximpl(m8583getsVKNKU), ULong.m8569boximpl(m8583getsVKNKU2)) < 0) {
                    m8583getsVKNKU = m8583getsVKNKU2;
                }
            }
            return m8583getsVKNKU;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m9170minOrThrowU(@NotNull long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (!ULongArray.m8586isEmptyimpl(min)) {
            long m8583getsVKNKU = ULongArray.m8583getsVKNKU(min, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(min)).iterator();
            while (it.hasNext()) {
                long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(min, it.nextInt());
                if (Long.compare(m8583getsVKNKU ^ Long.MIN_VALUE, Long.MIN_VALUE ^ m8583getsVKNKU2) > 0) {
                    m8583getsVKNKU = m8583getsVKNKU2;
                }
            }
            return m8583getsVKNKU;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m9178minWithOrThrowU(@NotNull long[] minWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!ULongArray.m8586isEmptyimpl(minWith)) {
            long m8583getsVKNKU = ULongArray.m8583getsVKNKU(minWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWith)).iterator();
            while (it.hasNext()) {
                long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(minWith, it.nextInt());
                if (comparator.compare(ULong.m8569boximpl(m8583getsVKNKU), ULong.m8569boximpl(m8583getsVKNKU2)) > 0) {
                    m8583getsVKNKU = m8583getsVKNKU2;
                }
            }
            return m8583getsVKNKU;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m9152maxOrThrowU(@NotNull byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (!UByteArray.m8538isEmptyimpl(max)) {
            byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(max, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(max)).iterator();
            while (it.hasNext()) {
                byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(max, it.nextInt());
                if (Intrinsics.compare(m8535getw2LRezQ & 255, m8535getw2LRezQ2 & 255) < 0) {
                    m8535getw2LRezQ = m8535getw2LRezQ2;
                }
            }
            return m8535getw2LRezQ;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m9160maxWithOrThrowU(@NotNull byte[] maxWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UByteArray.m8538isEmptyimpl(maxWith)) {
            byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(maxWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWith)).iterator();
            while (it.hasNext()) {
                byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(maxWith, it.nextInt());
                if (comparator.compare(UByte.m8521boximpl(m8535getw2LRezQ), UByte.m8521boximpl(m8535getw2LRezQ2)) < 0) {
                    m8535getw2LRezQ = m8535getw2LRezQ2;
                }
            }
            return m8535getw2LRezQ;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m9168minOrThrowU(@NotNull byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (!UByteArray.m8538isEmptyimpl(min)) {
            byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(min, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(min)).iterator();
            while (it.hasNext()) {
                byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(min, it.nextInt());
                if (Intrinsics.compare(m8535getw2LRezQ & 255, m8535getw2LRezQ2 & 255) > 0) {
                    m8535getw2LRezQ = m8535getw2LRezQ2;
                }
            }
            return m8535getw2LRezQ;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m9176minWithOrThrowU(@NotNull byte[] minWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UByteArray.m8538isEmptyimpl(minWith)) {
            byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(minWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWith)).iterator();
            while (it.hasNext()) {
                byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(minWith, it.nextInt());
                if (comparator.compare(UByte.m8521boximpl(m8535getw2LRezQ), UByte.m8521boximpl(m8535getw2LRezQ2)) > 0) {
                    m8535getw2LRezQ = m8535getw2LRezQ2;
                }
            }
            return m8535getw2LRezQ;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m9155maxOrThrowU(@NotNull short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (!UShortArray.m8610isEmptyimpl(max)) {
            short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(max, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(max)).iterator();
            while (it.hasNext()) {
                short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(max, it.nextInt());
                if (Intrinsics.compare(m8607getMh2AYeg & UShort.MAX_VALUE, 65535 & m8607getMh2AYeg2) < 0) {
                    m8607getMh2AYeg = m8607getMh2AYeg2;
                }
            }
            return m8607getMh2AYeg;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m9163maxWithOrThrowU(@NotNull short[] maxWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UShortArray.m8610isEmptyimpl(maxWith)) {
            short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(maxWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(maxWith)).iterator();
            while (it.hasNext()) {
                short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(maxWith, it.nextInt());
                if (comparator.compare(UShort.m8593boximpl(m8607getMh2AYeg), UShort.m8593boximpl(m8607getMh2AYeg2)) < 0) {
                    m8607getMh2AYeg = m8607getMh2AYeg2;
                }
            }
            return m8607getMh2AYeg;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m9171minOrThrowU(@NotNull short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (!UShortArray.m8610isEmptyimpl(min)) {
            short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(min, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(min)).iterator();
            while (it.hasNext()) {
                short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(min, it.nextInt());
                if (Intrinsics.compare(m8607getMh2AYeg & UShort.MAX_VALUE, 65535 & m8607getMh2AYeg2) > 0) {
                    m8607getMh2AYeg = m8607getMh2AYeg2;
                }
            }
            return m8607getMh2AYeg;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m9179minWithOrThrowU(@NotNull short[] minWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!UShortArray.m8610isEmptyimpl(minWith)) {
            short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(minWith, 0);
            ?? it = new IntRange(1, ArraysKt___ArraysKt.getLastIndex(minWith)).iterator();
            while (it.hasNext()) {
                short m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(minWith, it.nextInt());
                if (comparator.compare(UShort.m8593boximpl(m8607getMh2AYeg), UShort.m8593boximpl(m8607getMh2AYeg2)) > 0) {
                    m8607getMh2AYeg = m8607getMh2AYeg2;
                }
            }
            return m8607getMh2AYeg;
        }
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m9125getIndicesajY9A$annotations(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m9127getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m9129getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m9131getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m9133getLastIndexajY9A$annotations(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m9135getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m9137getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m9139getLastIndexrL5Bavg$annotations(short[] sArr) {
    }
}
