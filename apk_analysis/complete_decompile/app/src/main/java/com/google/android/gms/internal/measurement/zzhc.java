package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzhc extends zzmd implements zzni {
    private static final zzhc zzb;
    private int zzd;
    private long zzh;
    private long zzl;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzhc zzhcVar = new zzhc();
        zzb = zzhcVar;
        zzmd.zzct(zzhc.class, zzhcVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3305h(zzhc zzhcVar) {
        zzhcVar.zzd &= -5;
        zzhcVar.zzg = zzb.zzg;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3306i(zzhc zzhcVar) {
        zzhcVar.zzd &= -3;
        zzhcVar.zzf = zzb.zzf;
    }

    /* renamed from: j */
    public static /* synthetic */ void m3307j(zzhc zzhcVar) {
        zzhcVar.zzd &= -2;
        zzhcVar.zze = zzb.zze;
    }

    /* renamed from: k */
    public static /* synthetic */ void m3308k(zzhc zzhcVar) {
        zzhcVar.zzd &= -65;
        zzhcVar.zzk = zzb.zzk;
    }

    /* renamed from: l */
    public static /* synthetic */ void m3309l(zzhc zzhcVar) {
        zzhcVar.zzd &= -33;
        zzhcVar.zzj = zzb.zzj;
    }

    /* renamed from: m */
    public static /* synthetic */ void m3310m(zzhc zzhcVar) {
        zzhcVar.zzd &= -17;
        zzhcVar.zzi = zzb.zzi;
    }

    /* renamed from: n */
    public static /* synthetic */ void m3311n(zzhc zzhcVar, String str) {
        zzhcVar.zzd |= 4;
        zzhcVar.zzg = str;
    }

    /* renamed from: o */
    public static /* synthetic */ void m3312o(zzhc zzhcVar, String str) {
        zzhcVar.zzd |= 2;
        zzhcVar.zzf = str;
    }

    /* renamed from: p */
    public static /* synthetic */ void m3313p(zzhc zzhcVar, String str) {
        zzhcVar.zzd |= 1;
        zzhcVar.zze = str;
    }

    /* renamed from: q */
    public static /* synthetic */ void m3314q(zzhc zzhcVar, long j) {
        zzhcVar.zzd |= 8;
        zzhcVar.zzh = j;
    }

    /* renamed from: r */
    public static /* synthetic */ void m3315r(zzhc zzhcVar, long j) {
        zzhcVar.zzd |= 128;
        zzhcVar.zzl = j;
    }

    /* renamed from: s */
    public static /* synthetic */ void m3316s(zzhc zzhcVar, String str) {
        zzhcVar.zzd |= 64;
        zzhcVar.zzk = str;
    }

    /* renamed from: t */
    public static /* synthetic */ void m3317t(zzhc zzhcVar, String str) {
        zzhcVar.zzd |= 32;
        zzhcVar.zzj = str;
    }

    /* renamed from: u */
    public static /* synthetic */ void m3318u(zzhc zzhcVar, String str) {
        zzhcVar.zzd |= 16;
        zzhcVar.zzi = str;
    }

    public static zzhb zzc() {
        return (zzhb) zzb.zzcg();
    }

    public static zzhc zze() {
        return zzb;
    }

    public final boolean zzA() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzB() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzC() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzD() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzE() {
        return (this.zzd & 128) != 0;
    }

    public final boolean zzF() {
        return (this.zzd & 64) != 0;
    }

    public final boolean zzG() {
        return (this.zzd & 32) != 0;
    }

    public final boolean zzH() {
        return (this.zzd & 16) != 0;
    }

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzl;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zze;
    }

    public final String zzi() {
        return this.zzk;
    }

    public final String zzj() {
        return this.zzj;
    }

    public final String zzk() {
        return this.zzi;
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
                return new zzhc();
            }
            return zzmd.zzcq(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        return (byte) 1;
    }
}
