package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {

    /* renamed from: a */
    public final int[] f11138a;

    /* renamed from: b */
    public final SampleQueue[] f11139b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f11138a = iArr;
        this.f11139b = sampleQueueArr;
    }

    public int[] getWriteIndices() {
        SampleQueue[] sampleQueueArr = this.f11139b;
        int[] iArr = new int[sampleQueueArr.length];
        for (int i = 0; i < sampleQueueArr.length; i++) {
            iArr[i] = sampleQueueArr[i].getWriteIndex();
        }
        return iArr;
    }

    public void setSampleOffsetUs(long j) {
        for (SampleQueue sampleQueue : this.f11139b) {
            sampleQueue.setSampleOffsetUs(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider
    public TrackOutput track(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f11138a;
            if (i3 < iArr.length) {
                if (i2 == iArr[i3]) {
                    return this.f11139b[i3];
                }
                i3++;
            } else {
                Log.m3023e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new DummyTrackOutput();
            }
        }
    }
}
