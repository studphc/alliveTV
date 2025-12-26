package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* renamed from: com.bumptech.glide.load.resource.bitmap.e */
/* loaded from: classes.dex */
public final class C0631e extends DownsampleStrategy {
    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        if (DownsampleStrategy.f8867a) {
            return DownsampleStrategy.SampleSizeRounding.QUALITY;
        }
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final float getScaleFactor(int i, int i2, int i3, int i4) {
        if (DownsampleStrategy.f8867a) {
            return Math.min(i3 / i, i4 / i2);
        }
        if (Math.max(i2 / i4, i / i3) == 0) {
            return 1.0f;
        }
        return 1.0f / Integer.highestOneBit(r2);
    }
}
