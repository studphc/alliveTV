package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import java.nio.ByteBuffer;
import java.util.List;
import p000.C0020aj;
import p000.C0559bj;
import p000.ye0;

/* loaded from: classes.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f */
    public static final C0020aj f8932f = new Object();

    /* renamed from: g */
    public static final C0559bj f8933g = new C0559bj();

    /* renamed from: a */
    public final Context f8934a;

    /* renamed from: b */
    public final List f8935b;

    /* renamed from: c */
    public final C0559bj f8936c;

    /* renamed from: d */
    public final C0020aj f8937d;

    /* renamed from: e */
    public final GifBitmapProvider f8938e;

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get(context).getRegistry().getImageHeaderParsers(), Glide.get(context).getBitmapPool(), Glide.get(context).getArrayPool());
    }

    /* renamed from: b */
    public static int m2361b(GifHeader gifHeader, int i, int i2) {
        int highestOneBit;
        int min = Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder m8302v = ye0.m8302v("Downsampling GIF, sampleSize: ", max, ", target dimens: [", i, "x");
            m8302v.append(i2);
            m8302v.append("], actual dimens: [");
            m8302v.append(gifHeader.getWidth());
            m8302v.append("x");
            m8302v.append(gifHeader.getHeight());
            m8302v.append("]");
            Log.v("BufferGifDecoder", m8302v.toString());
        }
        return max;
    }

    /* renamed from: a */
    public final GifDrawableResource m2362a(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0 && parseHeader.getStatus() == 0) {
                if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                int m2361b = m2361b(parseHeader, i, i2);
                C0020aj c0020aj = this.f8937d;
                GifBitmapProvider gifBitmapProvider = this.f8938e;
                c0020aj.getClass();
                StandardGifDecoder standardGifDecoder = new StandardGifDecoder(gifBitmapProvider, parseHeader, byteBuffer, m2361b);
                standardGifDecoder.setDefaultBitmapConfig(config);
                standardGifDecoder.advance();
                Bitmap nextFrame = standardGifDecoder.getNextFrame();
                if (nextFrame == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                    }
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f8934a, standardGifDecoder, UnitTransformation.get(), i, i2, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                }
                return gifDrawableResource;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser data;
        C0559bj c0559bj = this.f8936c;
        synchronized (c0559bj) {
            try {
                GifHeaderParser gifHeaderParser = (GifHeaderParser) c0559bj.f8031a.poll();
                if (gifHeaderParser == null) {
                    gifHeaderParser = new GifHeaderParser();
                }
                data = gifHeaderParser.setData(byteBuffer);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            return m2362a(byteBuffer, i, i2, data, options);
        } finally {
            this.f8936c.m2102a(data);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.f8935b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        C0020aj c0020aj = f8932f;
        this.f8934a = context.getApplicationContext();
        this.f8935b = list;
        this.f8937d = c0020aj;
        this.f8938e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f8936c = f8933g;
    }
}
