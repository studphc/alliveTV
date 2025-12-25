package p000;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes.dex */
public final class u00 implements v00, yn1 {

    /* renamed from: a */
    public final ByteBuffer f27054a;

    public u00(byte[] bArr, int i) {
        this.f27054a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
    }

    @Override // p000.yn1
    /* renamed from: a */
    public int mo7516a() {
        return this.f27054a.getInt();
    }

    @Override // p000.yn1
    /* renamed from: b */
    public long mo7517b() {
        return this.f27054a.getInt() & 4294967295L;
    }

    /* renamed from: c */
    public short m7518c(int i) {
        ByteBuffer byteBuffer = this.f27054a;
        if (byteBuffer.remaining() - i >= 2) {
            return byteBuffer.getShort(i);
        }
        return (short) -1;
    }

    @Override // p000.v00
    /* renamed from: d */
    public int mo1987d() {
        return (mo1991h() << 8) | mo1991h();
    }

    @Override // p000.yn1
    public long getPosition() {
        return this.f27054a.position();
    }

    @Override // p000.v00
    /* renamed from: h */
    public short mo1991h() {
        ByteBuffer byteBuffer = this.f27054a;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    }

    @Override // p000.v00
    /* renamed from: i */
    public int mo1992i(int i, byte[] bArr) {
        ByteBuffer byteBuffer = this.f27054a;
        int min = Math.min(i, byteBuffer.remaining());
        if (min == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, min);
        return min;
    }

    @Override // p000.yn1
    public int readUnsignedShort() {
        return this.f27054a.getShort() & UShort.MAX_VALUE;
    }

    @Override // p000.yn1
    public void skip(int i) {
        ByteBuffer byteBuffer = this.f27054a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    @Override // p000.v00
    public long skip(long j) {
        ByteBuffer byteBuffer = this.f27054a;
        int min = (int) Math.min(byteBuffer.remaining(), j);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    public u00(ByteBuffer byteBuffer, int i) {
        switch (i) {
            case 2:
                this.f27054a = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                return;
            default:
                this.f27054a = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                return;
        }
    }
}
