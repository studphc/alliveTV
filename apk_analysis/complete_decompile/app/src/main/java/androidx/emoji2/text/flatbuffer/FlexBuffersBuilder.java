package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import p000.we0;
import p000.xe0;
import p000.y82;

/* loaded from: classes.dex */
public class FlexBuffersBuilder {
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;

    /* renamed from: a */
    public final y82 f4275a;

    /* renamed from: b */
    public final ArrayList f4276b;

    /* renamed from: c */
    public final HashMap f4277c;

    /* renamed from: d */
    public final HashMap f4278d;

    /* renamed from: e */
    public final int f4279e;

    /* renamed from: f */
    public final we0 f4280f;

    public FlexBuffersBuilder(int i) {
        this(new ArrayReadWriteBuf(i), 1);
    }

    /* renamed from: e */
    public static int m1072e(long j) {
        if (j <= 255) {
            return 0;
        }
        if (j <= 65535) {
            return 1;
        }
        return j <= (((long) (-1)) & 4294967295L) ? 2 : 3;
    }

    /* renamed from: a */
    public final int m1073a(int i) {
        int i2 = 1 << i;
        y82 y82Var = this.f4275a;
        int i3 = (i2 - 1) & ((~y82Var.writePosition()) + 1);
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                y82Var.put((byte) 0);
                i3 = i4;
            } else {
                return i2;
            }
        }
    }

    /* renamed from: b */
    public final xe0 m1074b(int i, int i2, int i3, boolean z, boolean z2, xe0 xe0Var) {
        int i4;
        int i5;
        boolean z3;
        int i6 = i3;
        long j = i6;
        int max = Math.max(0, m1072e(j));
        y82 y82Var = this.f4275a;
        if (xe0Var != null) {
            max = Math.max(max, xe0.m8163a(xe0Var.f28518a, xe0Var.f28519b, y82Var.writePosition(), xe0Var.f28521d, 0));
            i4 = 3;
        } else {
            i4 = 1;
        }
        int i7 = max;
        int i8 = 4;
        int i9 = i2;
        while (true) {
            ArrayList arrayList = this.f4276b;
            if (i9 < arrayList.size()) {
                xe0 xe0Var2 = (xe0) arrayList.get(i9);
                int i10 = i8;
                i7 = Math.max(i7, xe0.m8163a(xe0Var2.f28518a, xe0Var2.f28519b, y82Var.writePosition(), xe0Var2.f28521d, i9 + i4));
                if (z && i9 == i2) {
                    i8 = ((xe0) arrayList.get(i9)).f28518a;
                    if ((i8 < 1 || i8 > 4) && i8 != 26) {
                        throw new RuntimeException("TypedVector does not support this element type");
                    }
                } else {
                    i8 = i10;
                }
                i9++;
            } else {
                int i11 = i8;
                int m1073a = m1073a(i7);
                if (xe0Var != null) {
                    m1079h(m1073a, (int) (y82Var.writePosition() - xe0Var.f28521d));
                    m1079h(m1073a, 1 << xe0Var.f28519b);
                }
                if (!z2) {
                    m1079h(m1073a, j);
                }
                int writePosition = y82Var.writePosition();
                for (int i12 = i2; i12 < arrayList.size(); i12++) {
                    m1077f((xe0) arrayList.get(i12), m1073a);
                }
                if (!z) {
                    for (int i13 = i2; i13 < arrayList.size(); i13++) {
                        xe0 xe0Var3 = (xe0) arrayList.get(i13);
                        xe0Var3.getClass();
                        int i14 = FlexBuffers.FBT_NULL;
                        int i15 = xe0Var3.f28518a;
                        if (i15 > 3 && i15 != 26) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        int i16 = xe0Var3.f28519b;
                        if (z3) {
                            i16 = Math.max(i16, i7);
                        }
                        y82Var.put((byte) (i16 | (i15 << 2)));
                    }
                }
                if (xe0Var != null) {
                    i5 = 9;
                } else if (z) {
                    if (!z2) {
                        i6 = 0;
                    }
                    i5 = FlexBuffers.m1070e(i11, i6);
                } else {
                    i5 = 10;
                }
                return new xe0(i, i5, i7, writePosition);
            }
        }
    }

    /* renamed from: c */
    public final int m1075c(String str) {
        if (str == null) {
            return -1;
        }
        y82 y82Var = this.f4275a;
        int writePosition = y82Var.writePosition();
        int i = this.f4279e & 1;
        HashMap hashMap = this.f4277c;
        if (i != 0) {
            Integer num = (Integer) hashMap.get(str);
            if (num == null) {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                y82Var.put(bytes, 0, bytes.length);
                y82Var.put((byte) 0);
                hashMap.put(str, Integer.valueOf(writePosition));
                return writePosition;
            }
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        y82Var.put(bytes2, 0, bytes2.length);
        y82Var.put((byte) 0);
        hashMap.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    /* renamed from: d */
    public final void m1076d(long j) {
        xe0 xe0Var;
        int m1072e = m1072e(j);
        if (m1072e == 0) {
            xe0Var = new xe0(-1, 2, 0, (int) j);
        } else if (m1072e == 1) {
            xe0Var = new xe0(-1, 2, 1, (int) j);
        } else if (m1072e == 2) {
            xe0Var = new xe0(-1, 2, 2, (int) j);
        } else {
            xe0Var = new xe0(-1, 2, 3, j);
        }
        this.f4276b.add(xe0Var);
    }

    public int endMap(String str, int i) {
        y82 y82Var;
        int m1075c = m1075c(str);
        ArrayList arrayList = this.f4276b;
        Collections.sort(arrayList.subList(i, arrayList.size()), this.f4280f);
        long size = arrayList.size() - i;
        int max = Math.max(0, m1072e(size));
        int i2 = i;
        while (true) {
            int size2 = arrayList.size();
            y82Var = this.f4275a;
            if (i2 >= size2) {
                break;
            }
            long j = ((xe0) arrayList.get(i2)).f28522e;
            i2++;
            max = Math.max(max, xe0.m8163a(4, 0, y82Var.writePosition(), j, i2));
        }
        int m1073a = m1073a(max);
        m1079h(m1073a, size);
        int writePosition = y82Var.writePosition();
        for (int i3 = i; i3 < arrayList.size(); i3++) {
            int i4 = ((xe0) arrayList.get(i3)).f28522e;
            m1079h(m1073a, (int) (y82Var.writePosition() - ((xe0) arrayList.get(i3)).f28522e));
        }
        xe0 m1074b = m1074b(m1075c, i, arrayList.size() - i, false, false, new xe0(-1, FlexBuffers.m1070e(4, 0), max, writePosition));
        while (arrayList.size() > i) {
            arrayList.remove(arrayList.size() - 1);
        }
        arrayList.add(m1074b);
        return (int) m1074b.f28521d;
    }

    public int endVector(String str, int i, boolean z, boolean z2) {
        int m1075c = m1075c(str);
        ArrayList arrayList = this.f4276b;
        xe0 m1074b = m1074b(m1075c, i, arrayList.size() - i, z, z2, null);
        while (arrayList.size() > i) {
            arrayList.remove(arrayList.size() - 1);
        }
        arrayList.add(m1074b);
        return (int) m1074b.f28521d;
    }

    /* renamed from: f */
    public final void m1077f(xe0 xe0Var, int i) {
        int i2 = xe0Var.f28518a;
        long j = xe0Var.f28521d;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            y82 y82Var = this.f4275a;
            if (i2 != 3) {
                if (i2 != 26) {
                    m1079h(i, (int) (y82Var.writePosition() - j));
                    return;
                }
            } else {
                double d = xe0Var.f28520c;
                if (i == 4) {
                    y82Var.putFloat((float) d);
                    return;
                } else {
                    if (i == 8) {
                        y82Var.putDouble(d);
                        return;
                    }
                    return;
                }
            }
        }
        m1079h(i, j);
    }

    public ByteBuffer finish() {
        boolean z;
        ArrayList arrayList = this.f4276b;
        xe0 xe0Var = (xe0) arrayList.get(0);
        y82 y82Var = this.f4275a;
        int writePosition = y82Var.writePosition();
        int m1073a = m1073a(xe0.m8163a(xe0Var.f28518a, xe0Var.f28519b, writePosition, xe0Var.f28521d, 0));
        m1077f((xe0) arrayList.get(0), m1073a);
        xe0 xe0Var2 = (xe0) arrayList.get(0);
        xe0Var2.getClass();
        int i = FlexBuffers.FBT_NULL;
        int i2 = xe0Var2.f28518a;
        if (i2 > 3 && i2 != 26) {
            z = false;
        } else {
            z = true;
        }
        int i3 = xe0Var2.f28519b;
        if (z) {
            i3 = Math.max(i3, 0);
        }
        y82Var.put((byte) (i3 | (i2 << 2)));
        y82Var.put((byte) m1073a);
        return ByteBuffer.wrap(y82Var.data(), 0, y82Var.writePosition());
    }

    /* renamed from: g */
    public final xe0 m1078g(byte[] bArr, int i, int i2, boolean z) {
        int m1072e = m1072e(bArr.length);
        m1079h(m1073a(m1072e), bArr.length);
        y82 y82Var = this.f4275a;
        int writePosition = y82Var.writePosition();
        y82Var.put(bArr, 0, bArr.length);
        if (z) {
            y82Var.put((byte) 0);
        }
        return new xe0(i, i2, m1072e, writePosition);
    }

    public y82 getBuffer() {
        return this.f4275a;
    }

    /* renamed from: h */
    public final void m1079h(int i, long j) {
        y82 y82Var = this.f4275a;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i == 8) {
                        y82Var.putLong(j);
                        return;
                    }
                    return;
                }
                y82Var.putInt((int) j);
                return;
            }
            y82Var.putShort((short) j);
            return;
        }
        y82Var.put((byte) j);
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public void putBoolean(boolean z) {
        putBoolean(null, z);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putInt(int i) {
        putInt((String) null, i);
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public void putUInt(int i) {
        m1076d(i);
    }

    public void putUInt64(BigInteger bigInteger) {
        this.f4276b.add(new xe0(-1, 2, 3, bigInteger.longValue()));
    }

    public int startMap() {
        return this.f4276b.size();
    }

    public int startVector() {
        return this.f4276b.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public int putBlob(String str, byte[] bArr) {
        xe0 m1078g = m1078g(bArr, m1075c(str), 25, false);
        this.f4276b.add(m1078g);
        return (int) m1078g.f28521d;
    }

    public void putBoolean(String str, boolean z) {
        this.f4276b.add(new xe0(m1075c(str), 26, 0, z ? 1L : 0L));
    }

    public void putFloat(String str, float f) {
        this.f4276b.add(new xe0(m1075c(str), 2, f));
    }

    public void putInt(String str, int i) {
        putInt(str, i);
    }

    public int putString(String str, String str2) {
        int m1075c = m1075c(str);
        int i = this.f4279e & 2;
        ArrayList arrayList = this.f4276b;
        if (i != 0) {
            HashMap hashMap = this.f4278d;
            Integer num = (Integer) hashMap.get(str2);
            if (num == null) {
                xe0 m1078g = m1078g(str2.getBytes(StandardCharsets.UTF_8), m1075c, 5, true);
                int i2 = (int) m1078g.f28521d;
                hashMap.put(str2, Integer.valueOf(i2));
                arrayList.add(m1078g);
                return i2;
            }
            arrayList.add(new xe0(m1075c, 5, m1072e(str2.length()), num.intValue()));
            return num.intValue();
        }
        xe0 m1078g2 = m1078g(str2.getBytes(StandardCharsets.UTF_8), m1075c, 5, true);
        arrayList.add(m1078g2);
        return (int) m1078g2.f28521d;
    }

    public void putUInt(long j) {
        m1076d(j);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i);
    }

    public void putInt(String str, long j) {
        int m1075c = m1075c(str);
        ArrayList arrayList = this.f4276b;
        if (-128 <= j && j <= 127) {
            arrayList.add(new xe0(m1075c, 1, 0, (int) j));
            return;
        }
        if (-32768 <= j && j <= 32767) {
            arrayList.add(new xe0(m1075c, 1, 1, (int) j));
        } else if (-2147483648L <= j && j <= 2147483647L) {
            arrayList.add(new xe0(m1075c, 1, 2, (int) j));
        } else {
            arrayList.add(new xe0(m1075c, 1, 3, j));
        }
    }

    public FlexBuffersBuilder(y82 y82Var, int i) {
        this.f4276b = new ArrayList();
        this.f4277c = new HashMap();
        this.f4278d = new HashMap();
        this.f4280f = new we0(0, this);
        this.f4275a = y82Var;
        this.f4279e = i;
    }

    public void putFloat(double d) {
        putFloat((String) null, d);
    }

    public void putFloat(String str, double d) {
        this.f4276b.add(new xe0(m1075c(str), 3, d));
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }

    public void putInt(long j) {
        putInt((String) null, j);
    }
}
