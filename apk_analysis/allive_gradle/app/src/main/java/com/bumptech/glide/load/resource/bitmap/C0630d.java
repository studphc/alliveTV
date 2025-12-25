package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* renamed from: com.bumptech.glide.load.resource.bitmap.d */
/* loaded from: classes.dex */
public final class C0630d extends DownsampleStrategy {
    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final float getScaleFactor(int i, int i2, int i3, int i4) {
        return Math.max(i3 / i, i4 / i2);
    }
}
