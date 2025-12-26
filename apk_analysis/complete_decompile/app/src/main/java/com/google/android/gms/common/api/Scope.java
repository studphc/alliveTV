package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ScopeCreator")
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new zzd();

    /* renamed from: a */
    public final int f13069a;

    /* renamed from: b */
    public final String f13070b;

    public Scope(int i, String str) {
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.f13069a = i;
        this.f13070b = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f13070b.equals(((Scope) obj).f13070b);
    }

    @NonNull
    @KeepForSdk
    public String getScopeUri() {
        return this.f13070b;
    }

    public int hashCode() {
        return this.f13070b.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f13070b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13069a);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Scope(@NonNull String str) {
        this(1, str);
    }
}
