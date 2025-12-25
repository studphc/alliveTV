package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import p000.ad3;
import p000.ge3;
import p000.hd3;
import p000.ie3;
import p000.ke3;
import p000.le3;
import p000.md3;
import p000.oc3;
import p000.p63;
import p000.rd3;
import p000.ud3;
import p000.wc3;
import p000.wd3;
import p000.xd3;
import p000.yd3;
import p000.ye0;
import p000.yy2;
import p000.z93;
import p000.zd3;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.d */
/* loaded from: classes.dex */
public final class C0784d implements xd3 {

    /* renamed from: l */
    public static final int[] f13752l = new int[0];

    /* renamed from: m */
    public static final Unsafe f13753m = ie3.m5221j();

    /* renamed from: a */
    public final int[] f13754a;

    /* renamed from: b */
    public final Object[] f13755b;

    /* renamed from: c */
    public final int f13756c;

    /* renamed from: d */
    public final int f13757d;

    /* renamed from: e */
    public final zznh f13758e;

    /* renamed from: f */
    public final boolean f13759f;

    /* renamed from: g */
    public final int[] f13760g;

    /* renamed from: h */
    public final int f13761h;

    /* renamed from: i */
    public final int f13762i;

    /* renamed from: j */
    public final C0782b f13763j;

    /* renamed from: k */
    public final C0782b f13764k;

    public C0784d(int[] iArr, Object[] objArr, int i, int i2, zznh zznhVar, int[] iArr2, int i3, int i4, C0782b c0782b, C0782b c0782b2) {
        this.f13754a = iArr;
        this.f13755b = objArr;
        this.f13756c = i;
        this.f13757d = i2;
        boolean z = false;
        if (c0782b2 != null && (zznhVar instanceof zzma)) {
            z = true;
        }
        this.f13759f = z;
        this.f13760g = iArr2;
        this.f13761h = i3;
        this.f13762i = i4;
        this.f13763j = c0782b;
        this.f13764k = c0782b2;
        this.f13758e = zznhVar;
    }

    /* renamed from: E */
    public static Field m3223E(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* renamed from: q */
    public static boolean m3224q(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmd) {
            return ((zzmd) obj).m3474f();
        }
        return true;
    }

    /* renamed from: t */
    public static zzof m3225t(Object obj) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        if (zzofVar == zzof.zzc()) {
            zzof m3477a = zzof.m3477a();
            zzmdVar.zzc = m3477a;
            return m3477a;
        }
        return zzofVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026a  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0784d m3226u(wd3 wd3Var, C0782b c0782b, C0782b c0782b2) {
        int i;
        int charAt;
        int charAt2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        char charAt3;
        int i8;
        char charAt4;
        int i9;
        char charAt5;
        int i10;
        char charAt6;
        int i11;
        char charAt7;
        int i12;
        char charAt8;
        int i13;
        char charAt9;
        int i14;
        char charAt10;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        String str;
        int i22;
        int i23;
        int i24;
        Field m3223E;
        int i25;
        char charAt11;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        Object obj;
        Field m3223E2;
        Object obj2;
        Field m3223E3;
        int i33;
        char charAt12;
        int i34;
        char charAt13;
        int i35;
        char charAt14;
        int i36;
        char charAt15;
        if (wd3Var instanceof wd3) {
            String m8051c = wd3Var.m8051c();
            int length = m8051c.length();
            char c = 55296;
            if (m8051c.charAt(0) >= 55296) {
                int i37 = 1;
                while (true) {
                    i = i37 + 1;
                    if (m8051c.charAt(i37) < 55296) {
                        break;
                    }
                    i37 = i;
                }
            } else {
                i = 1;
            }
            int i38 = i + 1;
            int charAt16 = m8051c.charAt(i);
            if (charAt16 >= 55296) {
                int i39 = charAt16 & 8191;
                int i40 = 13;
                while (true) {
                    i36 = i38 + 1;
                    charAt15 = m8051c.charAt(i38);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i39 |= (charAt15 & 8191) << i40;
                    i40 += 13;
                    i38 = i36;
                }
                charAt16 = i39 | (charAt15 << i40);
                i38 = i36;
            }
            if (charAt16 == 0) {
                i3 = 0;
                charAt = 0;
                charAt2 = 0;
                i2 = 0;
                i5 = 0;
                i4 = 0;
                iArr = f13752l;
                i6 = 0;
            } else {
                int i41 = i38 + 1;
                int charAt17 = m8051c.charAt(i38);
                if (charAt17 >= 55296) {
                    int i42 = charAt17 & 8191;
                    int i43 = 13;
                    while (true) {
                        i14 = i41 + 1;
                        charAt10 = m8051c.charAt(i41);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i42 |= (charAt10 & 8191) << i43;
                        i43 += 13;
                        i41 = i14;
                    }
                    charAt17 = i42 | (charAt10 << i43);
                    i41 = i14;
                }
                int i44 = i41 + 1;
                int charAt18 = m8051c.charAt(i41);
                if (charAt18 >= 55296) {
                    int i45 = charAt18 & 8191;
                    int i46 = 13;
                    while (true) {
                        i13 = i44 + 1;
                        charAt9 = m8051c.charAt(i44);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i45 |= (charAt9 & 8191) << i46;
                        i46 += 13;
                        i44 = i13;
                    }
                    charAt18 = i45 | (charAt9 << i46);
                    i44 = i13;
                }
                int i47 = i44 + 1;
                int charAt19 = m8051c.charAt(i44);
                if (charAt19 >= 55296) {
                    int i48 = charAt19 & 8191;
                    int i49 = 13;
                    while (true) {
                        i12 = i47 + 1;
                        charAt8 = m8051c.charAt(i47);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i48 |= (charAt8 & 8191) << i49;
                        i49 += 13;
                        i47 = i12;
                    }
                    charAt19 = i48 | (charAt8 << i49);
                    i47 = i12;
                }
                int i50 = i47 + 1;
                int charAt20 = m8051c.charAt(i47);
                if (charAt20 >= 55296) {
                    int i51 = charAt20 & 8191;
                    int i52 = 13;
                    while (true) {
                        i11 = i50 + 1;
                        charAt7 = m8051c.charAt(i50);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i51 |= (charAt7 & 8191) << i52;
                        i52 += 13;
                        i50 = i11;
                    }
                    charAt20 = i51 | (charAt7 << i52);
                    i50 = i11;
                }
                int i53 = i50 + 1;
                charAt = m8051c.charAt(i50);
                if (charAt >= 55296) {
                    int i54 = charAt & 8191;
                    int i55 = 13;
                    while (true) {
                        i10 = i53 + 1;
                        charAt6 = m8051c.charAt(i53);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i54 |= (charAt6 & 8191) << i55;
                        i55 += 13;
                        i53 = i10;
                    }
                    charAt = i54 | (charAt6 << i55);
                    i53 = i10;
                }
                int i56 = i53 + 1;
                charAt2 = m8051c.charAt(i53);
                if (charAt2 >= 55296) {
                    int i57 = charAt2 & 8191;
                    int i58 = 13;
                    while (true) {
                        i9 = i56 + 1;
                        charAt5 = m8051c.charAt(i56);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i57 |= (charAt5 & 8191) << i58;
                        i58 += 13;
                        i56 = i9;
                    }
                    charAt2 = i57 | (charAt5 << i58);
                    i56 = i9;
                }
                int i59 = i56 + 1;
                int charAt21 = m8051c.charAt(i56);
                if (charAt21 >= 55296) {
                    int i60 = charAt21 & 8191;
                    int i61 = 13;
                    while (true) {
                        i8 = i59 + 1;
                        charAt4 = m8051c.charAt(i59);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i60 |= (charAt4 & 8191) << i61;
                        i61 += 13;
                        i59 = i8;
                    }
                    charAt21 = i60 | (charAt4 << i61);
                    i59 = i8;
                }
                int i62 = i59 + 1;
                int charAt22 = m8051c.charAt(i59);
                if (charAt22 >= 55296) {
                    int i63 = charAt22 & 8191;
                    int i64 = 13;
                    while (true) {
                        i7 = i62 + 1;
                        charAt3 = m8051c.charAt(i62);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i63 |= (charAt3 & 8191) << i64;
                        i64 += 13;
                        i62 = i7;
                    }
                    charAt22 = i63 | (charAt3 << i64);
                    i62 = i7;
                }
                int i65 = charAt17 + charAt17 + charAt18;
                int[] iArr2 = new int[charAt22 + charAt2 + charAt21];
                i2 = charAt19;
                i3 = i65;
                i4 = charAt22;
                i5 = charAt20;
                i6 = charAt17;
                i38 = i62;
                iArr = iArr2;
            }
            Unsafe unsafe = f13753m;
            Object[] m8052d = wd3Var.m8052d();
            Class<?> cls = wd3Var.m8049a().getClass();
            int i66 = i4 + charAt2;
            int i67 = charAt + charAt;
            int[] iArr3 = new int[charAt * 3];
            Object[] objArr = new Object[i67];
            int i68 = i4;
            int i69 = i66;
            int i70 = 0;
            int i71 = 0;
            while (i38 < length) {
                int i72 = i38 + 1;
                int charAt23 = m8051c.charAt(i38);
                if (charAt23 >= c) {
                    int i73 = charAt23 & 8191;
                    int i74 = i72;
                    int i75 = 13;
                    while (true) {
                        i35 = i74 + 1;
                        charAt14 = m8051c.charAt(i74);
                        if (charAt14 < c) {
                            break;
                        }
                        i73 |= (charAt14 & 8191) << i75;
                        i75 += 13;
                        i74 = i35;
                    }
                    charAt23 = i73 | (charAt14 << i75);
                    i15 = i35;
                } else {
                    i15 = i72;
                }
                int i76 = i15 + 1;
                int charAt24 = m8051c.charAt(i15);
                if (charAt24 >= c) {
                    int i77 = charAt24 & 8191;
                    int i78 = i76;
                    int i79 = 13;
                    while (true) {
                        i34 = i78 + 1;
                        charAt13 = m8051c.charAt(i78);
                        if (charAt13 < c) {
                            break;
                        }
                        i77 |= (charAt13 & 8191) << i79;
                        i79 += 13;
                        i78 = i34;
                    }
                    charAt24 = i77 | (charAt13 << i79);
                    i16 = i34;
                } else {
                    i16 = i76;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i70] = i71;
                    i70++;
                }
                int i80 = charAt24 & 255;
                int i81 = charAt24 & 2048;
                int i82 = length;
                if (i80 >= 51) {
                    int i83 = i16 + 1;
                    int charAt25 = m8051c.charAt(i16);
                    char c2 = 55296;
                    if (charAt25 >= 55296) {
                        int i84 = 13;
                        int i85 = charAt25 & 8191;
                        int i86 = i83;
                        while (true) {
                            i33 = i86 + 1;
                            charAt12 = m8051c.charAt(i86);
                            if (charAt12 < c2) {
                                break;
                            }
                            i85 |= (charAt12 & 8191) << i84;
                            i84 += 13;
                            i86 = i33;
                            c2 = 55296;
                        }
                        charAt25 = i85 | (charAt12 << i84);
                        i31 = i33;
                    } else {
                        i31 = i83;
                    }
                    int i87 = i31;
                    int i88 = i80 - 51;
                    i18 = i5;
                    if (i88 != 9 && i88 != 17) {
                        if (i88 == 12) {
                            if (wd3Var.m8050b() != 1 && i81 == 0) {
                                i81 = 0;
                            } else {
                                i32 = i3 + 1;
                                int i89 = i71 / 3;
                                objArr[i89 + i89 + 1] = m8052d[i3];
                            }
                        }
                        int i90 = charAt25 + charAt25;
                        obj = m8052d[i90];
                        if (!(obj instanceof Field)) {
                            m3223E2 = (Field) obj;
                        } else {
                            m3223E2 = m3223E(cls, (String) obj);
                            m8052d[i90] = m3223E2;
                        }
                        i17 = i2;
                        i24 = (int) unsafe.objectFieldOffset(m3223E2);
                        int i91 = i90 + 1;
                        obj2 = m8052d[i91];
                        if (!(obj2 instanceof Field)) {
                            m3223E3 = (Field) obj2;
                        } else {
                            m3223E3 = m3223E(cls, (String) obj2);
                            m8052d[i91] = m3223E3;
                        }
                        i21 = i81;
                        str = m8051c;
                        i19 = charAt23;
                        i20 = (int) unsafe.objectFieldOffset(m3223E3);
                        i38 = i87;
                        i23 = 0;
                    } else {
                        i32 = i3 + 1;
                        int i92 = i71 / 3;
                        objArr[i92 + i92 + 1] = m8052d[i3];
                    }
                    i3 = i32;
                    int i902 = charAt25 + charAt25;
                    obj = m8052d[i902];
                    if (!(obj instanceof Field)) {
                    }
                    i17 = i2;
                    i24 = (int) unsafe.objectFieldOffset(m3223E2);
                    int i912 = i902 + 1;
                    obj2 = m8052d[i912];
                    if (!(obj2 instanceof Field)) {
                    }
                    i21 = i81;
                    str = m8051c;
                    i19 = charAt23;
                    i20 = (int) unsafe.objectFieldOffset(m3223E3);
                    i38 = i87;
                    i23 = 0;
                } else {
                    i17 = i2;
                    i18 = i5;
                    int i93 = i3 + 1;
                    Field m3223E4 = m3223E(cls, (String) m8052d[i3]);
                    if (i80 == 9 || i80 == 17) {
                        i19 = charAt23;
                        int i94 = i71 / 3;
                        objArr[i94 + i94 + 1] = m3223E4.getType();
                    } else {
                        if (i80 != 27) {
                            if (i80 == 49) {
                                i27 = i3 + 2;
                                i19 = charAt23;
                                i26 = 1;
                            } else if (i80 != 12 && i80 != 30 && i80 != 44) {
                                if (i80 == 50) {
                                    int i95 = i3 + 2;
                                    int i96 = i68 + 1;
                                    iArr[i68] = i71;
                                    int i97 = i71 / 3;
                                    int i98 = i97 + i97;
                                    objArr[i98] = m8052d[i93];
                                    if (i81 != 0) {
                                        i93 = i3 + 3;
                                        objArr[i98 + 1] = m8052d[i95];
                                        i68 = i96;
                                    } else {
                                        i93 = i95;
                                        i68 = i96;
                                        i81 = 0;
                                    }
                                }
                                i19 = charAt23;
                            } else {
                                i19 = charAt23;
                                if (wd3Var.m8050b() != 1 && i81 == 0) {
                                    i81 = 0;
                                } else {
                                    i27 = i3 + 2;
                                    int i99 = i71 / 3;
                                    objArr[i99 + i99 + 1] = m8052d[i93];
                                    i93 = i27;
                                }
                            }
                        } else {
                            i19 = charAt23;
                            i26 = 1;
                            i27 = i3 + 2;
                        }
                        int i100 = i71 / 3;
                        objArr[i100 + i100 + i26] = m8052d[i93];
                        i93 = i27;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(m3223E4);
                    i20 = 1048575;
                    if ((charAt24 & 4096) != 0 && i80 <= 17) {
                        i22 = i16 + 1;
                        int charAt26 = m8051c.charAt(i16);
                        if (charAt26 >= 55296) {
                            int i101 = charAt26 & 8191;
                            int i102 = 13;
                            while (true) {
                                i25 = i22 + 1;
                                charAt11 = m8051c.charAt(i22);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i101 |= (charAt11 & 8191) << i102;
                                i102 += 13;
                                i22 = i25;
                            }
                            charAt26 = i101 | (charAt11 << i102);
                            i22 = i25;
                        }
                        int i103 = (charAt26 / 32) + i6 + i6;
                        Object obj3 = m8052d[i103];
                        if (obj3 instanceof Field) {
                            m3223E = (Field) obj3;
                        } else {
                            m3223E = m3223E(cls, (String) obj3);
                            m8052d[i103] = m3223E;
                        }
                        i21 = i81;
                        str = m8051c;
                        i23 = charAt26 % 32;
                        i20 = (int) unsafe.objectFieldOffset(m3223E);
                    } else {
                        i21 = i81;
                        str = m8051c;
                        i22 = i16;
                        i23 = 0;
                    }
                    if (i80 >= 18 && i80 <= 49) {
                        iArr[i69] = objectFieldOffset;
                        i69++;
                    }
                    i38 = i22;
                    i3 = i93;
                    i24 = objectFieldOffset;
                }
                int i104 = i71 + 1;
                iArr3[i71] = i19;
                int i105 = i71 + 2;
                if ((charAt24 & 512) != 0) {
                    i28 = 536870912;
                } else {
                    i28 = 0;
                }
                if ((charAt24 & 256) != 0) {
                    i29 = 268435456;
                } else {
                    i29 = 0;
                }
                if (i21 != 0) {
                    i30 = Integer.MIN_VALUE;
                } else {
                    i30 = 0;
                }
                iArr3[i104] = i28 | i29 | i30 | (i80 << 20) | i24;
                i71 += 3;
                iArr3[i105] = (i23 << 20) | i20;
                m8051c = str;
                length = i82;
                i5 = i18;
                i2 = i17;
                c = 55296;
            }
            return new C0784d(iArr3, objArr, i2, i5, wd3Var.m8049a(), iArr, i4, i66, c0782b, c0782b2);
        }
        ye0.m8280C(wd3Var);
        throw null;
    }

