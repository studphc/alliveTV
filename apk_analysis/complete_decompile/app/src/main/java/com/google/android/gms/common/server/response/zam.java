package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMapPairCreator")
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();

    /* renamed from: a */
    public final int f13610a;

    /* renamed from: b */
    public final String f13611b;

    /* renamed from: c */
    public final FastJsonResponse.Field f13612c;

    public zam(FastJsonResponse.Field field, String str, int i) {
        this.f13610a = i;
        this.f13611b = str;
        this.f13612c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13610a);
        SafeParcelWriter.writeString(parcel, 2, this.f13611b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f13612c, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zam(FastJsonResponse.Field field, String str) {
        this.f13610a = 1;
        this.f13611b = str;
        this.f13612c = field;
    }
}
