package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzrg implements Supplier {

    /* renamed from: b */
    public static final zzrg f13946b = new zzrg();

    /* renamed from: a */
    public final Supplier f13947a = Suppliers.ofInstance(new zzri());

    @SideEffectFree
    public static boolean zzb() {
        return f13946b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzrh get() {
        return (zzrh) this.f13947a.get();
    }
}
