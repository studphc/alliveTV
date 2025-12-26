package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

@SafeParcelable.Class(creator = "SignInResponseCreator")
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();

    /* renamed from: a */
    public final int f14431a;

    /* renamed from: b */
    public final ConnectionResult f14432b;

    /* renamed from: c */
    public final zav f14433c;

    public zak(int i, ConnectionResult connectionResult, zav zavVar) {
        this.f14431a = i;
        this.f14432b = connectionResult;
        this.f14433c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f14431a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f14432b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f14433c, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.f14432b;
    }

    @Nullable
    public final zav zab() {
        return this.f14433c;
    }
}
