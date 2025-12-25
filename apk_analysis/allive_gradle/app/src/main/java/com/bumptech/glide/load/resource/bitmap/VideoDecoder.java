package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.nio.ByteBuffer;
import p000.a23;
import p000.b23;
import p000.d23;
import p000.dx0;
import p000.wd0;
import p000.ye0;

/* loaded from: classes.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;

    /* renamed from: a */
    public final d23 f8923a;

    /* renamed from: b */
    public final BitmapPool f8924b;

    /* renamed from: c */
    public final dx0 f8925c = f8922d;
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a23());
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b23());

    /* renamed from: d */
    public static final dx0 f8922d = new dx0(27);

    public VideoDecoder(BitmapPool bitmapPool, d23 d23Var) {
        this.f8924b = bitmapPool;
        this.f8923a = d23Var;
    }

    /* renamed from: a */
    public static Bitmap m2359a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.NONE) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float scaleFactor = downsampleStrategy.getScaleFactor(parseInt, parseInt2, i2, i3);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * scaleFactor), Math.round(scaleFactor * parseInt2));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                }
            }
        }
        if (bitmap == null) {
            bitmap = mediaMetadataRetriever.getFrameAtTime(j, i);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new RuntimeException("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new dx0(26));
    }

    @RequiresApi(api = 23)
    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new wd0(27));
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new wd0(28));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull T t, int i, int i2, @NonNull Options options) {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException(ye0.m8294n(longValue, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer num = (Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.DEFAULT;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        this.f8925c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f8923a.mo4514h(mediaMetadataRetriever, t);
            Bitmap m2359a = m2359a(mediaMetadataRetriever, longValue, num.intValue(), i, i2, downsampleStrategy2);
            mediaMetadataRetriever.release();
            return BitmapResource.obtain(m2359a, this.f8924b);
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull T t, @NonNull Options options) {
        return true;
    }
}
