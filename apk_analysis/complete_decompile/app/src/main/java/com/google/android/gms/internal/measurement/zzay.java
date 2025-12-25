package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzay extends zzaw {
    public zzay() {
        this.f13786a.add(zzbl.EQUALS);
        this.f13786a.add(zzbl.GREATER_THAN);
        this.f13786a.add(zzbl.GREATER_THAN_EQUALS);
        this.f13786a.add(zzbl.IDENTITY_EQUALS);
        this.f13786a.add(zzbl.IDENTITY_NOT_EQUALS);
        this.f13786a.add(zzbl.LESS_THAN);
        this.f13786a.add(zzbl.LESS_THAN_EQUALS);
        this.f13786a.add(zzbl.NOT_EQUALS);
    }

    /* renamed from: b */
    public static boolean m3285b(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar.getClass().equals(zzapVar2.getClass())) {
            if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
                return true;
            }
            if (zzapVar instanceof zzah) {
                if (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue()) || zzapVar.zzh().doubleValue() != zzapVar2.zzh().doubleValue()) {
                    return false;
                }
                return true;
            }
            if (zzapVar instanceof zzat) {
                return zzapVar.zzi().equals(zzapVar2.zzi());
            }
            if (zzapVar instanceof zzaf) {
                return zzapVar.zzg().equals(zzapVar2.zzg());
            }
            if (zzapVar != zzapVar2) {
                return false;
            }
            return true;
        }
        if (((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) && ((zzapVar2 instanceof zzau) || (zzapVar2 instanceof zzan))) {
            return true;
        }
        boolean z = zzapVar instanceof zzah;
        if (z && (zzapVar2 instanceof zzat)) {
            return m3285b(zzapVar, new zzah(zzapVar2.zzh()));
        }
        boolean z2 = zzapVar instanceof zzat;
        if (z2 && (zzapVar2 instanceof zzah)) {
            return m3285b(new zzah(zzapVar.zzh()), zzapVar2);
        }
        if (zzapVar instanceof zzaf) {
            return m3285b(new zzah(zzapVar.zzh()), zzapVar2);
        }
        if (zzapVar2 instanceof zzaf) {
            return m3285b(zzapVar, new zzah(zzapVar2.zzh()));
        }
        if ((!z2 && !z) || !(zzapVar2 instanceof zzal)) {
            if (!(zzapVar instanceof zzal) || (!(zzapVar2 instanceof zzat) && !(zzapVar2 instanceof zzah))) {
                return false;
            }
            return m3285b(new zzat(zzapVar.zzi()), zzapVar2);
        }
        return m3285b(zzapVar, new zzat(zzapVar2.zzi()));
    }

    /* renamed from: c */
    public static boolean m3286c(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzi());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzi());
        }
        if ((zzapVar instanceof zzat) && (zzapVar2 instanceof zzat)) {
            if (zzapVar.zzi().compareTo(zzapVar2.zzi()) < 0) {
                return true;
            }
            return false;
        }
        double doubleValue = zzapVar.zzh().doubleValue();
        double doubleValue2 = zzapVar2.zzh().doubleValue();
        if (!Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && ((doubleValue != 0.0d || doubleValue2 != 0.0d) && ((doubleValue != 0.0d || doubleValue2 != 0.0d) && Double.compare(doubleValue, doubleValue2) < 0))) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m3287d(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzi());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzi());
        }
        if (((!(zzapVar instanceof zzat) || !(zzapVar2 instanceof zzat)) && (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue()))) || m3286c(zzapVar2, zzapVar)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        boolean m3285b;
        boolean m3285b2;
        zzh.zzh(zzh.zze(str).name(), 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal != 48) {
                if (ordinal != 42) {
                    if (ordinal != 43) {
                        switch (ordinal) {
                            case 37:
                                m3285b = m3286c(zzb2, zzb);
                                break;
                            case 38:
                                m3285b = m3287d(zzb2, zzb);
                                break;
                            case 39:
                                m3285b = zzh.zzl(zzb, zzb2);
                                break;
                            case 40:
                                m3285b2 = zzh.zzl(zzb, zzb2);
                                break;
                            default:
                                m3283a(str);
                                throw null;
                        }
                    } else {
                        m3285b = m3287d(zzb, zzb2);
                    }
                } else {
                    m3285b = m3286c(zzb, zzb2);
                }
            } else {
                m3285b2 = m3285b(zzb, zzb2);
            }
            m3285b = !m3285b2;
        } else {
            m3285b = m3285b(zzb, zzb2);
        }
        if (m3285b) {
            return zzap.zzk;
        }
        return zzap.zzl;
    }
}
