package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a */
    public final BitmapImageDecoderResourceDecoder f8900a = new BitmapImageDecoderResourceDecoder();

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource(ByteBufferUtil.fromStream(inputStream));
        return this.f8900a.decode2(createSource, i, i2, options);
    }
}
