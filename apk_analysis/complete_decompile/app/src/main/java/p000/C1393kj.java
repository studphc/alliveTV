package p000;

import com.google.common.io.ByteArrayDataInput;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: kj */
/* loaded from: classes2.dex */
public final class C1393kj implements ByteArrayDataInput {

    /* renamed from: a */
    public final DataInputStream f20864a;

    public C1393kj(ByteArrayInputStream byteArrayInputStream) {
        this.f20864a = new DataInputStream(byteArrayInputStream);
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final boolean readBoolean() {
        try {
            return this.f20864a.readBoolean();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final byte readByte() {
        try {
            return this.f20864a.readByte();
        } catch (EOFException e) {
            throw new IllegalStateException(e);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final char readChar() {
        try {
            return this.f20864a.readChar();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final double readDouble() {
        try {
            return this.f20864a.readDouble();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final float readFloat() {
        try {
            return this.f20864a.readFloat();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final void readFully(byte[] bArr) {
        try {
            this.f20864a.readFully(bArr);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final int readInt() {
        try {
            return this.f20864a.readInt();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final String readLine() {
        try {
            return this.f20864a.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final long readLong() {
        try {
            return this.f20864a.readLong();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final short readShort() {
        try {
            return this.f20864a.readShort();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final String readUTF() {
        try {
            return this.f20864a.readUTF();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final int readUnsignedByte() {
        try {
            return this.f20864a.readUnsignedByte();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final int readUnsignedShort() {
        try {
            return this.f20864a.readUnsignedShort();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final int skipBytes(int i) {
        try {
            return this.f20864a.skipBytes(i);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        try {
            this.f20864a.readFully(bArr, i, i2);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
