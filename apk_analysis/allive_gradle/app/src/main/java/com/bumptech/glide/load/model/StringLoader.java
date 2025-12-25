package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {

    /* renamed from: a */
    public final ModelLoader f8815a;

    /* loaded from: classes.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, AssetFileDescriptor> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<String, ParcelFileDescriptor> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<String, InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.f8815a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull String str) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull String str, int i, int i2, @NonNull Options options) {
        Uri fromFile;
        if (TextUtils.isEmpty(str)) {
            fromFile = null;
        } else if (str.charAt(0) == '/') {
            fromFile = Uri.fromFile(new File(str));
        } else {
            Uri parse = Uri.parse(str);
            fromFile = parse.getScheme() == null ? Uri.fromFile(new File(str)) : parse;
        }
        if (fromFile != null) {
            ModelLoader modelLoader = this.f8815a;
            if (modelLoader.handles(fromFile)) {
                return modelLoader.buildLoadData(fromFile, i, i2, options);
            }
        }
        return null;
    }
}
