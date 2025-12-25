package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ConnectionTelemetryConfigurationCreator")
/* loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzm();

    /* renamed from: a */
    public final RootTelemetryConfiguration f13413a;

    /* renamed from: b */
    public final boolean f13414b;

    /* renamed from: c */
    public final boolean f13415c;

    /* renamed from: d */
    public final int[] f13416d;

    /* renamed from: e */
    public final int f13417e;

    /* renamed from: f */
    public final int[] f13418f;

    @SafeParcelable.Constructor
    public ConnectionTelemetryConfiguration(@NonNull @SafeParcelable.Param(m3160id = 1) RootTelemetryConfiguration rootTelemetryConfiguration, @SafeParcelable.Param(m3160id = 2) boolean z, @SafeParcelable.Param(m3160id = 3) boolean z2, @Nullable @SafeParcelable.Param(m3160id = 4) int[] iArr, @SafeParcelable.Param(m3160id = 5) int i, @Nullable @SafeParcelable.Param(m3160id = 6) int[] iArr2) {
        this.f13413a = rootTelemetryConfiguration;
        this.f13414b = z;
        this.f13415c = z2;
        this.f13416d = iArr;
        this.f13417e = i;
        this.f13418f = iArr2;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsLogged() {
        return this.f13417e;
    }

    @Nullable
    @KeepForSdk
    public int[] getMethodInvocationMethodKeyAllowlist() {
        return this.f13416d;
    }

    @Nullable
    @KeepForSdk
    public int[] getMethodInvocationMethodKeyDisallowlist() {
        return this.f13418f;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.f13414b;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.f13415c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f13413a, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel, 3, getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeIntArray(parcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
        SafeParcelWriter.writeInt(parcel, 5, getMaxMethodInvocationsLogged());
        SafeParcelWriter.writeIntArray(parcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final RootTelemetryConfiguration zza() {
        return this.f13413a;
    }
}
