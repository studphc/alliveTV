package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface DataSource extends DataReader {

    /* loaded from: classes.dex */
    public interface Factory {
        DataSource createDataSource();
    }

    void addTransferListener(TransferListener transferListener);

    void close();

    Map<String, List<String>> getResponseHeaders();

    @Nullable
    Uri getUri();

    long open(DataSpec dataSpec);
}
