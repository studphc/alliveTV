package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a */
    public final RecyclableBufferedInputStream f8652a;

    /* loaded from: classes.dex */
    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a */
        public final ArrayPool f8653a;

        public Factory(ArrayPool arrayPool) {
            this.f8653a = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f8653a);
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f8652a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.f8652a.release();
    }

    public void fixMarkLimits() {
        this.f8652a.fixMarkLimit();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    public InputStream rewindAndGet() {
        RecyclableBufferedInputStream recyclableBufferedInputStream = this.f8652a;
        recyclableBufferedInputStream.reset();
        return recyclableBufferedInputStream;
    }
}
