package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class KeyFrameArray {

    /* loaded from: classes.dex */
    public static class CustomArray {

        /* renamed from: a */
        public final int[] f2187a = new int[101];

        /* renamed from: b */
        public final CustomAttribute[] f2188b = new CustomAttribute[101];

        /* renamed from: c */
        public int f2189c;

        public CustomArray() {
            clear();
        }

        public void append(int i, CustomAttribute customAttribute) {
            CustomAttribute[] customAttributeArr = this.f2188b;
            if (customAttributeArr[i] != null) {
                remove(i);
            }
            customAttributeArr[i] = customAttribute;
            int i2 = this.f2189c;
            this.f2189c = i2 + 1;
            int[] iArr = this.f2187a;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f2187a, 999);
            Arrays.fill(this.f2188b, (Object) null);
            this.f2189c = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f2187a, this.f2189c)));
            printStream.print("K: [");
            for (int i = 0; i < this.f2189c; i++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(valueAt(i));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.f2187a[i];
        }

        public void remove(int i) {
            this.f2188b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f2189c;
                if (i2 < i4) {
                    int[] iArr = this.f2187a;
                    if (i == iArr[i2]) {
                        iArr[i2] = 999;
                        i3++;
                    }
                    if (i2 != i3) {
                        iArr[i2] = iArr[i3];
                    }
                    i3++;
                    i2++;
                } else {
                    this.f2189c = i4 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.f2189c;
        }

        public CustomAttribute valueAt(int i) {
            return this.f2188b[this.f2187a[i]];
        }
    }

    /* loaded from: classes.dex */
    public static class CustomVar {

        /* renamed from: a */
        public final int[] f2190a = new int[101];

        /* renamed from: b */
        public final CustomVariable[] f2191b = new CustomVariable[101];

        /* renamed from: c */
        public int f2192c;

        public CustomVar() {
            clear();
        }

        public void append(int i, CustomVariable customVariable) {
            CustomVariable[] customVariableArr = this.f2191b;
            if (customVariableArr[i] != null) {
                remove(i);
            }
            customVariableArr[i] = customVariable;
            int i2 = this.f2192c;
            this.f2192c = i2 + 1;
            int[] iArr = this.f2190a;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f2190a, 999);
            Arrays.fill(this.f2191b, (Object) null);
            this.f2192c = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f2190a, this.f2192c)));
            printStream.print("K: [");
            for (int i = 0; i < this.f2192c; i++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(valueAt(i));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.f2190a[i];
        }

        public void remove(int i) {
            this.f2191b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f2192c;
                if (i2 < i4) {
                    int[] iArr = this.f2190a;
                    if (i == iArr[i2]) {
                        iArr[i2] = 999;
                        i3++;
                    }
                    if (i2 != i3) {
                        iArr[i2] = iArr[i3];
                    }
                    i3++;
                    i2++;
                } else {
                    this.f2192c = i4 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.f2192c;
        }

        public CustomVariable valueAt(int i) {
            return this.f2191b[this.f2190a[i]];
        }
    }
}
