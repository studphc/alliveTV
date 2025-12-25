package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ComplianceOptionsCreator")
/* loaded from: classes.dex */
public final class ComplianceOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ComplianceOptions> CREATOR;

    @NonNull
    public static final ComplianceOptions zza;

    /* renamed from: a */
    public final int f13028a;

    /* renamed from: b */
    public final int f13029b;

    /* renamed from: c */
    public final int f13030c;

    /* renamed from: d */
    public final boolean f13031d;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public int f13032a = -1;

        /* renamed from: b */
        public int f13033b = -1;

        /* renamed from: c */
        public int f13034c = 0;

        /* renamed from: d */
        public boolean f13035d = true;

        @NonNull
        @KeepForSdk
        public ComplianceOptions build() {
            return new ComplianceOptions(this.f13032a, this.f13033b, this.f13034c, this.f13035d);
        }

        @NonNull
        @KeepForSdk
        public Builder setCallerProductId(int i) {
            this.f13032a = i;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setDataOwnerProductId(int i) {
            this.f13033b = i;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setIsUserData(boolean z) {
            this.f13035d = z;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setProcessingReason(int i) {
            this.f13034c = i;
            return this;
        }
    }

    static {
        Builder newBuilder = newBuilder();
        newBuilder.setCallerProductId(-1);
        newBuilder.setDataOwnerProductId(-1);
        newBuilder.setProcessingReason(0);
        newBuilder.setIsUserData(true);
        zza = newBuilder.build();
        CREATOR = new zzc();
    }

    public ComplianceOptions(int i, int i2, int i3, boolean z) {
        this.f13028a = i;
        this.f13029b = i2;
        this.f13030c = i3;
        this.f13031d = z;
    }

    @NonNull
    @KeepForSdk
    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ComplianceOptions)) {
            return false;
        }
        ComplianceOptions complianceOptions = (ComplianceOptions) obj;
        if (this.f13028a != complianceOptions.f13028a || this.f13029b != complianceOptions.f13029b || this.f13030c != complianceOptions.f13030c || this.f13031d != complianceOptions.f13031d) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f13028a), Integer.valueOf(this.f13029b), Integer.valueOf(this.f13030c), Boolean.valueOf(this.f13031d));
    }

    @NonNull
    @KeepForSdk
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setCallerProductId(this.f13028a);
        builder.setDataOwnerProductId(this.f13029b);
        builder.setProcessingReason(this.f13030c);
        builder.setIsUserData(this.f13031d);
        return builder;
    }

    @NonNull
    public final String toString() {
        return "ComplianceOptions{callerProductId=" + this.f13028a + ", dataOwnerProductId=" + this.f13029b + ", processingReason=" + this.f13030c + ", isUserData=" + this.f13031d + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13028a);
        SafeParcelWriter.writeInt(parcel, 2, this.f13029b);
        SafeParcelWriter.writeInt(parcel, 3, this.f13030c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f13031d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    @KeepForSdk
    public static final Builder newBuilder(@NonNull Context context) {
        return newBuilder();
    }
}
