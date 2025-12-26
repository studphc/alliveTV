package p000;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class va0 {

    /* renamed from: a */
    public final int f27712a;

    /* renamed from: b */
    public final int f27713b;

    /* renamed from: c */
    public final long f27714c;

    /* renamed from: d */
    public final byte[] f27715d;

    public va0(byte[] bArr, int i, int i2) {
        this(-1L, bArr, i, i2);
    }

    /* renamed from: a */
    public static va0 m7886a(String str) {
        byte[] bytes = str.concat("\u0000").getBytes(ExifInterface.f4343f0);
        return new va0(bytes, 2, bytes.length);
    }

    /* renamed from: b */
    public static va0 m7887b(long j, ByteOrder byteOrder) {
        return m7888c(new long[]{j}, byteOrder);
    }

    /* renamed from: c */
    public static va0 m7888c(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f4332U[4] * jArr.length]);
        wrap.order(byteOrder);
        for (long j : jArr) {
            wrap.putInt((int) j);
        }
        return new va0(wrap.array(), 4, jArr.length);
    }

    /* renamed from: d */
    public static va0 m7889d(xa0[] xa0VarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f4332U[5] * xa0VarArr.length]);
        wrap.order(byteOrder);
        for (xa0 xa0Var : xa0VarArr) {
            wrap.putInt((int) xa0Var.f28485a);
            wrap.putInt((int) xa0Var.f28486b);
        }
        return new va0(wrap.array(), 5, xa0VarArr.length);
    }

    /* renamed from: e */
    public static va0 m7890e(int i, ByteOrder byteOrder) {
        return m7891f(new int[]{i}, byteOrder);
    }

    /* renamed from: f */
    public static va0 m7891f(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f4332U[3] * iArr.length]);
        wrap.order(byteOrder);
        for (int i : iArr) {
            wrap.putShort((short) i);
        }
        return new va0(wrap.array(), 3, iArr.length);
    }

    /* renamed from: g */
    public final double m7892g(ByteOrder byteOrder) {
        Object m7895j = m7895j(byteOrder);
        if (m7895j != null) {
            if (m7895j instanceof String) {
                return Double.parseDouble((String) m7895j);
            }
            if (m7895j instanceof long[]) {
                if (((long[]) m7895j).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (m7895j instanceof int[]) {
                if (((int[]) m7895j).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (m7895j instanceof double[]) {
                double[] dArr = (double[]) m7895j;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (m7895j instanceof xa0[]) {
                xa0[] xa0VarArr = (xa0[]) m7895j;
                if (xa0VarArr.length == 1) {
                    xa0 xa0Var = xa0VarArr[0];
                    return xa0Var.f28485a / xa0Var.f28486b;
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a double value");
        }
        throw new NumberFormatException("NULL can't be converted to a double value");
    }

    /* renamed from: h */
    public final int m7893h(ByteOrder byteOrder) {
        Object m7895j = m7895j(byteOrder);
        if (m7895j != null) {
            if (m7895j instanceof String) {
                return Integer.parseInt((String) m7895j);
            }
            if (m7895j instanceof long[]) {
                long[] jArr = (long[]) m7895j;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (m7895j instanceof int[]) {
                int[] iArr = (int[]) m7895j;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a integer value");
        }
        throw new NumberFormatException("NULL can't be converted to a integer value");
    }

    /* renamed from: i */
    public final String m7894i(ByteOrder byteOrder) {
        Object m7895j = m7895j(byteOrder);
        if (m7895j == null) {
            return null;
        }
        if (m7895j instanceof String) {
            return (String) m7895j;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (m7895j instanceof long[]) {
            long[] jArr = (long[]) m7895j;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (m7895j instanceof int[]) {
            int[] iArr = (int[]) m7895j;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (m7895j instanceof double[]) {
            double[] dArr = (double[]) m7895j;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(m7895j instanceof xa0[])) {
            return null;
        }
        xa0[] xa0VarArr = (xa0[]) m7895j;
        while (i < xa0VarArr.length) {
            sb.append(xa0VarArr[i].f28485a);
            sb.append('/');
            sb.append(xa0VarArr[i].f28486b);
            i++;
            if (i != xa0VarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:89|(2:91|(2:92|(2:94|(2:97|98)(1:96))(2:99|100)))|101|(2:103|(6:112|113|114|115|116|117)(3:105|(2:107|108)(2:110|111)|109))|121|114|115|116|117) */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0128, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0129, code lost:
    
        android.util.Log.e("ExifInterface", "IOException occurred while closing InputStream", r0);
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0032: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:51), block:B:158:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v23, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v24, types: [long[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v25, types: [xa0[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v26, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v27, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v28, types: [xa0[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v29, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v30, types: [double[], java.io.Serializable] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m7895j(ByteOrder byteOrder) {
        ta0 ta0Var;
        InputStream inputStream;
        byte b;
        int i = 0;
        byte[] bArr = this.f27715d;
        InputStream inputStream2 = null;
        try {
            try {
                ta0Var = new ta0(bArr);
                try {
                    ta0Var.f26742b = byteOrder;
                    int i2 = this.f27712a;
                    int i3 = this.f27713b;
                    switch (i2) {
                        case 1:
                        case 6:
                            if (bArr.length == 1 && (b = bArr[0]) >= 0 && b <= 1) {
                                String str = new String(new char[]{(char) (b + 48)});
                                try {
                                    ta0Var.close();
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                }
                                return str;
                            }
                            String str2 = new String(bArr, ExifInterface.f4343f0);
                            try {
                                ta0Var.close();
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (i3 >= ExifInterface.f4333V.length) {
                                int i4 = 0;
                                while (true) {
                                    byte[] bArr2 = ExifInterface.f4333V;
                                    if (i4 < bArr2.length) {
                                        if (bArr[i4] == bArr2[i4]) {
                                            i4++;
                                        }
                                    } else {
                                        i = bArr2.length;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (i < i3) {
                                byte b2 = bArr[i];
                                if (b2 != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    i++;
                                } else {
                                    String sb2 = sb.toString();
                                    ta0Var.close();
                                    return sb2;
                                }
                            }
                            String sb22 = sb.toString();
                            ta0Var.close();
                            return sb22;
                        case 3:
                            ?? r15 = new int[i3];
                            while (i < i3) {
                                r15[i] = ta0Var.readUnsignedShort();
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return r15;
                        case 4:
                            ?? r152 = new long[i3];
                            while (i < i3) {
                                r152[i] = ta0Var.readInt() & 4294967295L;
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            return r152;
                        case 5:
                            ?? r153 = new xa0[i3];
                            while (i < i3) {
                                r153[i] = new xa0(ta0Var.readInt() & 4294967295L, ta0Var.readInt() & 4294967295L);
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return r153;
                        case 8:
                            ?? r154 = new int[i3];
                            while (i < i3) {
                                r154[i] = ta0Var.readShort();
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return r154;
                        case 9:
                            ?? r155 = new int[i3];
                            while (i < i3) {
                                r155[i] = ta0Var.readInt();
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return r155;
                        case 10:
                            ?? r156 = new xa0[i3];
                            while (i < i3) {
                                r156[i] = new xa0(ta0Var.readInt(), ta0Var.readInt());
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return r156;
                        case 11:
                            ?? r157 = new double[i3];
                            while (i < i3) {
                                r157[i] = ta0Var.readFloat();
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return r157;
                        case 12:
                            ?? r158 = new double[i3];
                            while (i < i3) {
                                r158[i] = ta0Var.readDouble();
                                i++;
                            }
                            try {
                                ta0Var.close();
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return r158;
                        default:
                            try {
                                ta0Var.close();
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return null;
                    }
                } catch (IOException e12) {
                    e = e12;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (ta0Var != null) {
                        try {
                            ta0Var.close();
                        } catch (IOException e13) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e14) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                    }
                }
                throw th;
            }
        } catch (IOException e15) {
            e = e15;
            ta0Var = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(ExifInterface.f4331T[this.f27712a]);
        sb.append(", data length:");
        return ye0.m8298r(sb, ")", this.f27715d.length);
    }

    public va0(long j, byte[] bArr, int i, int i2) {
        this.f27712a = i;
        this.f27713b = i2;
        this.f27714c = j;
        this.f27715d = bArr;
    }
}
