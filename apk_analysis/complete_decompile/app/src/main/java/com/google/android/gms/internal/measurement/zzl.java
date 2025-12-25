package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzl extends zzam {

    /* renamed from: b */
    public final zzab f13875b;

    public zzl(zzab zzabVar) {
        this.f13875b = zzabVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzam, com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        char c;
        zzl zzlVar;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c = 0;
                    zzlVar = this;
                    break;
                }
                c = 65535;
                zzlVar = this;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    zzlVar = this;
                    c = 3;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    zzlVar = this;
                    c = 1;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    zzlVar = this;
                    c = 2;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c = 5;
                    zzlVar = this;
                    break;
                }
                c = 65535;
                zzlVar = this;
            case 1570616835:
                if (str.equals("setEventName")) {
                    zzlVar = this;
                    c = 4;
                    break;
                }
                c = 65535;
                zzlVar = this;
                break;
            default:
                c = 65535;
                zzlVar = this;
                break;
        }
        zzab zzabVar = zzlVar.f13875b;
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 5) {
                                return super.zzcz(str, zzgVar, list);
                            }
                            zzh.zzh("setParamValue", 2, list);
                            String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                            zzap zzb = zzgVar.zzb((zzap) list.get(1));
                            zzabVar.zzb().zzh(zzi, zzh.zzf(zzb));
                            return zzb;
                        }
                        zzh.zzh("setEventName", 1, list);
                        zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
                        if (!zzap.zzf.equals(zzb2) && !zzap.zzg.equals(zzb2)) {
                            zzabVar.zzb().zzg(zzb2.zzi());
                            return new zzat(zzb2.zzi());
                        }
                        throw new IllegalArgumentException("Illegal event name");
                    }
                    zzh.zzh("getTimestamp", 0, list);
                    return new zzah(Double.valueOf(zzabVar.zzb().zza()));
                }
                zzh.zzh("getParams", 0, list);
                Map zzf = zzabVar.zzb().zzf();
                zzam zzamVar = new zzam();
                for (String str2 : zzf.keySet()) {
                    zzamVar.zzr(str2, zzi.zzb(zzf.get(str2)));
                }
                return zzamVar;
            }
            zzh.zzh("getParamValue", 1, list);
            return zzi.zzb(zzabVar.zzb().zzc(zzgVar.zzb((zzap) list.get(0)).zzi()));
        }
        zzh.zzh("getEventName", 0, list);
        return new zzat(zzabVar.zzb().zze());
    }
}
