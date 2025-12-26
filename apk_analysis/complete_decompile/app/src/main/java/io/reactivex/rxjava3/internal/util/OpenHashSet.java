package io.reactivex.rxjava3.internal.util;

/* loaded from: classes2.dex */
public final class OpenHashSet<T> {

    /* renamed from: a */
    public final float f19961a;

    /* renamed from: b */
    public int f19962b;

    /* renamed from: c */
    public int f19963c;

    /* renamed from: d */
    public int f19964d;

    /* renamed from: e */
    public Object[] f19965e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    /* renamed from: a */
    public final void m5301a(int i, int i2, Object[] objArr) {
        int i3;
        Object obj;
        this.f19963c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                obj = objArr[i3];
                if (obj == null) {
                    objArr[i] = null;
                    return;
                }
                int hashCode = obj.hashCode() * (-1640531527);
                int i5 = (hashCode ^ (hashCode >>> 16)) & i2;
                if (i <= i3) {
                    if (i < i5 && i5 <= i3) {
                        i4 = i3 + 1;
                    }
                } else {
                    if (i >= i5 && i5 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            objArr[i] = obj;
            i = i3;
        }
    }

    public boolean add(T t) {
        Object obj;
        Object obj2;
        Object[] objArr = this.f19965e;
        int i = this.f19962b;
        int hashCode = t.hashCode() * (-1640531527);
        int i2 = (hashCode ^ (hashCode >>> 16)) & i;
        Object obj3 = objArr[i2];
        if (obj3 != null) {
            if (obj3.equals(t)) {
                return false;
            }
            do {
                i2 = (i2 + 1) & i;
                obj2 = objArr[i2];
                if (obj2 == null) {
                }
            } while (!obj2.equals(t));
            return false;
        }
        objArr[i2] = t;
        int i3 = this.f19963c + 1;
        this.f19963c = i3;
        if (i3 >= this.f19964d) {
            Object[] objArr2 = this.f19965e;
            int length = objArr2.length;
            int i4 = length << 1;
            int i5 = i4 - 1;
            Object[] objArr3 = new Object[i4];
            while (true) {
                int i6 = i3 - 1;
                if (i3 == 0) {
                    break;
                }
                do {
                    length--;
                    obj = objArr2[length];
                } while (obj == null);
                int hashCode2 = obj.hashCode() * (-1640531527);
                int i7 = (hashCode2 ^ (hashCode2 >>> 16)) & i5;
                if (objArr3[i7] == null) {
                    objArr3[i7] = objArr2[length];
                    i3 = i6;
                }
                do {
                    i7 = (i7 + 1) & i5;
                } while (objArr3[i7] != null);
                objArr3[i7] = objArr2[length];
                i3 = i6;
            }
            this.f19962b = i5;
            this.f19964d = (int) (i4 * this.f19961a);
            this.f19965e = objArr3;
        }
        return true;
    }

    public Object[] keys() {
        return this.f19965e;
    }

    public boolean remove(T t) {
        Object obj;
        Object[] objArr = this.f19965e;
        int i = this.f19962b;
        int hashCode = t.hashCode() * (-1640531527);
        int i2 = (hashCode ^ (hashCode >>> 16)) & i;
        Object obj2 = objArr[i2];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(t)) {
            m5301a(i2, i, objArr);
            return true;
        }
        do {
            i2 = (i2 + 1) & i;
            obj = objArr[i2];
            if (obj == null) {
                return false;
            }
        } while (!obj.equals(t));
        m5301a(i2, i, objArr);
        return true;
    }

    public int size() {
        return this.f19963c;
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.f19961a = f;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.f19962b = roundToPowerOfTwo - 1;
        this.f19964d = (int) (f * roundToPowerOfTwo);
        this.f19965e = new Object[roundToPowerOfTwo];
    }
}
