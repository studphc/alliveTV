package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqc implements Supplier {

    /* renamed from: b */
    public static final zzqc f13926b = new zzqc();

    /* renamed from: a */
    public final Supplier f13927a = Suppliers.ofInstance(new zzqe());

    @SideEffectFree
    public static boolean zzb() {
        return f13926b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqd get() {
        return (zzqd) this.f13927a.get();
    }
}
