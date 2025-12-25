package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import p000.u82;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new u82(13);

    /* renamed from: a */
    public final IBinder f13397a;

    @KeepForSdk
    public BinderWrapper(@NonNull IBinder iBinder) {
        this.f13397a = iBinder;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f13397a);
    }

    public /* synthetic */ BinderWrapper(Parcel parcel) {
        this.f13397a = parcel.readStrongBinder();
    }
}
