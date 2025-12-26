package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;

    /* renamed from: a */
    public static final Object f3849a = new Object();

    /* renamed from: b */
    public static char[] f3850b = new char[24];

    /* renamed from: a */
    public static int m898a(int i, int i2, int i3, boolean z) {
        if (i <= 99 && (!z || i3 < 3)) {
            if (i <= 9 && (!z || i3 < 2)) {
                if (!z && i <= 0) {
                    return 0;
                }
                return i2 + 1;
            }
            return i2 + 2;
        }
        return i2 + 3;
    }

    /* renamed from: b */
    public static int m899b(int i, long j) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        int i10;
        boolean z5;
        boolean z6;
        boolean z7;
        int i11;
        long j2 = j;
        if (f3850b.length < i) {
            f3850b = new char[i];
        }
        char[] cArr = f3850b;
        if (j2 == 0) {
            int i12 = i - 1;
            while (i12 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j2 > 0) {
            c = '+';
        } else {
            j2 = -j2;
            c = '-';
        }
        int i13 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i14 = floor / 60;
            i4 = floor - (i14 * 60);
            i5 = i14;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i != 0) {
            int m898a = m898a(i2, 1, 0, false);
            if (m898a > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            int m898a2 = m898a(i3, 1, 2, z5) + m898a;
            if (m898a2 > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int m898a3 = m898a(i5, 1, 2, z6) + m898a2;
            if (m898a3 > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            int m898a4 = m898a(i4, 1, 2, z7) + m898a3;
            if (m898a4 > 0) {
                i11 = 3;
            } else {
                i11 = 0;
            }
            i6 = 0;
            for (int m898a5 = m898a(i13, 2, i11, true) + 1 + m898a4; m898a5 < i; m898a5++) {
                cArr[i6] = ' ';
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i15 = i6 + 1;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        int m900c = m900c(cArr, i2, 'd', i15, false, 0);
        if (m900c != i15) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            i7 = 2;
        } else {
            i7 = 0;
        }
        int m900c2 = m900c(cArr, i3, 'h', m900c, z2, i7);
        if (m900c2 != i15) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z) {
            i8 = 2;
        } else {
            i8 = 0;
        }
        int m900c3 = m900c(cArr, i5, 'm', m900c2, z3, i8);
        if (m900c3 != i15) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z) {
            i9 = 2;
        } else {
            i9 = 0;
        }
        int m900c4 = m900c(cArr, i4, 's', m900c3, z4, i9);
        if (z && m900c4 != i15) {
            i10 = 3;
        } else {
            i10 = 0;
        }
        int m900c5 = m900c(cArr, i13, 'm', m900c4, true, i10);
        cArr[m900c5] = 's';
        return m900c5 + 1;
    }

    /* renamed from: c */
    public static int m900c(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (z || i > 0) {
            if ((z && i3 >= 3) || i > 99) {
                int i5 = i / 100;
                cArr[i2] = (char) (i5 + 48);
                i4 = i2 + 1;
                i -= i5 * 100;
            } else {
                i4 = i2;
            }
            if ((z && i3 >= 2) || i > 9 || i2 != i4) {
                int i6 = i / 10;
                cArr[i4] = (char) (i6 + 48);
                i4++;
                i -= i6 * 10;
            }
            cArr[i4] = (char) (i + 48);
            cArr[i4 + 1] = c;
            return i4 + 2;
        }
        return i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (f3849a) {
            sb.append(f3850b, 0, m899b(0, j));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (f3849a) {
            printWriter.print(new String(f3850b, 0, m899b(i, j)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }
}
