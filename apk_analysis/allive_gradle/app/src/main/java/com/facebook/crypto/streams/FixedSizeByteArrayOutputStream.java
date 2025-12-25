package com.facebook.crypto.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class FixedSizeByteArrayOutputStream extends ByteArrayOutputStream {
    public FixedSizeByteArrayOutputStream(int i) {
        super(i);
    }

    public byte[] getBytes() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        if (bArr.length == ((ByteArrayOutputStream) this).count) {
            return bArr;
        }
        throw new IOException("Size supplied is too small");
    }
}
