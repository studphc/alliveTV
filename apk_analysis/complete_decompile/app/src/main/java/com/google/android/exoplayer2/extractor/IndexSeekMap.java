package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class IndexSeekMap implements SeekMap {

    /* renamed from: a */
    public final long[] f10093a;

    /* renamed from: b */
    public final long[] f10094b;

    /* renamed from: c */
    public final long f10095c;

    /* renamed from: d */
    public final boolean f10096d;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j) {
        boolean z;
        boolean z2;
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int length = jArr2.length;
        if (length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f10096d = z2;
        if (z2 && jArr2[0] > 0) {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.f10093a = jArr3;
            long[] jArr4 = new long[i];
            this.f10094b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        } else {
            this.f10093a = jArr;
            this.f10094b = jArr2;
        }
        this.f10095c = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f10095c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        if (!this.f10096d) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        long[] jArr = this.f10094b;
        int binarySearchFloor = Util.binarySearchFloor(jArr, j, true, true);
        long j2 = jArr[binarySearchFloor];
        long[] jArr2 = this.f10093a;
        SeekPoint seekPoint = new SeekPoint(j2, jArr2[binarySearchFloor]);
        if (seekPoint.timeUs != j && binarySearchFloor != jArr.length - 1) {
            int i = binarySearchFloor + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(jArr[i], jArr2[i]));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.f10096d;
    }
}
