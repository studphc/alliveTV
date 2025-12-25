package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
/* loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zae();

    /* renamed from: a */
    public final int f13574a;

    /* renamed from: b */
    public final String f13575b;

    /* renamed from: c */
    public final int f13576c;

    public zac(int i, String str, int i2) {
        this.f13574a = i;
        this.f13575b = str;
        this.f13576c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13574a);
        SafeParcelWriter.writeString(parcel, 2, this.f13575b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f13576c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zac(String str, int i) {
        this.f13574a = 1;
        this.f13575b = str;
        this.f13576c = i;
    }
}
