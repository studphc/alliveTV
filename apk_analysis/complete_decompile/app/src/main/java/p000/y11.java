package p000;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* loaded from: classes.dex */
public final class y11 implements ImageDecoder$OnHeaderDecodedListener {

    /* renamed from: a */
    public final /* synthetic */ int f28797a;

    /* renamed from: b */
    public final /* synthetic */ int f28798b;

    /* renamed from: c */
    public final /* synthetic */ boolean f28799c;

    /* renamed from: d */
    public final /* synthetic */ DecodeFormat f28800d;

    /* renamed from: e */
    public final /* synthetic */ DownsampleStrategy f28801e;

    /* renamed from: f */
    public final /* synthetic */ PreferredColorSpace f28802f;

    /* renamed from: g */
    public final /* synthetic */ ImageDecoderResourceDecoder f28803g;

    public y11(ImageDecoderResourceDecoder imageDecoderResourceDecoder, int i, int i2, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
        this.f28803g = imageDecoderResourceDecoder;
        this.f28797a = i;
        this.f28798b = i2;
        this.f28799c = z;
        this.f28800d = decodeFormat;
        this.f28801e = downsampleStrategy;
        this.f28802f = preferredColorSpace;
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [x11, java.lang.Object] */
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace.Named named2;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        if (this.f28803g.f8848a.isHardwareConfigAllowed(this.f28797a, this.f28798b, this.f28799c, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f28800d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new Object());
        size = imageInfo.getSize();
        int i = this.f28797a;
        if (i == Integer.MIN_VALUE) {
            i = size.getWidth();
        }
        int i2 = this.f28798b;
        if (i2 == Integer.MIN_VALUE) {
            i2 = size.getHeight();
        }
        float scaleFactor = this.f28801e.getScaleFactor(size.getWidth(), size.getHeight(), i, i2);
        int round = Math.round(size.getWidth() * scaleFactor);
        int round2 = Math.round(size.getHeight() * scaleFactor);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
        }
        imageDecoder.setTargetSize(round, round2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            if (this.f28802f == PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named2 = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named2);
                        imageDecoder.setTargetColorSpace(colorSpace2);
                        return;
                    }
                }
            }
            named2 = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named2);
            imageDecoder.setTargetColorSpace(colorSpace2);
            return;
        }
        if (i3 >= 26) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            imageDecoder.setTargetColorSpace(colorSpace);
        }
    }
}
