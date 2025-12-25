package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a */
    public final Downsampler f8916a;

    /* renamed from: b */
    public final ArrayPool f8917b;

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f8916a = downsampler;
        this.f8917b = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f8917b);
        }
        ExceptionPassthroughInputStream obtain = ExceptionPassthroughInputStream.obtain(recyclableBufferedInputStream);
        try {
            return this.f8916a.decode(new MarkEnforcingInputStream(obtain), i, i2, options, new C0634h(recyclableBufferedInputStream, obtain));
        } finally {
            obtain.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.f8916a.handles(inputStream);
    }
}
