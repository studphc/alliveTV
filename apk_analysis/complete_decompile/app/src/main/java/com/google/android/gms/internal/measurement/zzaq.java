package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaq implements zzap {

    /* renamed from: a */
    public final String f13783a;

    /* renamed from: b */
    public final ArrayList f13784b;

    public zzaq(String str, List list) {
        this.f13783a = str;
        ArrayList arrayList = new ArrayList();
        this.f13784b = arrayList;
        arrayList.addAll(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaq)) {
            return false;
        }
        zzaq zzaqVar = (zzaq) obj;
        String str = this.f13783a;
        if (str == null ? zzaqVar.f13783a != null : !str.equals(zzaqVar.f13783a)) {
            return false;
        }
        return this.f13784b.equals(zzaqVar.f13784b);
    }

    public final int hashCode() {
        int i;
        String str = this.f13783a;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return this.f13784b.hashCode() + (i * 31);
    }

    public final String zzb() {
        return this.f13783a;
    }

    public final ArrayList zzc() {
        return this.f13784b;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }
}
