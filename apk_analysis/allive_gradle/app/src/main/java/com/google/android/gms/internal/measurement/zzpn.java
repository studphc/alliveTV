package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpn implements Supplier {

    /* renamed from: b */
    public static final zzpn f13916b = new zzpn();

    /* renamed from: a */
    public final Supplier f13917a = Suppliers.ofInstance(new zzpp());

    @SideEffectFree
    public static boolean zzb() {
        f13916b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13916b.get().zzb();
    }

    @SideEffectFree
    public static boolean zzd() {
        return f13916b.get().zzc();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpo get() {
        return (zzpo) this.f13917a.get();
    }
}
