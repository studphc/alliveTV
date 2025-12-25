package com.facebook.crypto.keychain;

/* loaded from: classes.dex */
public interface KeyChain {
    void destroyKeys();

    byte[] getCipherKey();

    byte[] getMacKey();

    byte[] getNewIV();
}
