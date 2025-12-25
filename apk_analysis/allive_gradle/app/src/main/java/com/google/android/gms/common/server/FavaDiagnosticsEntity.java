package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "FavaDiagnosticsEntityCreator")
/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();

    /* renamed from: a */
    public final int f13568a;

    @NonNull
    @SafeParcelable.Field(m3159id = 2)
    public final String zab;

    @SafeParcelable.Field(m3159id = 3)
    public final int zac;

    @SafeParcelable.Constructor
    public FavaDiagnosticsEntity(@SafeParcelable.Param(m3160id = 1) int i, @NonNull @SafeParcelable.Param(m3160id = 2) String str, @SafeParcelable.Param(m3160id = 3) int i2) {
        this.f13568a = i;
        this.zab = str;
        this.zac = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13568a);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @KeepForSdk
    public FavaDiagnosticsEntity(@NonNull String str, int i) {
        this.f13568a = 1;
        this.zab = str;
        this.zac = i;
    }
}
