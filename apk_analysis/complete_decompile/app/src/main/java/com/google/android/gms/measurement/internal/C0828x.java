package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* renamed from: com.google.android.gms.measurement.internal.x */
/* loaded from: classes.dex */
public final class C0828x implements Application.ActivityLifecycleCallbacks, zzlt {

    /* renamed from: a */
    public final /* synthetic */ zzlw f14109a;

    public C0828x(zzlw zzlwVar) {
        this.f14109a = zzlwVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzdj.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdj.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[Catch: all -> 0x0024, RuntimeException -> 0x0027, TryCatch #0 {RuntimeException -> 0x0027, blocks: (B:3:0x0002, B:5:0x0015, B:7:0x001b, B:12:0x0045, B:15:0x004c, B:17:0x005d, B:19:0x0065, B:24:0x0075, B:28:0x0082, B:36:0x002a, B:38:0x0031, B:40:0x003d), top: B:2:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    @Override // com.google.android.gms.measurement.internal.zzlt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        zzio zzioVar;
        zzio zzioVar2;
        Intent intent;
        Uri uri;
        String stringExtra;
        String str;
        boolean z;
        zzlw zzlwVar = this.f14109a;
        try {
            try {
                zzioVar2 = zzlwVar.zzu;
                zzioVar2.zzaW().zzj().zza("onActivityCreated");
                intent = zzdjVar.zzc;
            } catch (RuntimeException e) {
                zzlwVar.zzu.zzaW().zze().zzb("Throwable caught in onActivityCreated", e);
            }
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (!data.isHierarchical()) {
                    }
                    uri = data;
                    if (uri != null && uri.isHierarchical()) {
                        zzioVar2.zzw();
                        stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) && !"https://www.google.com".equals(stringExtra) && !"android-app://com.google.appcrawler".equals(stringExtra)) {
                            str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                            String str2 = str;
                            String queryParameter = uri.getQueryParameter("referrer");
                            if (bundle != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zzioVar2.zzaX().zzq(new RunnableC0827w(this, z, uri, str2, queryParameter));
                            zzioVar = zzlwVar.zzu;
                            zzioVar.zzt().zzs(zzdjVar, bundle);
                        }
                        str = "gs";
                        String str22 = str;
                        String queryParameter2 = uri.getQueryParameter("referrer");
                        if (bundle != null) {
                        }
                        zzioVar2.zzaX().zzq(new RunnableC0827w(this, z, uri, str22, queryParameter2));
                        zzioVar = zzlwVar.zzu;
                        zzioVar.zzt().zzs(zzdjVar, bundle);
                    }
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data = Uri.parse(string);
                        uri = data;
                        if (uri != null) {
                            zzioVar2.zzw();
                            stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                            if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra)) {
                                str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                                String str222 = str;
                                String queryParameter22 = uri.getQueryParameter("referrer");
                                if (bundle != null) {
                                }
                                zzioVar2.zzaX().zzq(new RunnableC0827w(this, z, uri, str222, queryParameter22));
                                zzioVar = zzlwVar.zzu;
                                zzioVar.zzt().zzs(zzdjVar, bundle);
                            }
                            str = "gs";
                            String str2222 = str;
                            String queryParameter222 = uri.getQueryParameter("referrer");
                            if (bundle != null) {
                            }
                            zzioVar2.zzaX().zzq(new RunnableC0827w(this, z, uri, str2222, queryParameter222));
                            zzioVar = zzlwVar.zzu;
                            zzioVar.zzt().zzs(zzdjVar, bundle);
                        }
                    }
                }
                uri = null;
                if (uri != null) {
                }
            }
            zzioVar = zzlwVar.zzu;
            zzioVar.zzt().zzs(zzdjVar, bundle);
        } catch (Throwable th) {
            zzlwVar.zzu.zzt().zzs(zzdjVar, bundle);
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzb(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        this.f14109a.zzu.zzt().zzt(zzdjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzc(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        zzio zzioVar = this.f14109a.zzu;
        zzioVar.zzt().zzu(zzdjVar);
        zzop zzv = zzioVar.zzv();
        zzio zzioVar2 = zzv.zzu;
        zzioVar2.zzaX().zzq(new RunnableC0808k0(zzv, zzioVar2.zzaU().elapsedRealtime(), 1));
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzd(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        zzio zzioVar = this.f14109a.zzu;
        zzop zzv = zzioVar.zzv();
        zzio zzioVar2 = zzv.zzu;
        zzioVar2.zzaX().zzq(new RunnableC0808k0(zzv, zzioVar2.zzaU().elapsedRealtime(), 0));
        zzioVar.zzt().zzv(zzdjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zze(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        this.f14109a.zzu.zzt().zzw(zzdjVar, bundle);
    }
}
