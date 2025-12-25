package p000;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class ua0 extends FilterOutputStream {

    /* renamed from: a */
    public final OutputStream f27164a;

    /* renamed from: b */
    public ByteOrder f27165b;

    public ua0(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f27164a = outputStream;
        this.f27165b = byteOrder;
    }

    /* renamed from: a */
    public final void m7685a(int i) {
        this.f27164a.write(i);
    }

    /* renamed from: b */
    public final void m7686b(int i) {
        ByteOrder byteOrder = this.f27165b;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        OutputStream outputStream = this.f27164a;
        if (byteOrder == byteOrder2) {
            outputStream.write(i & 255);
            outputStream.write((i >>> 8) & 255);
            outputStream.write((i >>> 16) & 255);
            outputStream.write((i >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            outputStream.write((i >>> 24) & 255);
            outputStream.write((i >>> 16) & 255);
            outputStream.write((i >>> 8) & 255);
            outputStream.write(i & 255);
        }
    }

    /* renamed from: c */
    public final void m7687c(short s) {
        ByteOrder byteOrder = this.f27165b;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        OutputStream outputStream = this.f27164a;
        if (byteOrder == byteOrder2) {
            outputStream.write(s & 255);
            outputStream.write((s >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            outputStream.write((s >>> 8) & 255);
            outputStream.write(s & 255);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f27164a.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.f27164a.write(bArr, i, i2);
    }
}
