package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {

    /* renamed from: a */
    public final Transformation f8855a;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f8855a = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(transformation, false));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.f8855a.equals(((BitmapDrawableTransformation) obj).f8855a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f8855a.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<BitmapDrawable> transform(@NonNull Context context, @NonNull Resource<BitmapDrawable> resource, int i, int i2) {
        Resource<BitmapDrawable> transform = this.f8855a.transform(context, resource, i, i2);
        if (transform.get() instanceof BitmapDrawable) {
            return transform;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + transform.get());
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f8855a.updateDiskCacheKey(messageDigest);
    }
}
