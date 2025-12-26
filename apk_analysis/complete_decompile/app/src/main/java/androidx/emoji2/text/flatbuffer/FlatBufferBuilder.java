package androidx.emoji2.text.flatbuffer;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import p000.ye0;

/* loaded from: classes.dex */
public class FlatBufferBuilder {

    /* renamed from: a */
    public ByteBuffer f4247a;

    /* renamed from: b */
    public int f4248b;

    /* renamed from: c */
    public int f4249c;

    /* renamed from: d */
    public int[] f4250d;

    /* renamed from: e */
    public int f4251e;

    /* renamed from: f */
    public boolean f4252f;

    /* renamed from: g */
    public boolean f4253g;

    /* renamed from: h */
    public int f4254h;

    /* renamed from: i */
    public int[] f4255i;

    /* renamed from: j */
    public int f4256j;

    /* renamed from: k */
    public int f4257k;

    /* renamed from: l */
    public boolean f4258l;

    /* renamed from: m */
    public ByteBufferFactory f4259m;

    /* renamed from: n */
    public final Utf8 f4260n;

    /* loaded from: classes.dex */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    /* loaded from: classes.dex */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i) {
            return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory) {
        this(i, byteBufferFactory, null, Utf8.getDefault());
    }

    public static boolean isFieldPresent(Table table, int i) {
        if (table.__offset(i) != 0) {
            return true;
        }
        return false;
    }

    public void Nested(int i) {
        if (i == offset()) {
        } else {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z) {
        prep(1, 0);
        putBoolean(z);
    }

    public void addByte(byte b) {
        prep(1, 0);
        putByte(b);
    }

    public void addDouble(double d) {
        prep(8, 0);
        putDouble(d);
    }

    public void addFloat(float f) {
        prep(4, 0);
        putFloat(f);
    }

    public void addInt(int i) {
        prep(4, 0);
        putInt(i);
    }

    public void addLong(long j) {
        prep(8, 0);
        putLong(j);
    }

    public void addOffset(int i) {
        prep(4, 0);
        putInt((offset() - i) + 4);
    }

    public void addShort(short s) {
        prep(2, 0);
        putShort(s);
    }

    public void addStruct(int i, int i2, int i3) {
        if (i2 != i3) {
            Nested(i2);
            slot(i);
        }
    }

    public void clear() {
        this.f4248b = this.f4247a.capacity();
        this.f4247a.clear();
        this.f4249c = 1;
        while (true) {
            int i = this.f4251e;
            if (i > 0) {
                int[] iArr = this.f4250d;
                int i2 = i - 1;
                this.f4251e = i2;
                iArr[i2] = 0;
            } else {
                this.f4251e = 0;
                this.f4252f = false;
                this.f4253g = false;
                this.f4254h = 0;
                this.f4256j = 0;
                this.f4257k = 0;
                return;
            }
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - length;
        this.f4248b = i;
        byteBuffer.position(i);
        this.f4247a.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t, int[] iArr) {
        t.sortTables(iArr, this.f4247a);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        Utf8 utf8 = this.f4260n;
        int encodedLength = utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - encodedLength;
        this.f4248b = i;
        byteBuffer.position(i);
        utf8.encodeUtf8(charSequence, this.f4247a);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i, int i2, int i3) {
        int i4 = i * i2;
        startVector(i, i2, i3);
        ByteBuffer byteBuffer = this.f4247a;
        int i5 = this.f4248b - i4;
        this.f4248b = i5;
        byteBuffer.position(i5);
        ByteBuffer order = this.f4247a.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i4);
        return order;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f4247a;
    }

    public int endTable() {
        int i;
        int i2;
        if (this.f4250d != null && this.f4252f) {
            addInt(0);
            int offset = offset();
            int i3 = this.f4251e - 1;
            while (i3 >= 0 && this.f4250d[i3] == 0) {
                i3--;
            }
            for (int i4 = i3; i4 >= 0; i4--) {
                int i5 = this.f4250d[i4];
                if (i5 != 0) {
                    i2 = offset - i5;
                } else {
                    i2 = 0;
                }
                addShort((short) i2);
            }
            addShort((short) (offset - this.f4254h));
            addShort((short) ((i3 + 3) * 2));
            int i6 = 0;
            loop2: while (true) {
                if (i6 < this.f4256j) {
                    int capacity = this.f4247a.capacity() - this.f4255i[i6];
                    int i7 = this.f4248b;
                    short s = this.f4247a.getShort(capacity);
                    if (s == this.f4247a.getShort(i7)) {
                        for (int i8 = 2; i8 < s; i8 += 2) {
                            if (this.f4247a.getShort(capacity + i8) != this.f4247a.getShort(i7 + i8)) {
                                break;
                            }
                        }
                        i = this.f4255i[i6];
                        break loop2;
                    }
                    i6++;
                } else {
                    i = 0;
                    break;
                }
            }
            if (i != 0) {
                int capacity2 = this.f4247a.capacity() - offset;
                this.f4248b = capacity2;
                this.f4247a.putInt(capacity2, i - offset);
            } else {
                int i9 = this.f4256j;
                int[] iArr = this.f4255i;
                if (i9 == iArr.length) {
                    this.f4255i = Arrays.copyOf(iArr, i9 * 2);
                }
                int[] iArr2 = this.f4255i;
                int i10 = this.f4256j;
                this.f4256j = i10 + 1;
                iArr2[i10] = offset();
                ByteBuffer byteBuffer = this.f4247a;
                byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
            }
            this.f4252f = false;
            return offset;
        }
        throw new AssertionError("FlatBuffers: endTable called without startTable");
    }

    public int endVector() {
        if (this.f4252f) {
            this.f4252f = false;
            putInt(this.f4257k);
            return offset();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int i, boolean z) {
        prep(this.f4249c, (z ? 4 : 0) + 4);
        addOffset(i);
        if (z) {
            addInt(this.f4247a.capacity() - this.f4248b);
        }
        this.f4247a.position(this.f4248b);
        this.f4253g = true;
    }

    public void finishSizePrefixed(int i) {
        finish(i, true);
    }

    public void finished() {
        if (this.f4253g) {
        } else {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z) {
        this.f4258l = z;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.f4259m = byteBufferFactory;
        this.f4247a = byteBuffer;
        byteBuffer.clear();
        this.f4247a.order(ByteOrder.LITTLE_ENDIAN);
        this.f4249c = 1;
        this.f4248b = this.f4247a.capacity();
        this.f4251e = 0;
        this.f4252f = false;
        this.f4253g = false;
        this.f4254h = 0;
        this.f4256j = 0;
        this.f4257k = 0;
        return this;
    }

    public void notNested() {
        if (!this.f4252f) {
        } else {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f4247a.capacity() - this.f4248b;
    }

    public void pad(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.f4247a;
            int i3 = this.f4248b - 1;
            this.f4248b = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    public void prep(int i, int i2) {
        int i3;
        if (i > this.f4249c) {
            this.f4249c = i;
        }
        int i4 = ((~((this.f4247a.capacity() - this.f4248b) + i2)) + 1) & (i - 1);
        while (this.f4248b < i4 + i + i2) {
            int capacity = this.f4247a.capacity();
            ByteBuffer byteBuffer = this.f4247a;
            ByteBufferFactory byteBufferFactory = this.f4259m;
            int capacity2 = byteBuffer.capacity();
            if (((-1073741824) & capacity2) == 0) {
                if (capacity2 == 0) {
                    i3 = 1;
                } else {
                    i3 = capacity2 << 1;
                }
                byteBuffer.position(0);
                ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i3);
                newByteBuffer.position(newByteBuffer.clear().capacity() - capacity2);
                newByteBuffer.put(byteBuffer);
                this.f4247a = newByteBuffer;
                if (byteBuffer != newByteBuffer) {
                    this.f4259m.releaseByteBuffer(byteBuffer);
                }
                this.f4248b = (this.f4247a.capacity() - capacity) + this.f4248b;
            } else {
                throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            }
        }
        pad(i4);
    }

    public void putBoolean(boolean z) {
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - 1;
        this.f4248b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b) {
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - 1;
        this.f4248b = i;
        byteBuffer.put(i, b);
    }

    public void putDouble(double d) {
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - 8;
        this.f4248b = i;
        byteBuffer.putDouble(i, d);
    }

    public void putFloat(float f) {
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - 4;
        this.f4248b = i;
        byteBuffer.putFloat(i, f);
    }

    public void putInt(int i) {
        ByteBuffer byteBuffer = this.f4247a;
        int i2 = this.f4248b - 4;
        this.f4248b = i2;
        byteBuffer.putInt(i2, i);
    }

    public void putLong(long j) {
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - 8;
        this.f4248b = i;
        byteBuffer.putLong(i, j);
    }

    public void putShort(short s) {
        ByteBuffer byteBuffer = this.f4247a;
        int i = this.f4248b - 2;
        this.f4248b = i;
        byteBuffer.putShort(i, s);
    }

    public void required(int i, int i2) {
        int capacity = this.f4247a.capacity() - i;
        if (this.f4247a.getShort((capacity - this.f4247a.getInt(capacity)) + i2) != 0) {
        } else {
            throw new AssertionError(ye0.m8292l(i2, "FlatBuffers: field ", " must be set"));
        }
    }

    public byte[] sizedByteArray(int i, int i2) {
        finished();
        byte[] bArr = new byte[i2];
        this.f4247a.position(i);
        this.f4247a.get(bArr);
        return bArr;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [te0, java.io.InputStream] */
    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.f4247a.duplicate();
        duplicate.position(this.f4248b);
        duplicate.limit(this.f4247a.capacity());
        ?? inputStream = new InputStream();
        inputStream.f26784a = duplicate;
        return inputStream;
    }

    public void slot(int i) {
        this.f4250d[i] = offset();
    }

    public void startTable(int i) {
        notNested();
        int[] iArr = this.f4250d;
        if (iArr == null || iArr.length < i) {
            this.f4250d = new int[i];
        }
        this.f4251e = i;
        Arrays.fill(this.f4250d, 0, i, 0);
        this.f4252f = true;
        this.f4254h = offset();
    }

    public void startVector(int i, int i2, int i3) {
        notNested();
        this.f4257k = i2;
        int i4 = i * i2;
        prep(4, i4);
        prep(i3, i4);
        this.f4252f = true;
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f4249c = 1;
        this.f4250d = null;
        this.f4251e = 0;
        this.f4252f = false;
        this.f4253g = false;
        this.f4255i = new int[16];
        this.f4256j = 0;
        this.f4257k = 0;
        this.f4258l = false;
        i = i <= 0 ? 1 : i;
        this.f4259m = byteBufferFactory;
        if (byteBuffer != null) {
            this.f4247a = byteBuffer;
            byteBuffer.clear();
            this.f4247a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f4247a = byteBufferFactory.newByteBuffer(i);
        }
        this.f4260n = utf8;
        this.f4248b = this.f4247a.capacity();
    }

    public void addBoolean(int i, boolean z, boolean z2) {
        if (this.f4258l || z != z2) {
            addBoolean(z);
            slot(i);
        }
    }

    public void addByte(int i, byte b, int i2) {
        if (this.f4258l || b != i2) {
            addByte(b);
            slot(i);
        }
    }

    public void addDouble(int i, double d, double d2) {
        if (this.f4258l || d != d2) {
            addDouble(d);
            slot(i);
        }
    }

    public void addFloat(int i, float f, double d) {
        if (this.f4258l || f != d) {
            addFloat(f);
            slot(i);
        }
    }

    public void addInt(int i, int i2, int i3) {
        if (this.f4258l || i2 != i3) {
            addInt(i2);
            slot(i);
        }
    }

    public void addLong(int i, long j, long j2) {
        if (this.f4258l || j != j2) {
            addLong(j);
            slot(i);
        }
    }

    public void addShort(int i, short s, int i2) {
        if (this.f4258l || s != i2) {
            addShort(s);
            slot(i);
        }
    }

    public void finishSizePrefixed(int i, String str) {
        finish(i, str, true);
    }

    public void addOffset(int i, int i2, int i3) {
        if (this.f4258l || i2 != i3) {
            addOffset(i2);
            slot(i);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.f4248b, this.f4247a.capacity() - this.f4248b);
    }

    public int createByteVector(byte[] bArr, int i, int i2) {
        startVector(1, i2, 1);
        ByteBuffer byteBuffer = this.f4247a;
        int i3 = this.f4248b - i2;
        this.f4248b = i3;
        byteBuffer.position(i3);
        this.f4247a.put(bArr, i, i2);
        return endVector();
    }

    public void finish(int i) {
        finish(i, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f4247a;
        int i = this.f4248b - remaining;
        this.f4248b = i;
        byteBuffer2.position(i);
        this.f4247a.put(byteBuffer);
        return endVector();
    }

    public void finish(int i, String str, boolean z) {
        prep(this.f4249c, (z ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i2 = 3; i2 >= 0; i2--) {
                addByte((byte) str.charAt(i2));
            }
            finish(i, z);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f4247a;
        int i = this.f4248b - remaining;
        this.f4248b = i;
        byteBuffer2.position(i);
        this.f4247a.put(byteBuffer);
        return endVector();
    }

    public void finish(int i, String str) {
        finish(i, str, false);
    }

    public FlatBufferBuilder(int i) {
        this(i, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }
}
