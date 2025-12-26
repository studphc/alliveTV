package p000;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class ta1 implements pa1 {

    /* renamed from: a */
    public static final qa1 f26745a;

    /* renamed from: b */
    public static final ra1 f26746b;

    /* renamed from: c */
    public static final Unsafe f26747c;

    /* renamed from: d */
    public static final int f26748d;

    /* renamed from: e */
    public static final /* synthetic */ ta1[] f26749e;

    static {
        qa1 qa1Var = new qa1();
        f26745a = qa1Var;
        ra1 ra1Var = new ra1();
        f26746b = ra1Var;
        f26749e = new ta1[]{qa1Var, ra1Var};
        Unsafe m7471d = m7471d();
        f26747c = m7471d;
        f26748d = m7471d.arrayBaseOffset(byte[].class);
        if (m7471d.arrayIndexScale(byte[].class) == 1) {
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public static Unsafe m7471d() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new sa1());
        }
    }

    public static ta1 valueOf(String str) {
        return (ta1) Enum.valueOf(ta1.class, str);
    }

    public static ta1[] values() {
        return (ta1[]) f26749e.clone();
    }
}
