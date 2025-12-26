package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;

/* loaded from: classes.dex */
public final class SingleSampleMediaChunk extends BaseMediaChunk {

    /* renamed from: c */
    public final int f11196c;

    /* renamed from: d */
    public final Format f11197d;

    /* renamed from: e */
    public long f11198e;

    /* renamed from: f */
    public boolean f11199f;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, long j, long j2, long j3, int i2, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, C0643C.TIME_UNSET, C0643C.TIME_UNSET, j3);
        this.f11196c = i2;
        this.f11197d = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.f11199f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() {
        BaseMediaChunkOutput output = getOutput();
        output.setSampleOffsetUs(0L);
        TrackOutput track = output.track(0, this.f11196c);
        track.format(this.f11197d);
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.f11198e));
            if (open != -1) {
                open += this.f11198e;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.f11198e, open);
            for (int i = 0; i != -1; i = track.sampleData((DataReader) defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.f11198e += i;
            }
            track.sampleMetadata(this.startTimeUs, 1, (int) this.f11198e, 0, null);
            DataSourceUtil.closeQuietly(this.dataSource);
            this.f11199f = true;
        } catch (Throwable th) {
            DataSourceUtil.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
