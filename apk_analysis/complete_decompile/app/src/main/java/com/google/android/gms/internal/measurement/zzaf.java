package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaf implements zzap {

    /* renamed from: a */
    public final boolean f13778a;

    public zzaf(Boolean bool) {
        boolean booleanValue;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.f13778a = booleanValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzaf) && this.f13778a == ((zzaf) obj).f13778a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f13778a).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.f13778a);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        boolean equals = "toString".equals(str);
        boolean z = this.f13778a;
        if (equals) {
            return new zzat(Boolean.toString(z));
        }
        throw new IllegalArgumentException(Boolean.toString(z) + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzaf(Boolean.valueOf(this.f13778a));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(this.f13778a);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        double d;
        if (true != this.f13778a) {
            d = 0.0d;
        } else {
            d = 1.0d;
        }
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return Boolean.toString(this.f13778a);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }
}
