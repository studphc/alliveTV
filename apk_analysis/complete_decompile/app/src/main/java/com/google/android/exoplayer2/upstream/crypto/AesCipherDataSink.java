package com.google.android.exoplayer2.upstream.crypto;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class AesCipherDataSink implements DataSink {

    /* renamed from: a */
    public final DataSink f12653a;

    /* renamed from: b */
    public final byte[] f12654b;

    /* renamed from: c */
    public final byte[] f12655c;

    /* renamed from: d */
    public AesFlushingCipher f12656d;

    public AesCipherDataSink(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        this.f12656d = null;
        this.f12653a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) {
        this.f12653a.open(dataSpec);
        this.f12656d = new AesFlushingCipher(1, this.f12654b, dataSpec.key, dataSpec.position + dataSpec.uriPositionOffset);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        DataSink dataSink = this.f12653a;
        byte[] bArr2 = this.f12655c;
        if (bArr2 == null) {
            ((AesFlushingCipher) Util.castNonNull(this.f12656d)).updateInPlace(bArr, i, i2);
            dataSink.write(bArr, i, i2);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i2 - i3, bArr2.length);
            ((AesFlushingCipher) Util.castNonNull(this.f12656d)).update(bArr, i + i3, min, this.f12655c, 0);
            dataSink.write(bArr2, 0, min);
            i3 += min;
        }
    }

    public AesCipherDataSink(byte[] bArr, DataSink dataSink, @Nullable byte[] bArr2) {
        this.f12653a = dataSink;
        this.f12654b = bArr;
        this.f12655c = bArr2;
    }
}
