package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.util.Assertions;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = new C1255h3(7);

    /* renamed from: j */
    public static final PositionHolder f11140j = new PositionHolder();

    /* renamed from: a */
    public final Extractor f11141a;

    /* renamed from: b */
    public final int f11142b;

    /* renamed from: c */
    public final Format f11143c;

    /* renamed from: d */
    public final SparseArray f11144d = new SparseArray();

    /* renamed from: e */
    public boolean f11145e;

    /* renamed from: f */
    public ChunkExtractor.TrackOutputProvider f11146f;

    /* renamed from: g */
    public long f11147g;

    /* renamed from: h */
    public SeekMap f11148h;

    /* renamed from: i */
    public Format[] f11149i;

    public BundledChunkExtractor(Extractor extractor, int i, Format format) {
        this.f11141a = extractor;
        this.f11142b = i;
        this.f11143c = format;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        SparseArray sparseArray = this.f11144d;
        Format[] formatArr = new Format[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            formatArr[i] = (Format) Assertions.checkStateNotNull(((C0691a) sparseArray.valueAt(i)).f11204e);
        }
        this.f11149i = formatArr;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public ChunkIndex getChunkIndex() {
        SeekMap seekMap = this.f11148h;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public Format[] getSampleFormats() {
        return this.f11149i;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void init(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.f11146f = trackOutputProvider;
        this.f11147g = j2;
        boolean z = this.f11145e;
        Extractor extractor = this.f11141a;
        if (!z) {
            extractor.init(this);
            if (j != C0643C.TIME_UNSET) {
                extractor.seek(0L, j);
            }
            this.f11145e = true;
            return;
        }
        if (j == C0643C.TIME_UNSET) {
            j = 0;
        }
        extractor.seek(0L, j);
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f11144d;
            if (i < sparseArray.size()) {
                C0691a c0691a = (C0691a) sparseArray.valueAt(i);
                if (trackOutputProvider == null) {
                    c0691a.f11205f = c0691a.f11203d;
                } else {
                    c0691a.f11206g = j2;
                    TrackOutput track = trackOutputProvider.track(c0691a.f11200a, c0691a.f11201b);
                    c0691a.f11205f = track;
                    Format format = c0691a.f11204e;
                    if (format != null) {
                        track.format(format);
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean read(ExtractorInput extractorInput) {
        boolean z;
        int read = this.f11141a.read(extractorInput, f11140j);
        if (read != 1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (read != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void release() {
        this.f11141a.release();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.f11148h = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        boolean z;
        Format format;
        SparseArray sparseArray = this.f11144d;
        C0691a c0691a = (C0691a) sparseArray.get(i);
        if (c0691a == null) {
            if (this.f11149i == null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            if (i2 == this.f11142b) {
                format = this.f11143c;
            } else {
                format = null;
            }
            c0691a = new C0691a(i, i2, format);
            ChunkExtractor.TrackOutputProvider trackOutputProvider = this.f11146f;
            long j = this.f11147g;
            if (trackOutputProvider == null) {
                c0691a.f11205f = c0691a.f11203d;
            } else {
                c0691a.f11206g = j;
                TrackOutput track = trackOutputProvider.track(i, i2);
                c0691a.f11205f = track;
                Format format2 = c0691a.f11204e;
                if (format2 != null) {
                    track.format(format2);
                }
            }
            sparseArray.put(i, c0691a);
        }
        return c0691a;
    }
}
