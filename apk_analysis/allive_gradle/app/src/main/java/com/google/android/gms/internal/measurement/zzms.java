package com.google.android.gms.internal.measurement;

import p000.uc3;

/* loaded from: classes.dex */
public class zzms {

    /* renamed from: a */
    public volatile zzld f13890a;
    protected volatile zznh zza;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzms)) {
            return false;
        }
        zzms zzmsVar = (zzms) obj;
        zznh zznhVar = this.zza;
        zznh zznhVar2 = zzmsVar.zza;
        if (zznhVar == null && zznhVar2 == null) {
            return zzb().equals(zzmsVar.zzb());
        }
        if (zznhVar != null && zznhVar2 != null) {
            return zznhVar.equals(zznhVar2);
        }
        if (zznhVar != null) {
            zzmsVar.zzd(zznhVar.zzcC());
            return zznhVar.equals(zzmsVar.zza);
        }
        zzd(zznhVar2.zzcC());
        return this.zza.equals(zznhVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.f13890a != null) {
            return ((uc3) this.f13890a).f27225b.length;
        }
        if (this.zza != null) {
            return this.zza.zzcf();
        }
        return 0;
    }

    public final zzld zzb() {
        if (this.f13890a != null) {
            return this.f13890a;
        }
        synchronized (this) {
            try {
                if (this.f13890a != null) {
                    return this.f13890a;
                }
                if (this.zza == null) {
                    this.f13890a = zzld.zzb;
                } else {
                    this.f13890a = this.zza.zzcb();
                }
                return this.f13890a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zznh zzc(zznh zznhVar) {
        zznh zznhVar2 = this.zza;
        this.f13890a = null;
        this.zza = zznhVar;
        return zznhVar2;
    }

    public final void zzd(zznh zznhVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zznhVar;
                this.f13890a = zzld.zzb;
            } catch (zzmm unused) {
                this.zza = zznhVar;
                this.f13890a = zzld.zzb;
            }
        }
    }
}
