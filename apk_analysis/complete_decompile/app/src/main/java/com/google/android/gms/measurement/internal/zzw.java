package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzqr;
import java.util.Objects;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class zzw extends BroadcastReceiver {

    /* renamed from: a */
    public final zzio f14412a;

    public zzw(zzio zzioVar) {
        this.f14412a = zzioVar;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        char c;
        final zzio zzioVar = this.f14412a;
        if (intent == null) {
            AbstractC1726qj.m7037B(zzioVar, "App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            AbstractC1726qj.m7037B(zzioVar, "App receiver called with null action");
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode != -1928239649) {
            if (hashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                AbstractC1726qj.m7037B(zzioVar, "App receiver called with unknown action");
                return;
            } else {
                if (zzioVar.zzf().zzx(null, zzgi.zzaR)) {
                    zzioVar.zzaW().zzj().zza("[sgtm] App Receiver notified batches are available");
                    zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzw.this.f14412a.zzs().zzj(((Long) zzgi.zzC.zza(null)).longValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        zzqr.zzb();
        if (!zzioVar.zzf().zzx(null, zzgi.zzaW)) {
            return;
        }
        zzioVar.zzaW().zzj().zza("App receiver notified triggers are available");
        zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzu
            @Override // java.lang.Runnable
            public final void run() {
                zzio zzioVar2 = zzio.this;
                zzqf zzw = zzioVar2.zzw();
                zzw.zzg();
                if (zzw.m3719Q() == 1) {
                    zzlw zzq = zzioVar2.zzq();
                    zzq.zzg();
                    C0813n c0813n = zzq.f14308j;
                    if (c0813n != null) {
                        c0813n.m8015a();
                    }
                    final zzlw zzq2 = zzioVar2.zzq();
                    Objects.requireNonNull(zzq2);
                    new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzlw.this.m3566b();
                        }
                    }).start();
                    return;
                }
                AbstractC1726qj.m7037B(zzioVar2, "registerTrigger called but app not eligible");
            }
        });
    }
}
