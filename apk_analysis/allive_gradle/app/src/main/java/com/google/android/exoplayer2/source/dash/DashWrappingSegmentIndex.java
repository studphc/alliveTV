package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

/* loaded from: classes.dex */
public final class DashWrappingSegmentIndex implements DashSegmentIndex {

    /* renamed from: a */
    public final ChunkIndex f11253a;

    /* renamed from: b */
    public final long f11254b;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long j) {
        this.f11253a = chunkIndex;
        this.f11254b = j;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getAvailableSegmentCount(long j, long j2) {
        return this.f11253a.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(long j, long j2) {
        return this.f11253a.durationsUs[(int) j];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstAvailableSegmentNum(long j, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstSegmentNum() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getNextSegmentAvailableTimeUs(long j, long j2) {
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentCount(long j) {
        return this.f11253a.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentNum(long j, long j2) {
        return this.f11253a.getChunkIndex(j + this.f11254b);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public RangedUri getSegmentUrl(long j) {
        return new RangedUri(null, this.f11253a.offsets[(int) j], r0.sizes[r8]);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j) {
        return this.f11253a.timesUs[(int) j] - this.f11254b;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }
}
