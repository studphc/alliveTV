package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzjx {
    public static final zzjx zza = new zzjx(null, null, 100);

    /* renamed from: a */
    public final EnumMap f14288a;

    /* renamed from: b */
    public final int f14289b;

    public zzjx(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        this.f14288a = enumMap;
        zzjw zzjwVar = zzjw.AD_STORAGE;
        zzju zzjuVar = zzju.UNINITIALIZED;
        enumMap.put((EnumMap) zzjwVar, (zzjw) zzjuVar);
        enumMap.put((EnumMap) zzjw.ANALYTICS_STORAGE, (zzjw) zzjuVar);
        this.f14289b = i;
    }

    /* renamed from: a */
    public static char m3561a(zzju zzjuVar) {
        if (zzjuVar != null) {
            int ordinal = zzjuVar.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        return '1';
                    }
                    return '-';
                }
                return '0';
            }
            return '+';
        }
        return '-';
    }

    /* renamed from: b */
    public static zzju m3562b(String str) {
        if (str == null) {
            return zzju.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzju.GRANTED;
        }
        if (str.equals("denied")) {
            return zzju.DENIED;
        }
        return zzju.UNINITIALIZED;
    }

    /* renamed from: c */
    public static zzju m3563c(char c) {
        if (c != '+') {
            if (c != '0') {
                if (c != '1') {
                    return zzju.UNINITIALIZED;
                }
                return zzju.GRANTED;
            }
            return zzju.DENIED;
        }
        return zzju.POLICY;
    }

    /* renamed from: d */
    public static String m3564d(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjx zzi(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzjx(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.STORAGE.f14286a) {
            enumMap.put((EnumMap) zzjwVar, (zzjw) m3562b(bundle.getString(zzjwVar.zze)));
        }
        return new zzjx(enumMap, i);
    }

    public static zzjx zzj(zzju zzjuVar, zzju zzjuVar2, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        enumMap.put((EnumMap) zzjw.AD_STORAGE, (zzjw) zzjuVar);
        enumMap.put((EnumMap) zzjw.ANALYTICS_STORAGE, (zzjw) zzjuVar2);
        return new zzjx(enumMap, -10);
    }

    public static zzjx zzk(String str, int i) {
        String str2;
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjw[] zzb = zzjv.STORAGE.zzb();
        for (int i2 = 0; i2 < zzb.length; i2++) {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            zzjw zzjwVar = zzb[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put((EnumMap) zzjwVar, (zzjw) m3563c(str2.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzjwVar, (zzjw) zzju.UNINITIALIZED);
            }
        }
        return new zzjx(enumMap, i);
    }

    public static boolean zzs(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjx)) {
            return false;
        }
        zzjx zzjxVar = (zzjx) obj;
        for (zzjw zzjwVar : zzjv.STORAGE.f14286a) {
            if (this.f14288a.get(zzjwVar) != zzjxVar.f14288a.get(zzjwVar)) {
                return false;
            }
        }
        if (this.f14289b != zzjxVar.f14289b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Iterator it = this.f14288a.values().iterator();
        int i = this.f14289b * 17;
        while (it.hasNext()) {
            i = (i * 31) + ((zzju) it.next()).hashCode();
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(m3564d(this.f14289b));
        for (zzjw zzjwVar : zzjv.STORAGE.f14286a) {
            sb.append(",");
            sb.append(zzjwVar.zze);
            sb.append("=");
            zzju zzjuVar = (zzju) this.f14288a.get(zzjwVar);
            if (zzjuVar == null) {
                zzjuVar = zzju.UNINITIALIZED;
            }
            sb.append(zzjuVar);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.f14289b;
    }

    public final Bundle zzc() {
        String str;
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f14288a.entrySet()) {
            int ordinal = ((zzju) entry.getValue()).ordinal();
            if (ordinal != 2) {
                if (ordinal != 3) {
                    str = null;
                } else {
                    str = "granted";
                }
            } else {
                str = "denied";
            }
            if (str != null) {
                bundle.putString(((zzjw) entry.getKey()).zze, str);
            }
        }
        return bundle;
    }

    public final zzju zze() {
        zzju zzjuVar = (zzju) this.f14288a.get(zzjw.AD_STORAGE);
        if (zzjuVar == null) {
            return zzju.UNINITIALIZED;
        }
        return zzjuVar;
    }

    public final zzju zzf() {
        zzju zzjuVar = (zzju) this.f14288a.get(zzjw.ANALYTICS_STORAGE);
        if (zzjuVar == null) {
            return zzju.UNINITIALIZED;
        }
        return zzjuVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjx zzl(zzjx zzjxVar) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.STORAGE.f14286a) {
            zzju zzjuVar = (zzju) this.f14288a.get(zzjwVar);
            zzju zzjuVar2 = (zzju) zzjxVar.f14288a.get(zzjwVar);
            if (zzjuVar != null) {
                if (zzjuVar2 != null) {
                    zzju zzjuVar3 = zzju.UNINITIALIZED;
                    if (zzjuVar != zzjuVar3) {
                        if (zzjuVar2 != zzjuVar3) {
                            zzju zzjuVar4 = zzju.POLICY;
                            if (zzjuVar != zzjuVar4) {
                                if (zzjuVar2 != zzjuVar4) {
                                    zzju zzjuVar5 = zzju.DENIED;
                                    zzjuVar = (zzjuVar == zzjuVar5 || zzjuVar2 == zzjuVar5) ? zzjuVar5 : zzju.GRANTED;
                                }
                            }
                        }
                    }
                }
                if (zzjuVar == null) {
                    enumMap.put((EnumMap) zzjwVar, (zzjw) zzjuVar);
                }
            }
            zzjuVar = zzjuVar2;
            if (zzjuVar == null) {
            }
        }
        return new zzjx(enumMap, 100);
    }

    public final zzjx zzm(zzjx zzjxVar) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.STORAGE.f14286a) {
            zzju zzjuVar = (zzju) this.f14288a.get(zzjwVar);
            if (zzjuVar == zzju.UNINITIALIZED) {
                zzjuVar = (zzju) zzjxVar.f14288a.get(zzjwVar);
            }
            if (zzjuVar != null) {
                enumMap.put((EnumMap) zzjwVar, (zzjw) zzjuVar);
            }
        }
        return new zzjx(enumMap, this.f14289b);
    }

    public final String zzp() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjw zzjwVar : zzjv.STORAGE.zzb()) {
            zzju zzjuVar = (zzju) this.f14288a.get(zzjwVar);
            char c = '-';
            if (zzjuVar != null && (ordinal = zzjuVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                        }
                    } else {
                        c = '0';
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzq() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjw zzjwVar : zzjv.STORAGE.zzb()) {
            sb.append(m3561a((zzju) this.f14288a.get(zzjwVar)));
        }
        return sb.toString();
    }

    public final boolean zzr(zzjw zzjwVar) {
        if (((zzju) this.f14288a.get(zzjwVar)) == zzju.DENIED) {
            return false;
        }
        return true;
    }

    public final boolean zzt() {
        Iterator it = this.f14288a.values().iterator();
        while (it.hasNext()) {
            if (((zzju) it.next()) != zzju.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzu(zzjx zzjxVar) {
        EnumMap enumMap = this.f14288a;
        for (zzjw zzjwVar : (zzjw[]) enumMap.keySet().toArray(new zzjw[0])) {
            zzju zzjuVar = (zzju) enumMap.get(zzjwVar);
            zzju zzjuVar2 = (zzju) zzjxVar.f14288a.get(zzjwVar);
            zzju zzjuVar3 = zzju.DENIED;
            if (zzjuVar == zzjuVar3 && zzjuVar2 != zzjuVar3) {
                return true;
            }
        }
        return false;
    }

    public zzjx(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.f14288a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f14289b = i;
    }
}
