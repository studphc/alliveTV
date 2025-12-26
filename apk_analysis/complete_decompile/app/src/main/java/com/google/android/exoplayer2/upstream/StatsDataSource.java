package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class StatsDataSource implements DataSource {

    /* renamed from: a */
    public final DataSource f12549a;

    /* renamed from: b */
    public long f12550b;

    /* renamed from: c */
    public Uri f12551c = Uri.EMPTY;

    /* renamed from: d */
    public Map f12552d = Collections.emptyMap();

    public StatsDataSource(DataSource dataSource) {
        this.f12549a = (DataSource) Assertions.checkNotNull(dataSource);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12549a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12549a.close();
    }

    public long getBytesRead() {
        return this.f12550b;
    }

    public Uri getLastOpenedUri() {
        return this.f12551c;
    }

    public Map<String, List<String>> getLastResponseHeaders() {
        return this.f12552d;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f12549a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12549a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        this.f12551c = dataSpec.uri;
        this.f12552d = Collections.emptyMap();
        long open = this.f12549a.open(dataSpec);
        this.f12551c = (Uri) Assertions.checkNotNull(getUri());
        this.f12552d = getResponseHeaders();
        return open;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        int read = this.f12549a.read(bArr, i, i2);
        if (read != -1) {
            this.f12550b += read;
        }
        return read;
    }

    public void resetBytesRead() {
        this.f12550b = 0L;
    }
}
