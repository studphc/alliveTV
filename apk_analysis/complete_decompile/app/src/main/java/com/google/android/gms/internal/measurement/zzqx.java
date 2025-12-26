package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqx implements Supplier {

    /* renamed from: b */
    public static final zzqx f13940b = new zzqx();

    /* renamed from: a */
    public final Supplier f13941a = Suppliers.ofInstance(new zzqz());

    @SideEffectFree
    public static boolean zzb() {
        return f13940b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqy get() {
        return (zzqy) this.f13941a.get();
    }
}
