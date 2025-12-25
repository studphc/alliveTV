package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class GranularRoundedCorners extends BitmapTransformation {

    /* renamed from: e */
    public static final byte[] f8880e = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(Key.CHARSET);

    /* renamed from: a */
    public final float f8881a;

    /* renamed from: b */
    public final float f8882b;

    /* renamed from: c */
    public final float f8883c;

    /* renamed from: d */
    public final float f8884d;

    public GranularRoundedCorners(float f, float f2, float f3, float f4) {
        this.f8881a = f;
        this.f8882b = f2;
        this.f8883c = f3;
        this.f8884d = f4;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof GranularRoundedCorners)) {
            return false;
        }
        GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
        if (this.f8881a != granularRoundedCorners.f8881a || this.f8882b != granularRoundedCorners.f8882b || this.f8883c != granularRoundedCorners.f8883c || this.f8884d != granularRoundedCorners.f8884d) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f8884d, Util.hashCode(this.f8883c, Util.hashCode(this.f8882b, Util.hashCode(-2013597734, Util.hashCode(this.f8881a)))));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.f8881a, this.f8882b, this.f8883c, this.f8884d);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f8880e);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f8881a).putFloat(this.f8882b).putFloat(this.f8883c).putFloat(this.f8884d).array());
    }
}
