package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzrs implements Supplier {

    /* renamed from: b */
    public static final zzrs f13954b = new zzrs();

    /* renamed from: a */
    public final Supplier f13955a = Suppliers.ofInstance(new zzru());

    @SideEffectFree
    public static boolean zzb() {
        return f13954b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzrt get() {
        return (zzrt) this.f13955a.get();
    }
}
