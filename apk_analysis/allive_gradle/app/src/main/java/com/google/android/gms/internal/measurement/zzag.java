package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzag implements zzap {

    /* renamed from: a */
    public final zzap f13779a;

    /* renamed from: b */
    public final String f13780b;

    public zzag() {
        this.f13779a = zzap.zzf;
        this.f13780b = "return";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        if (this.f13780b.equals(zzagVar.f13780b) && this.f13779a.equals(zzagVar.f13779a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f13779a.hashCode() + (this.f13780b.hashCode() * 31);
    }

    public final zzap zzb() {
        return this.f13779a;
    }

    public final String zzc() {
        return this.f13780b;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzag(this.f13780b, this.f13779a.zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }

    public zzag(String str) {
        this.f13779a = zzap.zzf;
        this.f13780b = str;
    }

    public zzag(String str, zzap zzapVar) {
        this.f13779a = zzapVar;
        this.f13780b = str;
    }
}
