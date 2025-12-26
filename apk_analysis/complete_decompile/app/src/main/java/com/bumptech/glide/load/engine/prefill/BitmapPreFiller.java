package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import p000.RunnableC1686pg;
import p000.fa0;

/* loaded from: classes.dex */
public final class BitmapPreFiller {

    /* renamed from: a */
    public final MemoryCache f8763a;

    /* renamed from: b */
    public final BitmapPool f8764b;

    /* renamed from: c */
    public final DecodeFormat f8765c;

    /* renamed from: d */
    public RunnableC1686pg f8766d;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f8763a = memoryCache;
        this.f8764b = bitmapPool;
        this.f8765c = decodeFormat;
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        RunnableC1686pg runnableC1686pg = this.f8766d;
        if (runnableC1686pg != null) {
            runnableC1686pg.f25158h = true;
        }
        int length = builderArr.length;
        PreFillType[] preFillTypeArr = new PreFillType[length];
        for (int i = 0; i < builderArr.length; i++) {
            PreFillType.Builder builder = builderArr[i];
            if (builder.f8773c == null) {
                if (this.f8765c == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i] = new PreFillType(builder.f8771a, builder.f8772b, builder.f8773c, builder.f8774d);
        }
        MemoryCache memoryCache = this.f8763a;
        long maxSize = memoryCache.getMaxSize() - memoryCache.getCurrentSize();
        BitmapPool bitmapPool = this.f8764b;
        long maxSize2 = bitmapPool.getMaxSize() + maxSize;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += preFillTypeArr[i3].f8770d;
        }
        float f = ((float) maxSize2) / i2;
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < length; i4++) {
            PreFillType preFillType = preFillTypeArr[i4];
            hashMap.put(preFillType, Integer.valueOf(Math.round(preFillType.f8770d * f) / Util.getBitmapByteSize(preFillType.f8767a, preFillType.f8768b, preFillType.f8769c)));
        }
        RunnableC1686pg runnableC1686pg2 = new RunnableC1686pg(bitmapPool, memoryCache, new fa0(hashMap));
        this.f8766d = runnableC1686pg2;
        Util.postOnUiThread(runnableC1686pg2);
    }
}
