package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import p000.f03;

/* loaded from: classes.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a */
    public static final UnitModelLoader f8816a = new UnitModelLoader();

    /* loaded from: classes.dex */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a */
        public static final Factory f8817a = new Factory();

        @Deprecated
        public Factory() {
        }

        public static <T> Factory<T> getInstance() {
            return f8817a;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Model, Model> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.getInstance();
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    @Deprecated
    public UnitModelLoader() {
    }

    public static <T> UnitModelLoader<T> getInstance() {
        return f8816a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Model> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new f03(model));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        return true;
    }
}
