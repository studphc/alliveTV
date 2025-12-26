package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@Beta
/* loaded from: classes2.dex */
public final class HashingOutputStream extends FilterOutputStream {

    /* renamed from: a */
    public final Hasher f15060a;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.f15060a = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    public HashCode hash() {
        return this.f15060a.hash();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        this.f15060a.putByte((byte) i);
        ((FilterOutputStream) this).out.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f15060a.putBytes(bArr, i, i2);
        ((FilterOutputStream) this).out.write(bArr, i, i2);
    }
}
