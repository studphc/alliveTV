package com.bumptech.glide.load.engine.bitmap_recycle;

import p000.InterfaceC1939wa;

/* loaded from: classes.dex */
public final class IntegerArrayAdapter implements InterfaceC1939wa {
    @Override // p000.InterfaceC1939wa
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override // p000.InterfaceC1939wa
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override // p000.InterfaceC1939wa
    public int getArrayLength(int[] iArr) {
        return iArr.length;
    }

    @Override // p000.InterfaceC1939wa
    public int[] newArray(int i) {
        return new int[i];
    }
}
