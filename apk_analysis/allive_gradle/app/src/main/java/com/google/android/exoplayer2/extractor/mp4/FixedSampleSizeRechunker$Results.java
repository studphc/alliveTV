package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
public final class FixedSampleSizeRechunker$Results {
    public final long duration;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timestamps;

    public FixedSampleSizeRechunker$Results(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i;
        this.timestamps = jArr2;
        this.flags = iArr2;
        this.duration = j;
    }
}
