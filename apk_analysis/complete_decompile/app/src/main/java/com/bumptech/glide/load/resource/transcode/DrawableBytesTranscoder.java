package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a */
    public final BitmapPool f8960a;

    /* renamed from: b */
    public final ResourceTranscoder f8961b;

    /* renamed from: c */
    public final ResourceTranscoder f8962c;

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f8960a = bitmapPool;
        this.f8961b = resourceTranscoder;
        this.f8962c = resourceTranscoder2;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<byte[]> transcode(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f8961b.transcode(BitmapResource.obtain(((BitmapDrawable) drawable).getBitmap(), this.f8960a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f8962c.transcode(resource, options);
        }
        return null;
    }
}