    /* renamed from: v */
    public static int m3227v(Object obj, long j) {
        return ((Integer) ie3.m5220i(obj, j)).intValue();
    }

    /* renamed from: x */
    public static int m3228x(int i) {
        return (i >>> 20) & 255;
    }

    /* renamed from: z */
    public static long m3229z(Object obj, long j) {
        return ((Long) ie3.m5220i(obj, j)).longValue();
    }

    /* renamed from: A */
    public final zzmg m3230A(int i) {
        int i2 = i / 3;
        return (zzmg) this.f13755b[i2 + i2 + 1];
    }

    /* renamed from: B */
    public final xd3 m3231B(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.f13755b;
        xd3 xd3Var = (xd3) objArr[i3];
        if (xd3Var != null) {
            return xd3Var;
        }
        xd3 m7701a = ud3.f27230c.m7701a((Class) objArr[i3 + 1]);
        objArr[i3] = m7701a;
        return m7701a;
    }

    /* renamed from: C */
    public final Object m3232C(int i, Object obj) {
        xd3 m3231B = m3231B(i);
        int m3253y = m3253y(i) & 1048575;
        if (!m3248o(i, obj)) {
            return m3231B.zze();
        }
        Object object = f13753m.getObject(obj, m3253y);
        if (m3224q(object)) {
            return object;
        }
        Object zze = m3231B.zze();
        if (object != null) {
            m3231B.mo3240g(zze, object);
        }
        return zze;
    }

    /* renamed from: D */
    public final Object m3233D(int i, int i2, Object obj) {
        xd3 m3231B = m3231B(i2);
        if (!m3250r(i, i2, obj)) {
            return m3231B.zze();
        }
        Object object = f13753m.getObject(obj, m3253y(i2) & 1048575);
        if (m3224q(object)) {
            return object;
        }
        Object zze = m3231B.zze();
        if (object != null) {
            m3231B.mo3240g(zze, object);
        }
        return zze;
    }

