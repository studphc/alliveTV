package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzpq implements Supplier {

    /* renamed from: b */
    public static final zzpq f13918b = new zzpq();

    /* renamed from: a */
    public final Supplier f13919a = Suppliers.ofInstance(new zzps());

    @SideEffectFree
    public static boolean zzb() {
        f13918b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13918b.get().zzb();
    }

    @SideEffectFree
    public static boolean zzd() {
        return f13918b.get().zzc();
    }

    @SideEffectFree
    public static boolean zze() {
        return f13918b.get().zzd();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpr get() {
        return (zzpr) this.f13919a.get();
    }
}
