package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.FileLoader;
import java.io.File;

/* renamed from: com.bumptech.glide.load.model.f */
/* loaded from: classes.dex */
public final class C0622f implements FileLoader.FileOpener {
    @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
    public final void close(Object obj) {
        ((ParcelFileDescriptor) obj).close();
    }

    @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
    public final Class getDataClass() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
    public final Object open(File file) {
        return ParcelFileDescriptor.open(file, 268435456);
    }
}
