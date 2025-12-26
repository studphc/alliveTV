package com.facebook.crypto.keygen;

import com.facebook.crypto.util.NativeCryptoLibrary;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class PasswordBasedKeyDerivation {
    public static final int DEFAULT_ITERATIONS = 4096;
    public static final int DEFAULT_KEY_LENGTH = 16;
    public static final int MINIMUM_ITERATIONS = 1;
    public static final int MINIMUM_KEY_LENGTH = 8;

    /* renamed from: a */
    public final NativeCryptoLibrary f9211a;

    /* renamed from: b */
    public final SecureRandom f9212b;

    /* renamed from: d */
    public String f9214d;

    /* renamed from: e */
    public byte[] f9215e;

    /* renamed from: g */
    public byte[] f9217g;

    /* renamed from: c */
    public int f9213c = 4096;

    /* renamed from: f */
    public int f9216f = 16;

    public PasswordBasedKeyDerivation(SecureRandom secureRandom, NativeCryptoLibrary nativeCryptoLibrary) {
        this.f9212b = secureRandom;
        this.f9211a = nativeCryptoLibrary;
    }

    private native int nativePbkdf2(String str, byte[] bArr, int i, byte[] bArr2);

    public byte[] generate() {
        if (this.f9214d != null) {
            if (this.f9215e == null) {
                byte[] bArr = new byte[16];
                this.f9215e = bArr;
                this.f9212b.nextBytes(bArr);
            }
            this.f9217g = new byte[this.f9216f];
            this.f9211a.ensureCryptoLoaded();
            if (nativePbkdf2(this.f9214d, this.f9215e, this.f9213c, this.f9217g) == 1) {
                return this.f9217g;
            }
            throw new RuntimeException("Native PBKDF2 failed...");
        }
        throw new IllegalStateException("Password was not set");
    }

    public byte[] getGeneratedKey() {
        return this.f9217g;
    }

    public int getIterations() {
        return this.f9213c;
    }

    public int getKeyLengthInBytes() {
        return this.f9216f;
    }

    public String getPassword() {
        return this.f9214d;
    }

    public byte[] getSalt() {
        return this.f9215e;
    }

    public PasswordBasedKeyDerivation setIterations(int i) {
        if (i >= 1) {
            this.f9213c = i;
            return this;
        }
        throw new IllegalArgumentException("Iterations cannot be less than 1");
    }

    public PasswordBasedKeyDerivation setKeyLengthInBytes(int i) {
        if (i >= 8) {
            this.f9216f = i;
            return this;
        }
        throw new IllegalArgumentException("Key length cannot be less than 8 bytes");
    }

    public PasswordBasedKeyDerivation setPassword(String str) {
        if (str != null) {
            this.f9214d = str;
            return this;
        }
        throw new IllegalArgumentException("Password cannot be null");
    }

    public PasswordBasedKeyDerivation setSalt(byte[] bArr) {
        if (bArr != null && bArr.length < 4) {
            throw new IllegalArgumentException("Salt cannot be shorter than 8 bytes");
        }
        this.f9215e = bArr;
        return this;
    }
}
