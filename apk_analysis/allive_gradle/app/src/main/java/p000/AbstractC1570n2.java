package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: n2 */
/* loaded from: classes2.dex */
public abstract class AbstractC1570n2 extends AbstractC1966x0 {
    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashBytes(ByteBuffer byteBuffer) {
        C1496l2 c1496l2 = (C1496l2) newHasher(byteBuffer.remaining());
        c1496l2.f22299a.m6007d(byteBuffer);
        return c1496l2.hash();
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public abstract HashCode hashBytes(byte[] bArr, int i, int i2);

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashInt(int i) {
        byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
        return hashBytes(array, 0, array.length);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashLong(long j) {
        byte[] array = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array();
        return hashBytes(array, 0, array.length);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashString(CharSequence charSequence, Charset charset) {
        byte[] bytes = charSequence.toString().getBytes(charset);
        return hashBytes(bytes, 0, bytes.length);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < length; i++) {
            order.putChar(charSequence.charAt(i));
        }
        byte[] array = order.array();
        return hashBytes(array, 0, array.length);
    }

    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        return newHasher(32);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        return new C1496l2(this, i);
    }
}
