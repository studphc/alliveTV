package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqu implements Supplier {

    /* renamed from: b */
    public static final zzqu f13938b = new zzqu();

    /* renamed from: a */
    public final Supplier f13939a = Suppliers.ofInstance(new zzqw());

    @SideEffectFree
    public static boolean zzb() {
        return f13938b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqv get() {
        return (zzqv) this.f13939a.get();
    }
}
