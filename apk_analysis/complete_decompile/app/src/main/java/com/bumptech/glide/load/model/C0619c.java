package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ByteArrayLoader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.c */
/* loaded from: classes.dex */
public final class C0619c implements ByteArrayLoader.Converter {
    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
    public final Object convert(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
    public final Class getDataClass() {
        return InputStream.class;
    }
}
