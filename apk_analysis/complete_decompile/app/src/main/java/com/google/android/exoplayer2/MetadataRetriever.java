package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import p000.eo1;

/* loaded from: classes.dex */
public final class MetadataRetriever {
    public static ListenableFuture<TrackGroupArray> retrieveMetadata(Context context, MediaItem mediaItem) {
        eo1 eo1Var = new eo1(new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory().setMp4ExtractorFlags(6)), Clock.DEFAULT);
        eo1Var.f16928c.obtainMessage(0, mediaItem).sendToTarget();
        return eo1Var.f16929d;
    }

    public static ListenableFuture<TrackGroupArray> retrieveMetadata(MediaSource.Factory factory, MediaItem mediaItem) {
        eo1 eo1Var = new eo1(factory, Clock.DEFAULT);
        eo1Var.f16928c.obtainMessage(0, mediaItem).sendToTarget();
        return eo1Var.f16929d;
    }
}
