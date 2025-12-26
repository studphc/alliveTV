package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountRequestCreator")
/* loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();

    /* renamed from: a */
    public final int f13499a;

    /* renamed from: b */
    public final Account f13500b;

    /* renamed from: c */
    public final int f13501c;

    /* renamed from: d */
    public final GoogleSignInAccount f13502d;

    public zat(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f13499a = i;
        this.f13500b = account;
        this.f13501c = i2;
        this.f13502d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13499a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f13500b, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f13501c);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f13502d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zat(Account account, int i, @Nullable GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }
}
