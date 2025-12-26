package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzlz;
import com.google.android.gms.internal.measurement.zzmd;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p000.hd3;
import p000.ie3;
import p000.md3;
import p000.ud3;
import p000.vd3;
import p000.wc3;
import p000.wd3;
import p000.xd3;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class zzmd<MessageType extends zzmd<MessageType, BuilderType>, BuilderType extends zzlz<MessageType, BuilderType>> extends zzko<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzof zzc = zzof.zzc();

    /* renamed from: b */
    public static zzmd m3469b(Class cls) {
        Map map = zzb;
        zzmd zzmdVar = (zzmd) map.get(cls);
        if (zzmdVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzmdVar = (zzmd) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzmdVar == null) {
            zzmdVar = (zzmd) ((zzmd) ie3.m5219h(cls)).zzl(6, null, null);
            if (zzmdVar != null) {
                map.put(cls, zzmdVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzmdVar;
    }

    /* renamed from: c */
    public static Object m3470c(Method method, zznh zznhVar, Object... objArr) {
        try {
            return method.invoke(zznhVar, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* renamed from: g */
    public static final boolean m3471g(zzmd zzmdVar, boolean z) {
        zzmd zzmdVar2;
        byte byteValue = ((Byte) zzmdVar.zzl(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean mo3239f = ud3.f27230c.m7701a(zzmdVar.getClass()).mo3239f(zzmdVar);
        if (z) {
            if (true != mo3239f) {
                zzmdVar2 = null;
            } else {
                zzmdVar2 = zzmdVar;
            }
            zzmdVar.zzl(2, zzmdVar2, null);
        }
        return mo3239f;
    }

    public static zzmh zzck() {
        return hd3.f18033e;
    }

    public static zzmi zzcl() {
        return md3.f22902e;
    }

    public static zzmi zzcm(zzmi zzmiVar) {
        int size = zzmiVar.size();
        return zzmiVar.zzd(size + size);
    }

    public static zzmj zzcn() {
        return vd3.f27746e;
    }

    public static zzmj zzco(zzmj zzmjVar) {
        int size = zzmjVar.size();
        return zzmjVar.zzd(size + size);
    }

    public static Object zzcq(zznh zznhVar, String str, Object[] objArr) {
        return new wd3(zznhVar, str, objArr);
    }

    public static void zzct(Class cls, zzmd zzmdVar) {
        zzmdVar.m3472d();
        zzb.put(cls, zzmdVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzko
    /* renamed from: a */
    public final int mo3461a(xd3 xd3Var) {
        if (m3474f()) {
            int mo3238e = xd3Var.mo3238e(this);
            if (mo3238e >= 0) {
                return mo3238e;
            }
            throw new IllegalStateException(ye0.m8291k(mo3238e, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i == Integer.MAX_VALUE) {
            int mo3238e2 = xd3Var.mo3238e(this);
            if (mo3238e2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | mo3238e2;
                return mo3238e2;
            }
            throw new IllegalStateException(ye0.m8291k(mo3238e2, "serialized size must be non-negative, was "));
        }
        return i;
    }

    /* renamed from: d */
    public final void m3472d() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* renamed from: e */
    public final void m3473e() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ud3.f27230c.m7701a(getClass()).mo3237d(this, (zzmd) obj);
    }

    /* renamed from: f */
    public final boolean m3474f() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final int hashCode() {
        if (!m3474f()) {
            int i = this.zza;
            if (i == 0) {
                int mo3241h = ud3.f27230c.m7701a(getClass()).mo3241h(this);
                this.zza = mo3241h;
                return mo3241h;
            }
            return i;
        }
        return ud3.f27230c.m7701a(getClass()).mo3241h(this);
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = AbstractC0783c.f13751a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        AbstractC0783c.m3222c(this, sb, 0);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final /* synthetic */ zzng zzcA() {
        return (zzlz) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final void zzcB(zzlk zzlkVar) {
        xd3 m7701a = ud3.f27230c.m7701a(getClass());
        wc3 wc3Var = zzlkVar.f13879a;
        if (wc3Var == null) {
            wc3Var = new wc3(zzlkVar);
        }
        m7701a.mo3235b(this, wc3Var);
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final /* synthetic */ zznh zzcC() {
        return (zzmd) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final boolean zzcD() {
        return m3471g(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final int zzcf() {
        int i;
        if (m3474f()) {
            i = ud3.f27230c.m7701a(getClass()).mo3238e(this);
            if (i < 0) {
                throw new IllegalStateException(ye0.m8291k(i, "serialized size must be non-negative, was "));
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = ud3.f27230c.m7701a(getClass()).mo3238e(this);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException(ye0.m8291k(i, "serialized size must be non-negative, was "));
                }
            }
        }
        return i;
    }

    public final zzlz zzcg() {
        return (zzlz) zzl(5, null, null);
    }

    public final zzlz zzch() {
        zzlz zzlzVar = (zzlz) zzl(5, null, null);
        zzlzVar.zzaY(this);
        return zzlzVar;
    }

    public final void zzcr() {
        ud3.f27230c.m7701a(getClass()).mo3234a(this);
        m3472d();
    }

    public abstract Object zzl(int i, Object obj, Object obj2);
}
