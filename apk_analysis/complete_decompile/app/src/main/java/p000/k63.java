package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class k63 implements tf2 {

    /* renamed from: a */
    public final long f20760a;

    /* renamed from: b */
    public final int f20761b;

    /* renamed from: c */
    public final long f20762c;

    /* renamed from: d */
    public final long f20763d;

    /* renamed from: e */
    public final long f20764e;

    /* renamed from: f */
    public final long[] f20765f;

    public k63(long j, int i, long j2, long j3, long[] jArr) {
        this.f20760a = j;
        this.f20761b = i;
        this.f20762c = j2;
        this.f20765f = jArr;
        this.f20763d = j3;
        this.f20764e = j3 != -1 ? j + j3 : -1L;
    }

    @Override // p000.tf2
    public final long getDataEndPosition() {
        return this.f20764e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f20762c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        double d;
        double d2;
        boolean isSeekable = isSeekable();
        int i = this.f20761b;
        long j2 = this.f20760a;
        if (!isSeekable) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, j2 + i));
        }
        long constrainValue = Util.constrainValue(j, 0L, this.f20762c);
        double d3 = (constrainValue * 100.0d) / this.f20762c;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d2 = 256.0d;
                d4 = 256.0d;
                double d5 = d4 / d2;
                long j3 = this.f20763d;
                return new SeekMap.SeekPoints(new SeekPoint(constrainValue, j2 + Util.constrainValue(Math.round(d5 * j3), i, j3 - 1)));
            }
            int i2 = (int) d3;
            long[] jArr = (long[]) Assertions.checkStateNotNull(this.f20765f);
            double d6 = jArr[i2];
            if (i2 == 99) {
                d = 256.0d;
            } else {
                d = jArr[i2 + 1];
            }
            d4 = ((d - d6) * (d3 - i2)) + d6;
        }
        d2 = 256.0d;
        double d52 = d4 / d2;
        long j32 = this.f20763d;
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, j2 + Util.constrainValue(Math.round(d52 * j32), i, j32 - 1)));
    }

    @Override // p000.tf2
    public final long getTimeUs(long j) {
        long j2;
        double d;
        long j3 = j - this.f20760a;
        if (isSeekable() && j3 > this.f20761b) {
            long[] jArr = (long[]) Assertions.checkStateNotNull(this.f20765f);
            double d2 = (j3 * 256.0d) / this.f20763d;
            int binarySearchFloor = Util.binarySearchFloor(jArr, (long) d2, true, true);
            long j4 = this.f20762c;
            long j5 = (binarySearchFloor * j4) / 100;
            long j6 = jArr[binarySearchFloor];
            int i = binarySearchFloor + 1;
            long j7 = (j4 * i) / 100;
            if (binarySearchFloor == 99) {
                j2 = 256;
            } else {
                j2 = jArr[i];
            }
            if (j6 == j2) {
                d = 0.0d;
            } else {
                d = (d2 - j6) / (j2 - j6);
            }
            return Math.round(d * (j7 - j5)) + j5;
        }
        return 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        if (this.f20765f != null) {
            return true;
        }
        return false;
    }
}
