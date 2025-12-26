package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ByteArrayLoader;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.a */
/* loaded from: classes.dex */
public final class C0617a implements ByteArrayLoader.Converter {
    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
    public final Object convert(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
    public final Class getDataClass() {
        return ByteBuffer.class;
    }
}
