package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqi implements Supplier {

    /* renamed from: b */
    public static final zzqi f13930b = new zzqi();

    /* renamed from: a */
    public final Supplier f13931a = Suppliers.ofInstance(new zzqk());

    @SideEffectFree
    public static boolean zzb() {
        return f13930b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqj get() {
        return (zzqj) this.f13931a.get();
    }
}
