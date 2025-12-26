package p000;

import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class jo1 implements tf2 {

    /* renamed from: a */
    public final long[] f20567a;

    /* renamed from: b */
    public final long[] f20568b;

    /* renamed from: c */
    public final long f20569c;

    public jo1(long[] jArr, long[] jArr2, long j) {
        this.f20567a = jArr;
        this.f20568b = jArr2;
        this.f20569c = j == C0643C.TIME_UNSET ? Util.msToUs(jArr2[jArr2.length - 1]) : j;
    }

    /* renamed from: a */
    public static Pair m5446a(long[] jArr, long[] jArr2, long j) {
        double d;
        int binarySearchFloor = Util.binarySearchFloor(jArr, j, true, true);
        long j2 = jArr[binarySearchFloor];
        long j3 = jArr2[binarySearchFloor];
        int i = binarySearchFloor + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        long j5 = jArr2[i];
        if (j4 == j2) {
            d = 0.0d;
        } else {
            d = (j - j2) / (j4 - j2);
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) (d * (j5 - j3))) + j3));
    }

    @Override // p000.tf2
    public final long getDataEndPosition() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f20569c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        Pair m5446a = m5446a(this.f20568b, this.f20567a, Util.usToMs(Util.constrainValue(j, 0L, this.f20569c)));
        return new SeekMap.SeekPoints(new SeekPoint(Util.msToUs(((Long) m5446a.first).longValue()), ((Long) m5446a.second).longValue()));
    }

    @Override // p000.tf2
    public final long getTimeUs(long j) {
        return Util.msToUs(((Long) m5446a(this.f20567a, this.f20568b, j).second).longValue());
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
