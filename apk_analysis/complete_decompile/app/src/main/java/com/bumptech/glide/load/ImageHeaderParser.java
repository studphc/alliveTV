package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);


        /* renamed from: a */
        public final boolean f8625a;

        ImageType(boolean z) {
            this.f8625a = z;
        }

        public boolean hasAlpha() {
            return this.f8625a;
        }
    }

    int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool);

    int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool);

    @NonNull
    ImageType getType(@NonNull InputStream inputStream);

    @NonNull
    ImageType getType(@NonNull ByteBuffer byteBuffer);
}
