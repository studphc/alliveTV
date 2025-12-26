package com.facebook.crypto;

import com.facebook.crypto.cipher.NativeGCMCipher;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.streams.NativeGCMCipherInputStream;
import com.facebook.crypto.streams.NativeGCMCipherOutputStream;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class CryptoAlgoGcm implements CryptoAlgo {

    /* renamed from: a */
    public final NativeCryptoLibrary f9202a;

    /* renamed from: b */
    public final KeyChain f9203b;

    /* renamed from: c */
    public final CryptoConfig f9204c;

    public CryptoAlgoGcm(NativeCryptoLibrary nativeCryptoLibrary, KeyChain keyChain, CryptoConfig cryptoConfig) {
        this.f9202a = nativeCryptoLibrary;
        this.f9203b = keyChain;
        this.f9204c = cryptoConfig;
    }

    @Override // com.facebook.crypto.CryptoAlgo
    public int getCipherMetaDataLength() {
        CryptoConfig cryptoConfig = this.f9204c;
        return cryptoConfig.ivLength + 2 + cryptoConfig.tagLength;
    }

    @Override // com.facebook.crypto.CryptoAlgo
    public OutputStream wrap(OutputStream outputStream, Entity entity, byte[] bArr) {
        outputStream.write(1);
        CryptoConfig cryptoConfig = this.f9204c;
        outputStream.write(cryptoConfig.cipherId);
        KeyChain keyChain = this.f9203b;
        byte[] newIV = keyChain.getNewIV();
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.f9202a);
        nativeGCMCipher.encryptInit(keyChain.getCipherKey(), newIV);
        outputStream.write(newIV);
        byte[] bytes = entity.getBytes();
        byte[] bArr2 = {cryptoConfig.cipherId};
        nativeGCMCipher.updateAad(new byte[]{1}, 1);
        nativeGCMCipher.updateAad(bArr2, 1);
        nativeGCMCipher.updateAad(bytes, bytes.length);
        return new NativeGCMCipherOutputStream(outputStream, nativeGCMCipher, bArr, cryptoConfig.tagLength);
    }

    @Override // com.facebook.crypto.CryptoAlgo
    public InputStream wrap(InputStream inputStream, Entity entity) {
        byte read = (byte) inputStream.read();
        byte read2 = (byte) inputStream.read();
        Assertions.checkArgumentForIO(read == 1, "Unexpected crypto version " + ((int) read));
        CryptoConfig cryptoConfig = this.f9204c;
        Assertions.checkArgumentForIO(read2 == cryptoConfig.cipherId, "Unexpected cipher ID " + ((int) read2));
        byte[] bArr = new byte[cryptoConfig.ivLength];
        new DataInputStream(inputStream).readFully(bArr);
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.f9202a);
        nativeGCMCipher.decryptInit(this.f9203b.getCipherKey(), bArr);
        byte[] bytes = entity.getBytes();
        nativeGCMCipher.updateAad(new byte[]{read}, 1);
        nativeGCMCipher.updateAad(new byte[]{read2}, 1);
        nativeGCMCipher.updateAad(bytes, bytes.length);
        return new NativeGCMCipherInputStream(inputStream, nativeGCMCipher, cryptoConfig.tagLength);
    }
}
