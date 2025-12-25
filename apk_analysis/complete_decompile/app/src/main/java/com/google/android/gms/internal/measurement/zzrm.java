package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzrm implements Supplier {

    /* renamed from: b */
    public static final zzrm f13950b = new zzrm();

    /* renamed from: a */
    public final Supplier f13951a = Suppliers.ofInstance(new zzro());

    @SideEffectFree
    public static boolean zzb() {
        return f13950b.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzrn get() {
        return (zzrn) this.f13951a.get();
    }
}
