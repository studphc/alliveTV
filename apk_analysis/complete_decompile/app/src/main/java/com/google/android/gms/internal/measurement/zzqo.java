package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqo implements Supplier {

    /* renamed from: b */
    public static final zzqo f13934b = new zzqo();

    /* renamed from: a */
    public final Supplier f13935a = Suppliers.ofInstance(new zzqq());

    @SideEffectFree
    public static double zza() {
        return f13934b.get().zza();
    }

    @SideEffectFree
    public static long zzb() {
        return f13934b.get().zzb();
    }

    @SideEffectFree
    public static long zzc() {
        return f13934b.get().zzc();
    }

    @SideEffectFree
    public static long zzd() {
        return f13934b.get().zzd();
    }

    @SideEffectFree
    public static String zzf() {
        return f13934b.get().zze();
    }

    @SideEffectFree
    public static boolean zzg() {
        return f13934b.get().zzf();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzqp get() {
        return (zzqp) this.f13935a.get();
    }
}
