package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class TypedBundle {

    /* renamed from: a */
    public int[] f2257a = new int[10];

    /* renamed from: b */
    public int[] f2258b = new int[10];

    /* renamed from: c */
    public int f2259c = 0;

    /* renamed from: d */
    public int[] f2260d = new int[10];

    /* renamed from: e */
    public float[] f2261e = new float[10];

    /* renamed from: f */
    public int f2262f = 0;

    /* renamed from: g */
    public int[] f2263g = new int[5];

    /* renamed from: h */
    public String[] f2264h = new String[5];

    /* renamed from: i */
    public int f2265i = 0;

    /* renamed from: j */
    public int[] f2266j = new int[4];

    /* renamed from: k */
    public boolean[] f2267k = new boolean[4];

    /* renamed from: l */
    public int f2268l = 0;

    public void add(int i, int i2) {
        int i3 = this.f2259c;
        int[] iArr = this.f2257a;
        if (i3 >= iArr.length) {
            this.f2257a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f2258b;
            this.f2258b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f2257a;
        int i4 = this.f2259c;
        iArr3[i4] = i;
        int[] iArr4 = this.f2258b;
        this.f2259c = i4 + 1;
        iArr4[i4] = i2;
    }

    public void addIfNotNull(int i, String str) {
        if (str != null) {
            add(i, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i = 0; i < this.f2259c; i++) {
            typedValues.setValue(this.f2257a[i], this.f2258b[i]);
        }
        for (int i2 = 0; i2 < this.f2262f; i2++) {
            typedValues.setValue(this.f2260d[i2], this.f2261e[i2]);
        }
        for (int i3 = 0; i3 < this.f2265i; i3++) {
            typedValues.setValue(this.f2263g[i3], this.f2264h[i3]);
        }
        for (int i4 = 0; i4 < this.f2268l; i4++) {
            typedValues.setValue(this.f2266j[i4], this.f2267k[i4]);
        }
    }

    public void clear() {
        this.f2268l = 0;
        this.f2265i = 0;
        this.f2262f = 0;
        this.f2259c = 0;
    }

    public int getInteger(int i) {
        for (int i2 = 0; i2 < this.f2259c; i2++) {
            if (this.f2257a[i2] == i) {
                return this.f2258b[i2];
            }
        }
        return -1;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.f2259c + ", mCountFloat=" + this.f2262f + ", mCountString=" + this.f2265i + ", mCountBoolean=" + this.f2268l + '}';
    }

    public void add(int i, float f) {
        int i2 = this.f2262f;
        int[] iArr = this.f2260d;
        if (i2 >= iArr.length) {
            this.f2260d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f2261e;
            this.f2261e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f2260d;
        int i3 = this.f2262f;
        iArr2[i3] = i;
        float[] fArr2 = this.f2261e;
        this.f2262f = i3 + 1;
        fArr2[i3] = f;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i = 0; i < this.f2259c; i++) {
            typedBundle.add(this.f2257a[i], this.f2258b[i]);
        }
        for (int i2 = 0; i2 < this.f2262f; i2++) {
            typedBundle.add(this.f2260d[i2], this.f2261e[i2]);
        }
        for (int i3 = 0; i3 < this.f2265i; i3++) {
            typedBundle.add(this.f2263g[i3], this.f2264h[i3]);
        }
        for (int i4 = 0; i4 < this.f2268l; i4++) {
            typedBundle.add(this.f2266j[i4], this.f2267k[i4]);
        }
    }

    public void add(int i, String str) {
        int i2 = this.f2265i;
        int[] iArr = this.f2263g;
        if (i2 >= iArr.length) {
            this.f2263g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f2264h;
            this.f2264h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f2263g;
        int i3 = this.f2265i;
        iArr2[i3] = i;
        String[] strArr2 = this.f2264h;
        this.f2265i = i3 + 1;
        strArr2[i3] = str;
    }

    public void add(int i, boolean z) {
        int i2 = this.f2268l;
        int[] iArr = this.f2266j;
        if (i2 >= iArr.length) {
            this.f2266j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f2267k;
            this.f2267k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f2266j;
        int i3 = this.f2268l;
        iArr2[i3] = i;
        boolean[] zArr2 = this.f2267k;
        this.f2268l = i3 + 1;
        zArr2[i3] = z;
    }
}
