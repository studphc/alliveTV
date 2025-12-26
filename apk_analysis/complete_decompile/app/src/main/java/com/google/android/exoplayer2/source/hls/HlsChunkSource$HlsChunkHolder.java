package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.chunk.Chunk;

/* loaded from: classes.dex */
public final class HlsChunkSource$HlsChunkHolder {

    @Nullable
    public Chunk chunk;
    public boolean endOfStream;

    @Nullable
    public Uri playlistUrl;

    public HlsChunkSource$HlsChunkHolder() {
        clear();
    }

    public void clear() {
        this.chunk = null;
        this.endOfStream = false;
        this.playlistUrl = null;
    }
}
