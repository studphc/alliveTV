package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: a */
    public final String f13678a;

    /* renamed from: b */
    public final boolean f13679b;

    /* renamed from: c */
    public final boolean f13680c;

    /* renamed from: d */
    public final Context f13681d;

    /* renamed from: e */
    public final boolean f13682e;

    /* renamed from: f */
    public final boolean f13683f;

    public zzo(String str, boolean z, boolean z2, IBinder iBinder, boolean z3, boolean z4) {
        this.f13678a = str;
        this.f13679b = z;
        this.f13680c = z2;
        this.f13681d = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.f13682e = z3;
        this.f13683f = z4;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f13678a, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f13679b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f13680c);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.f13681d), false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f13682e);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f13683f);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
