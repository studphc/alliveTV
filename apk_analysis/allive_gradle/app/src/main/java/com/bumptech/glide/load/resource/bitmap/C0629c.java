package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* renamed from: com.bumptech.glide.load.resource.bitmap.c */
/* loaded from: classes.dex */
public final class C0629c extends DownsampleStrategy {
    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        if (getScaleFactor(i, i2, i3, i4) == 1.0f) {
            return DownsampleStrategy.SampleSizeRounding.QUALITY;
        }
        return DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(i, i2, i3, i4);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final float getScaleFactor(int i, int i2, int i3, int i4) {
        return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(i, i2, i3, i4));
    }
}
