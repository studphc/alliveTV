package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqf implements Supplier {

    /* renamed from: b */
    public static final zzqf f13928b = new zzqf();

    /* renamed from: a */
    public final Supplier f13929a = Suppliers.ofInstance(new zzqh());

    @SideEffectFree
    public static boolean zzb() {
        return f13928b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqg get() {
        return (zzqg) this.f13929a.get();
    }
}