    @Override // p000.xd3
    /* renamed from: a */
    public final void mo3234a(Object obj) {
        if (m3224q(obj)) {
            int i = 0;
            if (obj instanceof zzmd) {
                zzmd zzmdVar = (zzmd) obj;
                zzmdVar.m3473e();
                zzmdVar.zza = 0;
                zzmdVar.m3472d();
            }
            while (true) {
                int[] iArr = this.f13754a;
                if (i < iArr.length) {
                    int m3253y = m3253y(i);
                    int i2 = 1048575 & m3253y;
                    int m3228x = m3228x(m3253y);
                    long j = i2;
                    if (m3228x != 9) {
                        if (m3228x != 60 && m3228x != 68) {
                            switch (m3228x) {
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                    ((zzmj) ie3.m5220i(obj, j)).zzb();
                                    break;
                                case 50:
                                    Unsafe unsafe = f13753m;
                                    Object object = unsafe.getObject(obj, j);
                                    if (object == null) {
                                        break;
                                    } else {
                                        ((zznb) object).zzc();
                                        unsafe.putObject(obj, j, object);
                                        break;
                                    }
                            }
                        } else if (m3250r(iArr[i], i, obj)) {
                            m3231B(i).mo3234a(f13753m.getObject(obj, j));
                        }
                        i += 3;
                    }
                    if (m3248o(i, obj)) {
                        m3231B(i).mo3234a(f13753m.getObject(obj, j));
                    }
                    i += 3;
                } else {
                    this.f13763j.getClass();
                    C0782b.m3219b(obj);
                    if (this.f13759f) {
                        this.f13764k.getClass();
                        C0782b.m3218a(obj);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0065. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:243:0x06a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @Override // p000.xd3
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo3235b(Object obj, le3 le3Var) {
        Map.Entry entry;
        int i;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        Map.Entry entry2;
        boolean z;
        boolean z2;
        ?? r9 = 1;
        if (this.f13759f) {
            ad3 ad3Var = ((zzma) obj).zzb;
            if (!ad3Var.f144a.isEmpty()) {
                entry = (Map.Entry) ad3Var.m71b().next();
                Unsafe unsafe = f13753m;
                i = 1048575;
                i2 = 0;
                i3 = 0;
                while (true) {
                    iArr = this.f13754a;
                    if (i3 >= iArr.length) {
                        int m3253y = m3253y(i3);
                        int m3228x = m3228x(m3253y);
                        int i8 = iArr[i3];
                        if (m3228x <= 17) {
                            int i9 = iArr[i3 + 2];
                            int i10 = i9 & 1048575;
                            if (i10 != i) {
                                if (i10 == 1048575) {
                                    i2 = 0;
                                } else {
                                    i2 = unsafe.getInt(obj, i10);
                                }
                                i = i10;
                            }
                            int i11 = r9 << (i9 >>> 20);
                            i5 = i2;
                            i6 = i11;
                            i4 = i;
                        } else {
                            i4 = i;
                            i5 = i2;
                            i6 = 0;
                        }
                        if (entry == null) {
                            long j = m3253y & 1048575;
                            switch (m3228x) {
                                case 0:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8036i(ie3.m5215d(obj, j), i8);
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 1:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8040m(ie3.m5216e(obj, j), i8);
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 2:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8043p(i8, unsafe.getLong(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 3:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8032e(i8, unsafe.getLong(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 4:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8042o(i8, unsafe.getInt(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 5:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8039l(i8, unsafe.getLong(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 6:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8038k(i8, unsafe.getInt(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 7:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8033f(i8, ie3.m5231t(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 8:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        Object object = unsafe.getObject(obj, j);
                                        if (object instanceof String) {
                                            ((wc3) le3Var).f28137a.zzp(i8, (String) object);
                                        } else {
                                            ((wc3) le3Var).m8034g(i8, (zzld) object);
                                        }
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 9:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8044q(i8, unsafe.getObject(obj, j), m3231B(i3));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 10:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8034g(i8, (zzld) unsafe.getObject(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 11:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8031d(i8, unsafe.getInt(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 12:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8037j(i8, unsafe.getInt(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 13:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8046s(i8, unsafe.getInt(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 14:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8047t(i8, unsafe.getLong(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 15:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i7, i5, i6)) {
                                        ((wc3) le3Var).m8028a(i8, unsafe.getInt(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 16:
                                    i7 = i4;
                                    entry2 = entry;
                                    if (m3249p(obj, i3, i4, i5, i6)) {
                                        ((wc3) le3Var).m8029b(i8, unsafe.getLong(obj, j));
                                    }
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 17:
                                    if (m3249p(obj, i3, i4, i5, i6)) {
                                        ((wc3) le3Var).m8041n(i8, unsafe.getObject(obj, j), m3231B(i3));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 18:
                                    z = false;
                                    AbstractC0786f.m3277u(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 19:
                                    z = false;
                                    AbstractC0786f.m3281y(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 20:
                                    z = false;
                                    AbstractC0786f.m3254A(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 21:
                                    z = false;
                                    AbstractC0786f.m3260d(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 22:
                                    z = false;
                                    AbstractC0786f.m3282z(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 23:
                                    z = false;
                                    AbstractC0786f.m3280x(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 24:
                                    z = false;
                                    AbstractC0786f.m3279w(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 25:
                                    z = false;
                                    AbstractC0786f.m3276t(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 26:
                                    int i12 = iArr[i3];
                                    List list = (List) unsafe.getObject(obj, j);
                                    C0782b c0782b = AbstractC0786f.f13768a;
                                    if (list != null && !list.isEmpty()) {
                                        ((wc3) le3Var).m8030c(i12, list);
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                    break;
                                case 27:
                                    int i13 = iArr[i3];
                                    List list2 = (List) unsafe.getObject(obj, j);
                                    xd3 m3231B = m3231B(i3);
                                    C0782b c0782b2 = AbstractC0786f.f13768a;
                                    if (list2 != null && !list2.isEmpty()) {
                                        for (int i14 = 0; i14 < list2.size(); i14 += r9) {
                                            ((wc3) le3Var).m8044q(i13, list2.get(i14), m3231B);
                                        }
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                    break;
                                case 28:
                                    int i15 = iArr[i3];
                                    List list3 = (List) unsafe.getObject(obj, j);
                                    C0782b c0782b3 = AbstractC0786f.f13768a;
                                    if (list3 != null && !list3.isEmpty()) {
                                        ((wc3) le3Var).m8035h(i15, list3);
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                    break;
                                case 29:
                                    z2 = false;
                                    AbstractC0786f.m3259c(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 30:
                                    z2 = false;
                                    AbstractC0786f.m3278v(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 31:
                                    z2 = false;
                                    AbstractC0786f.m3255B(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 32:
                                    z2 = false;
                                    AbstractC0786f.m3256C(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 33:
                                    z2 = false;
                                    AbstractC0786f.m3257a(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 34:
                                    z2 = false;
                                    AbstractC0786f.m3258b(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, false);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 35:
                                    AbstractC0786f.m3277u(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 36:
                                    AbstractC0786f.m3281y(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 37:
                                    AbstractC0786f.m3254A(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 38:
                                    AbstractC0786f.m3260d(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 39:
                                    AbstractC0786f.m3282z(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 40:
                                    AbstractC0786f.m3280x(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 41:
                                    AbstractC0786f.m3279w(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 42:
                                    AbstractC0786f.m3276t(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 43:
                                    AbstractC0786f.m3259c(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 44:
                                    AbstractC0786f.m3278v(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 45:
                                    AbstractC0786f.m3255B(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 46:
                                    AbstractC0786f.m3256C(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 47:
                                    AbstractC0786f.m3257a(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 48:
                                    AbstractC0786f.m3258b(iArr[i3], (List) unsafe.getObject(obj, j), le3Var, r9);
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 49:
                                    int i16 = iArr[i3];
                                    List list4 = (List) unsafe.getObject(obj, j);
                                    xd3 m3231B2 = m3231B(i3);
                                    C0782b c0782b4 = AbstractC0786f.f13768a;
                                    if (list4 != null && !list4.isEmpty()) {
                                        for (int i17 = 0; i17 < list4.size(); i17 += r9) {
                                            ((wc3) le3Var).m8041n(i16, list4.get(i17), m3231B2);
                                        }
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                    break;
                                case 50:
                                    if (unsafe.getObject(obj, j) != null) {
                                        int i18 = i3 / 3;
                                        throw null;
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 51:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8036i(((Double) ie3.m5220i(obj, j)).doubleValue(), i8);
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 52:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8040m(((Float) ie3.m5220i(obj, j)).floatValue(), i8);
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 53:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8043p(i8, m3229z(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 54:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8032e(i8, m3229z(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 55:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8042o(i8, m3227v(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 56:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8039l(i8, m3229z(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 57:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8038k(i8, m3227v(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 58:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8033f(i8, ((Boolean) ie3.m5220i(obj, j)).booleanValue());
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 59:
                                    if (m3250r(i8, i3, obj)) {
                                        Object object2 = unsafe.getObject(obj, j);
                                        if (object2 instanceof String) {
                                            ((wc3) le3Var).f28137a.zzp(i8, (String) object2);
                                        } else {
                                            ((wc3) le3Var).m8034g(i8, (zzld) object2);
                                        }
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 60:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8044q(i8, unsafe.getObject(obj, j), m3231B(i3));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 61:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8034g(i8, (zzld) unsafe.getObject(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 62:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8031d(i8, m3227v(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 63:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8037j(i8, m3227v(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 64:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8046s(i8, m3227v(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 65:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8047t(i8, m3229z(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 66:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8028a(i8, m3227v(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 67:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8029b(i8, m3229z(obj, j));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                case 68:
                                    if (m3250r(i8, i3, obj)) {
                                        ((wc3) le3Var).m8041n(i8, unsafe.getObject(obj, j), m3231B(i3));
                                    }
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                                default:
                                    i7 = i4;
                                    entry2 = entry;
                                    i3 += 3;
                                    i2 = i5;
                                    entry = entry2;
                                    i = i7;
                                    r9 = 1;
                            }
                        } else {
                            rd3.m7270b(entry.getKey());
                            throw null;
                        }
                    } else {
                        Map.Entry entry3 = entry;
                        if (entry3 == null) {
                            ((zzmd) obj).zzc.zzl(le3Var);
                            return;
                        } else {
                            rd3.m7270b(entry3.getKey());
                            throw null;
                        }
                    }
                }
            }
        }
        entry = null;
        Unsafe unsafe2 = f13753m;
        i = 1048575;
        i2 = 0;
        i3 = 0;
        while (true) {
            iArr = this.f13754a;
            if (i3 >= iArr.length) {
            }
            i3 += 3;
            i2 = i5;
            entry = entry2;
            i = i7;
            r9 = 1;
        }
    }

    @Override // p000.xd3
    /* renamed from: c */
    public final void mo3236c(Object obj, byte[] bArr, int i, int i2, oc3 oc3Var) {
        m3251s(obj, bArr, i, i2, 0, oc3Var);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c7 A[SYNTHETIC] */
    @Override // p000.xd3
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean mo3237d(zzmd zzmdVar, Object obj) {
        boolean m3261e;
        int i = 0;
        while (true) {
            int[] iArr = this.f13754a;
            if (i < iArr.length) {
                int m3253y = m3253y(i);
                long j = m3253y & 1048575;
                switch (m3228x(m3253y)) {
                    case 0:
                        if (!m3247n(zzmdVar, obj, i)) {
                            break;
                        } else {
                            ge3 ge3Var = ie3.f18388c;
                            if (Double.doubleToLongBits(ge3Var.mo4693j(zzmdVar, j)) != Double.doubleToLongBits(ge3Var.mo4693j(obj, j))) {
                                break;
                            } else {
                                i += 3;
                            }
                        }
                    case 1:
                        if (!m3247n(zzmdVar, obj, i)) {
                            break;
                        } else {
                            ge3 ge3Var2 = ie3.f18388c;
                            if (Float.floatToIntBits(ge3Var2.mo4694k(zzmdVar, j)) != Float.floatToIntBits(ge3Var2.mo4694k(obj, j))) {
                                break;
                            } else {
                                i += 3;
                            }
                        }
                    case 2:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5218g(zzmdVar, j) == ie3.m5218g(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 3:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5218g(zzmdVar, j) == ie3.m5218g(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 4:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5217f(zzmdVar, j) == ie3.m5217f(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 5:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5218g(zzmdVar, j) == ie3.m5218g(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 6:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5217f(zzmdVar, j) == ie3.m5217f(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 7:
                        if (!m3247n(zzmdVar, obj, i)) {
                            break;
                        } else {
                            ge3 ge3Var3 = ie3.f18388c;
                            if (ge3Var3.mo4699p(zzmdVar, j) != ge3Var3.mo4699p(obj, j)) {
                                break;
                            } else {
                                i += 3;
                            }
                        }
                    case 8:
                        if (m3247n(zzmdVar, obj, i) && AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j))) {
                            i += 3;
                        }
                        break;
                    case 9:
                        if (m3247n(zzmdVar, obj, i) && AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j))) {
                            i += 3;
                        }
                        break;
                    case 10:
                        if (m3247n(zzmdVar, obj, i) && AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j))) {
                            i += 3;
                        }
                        break;
                    case 11:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5217f(zzmdVar, j) == ie3.m5217f(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 12:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5217f(zzmdVar, j) == ie3.m5217f(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 13:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5217f(zzmdVar, j) == ie3.m5217f(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 14:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5218g(zzmdVar, j) == ie3.m5218g(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 15:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5217f(zzmdVar, j) == ie3.m5217f(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 16:
                        if (m3247n(zzmdVar, obj, i) && ie3.m5218g(zzmdVar, j) == ie3.m5218g(obj, j)) {
                            i += 3;
                        }
                        break;
                    case 17:
                        if (m3247n(zzmdVar, obj, i) && AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j))) {
                            i += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        m3261e = AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j));
                        if (m3261e) {
                            break;
                        } else {
                            i += 3;
                        }
                    case 50:
                        m3261e = AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j));
                        if (m3261e) {
                        }
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        if (ie3.m5217f(zzmdVar, j2) == ie3.m5217f(obj, j2) && AbstractC0786f.m3261e(ie3.m5220i(zzmdVar, j), ie3.m5220i(obj, j))) {
                            i += 3;
                        }
                        break;
                    default:
                        i += 3;
                }
            } else {
                if (!zzmdVar.zzc.equals(((zzmd) obj).zzc)) {
                    return false;
                }
                if (this.f13759f) {
                    return ((zzma) zzmdVar).zzb.equals(((zzma) obj).zzb);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0056. Please report as an issue. */
    @Override // p000.xd3
    /* renamed from: e */
    public final int mo3238e(zzmd zzmdVar) {
        int i;
        int i2;
        int i3;
        int zzz;
        int zzA;
        int zzz2;
        int zzd;
        int zzz3;
        int m3269m;
        int zzz4;
        int size;
        int m3273q;
        int zzz5;
        int zzz6;
        int zzz7;
        int i4;
        Unsafe unsafe = f13753m;
        int i5 = 1048575;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.f13754a;
            if (i8 < iArr.length) {
                int m3253y = m3253y(i8);
                int m3228x = m3228x(m3253y);
                int i10 = iArr[i8];
                int i11 = iArr[i8 + 2];
                int i12 = i11 & i5;
                if (m3228x <= 17) {
                    if (i12 != i6) {
                        if (i12 == i5) {
                            i7 = 0;
                        } else {
                            i7 = unsafe.getInt(zzmdVar, i12);
                        }
                        i6 = i12;
                    }
                    i = i6;
                    i2 = i7;
                    i3 = 1 << (i11 >>> 20);
                } else {
                    i = i6;
                    i2 = i7;
                    i3 = 0;
                }
                int i13 = m3253y & i5;
                if (m3228x >= zzlv.zzJ.zza()) {
                    zzlv.zzW.zza();
                }
                long j = i13;
                switch (m3228x) {
                    case 0:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 8, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 1:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 4, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 2:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            long j2 = unsafe.getLong(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(j2);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 3:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            long j3 = unsafe.getLong(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(j3);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 4:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            long j4 = unsafe.getInt(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(j4);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 5:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 8, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 6:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 4, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 7:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 1, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 8:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            int i14 = i10 << 3;
                            Object object = unsafe.getObject(zzmdVar, j);
                            if (object instanceof zzld) {
                                zzz2 = zzlk.zzz(i14);
                                zzd = ((zzld) object).zzd();
                                zzz3 = zzlk.zzz(zzd);
                                i9 += zzz3 + zzd + zzz2;
                                i8 += 3;
                                i6 = i;
                                i7 = i2;
                                i5 = 1048575;
                            } else {
                                zzz = zzlk.zzz(i14);
                                zzA = zzlk.zzy((String) object);
                                i9 += zzA + zzz;
                                i8 += 3;
                                i6 = i;
                                i7 = i2;
                                i5 = 1048575;
                            }
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 9:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            m3269m = AbstractC0786f.m3269m(i10, unsafe.getObject(zzmdVar, j), m3231B(i8));
                            i9 += m3269m;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 10:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            zzld zzldVar = (zzld) unsafe.getObject(zzmdVar, j);
                            zzz2 = zzlk.zzz(i10 << 3);
                            zzd = zzldVar.zzd();
                            zzz3 = zzlk.zzz(zzd);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 11:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(unsafe.getInt(zzmdVar, j), zzlk.zzz(i10 << 3), i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 12:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            long j5 = unsafe.getInt(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(j5);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 13:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 4, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 14:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            i9 = ye0.m8285e(i10 << 3, 8, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 15:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            int i15 = unsafe.getInt(zzmdVar, j);
                            i9 = ye0.m8285e((i15 >> 31) ^ (i15 + i15), zzlk.zzz(i10 << 3), i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 16:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            long j6 = unsafe.getLong(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA((j6 >> 63) ^ (j6 + j6));
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 17:
                        if (m3249p(zzmdVar, i8, i, i2, i3)) {
                            m3269m = zzlk.m3465b(i10, (zznh) unsafe.getObject(zzmdVar, j), m3231B(i8));
                            i9 += m3269m;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 18:
                        m3269m = AbstractC0786f.m3265i(i10, (List) unsafe.getObject(zzmdVar, j));
                        i9 += m3269m;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 19:
                        m3269m = AbstractC0786f.m3263g(i10, (List) unsafe.getObject(zzmdVar, j));
                        i9 += m3269m;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 20:
                        List list = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b = AbstractC0786f.f13768a;
                        if (list.size() != 0) {
                            zzz4 = (zzlk.zzz(i10 << 3) * list.size()) + AbstractC0786f.m3268l(list);
                            i9 += zzz4;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz4 = 0;
                        i9 += zzz4;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 21:
                        List list2 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b2 = AbstractC0786f.f13768a;
                        size = list2.size();
                        if (size != 0) {
                            m3273q = AbstractC0786f.m3273q(list2);
                            zzz5 = zzlk.zzz(i10 << 3);
                            zzz6 = (zzz5 * size) + m3273q;
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 22:
                        List list3 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b3 = AbstractC0786f.f13768a;
                        size = list3.size();
                        if (size != 0) {
                            m3273q = AbstractC0786f.m3267k(list3);
                            zzz5 = zzlk.zzz(i10 << 3);
                            zzz6 = (zzz5 * size) + m3273q;
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 23:
                        m3269m = AbstractC0786f.m3265i(i10, (List) unsafe.getObject(zzmdVar, j));
                        i9 += m3269m;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 24:
                        m3269m = AbstractC0786f.m3263g(i10, (List) unsafe.getObject(zzmdVar, j));
                        i9 += m3269m;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 25:
                        List list4 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b4 = AbstractC0786f.f13768a;
                        int size2 = list4.size();
                        if (size2 != 0) {
                            zzz4 = (zzlk.zzz(i10 << 3) + 1) * size2;
                            i9 += zzz4;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz4 = 0;
                        i9 += zzz4;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 26:
                        List list5 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b5 = AbstractC0786f.f13768a;
                        int size3 = list5.size();
                        if (size3 != 0) {
                            zzz6 = zzlk.zzz(i10 << 3) * size3;
                            if (list5 instanceof zzmt) {
                                zzmt zzmtVar = (zzmt) list5;
                                for (int i16 = 0; i16 < size3; i16++) {
                                    Object zzc = zzmtVar.zzc();
                                    if (zzc instanceof zzld) {
                                        int zzd2 = ((zzld) zzc).zzd();
                                        zzz6 = ye0.m8285e(zzd2, zzd2, zzz6);
                                    } else {
                                        zzz6 = zzlk.zzy((String) zzc) + zzz6;
                                    }
                                }
                            } else {
                                for (int i17 = 0; i17 < size3; i17++) {
                                    Object obj = list5.get(i17);
                                    if (obj instanceof zzld) {
                                        int zzd3 = ((zzld) obj).zzd();
                                        zzz6 = ye0.m8285e(zzd3, zzd3, zzz6);
                                    } else {
                                        zzz6 = zzlk.zzy((String) obj) + zzz6;
                                    }
                                }
                            }
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 27:
                        List list6 = (List) unsafe.getObject(zzmdVar, j);
                        xd3 m3231B = m3231B(i8);
                        C0782b c0782b6 = AbstractC0786f.f13768a;
                        int size4 = list6.size();
                        if (size4 == 0) {
                            zzz7 = 0;
                        } else {
                            zzz7 = zzlk.zzz(i10 << 3) * size4;
                            for (int i18 = 0; i18 < size4; i18++) {
                                Object obj2 = list6.get(i18);
                                if (obj2 instanceof zzms) {
                                    int zza = ((zzms) obj2).zza();
                                    zzz7 = ye0.m8285e(zza, zza, zzz7);
                                } else {
                                    zzz7 = zzlk.m3466c((zznh) obj2, m3231B) + zzz7;
                                }
                            }
                        }
                        i9 += zzz7;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 28:
                        List list7 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b7 = AbstractC0786f.f13768a;
                        int size5 = list7.size();
                        if (size5 != 0) {
                            zzz6 = zzlk.zzz(i10 << 3) * size5;
                            for (int i19 = 0; i19 < list7.size(); i19++) {
                                int zzd4 = ((zzld) list7.get(i19)).zzd();
                                zzz6 = ye0.m8285e(zzd4, zzd4, zzz6);
                            }
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 29:
                        List list8 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b8 = AbstractC0786f.f13768a;
                        size = list8.size();
                        if (size != 0) {
                            m3273q = AbstractC0786f.m3272p(list8);
                            zzz5 = zzlk.zzz(i10 << 3);
                            zzz6 = (zzz5 * size) + m3273q;
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 30:
                        List list9 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b9 = AbstractC0786f.f13768a;
                        size = list9.size();
                        if (size != 0) {
                            m3273q = AbstractC0786f.m3262f(list9);
                            zzz5 = zzlk.zzz(i10 << 3);
                            zzz6 = (zzz5 * size) + m3273q;
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 31:
                        m3269m = AbstractC0786f.m3263g(i10, (List) unsafe.getObject(zzmdVar, j));
                        i9 += m3269m;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 32:
                        m3269m = AbstractC0786f.m3265i(i10, (List) unsafe.getObject(zzmdVar, j));
                        i9 += m3269m;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 33:
                        List list10 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b10 = AbstractC0786f.f13768a;
                        size = list10.size();
                        if (size != 0) {
                            m3273q = AbstractC0786f.m3270n(list10);
                            zzz5 = zzlk.zzz(i10 << 3);
                            zzz6 = (zzz5 * size) + m3273q;
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 34:
                        List list11 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b11 = AbstractC0786f.f13768a;
                        size = list11.size();
                        if (size != 0) {
                            m3273q = AbstractC0786f.m3271o(list11);
                            zzz5 = zzlk.zzz(i10 << 3);
                            zzz6 = (zzz5 * size) + m3273q;
                            i9 += zzz6;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                        zzz6 = 0;
                        i9 += zzz6;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 35:
                        zzz2 = AbstractC0786f.m3266j((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 36:
                        zzz2 = AbstractC0786f.m3264h((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 37:
                        zzz2 = AbstractC0786f.m3268l((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 38:
                        zzz2 = AbstractC0786f.m3273q((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 39:
                        zzz2 = AbstractC0786f.m3267k((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 40:
                        zzz2 = AbstractC0786f.m3266j((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 41:
                        zzz2 = AbstractC0786f.m3264h((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 42:
                        List list12 = (List) unsafe.getObject(zzmdVar, j);
                        C0782b c0782b12 = AbstractC0786f.f13768a;
                        zzz2 = list12.size();
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 43:
                        zzz2 = AbstractC0786f.m3272p((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 44:
                        zzz2 = AbstractC0786f.m3262f((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 45:
                        zzz2 = AbstractC0786f.m3264h((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 46:
                        zzz2 = AbstractC0786f.m3266j((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 47:
                        zzz2 = AbstractC0786f.m3270n((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 48:
                        zzz2 = AbstractC0786f.m3271o((List) unsafe.getObject(zzmdVar, j));
                        if (zzz2 > 0) {
                            zzd = zzlk.zzz(i10 << 3);
                            zzz3 = zzlk.zzz(zzz2);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 49:
                        List list13 = (List) unsafe.getObject(zzmdVar, j);
                        xd3 m3231B2 = m3231B(i8);
                        C0782b c0782b13 = AbstractC0786f.f13768a;
                        int size6 = list13.size();
                        if (size6 == 0) {
                            i4 = 0;
                        } else {
                            i4 = 0;
                            for (int i20 = 0; i20 < size6; i20++) {
                                i4 += zzlk.m3465b(i10, (zznh) list13.get(i20), m3231B2);
                            }
                        }
                        i9 += i4;
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 50:
                        int i21 = i8 / 3;
                        zznb zznbVar = (zznb) unsafe.getObject(zzmdVar, j);
                        if (zznbVar.isEmpty()) {
                            continue;
                        } else {
                            Iterator it = zznbVar.entrySet().iterator();
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                entry.getKey();
                                entry.getValue();
                                throw null;
                            }
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 51:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 8, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 52:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 4, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 53:
                        if (m3250r(i10, i8, zzmdVar)) {
                            long m3229z = m3229z(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(m3229z);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 54:
                        if (m3250r(i10, i8, zzmdVar)) {
                            long m3229z2 = m3229z(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(m3229z2);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 55:
                        if (m3250r(i10, i8, zzmdVar)) {
                            long m3227v = m3227v(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(m3227v);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 56:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 8, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 57:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 4, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 58:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 1, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 59:
                        if (m3250r(i10, i8, zzmdVar)) {
                            int i22 = i10 << 3;
                            Object object2 = unsafe.getObject(zzmdVar, j);
                            if (object2 instanceof zzld) {
                                zzz2 = zzlk.zzz(i22);
                                zzd = ((zzld) object2).zzd();
                                zzz3 = zzlk.zzz(zzd);
                                i9 += zzz3 + zzd + zzz2;
                                i8 += 3;
                                i6 = i;
                                i7 = i2;
                                i5 = 1048575;
                            } else {
                                zzz = zzlk.zzz(i22);
                                zzA = zzlk.zzy((String) object2);
                                i9 += zzA + zzz;
                                i8 += 3;
                                i6 = i;
                                i7 = i2;
                                i5 = 1048575;
                            }
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 60:
                        if (m3250r(i10, i8, zzmdVar)) {
                            m3269m = AbstractC0786f.m3269m(i10, unsafe.getObject(zzmdVar, j), m3231B(i8));
                            i9 += m3269m;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 61:
                        if (m3250r(i10, i8, zzmdVar)) {
                            zzld zzldVar2 = (zzld) unsafe.getObject(zzmdVar, j);
                            zzz2 = zzlk.zzz(i10 << 3);
                            zzd = zzldVar2.zzd();
                            zzz3 = zzlk.zzz(zzd);
                            i9 += zzz3 + zzd + zzz2;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 62:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(m3227v(zzmdVar, j), zzlk.zzz(i10 << 3), i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 63:
                        if (m3250r(i10, i8, zzmdVar)) {
                            long m3227v2 = m3227v(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA(m3227v2);
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 64:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 4, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 65:
                        if (m3250r(i10, i8, zzmdVar)) {
                            i9 = ye0.m8285e(i10 << 3, 8, i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 66:
                        if (m3250r(i10, i8, zzmdVar)) {
                            int m3227v3 = m3227v(zzmdVar, j);
                            i9 = ye0.m8285e((m3227v3 >> 31) ^ (m3227v3 + m3227v3), zzlk.zzz(i10 << 3), i9);
                        }
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                    case 67:
                        if (m3250r(i10, i8, zzmdVar)) {
                            long m3229z3 = m3229z(zzmdVar, j);
                            zzz = zzlk.zzz(i10 << 3);
                            zzA = zzlk.zzA((m3229z3 >> 63) ^ (m3229z3 + m3229z3));
                            i9 += zzA + zzz;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    case 68:
                        if (m3250r(i10, i8, zzmdVar)) {
                            m3269m = zzlk.m3465b(i10, (zznh) unsafe.getObject(zzmdVar, j), m3231B(i8));
                            i9 += m3269m;
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        } else {
                            i8 += 3;
                            i6 = i;
                            i7 = i2;
                            i5 = 1048575;
                        }
                    default:
                        i8 += 3;
                        i6 = i;
                        i7 = i2;
                        i5 = 1048575;
                }
            } else {
                int zza2 = zzmdVar.zzc.zza() + i9;
                if (this.f13759f) {
                    yd3 yd3Var = ((zzma) zzmdVar).zzb.f144a;
                    int m8267a = yd3Var.m8267a();
                    int i23 = 0;
                    for (int i24 = 0; i24 < m8267a; i24++) {
                        zd3 m8270f = yd3Var.m8270f(i24);
                        i23 = ad3.m67a((zzlt) m8270f.m8412a(), m8270f.getValue()) + i23;
                    }
                    for (Map.Entry entry2 : yd3Var.m8268c()) {
                        i23 = ad3.m67a((zzlt) entry2.getKey(), entry2.getValue()) + i23;
                    }
                    return zza2 + i23;
                }
                return zza2;
            }
        }
    }

    @Override // p000.xd3
    /* renamed from: f */
    public final boolean mo3239f(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.f13761h) {
            int i6 = this.f13760g[i4];
            int[] iArr = this.f13754a;
            int i7 = iArr[i6];
            int m3253y = m3253y(i6);
            int i8 = iArr[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = f13753m.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & m3253y) != 0 && !m3249p(obj, i6, i, i2, i10)) {
                return false;
            }
            int m3228x = m3228x(m3253y);
            if (m3228x != 9 && m3228x != 17) {
                if (m3228x != 27) {
                    if (m3228x != 60 && m3228x != 68) {
                        if (m3228x != 49) {
                            if (m3228x == 50 && !((zznb) ie3.m5220i(obj, m3253y & 1048575)).isEmpty()) {
                                int i11 = i6 / 3;
                                throw null;
                            }
                        }
                    } else if (m3250r(i7, i6, obj) && !m3231B(i6).mo3239f(ie3.m5220i(obj, m3253y & 1048575))) {
                        return false;
                    }
                }
                List list = (List) ie3.m5220i(obj, m3253y & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    xd3 m3231B = m3231B(i6);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!m3231B.mo3239f(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (m3249p(obj, i6, i, i2, i10) && !m3231B(i6).mo3239f(ie3.m5220i(obj, m3253y & 1048575))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        if (this.f13759f && !((zzma) obj).zzb.m74e()) {
            return false;
        }
        return true;
    }

    @Override // p000.xd3
    /* renamed from: g */
    public final void mo3240g(Object obj, Object obj2) {
        if (m3224q(obj)) {
            obj2.getClass();
            int i = 0;
            while (true) {
                int[] iArr = this.f13754a;
                if (i < iArr.length) {
                    int m3253y = m3253y(i);
                    int i2 = m3253y & 1048575;
                    int m3228x = m3228x(m3253y);
                    int i3 = iArr[i];
                    long j = i2;
                    switch (m3228x) {
                        case 0:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5223l(obj, j, ie3.f18388c.mo4693j(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 1:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5224m(obj, j, ie3.f18388c.mo4694k(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 2:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5226o(obj, j, ie3.m5218g(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 3:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5226o(obj, j, ie3.m5218g(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 4:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5225n(obj, j, ie3.m5217f(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 5:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5226o(obj, j, ie3.m5218g(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 6:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5225n(obj, j, ie3.m5217f(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 7:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5222k(obj, j, ie3.f18388c.mo4699p(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 8:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5227p(j, obj, ie3.m5220i(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 9:
                            m3242i(i, obj, obj2);
                            break;
                        case 10:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5227p(j, obj, ie3.m5220i(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 11:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5225n(obj, j, ie3.m5217f(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 12:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5225n(obj, j, ie3.m5217f(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 13:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5225n(obj, j, ie3.m5217f(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 14:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5226o(obj, j, ie3.m5218g(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 15:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5225n(obj, j, ie3.m5217f(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 16:
                            if (!m3248o(i, obj2)) {
                                break;
                            } else {
                                ie3.m5226o(obj, j, ie3.m5218g(obj2, j));
                                m3244k(i, obj);
                                break;
                            }
                        case 17:
                            m3242i(i, obj, obj2);
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            zzmj zzmjVar = (zzmj) ie3.m5220i(obj, j);
                            zzmj zzmjVar2 = (zzmj) ie3.m5220i(obj2, j);
                            int size = zzmjVar.size();
                            int size2 = zzmjVar2.size();
                            if (size > 0 && size2 > 0) {
                                if (!zzmjVar.zzc()) {
                                    zzmjVar = zzmjVar.zzd(size2 + size);
                                }
                                zzmjVar.addAll(zzmjVar2);
                            }
                            if (size > 0) {
                                zzmjVar2 = zzmjVar;
                            }
                            ie3.m5227p(j, obj, zzmjVar2);
                            break;
                        case 50:
                            C0782b c0782b = AbstractC0786f.f13768a;
                            ie3.m5227p(j, obj, z93.m8408a(ie3.m5220i(obj, j), ie3.m5220i(obj2, j)));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            if (!m3250r(i3, i, obj2)) {
                                break;
                            } else {
                                ie3.m5227p(j, obj, ie3.m5220i(obj2, j));
                                ie3.m5225n(obj, iArr[i + 2] & 1048575, i3);
                                break;
                            }
                        case 60:
                            m3243j(i, obj, obj2);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (!m3250r(i3, i, obj2)) {
                                break;
                            } else {
                                ie3.m5227p(j, obj, ie3.m5220i(obj2, j));
                                ie3.m5225n(obj, iArr[i + 2] & 1048575, i3);
                                break;
                            }
                        case 68:
                            m3243j(i, obj, obj2);
                            break;
                    }
                    i += 3;
                } else {
                    AbstractC0786f.m3275s(obj, obj2);
                    if (!this.f13759f || ((zzma) obj2).zzb.f144a.isEmpty()) {
                        return;
                    }
                    throw null;
                }
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    @Override // p000.xd3
    /* renamed from: h */
    public final int mo3241h(zzmd zzmdVar) {
        int i;
        long doubleToLongBits;
        int i2;
        int floatToIntBits;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f13754a;
            if (i4 < iArr.length) {
                int m3253y = m3253y(i4);
                int i6 = 1048575 & m3253y;
                int m3228x = m3228x(m3253y);
                int i7 = iArr[i4];
                long j = i6;
                int i8 = 37;
                switch (m3228x) {
                    case 0:
                        i = i5 * 53;
                        doubleToLongBits = Double.doubleToLongBits(ie3.f18388c.mo4693j(zzmdVar, j));
                        Charset charset = zzmk.f13887a;
                        i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 1:
                        i2 = i5 * 53;
                        floatToIntBits = Float.floatToIntBits(ie3.f18388c.mo4694k(zzmdVar, j));
                        i5 = floatToIntBits + i2;
                        break;
                    case 2:
                        i = i5 * 53;
                        doubleToLongBits = ie3.m5218g(zzmdVar, j);
                        Charset charset2 = zzmk.f13887a;
                        i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 3:
                        i = i5 * 53;
                        doubleToLongBits = ie3.m5218g(zzmdVar, j);
                        Charset charset3 = zzmk.f13887a;
                        i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 4:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5217f(zzmdVar, j);
                        i5 = floatToIntBits + i2;
                        break;
                    case 5:
                        i = i5 * 53;
                        doubleToLongBits = ie3.m5218g(zzmdVar, j);
                        Charset charset4 = zzmk.f13887a;
                        i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 6:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5217f(zzmdVar, j);
                        i5 = floatToIntBits + i2;
                        break;
                    case 7:
                        i2 = i5 * 53;
                        floatToIntBits = zzmk.zza(ie3.f18388c.mo4699p(zzmdVar, j));
                        i5 = floatToIntBits + i2;
                        break;
                    case 8:
                        i2 = i5 * 53;
                        floatToIntBits = ((String) ie3.m5220i(zzmdVar, j)).hashCode();
                        i5 = floatToIntBits + i2;
                        break;
                    case 9:
                        i3 = i5 * 53;
                        Object m5220i = ie3.m5220i(zzmdVar, j);
                        if (m5220i != null) {
                            i8 = m5220i.hashCode();
                        }
                        i5 = i3 + i8;
                        break;
                    case 10:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5220i(zzmdVar, j).hashCode();
                        i5 = floatToIntBits + i2;
                        break;
                    case 11:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5217f(zzmdVar, j);
                        i5 = floatToIntBits + i2;
                        break;
                    case 12:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5217f(zzmdVar, j);
                        i5 = floatToIntBits + i2;
                        break;
                    case 13:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5217f(zzmdVar, j);
                        i5 = floatToIntBits + i2;
                        break;
                    case 14:
                        i = i5 * 53;
                        doubleToLongBits = ie3.m5218g(zzmdVar, j);
                        Charset charset5 = zzmk.f13887a;
                        i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 15:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5217f(zzmdVar, j);
                        i5 = floatToIntBits + i2;
                        break;
                    case 16:
                        i = i5 * 53;
                        doubleToLongBits = ie3.m5218g(zzmdVar, j);
                        Charset charset6 = zzmk.f13887a;
                        i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 17:
                        i3 = i5 * 53;
                        Object m5220i2 = ie3.m5220i(zzmdVar, j);
                        if (m5220i2 != null) {
                            i8 = m5220i2.hashCode();
                        }
                        i5 = i3 + i8;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5220i(zzmdVar, j).hashCode();
                        i5 = floatToIntBits + i2;
                        break;
                    case 50:
                        i2 = i5 * 53;
                        floatToIntBits = ie3.m5220i(zzmdVar, j).hashCode();
                        i5 = floatToIntBits + i2;
                        break;
                    case 51:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i = i5 * 53;
                            doubleToLongBits = Double.doubleToLongBits(((Double) ie3.m5220i(zzmdVar, j)).doubleValue());
                            Charset charset7 = zzmk.f13887a;
                            i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 52:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = Float.floatToIntBits(((Float) ie3.m5220i(zzmdVar, j)).floatValue());
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 53:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i = i5 * 53;
                            doubleToLongBits = m3229z(zzmdVar, j);
                            Charset charset8 = zzmk.f13887a;
                            i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 54:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i = i5 * 53;
                            doubleToLongBits = m3229z(zzmdVar, j);
                            Charset charset9 = zzmk.f13887a;
                            i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 55:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = m3227v(zzmdVar, j);
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 56:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i = i5 * 53;
                            doubleToLongBits = m3229z(zzmdVar, j);
                            Charset charset10 = zzmk.f13887a;
                            i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 57:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = m3227v(zzmdVar, j);
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 58:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = zzmk.zza(((Boolean) ie3.m5220i(zzmdVar, j)).booleanValue());
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 59:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = ((String) ie3.m5220i(zzmdVar, j)).hashCode();
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 60:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = ie3.m5220i(zzmdVar, j).hashCode();
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 61:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = ie3.m5220i(zzmdVar, j).hashCode();
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 62:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = m3227v(zzmdVar, j);
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 63:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = m3227v(zzmdVar, j);
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 64:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = m3227v(zzmdVar, j);
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 65:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i = i5 * 53;
                            doubleToLongBits = m3229z(zzmdVar, j);
                            Charset charset11 = zzmk.f13887a;
                            i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 66:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = m3227v(zzmdVar, j);
                            i5 = floatToIntBits + i2;
                            break;
                        }
                    case 67:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i = i5 * 53;
                            doubleToLongBits = m3229z(zzmdVar, j);
                            Charset charset12 = zzmk.f13887a;
                            i5 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 68:
                        if (!m3250r(i7, i4, zzmdVar)) {
                            break;
                        } else {
                            i2 = i5 * 53;
                            floatToIntBits = ie3.m5220i(zzmdVar, j).hashCode();
                            i5 = floatToIntBits + i2;
                            break;
                        }
                }
                i4 += 3;
            } else {
                int hashCode = zzmdVar.zzc.hashCode() + (i5 * 53);
                if (this.f13759f) {
                    return ((zzma) zzmdVar).zzb.f144a.hashCode() + (hashCode * 53);
                }
                return hashCode;
            }
        }
    }

    /* renamed from: i */
    public final void m3242i(int i, Object obj, Object obj2) {
        if (!m3248o(i, obj2)) {
            return;
        }
        int m3253y = m3253y(i) & 1048575;
        Unsafe unsafe = f13753m;
        long j = m3253y;
        Object object = unsafe.getObject(obj2, j);
        if (object != null) {
            xd3 m3231B = m3231B(i);
            if (!m3248o(i, obj)) {
                if (!m3224q(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = m3231B.zze();
                    m3231B.mo3240g(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                m3244k(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!m3224q(object2)) {
                Object zze2 = m3231B.zze();
                m3231B.mo3240g(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            m3231B.mo3240g(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.f13754a[i] + " is present but null: " + obj2.toString());
    }

    /* renamed from: j */
    public final void m3243j(int i, Object obj, Object obj2) {
        int[] iArr = this.f13754a;
        int i2 = iArr[i];
        if (!m3250r(i2, i, obj2)) {
            return;
        }
        int m3253y = m3253y(i) & 1048575;
        Unsafe unsafe = f13753m;
        long j = m3253y;
        Object object = unsafe.getObject(obj2, j);
        if (object != null) {
            xd3 m3231B = m3231B(i);
            if (!m3250r(i2, i, obj)) {
                if (!m3224q(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = m3231B.zze();
                    m3231B.mo3240g(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                ie3.m5225n(obj, iArr[i + 2] & 1048575, i2);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!m3224q(object2)) {
                Object zze2 = m3231B.zze();
                m3231B.mo3240g(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            m3231B.mo3240g(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
    }

    /* renamed from: k */
    public final void m3244k(int i, Object obj) {
        int i2 = this.f13754a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        ie3.m5225n(obj, j, (1 << (i2 >>> 20)) | ie3.m5217f(obj, j));
    }

    /* renamed from: l */
    public final void m3245l(int i, Object obj, Object obj2) {
        f13753m.putObject(obj, m3253y(i) & 1048575, obj2);
        m3244k(i, obj);
    }

    /* renamed from: m */
    public final void m3246m(int i, Object obj, int i2, Object obj2) {
        f13753m.putObject(obj, m3253y(i2) & 1048575, obj2);
        ie3.m5225n(obj, this.f13754a[i2 + 2] & 1048575, i);
    }

    /* renamed from: n */
    public final boolean m3247n(zzmd zzmdVar, Object obj, int i) {
        if (m3248o(i, zzmdVar) == m3248o(i, obj)) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public final boolean m3248o(int i, Object obj) {
        int i2 = this.f13754a[i + 2];
        long j = i2 & 1048575;
        if (j == 1048575) {
            int m3253y = m3253y(i);
            long j2 = m3253y & 1048575;
            switch (m3228x(m3253y)) {
                case 0:
                    if (Double.doubleToRawLongBits(ie3.f18388c.mo4693j(obj, j2)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(ie3.f18388c.mo4694k(obj, j2)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (ie3.m5218g(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (ie3.m5218g(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (ie3.m5217f(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (ie3.m5218g(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (ie3.m5217f(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return ie3.f18388c.mo4699p(obj, j2);
                case 8:
                    Object m5220i = ie3.m5220i(obj, j2);
                    if (m5220i instanceof String) {
                        if (((String) m5220i).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (m5220i instanceof zzld) {
                        if (zzld.zzb.equals(m5220i)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (ie3.m5220i(obj, j2) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzld.zzb.equals(ie3.m5220i(obj, j2))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (ie3.m5217f(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (ie3.m5217f(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (ie3.m5217f(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (ie3.m5218g(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (ie3.m5217f(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (ie3.m5218g(obj, j2) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (ie3.m5220i(obj, j2) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if (((1 << (i2 >>> 20)) & ie3.m5217f(obj, j)) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: p */
    public final boolean m3249p(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return m3248o(i, obj);
        }
        if ((i3 & i4) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: r */
    public final boolean m3250r(int i, int i2, Object obj) {
        if (ie3.m5217f(obj, this.f13754a[i2 + 2] & 1048575) == i) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0ed9, code lost:
    
        if (r0 == r15) goto L551;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0edb, code lost:
    
        r14.putInt(r7, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0edf, code lost:
    
        r0 = r10.f13761h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0ee3, code lost:
    
        if (r0 >= r10.f13762i) goto L681;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0ee5, code lost:
    
        r1 = r10.f13760g[r0];
        r3 = r19[r1];
        r3 = p000.ie3.m5220i(r7, r10.m3253y(r1) & r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0ef5, code lost:
    
        if (r3 != null) goto L557;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0efc, code lost:
    
        if (r10.m3230A(r1) != null) goto L682;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0f00, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zznb) r3;
        r1 = r1 / 3;
        r0 = (com.google.android.gms.internal.measurement.zzna) r23[r1 + r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0f09, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0efe, code lost:
    
        r0 = r0 + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0f0c, code lost:
    
        if (r9 != 0) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0f10, code lost:
    
        if (r8 != r42) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0f18, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmm("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0f1f, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0f1b, code lost:
    
        if (r8 > r42) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0f1d, code lost:
    
        if (r2 != r9) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0f25, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmm("Failed to parse the message.");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:175:0x05f4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0b9e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:533:0x00cb. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0b08 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0b1d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0e45 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0e59 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:608:0x02bc  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m3251s(Object obj, byte[] bArr, int i, int i2, int i3, oc3 oc3Var) {
        C0784d c0784d;
        int i4;
        Object[] objArr;
        int i5;
        int[] iArr;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        byte[] bArr2;
        oc3 oc3Var2;
        int i16;
        int m8353b0;
        int i17;
        int i18;
        int i19;
        Unsafe unsafe2;
        oc3 oc3Var3;
        int i20;
        int i21;
        int i22;
        boolean z;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int m8355c0;
        int i31;
        int i32;
        oc3 oc3Var4;
        int i33;
        int i34;
        Unsafe unsafe3;
        int i35;
        int i36;
        int i37;
        byte[] bArr3;
        byte[] bArr4;
        oc3 oc3Var5;
        Unsafe unsafe4;
        int i38;
        int i39;
        int i40;
        int m8361f0;
        byte[] bArr5;
        int i41;
        int i42;
        int i43;
        byte[] bArr6;
        int m8359e0;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        int i51;
        int i52;
        int m8348W;
        C0784d c0784d2 = this;
        Object obj2 = obj;
        byte[] bArr7 = bArr;
        int i53 = i2;
        int i54 = i3;
        oc3 oc3Var6 = oc3Var;
        int i55 = 3;
        int i56 = 1;
        if (m3224q(obj)) {
            Unsafe unsafe5 = f13753m;
            int i57 = i;
            int i58 = -1;
            int i59 = 0;
            int i60 = 1048575;
            int i61 = 0;
            int i62 = 0;
            while (true) {
                int[] iArr2 = c0784d2.f13754a;
                Object[] objArr2 = c0784d2.f13755b;
                if (i57 < i53) {
                    int i63 = i57 + 1;
                    int i64 = bArr7[i57];
                    if (i64 < 0) {
                        i63 = yy2.m8357d0(i64, bArr7, i63, oc3Var6);
                        i64 = oc3Var6.f23766a;
                    }
                    int i65 = (i64 == true ? 1 : 0) >>> 3;
                    int i66 = c0784d2.f13757d;
                    int i67 = c0784d2.f13756c;
                    if (i65 > i58) {
                        i11 = (i65 < i67 || i65 > i66) ? -1 : c0784d2.m3252w(i65, i59 / i55);
                        i10 = 0;
                    } else if (i65 < i67 || i65 > i66) {
                        i10 = 0;
                        i11 = -1;
                    } else {
                        i10 = 0;
                        i11 = c0784d2.m3252w(i65, 0);
                    }
                    if (i11 != -1) {
                        boolean z2 = (i64 == true ? 1 : 0) & 7;
                        int i68 = iArr2[i11 + 1];
                        int m3228x = m3228x(i68);
                        long j = i68 & 1048575;
                        if (m3228x > 17) {
                            int i69 = i63;
                            int i70 = i64 == true ? 1 : 0;
                            int i71 = i65;
                            iArr = iArr2;
                            i14 = i60;
                            Unsafe unsafe6 = unsafe5;
                            int i72 = i11;
                            if (m3228x != 27) {
                                objArr = objArr2;
                                i34 = i72;
                                if (m3228x > 49) {
                                    bArr3 = bArr;
                                    i36 = i71;
                                    i33 = i69;
                                    i35 = i70;
                                    if (m3228x != 50) {
                                        obj2 = obj;
                                        long j2 = iArr[i34 + 2] & 1048575;
                                        switch (m3228x) {
                                            case 51:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i5 = 1;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 1) {
                                                    i49 = i33 + 8;
                                                    unsafe.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(yy2.m8365i0(i33, bArr2))));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                        i4 = i3;
                                                        i16 = i57;
                                                        i64 = i48;
                                                        break;
                                                    } else {
                                                        i53 = i2;
                                                        i54 = i3;
                                                        bArr7 = bArr2;
                                                        c0784d2 = c0784d;
                                                        i58 = i15;
                                                        oc3Var6 = oc3Var2;
                                                        unsafe5 = unsafe;
                                                        i60 = i14;
                                                        i55 = i12;
                                                        i59 = i13;
                                                        i62 = i48;
                                                        i56 = i5;
                                                    }
                                                }
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                            case 52:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i5 = 1;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 5) {
                                                    i49 = i33 + 4;
                                                    unsafe.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(yy2.m8349X(i33, bArr2))));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i5 = 1;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 0) {
                                                    i49 = yy2.m8361f0(bArr2, i33, oc3Var2);
                                                    unsafe.putObject(obj2, j, Long.valueOf(oc3Var2.f23767b));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i5 = 1;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 0) {
                                                    i49 = yy2.m8355c0(bArr2, i33, oc3Var2);
                                                    unsafe.putObject(obj2, j, Integer.valueOf(oc3Var2.f23766a));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i5 = 1;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 1) {
                                                    i49 = i33 + 8;
                                                    unsafe.putObject(obj2, j, Long.valueOf(yy2.m8365i0(i33, bArr2)));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 5) {
                                                    i50 = i33 + 4;
                                                    unsafe.putObject(obj2, j, Integer.valueOf(yy2.m8349X(i33, bArr2)));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i50;
                                                    i5 = 1;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i5 = 1;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 58:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 0) {
                                                    i50 = yy2.m8361f0(bArr2, i33, oc3Var2);
                                                    unsafe.putObject(obj2, j, Boolean.valueOf(oc3Var2.f23767b != 0));
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = i50;
                                                    i5 = 1;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i5 = 1;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 59:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 2) {
                                                    int m8355c02 = yy2.m8355c0(bArr2, i33, oc3Var2);
                                                    int i73 = oc3Var2.f23766a;
                                                    if (i73 == 0) {
                                                        unsafe.putObject(obj2, j, "");
                                                    } else {
                                                        int i74 = m8355c02 + i73;
                                                        if ((i68 & 536870912) != 0 && !ke3.m5526d(bArr2, m8355c02, i74)) {
                                                            throw new zzmm("Protocol message had invalid UTF-8.");
                                                        }
                                                        unsafe.putObject(obj2, j, new String(bArr2, m8355c02, i73, zzmk.f13887a));
                                                        m8355c02 = i74;
                                                    }
                                                    unsafe.putInt(obj2, j2, i15);
                                                    i57 = m8355c02;
                                                    i5 = 1;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i5 = 1;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 60:
                                                c0784d = this;
                                                bArr2 = bArr3;
                                                i51 = i34;
                                                i52 = i36;
                                                unsafe = unsafe6;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 2) {
                                                    Object m3233D = c0784d.m3233D(i52, i51, obj2);
                                                    i12 = 3;
                                                    i48 = i35;
                                                    i49 = yy2.m8364h0(m3233D, c0784d.m3231B(i51), bArr, i33, i2, oc3Var);
                                                    c0784d.m3246m(i52, obj2, i51, m3233D);
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i15 = i52;
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                } else {
                                                    i48 = i35;
                                                    i12 = 3;
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i15 = i52;
                                                    i57 = i33;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                break;
                                            case 61:
                                                c0784d = this;
                                                bArr2 = bArr3;
                                                i51 = i34;
                                                i52 = i36;
                                                unsafe = unsafe6;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 2) {
                                                    m8348W = yy2.m8348W(bArr2, i33, oc3Var2);
                                                    unsafe.putObject(obj2, j, oc3Var2.f23768c);
                                                    unsafe.putInt(obj2, j2, i52);
                                                    i48 = i35;
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i12 = 3;
                                                    i15 = i52;
                                                    i57 = m8348W;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i48 = i35;
                                                i13 = i51;
                                                i5 = 1;
                                                i12 = 3;
                                                i15 = i52;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 63:
                                                c0784d = this;
                                                bArr2 = bArr3;
                                                i51 = i34;
                                                i52 = i36;
                                                unsafe = unsafe6;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 0) {
                                                    i49 = yy2.m8355c0(bArr2, i33, oc3Var2);
                                                    int i75 = oc3Var2.f23766a;
                                                    zzmg m3230A = c0784d.m3230A(i51);
                                                    if (m3230A != null && !m3230A.zza(i75)) {
                                                        m3225t(obj).m3478b(i35, Long.valueOf(i75));
                                                    } else {
                                                        unsafe.putObject(obj2, j, Integer.valueOf(i75));
                                                        unsafe.putInt(obj2, j2, i52);
                                                    }
                                                    i48 = i35;
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i12 = 3;
                                                    i15 = i52;
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i48 = i35;
                                                i13 = i51;
                                                i5 = 1;
                                                i12 = 3;
                                                i15 = i52;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 66:
                                                c0784d = this;
                                                bArr2 = bArr3;
                                                i51 = i34;
                                                i52 = i36;
                                                unsafe = unsafe6;
                                                oc3Var2 = oc3Var;
                                                if (z2 == 0) {
                                                    i49 = yy2.m8355c0(bArr2, i33, oc3Var2);
                                                    unsafe.putObject(obj2, j, Integer.valueOf(zzlg.zzb(oc3Var2.f23766a)));
                                                    unsafe.putInt(obj2, j2, i52);
                                                    i48 = i35;
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i12 = 3;
                                                    i15 = i52;
                                                    i57 = i49;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                i48 = i35;
                                                i13 = i51;
                                                i5 = 1;
                                                i12 = 3;
                                                i15 = i52;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                            case 67:
                                                c0784d = this;
                                                bArr2 = bArr3;
                                                i51 = i34;
                                                i52 = i36;
                                                if (z2 == 0) {
                                                    oc3Var2 = oc3Var;
                                                    m8348W = yy2.m8361f0(bArr2, i33, oc3Var2);
                                                    unsafe = unsafe6;
                                                    unsafe.putObject(obj2, j, Long.valueOf(zzlg.zzc(oc3Var2.f23767b)));
                                                    unsafe.putInt(obj2, j2, i52);
                                                    i48 = i35;
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i12 = 3;
                                                    i15 = i52;
                                                    i57 = m8348W;
                                                    if (i57 == i33) {
                                                    }
                                                } else {
                                                    oc3Var2 = oc3Var;
                                                    unsafe = unsafe6;
                                                    i12 = 3;
                                                    i48 = i35;
                                                    i13 = i51;
                                                    i5 = 1;
                                                    i15 = i52;
                                                    i57 = i33;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                break;
                                            case 68:
                                                if (z2 == 3) {
                                                    Object m3233D2 = m3233D(i36, i34, obj2);
                                                    bArr2 = bArr3;
                                                    i57 = yy2.m8362g0(m3233D2, m3231B(i34), bArr, i33, i2, (i35 & (-8)) | 4, oc3Var);
                                                    m3246m(i36, obj2, i34, m3233D2);
                                                    oc3Var2 = oc3Var;
                                                    i12 = 3;
                                                    i13 = i34;
                                                    c0784d = this;
                                                    i15 = i36;
                                                    i48 = i35;
                                                    unsafe = unsafe6;
                                                    i5 = 1;
                                                    if (i57 == i33) {
                                                    }
                                                } else {
                                                    bArr2 = bArr3;
                                                    c0784d = this;
                                                    oc3Var2 = oc3Var;
                                                    i12 = 3;
                                                    i48 = i35;
                                                    i13 = i34;
                                                    i15 = i36;
                                                    unsafe = unsafe6;
                                                    i5 = 1;
                                                    i57 = i33;
                                                    if (i57 == i33) {
                                                    }
                                                }
                                                break;
                                            default:
                                                c0784d = this;
                                                i48 = i35;
                                                bArr2 = bArr3;
                                                i13 = i34;
                                                i15 = i36;
                                                unsafe = unsafe6;
                                                i5 = 1;
                                                i12 = 3;
                                                oc3Var2 = oc3Var;
                                                i57 = i33;
                                                if (i57 == i33) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (z2 == 2) {
                                            int i76 = i34 / 3;
                                            Object obj3 = objArr[i76 + i76];
                                            Object object = unsafe6.getObject(obj, j);
                                            if (!((zznb) object).zze()) {
                                                zznb zzb = zznb.zza().zzb();
                                                z93.m8408a(zzb, object);
                                                unsafe6.putObject(obj, j, zzb);
                                            }
                                            throw null;
                                        }
                                        oc3Var4 = oc3Var;
                                        unsafe3 = unsafe6;
                                        i37 = 3;
                                        obj2 = obj;
                                        c0784d = this;
                                        i4 = i3;
                                        i12 = i37;
                                        i15 = i36;
                                        i64 = i35;
                                        bArr2 = bArr3;
                                        i13 = i34;
                                        i16 = i33;
                                        i5 = 1;
                                        unsafe = unsafe3;
                                        oc3Var2 = oc3Var4;
                                    }
                                } else {
                                    long j3 = i68;
                                    zzmj zzmjVar = (zzmj) unsafe6.getObject(obj2, j);
                                    if (!zzmjVar.zzc()) {
                                        int size = zzmjVar.size();
                                        zzmj zzd = zzmjVar.zzd(size + size);
                                        unsafe6.putObject(obj2, j, zzd);
                                        zzmjVar = zzd;
                                    }
                                    switch (m3228x) {
                                        case 18:
                                        case 35:
                                            bArr4 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i38 = i71;
                                            i39 = i69;
                                            if (z2 != 2) {
                                                i40 = 1;
                                                if (z2 == 1) {
                                                    rd3.m7269a(zzmjVar);
                                                    Double.longBitsToDouble(yy2.m8365i0(i39, bArr4));
                                                    throw null;
                                                }
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                    i4 = i3;
                                                    i16 = m8361f0;
                                                    i5 = i40;
                                                    i15 = i38;
                                                    bArr2 = bArr4;
                                                    i13 = i34;
                                                    unsafe = unsafe4;
                                                    i12 = 3;
                                                    c0784d = this;
                                                    oc3Var2 = oc3Var5;
                                                    obj2 = obj;
                                                    break;
                                                } else {
                                                    i54 = i3;
                                                    i53 = i2;
                                                    oc3Var6 = oc3Var5;
                                                    i62 = i64 == true ? 1 : 0;
                                                    i58 = i38;
                                                    bArr7 = bArr4;
                                                    i59 = i34;
                                                    i60 = i14;
                                                    unsafe5 = unsafe4;
                                                    c0784d2 = this;
                                                    obj2 = obj;
                                                    i57 = m8361f0;
                                                    i56 = i40;
                                                    i55 = 3;
                                                }
                                            } else {
                                                rd3.m7269a(zzmjVar);
                                                if (yy2.m8355c0(bArr4, i39, oc3Var5) + oc3Var5.f23766a > bArr4.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                throw null;
                                            }
                                        case 19:
                                        case 36:
                                            bArr4 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i38 = i71;
                                            i39 = i69;
                                            if (z2 == 2) {
                                                rd3.m7269a(zzmjVar);
                                                if (yy2.m8355c0(bArr4, i39, oc3Var5) + oc3Var5.f23766a > bArr4.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                throw null;
                                            }
                                            if (z2 == 5) {
                                                rd3.m7269a(zzmjVar);
                                                Float.intBitsToFloat(yy2.m8349X(i39, bArr4));
                                                throw null;
                                            }
                                            i40 = 1;
                                            m8361f0 = i39;
                                            if (m8361f0 == i39) {
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            bArr4 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i38 = i71;
                                            i39 = i69;
                                            if (z2 == 2) {
                                                md3 md3Var = (md3) zzmjVar;
                                                m8361f0 = yy2.m8355c0(bArr4, i39, oc3Var5);
                                                int i77 = oc3Var5.f23766a + m8361f0;
                                                while (m8361f0 < i77) {
                                                    m8361f0 = yy2.m8361f0(bArr4, m8361f0, oc3Var5);
                                                    md3Var.m6139b(oc3Var5.f23767b);
                                                }
                                                if (m8361f0 != i77) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (z2 == 0) {
                                                    md3 md3Var2 = (md3) zzmjVar;
                                                    m8361f0 = yy2.m8361f0(bArr4, i39, oc3Var5);
                                                    md3Var2.m6139b(oc3Var5.f23767b);
                                                    while (m8361f0 < i2) {
                                                        int m8355c03 = yy2.m8355c0(bArr4, m8361f0, oc3Var5);
                                                        if (i64 == oc3Var5.f23766a) {
                                                            m8361f0 = yy2.m8361f0(bArr4, m8355c03, oc3Var5);
                                                            md3Var2.m6139b(oc3Var5.f23767b);
                                                        }
                                                    }
                                                }
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            i40 = 1;
                                            if (m8361f0 == i39) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            bArr5 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i41 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 == 2) {
                                                m8361f0 = yy2.m8352a0(bArr5, i39, zzmjVar, oc3Var5);
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                if (m8361f0 == i39) {
                                                }
                                            } else {
                                                if (z2 == 0) {
                                                    bArr4 = bArr5;
                                                    i64 = i41;
                                                    i38 = i42;
                                                    m8361f0 = yy2.m8359e0(i41, bArr, i39, i2, zzmjVar, oc3Var);
                                                    i40 = 1;
                                                    if (m8361f0 == i39) {
                                                    }
                                                }
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            bArr5 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i41 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 == 2) {
                                                md3 md3Var3 = (md3) zzmjVar;
                                                m8361f0 = yy2.m8355c0(bArr5, i39, oc3Var5);
                                                int i78 = oc3Var5.f23766a;
                                                int i79 = m8361f0 + i78;
                                                if (i79 <= bArr5.length) {
                                                    md3Var3.m6140c((i78 / 8) + md3Var3.size());
                                                    while (m8361f0 < i79) {
                                                        md3Var3.m6139b(yy2.m8365i0(m8361f0, bArr5));
                                                        m8361f0 += 8;
                                                    }
                                                    if (m8361f0 != i79) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    bArr4 = bArr5;
                                                    i64 = i41;
                                                    i38 = i42;
                                                    i40 = 1;
                                                    if (m8361f0 == i39) {
                                                    }
                                                } else {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else if (z2 == 1) {
                                                i43 = i39 + 8;
                                                md3 md3Var4 = (md3) zzmjVar;
                                                md3Var4.m6139b(yy2.m8365i0(i39, bArr5));
                                                while (i43 < i2) {
                                                    int m8355c04 = yy2.m8355c0(bArr5, i43, oc3Var5);
                                                    if (i41 == oc3Var5.f23766a) {
                                                        md3Var4.m6139b(yy2.m8365i0(m8355c04, bArr5));
                                                        i43 = m8355c04 + 8;
                                                    } else {
                                                        m8361f0 = i43;
                                                        bArr4 = bArr5;
                                                        i64 = i41;
                                                        i38 = i42;
                                                        i40 = 1;
                                                        if (m8361f0 == i39) {
                                                        }
                                                    }
                                                }
                                                m8361f0 = i43;
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                if (m8361f0 == i39) {
                                                }
                                            } else {
                                                i40 = 1;
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            bArr5 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i41 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 == 2) {
                                                hd3 hd3Var = (hd3) zzmjVar;
                                                m8361f0 = yy2.m8355c0(bArr5, i39, oc3Var5);
                                                int i80 = oc3Var5.f23766a;
                                                int i81 = m8361f0 + i80;
                                                if (i81 <= bArr5.length) {
                                                    hd3Var.m5054d((i80 / 4) + hd3Var.size());
                                                    while (m8361f0 < i81) {
                                                        hd3Var.m5053c(yy2.m8349X(m8361f0, bArr5));
                                                        m8361f0 += 4;
                                                    }
                                                    if (m8361f0 != i81) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    bArr4 = bArr5;
                                                    i64 = i41;
                                                    i38 = i42;
                                                    i40 = 1;
                                                    if (m8361f0 == i39) {
                                                    }
                                                } else {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (z2 == 5) {
                                                    i43 = i39 + 4;
                                                    hd3 hd3Var2 = (hd3) zzmjVar;
                                                    hd3Var2.m5053c(yy2.m8349X(i39, bArr5));
                                                    while (i43 < i2) {
                                                        int m8355c05 = yy2.m8355c0(bArr5, i43, oc3Var5);
                                                        if (i41 == oc3Var5.f23766a) {
                                                            hd3Var2.m5053c(yy2.m8349X(m8355c05, bArr5));
                                                            i43 = m8355c05 + 4;
                                                        } else {
                                                            m8361f0 = i43;
                                                            bArr4 = bArr5;
                                                            i64 = i41;
                                                            i38 = i42;
                                                            i40 = 1;
                                                            if (m8361f0 == i39) {
                                                            }
                                                        }
                                                    }
                                                    m8361f0 = i43;
                                                    bArr4 = bArr5;
                                                    i64 = i41;
                                                    i38 = i42;
                                                    i40 = 1;
                                                    if (m8361f0 == i39) {
                                                    }
                                                }
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            bArr5 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i41 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 == 2) {
                                                rd3.m7269a(zzmjVar);
                                                m8361f0 = yy2.m8355c0(bArr5, i39, oc3Var5);
                                                int i82 = oc3Var5.f23766a + m8361f0;
                                                if (m8361f0 < i82) {
                                                    yy2.m8361f0(bArr5, m8361f0, oc3Var5);
                                                    throw null;
                                                }
                                                if (m8361f0 != i82) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                if (m8361f0 == i39) {
                                                }
                                            } else {
                                                if (z2 == 0) {
                                                    rd3.m7269a(zzmjVar);
                                                    yy2.m8361f0(bArr5, i39, oc3Var5);
                                                    throw null;
                                                }
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 26:
                                            bArr5 = bArr;
                                            oc3Var5 = oc3Var;
                                            unsafe4 = unsafe6;
                                            i41 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 != 2) {
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                bArr4 = bArr5;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            } else if ((j3 & 536870912) == 0) {
                                                m8361f0 = yy2.m8355c0(bArr5, i39, oc3Var5);
                                                int i83 = oc3Var5.f23766a;
                                                if (i83 < 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i83 == 0) {
                                                    zzmjVar.add("");
                                                } else {
                                                    zzmjVar.add(new String(bArr5, m8361f0, i83, zzmk.f13887a));
                                                    m8361f0 += i83;
                                                }
                                                while (m8361f0 < i2) {
                                                    int m8355c06 = yy2.m8355c0(bArr5, m8361f0, oc3Var5);
                                                    if (i41 == oc3Var5.f23766a) {
                                                        m8361f0 = yy2.m8355c0(bArr5, m8355c06, oc3Var5);
                                                        int i84 = oc3Var5.f23766a;
                                                        if (i84 < 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i84 == 0) {
                                                            zzmjVar.add("");
                                                        } else {
                                                            zzmjVar.add(new String(bArr5, m8361f0, i84, zzmk.f13887a));
                                                            m8361f0 += i84;
                                                        }
                                                    } else {
                                                        i64 = i41;
                                                        i38 = i42;
                                                        i40 = 1;
                                                        bArr4 = bArr5;
                                                        if (m8361f0 == i39) {
                                                        }
                                                    }
                                                }
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                bArr4 = bArr5;
                                                if (m8361f0 == i39) {
                                                }
                                            } else {
                                                m8361f0 = yy2.m8355c0(bArr5, i39, oc3Var5);
                                                int i85 = oc3Var5.f23766a;
                                                if (i85 < 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i85 == 0) {
                                                    zzmjVar.add("");
                                                } else {
                                                    int i86 = m8361f0 + i85;
                                                    if (ke3.m5526d(bArr5, m8361f0, i86)) {
                                                        zzmjVar.add(new String(bArr5, m8361f0, i85, zzmk.f13887a));
                                                        m8361f0 = i86;
                                                    } else {
                                                        throw new zzmm("Protocol message had invalid UTF-8.");
                                                    }
                                                }
                                                while (m8361f0 < i2) {
                                                    int m8355c07 = yy2.m8355c0(bArr5, m8361f0, oc3Var5);
                                                    if (i41 == oc3Var5.f23766a) {
                                                        m8361f0 = yy2.m8355c0(bArr5, m8355c07, oc3Var5);
                                                        int i87 = oc3Var5.f23766a;
                                                        if (i87 < 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i87 == 0) {
                                                            zzmjVar.add("");
                                                        } else {
                                                            int i88 = m8361f0 + i87;
                                                            if (ke3.m5526d(bArr5, m8361f0, i88)) {
                                                                zzmjVar.add(new String(bArr5, m8361f0, i87, zzmk.f13887a));
                                                                m8361f0 = i88;
                                                            } else {
                                                                throw new zzmm("Protocol message had invalid UTF-8.");
                                                            }
                                                        }
                                                    } else {
                                                        bArr4 = bArr5;
                                                        i64 = i41;
                                                        i38 = i42;
                                                        i40 = 1;
                                                        if (m8361f0 == i39) {
                                                        }
                                                    }
                                                }
                                                bArr4 = bArr5;
                                                i64 = i41;
                                                i38 = i42;
                                                i40 = 1;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 27:
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 == 2) {
                                                i40 = 1;
                                                oc3Var5 = oc3Var;
                                                int m8351Z = yy2.m8351Z(m3231B(i34), i64 == true ? 1 : 0, bArr, i39, i2, zzmjVar, oc3Var);
                                                i34 = i34;
                                                bArr4 = bArr;
                                                i38 = i42;
                                                m8361f0 = m8351Z;
                                                i64 = i64 == true ? 1 : 0;
                                                if (m8361f0 == i39) {
                                                }
                                            } else {
                                                oc3Var5 = oc3Var;
                                                bArr4 = bArr;
                                                i40 = 1;
                                                i38 = i42;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i39 = i69;
                                            i42 = i71;
                                            if (z2 == 2) {
                                                m8361f0 = yy2.m8355c0(bArr, i39, oc3Var);
                                                int i89 = oc3Var.f23766a;
                                                if (i89 >= 0) {
                                                    if (i89 > bArr.length - m8361f0) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i89 == 0) {
                                                        zzmjVar.add(zzld.zzb);
                                                    } else {
                                                        zzmjVar.add(zzld.zzj(bArr, m8361f0, i89));
                                                        m8361f0 += i89;
                                                    }
                                                    while (m8361f0 < i2) {
                                                        int m8355c08 = yy2.m8355c0(bArr, m8361f0, oc3Var);
                                                        if (i64 == oc3Var.f23766a) {
                                                            m8361f0 = yy2.m8355c0(bArr, m8355c08, oc3Var);
                                                            int i90 = oc3Var.f23766a;
                                                            if (i90 >= 0) {
                                                                if (i90 > bArr.length - m8361f0) {
                                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                if (i90 == 0) {
                                                                    zzmjVar.add(zzld.zzb);
                                                                } else {
                                                                    zzmjVar.add(zzld.zzj(bArr, m8361f0, i90));
                                                                    m8361f0 += i90;
                                                                }
                                                            } else {
                                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        } else {
                                                            bArr4 = bArr;
                                                            oc3Var5 = oc3Var;
                                                            i40 = 1;
                                                            i38 = i42;
                                                            if (m8361f0 == i39) {
                                                            }
                                                        }
                                                    }
                                                    bArr4 = bArr;
                                                    oc3Var5 = oc3Var;
                                                    i40 = 1;
                                                    i38 = i42;
                                                    if (m8361f0 == i39) {
                                                    }
                                                } else {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                            } else {
                                                bArr4 = bArr;
                                                oc3Var5 = oc3Var;
                                                i40 = 1;
                                                i38 = i42;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            bArr6 = bArr;
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i39 = i69;
                                            if (z2 == 2) {
                                                m8359e0 = yy2.m8352a0(bArr6, i39, zzmjVar, oc3Var);
                                            } else {
                                                if (z2 == 0) {
                                                    m8359e0 = yy2.m8359e0(i64 == true ? 1 : 0, bArr, i39, i2, zzmjVar, oc3Var);
                                                }
                                                bArr4 = bArr6;
                                                oc3Var5 = oc3Var;
                                                i38 = i71;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            zzmg m3230A2 = m3230A(i34);
                                            C0782b c0782b = AbstractC0786f.f13768a;
                                            if (m3230A2 == null) {
                                                i44 = m8359e0;
                                                i45 = i71;
                                                i46 = 1;
                                            } else if (zzmjVar instanceof RandomAccess) {
                                                int size2 = zzmjVar.size();
                                                int i91 = 0;
                                                int i92 = 0;
                                                Object obj4 = null;
                                                while (i91 < size2) {
                                                    Integer num = (Integer) zzmjVar.get(i91);
                                                    int i93 = m8359e0;
                                                    int intValue = num.intValue();
                                                    if (m3230A2.zza(intValue)) {
                                                        if (i91 != i92) {
                                                            zzmjVar.set(i92, num);
                                                        }
                                                        i92++;
                                                        i47 = i71;
                                                    } else {
                                                        i47 = i71;
                                                        obj4 = AbstractC0786f.m3274r(i47, obj2, intValue, obj4);
                                                    }
                                                    i91++;
                                                    m8359e0 = i93;
                                                    i71 = i47;
                                                }
                                                i44 = m8359e0;
                                                i45 = i71;
                                                i46 = 1;
                                                if (i92 != size2) {
                                                    zzmjVar.subList(i92, size2).clear();
                                                }
                                            } else {
                                                i44 = m8359e0;
                                                i45 = i71;
                                                i46 = 1;
                                                Iterator it = zzmjVar.iterator();
                                                Object obj5 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!m3230A2.zza(intValue2)) {
                                                        obj5 = AbstractC0786f.m3274r(i45, obj2, intValue2, obj5);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            m8361f0 = i44;
                                            bArr4 = bArr6;
                                            oc3Var5 = oc3Var;
                                            i40 = i46;
                                            i38 = i45;
                                            if (m8361f0 == i39) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            bArr6 = bArr;
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i39 = i69;
                                            if (z2 == 2) {
                                                hd3 hd3Var3 = (hd3) zzmjVar;
                                                m8361f0 = yy2.m8355c0(bArr6, i39, oc3Var);
                                                int i94 = oc3Var.f23766a + m8361f0;
                                                while (m8361f0 < i94) {
                                                    m8361f0 = yy2.m8355c0(bArr6, m8361f0, oc3Var);
                                                    hd3Var3.m5053c(zzlg.zzb(oc3Var.f23766a));
                                                }
                                                if (m8361f0 != i94) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (z2 == 0) {
                                                    hd3 hd3Var4 = (hd3) zzmjVar;
                                                    m8361f0 = yy2.m8355c0(bArr6, i39, oc3Var);
                                                    hd3Var4.m5053c(zzlg.zzb(oc3Var.f23766a));
                                                    while (m8361f0 < i2) {
                                                        int m8355c09 = yy2.m8355c0(bArr6, m8361f0, oc3Var);
                                                        if (i64 == oc3Var.f23766a) {
                                                            m8361f0 = yy2.m8355c0(bArr6, m8355c09, oc3Var);
                                                            hd3Var4.m5053c(zzlg.zzb(oc3Var.f23766a));
                                                        }
                                                    }
                                                }
                                                bArr4 = bArr6;
                                                oc3Var5 = oc3Var;
                                                i38 = i71;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            bArr4 = bArr6;
                                            oc3Var5 = oc3Var;
                                            i38 = i71;
                                            i40 = 1;
                                            if (m8361f0 == i39) {
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr6 = bArr;
                                            unsafe4 = unsafe6;
                                            i64 = i70;
                                            i39 = i69;
                                            if (z2 == 2) {
                                                md3 md3Var5 = (md3) zzmjVar;
                                                m8361f0 = yy2.m8355c0(bArr6, i39, oc3Var);
                                                int i95 = oc3Var.f23766a + m8361f0;
                                                while (m8361f0 < i95) {
                                                    m8361f0 = yy2.m8361f0(bArr6, m8361f0, oc3Var);
                                                    md3Var5.m6139b(zzlg.zzc(oc3Var.f23767b));
                                                }
                                                if (m8361f0 != i95) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (z2 == 0) {
                                                    md3 md3Var6 = (md3) zzmjVar;
                                                    m8361f0 = yy2.m8361f0(bArr6, i39, oc3Var);
                                                    md3Var6.m6139b(zzlg.zzc(oc3Var.f23767b));
                                                    while (m8361f0 < i2) {
                                                        int m8355c010 = yy2.m8355c0(bArr6, m8361f0, oc3Var);
                                                        if (i64 == oc3Var.f23766a) {
                                                            m8361f0 = yy2.m8361f0(bArr6, m8355c010, oc3Var);
                                                            md3Var6.m6139b(zzlg.zzc(oc3Var.f23767b));
                                                        }
                                                    }
                                                }
                                                bArr4 = bArr6;
                                                oc3Var5 = oc3Var;
                                                i38 = i71;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            bArr4 = bArr6;
                                            oc3Var5 = oc3Var;
                                            i38 = i71;
                                            i40 = 1;
                                            if (m8361f0 == i39) {
                                            }
                                            break;
                                        default:
                                            char c = 3;
                                            if (z2 == 3) {
                                                i64 = i70;
                                                int i96 = ((i64 == true ? 1 : 0) & (-8)) | 4;
                                                xd3 m3231B = m3231B(i34);
                                                unsafe4 = unsafe6;
                                                i39 = i69;
                                                m8361f0 = yy2.m8350Y(m3231B, bArr, i69, i2, i96, oc3Var);
                                                zzmjVar.add(oc3Var.f23768c);
                                                while (true) {
                                                    if (m8361f0 < i2) {
                                                        bArr6 = bArr;
                                                        int m8355c011 = yy2.m8355c0(bArr6, m8361f0, oc3Var);
                                                        if (i64 == oc3Var.f23766a) {
                                                            m8361f0 = yy2.m8350Y(m3231B, bArr, m8355c011, i2, i96, oc3Var);
                                                            zzmjVar.add(oc3Var.f23768c);
                                                            c = 3;
                                                        }
                                                    } else {
                                                        bArr6 = bArr;
                                                    }
                                                }
                                                bArr4 = bArr6;
                                                oc3Var5 = oc3Var;
                                                i38 = i71;
                                                i40 = 1;
                                                if (m8361f0 == i39) {
                                                }
                                            } else {
                                                unsafe4 = unsafe6;
                                                i39 = i69;
                                                bArr4 = bArr;
                                                oc3Var5 = oc3Var;
                                                i64 = i70;
                                                i38 = i71;
                                                i40 = 1;
                                                m8361f0 = i39;
                                                if (m8361f0 == i39) {
                                                }
                                            }
                                            break;
                                    }
                                }
                            } else if (z2 == 2) {
                                zzmj zzmjVar2 = (zzmj) unsafe6.getObject(obj2, j);
                                if (!zzmjVar2.zzc()) {
                                    int size3 = zzmjVar2.size();
                                    zzmjVar2 = zzmjVar2.zzd(size3 == 0 ? 10 : size3 + size3);
                                    unsafe6.putObject(obj2, j, zzmjVar2);
                                }
                                i57 = yy2.m8351Z(m3231B(i72), i70, bArr, i69, i2, zzmjVar2, oc3Var);
                                i53 = i2;
                                c0784d2 = this;
                                i56 = 1;
                                i59 = i72;
                                unsafe5 = unsafe6;
                                i60 = i14;
                                i62 = i70;
                                i58 = i71;
                                bArr7 = bArr;
                                i54 = i3;
                                oc3Var6 = oc3Var;
                                i55 = 3;
                            } else {
                                oc3Var4 = oc3Var;
                                i33 = i69;
                                objArr = objArr2;
                                i34 = i72;
                                unsafe3 = unsafe6;
                                i35 = i70;
                                i36 = i71;
                                i37 = 3;
                                bArr3 = bArr;
                                c0784d = this;
                                i4 = i3;
                                i12 = i37;
                                i15 = i36;
                                i64 = i35;
                                bArr2 = bArr3;
                                i13 = i34;
                                i16 = i33;
                                i5 = 1;
                                unsafe = unsafe3;
                                oc3Var2 = oc3Var4;
                            }
                        } else {
                            int i97 = iArr2[i11 + 2];
                            int i98 = 1 << (i97 >>> 20);
                            int i99 = i64 == true ? 1 : 0;
                            int i100 = i97 & 1048575;
                            iArr = iArr2;
                            int i101 = i60;
                            if (i100 != i101) {
                                if (i101 != 1048575) {
                                    unsafe5.putInt(obj2, i101, i61);
                                }
                                i17 = i100 == 1048575 ? 0 : unsafe5.getInt(obj2, i100);
                                i18 = i100;
                            } else {
                                i17 = i61;
                                i18 = i101;
                            }
                            switch (m3228x) {
                                case 0:
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 1) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var7 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var7;
                                        break;
                                    } else {
                                        i23 = i17 | i98;
                                        ie3.m5223l(obj2, j, Double.longBitsToDouble(yy2.m8365i0(i20, bArr7)));
                                        c0784d2 = this;
                                        i57 = i20 + 8;
                                        i54 = i3;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i55 = 3;
                                        i56 = 1;
                                        i61 = i23;
                                    }
                                case 1:
                                    i24 = i2;
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 5) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var72 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var72;
                                        break;
                                    } else {
                                        i25 = i20 + 4;
                                        i26 = i17 | i98;
                                        ie3.m5224m(obj2, j, Float.intBitsToFloat(yy2.m8349X(i20, bArr7)));
                                        i54 = i3;
                                        i57 = i25;
                                        i53 = i24;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i56 = 1;
                                        c0784d2 = this;
                                        i61 = i26;
                                        i55 = 3;
                                    }
                                case 2:
                                case 3:
                                    i27 = i2;
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 0) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var722 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var722;
                                        break;
                                    } else {
                                        i28 = i17 | i98;
                                        int m8361f02 = yy2.m8361f0(bArr7, i20, oc3Var3);
                                        unsafe2.putLong(obj, j, oc3Var3.f23767b);
                                        i54 = i3;
                                        i57 = m8361f02;
                                        i53 = i27;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i55 = 3;
                                        i56 = 1;
                                        i61 = i28;
                                        c0784d2 = this;
                                    }
                                case 4:
                                case 11:
                                    i27 = i2;
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 0) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var7222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var7222;
                                        break;
                                    } else {
                                        i28 = i17 | i98;
                                        int m8355c012 = yy2.m8355c0(bArr7, i20, oc3Var3);
                                        unsafe2.putInt(obj2, j, oc3Var3.f23766a);
                                        i54 = i3;
                                        i57 = m8355c012;
                                        i53 = i27;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i55 = 3;
                                        i56 = 1;
                                        i61 = i28;
                                        c0784d2 = this;
                                    }
                                case 5:
                                case 14:
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 1) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var72222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var72222;
                                        break;
                                    } else {
                                        int i102 = i20 + 8;
                                        i29 = i17 | i98;
                                        unsafe2.putLong(obj, j, yy2.m8365i0(i20, bArr7));
                                        i54 = i3;
                                        i57 = i102;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i55 = 3;
                                        i56 = 1;
                                        c0784d2 = this;
                                        i61 = i29;
                                        i58 = i19;
                                    }
                                case 6:
                                case 13:
                                    i24 = i2;
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 5) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var722222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var722222;
                                        break;
                                    } else {
                                        i25 = i20 + 4;
                                        i26 = i17 | i98;
                                        unsafe2.putInt(obj2, j, yy2.m8349X(i20, bArr7));
                                        i54 = i3;
                                        i57 = i25;
                                        i53 = i24;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i56 = 1;
                                        c0784d2 = this;
                                        i61 = i26;
                                        i55 = 3;
                                    }
                                case 7:
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    z = false;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 0) {
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var7222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var7222222;
                                        break;
                                    } else {
                                        int i103 = i17 | i98;
                                        int m8361f03 = yy2.m8361f0(bArr7, i20, oc3Var3);
                                        ie3.m5222k(obj2, j, oc3Var3.f23767b != 0);
                                        c0784d2 = this;
                                        i54 = i3;
                                        i57 = m8361f03;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i55 = 3;
                                        i56 = 1;
                                        i61 = i103;
                                    }
                                case 8:
                                    oc3Var3 = oc3Var;
                                    i20 = i63;
                                    i19 = i65;
                                    i22 = i99;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 2) {
                                        z = false;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var72222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var72222222;
                                        break;
                                    } else {
                                        if ((i68 & 536870912) != 0) {
                                            int m8355c013 = yy2.m8355c0(bArr7, i20, oc3Var3);
                                            int i104 = oc3Var3.f23766a;
                                            if (i104 < 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i105 = i17 | i98;
                                            if (i104 == 0) {
                                                oc3Var3.f23768c = "";
                                                i31 = i105;
                                            } else {
                                                int i106 = ke3.f20839a;
                                                int length = bArr7.length;
                                                if ((m8355c013 | i104 | ((length - m8355c013) - i104)) >= 0) {
                                                    int i107 = m8355c013 + i104;
                                                    char[] cArr = new char[i104];
                                                    int i108 = 0;
                                                    while (m8355c013 < i107) {
                                                        byte b = bArr7[m8355c013];
                                                        if (p63.m6857Q(b)) {
                                                            m8355c013++;
                                                            cArr[i108] = (char) b;
                                                            i108++;
                                                        } else {
                                                            while (true) {
                                                                while (m8355c013 < i107) {
                                                                    int i109 = m8355c013 + 1;
                                                                    byte b2 = bArr7[m8355c013];
                                                                    if (p63.m6857Q(b2)) {
                                                                        cArr[i108] = (char) b2;
                                                                        i108++;
                                                                        m8355c013 = i109;
                                                                        while (m8355c013 < i107) {
                                                                            byte b3 = bArr7[m8355c013];
                                                                            if (p63.m6857Q(b3)) {
                                                                                m8355c013++;
                                                                                cArr[i108] = (char) b3;
                                                                                i108++;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        int i110 = i105;
                                                                        if (b2 < -32) {
                                                                            if (i109 < i107) {
                                                                                m8355c013 += 2;
                                                                                p63.m6856P(b2, bArr7[i109], cArr, i108);
                                                                                i108++;
                                                                                i105 = i110;
                                                                            } else {
                                                                                throw new zzmm("Protocol message had invalid UTF-8.");
                                                                            }
                                                                        } else if (b2 < -16) {
                                                                            if (i109 < i107 - 1) {
                                                                                int i111 = m8355c013 + 2;
                                                                                m8355c013 += 3;
                                                                                p63.m6855O(b2, bArr7[i109], bArr7[i111], cArr, i108);
                                                                                i105 = i110;
                                                                                i108++;
                                                                            } else {
                                                                                throw new zzmm("Protocol message had invalid UTF-8.");
                                                                            }
                                                                        } else if (i109 < i107 - 2) {
                                                                            byte b4 = bArr7[i109];
                                                                            int i112 = m8355c013 + 3;
                                                                            byte b5 = bArr7[m8355c013 + 2];
                                                                            m8355c013 += 4;
                                                                            p63.m6854N(b2, b4, b5, bArr7[i112], cArr, i108);
                                                                            i108 += 2;
                                                                            i105 = i110;
                                                                        } else {
                                                                            throw new zzmm("Protocol message had invalid UTF-8.");
                                                                        }
                                                                    }
                                                                }
                                                                i31 = i105;
                                                                oc3Var3.f23768c = new String(cArr, 0, i108);
                                                                m8355c013 = i107;
                                                            }
                                                        }
                                                    }
                                                    while (true) {
                                                        while (m8355c013 < i107) {
                                                        }
                                                        i31 = i105;
                                                        oc3Var3.f23768c = new String(cArr, 0, i108);
                                                        m8355c013 = i107;
                                                    }
                                                } else {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(m8355c013), Integer.valueOf(i104)));
                                                }
                                            }
                                            m8355c0 = m8355c013;
                                            i30 = 3;
                                            i23 = i31;
                                        } else {
                                            i30 = 3;
                                            m8355c0 = yy2.m8355c0(bArr7, i20, oc3Var3);
                                            int i113 = oc3Var3.f23766a;
                                            if (i113 < 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i23 = i17 | i98;
                                            if (i113 == 0) {
                                                oc3Var3.f23768c = "";
                                            } else {
                                                oc3Var3.f23768c = new String(bArr7, m8355c0, i113, zzmk.f13887a);
                                                m8355c0 += i113;
                                            }
                                        }
                                        unsafe2.putObject(obj2, j, oc3Var3.f23768c);
                                        i54 = i3;
                                        i57 = m8355c0;
                                        i53 = i2;
                                        i55 = i30;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i56 = 1;
                                        c0784d2 = this;
                                        i61 = i23;
                                    }
                                case 9:
                                    oc3Var3 = oc3Var;
                                    i19 = i65;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 2) {
                                        i22 = i99;
                                        i20 = i63;
                                        z = false;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var722222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var722222222;
                                        break;
                                    } else {
                                        i29 = i17 | i98;
                                        Object m3232C = c0784d2.m3232C(i21, obj2);
                                        int m8364h0 = yy2.m8364h0(m3232C, c0784d2.m3231B(i21), bArr, i63, i2, oc3Var);
                                        c0784d2.m3245l(i21, obj2, m3232C);
                                        i54 = i3;
                                        i57 = m8364h0;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i99;
                                        i55 = 3;
                                        i56 = 1;
                                        i61 = i29;
                                        i58 = i19;
                                    }
                                case 10:
                                    oc3Var3 = oc3Var;
                                    i19 = i65;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 2) {
                                        i22 = i99;
                                        z = false;
                                        i20 = i63;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var7222222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var7222222222;
                                        break;
                                    } else {
                                        int m8348W2 = yy2.m8348W(bArr7, i63, oc3Var3);
                                        unsafe2.putObject(obj2, j, oc3Var3.f23768c);
                                        i62 = i99;
                                        i54 = i3;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        i60 = i18;
                                        i58 = i19;
                                        i55 = 3;
                                        i56 = 1;
                                        i57 = m8348W2;
                                        i61 = i17 | i98;
                                        oc3Var6 = oc3Var3;
                                    }
                                case 12:
                                    oc3Var3 = oc3Var;
                                    i19 = i65;
                                    i22 = i99;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 0) {
                                        i20 = i63;
                                        z = false;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var72222222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var72222222222;
                                        break;
                                    } else {
                                        int m8355c014 = yy2.m8355c0(bArr7, i63, oc3Var3);
                                        int i114 = oc3Var3.f23766a;
                                        zzmg m3230A3 = c0784d2.m3230A(i21);
                                        if ((i68 & Integer.MIN_VALUE) != 0 && m3230A3 != null && !m3230A3.zza(i114)) {
                                            i32 = i22;
                                            m3225t(obj).m3478b(i32, Long.valueOf(i114));
                                        } else {
                                            i32 = i22;
                                            i17 |= i98;
                                            unsafe2.putInt(obj2, j, i114);
                                        }
                                        i62 = i32;
                                        i54 = i3;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        i60 = i18;
                                        i58 = i19;
                                        i56 = 1;
                                        i57 = m8355c014;
                                        i61 = i17;
                                        oc3Var6 = oc3Var3;
                                        i55 = 3;
                                    }
                                case 15:
                                    oc3Var3 = oc3Var;
                                    i19 = i65;
                                    i22 = i99;
                                    unsafe2 = unsafe5;
                                    i21 = i11;
                                    if (z2 != 0) {
                                        i20 = i63;
                                        z = false;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var722222222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var722222222222;
                                        break;
                                    } else {
                                        int i115 = i17 | i98;
                                        int m8355c015 = yy2.m8355c0(bArr7, i63, oc3Var3);
                                        unsafe2.putInt(obj2, j, zzlg.zzb(oc3Var3.f23766a));
                                        i54 = i3;
                                        i53 = i2;
                                        i59 = i21;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var3;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i56 = 1;
                                        i61 = i115;
                                        i57 = m8355c015;
                                        i55 = 3;
                                    }
                                case 16:
                                    i19 = i65;
                                    i22 = i99;
                                    unsafe2 = unsafe5;
                                    if (z2 != 0) {
                                        oc3Var3 = oc3Var;
                                        i21 = i11;
                                        i20 = i63;
                                        z = false;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var7222222222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var7222222222222;
                                        break;
                                    } else {
                                        int i116 = i17 | i98;
                                        int m8361f04 = yy2.m8361f0(bArr7, i63, oc3Var);
                                        int i117 = i11;
                                        unsafe2.putLong(obj, j, zzlg.zzc(oc3Var.f23767b));
                                        i54 = i3;
                                        i53 = i2;
                                        i59 = i117;
                                        unsafe5 = unsafe2;
                                        oc3Var6 = oc3Var;
                                        i60 = i18;
                                        i62 = i22;
                                        i58 = i19;
                                        i55 = 3;
                                        i56 = 1;
                                        i61 = i116;
                                        i57 = m8361f04;
                                    }
                                default:
                                    if (z2 != 3) {
                                        i19 = i65;
                                        unsafe2 = unsafe5;
                                        oc3Var3 = oc3Var;
                                        i20 = i63;
                                        i21 = i11;
                                        i22 = i99;
                                        z = false;
                                        c0784d = this;
                                        i4 = i3;
                                        objArr = objArr2;
                                        i13 = i21;
                                        bArr2 = bArr7;
                                        i14 = i18;
                                        i64 = i22;
                                        i15 = i19;
                                        i5 = 1;
                                        i12 = 3;
                                        i61 = i17;
                                        i16 = i20;
                                        oc3 oc3Var72222222222222 = oc3Var3;
                                        unsafe = unsafe2;
                                        oc3Var2 = oc3Var72222222222222;
                                        break;
                                    } else {
                                        int i118 = i17 | i98;
                                        Object m3232C2 = c0784d2.m3232C(i11, obj2);
                                        i57 = yy2.m8362g0(m3232C2, c0784d2.m3231B(i11), bArr, i63, i2, (i65 << 3) | 4, oc3Var);
                                        c0784d2.m3245l(i11, obj2, m3232C2);
                                        i54 = i3;
                                        oc3Var6 = oc3Var;
                                        unsafe5 = unsafe5;
                                        i59 = i11;
                                        i60 = i18;
                                        i62 = i99;
                                        i58 = i65;
                                        i56 = 1;
                                        i53 = i2;
                                        i61 = i118;
                                        i55 = 3;
                                    }
                            }
                        }
                    } else {
                        i12 = i55;
                        i13 = i10;
                        i4 = i54;
                        objArr = objArr2;
                        iArr = iArr2;
                        i14 = i60;
                        i5 = 1;
                        c0784d = c0784d2;
                        unsafe = unsafe5;
                        i15 = i65;
                        bArr2 = bArr7;
                        oc3Var2 = oc3Var6;
                        i16 = i63;
                    }
                    if (i64 != i4 || i4 == 0) {
                        if (c0784d.f13759f) {
                            zzlp zzlpVar = zzlp.f13880b;
                            ud3 ud3Var = ud3.f27230c;
                            zzlp zzlpVar2 = zzlp.f13881c;
                            zzlp zzlpVar3 = oc3Var2.f23769d;
                            if (zzlpVar3 != zzlpVar2) {
                                if (zzlpVar3.zzb(c0784d.f13758e, i15) == null) {
                                    m8353b0 = yy2.m8353b0(i64, bArr, i16, i2, m3225t(obj), oc3Var);
                                    i53 = i2;
                                    bArr7 = bArr2;
                                    i62 = i64;
                                    i54 = i4;
                                    c0784d2 = c0784d;
                                    i58 = i15;
                                    oc3Var6 = oc3Var2;
                                    unsafe5 = unsafe;
                                    i60 = i14;
                                    i59 = i13;
                                    i57 = m8353b0;
                                    i56 = i5;
                                    i55 = i12;
                                } else {
                                    throw null;
                                }
                            }
                        }
                        m8353b0 = yy2.m8353b0(i64, bArr, i16, i2, m3225t(obj), oc3Var);
                        i53 = i2;
                        bArr7 = bArr2;
                        i62 = i64;
                        i54 = i4;
                        c0784d2 = c0784d;
                        i58 = i15;
                        oc3Var6 = oc3Var2;
                        unsafe5 = unsafe;
                        i60 = i14;
                        i59 = i13;
                        i57 = m8353b0;
                        i56 = i5;
                        i55 = i12;
                    } else {
                        i8 = i64;
                        i7 = i61;
                        i9 = i14;
                        i6 = 1048575;
                        i57 = i16;
                    }
                } else {
                    c0784d = c0784d2;
                    i4 = i54;
                    objArr = objArr2;
                    i5 = i56;
                    iArr = iArr2;
                    i6 = 1048575;
                    unsafe = unsafe5;
                    i7 = i61;
                    i8 = i62;
                    i9 = i60;
                }
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    /* renamed from: w */
    public final int m3252w(int i, int i2) {
        int[] iArr = this.f13754a;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: y */
    public final int m3253y(int i) {
        return this.f13754a[i + 1];
    }

    @Override // p000.xd3
    public final Object zze() {
        return (zzmd) ((zzmd) this.f13758e).zzl(4, null, null);
    }
}
