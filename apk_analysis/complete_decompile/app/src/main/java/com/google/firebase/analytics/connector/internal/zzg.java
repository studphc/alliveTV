package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;
import p000.ib3;

/* loaded from: classes2.dex */
public final class zzg implements zza {

    /* renamed from: a */
    public final AnalyticsConnector.AnalyticsConnectorListener f15505a;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f15505a = analyticsConnectorListener;
        appMeasurementSdk.registerOnMeasurementEventListener(new ib3(this));
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.f15505a;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
    }
}
