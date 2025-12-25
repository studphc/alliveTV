package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes.dex */
public final class f82 {

    /* renamed from: c */
    public boolean f17172c;

    /* renamed from: d */
    public boolean f17173d;

    /* renamed from: e */
    public boolean f17174e;

    /* renamed from: a */
    public final TimestampAdjuster f17170a = new TimestampAdjuster(0);

    /* renamed from: f */
    public long f17175f = C0643C.TIME_UNSET;

    /* renamed from: g */
    public long f17176g = C0643C.TIME_UNSET;

    /* renamed from: h */
    public long f17177h = C0643C.TIME_UNSET;

    /* renamed from: b */
    public final ParsableByteArray f17171b = new ParsableByteArray();

    /* renamed from: a */
    public static int m4777a(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: b */
    public static long m4778b(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        if (parsableByteArray.bytesLeft() < 9) {
            return C0643C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.readBytes(bArr, 0, 9);
        parsableByteArray.setPosition(position);
        byte b = bArr[0];
        if ((b & 196) == 68) {
            byte b2 = bArr[2];
            if ((b2 & 4) == 4) {
                byte b3 = bArr[4];
                if ((b3 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j = b;
                    long j2 = b2;
                    return ((j2 & 3) << 13) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j2 & 248) >> 3) << 15) | ((bArr[3] & 255) << 5) | ((b3 & 248) >> 3);
                }
            }
        }
        return C0643C.TIME_UNSET;
    }
}
