package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class zv0 extends OutputStream {

    /* renamed from: a */
    public final PrimitiveSink f29525a;

    public zv0(PrimitiveSink primitiveSink) {
        this.f29525a = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f29525a);
        return AbstractC1726qj.m7059o("Funnels.asOutputStream(", valueOf, ")", valueOf.length() + 24);
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f29525a.putByte((byte) i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f29525a.putBytes(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.f29525a.putBytes(bArr, i, i2);
    }
}
