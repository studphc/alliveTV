package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpw implements Supplier {

    /* renamed from: b */
    public static final zzpw f13922b = new zzpw();

    /* renamed from: a */
    public final Supplier f13923a = Suppliers.ofInstance(new zzpy());

    @SideEffectFree
    public static boolean zzb() {
        return f13922b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpx get() {
        return (zzpx) this.f13923a.get();
    }
}
