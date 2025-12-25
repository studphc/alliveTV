package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzos implements Supplier {

    /* renamed from: b */
    public static final zzos f13902b = new zzos();

    /* renamed from: a */
    public final Supplier f13903a = Suppliers.ofInstance(new zzou());

    @SideEffectFree
    public static boolean zzb() {
        return f13902b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzot get() {
        return (zzot) this.f13903a.get();
    }
}
