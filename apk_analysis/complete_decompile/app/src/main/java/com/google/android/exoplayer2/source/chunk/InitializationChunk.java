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
public final class InitializationChunk extends Chunk {

    /* renamed from: a */
    public final ChunkExtractor f11184a;

    /* renamed from: b */
    public ChunkExtractor.TrackOutputProvider f11185b;

    /* renamed from: c */
    public long f11186c;

    /* renamed from: d */
    public volatile boolean f11187d;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i, obj, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
        this.f11184a = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.f11187d = true;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.f11185b = trackOutputProvider;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() {
        if (this.f11186c == 0) {
            this.f11184a.init(this.f11185b, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.f11186c);
            StatsDataSource statsDataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            while (!this.f11187d && this.f11184a.read(defaultExtractorInput)) {
                try {
                } finally {
                    this.f11186c = defaultExtractorInput.getPosition() - this.dataSpec.position;
                }
            }
        } finally {
            DataSourceUtil.closeQuietly(this.dataSource);
        }
    }
}
