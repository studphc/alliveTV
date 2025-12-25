package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;

/* loaded from: classes.dex */
public class ContainerMediaChunk extends BaseMediaChunk {

    /* renamed from: c */
    public final int f11176c;

    /* renamed from: d */
    public final long f11177d;

    /* renamed from: e */
    public final ChunkExtractor f11178e;

    /* renamed from: f */
    public long f11179f;

    /* renamed from: g */
    public volatile boolean f11180g;

    /* renamed from: h */
    public boolean f11181h;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3, j4, j5);
        this.f11176c = i2;
        this.f11177d = j6;
        this.f11178e = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.f11180g = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + this.f11176c;
    }

    public ChunkExtractor.TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.f11181h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        long j;
        long j2;
        if (this.f11179f == 0) {
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(this.f11177d);
            ChunkExtractor chunkExtractor = this.f11178e;
            ChunkExtractor.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j3 = this.clippedStartTimeUs;
            if (j3 == C0643C.TIME_UNSET) {
                j = -9223372036854775807L;
            } else {
                j = j3 - this.f11177d;
            }
            long j4 = this.clippedEndTimeUs;
            if (j4 == C0643C.TIME_UNSET) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j4 - this.f11177d;
            }
            chunkExtractor.init(trackOutputProvider, j, j2);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.f11179f);
            StatsDataSource statsDataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            do {
                try {
                    if (this.f11180g) {
                        break;
                    }
                } finally {
                    this.f11179f = defaultExtractorInput.getPosition() - this.dataSpec.position;
                }
            } while (this.f11178e.read(defaultExtractorInput));
            DataSourceUtil.closeQuietly(this.dataSource);
            this.f11181h = !this.f11180g;
        } catch (Throwable th) {
            DataSourceUtil.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
