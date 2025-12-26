package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* loaded from: classes.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a */
    public final BitmapPool f8852a;

    /* renamed from: b */
    public final ResourceEncoder f8853b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f8852a = bitmapPool;
        this.f8853b = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options options) {
        return this.f8853b.getEncodeStrategy(options);
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull Options options) {
        return this.f8853b.encode(new BitmapResource(resource.get().getBitmap(), this.f8852a), file, options);
    }
}
