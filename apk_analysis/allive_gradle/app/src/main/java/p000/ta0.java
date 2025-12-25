package p000;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class ta0 extends InputStream implements DataInput {

    /* renamed from: e */
    public static final ByteOrder f26739e = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: f */
    public static final ByteOrder f26740f = ByteOrder.BIG_ENDIAN;

    /* renamed from: a */
    public final DataInputStream f26741a;

    /* renamed from: b */
    public ByteOrder f26742b;

    /* renamed from: c */
    public final int f26743c;

    /* renamed from: d */
    public int f26744d;

    public ta0(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    /* renamed from: a */
    public final void m7468a(long j) {
        int i = this.f26744d;
        if (i > j) {
            this.f26744d = 0;
            DataInputStream dataInputStream = this.f26741a;
            dataInputStream.reset();
            dataInputStream.mark(this.f26743c);
        } else {
            j -= i;
        }
        int i2 = (int) j;
        if (skipBytes(i2) == i2) {
        } else {
            throw new IOException("Couldn't seek up to the byteCount");
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f26741a.available();
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f26744d++;
        return this.f26741a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f26744d++;
        return this.f26741a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        int i = this.f26744d + 1;
        this.f26744d = i;
        if (i <= this.f26743c) {
            int read = this.f26741a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f26744d += 2;
        return this.f26741a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        int i3 = this.f26744d + i2;
        this.f26744d = i3;
        if (i3 <= this.f26743c) {
            if (this.f26741a.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int readInt() {
        int i = this.f26744d + 4;
        this.f26744d = i;
        if (i <= this.f26743c) {
            DataInputStream dataInputStream = this.f26741a;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            int read3 = dataInputStream.read();
            int read4 = dataInputStream.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f26742b;
                if (byteOrder == f26739e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f26740f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f26742b);
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        int i = this.f26744d + 8;
        this.f26744d = i;
        if (i <= this.f26743c) {
            DataInputStream dataInputStream = this.f26741a;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            int read3 = dataInputStream.read();
            int read4 = dataInputStream.read();
            int read5 = dataInputStream.read();
            int read6 = dataInputStream.read();
            int read7 = dataInputStream.read();
            int read8 = dataInputStream.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f26742b;
                if (byteOrder == f26739e) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f26740f) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                throw new IOException("Invalid byte order: " + this.f26742b);
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final short readShort() {
        int i = this.f26744d + 2;
        this.f26744d = i;
        if (i <= this.f26743c) {
            DataInputStream dataInputStream = this.f26741a;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f26742b;
                if (byteOrder == f26739e) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f26740f) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f26742b);
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f26744d += 2;
        return this.f26741a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f26744d++;
        return this.f26741a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        int i = this.f26744d + 2;
        this.f26744d = i;
        if (i <= this.f26743c) {
            DataInputStream dataInputStream = this.f26741a;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f26742b;
                if (byteOrder == f26739e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f26740f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f26742b);
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        int min = Math.min(i, this.f26743c - this.f26744d);
        int i2 = 0;
        while (i2 < min) {
            i2 += this.f26741a.skipBytes(min - i2);
        }
        this.f26744d += i2;
        return i2;
    }

    public ta0(InputStream inputStream, ByteOrder byteOrder) {
        this.f26742b = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f26741a = dataInputStream;
        int available = dataInputStream.available();
        this.f26743c = available;
        this.f26744d = 0;
        dataInputStream.mark(available);
        this.f26742b = byteOrder;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int read = this.f26741a.read(bArr, i, i2);
        this.f26744d += read;
        return read;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        int length = this.f26744d + bArr.length;
        this.f26744d = length;
        if (length <= this.f26743c) {
            if (this.f26741a.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
            return;
        }
        throw new EOFException();
    }

    public ta0(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
