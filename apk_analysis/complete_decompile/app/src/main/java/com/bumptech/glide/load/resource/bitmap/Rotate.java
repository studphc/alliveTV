package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class Rotate extends BitmapTransformation {

    /* renamed from: b */
    public static final byte[] f8912b = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(Key.CHARSET);

    /* renamed from: a */
    public final int f8913a;

    public Rotate(int i) {
        this.f8913a = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof Rotate) || this.f8913a != ((Rotate) obj).f8913a) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.f8913a));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.rotateImage(bitmap, this.f8913a);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f8912b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f8913a).array());
    }
}
