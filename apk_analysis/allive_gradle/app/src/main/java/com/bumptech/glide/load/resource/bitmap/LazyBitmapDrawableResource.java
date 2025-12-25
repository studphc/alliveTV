package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: a */
    public final Resources f8901a;

    /* renamed from: b */
    public final Resource f8902b;

    public LazyBitmapDrawableResource(Resources resources, Resource resource) {
        this.f8901a = (Resources) Preconditions.checkNotNull(resources);
        this.f8902b = (Resource) Preconditions.checkNotNull(resource);
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(context.getResources(), BitmapResource.obtain(bitmap, Glide.get(context).getBitmapPool()));
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f8902b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Resource resource = this.f8902b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.f8902b.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f8901a, (Bitmap) this.f8902b.get());
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(resources, BitmapResource.obtain(bitmap, bitmapPool));
    }

    @Nullable
    public static Resource<BitmapDrawable> obtain(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }
}
