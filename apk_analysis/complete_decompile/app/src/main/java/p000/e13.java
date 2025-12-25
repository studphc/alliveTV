package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class e13 implements tf2 {

    /* renamed from: a */
    public final long[] f16648a;

    /* renamed from: b */
    public final long[] f16649b;

    /* renamed from: c */
    public final long f16650c;

    /* renamed from: d */
    public final long f16651d;

    public e13(long[] jArr, long[] jArr2, long j, long j2) {
        this.f16648a = jArr;
        this.f16649b = jArr2;
        this.f16650c = j;
        this.f16651d = j2;
    }

    @Override // p000.tf2
    public final long getDataEndPosition() {
        return this.f16651d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f16650c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        long[] jArr = this.f16648a;
        int binarySearchFloor = Util.binarySearchFloor(jArr, j, true, true);
        long j2 = jArr[binarySearchFloor];
        long[] jArr2 = this.f16649b;
        SeekPoint seekPoint = new SeekPoint(j2, jArr2[binarySearchFloor]);
        if (seekPoint.timeUs < j && binarySearchFloor != jArr.length - 1) {
            int i = binarySearchFloor + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(jArr[i], jArr2[i]));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // p000.tf2
    public final long getTimeUs(long j) {
        return this.f16648a[Util.binarySearchFloor(this.f16649b, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
