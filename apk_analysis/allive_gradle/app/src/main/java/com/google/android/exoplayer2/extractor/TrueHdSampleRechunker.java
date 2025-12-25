package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class TrueHdSampleRechunker {

    /* renamed from: a */
    public final byte[] f10099a = new byte[10];

    /* renamed from: b */
    public boolean f10100b;

    /* renamed from: c */
    public int f10101c;

    /* renamed from: d */
    public long f10102d;

    /* renamed from: e */
    public int f10103e;

    /* renamed from: f */
    public int f10104f;

    /* renamed from: g */
    public int f10105g;

    public void outputPendingSampleMetadata(TrackOutput trackOutput, @Nullable TrackOutput.CryptoData cryptoData) {
        if (this.f10101c > 0) {
            trackOutput.sampleMetadata(this.f10102d, this.f10103e, this.f10104f, this.f10105g, cryptoData);
            this.f10101c = 0;
        }
    }

    public void reset() {
        this.f10100b = false;
        this.f10101c = 0;
    }

    public void sampleMetadata(TrackOutput trackOutput, long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
        boolean z;
        if (this.f10105g <= i2 + i3) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (!this.f10100b) {
            return;
        }
        int i4 = this.f10101c;
        int i5 = i4 + 1;
        this.f10101c = i5;
        if (i4 == 0) {
            this.f10102d = j;
            this.f10103e = i;
            this.f10104f = 0;
        }
        this.f10104f += i2;
        this.f10105g = i3;
        if (i5 >= 16) {
            outputPendingSampleMetadata(trackOutput, cryptoData);
        }
    }

    public void startSample(ExtractorInput extractorInput) {
        if (this.f10100b) {
            return;
        }
        byte[] bArr = this.f10099a;
        extractorInput.peekFully(bArr, 0, 10);
        extractorInput.resetPeekPosition();
        if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(bArr) == 0) {
            return;
        }
        this.f10100b = true;
    }
}
