package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzfj extends zzmd implements zzni {
    private static final zzfj zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzmj zzg = zzmd.zzcn();
    private boolean zzh;
    private zzfp zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzfj zzfjVar = new zzfj();
        zzb = zzfjVar;
        zzmd.zzct(zzfj.class, zzfjVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3297h(zzfj zzfjVar, String str) {
        zzfjVar.zzd |= 2;
        zzfjVar.zzf = str;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3298i(zzfj zzfjVar, int i, zzfl zzflVar) {
        zzflVar.getClass();
        zzmj zzmjVar = zzfjVar.zzg;
        if (!zzmjVar.zzc()) {
            zzfjVar.zzg = zzmd.zzco(zzmjVar);
        }
        zzfjVar.zzg.set(i, zzflVar);
    }

    public static zzfi zzc() {
        return (zzfi) zzb.zzcg();
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzfl zze(int i) {
        return (zzfl) this.zzg.get(i);
    }

    public final zzfp zzf() {
        zzfp zzfpVar = this.zzi;
        if (zzfpVar == null) {
            return zzfp.zzb();
        }
        return zzfpVar;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzg;
    }

    public final boolean zzk() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return zzb;
                        }
                        throw null;
                    }
                    return new zzlz(zzb);
                }
                return new zzfj();
            }
            return zzmd.zzcq(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", zzfl.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return this.zzl;
    }

    public final boolean zzo() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzp() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzq() {
        return (this.zzd & 64) != 0;
    }
}
