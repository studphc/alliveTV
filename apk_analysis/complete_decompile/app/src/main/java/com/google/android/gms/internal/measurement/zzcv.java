package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public interface zzcv extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(zzcy zzcyVar);

    void getAppInstanceId(zzcy zzcyVar);

    void getCachedAppInstanceId(zzcy zzcyVar);

    void getConditionalUserProperties(String str, String str2, zzcy zzcyVar);

    void getCurrentScreenClass(zzcy zzcyVar);

    void getCurrentScreenName(zzcy zzcyVar);

    void getGmpAppId(zzcy zzcyVar);

    void getMaxUserProperties(String str, zzcy zzcyVar);

    void getSessionId(zzcy zzcyVar);

    void getTestFlag(zzcy zzcyVar, int i);

    void getUserProperties(String str, String str2, boolean z, zzcy zzcyVar);

    void initForTests(Map map);

    void initialize(IObjectWrapper iObjectWrapper, zzdh zzdhVar, long j);

    void isDataCollectionEnabled(zzcy zzcyVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcy zzcyVar, long j);

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j);

    void onActivityCreatedByScionActivityInfo(zzdj zzdjVar, Bundle bundle, long j);

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j);

    void onActivityDestroyedByScionActivityInfo(zzdj zzdjVar, long j);

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j);

    void onActivityPausedByScionActivityInfo(zzdj zzdjVar, long j);

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j);

    void onActivityResumedByScionActivityInfo(zzdj zzdjVar, long j);

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcy zzcyVar, long j);

    void onActivitySaveInstanceStateByScionActivityInfo(zzdj zzdjVar, zzcy zzcyVar, long j);

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j);

    void onActivityStartedByScionActivityInfo(zzdj zzdjVar, long j);

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j);

    void onActivityStoppedByScionActivityInfo(zzdj zzdjVar, long j);

    void performAction(Bundle bundle, zzcy zzcyVar, long j);

    void registerOnMeasurementEventListener(zzde zzdeVar);

    void resetAnalyticsData(long j);

    void retrieveAndUploadBatches(zzdb zzdbVar);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j);

    void setCurrentScreenByScionActivityInfo(zzdj zzdjVar, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzde zzdeVar);

    void setInstanceIdProvider(zzdg zzdgVar);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j);

    void unregisterOnMeasurementEventListener(zzde zzdeVar);
}
