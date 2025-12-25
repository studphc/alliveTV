package com.facebook.crypto;

import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.mac.NativeMac;
import com.facebook.crypto.streams.FixedSizeByteArrayOutputStream;
import com.facebook.crypto.streams.NativeMacLayeredInputStream;
import com.facebook.crypto.streams.NativeMacLayeredOutputStream;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import p000.C1540m9;

/* loaded from: classes.dex */
public class Crypto {

    /* renamed from: a */
    public final C1540m9 f9199a;

    /* renamed from: b */
    public final NativeCryptoLibrary f9200b;

    /* renamed from: c */
    public final CryptoAlgoGcm f9201c;

    @Deprecated
    public Crypto(KeyChain keyChain, NativeCryptoLibrary nativeCryptoLibrary) {
        this(keyChain, nativeCryptoLibrary, CryptoConfig.KEY_128);
    }

    public byte[] decrypt(byte[] bArr, Entity entity) {
        int length = bArr.length;
        InputStream cipherInputStream = getCipherInputStream(new ByteArrayInputStream(bArr), entity);
        FixedSizeByteArrayOutputStream fixedSizeByteArrayOutputStream = new FixedSizeByteArrayOutputStream(length - this.f9201c.getCipherMetaDataLength());
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = cipherInputStream.read(bArr2);
            if (read != -1) {
                fixedSizeByteArrayOutputStream.write(bArr2, 0, read);
            } else {
                cipherInputStream.close();
                return fixedSizeByteArrayOutputStream.getBytes();
            }
        }
    }

    public byte[] encrypt(byte[] bArr, Entity entity) {
        FixedSizeByteArrayOutputStream fixedSizeByteArrayOutputStream = new FixedSizeByteArrayOutputStream(this.f9201c.getCipherMetaDataLength() + bArr.length);
        OutputStream cipherOutputStream = getCipherOutputStream(fixedSizeByteArrayOutputStream, entity, null);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return fixedSizeByteArrayOutputStream.getBytes();
    }

    public InputStream getCipherInputStream(InputStream inputStream, Entity entity) {
        return this.f9201c.wrap(inputStream, entity);
    }

    public OutputStream getCipherOutputStream(OutputStream outputStream, Entity entity) {
        return getCipherOutputStream(outputStream, entity, null);
    }

    public InputStream getMacInputStream(InputStream inputStream, Entity entity) {
        boolean z;
        boolean z2;
        byte read = (byte) inputStream.read();
        if (read == 1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgumentForIO(z, "Unexpected mac version " + ((int) read));
        byte read2 = (byte) inputStream.read();
        if (read2 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkArgumentForIO(z2, "Unexpected mac ID " + ((int) read2));
        NativeMac nativeMac = new NativeMac(this.f9200b);
        byte[] macKey = this.f9199a.getMacKey();
        nativeMac.init(macKey, macKey.length);
        byte[] bytes = entity.getBytes();
        nativeMac.update(new byte[]{read}, 0, 1);
        nativeMac.update(new byte[]{1}, 0, 1);
        nativeMac.update(bytes, 0, bytes.length);
        return new NativeMacLayeredInputStream(nativeMac, inputStream);
    }

    public OutputStream getMacOutputStream(OutputStream outputStream, Entity entity) {
        outputStream.write(1);
        outputStream.write(1);
        NativeMac nativeMac = new NativeMac(this.f9200b);
        byte[] macKey = this.f9199a.getMacKey();
        nativeMac.init(macKey, macKey.length);
        byte[] bytes = entity.getBytes();
        nativeMac.update(new byte[]{1}, 0, 1);
        nativeMac.update(new byte[]{1}, 0, 1);
        nativeMac.update(bytes, 0, bytes.length);
        return new NativeMacLayeredOutputStream(nativeMac, outputStream);
    }

    public boolean isAvailable() {
        try {
            this.f9200b.ensureCryptoLoaded();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public Crypto(KeyChain keyChain, NativeCryptoLibrary nativeCryptoLibrary, CryptoConfig cryptoConfig) {
        C1540m9 c1540m9 = new C1540m9(3, keyChain, cryptoConfig);
        this.f9199a = c1540m9;
        this.f9200b = nativeCryptoLibrary;
        this.f9201c = new CryptoAlgoGcm(nativeCryptoLibrary, c1540m9, cryptoConfig);
    }

    public OutputStream getCipherOutputStream(OutputStream outputStream, Entity entity, byte[] bArr) {
        return this.f9201c.wrap(outputStream, entity, bArr);
    }
}
