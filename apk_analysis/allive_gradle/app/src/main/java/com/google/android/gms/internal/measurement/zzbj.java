package com.google.android.gms.internal.measurement;

import java.util.List;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzbj extends zzaw {
    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        if (str != null && !str.isEmpty() && zzgVar.zzh(str)) {
            zzap zzd = zzgVar.zzd(str);
            if (zzd instanceof zzai) {
                return ((zzai) zzd).zza(zzgVar, list);
            }
            throw new IllegalArgumentException(ye0.m8296p("Function ", str, " is not defined"));
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Command not found: ", str));
    }
}
