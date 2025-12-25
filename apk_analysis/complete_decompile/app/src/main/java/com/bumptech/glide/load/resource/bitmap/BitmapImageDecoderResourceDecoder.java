package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {

    /* renamed from: b */
    public final BitmapPoolAdapter f8857b = new BitmapPoolAdapter();

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public Resource<Bitmap> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder$OnHeaderDecodedListener imageDecoder$OnHeaderDecodedListener) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, imageDecoder$OnHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i + "x" + i2 + "]");
        }
        return new BitmapResource(decodeBitmap, this.f8857b);
    }
}
