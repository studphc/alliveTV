package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.u82;

/* loaded from: classes.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new u82(1);
    public static final int DEVICE_CHARGING = 8;
    public static final int DEVICE_IDLE = 4;
    public static final int DEVICE_STORAGE_NOT_LOW = 16;
    public static final int NETWORK = 1;
    public static final int NETWORK_UNMETERED = 2;

    /* renamed from: a */
    public final int f10891a;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RequirementFlags {
    }

    public Requirements(int i) {
        this.f10891a = (i & 2) != 0 ? i | 1 : i;
    }

    public boolean checkRequirements(Context context) {
        if (getNotMetRequirements(context) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Requirements.class != obj.getClass()) {
            return false;
        }
        if (this.f10891a == ((Requirements) obj).f10891a) {
            return true;
        }
        return false;
    }

    public Requirements filterRequirements(int i) {
        int i2 = this.f10891a;
        int i3 = i & i2;
        if (i3 == i2) {
            return this;
        }
        return new Requirements(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x003c, code lost:
    
        if (r3.hasCapability(16) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNotMetRequirements(Context context) {
        int i;
        boolean z;
        Intent registerReceiver;
        int intExtra;
        boolean z2 = false;
        if (isNetworkRequired()) {
            ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.checkNotNull(context.getSystemService("connectivity"));
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (Util.SDK_INT >= 24) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        try {
                            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                            if (networkCapabilities != null) {
                            }
                        } catch (SecurityException unused) {
                        }
                    }
                }
                if (isUnmeteredNetworkRequired() && connectivityManager.isActiveNetworkMetered()) {
                    i = 2;
                    if (isChargingRequired() && ((registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null || ((intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1)) != 2 && intExtra != 5))) {
                        i |= 8;
                    }
                    if (isIdleRequired()) {
                        PowerManager powerManager = (PowerManager) Assertions.checkNotNull(context.getSystemService("power"));
                        int i2 = Util.SDK_INT;
                        if (i2 >= 23) {
                            z = powerManager.isDeviceIdleMode();
                        } else if (i2 < 20 ? !powerManager.isScreenOn() : !powerManager.isInteractive()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            i |= 4;
                        }
                    }
                    if (isStorageNotLowRequired()) {
                        if (context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null) {
                            z2 = true;
                        }
                        if (!z2) {
                            return i | 16;
                        }
                        return i;
                    }
                    return i;
                }
            }
            i = this.f10891a & 3;
            if (isChargingRequired()) {
                i |= 8;
            }
            if (isIdleRequired()) {
            }
            if (isStorageNotLowRequired()) {
            }
        }
        i = 0;
        if (isChargingRequired()) {
        }
        if (isIdleRequired()) {
        }
        if (isStorageNotLowRequired()) {
        }
    }

    public int getRequirements() {
        return this.f10891a;
    }

    public int hashCode() {
        return this.f10891a;
    }

    public boolean isChargingRequired() {
        if ((this.f10891a & 8) != 0) {
            return true;
        }
        return false;
    }

    public boolean isIdleRequired() {
        if ((this.f10891a & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isNetworkRequired() {
        if ((this.f10891a & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isStorageNotLowRequired() {
        if ((this.f10891a & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isUnmeteredNetworkRequired() {
        if ((this.f10891a & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10891a);
    }
}
