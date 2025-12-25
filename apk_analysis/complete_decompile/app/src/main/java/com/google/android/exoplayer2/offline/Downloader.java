package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface Downloader {

    /* loaded from: classes.dex */
    public interface ProgressListener {
        void onProgress(long j, long j2, float f);
    }

    void cancel();

    void download(@Nullable ProgressListener progressListener);

    void remove();
}
