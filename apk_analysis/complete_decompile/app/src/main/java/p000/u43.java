package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class u43 implements SeekMap {

    /* renamed from: a */
    public final C1682pc f27105a;

    /* renamed from: b */
    public final int f27106b;

    /* renamed from: c */
    public final long f27107c;

    /* renamed from: d */
    public final long f27108d;

    /* renamed from: e */
    public final long f27109e;

    public u43(C1682pc c1682pc, int i, long j, long j2) {
        this.f27105a = c1682pc;
        this.f27106b = i;
        this.f27107c = j;
        long j3 = (j2 - j) / c1682pc.f25114c;
        this.f27108d = j3;
        this.f27109e = Util.scaleLargeTimestamp(j3 * i, 1000000L, c1682pc.f25113b);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f27109e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        C1682pc c1682pc = this.f27105a;
        int i = this.f27106b;
        long j2 = (c1682pc.f25113b * j) / (i * 1000000);
        long j3 = this.f27108d - 1;
        long constrainValue = Util.constrainValue(j2, 0L, j3);
        int i2 = c1682pc.f25114c;
        long j4 = this.f27107c;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(constrainValue * i, 1000000L, c1682pc.f25113b);
        SeekPoint seekPoint = new SeekPoint(scaleLargeTimestamp, (i2 * constrainValue) + j4);
        if (scaleLargeTimestamp < j && constrainValue != j3) {
            long j5 = constrainValue + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(Util.scaleLargeTimestamp(j5 * i, 1000000L, c1682pc.f25113b), (i2 * j5) + j4));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
