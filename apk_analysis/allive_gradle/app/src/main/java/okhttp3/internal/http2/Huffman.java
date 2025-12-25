package okhttp3.internal.http2;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import p000.C1617oc;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, m5569d2 = {"Lokhttp3/internal/http2/Huffman;", "", "Lokio/ByteString;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSink;", "sink", "", "encode", "(Lokio/ByteString;Lokio/BufferedSink;)V", "bytes", "", "encodedLength", "(Lokio/ByteString;)I", "Lokio/BufferedSource;", "", "byteCount", "decode", "(Lokio/BufferedSource;JLokio/BufferedSink;)V", "oc", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Huffman {

    @NotNull
    public static final Huffman INSTANCE = new Object();

    /* renamed from: a */
    public static final int[] f24520a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    public static final byte[] f24521b = {Ascii.f14455CR, Ascii.ETB, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.CAN, Ascii.f14463RS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14463RS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14463RS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, Ascii.f14458FS, 6, 10, 10, Ascii.f14457FF, Ascii.f14455CR, 6, 8, Ascii.f14468VT, 10, 10, 8, Ascii.f14468VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.f14464SI, 6, Ascii.f14457FF, 10, Ascii.f14455CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.f14455CR, 19, Ascii.f14455CR, Ascii.f14465SO, 6, Ascii.f14464SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.f14464SI, Ascii.f14468VT, Ascii.f14465SO, Ascii.f14455CR, Ascii.f14458FS, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.SYN, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.CAN, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.f14456EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.f14456EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.f14458FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.f14456EM, Ascii.f14456EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.f14458FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};

    /* renamed from: c */
    public static final C1617oc f24522c = new C1617oc();

    /* JADX WARN: Type inference failed for: r4v0, types: [okhttp3.internal.http2.Huffman, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [oc, java.lang.Object] */
    static {
        C1617oc[] c1617ocArr;
        for (int i = 0; i < 256; i++) {
            Huffman huffman = INSTANCE;
            int i2 = f24520a[i];
            int i3 = f24521b[i];
            huffman.getClass();
            ?? obj = new Object();
            obj.f23761c = null;
            obj.f23759a = i;
            int i4 = i3 & 7;
            if (i4 == 0) {
                i4 = 8;
            }
            obj.f23760b = i4;
            C1617oc c1617oc = f24522c;
            while (true) {
                c1617ocArr = (C1617oc[]) c1617oc.f23761c;
                if (i3 > 8) {
                    i3 -= 8;
                    int i5 = (i2 >>> i3) & 255;
                    Intrinsics.checkNotNull(c1617ocArr);
                    C1617oc c1617oc2 = c1617ocArr[i5];
                    if (c1617oc2 == null) {
                        c1617oc2 = new C1617oc();
                        c1617ocArr[i5] = c1617oc2;
                    }
                    c1617oc = c1617oc2;
                }
            }
            int i6 = 8 - i3;
            int i7 = (i2 << i6) & 255;
            Intrinsics.checkNotNull(c1617ocArr);
            ArraysKt___ArraysJvmKt.fill(c1617ocArr, obj, i7, (1 << i6) + i7);
        }
    }

    public final void decode(@NotNull BufferedSource source, long byteCount, @NotNull BufferedSink sink) {
        int i;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        C1617oc c1617oc = f24522c;
        int i2 = 0;
        C1617oc c1617oc2 = c1617oc;
        int i3 = 0;
        for (long j = 0; j < byteCount; j++) {
            i2 = (i2 << 8) | _UtilCommonKt.and(source.readByte(), 255);
            i3 += 8;
            while (i3 >= 8) {
                C1617oc[] c1617ocArr = (C1617oc[]) c1617oc2.f23761c;
                Intrinsics.checkNotNull(c1617ocArr);
                c1617oc2 = c1617ocArr[(i2 >>> (i3 - 8)) & 255];
                Intrinsics.checkNotNull(c1617oc2);
                if (((C1617oc[]) c1617oc2.f23761c) == null) {
                    sink.writeByte(c1617oc2.f23759a);
                    i3 -= c1617oc2.f23760b;
                    c1617oc2 = c1617oc;
                } else {
                    i3 -= 8;
                }
            }
        }
        while (i3 > 0) {
            C1617oc[] c1617ocArr2 = (C1617oc[]) c1617oc2.f23761c;
            Intrinsics.checkNotNull(c1617ocArr2);
            C1617oc c1617oc3 = c1617ocArr2[(i2 << (8 - i3)) & 255];
            Intrinsics.checkNotNull(c1617oc3);
            if (((C1617oc[]) c1617oc3.f23761c) == null && (i = c1617oc3.f23760b) <= i3) {
                sink.writeByte(c1617oc3.f23759a);
                i3 -= i;
                c1617oc2 = c1617oc;
            } else {
                return;
            }
        }
    }

    public final void encode(@NotNull ByteString source, @NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int size = source.size();
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int and = _UtilCommonKt.and(source.getByte(i2), 255);
            int i3 = f24520a[and];
            byte b = f24521b[and];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i -= 8;
                sink.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            sink.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public final int encodedLength(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j = 0;
        for (int i = 0; i < bytes.size(); i++) {
            j += f24521b[_UtilCommonKt.and(bytes.getByte(i), 255)];
        }
        return (int) ((j + 7) >> 3);
    }
}
