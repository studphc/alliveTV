package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzmg;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {

    /* renamed from: c */
    public static volatile AnalyticsConnectorImpl f15492c;

    /* renamed from: a */
    public final AppMeasurementSdk f15493a;

    /* renamed from: b */
    public final ConcurrentHashMap f15494b;

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f15493a = appMeasurementSdk;
        this.f15494b = new ConcurrentHashMap();
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* renamed from: a */
    public final boolean m4369a(String str) {
        if (!str.isEmpty()) {
            ConcurrentHashMap concurrentHashMap = this.f15494b;
            if (concurrentHashMap.containsKey(str) && concurrentHashMap.get(str) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (str2 != null && !zzc.zzb(str2, bundle)) {
            return;
        }
        this.f15493a.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    @KeepForSdk
    @WorkerThread
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @NonNull @Size(max = 23, min = 1) String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.f15493a.getConditionalUserProperties(str, str2)) {
            ImmutableSet immutableSet = zzc.f15497a;
            Preconditions.checkNotNull(bundle);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            conditionalUserProperty.origin = (String) Preconditions.checkNotNull((String) zzjt.zza(bundle, "origin", String.class, null));
            conditionalUserProperty.name = (String) Preconditions.checkNotNull((String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null));
            conditionalUserProperty.value = zzjt.zza(bundle, "value", Object.class, null);
            conditionalUserProperty.triggerEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            conditionalUserProperty.triggerTimeout = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            conditionalUserProperty.timedOutEventParams = (Bundle) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            conditionalUserProperty.triggeredEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            conditionalUserProperty.triggeredEventParams = (Bundle) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            conditionalUserProperty.timeToLive = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            conditionalUserProperty.expiredEventParams = (Bundle) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            conditionalUserProperty.active = ((Boolean) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        return this.f15493a.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    @KeepForSdk
    @WorkerThread
    public Map<String, Object> getUserProperties(boolean z) {
        return this.f15493a.getUserProperties(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzd(str) && zzc.zzb(str2, bundle) && zzc.zza(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.f15493a.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    @KeepForSdk
    @WorkerThread
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, @NonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        com.google.firebase.analytics.connector.internal.zza zzaVar;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (zzc.zzd(str) && !m4369a(str)) {
            boolean equals = AppMeasurement.FIAM_ORIGIN.equals(str);
            AppMeasurementSdk appMeasurementSdk = this.f15493a;
            if (equals) {
                zzaVar = new zze(appMeasurementSdk, analyticsConnectorListener);
            } else if ("clx".equals(str)) {
                zzaVar = new zzg(appMeasurementSdk, analyticsConnectorListener);
            } else {
                zzaVar = null;
            }
            if (zzaVar != null) {
                this.f15494b.put(str, zzaVar);
                return new C1038a(this, str);
            }
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        ImmutableSet immutableSet = zzc.f15497a;
        if (conditionalUserProperty != null && (str = conditionalUserProperty.origin) != null && !str.isEmpty()) {
            Object obj = conditionalUserProperty.value;
            if ((obj == null || zzmg.zza(obj) != null) && zzc.zzd(str) && zzc.zze(str, conditionalUserProperty.name)) {
                String str2 = conditionalUserProperty.expiredEventName;
                if (str2 == null || (zzc.zzb(str2, conditionalUserProperty.expiredEventParams) && zzc.zza(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                    String str3 = conditionalUserProperty.triggeredEventName;
                    if (str3 == null || (zzc.zzb(str3, conditionalUserProperty.triggeredEventParams) && zzc.zza(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                        String str4 = conditionalUserProperty.timedOutEventName;
                        if (str4 == null || (zzc.zzb(str4, conditionalUserProperty.timedOutEventParams) && zzc.zza(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
                            Bundle bundle = new Bundle();
                            String str5 = conditionalUserProperty.origin;
                            if (str5 != null) {
                                bundle.putString("origin", str5);
                            }
                            String str6 = conditionalUserProperty.name;
                            if (str6 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str6);
                            }
                            Object obj2 = conditionalUserProperty.value;
                            if (obj2 != null) {
                                zzjt.zzb(bundle, obj2);
                            }
                            String str7 = conditionalUserProperty.triggerEventName;
                            if (str7 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str7);
                            }
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.triggerTimeout);
                            String str8 = conditionalUserProperty.timedOutEventName;
                            if (str8 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str8);
                            }
                            Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
                            if (bundle2 != null) {
                                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
                            }
                            String str9 = conditionalUserProperty.triggeredEventName;
                            if (str9 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str9);
                            }
                            Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
                            if (bundle3 != null) {
                                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
                            }
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.timeToLive);
                            String str10 = conditionalUserProperty.expiredEventName;
                            if (str10 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str10);
                            }
                            Bundle bundle4 = conditionalUserProperty.expiredEventParams;
                            if (bundle4 != null) {
                                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
                            }
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.creationTimestamp);
                            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.active);
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.triggeredTimestamp);
                            this.f15493a.setConditionalUserProperty(bundle);
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (zzc.zzd(str) && zzc.zze(str, str2)) {
            this.f15493a.setUserProperty(str, str2, obj);
        }
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp, @NonNull Context context, @NonNull Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f15492c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (f15492c == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.isDefaultApp()) {
                            subscriber.subscribe(DataCollectionDefaultChange.class, new Executor() { // from class: com.google.firebase.analytics.connector.zza
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new EventHandler() { // from class: com.google.firebase.analytics.connector.zzb
                                @Override // com.google.firebase.events.EventHandler
                                public final void handle(Event event) {
                                    boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
                                    synchronized (AnalyticsConnectorImpl.class) {
                                        ((AnalyticsConnectorImpl) Preconditions.checkNotNull(AnalyticsConnectorImpl.f15492c)).f15493a.zza(z);
                                    }
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                        }
                        f15492c = new AnalyticsConnectorImpl(zzff.zzg(context, null, null, null, bundle).zzd());
                    }
                } finally {
                }
            }
        }
        return f15492c;
    }
}
