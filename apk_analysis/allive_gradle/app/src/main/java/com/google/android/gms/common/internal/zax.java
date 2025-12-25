package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
/* loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();

    /* renamed from: a */
    public final int f13508a;

    /* renamed from: b */
    public final int f13509b;

    /* renamed from: c */
    public final int f13510c;

    /* renamed from: d */
    public final Scope[] f13511d;

    public zax(int i, int i2, int i3, Scope[] scopeArr) {
        this.f13508a = i;
        this.f13509b = i2;
        this.f13510c = i3;
        this.f13511d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13508a);
        SafeParcelWriter.writeInt(parcel, 2, this.f13509b);
        SafeParcelWriter.writeInt(parcel, 3, this.f13510c);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.f13511d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
