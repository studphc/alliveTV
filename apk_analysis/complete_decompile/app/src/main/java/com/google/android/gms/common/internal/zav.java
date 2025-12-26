package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
/* loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();

    /* renamed from: a */
    public final int f13503a;

    /* renamed from: b */
    public final IBinder f13504b;

    /* renamed from: c */
    public final ConnectionResult f13505c;

    /* renamed from: d */
    public final boolean f13506d;

    /* renamed from: e */
    public final boolean f13507e;

    public zav(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f13503a = i;
        this.f13504b = iBinder;
        this.f13505c = connectionResult;
        this.f13506d = z;
        this.f13507e = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (!this.f13505c.equals(zavVar.f13505c) || !Objects.equal(zab(), zavVar.zab())) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13503a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f13504b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f13505c, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f13506d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f13507e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.f13505c;
    }

    @Nullable
    public final IAccountAccessor zab() {
        IBinder iBinder = this.f13504b;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.asInterface(iBinder);
    }

    public final boolean zac() {
        return this.f13506d;
    }

    public final boolean zad() {
        return this.f13507e;
    }
}
