package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class SimpleDecoderOutputBuffer extends DecoderOutputBuffer {

    /* renamed from: b */
    public final DecoderOutputBuffer.Owner f9936b;

    @Nullable
    public ByteBuffer data;

    public SimpleDecoderOutputBuffer(DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> owner) {
        this.f9936b = owner;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer init(long j, int i) {
        this.timeUs = j;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.data = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i);
        return this.data;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
    public void release() {
        this.f9936b.releaseOutputBuffer(this);
    }
}
