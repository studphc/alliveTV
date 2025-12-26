package com.bumptech.glide.integration.okhttp3;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: a */
    public final Call.Factory f8618a;

    public OkHttpUrlLoader(@NonNull Call.Factory factory) {
        this.f8618a = factory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull GlideUrl glideUrl) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull GlideUrl glideUrl, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(glideUrl, new OkHttpStreamFetcher(this.f8618a, glideUrl));
    }

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: b */
        public static volatile OkHttpClient f8619b;

        /* renamed from: a */
        public final Call.Factory f8620a;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory() {
            this(f8619b);
            if (f8619b == null) {
                synchronized (Factory.class) {
                    try {
                        if (f8619b == null) {
                            f8619b = new OkHttpClient();
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.f8620a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(@NonNull Call.Factory factory) {
            this.f8620a = factory;
        }
    }
}
