package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import p000.ye0;

@SafeParcelable.Class(creator = "ConnectionResultCreator")
/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_DISABLED = 23;
    public static final int API_DISABLED_FOR_CONNECTION = 24;
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final int DEVELOPER_ERROR = 10;

    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;

    @KeepForSdk
    public static final int UNKNOWN = -1;

    /* renamed from: a */
    public final int f12974a;

    /* renamed from: b */
    public final int f12975b;

    /* renamed from: c */
    public final PendingIntent f12976c;

    /* renamed from: d */
    public final String f12977d;

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);

    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();

    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f12974a = i;
        this.f12975b = i2;
        this.f12976c = pendingIntent;
        this.f12977d = str;
    }

    /* renamed from: a */
    public static String m3072a(int i) {
        if (i != 99) {
            if (i != 1500) {
                switch (i) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            case 22:
                                return "RESOLUTION_ACTIVITY_NOT_FOUND";
                            case 23:
                                return "API_DISABLED";
                            case 24:
                                return "API_DISABLED_FOR_CONNECTION";
                            case 25:
                                return "API_INSTALL_REQUIRED";
                            default:
                                return ye0.m8292l(i, "UNKNOWN_ERROR_CODE(", ")");
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (this.f12975b == connectionResult.f12975b && Objects.equal(this.f12976c, connectionResult.f12976c) && Objects.equal(this.f12977d, connectionResult.f12977d)) {
            return true;
        }
        return false;
    }

    public int getErrorCode() {
        return this.f12975b;
    }

    @Nullable
    public String getErrorMessage() {
        return this.f12977d;
    }

    @Nullable
    public PendingIntent getResolution() {
        return this.f12976c;
    }

    public boolean hasResolution() {
        return (this.f12975b == 0 || this.f12976c == null) ? false : true;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f12975b), this.f12976c, this.f12977d);
    }

    public boolean isSuccess() {
        return this.f12975b == 0;
    }

    public void startResolutionForResult(@NonNull Activity activity, int i) {
        if (!hasResolution()) {
            return;
        }
        PendingIntent pendingIntent = this.f12976c;
        Preconditions.checkNotNull(pendingIntent);
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", m3072a(this.f12975b));
        stringHelper.add("resolution", this.f12976c);
        stringHelper.add("message", this.f12977d);
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f12974a);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCode());
        SafeParcelWriter.writeParcelable(parcel, 3, getResolution(), i, false);
        SafeParcelWriter.writeString(parcel, 4, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i, pendingIntent, str);
    }
}
