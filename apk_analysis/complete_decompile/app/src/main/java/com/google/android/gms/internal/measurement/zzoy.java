package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzoy implements Supplier {

    /* renamed from: b */
    public static final zzoy f13906b = new zzoy();

    /* renamed from: a */
    public final Supplier f13907a = Suppliers.ofInstance(new zzpa());

    @SideEffectFree
    public static boolean zzb() {
        f13906b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13906b.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzoz get() {
        return (zzoz) this.f13907a.get();
    }
}
