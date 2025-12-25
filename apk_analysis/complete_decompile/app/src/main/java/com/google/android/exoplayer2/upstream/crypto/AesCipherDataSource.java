package com.google.android.exoplayer2.upstream.crypto;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class AesCipherDataSource implements DataSource {

    /* renamed from: a */
    public final DataSource f12657a;

    /* renamed from: b */
    public final byte[] f12658b;

    /* renamed from: c */
    public AesFlushingCipher f12659c;

    public AesCipherDataSource(byte[] bArr, DataSource dataSource) {
        this.f12657a = dataSource;
        this.f12658b = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12657a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12659c = null;
        this.f12657a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f12657a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12657a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        long open = this.f12657a.open(dataSpec);
        this.f12659c = new AesFlushingCipher(2, this.f12658b, dataSpec.key, dataSpec.position + dataSpec.uriPositionOffset);
        return open;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int read = this.f12657a.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        ((AesFlushingCipher) Util.castNonNull(this.f12659c)).updateInPlace(bArr, i, read);
        return read;
    }
}
