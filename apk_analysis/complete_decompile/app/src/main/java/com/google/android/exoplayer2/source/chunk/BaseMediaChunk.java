package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class BaseMediaChunk extends MediaChunk {

    /* renamed from: a */
    public BaseMediaChunkOutput f11133a;

    /* renamed from: b */
    public int[] f11134b;
    public final long clippedEndTimeUs;
    public final long clippedStartTimeUs;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j5);
        this.clippedStartTimeUs = j3;
        this.clippedEndTimeUs = j4;
    }

    public final int getFirstSampleIndex(int i) {
        return ((int[]) Assertions.checkStateNotNull(this.f11134b))[i];
    }

    public final BaseMediaChunkOutput getOutput() {
        return (BaseMediaChunkOutput) Assertions.checkStateNotNull(this.f11133a);
    }

    public void init(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.f11133a = baseMediaChunkOutput;
        this.f11134b = baseMediaChunkOutput.getWriteIndices();
    }
}
