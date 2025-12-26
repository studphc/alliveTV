package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import p000.vm1;

/* loaded from: classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a */
    public final Context f8797a;

    /* loaded from: classes.dex */
    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a */
        public final Context f8798a;

        public Factory(Context context) {
            this.f8798a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f8798a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f8797a = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<File> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new vm1(this.f8797a, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return MediaStoreUtil.isMediaStoreUri(uri);
    }
}
