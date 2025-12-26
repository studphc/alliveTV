package com.facebook.crypto;

/* loaded from: classes.dex */
public enum CryptoConfig {
    KEY_128((byte) 1, 16),
    KEY_256((byte) 2, 32);

    public final byte cipherId;
    public final int keyLength;
    public final int ivLength = 12;
    public final int tagLength = 16;

    CryptoConfig(byte b, int i) {
        this.cipherId = b;
        this.keyLength = i;
    }
}
