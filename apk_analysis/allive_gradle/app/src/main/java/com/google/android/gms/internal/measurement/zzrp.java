package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzrp implements Supplier {

    /* renamed from: b */
    public static final zzrp f13952b = new zzrp();

    /* renamed from: a */
    public final Supplier f13953a = Suppliers.ofInstance(new zzrr());

    @SideEffectFree
    public static boolean zzb() {
        f13952b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13952b.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzrq get() {
        return (zzrq) this.f13953a.get();
    }
}
