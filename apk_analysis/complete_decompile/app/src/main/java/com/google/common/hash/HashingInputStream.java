package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
/* loaded from: classes2.dex */
public final class HashingInputStream extends FilterInputStream {

    /* renamed from: a */
    public final Hasher f15059a;

    public HashingInputStream(HashFunction hashFunction, InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.f15059a = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    public HashCode hash() {
        return this.f15059a.hash();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @CanIgnoreReturnValue
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f15059a.putByte((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @CanIgnoreReturnValue
    public int read(byte[] bArr, int i, int i2) {
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read != -1) {
            this.f15059a.putBytes(bArr, i, read);
        }
        return read;
    }
}
