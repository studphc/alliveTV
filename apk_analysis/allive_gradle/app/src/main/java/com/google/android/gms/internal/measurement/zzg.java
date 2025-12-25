package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Iterator;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class zzg {

    /* renamed from: a */
    public final zzax f13821a;

    /* renamed from: b */
    public final HashMap f13822b = new HashMap();

    /* renamed from: c */
    public final HashMap f13823c = new HashMap();

    @VisibleForTesting
    public final zzg zza;

    public zzg(zzg zzgVar, zzax zzaxVar) {
        this.zza = zzgVar;
        this.f13821a = zzaxVar;
    }

    public final zzg zza() {
        return new zzg(this, this.f13821a);
    }

    public final zzap zzb(zzap zzapVar) {
        return this.f13821a.zza(this, zzapVar);
    }

    public final zzap zzc(zzae zzaeVar) {
        zzap zzapVar = zzap.zzf;
        Iterator zzk = zzaeVar.zzk();
        while (zzk.hasNext()) {
            zzapVar = this.f13821a.zza(this, zzaeVar.zze(((Integer) zzk.next()).intValue()));
            if (zzapVar instanceof zzag) {
                break;
            }
        }
        return zzapVar;
    }

    public final zzap zzd(String str) {
        HashMap hashMap = this.f13822b;
        if (hashMap.containsKey(str)) {
            return (zzap) hashMap.get(str);
        }
        zzg zzgVar = this.zza;
        if (zzgVar != null) {
            return zzgVar.zzd(str);
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7057m(str, " is not defined"));
    }

    public final void zze(String str, zzap zzapVar) {
        if (this.f13823c.containsKey(str)) {
            return;
        }
        HashMap hashMap = this.f13822b;
        if (zzapVar == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, zzapVar);
        }
    }

    public final void zzf(String str, zzap zzapVar) {
        zze(str, zzapVar);
        this.f13823c.put(str, Boolean.TRUE);
    }

    public final void zzg(String str, zzap zzapVar) {
        zzg zzgVar;
        HashMap hashMap = this.f13822b;
        if (!hashMap.containsKey(str) && (zzgVar = this.zza) != null && zzgVar.zzh(str)) {
            zzgVar.zzg(str, zzapVar);
        } else {
            if (this.f13823c.containsKey(str)) {
                return;
            }
            if (zzapVar == null) {
                hashMap.remove(str);
            } else {
                hashMap.put(str, zzapVar);
            }
        }
    }

    public final boolean zzh(String str) {
        if (this.f13822b.containsKey(str)) {
            return true;
        }
        zzg zzgVar = this.zza;
        if (zzgVar != null) {
            return zzgVar.zzh(str);
        }
        return false;
    }
}
