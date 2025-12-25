package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class FlacSeekTableSeekMap implements SeekMap {

    /* renamed from: a */
    public final FlacStreamMetadata f10087a;

    /* renamed from: b */
    public final long f10088b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j) {
        this.f10087a = flacStreamMetadata;
        this.f10088b = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f10087a.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2;
        FlacStreamMetadata flacStreamMetadata = this.f10087a;
        Assertions.checkStateNotNull(flacStreamMetadata.seekTable);
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.seekTable;
        long[] jArr = seekTable.pointSampleNumbers;
        long[] jArr2 = seekTable.pointOffsets;
        int binarySearchFloor = Util.binarySearchFloor(jArr, flacStreamMetadata.getSampleNumber(j), true, false);
        long j3 = 0;
        if (binarySearchFloor == -1) {
            j2 = 0;
        } else {
            j2 = jArr[binarySearchFloor];
        }
        if (binarySearchFloor != -1) {
            j3 = jArr2[binarySearchFloor];
        }
        long j4 = this.f10088b;
        SeekPoint seekPoint = new SeekPoint((j2 * 1000000) / flacStreamMetadata.sampleRate, j3 + j4);
        if (seekPoint.timeUs != j && binarySearchFloor != jArr.length - 1) {
            int i = binarySearchFloor + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint((jArr[i] * 1000000) / flacStreamMetadata.sampleRate, j4 + jArr2[i]));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
