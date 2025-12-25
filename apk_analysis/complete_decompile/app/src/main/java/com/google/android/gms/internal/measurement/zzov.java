package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzov implements Supplier {

    /* renamed from: b */
    public static final zzov f13904b = new zzov();

    /* renamed from: a */
    public final Supplier f13905a = Suppliers.ofInstance(new zzox());

    @SideEffectFree
    public static boolean zzb() {
        return f13904b.get().zza();
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13904b.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzow get() {
        return (zzow) this.f13905a.get();
    }
}
