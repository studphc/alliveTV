package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzah;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public final class GoogleServices {

    /* renamed from: e */
    public static final Object f13121e = new Object();

    /* renamed from: f */
    public static GoogleServices f13122f;

    /* renamed from: a */
    public final String f13123a;

    /* renamed from: b */
    public final Status f13124b;

    /* renamed from: c */
    public final boolean f13125c;

    /* renamed from: d */
    public final boolean f13126d;

    public GoogleServices(String str, boolean z) {
        this.f13123a = str;
        this.f13124b = Status.RESULT_SUCCESS;
        this.f13125c = z;
        this.f13126d = !z;
    }

    /* renamed from: a */
    public static GoogleServices m3090a(String str) {
        GoogleServices googleServices;
        synchronized (f13121e) {
            try {
                googleServices = f13122f;
                if (googleServices == null) {
                    throw new IllegalStateException("Initialize must be called before " + str + ".");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleServices;
    }

    @Nullable
    @KeepForSdk
    public static String getGoogleAppId() {
        return m3090a("getGoogleAppId").f13123a;
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (f13121e) {
            try {
                if (f13122f == null) {
                    f13122f = new GoogleServices(context);
                }
                status = f13122f.f13124b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return status;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices m3090a = m3090a("isMeasurementEnabled");
        if (m3090a.f13124b.isSuccess() && m3090a.f13125c) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return m3090a("isMeasurementExplicitlyDisabled").f13126d;
    }

    public GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", TypedValues.Custom.S_INT, resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z = integer == 0;
            r2 = integer != 0;
            this.f13126d = z;
        } else {
            this.f13126d = false;
        }
        this.f13125c = r2;
        String zzb = zzah.zzb(context);
        zzb = zzb == null ? new StringResourceValueReader(context).getString("google_app_id") : zzb;
        if (TextUtils.isEmpty(zzb)) {
            this.f13124b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f13123a = null;
        } else {
            this.f13123a = zzb;
            this.f13124b = Status.RESULT_SUCCESS;
        }
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context, @NonNull String str, boolean z) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (f13121e) {
            try {
                GoogleServices googleServices = f13122f;
                if (googleServices != null) {
                    String str2 = googleServices.f13123a;
                    if (str2 == null || str2.equals(str)) {
                        status = Status.RESULT_SUCCESS;
                    } else {
                        status = new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + str2 + "'.");
                    }
                    return status;
                }
                GoogleServices googleServices2 = new GoogleServices(str, z);
                f13122f = googleServices2;
                return googleServices2.f13124b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
