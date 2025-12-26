package p000;

import com.google.common.io.ByteArrayDataOutput;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: lj */
/* loaded from: classes2.dex */
public final class C1513lj implements ByteArrayDataOutput {

    /* renamed from: a */
    public final DataOutputStream f22518a;

    /* renamed from: b */
    public final ByteArrayOutputStream f22519b;

    public C1513lj(ByteArrayOutputStream byteArrayOutputStream) {
        this.f22519b = byteArrayOutputStream;
        this.f22518a = new DataOutputStream(byteArrayOutputStream);
    }

    @Override // com.google.common.io.ByteArrayDataOutput
    public final byte[] toByteArray() {
        return this.f22519b.toByteArray();
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void write(int i) {
        try {
            this.f22518a.write(i);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeBoolean(boolean z) {
        try {
            this.f22518a.writeBoolean(z);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeByte(int i) {
        try {
            this.f22518a.writeByte(i);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeBytes(String str) {
        try {
            this.f22518a.writeBytes(str);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeChar(int i) {
        try {
            this.f22518a.writeChar(i);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeChars(String str) {
        try {
            this.f22518a.writeChars(str);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeDouble(double d) {
        try {
            this.f22518a.writeDouble(d);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeFloat(float f) {
        try {
            this.f22518a.writeFloat(f);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeInt(int i) {
        try {
            this.f22518a.writeInt(i);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeLong(long j) {
        try {
            this.f22518a.writeLong(j);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeShort(int i) {
        try {
            this.f22518a.writeShort(i);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void writeUTF(String str) {
        try {
            this.f22518a.writeUTF(str);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void write(byte[] bArr) {
        try {
            this.f22518a.write(bArr);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
    public final void write(byte[] bArr, int i, int i2) {
        try {
            this.f22518a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
