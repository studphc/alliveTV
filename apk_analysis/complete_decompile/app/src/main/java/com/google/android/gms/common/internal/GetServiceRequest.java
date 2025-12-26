package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzn();

    /* renamed from: o */
    public static final Scope[] f13421o = new Scope[0];

    /* renamed from: p */
    public static final Feature[] f13422p = new Feature[0];

    /* renamed from: a */
    public final int f13423a;

    /* renamed from: b */
    public final int f13424b;

    /* renamed from: c */
    public final int f13425c;

    /* renamed from: d */
    public String f13426d;

    /* renamed from: e */
    public IBinder f13427e;

    /* renamed from: f */
    public Scope[] f13428f;

    /* renamed from: g */
    public Bundle f13429g;

    /* renamed from: h */
    public Account f13430h;

    /* renamed from: i */
    public Feature[] f13431i;

    /* renamed from: j */
    public Feature[] f13432j;

    /* renamed from: k */
    public final boolean f13433k;

    /* renamed from: l */
    public final int f13434l;

    /* renamed from: m */
    public boolean f13435m;

    /* renamed from: n */
    public final String f13436n;

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4, boolean z2, String str2) {
        Account account2;
        scopeArr = scopeArr == null ? f13421o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f13422p;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.f13423a = i;
        this.f13424b = i2;
        this.f13425c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f13426d = "com.google.android.gms";
        } else {
            this.f13426d = str;
        }
        if (i < 2) {
            if (iBinder != null) {
                account2 = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder));
            } else {
                account2 = null;
            }
            this.f13430h = account2;
        } else {
            this.f13427e = iBinder;
            this.f13430h = account;
        }
        this.f13428f = scopeArr;
        this.f13429g = bundle;
        this.f13431i = featureArr;
        this.f13432j = featureArr2;
        this.f13433k = z;
        this.f13434l = i4;
        this.f13435m = z2;
        this.f13436n = str2;
    }

    @Nullable
    @KeepForSdk
    public String getAttributionTag() {
        return this.f13436n;
    }

    @NonNull
    @KeepForSdk
    public String getCallingPackage() {
        return this.f13426d;
    }

    @NonNull
    @KeepForSdk
    public Feature[] getClientApiFeatures() {
        return this.f13432j;
    }

    @KeepForSdk
    public int getClientLibraryVersion() {
        return this.f13425c;
    }

    @NonNull
    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.f13429g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        zzn.m3167a(this, parcel, i);
    }
}
