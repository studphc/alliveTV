package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: w */
/* loaded from: classes2.dex */
public final class C1928w implements Hasher {

    /* renamed from: a */
    public final /* synthetic */ Hasher[] f28021a;

    /* renamed from: b */
    public final /* synthetic */ sz0 f28022b;

    public C1928w(sz0 sz0Var, Hasher[] hasherArr) {
        this.f28022b = sz0Var;
        this.f28021a = hasherArr;
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        byte[] bArr = new byte[this.f28022b.bits() / 8];
        int i = 0;
        for (Hasher hasher : this.f28021a) {
            HashCode hash = hasher.hash();
            i += hash.writeBytesTo(bArr, i, hash.bits() / 8);
        }
        char[] cArr = HashCode.f15057a;
        return new lz0(bArr);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z) {
        putBoolean(z);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b) {
        putByte(b);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer) {
        putBytes(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putChar(char c) {
        putChar(c);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d) {
        putDouble(d);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f) {
        putFloat(f);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putInt(int i) {
        putInt(i);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putLong(long j) {
        putLong(j);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final Hasher putObject(Object obj, Funnel funnel) {
        for (Hasher hasher : this.f28021a) {
            hasher.putObject(obj, funnel);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putShort(short s) {
        putShort(s);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset) {
        putString(charSequence, charset);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence) {
        putUnencodedChars(charSequence);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBoolean(boolean z) {
        for (Hasher hasher : this.f28021a) {
            hasher.putBoolean(z);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        for (Hasher hasher : this.f28021a) {
            hasher.putByte(b);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr) {
        putBytes(bArr);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        for (Hasher hasher : this.f28021a) {
            hasher.putChar(c);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putDouble(double d) {
        for (Hasher hasher : this.f28021a) {
            hasher.putDouble(d);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putFloat(float f) {
        for (Hasher hasher : this.f28021a) {
            hasher.putFloat(f);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        for (Hasher hasher : this.f28021a) {
            hasher.putInt(i);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        for (Hasher hasher : this.f28021a) {
            hasher.putLong(j);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s) {
        for (Hasher hasher : this.f28021a) {
            hasher.putShort(s);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putString(CharSequence charSequence, Charset charset) {
        for (Hasher hasher : this.f28021a) {
            hasher.putString(charSequence, charset);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putUnencodedChars(CharSequence charSequence) {
        for (Hasher hasher : this.f28021a) {
            hasher.putUnencodedChars(charSequence);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i, int i2) {
        putBytes(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr) {
        for (Hasher hasher : this.f28021a) {
            hasher.putBytes(bArr);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        for (Hasher hasher : this.f28021a) {
            hasher.putBytes(bArr, i, i2);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        for (Hasher hasher : this.f28021a) {
            byteBuffer.position(position);
            hasher.putBytes(byteBuffer);
        }
        return this;
    }
}
