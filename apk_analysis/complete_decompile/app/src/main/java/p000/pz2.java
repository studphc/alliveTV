package p000;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class pz2 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m8546constructorimpl(UInt.m8546constructorimpl(it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() & 255) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m8546constructorimpl(it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ULong.m8570constructorimpl(it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() + j);
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m8546constructorimpl(UInt.m8546constructorimpl(it.next().getData() & UShort.MAX_VALUE) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] toUByteArray(@NotNull Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] m8529constructorimpl = UByteArray.m8529constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m8540setVurrAj0(m8529constructorimpl, i, it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
            i++;
        }
        return m8529constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] toUIntArray(@NotNull Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] m8553constructorimpl = UIntArray.m8553constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m8564setVXSXFK8(m8553constructorimpl, i, it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
            i++;
        }
        return m8553constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] toULongArray(@NotNull Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m8577constructorimpl = ULongArray.m8577constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m8588setk8EXiF4(m8577constructorimpl, i, it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
            i++;
        }
        return m8577constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] toUShortArray(@NotNull Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] m8601constructorimpl = UShortArray.m8601constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m8612set01HTLdE(m8601constructorimpl, i, it.next().getData());
            i++;
        }
        return m8601constructorimpl;
    }
}
