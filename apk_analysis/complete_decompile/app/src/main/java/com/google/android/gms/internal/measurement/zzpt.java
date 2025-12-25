package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpt implements Supplier {

    /* renamed from: b */
    public static final zzpt f13920b = new zzpt();

    /* renamed from: a */
    public final Supplier f13921a = Suppliers.ofInstance(new zzpv());

    @SideEffectFree
    public static boolean zzb() {
        return f13920b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpu get() {
        return (zzpu) this.f13921a.get();
    }
}
