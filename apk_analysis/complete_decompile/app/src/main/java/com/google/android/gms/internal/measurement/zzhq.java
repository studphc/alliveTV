package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzhq extends zzmd implements zzni {
    private static final zzhq zzb;
    private int zzd;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private zzmj zzj = zzmd.zzcn();

    static {
        zzhq zzhqVar = new zzhq();
        zzb = zzhqVar;
        zzmd.zzct(zzhq.class, zzhqVar);
    }

    /* renamed from: h */
    public static void m3343h(zzhq zzhqVar, Iterable iterable) {
        zzmj zzmjVar = zzhqVar.zzj;
        if (!zzmjVar.zzc()) {
            zzhqVar.zzj = zzmd.zzco(zzmjVar);
        }
        zzko.zzcc(iterable, zzhqVar.zzj);
    }

    /* renamed from: i */
    public static void m3344i(zzhq zzhqVar, zzhq zzhqVar2) {
        zzhqVar2.getClass();
        zzmj zzmjVar = zzhqVar.zzj;
        if (!zzmjVar.zzc()) {
            zzhqVar.zzj = zzmd.zzco(zzmjVar);
        }
        zzhqVar.zzj.add(zzhqVar2);
    }

    /* renamed from: j */
    public static /* synthetic */ void m3345j(zzhq zzhqVar) {
        zzhqVar.zzd &= -17;
        zzhqVar.zzi = 0.0d;
    }

    /* renamed from: k */
    public static /* synthetic */ void m3346k(zzhq zzhqVar) {
        zzhqVar.zzd &= -5;
        zzhqVar.zzg = 0L;
    }

    /* renamed from: m */
    public static /* synthetic */ void m3348m(zzhq zzhqVar) {
        zzhqVar.zzd &= -3;
        zzhqVar.zzf = zzb.zzf;
    }

    /* renamed from: n */
    public static /* synthetic */ void m3349n(zzhq zzhqVar, double d) {
        zzhqVar.zzd |= 16;
        zzhqVar.zzi = d;
    }

    /* renamed from: o */
    public static /* synthetic */ void m3350o(zzhq zzhqVar, long j) {
        zzhqVar.zzd |= 4;
        zzhqVar.zzg = j;
    }

    /* renamed from: p */
    public static /* synthetic */ void m3351p(zzhq zzhqVar, String str) {
        str.getClass();
        zzhqVar.zzd |= 1;
        zzhqVar.zze = str;
    }

    /* renamed from: q */
    public static /* synthetic */ void m3352q(zzhq zzhqVar, String str) {
        str.getClass();
        zzhqVar.zzd |= 2;
        zzhqVar.zzf = str;
    }

    public static zzhp zze() {
        return (zzhp) zzb.zzcg();
    }

    public final double zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzj.size();
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
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
                return new zzhq();
            }
            return zzmd.zzcq(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzhq.class});
        }
        return (byte) 1;
    }

    public final boolean zzu() {
        return (this.zzd & 16) != 0;
    }

    public final boolean zzv() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzw() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzx() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzy() {
        return (this.zzd & 2) != 0;
    }
}
