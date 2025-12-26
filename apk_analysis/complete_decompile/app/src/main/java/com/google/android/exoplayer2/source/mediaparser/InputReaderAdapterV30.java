package com.google.android.exoplayer2.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.MediaParser$SeekableInputReader;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;

@RequiresApi(30)
@SuppressLint({"Override"})
/* loaded from: classes.dex */
public final class InputReaderAdapterV30 implements MediaParser$SeekableInputReader {

    /* renamed from: a */
    public DataReader f11586a;

    /* renamed from: b */
    public long f11587b;

    /* renamed from: c */
    public long f11588c;

    /* renamed from: d */
    public long f11589d;

    public long getAndResetSeekPosition() {
        long j = this.f11589d;
        this.f11589d = -1L;
        return j;
    }

    public long getLength() {
        return this.f11587b;
    }

    public long getPosition() {
        return this.f11588c;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = ((DataReader) Util.castNonNull(this.f11586a)).read(bArr, i, i2);
        this.f11588c += read;
        return read;
    }

    public void seekToPosition(long j) {
        this.f11589d = j;
    }

    public void setCurrentPosition(long j) {
        this.f11588c = j;
    }

    public void setDataReader(DataReader dataReader, long j) {
        this.f11586a = dataReader;
        this.f11587b = j;
        this.f11589d = -1L;
    }
}
