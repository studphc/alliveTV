package p000;

import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class lq1 extends AbstractC0579c3 {

    /* renamed from: d */
    public long f22637d;

    /* renamed from: e */
    public long f22638e;

    /* renamed from: f */
    public int f22639f;

    @Override // p000.AbstractC0579c3
    /* renamed from: a */
    public final HashCode mo2184a() {
        long j = this.f22637d;
        long j2 = this.f22639f;
        long j3 = j ^ j2;
        long j4 = j2 ^ this.f22638e;
        long j5 = j3 + j4;
        long j6 = j4 + j5;
        long j7 = (j5 ^ (j5 >>> 33)) * (-49064778989728563L);
        long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
        long j9 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        long j10 = (j9 ^ (j9 >>> 33)) * (-4265267296055464877L);
        long j11 = j10 ^ (j10 >>> 33);
        long j12 = (j8 ^ (j8 >>> 33)) + j11;
        this.f22637d = j12;
        this.f22638e = j11 + j12;
        byte[] array = ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f22637d).putLong(this.f22638e).array();
        char[] cArr = HashCode.f15057a;
        return new lz0(array);
    }

    @Override // p000.AbstractC0579c3
    /* renamed from: d */
    public final void mo2187d(ByteBuffer byteBuffer) {
        long j = byteBuffer.getLong();
        long j2 = byteBuffer.getLong();
        long rotateLeft = (Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
        this.f22637d = rotateLeft;
        long rotateLeft2 = Long.rotateLeft(rotateLeft, 27);
        long j3 = this.f22638e;
        this.f22637d = ((rotateLeft2 + j3) * 5) + 1390208809;
        long rotateLeft3 = (Long.rotateLeft(j2 * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ j3;
        this.f22638e = rotateLeft3;
        this.f22638e = ((Long.rotateLeft(rotateLeft3, 31) + this.f22637d) * 5) + 944331445;
        this.f22639f += 16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001b. Please report as an issue. */
    @Override // p000.AbstractC0579c3
    /* renamed from: e */
    public final void mo2188e(ByteBuffer byteBuffer) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        this.f22639f = byteBuffer.remaining() + this.f22639f;
        long j8 = 0;
        switch (byteBuffer.remaining()) {
            case 1:
                j = 0;
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 2:
                j2 = 0;
                j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 3:
                j3 = 0;
                j2 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j3;
                j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 4:
                j4 = 0;
                j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                j2 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j3;
                j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 5:
                j5 = 0;
                j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                j2 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j3;
                j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 6:
                j6 = 0;
                j5 = (UnsignedBytes.toInt(byteBuffer.get(5)) << 40) ^ j6;
                j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                j2 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j3;
                j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 7:
                j6 = UnsignedBytes.toInt(byteBuffer.get(6)) << 48;
                j5 = (UnsignedBytes.toInt(byteBuffer.get(5)) << 40) ^ j6;
                j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                j2 = (UnsignedBytes.toInt(byteBuffer.get(2)) << 16) ^ j3;
                j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                j7 = j ^ UnsignedBytes.toInt(byteBuffer.get(0));
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 8:
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 9:
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 10:
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 11:
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 12:
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 13:
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(12)) << 32;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 14:
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(13)) << 40;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(12)) << 32;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 15:
                j8 = UnsignedBytes.toInt(byteBuffer.get(14)) << 48;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(13)) << 40;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(12)) << 32;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(11)) << 24;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(10)) << 16;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(9)) << 8;
                j8 ^= UnsignedBytes.toInt(byteBuffer.get(8));
                j7 = byteBuffer.getLong();
                this.f22637d = (Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f22637d;
                this.f22638e ^= Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            default:
                throw new AssertionError("Should never get here.");
        }
    }
}
