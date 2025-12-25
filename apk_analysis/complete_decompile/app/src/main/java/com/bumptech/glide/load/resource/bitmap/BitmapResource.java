package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: a */
    public final Bitmap f8858a;

    /* renamed from: b */
    public final BitmapPool f8859b;

    public BitmapResource(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        this.f8858a = (Bitmap) Preconditions.checkNotNull(bitmap, "Bitmap must not be null");
        this.f8859b = (BitmapPool) Preconditions.checkNotNull(bitmapPool, "BitmapPool must not be null");
    }

    @Nullable
    public static BitmapResource obtain(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.f8858a);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.f8858a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.f8859b.put(this.f8858a);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Bitmap get() {
        return this.f8858a;
    }
}
