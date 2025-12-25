package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {

    /* renamed from: a */
    public final ModelLoader f8835a;

    /* renamed from: b */
    public final ModelCache f8836b;

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, null);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        GlideUrl glideUrl;
        ModelCache modelCache = this.f8836b;
        if (modelCache != null) {
            glideUrl = (GlideUrl) modelCache.get(model, i, i2);
        } else {
            glideUrl = null;
        }
        if (glideUrl == null) {
            String url = getUrl(model, i, i2, options);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(model, i, i2, options));
            if (modelCache != null) {
                modelCache.put(model, i, i2, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List<String> alternateUrls = getAlternateUrls(model, i, i2, options);
        ModelLoader.LoadData<InputStream> buildLoadData = this.f8835a.buildLoadData(glideUrl, i, i2, options);
        if (buildLoadData != null && !alternateUrls.isEmpty()) {
            Key key = buildLoadData.sourceKey;
            ArrayList arrayList = new ArrayList(alternateUrls.size());
            Iterator<String> it = alternateUrls.iterator();
            while (it.hasNext()) {
                arrayList.add(new GlideUrl(it.next()));
            }
            return new ModelLoader.LoadData<>(key, arrayList, buildLoadData.fetcher);
        }
        return buildLoadData;
    }

    public List<String> getAlternateUrls(Model model, int i, int i2, Options options) {
        return Collections.emptyList();
    }

    @Nullable
    public Headers getHeaders(Model model, int i, int i2, Options options) {
        return Headers.DEFAULT;
    }

    public abstract String getUrl(Model model, int i, int i2, Options options);

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, @Nullable ModelCache<Model, GlideUrl> modelCache) {
        this.f8835a = modelLoader;
        this.f8836b = modelCache;
    }
}
