package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzra implements Supplier {

    /* renamed from: b */
    public static final zzra f13942b = new zzra();

    /* renamed from: a */
    public final Supplier f13943a = Suppliers.ofInstance(new zzrc());

    @SideEffectFree
    public static boolean zzb() {
        f13942b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13942b.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzrb get() {
        return (zzrb) this.f13943a.get();
    }
}
