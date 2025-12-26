package p000;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class uz2 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UByte> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m8546constructorimpl(UInt.m8546constructorimpl(it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() & 255) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UInt> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m8546constructorimpl(it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<ULong> it = sequence.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ULong.m8570constructorimpl(it.next().getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String() + j);
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UShort> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m8546constructorimpl(UInt.m8546constructorimpl(it.next().getData() & UShort.MAX_VALUE) + i);
        }
        return i;
    }
}
