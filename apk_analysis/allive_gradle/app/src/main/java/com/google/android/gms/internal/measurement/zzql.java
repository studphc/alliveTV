package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzql implements Supplier {

    /* renamed from: b */
    public static final zzql f13932b = new zzql();

    /* renamed from: a */
    public final Supplier f13933a = Suppliers.ofInstance(new zzqn());

    @SideEffectFree
    public static boolean zzb() {
        return f13932b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqm get() {
        return (zzqm) this.f13933a.get();
    }
}
