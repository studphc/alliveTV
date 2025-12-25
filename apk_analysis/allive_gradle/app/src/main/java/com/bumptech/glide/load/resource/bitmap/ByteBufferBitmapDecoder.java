package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a */
    public final Downsampler f8860a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f8860a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        return this.f8860a.decode(ByteBufferUtil.toStream(byteBuffer), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return this.f8860a.handles(byteBuffer);
    }
}
