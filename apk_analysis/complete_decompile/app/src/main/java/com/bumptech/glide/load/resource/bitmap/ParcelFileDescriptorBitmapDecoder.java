package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a */
    public final Downsampler f8903a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f8903a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public Resource<Bitmap> decode(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @NonNull Options options) {
        return this.f8903a.decode(parcelFileDescriptor, i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull Options options) {
        return this.f8903a.handles(parcelFileDescriptor);
    }
}
