package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzrd implements Supplier {

    /* renamed from: b */
    public static final zzrd f13944b = new zzrd();

    /* renamed from: a */
    public final Supplier f13945a = Suppliers.ofInstance(new zzrf());

    @SideEffectFree
    public static boolean zzb() {
        f13944b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13944b.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzre get() {
        return (zzre) this.f13945a.get();
    }
}
