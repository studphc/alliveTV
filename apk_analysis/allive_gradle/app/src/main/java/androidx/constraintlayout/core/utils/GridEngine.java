package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridEngine {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    public int f2441a;

    /* renamed from: b */
    public int f2442b;

    /* renamed from: c */
    public int f2443c;

    /* renamed from: d */
    public int f2444d;

    /* renamed from: e */
    public int f2445e;

    /* renamed from: f */
    public String f2446f;

    /* renamed from: g */
    public String f2447g;

    /* renamed from: h */
    public int f2448h;

    /* renamed from: i */
    public int f2449i = 0;

    /* renamed from: j */
    public boolean[][] f2450j;

    /* renamed from: k */
    public int[][] f2451k;

    public GridEngine() {
    }

    /* renamed from: f */
    public static int[][] m480f(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr[i][0] = Integer.parseInt(split2[0]);
            iArr[i][1] = Integer.parseInt(split3[0]);
            iArr[i][2] = Integer.parseInt(split3[1]);
        }
        return iArr;
    }

    /* renamed from: a */
    public final void m481a(boolean z) {
        int[][] m480f;
        int[][] m480f2;
        if (z) {
            for (int i = 0; i < this.f2450j.length; i++) {
                int i2 = 0;
                while (true) {
                    boolean[][] zArr = this.f2450j;
                    if (i2 < zArr[0].length) {
                        zArr[i][i2] = true;
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.f2451k.length; i3++) {
                int i4 = 0;
                while (true) {
                    int[][] iArr = this.f2451k;
                    if (i4 < iArr[0].length) {
                        iArr[i3][i4] = -1;
                        i4++;
                    }
                }
            }
        }
        this.f2449i = 0;
        String str = this.f2447g;
        if (str != null && !str.trim().isEmpty() && (m480f2 = m480f(this.f2447g)) != null) {
            for (int i5 = 0; i5 < m480f2.length; i5++) {
                int m483c = m483c(m480f2[i5][0]);
                int m482b = m482b(m480f2[i5][0]);
                int[] iArr2 = m480f2[i5];
                if (!m485e(m483c, m482b, iArr2[1], iArr2[2])) {
                    break;
                }
            }
        }
        String str2 = this.f2446f;
        if (str2 != null && !str2.trim().isEmpty() && (m480f = m480f(this.f2446f)) != null) {
            for (int i6 = 0; i6 < m480f.length; i6++) {
                int m483c2 = m483c(m480f[i6][0]);
                int m482b2 = m482b(m480f[i6][0]);
                int[] iArr3 = m480f[i6];
                if (!m485e(m483c2, m482b2, iArr3[1], iArr3[2])) {
                    break;
                }
                int[] iArr4 = m480f[i6];
                int i7 = iArr4[1];
                int i8 = iArr4[2];
                int[] iArr5 = this.f2451k[i6];
                iArr5[0] = m482b2;
                iArr5[1] = m483c2;
                iArr5[2] = (m482b2 + i8) - 1;
                iArr5[3] = (m483c2 + i7) - 1;
            }
        }
        for (int i9 = 0; i9 < this.f2443c; i9++) {
            if (leftOfWidget(i9) == -1) {
                boolean z2 = false;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        break;
                    }
                    i10 = this.f2449i;
                    if (i10 >= this.f2441a * this.f2444d) {
                        i10 = -1;
                        break;
                    }
                    int m483c3 = m483c(i10);
                    int m482b3 = m482b(this.f2449i);
                    boolean[] zArr2 = this.f2450j[m483c3];
                    if (zArr2[m482b3]) {
                        zArr2[m482b3] = false;
                        z2 = true;
                    }
                    this.f2449i++;
                }
                int m483c4 = m483c(i10);
                int m482b4 = m482b(i10);
                if (i10 != -1) {
                    int[] iArr6 = this.f2451k[i9];
                    iArr6[0] = m482b4;
                    iArr6[1] = m483c4;
                    iArr6[2] = m482b4;
                    iArr6[3] = m483c4;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public final int m482b(int i) {
        if (this.f2448h == 1) {
            return i / this.f2441a;
        }
        return i % this.f2444d;
    }

    public int bottomOfWidget(int i) {
        int[][] iArr = this.f2451k;
        if (iArr != null && i < iArr.length) {
            return iArr[i][3];
        }
        return 0;
    }

    /* renamed from: c */
    public final int m483c(int i) {
        if (this.f2448h == 1) {
            return i % this.f2441a;
        }
        return i / this.f2444d;
    }

    /* renamed from: d */
    public final void m484d() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.f2441a, this.f2444d);
        this.f2450j = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i = this.f2443c;
        if (i > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, 4);
            this.f2451k = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    /* renamed from: e */
    public final boolean m485e(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                boolean[][] zArr = this.f2450j;
                if (i5 < zArr.length && i6 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i5];
                    if (zArr2[i6]) {
                        zArr2[i6] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public final void m486g() {
        int i;
        int i2 = this.f2442b;
        if (i2 != 0 && (i = this.f2445e) != 0) {
            this.f2441a = i2;
            this.f2444d = i;
            return;
        }
        int i3 = this.f2445e;
        if (i3 > 0) {
            this.f2444d = i3;
            this.f2441a = ((this.f2443c + i3) - 1) / i3;
        } else if (i2 > 0) {
            this.f2441a = i2;
            this.f2444d = ((this.f2443c + i2) - 1) / i2;
        } else {
            int sqrt = (int) (Math.sqrt(this.f2443c) + 1.5d);
            this.f2441a = sqrt;
            this.f2444d = ((this.f2443c + sqrt) - 1) / sqrt;
        }
    }

    public int leftOfWidget(int i) {
        int[][] iArr = this.f2451k;
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i][0];
    }

    public int rightOfWidget(int i) {
        int[][] iArr = this.f2451k;
        if (iArr != null && i < iArr.length) {
            return iArr[i][2];
        }
        return 0;
    }

    public void setColumns(int i) {
        if (i > 50 || this.f2445e == i) {
            return;
        }
        this.f2445e = i;
        m486g();
    }

    public void setNumWidgets(int i) {
        if (i > this.f2441a * this.f2444d) {
            return;
        }
        this.f2443c = i;
    }

    public void setOrientation(int i) {
        if ((i != 0 && i != 1) || this.f2448h == i) {
            return;
        }
        this.f2448h = i;
    }

    public void setRows(int i) {
        if (i > 50 || this.f2442b == i) {
            return;
        }
        this.f2442b = i;
        m486g();
    }

    public void setSkips(String str) {
        String str2 = this.f2447g;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2447g = str;
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.f2446f;
        if (str != null && str.equals(charSequence.toString())) {
            return;
        }
        this.f2446f = charSequence.toString();
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.f2451k;
        boolean z = false;
        if (iArr != null && iArr.length == this.f2443c && (zArr = this.f2450j) != null && zArr.length == this.f2441a && zArr[0].length == this.f2444d) {
            z = true;
        }
        if (!z) {
            m484d();
        }
        m481a(z);
    }

    public int topOfWidget(int i) {
        int[][] iArr = this.f2451k;
        if (iArr != null && i < iArr.length) {
            return iArr[i][1];
        }
        return 0;
    }

    public GridEngine(int i, int i2) {
        this.f2442b = i;
        this.f2445e = i2;
        if (i > 50) {
            this.f2442b = 3;
        }
        if (i2 > 50) {
            this.f2445e = 3;
        }
        m486g();
        m484d();
    }

    public GridEngine(int i, int i2, int i3) {
        this.f2442b = i;
        this.f2445e = i2;
        this.f2443c = i3;
        if (i > 50) {
            this.f2442b = 3;
        }
        if (i2 > 50) {
            this.f2445e = 3;
        }
        m486g();
        int i4 = this.f2441a;
        int i5 = this.f2444d;
        if (i3 > i4 * i5 || i3 < 1) {
            this.f2443c = i4 * i5;
        }
        m484d();
        m481a(false);
    }
}
