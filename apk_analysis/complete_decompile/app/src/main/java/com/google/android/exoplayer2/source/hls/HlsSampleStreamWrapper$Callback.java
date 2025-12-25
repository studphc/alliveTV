package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.source.SequenceableLoader;
import p000.v01;

/* loaded from: classes.dex */
public interface HlsSampleStreamWrapper$Callback extends SequenceableLoader.Callback<v01> {
    void onPlaylistRefreshRequired(Uri uri);

    void onPrepared();
}
