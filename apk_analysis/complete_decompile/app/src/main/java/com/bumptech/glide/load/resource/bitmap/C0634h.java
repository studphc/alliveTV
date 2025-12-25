package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.resource.bitmap.h */
/* loaded from: classes.dex */
public final class C0634h implements Downsampler.DecodeCallbacks {

    /* renamed from: a */
    public final RecyclableBufferedInputStream f8926a;

    /* renamed from: b */
    public final ExceptionPassthroughInputStream f8927b;

    public C0634h(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
        this.f8926a = recyclableBufferedInputStream;
        this.f8927b = exceptionPassthroughInputStream;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
    public final void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        IOException exception = this.f8927b.getException();
        if (exception != null) {
            if (bitmap != null) {
                bitmapPool.put(bitmap);
                throw exception;
            }
            throw exception;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
    public final void onObtainBounds() {
        this.f8926a.fixMarkLimit();
    }
}
