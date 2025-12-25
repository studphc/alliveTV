package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import p000.cs2;

/* loaded from: classes.dex */
public class Table {

    /* renamed from: a */
    public int f4283a;

    /* renamed from: b */
    public int f4284b;

    /* renamed from: bb */
    protected ByteBuffer f4285bb;
    protected int bb_pos;

    /* renamed from: c */
    public final Utf8 f4286c = Utf8.getDefault();

    public static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() == 4) {
            for (int i = 0; i < 4; i++) {
                if (str.charAt(i) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i))) {
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public static int compareStrings(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = byteBuffer.getInt(i) + i;
        int i4 = byteBuffer.getInt(i2) + i2;
        int i5 = byteBuffer.getInt(i3);
        int i6 = byteBuffer.getInt(i4);
        int i7 = i3 + 4;
        int i8 = i4 + 4;
        int min = Math.min(i5, i6);
        for (int i9 = 0; i9 < min; i9++) {
            int i10 = i9 + i7;
            int i11 = i9 + i8;
            if (byteBuffer.get(i10) != byteBuffer.get(i11)) {
                return byteBuffer.get(i10) - byteBuffer.get(i11);
            }
        }
        return i5 - i6;
    }

    public int __indirect(int i) {
        return this.f4285bb.getInt(i) + i;
    }

    public int __offset(int i) {
        if (i < this.f4284b) {
            return this.f4285bb.getShort(this.f4283a + i);
        }
        return 0;
    }

    public void __reset(int i, ByteBuffer byteBuffer) {
        this.f4285bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i;
            int i2 = i - byteBuffer.getInt(i);
            this.f4283a = i2;
            this.f4284b = this.f4285bb.getShort(i2);
            return;
        }
        this.bb_pos = 0;
        this.f4283a = 0;
        this.f4284b = 0;
    }

    public String __string(int i) {
        return __string(i, this.f4285bb, this.f4286c);
    }

    public Table __union(Table table, int i) {
        return __union(table, i, this.f4285bb);
    }

    public int __vector(int i) {
        int i2 = i + this.bb_pos;
        return this.f4285bb.getInt(i2) + i2 + 4;
    }

    public ByteBuffer __vector_as_bytebuffer(int i, int i2) {
        int __offset = __offset(i);
        if (__offset == 0) {
            return null;
        }
        ByteBuffer order = this.f4285bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int __vector = __vector(__offset);
        order.position(__vector);
        order.limit((__vector_len(__offset) * i2) + __vector);
        return order;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i, int i2) {
        int __offset = __offset(i);
        if (__offset == 0) {
            return null;
        }
        int __vector = __vector(__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(__offset) * i2) + __vector);
        byteBuffer.position(__vector);
        return byteBuffer;
    }

    public int __vector_len(int i) {
        int i2 = i + this.bb_pos;
        return this.f4285bb.getInt(this.f4285bb.getInt(i2) + i2);
    }

    public ByteBuffer getByteBuffer() {
        return this.f4285bb;
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void sortTables(int[] iArr, ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        Arrays.sort(numArr, new cs2(this, byteBuffer));
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
    }

    public static int __indirect(int i, ByteBuffer byteBuffer) {
        return byteBuffer.getInt(i) + i;
    }

    public static int __offset(int i, int i2, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - i2;
        return byteBuffer.getShort((i + capacity) - byteBuffer.getInt(capacity)) + capacity;
    }

    public static String __string(int i, ByteBuffer byteBuffer, Utf8 utf8) {
        int i2 = byteBuffer.getInt(i) + i;
        return utf8.decodeUtf8(byteBuffer, i2 + 4, byteBuffer.getInt(i2));
    }

    public static Table __union(Table table, int i, ByteBuffer byteBuffer) {
        table.__reset(__indirect(i, byteBuffer), byteBuffer);
        return table;
    }

    public static int compareStrings(int i, byte[] bArr, ByteBuffer byteBuffer) {
        int i2 = byteBuffer.getInt(i) + i;
        int i3 = byteBuffer.getInt(i2);
        int length = bArr.length;
        int i4 = i2 + 4;
        int min = Math.min(i3, length);
        for (int i5 = 0; i5 < min; i5++) {
            int i6 = i5 + i4;
            if (byteBuffer.get(i6) != bArr[i5]) {
                return byteBuffer.get(i6) - bArr[i5];
            }
        }
        return i3 - length;
    }

    public void __reset() {
        __reset(0, null);
    }
}
