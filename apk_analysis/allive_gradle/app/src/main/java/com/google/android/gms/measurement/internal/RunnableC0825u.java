package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* renamed from: com.google.android.gms.measurement.internal.u */
/* loaded from: classes.dex */
public final class RunnableC0825u implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14095a;

    /* renamed from: b */
    public final /* synthetic */ Bundle f14096b;

    /* renamed from: c */
    public final /* synthetic */ zzlw f14097c;

    public /* synthetic */ RunnableC0825u(zzlw zzlwVar, Bundle bundle, int i) {
        this.f14095a = i;
        this.f14096b = bundle;
        this.f14097c = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14095a) {
            case 0:
                zzlw zzlwVar = this.f14097c;
                zzlwVar.zzg();
                zzlwVar.zza();
                Bundle bundle = this.f14096b;
                Preconditions.checkNotNull(bundle);
                String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                String string2 = bundle.getString("origin");
                Preconditions.checkNotEmpty(string);
                Preconditions.checkNotEmpty(string2);
                Preconditions.checkNotNull(bundle.get("value"));
                if (!zzlwVar.zzu.zzJ()) {
                    zzlwVar.zzu.zzaW().zzj().zza("Conditional property not set since app measurement is disabled");
                    return;
                }
                zzqb zzqbVar = new zzqb(bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string, string2);
                try {
                    zzio zzioVar = zzlwVar.zzu;
                    zzqf zzw = zzioVar.zzw();
                    bundle.getString("app_id");
                    zzbh m3723b = zzw.m3723b(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0L, true);
                    zzqf zzw2 = zzioVar.zzw();
                    bundle.getString("app_id");
                    zzbh m3723b2 = zzw2.m3723b(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0L, true);
                    zzqf zzw3 = zzioVar.zzw();
                    bundle.getString("app_id");
                    zzlwVar.zzu.zzu().zzQ(new zzai(bundle.getString("app_id"), string2, zzqbVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), m3723b2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), m3723b, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzw3.m3723b(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0L, true)));
                    return;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            default:
                zzlw zzlwVar2 = this.f14097c;
                zzlwVar2.zzg();
                zzlwVar2.zza();
                Bundle bundle2 = this.f14096b;
                Preconditions.checkNotNull(bundle2);
                String checkNotEmpty = Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
                if (!zzlwVar2.zzu.zzJ()) {
                    zzlwVar2.zzu.zzaW().zzj().zza("Conditional property not cleared since app measurement is disabled");
                    return;
                }
                zzqb zzqbVar2 = new zzqb(0L, null, checkNotEmpty, "");
                try {
                    zzqf zzw4 = zzlwVar2.zzu.zzw();
                    bundle2.getString("app_id");
                    zzlwVar2.zzu.zzu().zzQ(new zzai(bundle2.getString("app_id"), "", zzqbVar2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzw4.m3723b(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true)));
                    return;
                } catch (IllegalArgumentException unused2) {
                    return;
                }
        }
    }
}
