package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class f41 implements tf2 {

    /* renamed from: a */
    public final long f17121a;

    /* renamed from: b */
    public final LongArray f17122b;

    /* renamed from: c */
    public final LongArray f17123c;

    /* renamed from: d */
    public long f17124d;

    public f41(long j, long j2, long j3) {
        this.f17124d = j;
        this.f17121a = j3;
        LongArray longArray = new LongArray();
        this.f17122b = longArray;
        LongArray longArray2 = new LongArray();
        this.f17123c = longArray2;
        longArray.add(0L);
        longArray2.add(j2);
    }

    /* renamed from: a */
    public final boolean m4768a(long j) {
        LongArray longArray = this.f17122b;
        if (j - longArray.get(longArray.size() - 1) < 100000) {
            return true;
        }
        return false;
    }

    @Override // p000.tf2
    public final long getDataEndPosition() {
        return this.f17121a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f17124d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        LongArray longArray = this.f17122b;
        int binarySearchFloor = Util.binarySearchFloor(longArray, j, true, true);
        long j2 = longArray.get(binarySearchFloor);
        LongArray longArray2 = this.f17123c;
        SeekPoint seekPoint = new SeekPoint(j2, longArray2.get(binarySearchFloor));
        if (seekPoint.timeUs != j && binarySearchFloor != longArray.size() - 1) {
            int i = binarySearchFloor + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(longArray.get(i), longArray2.get(i)));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // p000.tf2
    public final long getTimeUs(long j) {
        return this.f17122b.get(Util.binarySearchFloor(this.f17123c, j, true, true));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
