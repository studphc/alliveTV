package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

@WorkerThread
/* loaded from: classes.dex */
public interface DownloadIndex {
    @Nullable
    Download getDownload(String str);

    DownloadCursor getDownloads(int... iArr);
}
