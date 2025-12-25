package com.bumptech.glide.load.resource;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import p000.AbstractC1534m3;
import p000.y11;

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: a */
    public final HardwareConfigState f8848a = HardwareConfigState.getInstance();

    public abstract Resource<T> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder$OnHeaderDecodedListener imageDecoder$OnHeaderDecodedListener);

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public /* bridge */ /* synthetic */ Resource decode(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull Options options) {
        return decode2(AbstractC1534m3.m6023e(source), i, i2, options);
    }

    /* renamed from: handles, reason: avoid collision after fix types in other method */
    public final boolean handles2(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }

    @Nullable
    /* renamed from: decode, reason: avoid collision after fix types in other method */
    public final Resource<T> decode2(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull Options options) {
        DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
        return decode(source, i, i2, new y11(this, i, i2, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE)));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return handles2(AbstractC1534m3.m6023e(source), options);
    }
}
