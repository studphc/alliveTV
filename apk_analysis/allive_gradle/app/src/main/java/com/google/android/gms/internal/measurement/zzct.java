package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzct extends zzbm implements zzcv {
    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void beginAdUnitExposure(String str, long j) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void clearMeasurementEnabled(long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void endAdUnitExposure(String str, long j) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void generateEventId(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getAppInstanceId(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getCachedAppInstanceId(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getConditionalUserProperties(String str, String str2, zzcy zzcyVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, zzcyVar);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getCurrentScreenClass(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(17, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getCurrentScreenName(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getGmpAppId(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(21, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getMaxUserProperties(String str, zzcy zzcyVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zzbo.zze(zza, zzcyVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getSessionId(zzcy zzcyVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(46, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getTestFlag(zzcy zzcyVar, int i) {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zza.writeInt(i);
        zzc(38, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getUserProperties(String str, String str2, boolean z, zzcy zzcyVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        ClassLoader classLoader = zzbo.f13794a;
        zza.writeInt(z ? 1 : 0);
        zzbo.zze(zza, zzcyVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void initForTests(Map map) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void initialize(IObjectWrapper iObjectWrapper, zzdh zzdhVar, long j) {
        Parcel zza = zza();
        zzbo.zze(zza, iObjectWrapper);
        zzbo.zzd(zza, zzdhVar);
        zza.writeLong(j);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void isDataCollectionEnabled(zzcy zzcyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeLong(j);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcy zzcyVar, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbo.zze(zza, iObjectWrapper);
        zzbo.zze(zza, iObjectWrapper2);
        zzbo.zze(zza, iObjectWrapper3);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityCreatedByScionActivityInfo(zzdj zzdjVar, Bundle bundle, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(53, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityDestroyedByScionActivityInfo(zzdj zzdjVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(54, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityPausedByScionActivityInfo(zzdj zzdjVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(55, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityResumedByScionActivityInfo(zzdj zzdjVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(56, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcy zzcyVar, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdj zzdjVar, zzcy zzcyVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zzbo.zze(zza, zzcyVar);
        zza.writeLong(j);
        zzc(57, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStartedByScionActivityInfo(zzdj zzdjVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(51, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStoppedByScionActivityInfo(zzdj zzdjVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(52, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void performAction(Bundle bundle, zzcy zzcyVar, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzbo.zze(zza, zzcyVar);
        zza.writeLong(j);
        zzc(32, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void registerOnMeasurementEventListener(zzde zzdeVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzdeVar);
        zzc(35, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void resetAnalyticsData(long j) {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void retrieveAndUploadBatches(zzdb zzdbVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzdbVar);
        zzc(58, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setConsent(Bundle bundle, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setConsentThirdParty(Bundle bundle, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(45, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setCurrentScreenByScionActivityInfo(zzdj zzdjVar, String str, String str2, long j) {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(50, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setDataCollectionEnabled(boolean z) {
        Parcel zza = zza();
        ClassLoader classLoader = zzbo.f13794a;
        zza.writeInt(z ? 1 : 0);
        zzc(39, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setDefaultEventParameters(Bundle bundle) {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzc(42, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setEventInterceptor(zzde zzdeVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzdeVar);
        zzc(34, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setInstanceIdProvider(zzdg zzdgVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setMeasurementEnabled(boolean z, long j) {
        Parcel zza = zza();
        ClassLoader classLoader = zzbo.f13794a;
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setMinimumSessionDuration(long j) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setSessionTimeoutDuration(long j) {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setSgtmDebugInfo(Intent intent) {
        Parcel zza = zza();
        zzbo.zzd(zza, intent);
        zzc(48, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setUserId(String str, long j) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, iObjectWrapper);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void unregisterOnMeasurementEventListener(zzde zzdeVar) {
        Parcel zza = zza();
        zzbo.zze(zza, zzdeVar);
        zzc(36, zza);
    }
}
