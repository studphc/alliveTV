package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ModuleInstallResponseCreator")
/* loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new zad();

    /* renamed from: a */
    public final int f13551a;

    /* renamed from: b */
    public final boolean f13552b;

    @KeepForSdk
    public ModuleInstallResponse(int i) {
        this(i, false);
    }

    public boolean areModulesAlreadyInstalled() {
        return this.f13551a == 0;
    }

    public int getSessionId() {
        return this.f13551a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeBoolean(parcel, 2, this.f13552b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zaa() {
        return this.f13552b;
    }

    @SafeParcelable.Constructor
    public ModuleInstallResponse(@SafeParcelable.Param(m3160id = 1) int i, @SafeParcelable.Param(m3160id = 2) boolean z) {
        this.f13551a = i;
        this.f13552b = z;
    }
}
