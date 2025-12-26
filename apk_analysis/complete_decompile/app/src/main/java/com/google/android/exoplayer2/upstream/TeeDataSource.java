package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class TeeDataSource implements DataSource {

    /* renamed from: a */
    public final DataSource f12553a;

    /* renamed from: b */
    public final DataSink f12554b;

    /* renamed from: c */
    public boolean f12555c;

    /* renamed from: d */
    public long f12556d;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.f12553a = (DataSource) Assertions.checkNotNull(dataSource);
        this.f12554b = (DataSink) Assertions.checkNotNull(dataSink);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12553a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        DataSink dataSink = this.f12554b;
        try {
            this.f12553a.close();
        } finally {
            if (this.f12555c) {
                this.f12555c = false;
                dataSink.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f12553a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12553a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        long open = this.f12553a.open(dataSpec);
        this.f12556d = open;
        if (open == 0) {
            return 0L;
        }
        if (dataSpec.length == -1 && open != -1) {
            dataSpec = dataSpec.subrange(0L, open);
        }
        this.f12555c = true;
        this.f12554b.open(dataSpec);
        return this.f12556d;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (this.f12556d == 0) {
            return -1;
        }
        int read = this.f12553a.read(bArr, i, i2);
        if (read > 0) {
            this.f12554b.write(bArr, i, read);
            long j = this.f12556d;
            if (j != -1) {
                this.f12556d = j - read;
            }
        }
        return read;
    }
}
