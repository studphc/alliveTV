package p000;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

/* renamed from: dg */
/* loaded from: classes.dex */
public final class C1121dg extends DecoderInputBuffer {

    /* renamed from: d */
    public long f16364d;

    /* renamed from: e */
    public int f16365e;

    /* renamed from: f */
    public int f16366f;

    /* renamed from: b */
    public final boolean m4579b(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        Assertions.checkArgument(!decoderInputBuffer.isEncrypted());
        Assertions.checkArgument(!decoderInputBuffer.hasSupplementalData());
        Assertions.checkArgument(!decoderInputBuffer.isEndOfStream());
        int i = this.f16365e;
        if (i > 0) {
            if (i < this.f16366f && decoderInputBuffer.isDecodeOnly() == isDecodeOnly()) {
                ByteBuffer byteBuffer2 = decoderInputBuffer.data;
                if (byteBuffer2 != null && (byteBuffer = this.data) != null) {
                    if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        int i2 = this.f16365e;
        this.f16365e = i2 + 1;
        if (i2 == 0) {
            this.timeUs = decoderInputBuffer.timeUs;
            if (decoderInputBuffer.isKeyFrame()) {
                setFlags(1);
            }
        }
        if (decoderInputBuffer.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = decoderInputBuffer.data;
        if (byteBuffer3 != null) {
            ensureSpaceForWrite(byteBuffer3.remaining());
            this.data.put(byteBuffer3);
        }
        this.f16364d = decoderInputBuffer.timeUs;
        return true;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.Buffer
    public final void clear() {
        super.clear();
        this.f16365e = 0;
    }
}
