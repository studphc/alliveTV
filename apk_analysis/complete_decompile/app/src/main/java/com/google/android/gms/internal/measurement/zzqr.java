package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzqr implements Supplier {

    /* renamed from: b */
    public static final zzqr f13936b = new zzqr();

    /* renamed from: a */
    public final Supplier f13937a = Suppliers.ofInstance(new zzqt());

    @SideEffectFree
    public static boolean zzb() {
        f13936b.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13936b.get().zzb();
    }

    @SideEffectFree
    public static boolean zzd() {
        return f13936b.get().zzc();
    }

    @SideEffectFree
    public static boolean zze() {
        return f13936b.get().zzd();
    }

    @SideEffectFree
    public static boolean zzf() {
        return f13936b.get().zze();
    }

    @SideEffectFree
    public static boolean zzg() {
        return f13936b.get().zzf();
    }

    @SideEffectFree
    public static boolean zzh() {
        return f13936b.get().zzg();
    }

    @SideEffectFree
    public static boolean zzi() {
        return f13936b.get().zzh();
    }

    @SideEffectFree
    public static boolean zzj() {
        return f13936b.get().zzi();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzqs get() {
        return (zzqs) this.f13937a.get();
    }
}
