package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzlx;
import com.google.android.gms.measurement.internal.zzmg;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000.f93;
import p000.ia3;
import p000.y93;

@ShowFirstParty
@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";

    /* renamed from: b */
    public static volatile AppMeasurement f13965b;

    /* renamed from: a */
    public final ia3 f13966a;

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public boolean mActive;

        @NonNull
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mAppId;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mCreationTimestamp;

        @NonNull
        @Keep
        public String mExpiredEventName;

        @NonNull
        @Keep
        public Bundle mExpiredEventParams;

        @NonNull
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mName;

        @NonNull
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mOrigin;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTimeToLive;

        @NonNull
        @Keep
        public String mTimedOutEventName;

        @NonNull
        @Keep
        public Bundle mTimedOutEventParams;

        @NonNull
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mTriggerEventName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggerTimeout;

        @NonNull
        @Keep
        public String mTriggeredEventName;

        @NonNull
        @Keep
        public Bundle mTriggeredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggeredTimestamp;

        @NonNull
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        @KeepForSdk
        public ConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zza = zzmg.zza(obj);
                this.mValue = zza;
                if (zza == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public interface EventInterceptor extends zzkb {
        @Override // com.google.android.gms.measurement.internal.zzkb
        @ShowFirstParty
        @KeepForSdk
        @WorkerThread
        void interceptEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j);
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public interface OnEventListener extends zzkc {
        @Override // com.google.android.gms.measurement.internal.zzkc
        @ShowFirstParty
        @KeepForSdk
        @WorkerThread
        void onEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j);
    }

    public AppMeasurement(zzio zzioVar) {
        this.f13966a = new f93(zzioVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @NonNull
    @Keep
    @Deprecated
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurement getInstance(@NonNull Context context) {
        if (f13965b == null) {
            synchronized (AppMeasurement.class) {
                if (f13965b == null) {
                    zzlx zzlxVar = (zzlx) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (zzlxVar != null) {
                        f13965b = new AppMeasurement(zzlxVar);
                    } else {
                        f13965b = new AppMeasurement(zzio.zzp(context, new zzdh(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return f13965b;
    }

    @Keep
    public void beginAdUnitExposure(@NonNull @Size(min = 1) String str) {
        this.f13966a.zzp(str);
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f13966a.zzq(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@NonNull @Size(min = 1) String str) {
        this.f13966a.zzr(str);
    }

    @Keep
    public long generateEventId() {
        return this.f13966a.zzb();
    }

    @NonNull
    @Keep
    public String getAppInstanceId() {
        return this.f13966a.zzh();
    }

    @NonNull
    @KeepForSdk
    public Boolean getBoolean() {
        return this.f13966a.mo4783a();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty, java.lang.Object] */
    @NonNull
    @Keep
    @ShowFirstParty
    @KeepForSdk
    @WorkerThread
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @NonNull @Size(max = 23, min = 1) String str2) {
        int size;
        List<Bundle> zzm = this.f13966a.zzm(str, str2);
        if (zzm == null) {
            size = 0;
        } else {
            size = zzm.size();
        }
        ArrayList arrayList = new ArrayList(size);
        for (Bundle bundle : zzm) {
            ?? obj = new Object();
            Preconditions.checkNotNull(bundle);
            obj.mAppId = (String) zzjt.zza(bundle, "app_id", String.class, null);
            obj.mOrigin = (String) zzjt.zza(bundle, "origin", String.class, null);
            obj.mName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
            obj.mValue = zzjt.zza(bundle, "value", Object.class, null);
            obj.mTriggerEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            obj.mTriggerTimeout = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            obj.mTimedOutEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            obj.mTimedOutEventParams = (Bundle) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            obj.mTriggeredEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            obj.mTriggeredEventParams = (Bundle) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            obj.mTimeToLive = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            obj.mExpiredEventName = (String) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            obj.mExpiredEventParams = (Bundle) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            obj.mActive = ((Boolean) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, Boolean.FALSE)).booleanValue();
            obj.mCreationTimestamp = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            obj.mTriggeredTimestamp = ((Long) zzjt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NonNull
    @Keep
    public String getCurrentScreenClass() {
        return this.f13966a.zzi();
    }

    @NonNull
    @Keep
    public String getCurrentScreenName() {
        return this.f13966a.zzj();
    }

    @NonNull
    @KeepForSdk
    public Double getDouble() {
        return this.f13966a.mo4784b();
    }

    @NonNull
    @Keep
    public String getGmpAppId() {
        return this.f13966a.zzk();
    }

    @NonNull
    @KeepForSdk
    public Integer getInteger() {
        return this.f13966a.mo4785c();
    }

    @NonNull
    @KeepForSdk
    public Long getLong() {
        return this.f13966a.mo4786d();
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        return this.f13966a.zza(str);
    }

    @NonNull
    @KeepForSdk
    public String getString() {
        return this.f13966a.mo4787e();
    }

    @NonNull
    @Keep
    @VisibleForTesting
    @WorkerThread
    public Map<String, Object> getUserProperties(@NonNull String str, @NonNull @Size(max = 24, min = 1) String str2, boolean z) {
        return this.f13966a.zzo(str, str2, z);
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f13966a.zzs(str, str2, bundle);
    }

    @ShowFirstParty
    @KeepForSdk
    public void logEventInternalNoInterceptor(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j) {
        this.f13966a.zzt(str, str2, bundle, j);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.f13966a.zzu(onEventListener);
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzjt.zzb(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.mActive);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.mTriggeredTimestamp);
        this.f13966a.zzv(bundle);
    }

    @ShowFirstParty
    @KeepForSdk
    @WorkerThread
    public void setEventInterceptor(@NonNull EventInterceptor eventInterceptor) {
        this.f13966a.zzw(eventInterceptor);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.f13966a.zzx(onEventListener);
    }

    public AppMeasurement(zzlx zzlxVar) {
        this.f13966a = new y93(zzlxVar);
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    @WorkerThread
    public Map<String, Object> getUserProperties(boolean z) {
        return this.f13966a.mo4788f(z);
    }
}
