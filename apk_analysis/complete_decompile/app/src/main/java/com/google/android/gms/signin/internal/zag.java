package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "RecordConsentByConsentResultResponseCreator")
/* loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zah();

    /* renamed from: a */
    public final List f14427a;

    /* renamed from: b */
    public final String f14428b;

    @SafeParcelable.Constructor
    public zag(@SafeParcelable.Param(m3160id = 1) List list, @Nullable @SafeParcelable.Param(m3160id = 2) String str) {
        this.f14427a = list;
        this.f14428b = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.f14428b != null) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.f14427a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f14428b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
