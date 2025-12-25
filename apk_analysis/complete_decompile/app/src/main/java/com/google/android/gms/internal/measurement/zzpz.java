package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpz implements Supplier {

    /* renamed from: b */
    public static final zzpz f13924b = new zzpz();

    /* renamed from: a */
    public final Supplier f13925a = Suppliers.ofInstance(new zzqb());

    @SideEffectFree
    public static boolean zzb() {
        return f13924b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqa get() {
        return (zzqa) this.f13925a.get();
    }
}
