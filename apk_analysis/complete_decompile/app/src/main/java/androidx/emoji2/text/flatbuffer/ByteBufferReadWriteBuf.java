package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p000.y82;

/* loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements y82 {

    /* renamed from: a */
    public final ByteBuffer f4246a;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.f4246a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // p000.x82
    public byte[] data() {
        return this.f4246a.array();
    }

    @Override // p000.x82
    public byte get(int i) {
        return this.f4246a.get(i);
    }

    public boolean getBoolean(int i) {
        if (get(i) != 0) {
            return true;
        }
        return false;
    }

    @Override // p000.x82
    public double getDouble(int i) {
        return this.f4246a.getDouble(i);
    }

    @Override // p000.x82
    public float getFloat(int i) {
        return this.f4246a.getFloat(i);
    }

    @Override // p000.x82
    public int getInt(int i) {
        return this.f4246a.getInt(i);
    }

    @Override // p000.x82
    public long getLong(int i) {
        return this.f4246a.getLong(i);
    }

    @Override // p000.x82
    public short getShort(int i) {
        return this.f4246a.getShort(i);
    }

    @Override // p000.x82
    public String getString(int i, int i2) {
        return Utf8Safe.decodeUtf8Buffer(this.f4246a, i, i2);
    }

    @Override // p000.x82
    public int limit() {
        return this.f4246a.limit();
    }

    @Override // p000.y82
    public void put(byte[] bArr, int i, int i2) {
        this.f4246a.put(bArr, i, i2);
    }

    public void putBoolean(boolean z) {
        this.f4246a.put(z ? (byte) 1 : (byte) 0);
    }

    @Override // p000.y82
    public void putDouble(double d) {
        this.f4246a.putDouble(d);
    }

    @Override // p000.y82
    public void putFloat(float f) {
        this.f4246a.putFloat(f);
    }

    @Override // p000.y82
    public void putInt(int i) {
        this.f4246a.putInt(i);
    }

    @Override // p000.y82
    public void putLong(long j) {
        this.f4246a.putLong(j);
    }

    @Override // p000.y82
    public void putShort(short s) {
        this.f4246a.putShort(s);
    }

    public boolean requestCapacity(int i) {
        if (i <= this.f4246a.limit()) {
            return true;
        }
        return false;
    }

    public void set(int i, byte b) {
        requestCapacity(i + 1);
        this.f4246a.put(i, b);
    }

    public void setBoolean(int i, boolean z) {
        set(i, z ? (byte) 1 : (byte) 0);
    }

    public void setDouble(int i, double d) {
        requestCapacity(i + 8);
        this.f4246a.putDouble(i, d);
    }

    public void setFloat(int i, float f) {
        requestCapacity(i + 4);
        this.f4246a.putFloat(i, f);
    }

    public void setInt(int i, int i2) {
        requestCapacity(i + 4);
        this.f4246a.putInt(i, i2);
    }

    public void setLong(int i, long j) {
        requestCapacity(i + 8);
        this.f4246a.putLong(i, j);
    }

    public void setShort(int i, short s) {
        requestCapacity(i + 2);
        this.f4246a.putShort(i, s);
    }

    @Override // p000.y82
    public int writePosition() {
        return this.f4246a.position();
    }

    @Override // p000.y82
    public void put(byte b) {
        this.f4246a.put(b);
    }

    public void set(int i, byte[] bArr, int i2, int i3) {
        requestCapacity((i3 - i2) + i);
        ByteBuffer byteBuffer = this.f4246a;
        int position = byteBuffer.position();
        byteBuffer.position(i);
        byteBuffer.put(bArr, i2, i3);
        byteBuffer.position(position);
    }
}
