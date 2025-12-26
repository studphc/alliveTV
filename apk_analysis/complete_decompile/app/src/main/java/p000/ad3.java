package p000;

import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzld;
import com.google.android.gms.internal.measurement.zzlk;
import com.google.android.gms.internal.measurement.zzlt;
import com.google.android.gms.internal.measurement.zzmd;
import com.google.android.gms.internal.measurement.zzmf;
import com.google.android.gms.internal.measurement.zzmk;
import com.google.android.gms.internal.measurement.zzmr;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zzni;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.internal.measurement.zzoq;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ad3 {

    /* renamed from: d */
    public static final ad3 f143d = new ad3(0);

    /* renamed from: a */
    public final yd3 f144a = new yd3();

    /* renamed from: b */
    public boolean f145b;

    /* renamed from: c */
    public boolean f146c;

    public ad3() {
    }

    /* renamed from: a */
    public static int m67a(zzlt zzltVar, Object obj) {
        zzltVar.zzb();
        int zza = zzltVar.zza();
        if (zzltVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            if (zzltVar.zzd()) {
                if (list.isEmpty()) {
                    return 0;
                }
                if (size <= 0) {
                    return zzlk.zzz(0) + zzlk.zzz(zza << 3);
                }
                list.get(0);
                zzop zzopVar = zzop.zza;
                zzoq zzoqVar = zzoq.zza;
                throw null;
            }
            if (size <= 0) {
                return 0;
            }
            Object obj2 = list.get(0);
            zzlk.zzz(zza << 3);
            if (zzop.zzj == null) {
                Charset charset = zzmk.f13887a;
                if (((zznh) obj2) instanceof zzkp) {
                    throw null;
                }
            }
            zzoq zzoqVar2 = zzoq.zza;
            throw null;
        }
        zzlk.zzz(zza << 3);
        if (zzop.zzj == null) {
            Charset charset2 = zzmk.f13887a;
            if (((zznh) obj) instanceof zzkp) {
                throw null;
            }
        }
        zzoq zzoqVar3 = zzoq.zza;
        throw null;
    }

    /* renamed from: f */
    public static boolean m68f(Map.Entry entry) {
        boolean z;
        zzlt zzltVar = (zzlt) entry.getKey();
        if (zzltVar.zzc() == zzoq.zzi) {
            if (zzltVar.zze()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Object obj = list.get(i);
                    if (obj instanceof zzni) {
                        z = ((zzni) obj).zzcD();
                    } else if (obj instanceof zzmr) {
                        z = true;
                    } else {
                        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    }
                    if (!z) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzni) {
                    return ((zzni) value).zzcD();
                }
                if (value instanceof zzmr) {
                    return true;
                }
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    /* renamed from: g */
    public static final int m69g(Map.Entry entry) {
        int i;
        int zzz;
        int m8285e;
        zzlt zzltVar = (zzlt) entry.getKey();
        Object value = entry.getValue();
        if (zzltVar.zzc() == zzoq.zzi && !zzltVar.zze() && !zzltVar.zzd()) {
            if (value instanceof zzmr) {
                int zza = ((zzlt) entry.getKey()).zza();
                int zzz2 = zzlk.zzz(8);
                i = zzz2 + zzz2;
                zzz = zzlk.zzz(zza) + zzlk.zzz(16);
                int zzz3 = zzlk.zzz(24);
                int zza2 = ((zzmr) value).zza();
                m8285e = ye0.m8285e(zza2, zza2, zzz3);
            } else {
                int zza3 = ((zzlt) entry.getKey()).zza();
                int zzz4 = zzlk.zzz(8);
                i = zzz4 + zzz4;
                zzz = zzlk.zzz(zza3) + zzlk.zzz(16);
                int zzz5 = zzlk.zzz(24);
                int zzcf = ((zznh) value).zzcf();
                m8285e = ye0.m8285e(zzcf, zzcf, zzz5);
            }
            return i + zzz + m8285e;
        }
        return m67a(zzltVar, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m70h(zzlt zzltVar, Object obj) {
        boolean z;
        zzop zzb = zzltVar.zzb();
        Charset charset = zzmk.f13887a;
        obj.getClass();
        zzop zzopVar = zzop.zza;
        zzoq zzoqVar = zzoq.zza;
        switch (zzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzld) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzmf)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zznh) || (obj instanceof zzmr)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    /* renamed from: b */
    public final Iterator m71b() {
        yd3 yd3Var = this.f144a;
        if (yd3Var.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.f146c) {
            return new oj2(((C1251h) yd3Var.entrySet()).iterator(), 2);
        }
        return ((C1251h) yd3Var.entrySet()).iterator();
    }

    /* renamed from: c */
    public final void m72c() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (this.f145b) {
            return;
        }
        yd3 yd3Var = this.f144a;
        int i = yd3Var.f28915b;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = yd3Var.m8270f(i2).f29327b;
            if (obj instanceof zzmd) {
                ((zzmd) obj).zzcr();
            }
        }
        Iterator it = yd3Var.m8268c().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof zzmd) {
                ((zzmd) value).zzcr();
            }
        }
        if (!yd3Var.f28917d) {
            for (int i3 = 0; i3 < yd3Var.f28915b; i3++) {
                zd3 m8270f = yd3Var.m8270f(i3);
                if (((zzlt) m8270f.f29326a).zze()) {
                    m8270f.setValue(Collections.unmodifiableList((List) m8270f.f29327b));
                }
            }
            for (Map.Entry entry : yd3Var.m8268c()) {
                if (((zzlt) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        if (!yd3Var.f28917d) {
            if (yd3Var.f28916c.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(yd3Var.f28916c);
            }
            yd3Var.f28916c = unmodifiableMap;
            if (yd3Var.f28919f.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(yd3Var.f28919f);
            }
            yd3Var.f28919f = unmodifiableMap2;
            yd3Var.f28917d = true;
        }
        this.f145b = true;
    }

    public final Object clone() {
        ad3 ad3Var = new ad3();
        yd3 yd3Var = this.f144a;
        int i = yd3Var.f28915b;
        for (int i2 = 0; i2 < i; i2++) {
            zd3 m8270f = yd3Var.m8270f(i2);
            ad3Var.m73d((zzlt) m8270f.f29326a, m8270f.f29327b);
        }
        for (Map.Entry entry : yd3Var.m8268c()) {
            ad3Var.m73d((zzlt) entry.getKey(), entry.getValue());
        }
        ad3Var.f146c = this.f146c;
        return ad3Var;
    }

    /* renamed from: d */
    public final void m73d(zzlt zzltVar, Object obj) {
        if (zzltVar.zze()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    m70h(zzltVar, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            m70h(zzltVar, obj);
        }
        if (obj instanceof zzmr) {
            this.f146c = true;
        }
        this.f144a.put(zzltVar, obj);
    }

    /* renamed from: e */
    public final boolean m74e() {
        yd3 yd3Var = this.f144a;
        int i = yd3Var.f28915b;
        for (int i2 = 0; i2 < i; i2++) {
            if (!m68f(yd3Var.m8270f(i2))) {
                return false;
            }
        }
        Iterator it = yd3Var.m8268c().iterator();
        while (it.hasNext()) {
            if (!m68f((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad3)) {
            return false;
        }
        return this.f144a.equals(((ad3) obj).f144a);
    }

    public final int hashCode() {
        return this.f144a.hashCode();
    }

    public ad3(int i) {
        m72c();
        m72c();
    }
}
