package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "RootTelemetryConfigurationCreator")
/* loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzak();

    /* renamed from: a */
    public final int f13465a;

    /* renamed from: b */
    public final boolean f13466b;

    /* renamed from: c */
    public final boolean f13467c;

    /* renamed from: d */
    public final int f13468d;

    /* renamed from: e */
    public final int f13469e;

    @SafeParcelable.Constructor
    public RootTelemetryConfiguration(@SafeParcelable.Param(m3160id = 1) int i, @SafeParcelable.Param(m3160id = 2) boolean z, @SafeParcelable.Param(m3160id = 3) boolean z2, @SafeParcelable.Param(m3160id = 4) int i2, @SafeParcelable.Param(m3160id = 5) int i3) {
        this.f13465a = i;
        this.f13466b = z;
        this.f13467c = z2;
        this.f13468d = i2;
        this.f13469e = i3;
    }

    @KeepForSdk
    public int getBatchPeriodMillis() {
        return this.f13468d;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsInBatch() {
        return this.f13469e;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.f13466b;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.f13467c;
    }

    @KeepForSdk
    public int getVersion() {
        return this.f13465a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersion());
        SafeParcelWriter.writeBoolean(parcel, 2, getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel, 3, getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeInt(parcel, 4, getBatchPeriodMillis());
        SafeParcelWriter.writeInt(parcel, 5, getMaxMethodInvocationsInBatch());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
