package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzph implements Supplier {

    /* renamed from: b */
    public static final zzph f13912b = new zzph();

    /* renamed from: a */
    public final Supplier f13913a = Suppliers.ofInstance(new zzpj());

    @SideEffectFree
    public static boolean zzb() {
        return f13912b.get().zza();
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13912b.get().zzb();
    }

    @SideEffectFree
    public static boolean zzd() {
        return f13912b.get().zzc();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpi get() {
        return (zzpi) this.f13913a.get();
    }
}
