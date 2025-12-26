package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: a */
    public final zzf f13796a;

    /* renamed from: b */
    public zzg f13797b;

    /* renamed from: c */
    public final zzab f13798c;

    /* renamed from: d */
    public final zzz f13799d;

    public zzc() {
        zzf zzfVar = new zzf();
        this.f13796a = zzfVar;
        this.f13797b = zzfVar.f13810b.zza();
        this.f13798c = new zzab();
        this.f13799d = new zzz();
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzc.zzb(zzc.this);
            }
        };
        zzj zzjVar = zzfVar.f13812d;
        zzjVar.zza("internal.registerCallback", callable);
        zzjVar.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzk(zzc.this.f13798c);
            }
        });
    }

    public static /* synthetic */ zzai zzb(zzc zzcVar) {
        return new zzv(zzcVar.f13799d);
    }

    public final zzab zza() {
        return this.f13798c;
    }

    public final void zzc(zziv zzivVar) {
        zzai zzaiVar;
        try {
            zzf zzfVar = this.f13796a;
            this.f13797b = zzfVar.f13810b.zza();
            if (!(zzfVar.zza(this.f13797b, (zziz[]) zzivVar.zzc().toArray(new zziz[0])) instanceof zzag)) {
                for (zzit zzitVar : zzivVar.zza().zzd()) {
                    List zzc = zzitVar.zzc();
                    String zzb = zzitVar.zzb();
                    Iterator it = zzc.iterator();
                    while (it.hasNext()) {
                        zzap zza = zzfVar.zza(this.f13797b, (zziz) it.next());
                        if (zza instanceof zzam) {
                            zzg zzgVar = this.f13797b;
                            if (!zzgVar.zzh(zzb)) {
                                zzaiVar = null;
                            } else {
                                zzap zzd = zzgVar.zzd(zzb);
                                if (zzd instanceof zzai) {
                                    zzaiVar = (zzai) zzd;
                                } else {
                                    throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zzb)));
                                }
                            }
                            if (zzaiVar != null) {
                                zzaiVar.zza(this.f13797b, Collections.singletonList(zza));
                            } else {
                                throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zzb)));
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid rule definition");
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void zzd(String str, Callable callable) {
        this.f13796a.f13812d.zza(str, callable);
    }

    public final boolean zze(zzaa zzaaVar) {
        try {
            zzab zzabVar = this.f13798c;
            zzabVar.zzd(zzaaVar);
            this.f13796a.f13811c.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.f13799d.zzb(this.f13797b.zza(), zzabVar);
            if (!zzg()) {
                if (!zzf()) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzf() {
        if (!this.f13798c.zzc().isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        zzab zzabVar = this.f13798c;
        if (!zzabVar.zzb().equals(zzabVar.zza())) {
            return true;
        }
        return false;
    }
}
