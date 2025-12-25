package com.google.android.gms.measurement.internal;

import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.g */
/* loaded from: classes.dex */
public final class C0799g implements com.google.android.gms.internal.measurement.zzr {

    /* renamed from: a */
    public final /* synthetic */ zzif f14024a;

    public C0799g(zzif zzifVar) {
        this.f14024a = zzifVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzhc zzd;
        int i2 = i - 1;
        zzif zzifVar = this.f14024a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        zzd = zzifVar.zzu.zzaW().zzi();
                    } else if (z) {
                        zzd = zzifVar.zzu.zzaW().zzm();
                    } else if (!z2) {
                        zzd = zzifVar.zzu.zzaW().zzl();
                    } else {
                        zzd = zzifVar.zzu.zzaW().zzk();
                    }
                } else {
                    zzd = zzifVar.zzu.zzaW().zzj();
                }
            } else if (z) {
                zzd = zzifVar.zzu.zzaW().zzh();
            } else if (!z2) {
                zzd = zzifVar.zzu.zzaW().zzf();
            } else {
                zzd = zzifVar.zzu.zzaW().zze();
            }
        } else {
            zzd = zzifVar.zzu.zzaW().zzd();
        }
        int size = list.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    zzd.zza(str);
                    return;
                } else {
                    zzd.zzd(str, list.get(0), list.get(1), list.get(2));
                    return;
                }
            }
            zzd.zzc(str, list.get(0), list.get(1));
            return;
        }
        zzd.zzb(str, list.get(0));
    }
}
