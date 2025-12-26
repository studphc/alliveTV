package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class zzrj implements Supplier {

    /* renamed from: b */
    public static final zzrj f13948b = new zzrj();

    /* renamed from: a */
    public final Supplier f13949a = Suppliers.ofInstance(new zzrl());

    @SideEffectFree
    public static boolean zzb() {
        return f13948b.get().zza();
    }

    @SideEffectFree
    public static boolean zzc() {
        return f13948b.get().zzb();
    }

    @SideEffectFree
    public static boolean zzd() {
        return f13948b.get().zzc();
    }

    @SideEffectFree
    public static boolean zze() {
        return f13948b.get().zzd();
    }

    @SideEffectFree
    public static boolean zzf() {
        return f13948b.get().zze();
    }

    @SideEffectFree
    public static boolean zzg() {
        return f13948b.get().zzf();
    }

    @SideEffectFree
    public static boolean zzh() {
        return f13948b.get().zzg();
    }

    @SideEffectFree
    public static boolean zzi() {
        return f13948b.get().zzh();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzrk get() {
        return (zzrk) this.f13949a.get();
    }
}
