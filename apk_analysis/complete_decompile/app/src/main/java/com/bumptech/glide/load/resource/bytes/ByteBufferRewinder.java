package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* renamed from: a */
    public final ByteBuffer f8928a;

    /* loaded from: classes.dex */
    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<ByteBuffer> build(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f8928a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    public ByteBuffer rewindAndGet() {
        ByteBuffer byteBuffer = this.f8928a;
        byteBuffer.position(0);
        return byteBuffer;
    }
}
