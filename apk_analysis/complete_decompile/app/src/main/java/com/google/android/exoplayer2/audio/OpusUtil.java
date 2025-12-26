package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.C0643C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OpusUtil {
    public static final int SAMPLE_RATE = 48000;

    public static List<byte[]> buildInitializationData(byte[] bArr) {
        long j = ((((bArr[11] & 255) << 8) | (bArr[10] & 255)) * C0643C.NANOS_PER_SECOND) / 48000;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array());
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(80000000L).array());
        return arrayList;
    }

    public static int getChannelCount(byte[] bArr) {
        return bArr[9] & 255;
    }
}
