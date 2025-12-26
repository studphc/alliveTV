package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpe implements Supplier {

    /* renamed from: b */
    public static final zzpe f13910b = new zzpe();

    /* renamed from: a */
    public final Supplier f13911a = Suppliers.ofInstance(new zzpg());

    @SideEffectFree
    public static long zza() {
        return f13910b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzpf get() {
        return (zzpf) this.f13911a.get();
    }
}
