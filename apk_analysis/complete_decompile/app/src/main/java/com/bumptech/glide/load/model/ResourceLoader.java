package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a */
    public final ModelLoader f8808a;

    /* renamed from: b */
    public final Resources f8809b;

    /* loaded from: classes.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        public final Resources f8810a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f8810a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f8810a, multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        public final Resources f8811a;

        public FileDescriptorFactory(Resources resources) {
            this.f8811a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f8811a, multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a */
        public final Resources f8812a;

        public StreamFactory(Resources resources) {
            this.f8812a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f8812a, multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a */
        public final Resources f8813a;

        public UriFactory(Resources resources) {
            this.f8813a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f8813a, UnitModelLoader.getInstance());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f8809b = resources;
        this.f8808a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Integer num) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Integer num, int i, int i2, @NonNull Options options) {
        Uri uri;
        Resources resources = this.f8809b;
        try {
            uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num.intValue()) + '/' + resources.getResourceTypeName(num.intValue()) + '/' + resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.f8808a.buildLoadData(uri, i, i2, options);
    }
}
