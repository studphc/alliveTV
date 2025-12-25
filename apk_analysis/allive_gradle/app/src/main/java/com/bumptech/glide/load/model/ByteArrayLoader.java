package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a */
    public final Converter f8779a;

    /* loaded from: classes.dex */
    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.bumptech.glide.load.model.ByteArrayLoader$Converter] */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<byte[], ByteBuffer> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Object());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public interface Converter<Data> {
        Data convert(byte[] bArr);

        Class<Data> getDataClass();
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.bumptech.glide.load.model.ByteArrayLoader$Converter] */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<byte[], InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Object());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.f8779a = converter;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull byte[] bArr) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull byte[] bArr, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(bArr), new C0618b(bArr, this.f8779a));
    }
}
