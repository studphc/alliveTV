package p000;

import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class ik2 extends AbstractC0579c3 {

    /* renamed from: d */
    public final int f18448d;

    /* renamed from: e */
    public final int f18449e;

    /* renamed from: f */
    public long f18450f;

    /* renamed from: g */
    public long f18451g;

    /* renamed from: h */
    public long f18452h;

    /* renamed from: i */
    public long f18453i;

    /* renamed from: j */
    public long f18454j;

    /* renamed from: k */
    public long f18455k;

    public ik2(int i, long j, int i2, long j2) {
        super(8);
        this.f18454j = 0L;
        this.f18455k = 0L;
        this.f18448d = i;
        this.f18449e = i2;
        this.f18450f = 8317987319222330741L ^ j;
        this.f18451g = 7237128888997146477L ^ j2;
        this.f18452h = 7816392313619706465L ^ j;
        this.f18453i = 8387220255154660723L ^ j2;
    }

    @Override // p000.AbstractC0579c3
    /* renamed from: a */
    public final HashCode mo2184a() {
        long j = this.f18455k ^ (this.f18454j << 56);
        this.f18455k = j;
        this.f18453i ^= j;
        m5248g(this.f18448d);
        this.f18450f = j ^ this.f18450f;
        this.f18452h ^= 255;
        m5248g(this.f18449e);
        return HashCode.fromLong(((this.f18450f ^ this.f18451g) ^ this.f18452h) ^ this.f18453i);
    }

    @Override // p000.AbstractC0579c3
    /* renamed from: d */
    public final void mo2187d(ByteBuffer byteBuffer) {
        this.f18454j += 8;
        long j = byteBuffer.getLong();
        this.f18453i ^= j;
        m5248g(this.f18448d);
        this.f18450f = j ^ this.f18450f;
    }

    @Override // p000.AbstractC0579c3
    /* renamed from: e */
    public final void mo2188e(ByteBuffer byteBuffer) {
        this.f18454j += byteBuffer.remaining();
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            this.f18455k ^= (byteBuffer.get() & 255) << i;
            i += 8;
        }
    }

    /* renamed from: g */
    public final void m5248g(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            long j = this.f18450f;
            long j2 = this.f18451g;
            this.f18450f = j + j2;
            this.f18452h += this.f18453i;
            this.f18451g = Long.rotateLeft(j2, 13);
            long rotateLeft = Long.rotateLeft(this.f18453i, 16);
            long j3 = this.f18451g;
            long j4 = this.f18450f;
            this.f18451g = j3 ^ j4;
            this.f18453i = rotateLeft ^ this.f18452h;
            long rotateLeft2 = Long.rotateLeft(j4, 32);
            long j5 = this.f18452h;
            long j6 = this.f18451g;
            this.f18452h = j5 + j6;
            this.f18450f = rotateLeft2 + this.f18453i;
            this.f18451g = Long.rotateLeft(j6, 17);
            long rotateLeft3 = Long.rotateLeft(this.f18453i, 21);
            long j7 = this.f18451g;
            long j8 = this.f18452h;
            this.f18451g = j7 ^ j8;
            this.f18453i = rotateLeft3 ^ this.f18450f;
            this.f18452h = Long.rotateLeft(j8, 32);
        }
    }
}
