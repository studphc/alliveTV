package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import p000.m60;

/* loaded from: classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: a */
    public final Transformation f8877a;

    /* renamed from: b */
    public final boolean f8878b;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.f8877a = transformation;
        this.f8878b = z;
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f8877a.equals(((DrawableTransformation) obj).f8877a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f8877a.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<Drawable> transform(@NonNull Context context, @NonNull Resource<Drawable> resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = resource.get();
        BitmapResource m6082a = m60.m6082a(bitmapPool, drawable, i, i2);
        if (m6082a == null) {
            if (!this.f8878b) {
                return resource;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        Resource transform = this.f8877a.transform(context, m6082a, i, i2);
        if (transform.equals(m6082a)) {
            transform.recycle();
            return resource;
        }
        return LazyBitmapDrawableResource.obtain(context.getResources(), (Resource<Bitmap>) transform);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f8877a.updateDiskCacheKey(messageDigest);
    }
}
