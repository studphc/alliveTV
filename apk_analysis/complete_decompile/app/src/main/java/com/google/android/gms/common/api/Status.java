package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.PlatformVersion;
import p000.mk1;

@SafeParcelable.Class(creator = "StatusCreator")
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    /* renamed from: a */
    public final int f13071a;

    /* renamed from: b */
    public final String f13072b;

    /* renamed from: c */
    public final PendingIntent f13073c;

    /* renamed from: d */
    public final ConnectionResult f13074d;

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_SUCCESS = new Status(0);

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);

    @NonNull
    @ShowFirstParty
    public static final Status zza = new Status(17);

    @NonNull
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new zze();

    public Status(int i, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f13071a = i;
        this.f13072b = str;
        this.f13073c = pendingIntent;
        this.f13074d = connectionResult;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f13071a != status.f13071a || !Objects.equal(this.f13072b, status.f13072b) || !Objects.equal(this.f13073c, status.f13073c) || !Objects.equal(this.f13074d, status.f13074d)) {
            return false;
        }
        return true;
    }

    @Nullable
    public ConnectionResult getConnectionResult() {
        return this.f13074d;
    }

    @Nullable
    public PendingIntent getResolution() {
        return this.f13073c;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f13071a;
    }

    @Nullable
    public String getStatusMessage() {
        return this.f13072b;
    }

    public boolean hasResolution() {
        return this.f13073c != null;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f13071a), this.f13072b, this.f13073c, this.f13074d);
    }

    public boolean isCanceled() {
        return this.f13071a == 16;
    }

    public boolean isInterrupted() {
        return this.f13071a == 14;
    }

    public boolean isSuccess() {
        return this.f13071a <= 0;
    }

    public void startResolutionForResult(@NonNull Activity activity, int i) {
        if (hasResolution()) {
            Bundle bundle = PlatformVersion.isAtLeastU() ? mk1.m6169q(ActivityOptions.makeBasic()).toBundle() : null;
            PendingIntent pendingIntent = this.f13073c;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0, bundle);
        }
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", zza());
        stringHelper.add("resolution", this.f13073c);
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f13073c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zza() {
        String str = this.f13072b;
        if (str != null) {
            return str;
        }
        return CommonStatusCodes.getStatusCodeString(this.f13071a);
    }

    public Status(int i) {
        this(i, (String) null);
    }

    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str) {
        this(connectionResult, str, 17);
    }

    public Status(int i, @Nullable String str) {
        this(i, str, (PendingIntent) null);
    }

    @KeepForSdk
    @Deprecated
    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str, int i) {
        this(i, str, connectionResult.getResolution(), connectionResult);
    }

    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(i, str, pendingIntent, null);
    }

    public void startResolutionForResult(@NonNull ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.f13073c;
            Preconditions.checkNotNull(pendingIntent);
            activityResultLauncher.launch(new IntentSenderRequest.Builder(pendingIntent.getIntentSender()).build());
        }
    }
}
