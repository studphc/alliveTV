package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class ByteArrayDataSink implements DataSink {

    /* renamed from: a */
    public ByteArrayOutputStream f12395a;

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        ((ByteArrayOutputStream) Util.castNonNull(this.f12395a)).close();
    }

    @Nullable
    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.f12395a;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) {
        boolean z;
        long j = dataSpec.length;
        if (j == -1) {
            this.f12395a = new ByteArrayOutputStream();
            return;
        }
        if (j <= 2147483647L) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f12395a = new ByteArrayOutputStream((int) dataSpec.length);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        ((ByteArrayOutputStream) Util.castNonNull(this.f12395a)).write(bArr, i, i2);
    }
}
