package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes2.dex */
public abstract class InstallationResponse {

    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class Builder {
        @NonNull
        public abstract InstallationResponse build();

        @NonNull
        public abstract Builder setAuthToken(@NonNull TokenResult tokenResult);

        @NonNull
        public abstract Builder setFid(@NonNull String str);

        @NonNull
        public abstract Builder setRefreshToken(@NonNull String str);

        @NonNull
        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder setUri(@NonNull String str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class ResponseCode {
        public static final ResponseCode BAD_CONFIG;

        /* renamed from: OK */
        public static final ResponseCode f15620OK;

        /* renamed from: a */
        public static final /* synthetic */ ResponseCode[] f15621a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, com.google.firebase.installations.remote.InstallationResponse$ResponseCode] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, com.google.firebase.installations.remote.InstallationResponse$ResponseCode] */
        static {
            ?? r2 = new Enum("OK", 0);
            f15620OK = r2;
            ?? r3 = new Enum("BAD_CONFIG", 1);
            BAD_CONFIG = r3;
            f15621a = new ResponseCode[]{r2, r3};
        }

        public static ResponseCode valueOf(String str) {
            return (ResponseCode) Enum.valueOf(ResponseCode.class, str);
        }

        public static ResponseCode[] values() {
            return (ResponseCode[]) f15621a.clone();
        }
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public abstract TokenResult getAuthToken();

    @Nullable
    public abstract String getFid();

    @Nullable
    public abstract String getRefreshToken();

    @Nullable
    public abstract ResponseCode getResponseCode();

    @Nullable
    public abstract String getUri();

    @NonNull
    public abstract Builder toBuilder();
}
