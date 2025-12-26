package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class TrackEncryptionBox {
    public final TrackOutput.CryptoData cryptoData;

    @Nullable
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;

    @Nullable
    public final String schemeType;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r7.equals(com.google.android.exoplayer2.C0643C.CENC_TYPE_cbc1) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TrackEncryptionBox(boolean z, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        boolean z2;
        boolean z3;
        int i4 = 2;
        char c = 0;
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (bArr2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.checkArgument(z2 ^ z3);
        this.isEncrypted = z;
        this.schemeType = str;
        this.perSampleIvSize = i;
        this.defaultInitializationVector = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    break;
                case 3046671:
                    if (str.equals(C0643C.CENC_TYPE_cbcs)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3049879:
                    if (str.equals(C0643C.CENC_TYPE_cenc)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3049895:
                    if (str.equals(C0643C.CENC_TYPE_cens)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    break;
                default:
                    Log.m3027w("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                case 2:
                case 3:
                    i4 = 1;
                    break;
            }
            this.cryptoData = new TrackOutput.CryptoData(i4, bArr, i2, i3);
        }
        i4 = 1;
        this.cryptoData = new TrackOutput.CryptoData(i4, bArr, i2, i3);
    }
}
