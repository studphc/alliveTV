package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzba {
    public static final zzba zza = new zzba((Boolean) null, 100, (Boolean) null, (String) null);

    /* renamed from: a */
    public final int f14135a;

    /* renamed from: b */
    public final String f14136b;

    /* renamed from: c */
    public final Boolean f14137c;

    /* renamed from: d */
    public final String f14138d;

    /* renamed from: e */
    public final EnumMap f14139e;

    public zzba(Boolean bool, int i, Boolean bool2, String str) {
        zzju zzjuVar;
        EnumMap enumMap = new EnumMap(zzjw.class);
        this.f14139e = enumMap;
        zzjw zzjwVar = zzjw.AD_USER_DATA;
        if (bool == null) {
            zzjuVar = zzju.UNINITIALIZED;
        } else if (bool.booleanValue()) {
            zzjuVar = zzju.GRANTED;
        } else {
            zzjuVar = zzju.DENIED;
        }
        enumMap.put((EnumMap) zzjwVar, (zzjw) zzjuVar);
        this.f14135a = i;
        this.f14136b = m3515a();
        this.f14137c = bool2;
        this.f14138d = str;
    }

    public static zzba zzc(Bundle bundle, int i) {
        Boolean bool = null;
        if (bundle == null) {
            return new zzba((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.DMA.zzb()) {
            enumMap.put((EnumMap) zzjwVar, (zzjw) zzjx.m3562b(bundle.getString(zzjwVar.zze)));
        }
        if (bundle.containsKey("is_dma_region")) {
            bool = Boolean.valueOf(bundle.getString("is_dma_region"));
        }
        return new zzba(enumMap, i, bool, bundle.getString("cps_display_str"));
    }

    public static zzba zze(String str) {
        if (str != null && str.length() > 0) {
            String[] split = str.split(":");
            int parseInt = Integer.parseInt(split[0]);
            EnumMap enumMap = new EnumMap(zzjw.class);
            zzjw[] zzb = zzjv.DMA.zzb();
            int length = zzb.length;
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                enumMap.put((EnumMap) zzb[i2], (zzjw) zzjx.m3563c(split[i].charAt(0)));
                i2++;
                i++;
            }
            return new zzba(enumMap, parseInt, (Boolean) null, (String) null);
        }
        return zza;
    }

    public static Boolean zzg(Bundle bundle) {
        zzju m3562b;
        if (bundle != null && (m3562b = zzjx.m3562b(bundle.getString("ad_personalization"))) != null) {
            int ordinal = m3562b.ordinal();
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return Boolean.TRUE;
                }
                return null;
            }
            return Boolean.FALSE;
        }
        return null;
    }

    /* renamed from: a */
    public final String m3515a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14135a);
        for (zzjw zzjwVar : zzjv.DMA.zzb()) {
            sb.append(":");
            sb.append(zzjx.m3561a((zzju) this.f14139e.get(zzjwVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (this.f14136b.equalsIgnoreCase(zzbaVar.f14136b) && Objects.equals(this.f14137c, zzbaVar.f14137c)) {
                return Objects.equals(this.f14138d, zzbaVar.f14138d);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode;
        Boolean bool = this.f14137c;
        if (bool == null) {
            i = 3;
        } else if (true != bool.booleanValue()) {
            i = 13;
        } else {
            i = 7;
        }
        String str = this.f14138d;
        if (str == null) {
            hashCode = 17;
        } else {
            hashCode = str.hashCode();
        }
        return (hashCode * 137) + this.f14136b.hashCode() + (i * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjx.m3564d(this.f14135a));
        for (zzjw zzjwVar : zzjv.DMA.zzb()) {
            sb.append(",");
            sb.append(zzjwVar.zze);
            sb.append("=");
            zzju zzjuVar = (zzju) this.f14139e.get(zzjwVar);
            if (zzjuVar == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = zzjuVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                sb.append("granted");
                            }
                        } else {
                            sb.append("denied");
                        }
                    } else {
                        sb.append("eu_consent_policy");
                    }
                } else {
                    sb.append("uninitialized");
                }
            }
        }
        Boolean bool = this.f14137c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f14138d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public final int zza() {
        return this.f14135a;
    }

    public final Bundle zzb() {
        String str;
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f14139e.entrySet()) {
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
        Boolean bool = this.f14137c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str2 = this.f14138d;
        if (str2 != null) {
            bundle.putString("cps_display_str", str2);
        }
        return bundle;
    }

    public final zzju zzf() {
        zzju zzjuVar = (zzju) this.f14139e.get(zzjw.AD_USER_DATA);
        if (zzjuVar == null) {
            return zzju.UNINITIALIZED;
        }
        return zzjuVar;
    }

    public final Boolean zzh() {
        return this.f14137c;
    }

    public final String zzi() {
        return this.f14138d;
    }

    public final String zzj() {
        return this.f14136b;
    }

    public final boolean zzk() {
        Iterator it = this.f14139e.values().iterator();
        while (it.hasNext()) {
            if (((zzju) it.next()) != zzju.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public zzba(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.f14139e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f14135a = i;
        this.f14136b = m3515a();
        this.f14137c = bool;
        this.f14138d = str;
    }
}
