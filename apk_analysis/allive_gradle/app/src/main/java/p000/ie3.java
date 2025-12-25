package p000;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class ie3 {

    /* renamed from: a */
    public static final Unsafe f18386a;

    /* renamed from: b */
    public static final Class f18387b;

    /* renamed from: c */
    public static final ge3 f18388c;

    /* renamed from: d */
    public static final boolean f18389d;

    /* renamed from: e */
    public static final boolean f18390e;

    /* renamed from: f */
    public static final long f18391f;

    /* renamed from: g */
    public static final boolean f18392g;

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(17:(1:64)(1:(1:66))|4|(7:42|43|44|45|46|(4:50|51|(1:53)|56)|(14:49|7|(14:35|36|37|38|10|11|12|(3:25|26|(6:30|(1:18)|19|(1:21)|22|23))|14|(2:16|18)|19|(0)|22|23)|9|10|11|12|(0)|14|(0)|19|(0)|22|23))|6|7|(0)|9|10|11|12|(0)|14|(0)|19|(0)|22|23)|3|4|(0)|6|7|(0)|9|10|11|12|(0)|14|(0)|19|(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x016d, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007a, code lost:
    
        if (r0.getType() == java.lang.Long.TYPE) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004c  */
    static {
        ge3 ee3Var;
        Field field;
        boolean z;
        ge3 ge3Var;
        boolean z2;
        Field field2;
        Field field3;
        ge3 ge3Var2;
        boolean z3 = false;
        Unsafe m5221j = m5221j();
        f18386a = m5221j;
        int i = nc3.f23326a;
        f18387b = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean m5230s = m5230s(cls);
        boolean m5230s2 = m5230s(Integer.TYPE);
        if (m5221j != null) {
            if (m5230s) {
                ee3Var = new fe3(m5221j);
            } else if (m5230s2) {
                ee3Var = new ee3(m5221j);
            }
            f18388c = ee3Var;
            if (ee3Var != null) {
                try {
                    Class<?> cls2 = ((Unsafe) ee3Var.f17677a).getClass();
                    cls2.getMethod("objectFieldOffset", Field.class);
                    cls2.getMethod("getLong", Object.class, cls);
                    try {
                        field = Buffer.class.getDeclaredField("effectiveDirectAddress");
                    } catch (Throwable unused) {
                        field = null;
                    }
                    if (field == null) {
                        try {
                            field = Buffer.class.getDeclaredField("address");
                        } catch (Throwable unused2) {
                            field = null;
                        }
                        if (field != null) {
                        }
                        field = null;
                    }
                } catch (Throwable th) {
                    Logger.getLogger(ie3.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
                }
                if (field != null) {
                    z = true;
                    f18389d = z;
                    ge3Var = f18388c;
                    if (ge3Var != null) {
                        try {
                            Class<?> cls3 = ((Unsafe) ge3Var.f17677a).getClass();
                            cls3.getMethod("objectFieldOffset", Field.class);
                            cls3.getMethod("arrayBaseOffset", Class.class);
                            cls3.getMethod("arrayIndexScale", Class.class);
                            Class<?> cls4 = Long.TYPE;
                            cls3.getMethod("getInt", Object.class, cls4);
                            cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                            cls3.getMethod("getLong", Object.class, cls4);
                            cls3.getMethod("putLong", Object.class, cls4, cls4);
                            cls3.getMethod("getObject", Object.class, cls4);
                            cls3.getMethod("putObject", Object.class, cls4, Object.class);
                            z2 = true;
                        } catch (Throwable th2) {
                            Logger.getLogger(ie3.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th2.toString()));
                        }
                        f18390e = z2;
                        f18391f = m5232u(byte[].class);
                        m5232u(boolean[].class);
                        m5212a(boolean[].class);
                        m5232u(int[].class);
                        m5212a(int[].class);
                        m5232u(long[].class);
                        m5212a(long[].class);
                        m5232u(float[].class);
                        m5212a(float[].class);
                        m5232u(double[].class);
                        m5212a(double[].class);
                        m5232u(Object[].class);
                        m5212a(Object[].class);
                        int i2 = nc3.f23326a;
                        field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
                        if (field2 == null) {
                            try {
                                field2 = Buffer.class.getDeclaredField("address");
                            } catch (Throwable unused3) {
                                field2 = null;
                            }
                            if (field2 == null || field2.getType() != Long.TYPE) {
                                field3 = null;
                                if (field3 != null && (ge3Var2 = f18388c) != null) {
                                    ((Unsafe) ge3Var2.f17677a).objectFieldOffset(field3);
                                }
                                if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                    z3 = true;
                                }
                                f18392g = z3;
                            }
                        }
                        field3 = field2;
                        if (field3 != null) {
                            ((Unsafe) ge3Var2.f17677a).objectFieldOffset(field3);
                        }
                        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                        }
                        f18392g = z3;
                    }
                    z2 = false;
                    f18390e = z2;
                    f18391f = m5232u(byte[].class);
                    m5232u(boolean[].class);
                    m5212a(boolean[].class);
                    m5232u(int[].class);
                    m5212a(int[].class);
                    m5232u(long[].class);
                    m5212a(long[].class);
                    m5232u(float[].class);
                    m5212a(float[].class);
                    m5232u(double[].class);
                    m5212a(double[].class);
                    m5232u(Object[].class);
                    m5212a(Object[].class);
                    int i22 = nc3.f23326a;
                    field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
                    if (field2 == null) {
                    }
                    field3 = field2;
                    if (field3 != null) {
                    }
                    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                    }
                    f18392g = z3;
                }
            }
            z = false;
            f18389d = z;
            ge3Var = f18388c;
            if (ge3Var != null) {
            }
            z2 = false;
            f18390e = z2;
            f18391f = m5232u(byte[].class);
            m5232u(boolean[].class);
            m5212a(boolean[].class);
            m5232u(int[].class);
            m5212a(int[].class);
            m5232u(long[].class);
            m5212a(long[].class);
            m5232u(float[].class);
            m5212a(float[].class);
            m5232u(double[].class);
            m5212a(double[].class);
            m5232u(Object[].class);
            m5212a(Object[].class);
            int i222 = nc3.f23326a;
            field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            if (field2 == null) {
            }
            field3 = field2;
            if (field3 != null) {
            }
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            }
            f18392g = z3;
        }
        ee3Var = null;
        f18388c = ee3Var;
        if (ee3Var != null) {
        }
        z = false;
        f18389d = z;
        ge3Var = f18388c;
        if (ge3Var != null) {
        }
        z2 = false;
        f18390e = z2;
        f18391f = m5232u(byte[].class);
        m5232u(boolean[].class);
        m5212a(boolean[].class);
        m5232u(int[].class);
        m5212a(int[].class);
        m5232u(long[].class);
        m5212a(long[].class);
        m5232u(float[].class);
        m5212a(float[].class);
        m5232u(double[].class);
        m5212a(double[].class);
        m5232u(Object[].class);
        m5212a(Object[].class);
        int i2222 = nc3.f23326a;
        field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
        if (field2 == null) {
        }
        field3 = field2;
        if (field3 != null) {
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
        }
        f18392g = z3;
    }

    /* renamed from: a */
    public static void m5212a(Class cls) {
        if (f18390e) {
            ((Unsafe) f18388c.f17677a).arrayIndexScale(cls);
        }
    }

    /* renamed from: b */
    public static void m5213b(Object obj, long j, byte b) {
        Unsafe unsafe = (Unsafe) f18388c.f17677a;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* renamed from: c */
    public static void m5214c(Object obj, long j, byte b) {
        Unsafe unsafe = (Unsafe) f18388c.f17677a;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i) | (unsafe.getInt(obj, j2) & (~(255 << i))));
    }

    /* renamed from: d */
    public static double m5215d(Object obj, long j) {
        return f18388c.mo4693j(obj, j);
    }

    /* renamed from: e */
    public static float m5216e(Object obj, long j) {
        return f18388c.mo4694k(obj, j);
    }

    /* renamed from: f */
    public static int m5217f(Object obj, long j) {
        return ((Unsafe) f18388c.f17677a).getInt(obj, j);
    }

    /* renamed from: g */
    public static long m5218g(Object obj, long j) {
        return ((Unsafe) f18388c.f17677a).getLong(obj, j);
    }

    /* renamed from: h */
    public static Object m5219h(Class cls) {
        try {
            return f18386a.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: i */
    public static Object m5220i(Object obj, long j) {
        return ((Unsafe) f18388c.f17677a).getObject(obj, j);
    }

    /* renamed from: j */
    public static Unsafe m5221j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new de3());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: k */
    public static void m5222k(Object obj, long j, boolean z) {
        f18388c.mo4695l(obj, j, z);
    }

    /* renamed from: l */
    public static void m5223l(Object obj, long j, double d) {
        f18388c.mo4697n(obj, j, d);
    }

    /* renamed from: m */
    public static void m5224m(Object obj, long j, float f) {
        f18388c.mo4698o(obj, j, f);
    }

    /* renamed from: n */
    public static void m5225n(Object obj, long j, int i) {
        ((Unsafe) f18388c.f17677a).putInt(obj, j, i);
    }

    /* renamed from: o */
    public static void m5226o(Object obj, long j, long j2) {
        ((Unsafe) f18388c.f17677a).putLong(obj, j, j2);
    }

    /* renamed from: p */
    public static void m5227p(long j, Object obj, Object obj2) {
        ((Unsafe) f18388c.f17677a).putObject(obj, j, obj2);
    }

    /* renamed from: q */
    public static /* bridge */ /* synthetic */ boolean m5228q(Object obj, long j) {
        if (((byte) ((((Unsafe) f18388c.f17677a).getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: r */
    public static /* bridge */ /* synthetic */ boolean m5229r(Object obj, long j) {
        if (((byte) ((((Unsafe) f18388c.f17677a).getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: s */
    public static boolean m5230s(Class cls) {
        int i = nc3.f23326a;
        try {
            Class cls2 = f18387b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: t */
    public static boolean m5231t(Object obj, long j) {
        return f18388c.mo4699p(obj, j);
    }

    /* renamed from: u */
    public static int m5232u(Class cls) {
        if (f18390e) {
            return ((Unsafe) f18388c.f17677a).arrayBaseOffset(cls);
        }
        return -1;
    }
}
