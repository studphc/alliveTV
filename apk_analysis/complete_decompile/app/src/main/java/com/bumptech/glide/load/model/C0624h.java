package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.FileLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.h */
/* loaded from: classes.dex */
public final class C0624h implements FileLoader.FileOpener {
    @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
    public final void close(Object obj) {
        ((InputStream) obj).close();
    }

    @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
    public final Class getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
    public final Object open(File file) {
        return new FileInputStream(file);
    }
}
