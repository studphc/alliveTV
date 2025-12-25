package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();

    /* renamed from: a */
    public final String f12981a;

    /* renamed from: b */
    public final int f12982b;

    /* renamed from: c */
    public final long f12983c;

    @SafeParcelable.Constructor
    public Feature(@NonNull @SafeParcelable.Param(m3160id = 1) String str, @SafeParcelable.Param(m3160id = 2) int i, @SafeParcelable.Param(m3160id = 3) long j) {
        this.f12981a = str;
        this.f12982b = i;
        this.f12983c = j;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public String getName() {
        return this.f12981a;
    }

    @KeepForSdk
    public long getVersion() {
        long j = this.f12983c;
        return j == -1 ? this.f12982b : j;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    @NonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add(AppMeasurementSdk.ConditionalUserProperty.NAME, getName());
        stringHelper.add("version", Long.valueOf(getVersion()));
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.f12982b);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @KeepForSdk
    public Feature(@NonNull String str, long j) {
        this.f12981a = str;
        this.f12983c = j;
        this.f12982b = -1;
    }
}
