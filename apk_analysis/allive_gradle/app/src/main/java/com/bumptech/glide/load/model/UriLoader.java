package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b */
    public static final Set f8818b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", FirebaseAnalytics.Param.CONTENT)));

    /* renamed from: a */
    public final LocalUriFetcherFactory f8819a;

    /* loaded from: classes.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {

        /* renamed from: a */
        public final ContentResolver f8820a;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.f8820a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher<AssetFileDescriptor> build(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f8820a, uri);
        }
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {

        /* renamed from: a */
        public final ContentResolver f8821a;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.f8821a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher<ParcelFileDescriptor> build(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f8821a, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* loaded from: classes.dex */
    public interface LocalUriFetcherFactory<Data> {
        DataFetcher<Data> build(Uri uri);
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {

        /* renamed from: a */
        public final ContentResolver f8822a;

        public StreamFactory(ContentResolver contentResolver) {
            this.f8822a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher<InputStream> build(Uri uri) {
            return new StreamLocalUriFetcher(this.f8822a, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.f8819a = localUriFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.f8819a.build(uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return f8818b.contains(uri.getScheme());
    }
}
