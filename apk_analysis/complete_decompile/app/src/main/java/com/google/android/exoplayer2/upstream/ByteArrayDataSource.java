package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class ByteArrayDataSource extends BaseDataSource {

    /* renamed from: e */
    public final byte[] f12396e;

    /* renamed from: f */
    public Uri f12397f;

    /* renamed from: g */
    public int f12398g;

    /* renamed from: h */
    public int f12399h;

    /* renamed from: i */
    public boolean f12400i;

    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        Assertions.checkNotNull(bArr);
        Assertions.checkArgument(bArr.length > 0);
        this.f12396e = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f12400i) {
            this.f12400i = false;
            transferEnded();
        }
        this.f12397f = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12397f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        this.f12397f = dataSpec.uri;
        transferInitializing(dataSpec);
        long j = dataSpec.position;
        byte[] bArr = this.f12396e;
        if (j <= bArr.length) {
            this.f12398g = (int) j;
            int length = bArr.length - ((int) j);
            this.f12399h = length;
            long j2 = dataSpec.length;
            if (j2 != -1) {
                this.f12399h = (int) Math.min(length, j2);
            }
            this.f12400i = true;
            transferStarted(dataSpec);
            long j3 = dataSpec.length;
            if (j3 == -1) {
                return this.f12399h;
            }
            return j3;
        }
        throw new DataSourceException(2008);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f12399h;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.f12396e, this.f12398g, bArr, i, min);
        this.f12398g += min;
        this.f12399h -= min;
        bytesTransferred(min);
        return min;
    }
}
