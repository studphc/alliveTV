package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.DataSpec;
import p000.dx0;

/* loaded from: classes.dex */
public interface MediaChunkIterator {
    public static final MediaChunkIterator EMPTY = new dx0(20);

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    DataSpec getDataSpec();

    boolean isEnded();

    boolean next();

    void reset();
}
