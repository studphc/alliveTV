package com.google.android.exoplayer2.upstream.crypto;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesFlushingCipher {

    /* renamed from: a */
    public final Cipher f12660a;

    /* renamed from: b */
    public final int f12661b;

    /* renamed from: c */
    public final byte[] f12662c;

    /* renamed from: d */
    public final byte[] f12663d;

    /* renamed from: e */
    public int f12664e;

    public AesFlushingCipher(int i, byte[] bArr, long j, long j2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            this.f12660a = cipher;
            int blockSize = cipher.getBlockSize();
            this.f12661b = blockSize;
            this.f12662c = new byte[blockSize];
            this.f12663d = new byte[blockSize];
            long j3 = blockSize;
            long j4 = j2 / j3;
            int i2 = (int) (j2 % j3);
            cipher.init(i, new SecretKeySpec(bArr, Util.splitAtFirst(cipher.getAlgorithm(), "/")[0]), new IvParameterSpec(m3008a(j, j4)));
            if (i2 != 0) {
                updateInPlace(new byte[i2], 0, i2);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static byte[] m3008a(long j, long j2) {
        return ByteBuffer.allocate(16).putLong(j).putLong(j2).array();
    }

    public void update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        boolean z;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        do {
            int i7 = this.f12664e;
            byte[] bArr3 = this.f12663d;
            int i8 = this.f12661b;
            if (i7 > 0) {
                bArr2[i6] = (byte) (bArr[i4] ^ bArr3[i8 - i7]);
                i6++;
                i4++;
                this.f12664e = i7 - 1;
                i5--;
            } else {
                try {
                    int update = this.f12660a.update(bArr, i4, i5, bArr2, i6);
                    if (i5 == update) {
                        return;
                    }
                    int i9 = i5 - update;
                    boolean z2 = true;
                    int i10 = 0;
                    if (i9 < i8) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Assertions.checkState(z);
                    int i11 = i6 + update;
                    int i12 = i8 - i9;
                    this.f12664e = i12;
                    try {
                        if (this.f12660a.update(this.f12662c, 0, i12, this.f12663d, 0) != i8) {
                            z2 = false;
                        }
                        Assertions.checkState(z2);
                        while (i10 < i9) {
                            bArr2[i11] = bArr3[i10];
                            i10++;
                            i11++;
                        }
                        return;
                    } catch (ShortBufferException e) {
                        throw new RuntimeException(e);
                    }
                } catch (ShortBufferException e2) {
                    throw new RuntimeException(e2);
                }
            }
        } while (i5 != 0);
    }

    public void updateInPlace(byte[] bArr, int i, int i2) {
        update(bArr, i, i2, bArr, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AesFlushingCipher(int i, byte[] bArr, @Nullable String str, long j) {
        this(i, bArr, r0, j);
        long j2 = 0;
        if (str != null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                long charAt = j2 ^ str.charAt(i2);
                j2 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
            }
        }
    }
}
