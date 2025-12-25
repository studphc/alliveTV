package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.io.InputStream;

/* loaded from: classes.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public static final Option<Integer> TIMEOUT = Option.memory("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS));

    /* renamed from: a */
    public final ModelCache f8837a;

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a */
        public final ModelCache f8838a = new ModelCache(500);

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f8838a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public HttpGlideUrlLoader(@Nullable ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.f8837a = modelCache;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull GlideUrl glideUrl, int i, int i2, @NonNull Options options) {
        ModelCache modelCache = this.f8837a;
        if (modelCache != null) {
            GlideUrl glideUrl2 = (GlideUrl) modelCache.get(glideUrl, 0, 0);
            if (glideUrl2 == null) {
                modelCache.put(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = glideUrl2;
            }
        }
        return new ModelLoader.LoadData<>(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.get(TIMEOUT)).intValue()));
    }
}
