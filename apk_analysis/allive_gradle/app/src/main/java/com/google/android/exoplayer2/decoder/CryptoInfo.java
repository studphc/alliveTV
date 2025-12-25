package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.C1961ww;

/* loaded from: classes.dex */
public final class CryptoInfo {

    /* renamed from: a */
    public final MediaCodec.CryptoInfo f9918a;

    /* renamed from: b */
    public final C1961ww f9919b;
    public int clearBlocks;
    public int encryptedBlocks;

    /* renamed from: iv */
    @Nullable
    public byte[] f9920iv;

    @Nullable
    public byte[] key;
    public int mode;

    @Nullable
    public int[] numBytesOfClearData;

    @Nullable
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    public CryptoInfo() {
        C1961ww c1961ww;
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f9918a = cryptoInfo;
        if (Util.SDK_INT >= 24) {
            c1961ww = new C1961ww(cryptoInfo);
        } else {
            c1961ww = null;
        }
        this.f9919b = c1961ww;
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.f9918a;
    }

    public void increaseClearDataFirstSubSampleBy(int i) {
        if (i == 0) {
            return;
        }
        if (this.numBytesOfClearData == null) {
            int[] iArr = new int[1];
            this.numBytesOfClearData = iArr;
            this.f9918a.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.numBytesOfClearData;
        iArr2[0] = iArr2[0] + i;
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f9920iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.f9918a;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (Util.SDK_INT >= 24) {
            C1961ww c1961ww = (C1961ww) Assertions.checkNotNull(this.f9919b);
            c1961ww.f28356b.set(i3, i4);
            c1961ww.f28355a.setPattern(c1961ww.f28356b);
        }
    }
}
