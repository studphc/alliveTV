package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();

    /* renamed from: a */
    public Bundle f13527a;

    /* renamed from: b */
    public Feature[] f13528b;

    /* renamed from: c */
    public int f13529c;

    /* renamed from: d */
    public ConnectionTelemetryConfiguration f13530d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f13527a, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f13528b, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f13529c);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f13530d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
