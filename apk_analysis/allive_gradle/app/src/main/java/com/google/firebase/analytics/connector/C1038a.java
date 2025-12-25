package com.google.firebase.analytics.connector;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.firebase.analytics.connector.a */
/* loaded from: classes2.dex */
public final class C1038a implements AnalyticsConnector.AnalyticsConnectorHandle {

    /* renamed from: a */
    public final /* synthetic */ String f15495a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsConnectorImpl f15496b;

    public C1038a(AnalyticsConnectorImpl analyticsConnectorImpl, String str) {
        this.f15495a = str;
        this.f15496b = analyticsConnectorImpl;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
    public final void registerEventNames(Set set) {
        AnalyticsConnectorImpl analyticsConnectorImpl = this.f15496b;
        String str = this.f15495a;
        if (analyticsConnectorImpl.m4369a(str) && str.equals(AppMeasurement.FIAM_ORIGIN) && set != null && !set.isEmpty()) {
            ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.f15494b.get(str)).zzb(set);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
    public final void unregister() {
        AnalyticsConnectorImpl analyticsConnectorImpl = this.f15496b;
        String str = this.f15495a;
        if (!analyticsConnectorImpl.m4369a(str)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = analyticsConnectorImpl.f15494b;
        AnalyticsConnector.AnalyticsConnectorListener zza = ((com.google.firebase.analytics.connector.internal.zza) concurrentHashMap.get(str)).zza();
        if (zza != null) {
            zza.onMessageTriggered(0, null);
        }
        concurrentHashMap.remove(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
    public final void unregisterEventNames() {
        AnalyticsConnectorImpl analyticsConnectorImpl = this.f15496b;
        String str = this.f15495a;
        if (analyticsConnectorImpl.m4369a(str) && str.equals(AppMeasurement.FIAM_ORIGIN)) {
            ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.f15494b.get(str)).zzc();
        }
    }
}
