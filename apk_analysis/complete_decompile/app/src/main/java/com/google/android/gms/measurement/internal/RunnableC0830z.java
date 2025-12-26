package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.measurement.internal.z */
/* loaded from: classes.dex */
public final class RunnableC0830z implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Bundle f14116a;

    /* renamed from: b */
    public final /* synthetic */ zzmh f14117b;

    /* renamed from: c */
    public final /* synthetic */ zzmh f14118c;

    /* renamed from: d */
    public final /* synthetic */ long f14119d;

    /* renamed from: e */
    public final /* synthetic */ zzmo f14120e;

    public RunnableC0830z(zzmo zzmoVar, Bundle bundle, zzmh zzmhVar, zzmh zzmhVar2, long j) {
        this.f14116a = bundle;
        this.f14117b = zzmhVar;
        this.f14118c = zzmhVar2;
        this.f14119d = j;
        this.f14120e = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = this.f14116a;
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzmo zzmoVar = this.f14120e;
        zzmoVar.m3578b(this.f14117b, this.f14118c, this.f14119d, true, zzmoVar.zzu.zzw().m3722a(FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }
}
