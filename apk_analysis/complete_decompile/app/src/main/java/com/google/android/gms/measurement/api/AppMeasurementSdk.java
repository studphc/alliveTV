package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzkc;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class AppMeasurementSdk {

    /* renamed from: a */
    public final zzff f13970a;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ConditionalUserProperty {

        @NonNull
        @KeepForSdk
        public static final String ACTIVE = "active";

        @NonNull
        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";

        @NonNull
        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";

        @NonNull
        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";

        @NonNull
        @KeepForSdk
        public static final String NAME = "name";

        @NonNull
        @KeepForSdk
        public static final String ORIGIN = "origin";

        @NonNull
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";

        @NonNull
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";

        @NonNull
        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";

        @NonNull
        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";

        @NonNull
        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";

        @NonNull
        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";

        @NonNull
        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";

        @NonNull
        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";

        @NonNull
        @KeepForSdk
        public static final String VALUE = "value";
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

    public AppMeasurementSdk(zzff zzffVar) {
        this.f13970a = zzffVar;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurementSdk getInstance(@NonNull Context context) {
        return zzff.zzg(context, null, null, null, null).zzd();
    }

    @KeepForSdk
    public void beginAdUnitExposure(@NonNull @Size(min = 1) String str) {
        this.f13970a.zzv(str);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.f13970a.zzw(str, str2, bundle);
    }

    @KeepForSdk
    public void endAdUnitExposure(@NonNull @Size(min = 1) String str) {
        this.f13970a.zzx(str);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.f13970a.zzb();
    }

    @Nullable
    @KeepForSdk
    public String getAppIdOrigin() {
        return this.f13970a.zzk();
    }

    @Nullable
    @KeepForSdk
    public String getAppInstanceId() {
        return this.f13970a.zzm();
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public List<Bundle> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        return this.f13970a.zzq(str, str2);
    }

    @Nullable
    @KeepForSdk
    public String getCurrentScreenClass() {
        return this.f13970a.zzn();
    }

    @Nullable
    @KeepForSdk
    public String getCurrentScreenName() {
        return this.f13970a.zzo();
    }

    @Nullable
    @KeepForSdk
    public String getGmpAppId() {
        return this.f13970a.zzp();
    }

    @KeepForSdk
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        return this.f13970a.zza(str);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public Map<String, Object> getUserProperties(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z) {
        return this.f13970a.zzr(str, str2, z);
    }

    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        this.f13970a.zzz(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.f13970a.zzA(str, str2, bundle, j);
    }

    @KeepForSdk
    public void performAction(@NonNull Bundle bundle) {
        this.f13970a.zzc(bundle, false);
    }

    @Nullable
    @KeepForSdk
    public Bundle performActionWithResponse(@NonNull Bundle bundle) {
        return this.f13970a.zzc(bundle, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.f13970a.zzC(onEventListener);
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull Bundle bundle) {
        this.f13970a.zzF(bundle);
    }

    @KeepForSdk
    @Deprecated
    public void setConsent(@NonNull Bundle bundle) {
    }

    @KeepForSdk
    public void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.f13970a.zzH(zzdj.zza(activity), str, str2);
    }

    @ShowFirstParty
    @KeepForSdk
    @WorkerThread
    public void setEventInterceptor(@NonNull EventInterceptor eventInterceptor) {
        this.f13970a.zzK(eventInterceptor);
    }

    @KeepForSdk
    @Deprecated
    public void setMeasurementEnabled(@Nullable Boolean bool) {
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        this.f13970a.zzP(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.f13970a.zzQ(onEventListener);
    }

    public final void zza(boolean z) {
        this.f13970a.zzI(z);
    }

    @KeepForSdk
    @Deprecated
    public void setMeasurementEnabled(boolean z) {
    }

    @NonNull
    @Deprecated
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AppMeasurementSdk getInstance(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull Bundle bundle) {
        return zzff.zzg(context, str, str2, str3, bundle).zzd();
    }
}
