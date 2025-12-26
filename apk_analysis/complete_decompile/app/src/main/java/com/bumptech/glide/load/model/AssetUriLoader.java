package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: a */
    public final AssetManager f8775a;

    /* renamed from: b */
    public final AssetFetcherFactory f8776b;

    /* loaded from: classes.dex */
    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> buildFetcher(AssetManager assetManager, String str);
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {

        /* renamed from: a */
        public final AssetManager f8777a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f8777a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f8777a, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher<ParcelFileDescriptor> buildFetcher(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {

        /* renamed from: a */
        public final AssetManager f8778a;

        public StreamFactory(AssetManager assetManager) {
            this.f8778a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f8778a, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher<InputStream> buildFetcher(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.f8775a = assetManager;
        this.f8776b = assetFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.f8776b.buildFetcher(this.f8775a, uri.toString().substring(22)));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
