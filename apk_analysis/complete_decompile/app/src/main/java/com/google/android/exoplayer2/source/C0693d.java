package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

/* renamed from: com.google.android.exoplayer2.source.d */
/* loaded from: classes.dex */
public final class C0693d extends BaseMediaSource {
    @Override // com.google.android.exoplayer2.source.MediaSource
    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final MediaItem getMediaItem() {
        return ConcatenatingMediaSource.f10930w;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public final void prepareSourceInternal(TransferListener transferListener) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void releasePeriod(MediaPeriod mediaPeriod) {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public final void releaseSourceInternal() {
    }
}
