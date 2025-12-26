package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import p000.e03;

/* loaded from: classes.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull Bitmap bitmap, int i, int i2, @NonNull Options options) {
        return new e03(bitmap);
    }
}
