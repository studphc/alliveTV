package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;

/* renamed from: com.google.android.exoplayer2.source.j */
/* loaded from: classes.dex */
public final class C0704j implements MediaSourceFactory {
    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public final MediaSource createMediaSource(MediaItem mediaItem) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public final int[] getSupportedTypes() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public final MediaSource.Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public final MediaSource.Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        return this;
    }
}
