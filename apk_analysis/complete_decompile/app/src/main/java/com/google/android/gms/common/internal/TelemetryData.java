package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@SafeParcelable.Class(creator = "TelemetryDataCreator")
/* loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();

    /* renamed from: a */
    public final int f13472a;

    /* renamed from: b */
    public List f13473b;

    @SafeParcelable.Constructor
    public TelemetryData(@SafeParcelable.Param(m3160id = 1) int i, @SafeParcelable.Param(m3160id = 2) @Nullable List list) {
        this.f13472a = i;
        this.f13473b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13472a);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f13473b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zaa() {
        return this.f13472a;
    }

    @androidx.annotation.Nullable
    public final List zab() {
        return this.f13473b;
    }

    public final void zac(@NonNull MethodInvocation methodInvocation) {
        if (this.f13473b == null) {
            this.f13473b = new ArrayList();
        }
        this.f13473b.add(methodInvocation);
    }
}
