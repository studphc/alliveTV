package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpk implements Supplier {

    /* renamed from: b */
    public static final zzpk f13914b = new zzpk();

    /* renamed from: a */
    public final Supplier f13915a = Suppliers.ofInstance(new zzpm());

    @SideEffectFree
    public static boolean zzb() {
        return f13914b.get().zza();
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13914b.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpl get() {
        return (zzpl) this.f13915a.get();
    }
}
