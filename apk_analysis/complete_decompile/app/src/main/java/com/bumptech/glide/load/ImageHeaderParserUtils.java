package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class ImageHeaderParserUtils {
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int orientation = list.get(i).getOrientation(inputStream, arrayPool);
                if (orientation != -1) {
                    return orientation;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser.ImageType type = list.get(i).getType(inputStream);
                inputStream.reset();
                if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                    return type;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @RequiresApi(21)
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull ArrayPool arrayPool) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser imageHeaderParser = list.get(i);
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                try {
                    int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, arrayPool);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    if (orientation != -1) {
                        return orientation;
                    }
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType type = list.get(i).getType(byteBuffer);
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull ArrayPool arrayPool) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser imageHeaderParser = list.get(i);
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                try {
                    ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                        return type;
                    }
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
