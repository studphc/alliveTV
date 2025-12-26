package com.facebook.android.crypto.keychain;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.keychain.KeyChain;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SharedPrefsBackedKeyChain implements KeyChain {

    /* renamed from: a */
    public final CryptoConfig f9196a;

    /* renamed from: b */
    public final SharedPreferences f9197b;

    /* renamed from: c */
    public final FixedSecureRandom f9198c;
    protected byte[] mCipherKey;
    protected byte[] mMacKey;
    protected boolean mSetCipherKey;
    protected boolean mSetMacKey;

    @Deprecated
    public SharedPrefsBackedKeyChain(Context context) {
        this(context, CryptoConfig.KEY_128);
    }

    /* renamed from: a */
    public final byte[] m2404a(int i, String str) {
        SharedPreferences sharedPreferences = this.f9197b;
        String string = sharedPreferences.getString(str, null);
        if (string == null) {
            byte[] bArr = new byte[i];
            this.f9198c.nextBytes(bArr);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, Base64.encodeToString(bArr, 0));
            edit.commit();
            return bArr;
        }
        return Base64.decode(string, 0);
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public synchronized void destroyKeys() {
        try {
            this.mSetCipherKey = false;
            this.mSetMacKey = false;
            byte[] bArr = this.mCipherKey;
            if (bArr != null) {
                Arrays.fill(bArr, (byte) 0);
            }
            byte[] bArr2 = this.mMacKey;
            if (bArr2 != null) {
                Arrays.fill(bArr2, (byte) 0);
            }
            this.mCipherKey = null;
            this.mMacKey = null;
            SharedPreferences.Editor edit = this.f9197b.edit();
            edit.remove("cipher_key");
            edit.remove("mac_key");
            edit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public synchronized byte[] getCipherKey() {
        try {
            if (!this.mSetCipherKey) {
                this.mCipherKey = m2404a(this.f9196a.keyLength, "cipher_key");
            }
            this.mSetCipherKey = true;
        } catch (Throwable th) {
            throw th;
        }
        return this.mCipherKey;
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public byte[] getMacKey() {
        if (!this.mSetMacKey) {
            this.mMacKey = m2404a(64, "mac_key");
        }
        this.mSetMacKey = true;
        return this.mMacKey;
    }

    @Override // com.facebook.crypto.keychain.KeyChain
    public byte[] getNewIV() {
        byte[] bArr = new byte[this.f9196a.ivLength];
        this.f9198c.nextBytes(bArr);
        return bArr;
    }

    public SharedPrefsBackedKeyChain(Context context, CryptoConfig cryptoConfig) {
        this.f9197b = context.getSharedPreferences(cryptoConfig == CryptoConfig.KEY_128 ? "crypto" : "crypto.".concat(String.valueOf(cryptoConfig)), 0);
        this.f9198c = new FixedSecureRandom();
        this.f9196a = cryptoConfig;
    }
}
