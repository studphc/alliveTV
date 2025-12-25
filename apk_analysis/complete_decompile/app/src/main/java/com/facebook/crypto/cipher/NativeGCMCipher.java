package com.facebook.crypto.cipher;

import com.facebook.crypto.proguard.annotations.DoNotStrip;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import p000.ye0;

@DoNotStrip
/* loaded from: classes.dex */
public class NativeGCMCipher {
    public static final String FAILURE = "Failure";

    /* renamed from: a */
    public int f9209a = 1;

    /* renamed from: b */
    public final NativeCryptoLibrary f9210b;

    @DoNotStrip
    private long mCtxPtr;

    public NativeGCMCipher(NativeCryptoLibrary nativeCryptoLibrary) {
        this.f9210b = nativeCryptoLibrary;
    }

    private native int nativeDecryptFinal(byte[] bArr, int i);

    private native int nativeDecryptInit(byte[] bArr, byte[] bArr2);

    private native int nativeDestroy();

    private native int nativeEncryptFinal(byte[] bArr, int i);

    private native int nativeEncryptInit(byte[] bArr, byte[] bArr2);

    private static native int nativeFailure();

    private native int nativeGetCipherBlockSize();

    private native int nativeUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    private native int nativeUpdateAad(byte[] bArr, int i);

    /* renamed from: a */
    public final void m2405a() {
        boolean z;
        int i = this.f9209a;
        if (i != 3 && i != 2) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z, "Cipher has not been initialized");
    }

    public void decryptFinal(byte[] bArr, int i) {
        boolean z;
        if (this.f9209a == 3) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z, "Cipher has not been initialized");
        this.f9209a = 5;
        if (nativeDecryptFinal(bArr, i) != nativeFailure()) {
        } else {
            throw new NativeGCMCipherException("The message could not be decrypted successfully.It has either been tampered with or the wrong resource is being decrypted.");
        }
    }

    public void decryptInit(byte[] bArr, byte[] bArr2) {
        boolean z = true;
        if (this.f9209a != 1) {
            z = false;
        }
        Assertions.checkState(z, "Cipher has already been initialized");
        this.f9210b.ensureCryptoLoaded();
        if (nativeDecryptInit(bArr, bArr2) != nativeFailure()) {
            this.f9209a = 3;
            return;
        }
        throw new NativeGCMCipherException("decryptInit");
    }

    public void destroy() {
        boolean z;
        int i = this.f9209a;
        if (i != 5 && i != 4) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z, "Cipher has not been finalized");
        if (nativeDestroy() != nativeFailure()) {
            this.f9209a = 1;
            return;
        }
        throw new NativeGCMCipherException("destroy");
    }

    public void encryptFinal(byte[] bArr, int i) {
        boolean z;
        if (this.f9209a == 2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z, "Cipher has not been initialized");
        this.f9209a = 4;
        if (nativeEncryptFinal(bArr, i) != nativeFailure()) {
        } else {
            throw new NativeGCMCipherException(ye0.m8291k(i, "encryptFinal: "));
        }
    }

    public void encryptInit(byte[] bArr, byte[] bArr2) {
        boolean z = true;
        if (this.f9209a != 1) {
            z = false;
        }
        Assertions.checkState(z, "Cipher has already been initialized");
        this.f9210b.ensureCryptoLoaded();
        if (nativeEncryptInit(bArr, bArr2) != nativeFailure()) {
            this.f9209a = 2;
            return;
        }
        throw new NativeGCMCipherException("encryptInit");
    }

    public int getCipherBlockSize() {
        m2405a();
        return nativeGetCipherBlockSize();
    }

    public int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        m2405a();
        int nativeUpdate = nativeUpdate(bArr, i, i2, bArr2, i3);
        if (nativeUpdate >= 0) {
            return nativeUpdate;
        }
        StringBuilder m8302v = ye0.m8302v("update: Offset = ", i, "; DataLen = ", i2, "; Result = ");
        m8302v.append(nativeUpdate);
        throw new NativeGCMCipherException(m8302v.toString());
    }

    public void updateAad(byte[] bArr, int i) {
        m2405a();
        if (nativeUpdateAad(bArr, i) >= 0) {
        } else {
            throw new NativeGCMCipherException(ye0.m8291k(i, "updateAAd: DataLen = "));
        }
    }
}
