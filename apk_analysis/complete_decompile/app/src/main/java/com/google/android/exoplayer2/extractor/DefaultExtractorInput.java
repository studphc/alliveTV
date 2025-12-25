package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DefaultExtractorInput implements ExtractorInput {

    /* renamed from: b */
    public final DataReader f10065b;

    /* renamed from: c */
    public final long f10066c;

    /* renamed from: d */
    public long f10067d;

    /* renamed from: f */
    public int f10069f;

    /* renamed from: g */
    public int f10070g;

    /* renamed from: e */
    public byte[] f10068e = new byte[65536];

    /* renamed from: a */
    public final byte[] f10064a = new byte[4096];

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j, long j2) {
        this.f10065b = dataReader;
        this.f10067d = j;
        this.f10066c = j2;
    }

    /* renamed from: a */
    public final void m2528a(int i) {
        int i2 = this.f10069f + i;
        byte[] bArr = this.f10068e;
        if (i2 > bArr.length) {
            this.f10068e = Arrays.copyOf(this.f10068e, Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) {
        m2528a(i);
        int i2 = this.f10070g - this.f10069f;
        while (i2 < i) {
            i2 = m2529b(this.f10068e, this.f10069f, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.f10070g = this.f10069f + i2;
        }
        this.f10069f += i;
        return true;
    }

    /* renamed from: b */
    public final int m2529b(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (!Thread.interrupted()) {
            int read = this.f10065b.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                if (i3 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i3 + read;
        }
        throw new InterruptedIOException();
    }

    /* renamed from: c */
    public final void m2530c(int i) {
        byte[] bArr;
        int i2 = this.f10070g - i;
        this.f10070g = i2;
        this.f10069f = 0;
        byte[] bArr2 = this.f10068e;
        if (i2 < bArr2.length - 524288) {
            bArr = new byte[65536 + i2];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i, bArr, 0, i2);
        this.f10068e = bArr;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.f10066c;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.f10067d + this.f10069f;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.f10067d;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) {
        int min;
        m2528a(i2);
        int i3 = this.f10070g;
        int i4 = this.f10069f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            min = m2529b(this.f10068e, i4, i2, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f10070g += min;
        } else {
            min = Math.min(i2, i5);
        }
        System.arraycopy(this.f10068e, this.f10069f, bArr, i, min);
        this.f10069f += min;
        return min;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.f10068e, this.f10069f - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        int i3 = this.f10070g;
        int i4 = 0;
        if (i3 != 0) {
            int min = Math.min(i3, i2);
            System.arraycopy(this.f10068e, 0, bArr, i, min);
            m2530c(min);
            i4 = min;
        }
        if (i4 == 0) {
            i4 = m2529b(bArr, i, i2, 0, true);
        }
        if (i4 != -1) {
            this.f10067d += i4;
        }
        return i4;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.f10069f = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f10067d = j;
        throw e;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i) {
        int min = Math.min(this.f10070g, i);
        m2530c(min);
        if (min == 0) {
            byte[] bArr = this.f10064a;
            min = m2529b(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        if (min != -1) {
            this.f10067d += min;
        }
        return min;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) {
        skipFully(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        int min;
        int i3 = this.f10070g;
        if (i3 == 0) {
            min = 0;
        } else {
            min = Math.min(i3, i2);
            System.arraycopy(this.f10068e, 0, bArr, i, min);
            m2530c(min);
        }
        int i4 = min;
        while (i4 < i2 && i4 != -1) {
            i4 = m2529b(bArr, i, i2, i4, z);
        }
        if (i4 != -1) {
            this.f10067d += i4;
        }
        return i4 != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) {
        int min = Math.min(this.f10070g, i);
        m2530c(min);
        int i2 = min;
        while (i2 < i && i2 != -1) {
            byte[] bArr = this.f10064a;
            i2 = m2529b(bArr, -i2, Math.min(i, bArr.length + i2), i2, z);
        }
        if (i2 != -1) {
            this.f10067d += i2;
        }
        return i2 != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) {
        peekFully(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) {
        advancePeekPosition(i, false);
    }
}
