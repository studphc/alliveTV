package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class RoundedCorners extends BitmapTransformation {

    /* renamed from: b */
    public static final byte[] f8914b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(Key.CHARSET);

    /* renamed from: a */
    public final int f8915a;

    public RoundedCorners(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "roundingRadius must be greater than 0.");
        this.f8915a = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof RoundedCorners) || this.f8915a != ((RoundedCorners) obj).f8915a) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-569625254, Util.hashCode(this.f8915a));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.f8915a);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f8914b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f8915a).array());
    }
}
