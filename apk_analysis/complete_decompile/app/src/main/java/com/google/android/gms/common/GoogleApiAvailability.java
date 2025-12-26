package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.Arrays;
import p000.h83;
import p000.ra0;
import p000.x73;
import p000.ye0;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    @NonNull
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    /* renamed from: b */
    public String f12986b;

    /* renamed from: c */
    public static final Object f12984c = new Object();

    /* renamed from: d */
    public static final GoogleApiAvailability f12985d = new GoogleApiAvailability();
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static AlertDialog m3073a(Context context, int i, zag zagVar, DialogInterface.OnCancelListener onCancelListener, x73 x73Var) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zac.zac(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zab = zac.zab(context, i);
        if (zab != null) {
            if (zagVar == null) {
                zagVar = x73Var;
            }
            builder.setPositiveButton(zab, zagVar);
        }
        String zaf = zac.zaf(context, i);
        if (zaf != null) {
            builder.setTitle(zaf);
        }
        Log.w("GoogleApiAvailability", ye0.m8291k(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    /* renamed from: b */
    public static void m3074b(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @NonNull
    public static GoogleApiAvailability getInstance() {
        return f12985d;
    }

    @NonNull
    public static final Task zai(@NonNull HasApiKey hasApiKey, @NonNull HasApiKey... hasApiKeyArr) {
        Preconditions.checkNotNull(hasApiKey, "Requested API must not be null.");
        for (HasApiKey hasApiKey2 : hasApiKeyArr) {
            Preconditions.checkNotNull(hasApiKey2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.zaj().zam(arrayList);
    }

    /* renamed from: c */
    public final void m3075c(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        String str;
        NotificationChannel notificationChannel;
        CharSequence name;
        Log.w("GoogleApiAvailability", ye0.m8292l(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new h83(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String zae = zac.zae(context, i);
        String zad = zac.zad(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"));
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(zae).setStyle(new NotificationCompat.BigTextStyle().bigText(zad));
        if (DeviceProperties.isWearable(context)) {
            Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                style.addAction(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(android.R.drawable.stat_sys_warning).setTicker(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(zad);
        }
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkState(PlatformVersion.isAtLeastO());
            synchronized (f12984c) {
                str = this.f12986b;
            }
            if (str == null) {
                str = "com.google.android.gms.availability";
                notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(ra0.m7243f(string));
                } else {
                    name = notificationChannel.getName();
                    if (!string.contentEquals(name)) {
                        notificationChannel.setName(string);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
            }
            style.setChannelId(str);
        }
        Notification build = style.build();
        if (i != 1 && i != 2 && i != 3) {
            i2 = 39789;
        } else {
            GooglePlayServicesUtilLight.f12990a.set(false);
            i2 = 10436;
        }
        notificationManager.notify(i2, build);
    }

    @NonNull
    public Task<Void> checkApiAvailability(@NonNull GoogleApi<?> googleApi, @NonNull GoogleApi<?>... googleApiArr) {
        return zai(googleApi, googleApiArr).onSuccessTask(zab.zaa);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(@NonNull Context context) {
        return super.getClientVersion(context);
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Activity activity, int i, int i2) {
        return getErrorDialog(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(@Nullable Context context, int i, @Nullable String str) {
        return super.getErrorResolutionIntent(context, i, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, int i, int i2) {
        return super.getErrorResolutionPendingIntent(context, i, i2);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @NonNull
    public final String getErrorString(int i) {
        return super.getErrorString(i);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ResultIgnorabilityUnspecified
    @HideFirstParty
    public int isGooglePlayServicesAvailable(@NonNull Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean isUserResolvableError(int i) {
        return super.isUserResolvableError(i);
    }

    @NonNull
    @MainThread
    public Task<Void> makeGooglePlayServicesAvailable(@NonNull Activity activity) {
        int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity, i);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zacc zaa = zacc.zaa(activity);
        zaa.zah(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        return zaa.zad();
    }

    @TargetApi(26)
    public void setDefaultNotificationChannelId(@NonNull Context context, @NonNull String str) {
        NotificationChannel notificationChannel;
        if (PlatformVersion.isAtLeastO()) {
            notificationChannel = ((NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"))).getNotificationChannel(str);
            Preconditions.checkNotNull(notificationChannel);
        }
        synchronized (f12984c) {
            this.f12986b = str;
        }
    }

    @ResultIgnorabilityUnspecified
    public boolean showErrorDialogFragment(@NonNull Activity activity, int i, int i2) {
        return showErrorDialogFragment(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(@NonNull Context context, int i) {
        m3075c(context, i, getErrorResolutionPendingIntent(context, i, 0, "n"));
    }

    @NonNull
    public final Dialog zab(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zac.zac(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        m3074b(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @Nullable
    @ResultIgnorabilityUnspecified
    public final zabx zac(Context context, zabw zabwVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(zabwVar);
        zao.zaa(context, zabxVar, intentFilter);
        zabxVar.zaa(context);
        if (!isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            zabwVar.zaa();
            zabxVar.zab();
            return null;
        }
        return zabxVar;
    }

    @ResultIgnorabilityUnspecified
    public final boolean zag(@NonNull Activity activity, @NonNull LifecycleFragment lifecycleFragment, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog m3073a = m3073a(activity, i, zag.zad(lifecycleFragment, getErrorResolutionIntent(activity, i, "d"), 2), onCancelListener, null);
        if (m3073a == null) {
            return false;
        }
        m3074b(activity, m3073a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final boolean zah(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        m3075c(context, connectionResult.getErrorCode(), PendingIntent.getActivity(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i, true), zap.zaa | C0643C.BUFFER_FLAG_FIRST_SAMPLE));
        return true;
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Activity activity, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return m3073a(activity, i, zag.zab(activity, getErrorResolutionIntent(activity, i, "d"), i2), onCancelListener, null);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(@NonNull Context context, int i) {
        return super.isGooglePlayServicesAvailable(context, i);
    }

    @ResultIgnorabilityUnspecified
    public boolean showErrorDialogFragment(@NonNull Activity activity, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        m3074b(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @NonNull
    public Task<Void> checkApiAvailability(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        return zai(hasApiKey, hasApiKeyArr).onSuccessTask(zaa.zaa);
    }

    public void showErrorNotification(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        m3075c(context, connectionResult.getErrorCode(), getErrorResolutionPendingIntent(context, connectionResult));
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Fragment fragment, int i, int i2) {
        return getErrorDialog(fragment, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public boolean showErrorDialogFragment(@NonNull Activity activity, int i, @NonNull ActivityResultLauncher<IntentSenderRequest> activityResultLauncher, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog m3073a = m3073a(activity, i, null, onCancelListener, new x73(this, activity, i, activityResultLauncher));
        if (m3073a == null) {
            return false;
        }
        m3074b(activity, m3073a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Fragment fragment, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return m3073a(fragment.requireContext(), i, zag.zac(fragment, getErrorResolutionIntent(fragment.requireContext(), i, "d"), i2), onCancelListener, null);
    }
}
