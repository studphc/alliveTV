package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a */
    public final Context f8841a;

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a */
        public final Context f8842a;

        public Factory(Context context) {
            this.f8842a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f8842a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f8841a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Long l;
        if (MediaStoreUtil.isThumbnailSize(i, i2) && (l = (Long) options.get(VideoDecoder.TARGET_FRAME)) != null && l.longValue() == -1) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.buildVideoFetcher(this.f8841a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return MediaStoreUtil.isMediaStoreVideoUri(uri);
    }
}
