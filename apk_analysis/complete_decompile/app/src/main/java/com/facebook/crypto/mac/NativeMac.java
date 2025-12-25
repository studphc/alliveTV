package com.facebook.crypto.mac;

import com.facebook.crypto.proguard.annotations.DoNotStrip;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.IOException;

@DoNotStrip
/* loaded from: classes.dex */
public class NativeMac {
    public static final String FAILURE = "Failure";
    public static final int KEY_LENGTH = 64;

    /* renamed from: a */
    public int f9218a = 1;

    /* renamed from: b */
    public final NativeCryptoLibrary f9219b;

    @DoNotStrip
    private long mCtxPtr;

    public NativeMac(NativeCryptoLibrary nativeCryptoLibrary) {
        this.f9219b = nativeCryptoLibrary;
    }

    private native int nativeDestroy();

    private native byte[] nativeDoFinal();

    private static native int nativeFailure();

    private native int nativeGetMacLength();

    private native int nativeInit(byte[] bArr, int i);

    private native int nativeUpdate(byte b);

    private native int nativeUpdate(byte[] bArr, int i, int i2);

    public void destroy() {
        boolean z;
        if (this.f9218a == 3) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z, "Mac has not been finalized");
        if (nativeDestroy() != nativeFailure()) {
            this.f9218a = 1;
            return;
        }
        throw new IOException("Failure");
    }

    public byte[] doFinal() {
        boolean z;
        if (this.f9218a == 2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z, "Mac has not been initialized");
        this.f9218a = 3;
        byte[] nativeDoFinal = nativeDoFinal();
        if (nativeDoFinal != null) {
            return nativeDoFinal;
        }
        throw new IOException("Failure");
    }

    public int getMacLength() {
        return nativeGetMacLength();
    }

    public void init(byte[] bArr, int i) {
        boolean z = true;
        if (this.f9218a != 1) {
            z = false;
        }
        Assertions.checkState(z, "Mac has already been initialized");
        this.f9219b.ensureCryptoLoaded();
        if (nativeInit(bArr, i) != nativeFailure()) {
            this.f9218a = 2;
            return;
        }
        throw new IOException("Failure");
    }

    public void update(byte b) {
        Assertions.checkState(this.f9218a == 2, "Mac has not been initialized");
        if (nativeUpdate(b) == nativeFailure()) {
            throw new IOException("Failure");
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        Assertions.checkState(this.f9218a == 2, "Mac has not been initialized");
        if (nativeUpdate(bArr, i, i2) == nativeFailure()) {
            throw new IOException("Failure");
        }
    }
}
