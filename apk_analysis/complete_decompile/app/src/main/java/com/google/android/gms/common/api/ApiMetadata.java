package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Objects;
import p000.h93;
import p000.ye0;

@KeepForSdk
@SafeParcelable.Class(creator = "ApiMetadataCreator")
/* loaded from: classes.dex */
public final class ApiMetadata extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiMetadata> CREATOR = h93.f17992a;

    /* renamed from: b */
    public static final ApiMetadata f13013b = newBuilder().build();

    /* renamed from: a */
    public final ComplianceOptions f13014a;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public ComplianceOptions f13015a;

        @NonNull
        @KeepForSdk
        public ApiMetadata build() {
            return new ApiMetadata(this.f13015a);
        }

        @NonNull
        @KeepForSdk
        public Builder setComplianceOptions(@Nullable ComplianceOptions complianceOptions) {
            this.f13015a = complianceOptions;
            return this;
        }
    }

    public ApiMetadata(ComplianceOptions complianceOptions) {
        this.f13014a = complianceOptions;
    }

    @NonNull
    @KeepForSdk
    public static final ApiMetadata fromComplianceOptions(@NonNull ComplianceOptions complianceOptions) {
        Builder newBuilder = newBuilder();
        newBuilder.setComplianceOptions(complianceOptions);
        return newBuilder.build();
    }

    @NonNull
    @KeepForSdk
    public static final ApiMetadata getEmptyInstance() {
        return f13013b;
    }

    @NonNull
    @KeepForSdk
    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ApiMetadata)) {
            return false;
        }
        return Objects.equals(this.f13014a, ((ApiMetadata) obj).f13014a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f13014a);
    }

    @NonNull
    public final String toString() {
        return ye0.m8296p("ApiMetadata(complianceOptions=", String.valueOf(this.f13014a), ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(-204102970);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f13014a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
