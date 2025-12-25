package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Objects;
import kotlin.UShort;
import p000.aa2;
import p000.o63;
import p000.y92;
import p000.z92;

/* renamed from: com.google.common.collect.i2 */
/* loaded from: classes.dex */
public final class C0884i2 extends ImmutableMap {

    /* renamed from: i */
    public static final C0884i2 f14851i = new C0884i2(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final transient Object f14852f;

    /* renamed from: g */
    public final transient Object[] f14853g;

    /* renamed from: h */
    public final transient int f14854h;

    public C0884i2(Object obj, Object[] objArr, int i) {
        this.f14852f = obj;
        this.f14853g = objArr;
        this.f14854h = i;
    }

    /* renamed from: j */
    public static C0884i2 m4117j(int i, Object[] objArr, ImmutableMap.Builder builder) {
        if (i == 0) {
            return f14851i;
        }
        if (i == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new C0884i2(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        Object m4118k = m4118k(objArr, i, ImmutableSet.m3969f(i), 0);
        if (m4118k instanceof Object[]) {
            Object[] objArr2 = (Object[]) m4118k;
            C0842a0 c0842a0 = (C0842a0) objArr2[2];
            if (builder != null) {
                builder.f14674e = c0842a0;
                Object obj = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                m4118k = obj;
                i = intValue;
            } else {
                throw c0842a0.m4080a();
            }
        }
        return new C0884i2(m4118k, objArr, i);
    }

    /* renamed from: k */
    public static Object m4118k(Object[] objArr, int i, int i2, int i3) {
        C0842a0 c0842a0 = null;
        if (i == 1) {
            Objects.requireNonNull(objArr[i3]);
            Objects.requireNonNull(objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int i5 = -1;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = (i7 * 2) + i3;
                int i9 = (i6 * 2) + i3;
                Object obj = objArr[i8];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i8 ^ 1];
                Objects.requireNonNull(obj2);
                int m6453M = o63.m6453M(obj.hashCode());
                while (true) {
                    int i10 = m6453M & i4;
                    int i11 = bArr[i10] & 255;
                    if (i11 == 255) {
                        bArr[i10] = (byte) i9;
                        if (i6 < i7) {
                            objArr[i9] = obj;
                            objArr[i9 ^ 1] = obj2;
                        }
                        i6++;
                    } else {
                        if (obj.equals(objArr[i11])) {
                            int i12 = i11 ^ 1;
                            Object obj3 = objArr[i12];
                            Objects.requireNonNull(obj3);
                            c0842a0 = new C0842a0(obj, obj2, obj3);
                            objArr[i12] = obj2;
                            break;
                        }
                        m6453M = i10 + 1;
                    }
                }
            }
            if (i6 != i) {
                return new Object[]{bArr, Integer.valueOf(i6), c0842a0};
            }
            return bArr;
        }
        if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            int i13 = 0;
            for (int i14 = 0; i14 < i; i14++) {
                int i15 = (i14 * 2) + i3;
                int i16 = (i13 * 2) + i3;
                Object obj4 = objArr[i15];
                Objects.requireNonNull(obj4);
                Object obj5 = objArr[i15 ^ 1];
                Objects.requireNonNull(obj5);
                int m6453M2 = o63.m6453M(obj4.hashCode());
                while (true) {
                    int i17 = m6453M2 & i4;
                    int i18 = sArr[i17] & UShort.MAX_VALUE;
                    if (i18 == 65535) {
                        sArr[i17] = (short) i16;
                        if (i13 < i14) {
                            objArr[i16] = obj4;
                            objArr[i16 ^ 1] = obj5;
                        }
                        i13++;
                    } else {
                        if (obj4.equals(objArr[i18])) {
                            int i19 = i18 ^ 1;
                            Object obj6 = objArr[i19];
                            Objects.requireNonNull(obj6);
                            c0842a0 = new C0842a0(obj4, obj5, obj6);
                            objArr[i19] = obj5;
                            break;
                        }
                        m6453M2 = i17 + 1;
                    }
                }
            }
            if (i13 != i) {
                return new Object[]{sArr, Integer.valueOf(i13), c0842a0};
            }
            return sArr;
        }
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i20 = 0;
        int i21 = 0;
        while (i20 < i) {
            int i22 = (i20 * 2) + i3;
            int i23 = (i21 * 2) + i3;
            Object obj7 = objArr[i22];
            Objects.requireNonNull(obj7);
            Object obj8 = objArr[i22 ^ 1];
            Objects.requireNonNull(obj8);
            int m6453M3 = o63.m6453M(obj7.hashCode());
            while (true) {
                int i24 = m6453M3 & i4;
                int i25 = iArr[i24];
                if (i25 == i5) {
                    iArr[i24] = i23;
                    if (i21 < i20) {
                        objArr[i23] = obj7;
                        objArr[i23 ^ 1] = obj8;
                    }
                    i21++;
                } else {
                    if (obj7.equals(objArr[i25])) {
                        int i26 = i25 ^ 1;
                        Object obj9 = objArr[i26];
                        Objects.requireNonNull(obj9);
                        c0842a0 = new C0842a0(obj7, obj8, obj9);
                        objArr[i26] = obj8;
                        break;
                    }
                    m6453M3 = i24 + 1;
                    i5 = -1;
                }
            }
            i20++;
            i5 = -1;
        }
        if (i21 != i) {
            return new Object[]{iArr, Integer.valueOf(i21), c0842a0};
        }
        return iArr;
    }

    /* renamed from: l */
    public static Object m4119l(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int m6453M = o63.m6453M(obj2.hashCode());
            while (true) {
                int i3 = m6453M & length;
                int i4 = bArr[i3] & 255;
                if (i4 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i4])) {
                    return objArr[i4 ^ 1];
                }
                m6453M = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int m6453M2 = o63.m6453M(obj2.hashCode());
            while (true) {
                int i5 = m6453M2 & length2;
                int i6 = sArr[i5] & UShort.MAX_VALUE;
                if (i6 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                m6453M2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int m6453M3 = o63.m6453M(obj2.hashCode());
            while (true) {
                int i7 = m6453M3 & length3;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                m6453M3 = i7 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: a */
    public final ImmutableSet mo3934a() {
        return new y92(this, this.f14853g, 0, this.f14854h);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: c */
    public final ImmutableSet mo3935c() {
        return new z92(this, new aa2(0, this.f14854h, this.f14853g));
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: e */
    public final ImmutableCollection mo3893e() {
        return new aa2(1, this.f14854h, this.f14853g);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object m4119l = m4119l(this.f14852f, this.f14853g, this.f14854h, 0, obj);
        if (m4119l == null) {
            return null;
        }
        return m4119l;
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        return false;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f14854h;
    }
}
