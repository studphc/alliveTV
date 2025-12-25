package com.facebook.crypto;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface CryptoAlgo {
    int getCipherMetaDataLength();

    InputStream wrap(InputStream inputStream, Entity entity);

    OutputStream wrap(OutputStream outputStream, Entity entity, byte[] bArr);
}
