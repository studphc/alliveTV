package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzhl extends zzlz implements zzni {
    public final int zza() {
        return ((zzhm) this.zza).zzb();
    }

    public final long zzb() {
        return ((zzhm) this.zza).zzc();
    }

    public final long zzc() {
        return ((zzhm) this.zza).zzd();
    }

    public final zzhl zzd(Iterable iterable) {
        zzbe();
        zzhm.m3332h((zzhm) this.zza, iterable);
        return this;
    }

    public final zzhl zze(zzhp zzhpVar) {
        zzbe();
        zzhm.m3333i((zzhm) this.zza, (zzhq) zzhpVar.zzba());
        return this;
    }

    public final zzhl zzf(zzhq zzhqVar) {
        zzbe();
        zzhm.m3333i((zzhm) this.zza, zzhqVar);
        return this;
    }

    public final zzhl zzg() {
        zzbe();
        ((zzhm) this.zza).zze = zzmd.zzcn();
        return this;
    }

    public final zzhl zzh(int i) {
        zzbe();
        zzhm.m3335k(i, (zzhm) this.zza);
        return this;
    }

    public final zzhl zzi(String str) {
        zzbe();
        zzhm.m3336l((zzhm) this.zza, str);
        return this;
    }

    public final zzhl zzj(int i, zzhp zzhpVar) {
        zzbe();
        zzhm.m3337m((zzhm) this.zza, i, (zzhq) zzhpVar.zzba());
        return this;
    }

    public final zzhl zzk(int i, zzhq zzhqVar) {
        zzbe();
        zzhm.m3337m((zzhm) this.zza, i, zzhqVar);
        return this;
    }

    public final zzhl zzl(long j) {
        zzbe();
        zzhm.m3338n(j, (zzhm) this.zza);
        return this;
    }

    public final zzhl zzm(long j) {
        zzbe();
        zzhm.m3339o(j, (zzhm) this.zza);
        return this;
    }

    public final zzhq zzn(int i) {
        return ((zzhm) this.zza).zzg(i);
    }

    public final String zzo() {
        return ((zzhm) this.zza).zzh();
    }

    public final List zzp() {
        return Collections.unmodifiableList(((zzhm) this.zza).zzi());
    }

    public final boolean zzq() {
        return ((zzhm) this.zza).zzu();
    }
}
