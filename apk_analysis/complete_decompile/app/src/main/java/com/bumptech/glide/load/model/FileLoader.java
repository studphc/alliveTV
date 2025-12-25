package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a */
    public final FileOpener f8782a;

    /* loaded from: classes.dex */
    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a */
        public final FileOpener f8783a;

        public Factory(FileOpener<Data> fileOpener) {
            this.f8783a = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public final ModelLoader<File, Data> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f8783a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.bumptech.glide.load.model.FileLoader$FileOpener] */
        public FileDescriptorFactory() {
            super(new Object());
        }
    }

    /* loaded from: classes.dex */
    public interface FileOpener<Data> {
        void close(Data data);

        Class<Data> getDataClass();

        Data open(File file);
    }

    /* loaded from: classes.dex */
    public static class StreamFactory extends Factory<InputStream> {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.bumptech.glide.load.model.FileLoader$FileOpener] */
        public StreamFactory() {
            super(new Object());
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.f8782a = fileOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new C0623g(file, this.f8782a));
    }
}
