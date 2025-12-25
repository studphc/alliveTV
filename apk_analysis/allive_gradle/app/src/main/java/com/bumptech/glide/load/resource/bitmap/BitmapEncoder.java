package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {

    /* renamed from: a */
    public final ArrayPool f8856a;
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    public BitmapEncoder(@NonNull ArrayPool arrayPool) {
        this.f8856a = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0087 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #3 {all -> 0x0067, blocks: (B:9:0x0035, B:18:0x0063, B:21:0x0081, B:23:0x0087, B:50:0x00ce, B:48:0x00d1, B:42:0x007c), top: B:8:0x0035 }] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean encode(@NonNull Resource<Bitmap> resource, @NonNull File file, @NonNull Options options) {
        boolean z;
        Bitmap bitmap = resource.get();
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat == null) {
            if (bitmap.hasAlpha()) {
                compressFormat = Bitmap.CompressFormat.PNG;
            } else {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
        }
        GlideTrace.beginSectionFormat("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormat);
        try {
            long logTime = LogTime.getLogTime();
            int intValue = ((Integer) options.get(COMPRESSION_QUALITY)).intValue();
            OutputStream outputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ArrayPool arrayPool = this.f8856a;
                    if (arrayPool != null) {
                        try {
                            outputStream = new BufferedOutputStream(fileOutputStream, arrayPool);
                        } catch (IOException e) {
                            e = e;
                            outputStream = fileOutputStream;
                            if (Log.isLoggable("BitmapEncoder", 3)) {
                                Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            z = false;
                            if (Log.isLoggable("BitmapEncoder", 2)) {
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            outputStream = fileOutputStream;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        outputStream = fileOutputStream;
                    }
                    bitmap.compress(compressFormat, intValue, outputStream);
                    outputStream.close();
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                    z = true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + Util.getBitmapByteSize(bitmap) + " in " + LogTime.getElapsedMillis(logTime) + ", options format: " + options.get(COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } finally {
            GlideTrace.endSection();
        }
    }

    @Deprecated
    public BitmapEncoder() {
        this.f8856a = null;
    }
}
