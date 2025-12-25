package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* renamed from: com.bumptech.glide.load.resource.bitmap.b */
/* loaded from: classes.dex */
public final class C0628b extends DownsampleStrategy {
    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public final float getScaleFactor(int i, int i2, int i3, int i4) {
        int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
        int i5 = 1;
        if (Math.max(1, Integer.highestOneBit(ceil)) >= ceil) {
            i5 = 0;
        }
        return 1.0f / (r2 << i5);
    }
}
