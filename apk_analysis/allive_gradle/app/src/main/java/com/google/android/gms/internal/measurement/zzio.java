package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzio extends zzmd implements zzni {
    private static final zzio zzb;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzio zzioVar = new zzio();
        zzb = zzioVar;
        zzmd.zzct(zzio.class, zzioVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3447h(zzio zzioVar) {
        zzioVar.zzd &= -33;
        zzioVar.zzj = 0.0d;
    }

    /* renamed from: i */
    public static /* synthetic */ void m3448i(zzio zzioVar) {
        zzioVar.zzd &= -9;
        zzioVar.zzh = 0L;
    }

    /* renamed from: j */
    public static /* synthetic */ void m3449j(zzio zzioVar) {
        zzioVar.zzd &= -5;
        zzioVar.zzg = zzb.zzg;
    }

    /* renamed from: k */
    public static /* synthetic */ void m3450k(zzio zzioVar, double d) {
        zzioVar.zzd |= 32;
        zzioVar.zzj = d;
    }

    /* renamed from: l */
    public static /* synthetic */ void m3451l(zzio zzioVar, long j) {
        zzioVar.zzd |= 8;
        zzioVar.zzh = j;
    }

    /* renamed from: m */
    public static /* synthetic */ void m3452m(zzio zzioVar, String str) {
        str.getClass();
        zzioVar.zzd |= 2;
        zzioVar.zzf = str;
    }

    /* renamed from: n */
    public static /* synthetic */ void m3453n(zzio zzioVar, long j) {
        zzioVar.zzd |= 1;
        zzioVar.zze = j;
    }

    /* renamed from: o */
    public static /* synthetic */ void m3454o(zzio zzioVar, String str) {
        str.getClass();
        zzioVar.zzd |= 4;
        zzioVar.zzg = str;
    }

    public static zzin zze() {
        return (zzin) zzb.zzcg();
    }

    public final double zza() {
        return this.zzj;
    }

    public final float zzb() {
        return this.zzi;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzg;
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
                return new zzio();
            }
            return zzmd.zzcq(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }

    public final boolean zzr() {
        return (this.zzd & 32) != 0;
    }

    public final boolean zzs() {
        return (this.zzd & 16) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzu() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzv() {
        return (this.zzd & 4) != 0;
    }
}
