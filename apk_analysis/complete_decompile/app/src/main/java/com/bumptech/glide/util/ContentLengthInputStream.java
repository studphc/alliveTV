package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a */
    public final long f9160a;

    /* renamed from: b */
    public int f9161b;

    public ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.f9160a = j;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    /* renamed from: a */
    public final void m2396a(int i) {
        if (i >= 0) {
            this.f9161b += i;
            return;
        }
        long j = this.f9161b;
        long j2 = this.f9160a;
        if (j2 - j <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j2 + ", but read: " + this.f9161b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f9160a - this.f9161b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        m2396a(read >= 0 ? 1 : -1);
        return read;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        int parseInt;
        if (!TextUtils.isEmpty(str)) {
            try {
                parseInt = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (Log.isLoggable("ContentLengthStream", 3)) {
                    Log.d("ContentLengthStream", "failed to parse content length header: " + str, e);
                }
            }
            return obtain(inputStream, parseInt);
        }
        parseInt = -1;
        return obtain(inputStream, parseInt);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        read = super.read(bArr, i, i2);
        m2396a(read);
        return read;
    }
}
