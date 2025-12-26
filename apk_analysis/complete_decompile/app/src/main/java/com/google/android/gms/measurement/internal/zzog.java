package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import p000.ed3;

/* loaded from: classes.dex */
public final class zzog {

    /* renamed from: a */
    public final Context f14346a;

    public zzog(Context context) {
        Preconditions.checkNotNull(context);
        this.f14346a = context;
    }

    public static /* synthetic */ void zzc(zzog zzogVar, JobParameters jobParameters) {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((zzof) zzogVar.f14346a).zzb(jobParameters, false);
    }

    public static /* synthetic */ void zzd(zzog zzogVar, zzhe zzheVar, JobParameters jobParameters) {
        zzheVar.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzof) zzogVar.f14346a).zzb(jobParameters, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void zze(zzog zzogVar, int i, zzhe zzheVar, Intent intent) {
        Context context = zzogVar.f14346a;
        zzof zzofVar = (zzof) context;
        if (zzofVar.zzc(i)) {
            zzheVar.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzio.zzp(context, null, null).zzaW().zzj().zza("Completed wakeful intent.");
            zzofVar.zza(intent);
        }
    }

    @MainThread
    public static final void zzi(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    @MainThread
    public static final boolean zzj(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    @MainThread
    public final int zza(final Intent intent, int i, final int i2) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.f14346a;
        zzio zzp = zzio.zzp(context, null, null);
        final zzhe zzaW = zzp.zzaW();
        String action = intent.getAction();
        zzp.zzaV();
        zzaW.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzoc
                @Override // java.lang.Runnable
                public final void run() {
                    zzog.zze(zzog.this, i2, zzaW, intent);
                }
            };
            zzpv zzz = zzpv.zzz(context);
            zzz.zzaX().zzq(new ed3(4, zzz, runnable, false));
        }
        return 2;
    }

    @MainThread
    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzjp(zzpv.zzz(this.f14346a), null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    @MainThread
    public final void zzf() {
        Log.v("FA", this.f14346a.getClass().getSimpleName().concat(" is starting up."));
    }

    @MainThread
    public final void zzg() {
        Log.v("FA", this.f14346a.getClass().getSimpleName().concat(" is shutting down."));
    }

    @TargetApi(24)
    @MainThread
    public final boolean zzh(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        boolean equals = Objects.equals(string, "com.google.android.gms.measurement.UPLOAD");
        Context context = this.f14346a;
        if (equals) {
            String str = (String) Preconditions.checkNotNull(string);
            zzpv zzz = zzpv.zzz(context);
            final zzhe zzaW = zzz.zzaW();
            zzz.zzaV();
            zzaW.zzj().zzb("Local AppMeasurementJobService called. action", str);
            zzz.zzaX().zzq(new ed3(4, zzz, new Runnable() { // from class: com.google.android.gms.measurement.internal.zzod
                @Override // java.lang.Runnable
                public final void run() {
                    zzog.zzd(zzog.this, zzaW, jobParameters);
                }
            }, false));
        }
        if (Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            com.google.android.gms.internal.measurement.zzff zzg = com.google.android.gms.internal.measurement.zzff.zzg(context, null, null, null, null);
            if (((Boolean) zzgi.zzaT.zza(null)).booleanValue()) {
                zzg.zzE(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzob
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzog.zzc(zzog.this, jobParameters);
                    }
                });
                return true;
            }
            return true;
        }
        return true;
    }
}
