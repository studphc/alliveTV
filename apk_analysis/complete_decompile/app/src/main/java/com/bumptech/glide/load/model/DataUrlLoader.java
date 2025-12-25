package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a */
    public final DataDecoder f8780a;

    /* loaded from: classes.dex */
    public interface DataDecoder<Data> {
        void close(Data data);

        Data decode(String str);

        Class<Data> getDataClass();
    }

    /* loaded from: classes.dex */
    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a */
        public final C0621e f8781a = new Object();

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Model, InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f8781a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f8780a = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new C0620d(model.toString(), this.f8780a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
