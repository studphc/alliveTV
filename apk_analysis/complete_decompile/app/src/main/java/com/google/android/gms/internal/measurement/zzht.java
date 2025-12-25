package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzht extends zzlz implements zzni {
    public final int zza() {
        return ((zzhv) this.zza).zza();
    }

    public final zzht zzb(Iterable iterable) {
        zzbe();
        zzhv.m3353h((zzhv) this.zza, iterable);
        return this;
    }

    public final zzht zzc(zzhw zzhwVar) {
        zzbe();
        zzhv.m3354i((zzhv) this.zza, (zzhx) zzhwVar.zzba());
        return this;
    }

    public final zzht zzd() {
        zzbe();
        ((zzhv) this.zza).zze = zzmd.zzcn();
        return this;
    }

    public final zzht zze(int i, zzhw zzhwVar) {
        zzbe();
        zzhv.m3356k((zzhv) this.zza, i, (zzhx) zzhwVar.zzba());
        return this;
    }

    public final zzht zzf(String str) {
        zzbe();
        zzhv.m3357l((zzhv) this.zza, str);
        return this;
    }

    public final zzht zzg(String str) {
        zzbe();
        zzhv.m3358m((zzhv) this.zza, str);
        return this;
    }

    public final zzhx zzh(int i) {
        return ((zzhv) this.zza).zze(i);
    }

    public final String zzi() {
        return ((zzhv) this.zza).zzf();
    }

    public final List zzj() {
        return Collections.unmodifiableList(((zzhv) this.zza).zzh());
    }
}
