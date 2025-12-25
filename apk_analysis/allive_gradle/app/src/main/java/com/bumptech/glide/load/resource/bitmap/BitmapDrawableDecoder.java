package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a */
    public final ResourceDecoder f8850a;

    /* renamed from: b */
    public final Resources f8851b;

    public BitmapDrawableDecoder(Context context, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(context.getResources(), resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<BitmapDrawable> decode(@NonNull DataType datatype, int i, int i2, @NonNull Options options) {
        return LazyBitmapDrawableResource.obtain(this.f8851b, (Resource<Bitmap>) this.f8850a.decode(datatype, i, i2, options));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull DataType datatype, @NonNull Options options) {
        return this.f8850a.handles(datatype, options);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources, BitmapPool bitmapPool, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(resources, resourceDecoder);
    }

    public BitmapDrawableDecoder(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f8851b = (Resources) Preconditions.checkNotNull(resources);
        this.f8850a = (ResourceDecoder) Preconditions.checkNotNull(resourceDecoder);
    }
}
