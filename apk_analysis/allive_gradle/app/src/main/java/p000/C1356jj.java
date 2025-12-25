package p000;

import com.google.common.base.Preconditions;
import java.io.OutputStream;

/* renamed from: jj */
/* loaded from: classes2.dex */
public final class C1356jj extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2 + i, bArr.length);
    }
}
