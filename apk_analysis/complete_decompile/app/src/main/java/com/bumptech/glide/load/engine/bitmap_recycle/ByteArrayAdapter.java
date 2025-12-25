package com.bumptech.glide.load.engine.bitmap_recycle;

import p000.InterfaceC1939wa;

/* loaded from: classes.dex */
public final class ByteArrayAdapter implements InterfaceC1939wa {
    @Override // p000.InterfaceC1939wa
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override // p000.InterfaceC1939wa
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override // p000.InterfaceC1939wa
    public int getArrayLength(byte[] bArr) {
        return bArr.length;
    }

    @Override // p000.InterfaceC1939wa
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
