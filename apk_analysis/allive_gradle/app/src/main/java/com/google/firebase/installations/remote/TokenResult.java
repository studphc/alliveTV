package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes2.dex */
public abstract class TokenResult {

    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class Builder {
        @NonNull
        public abstract TokenResult build();

        @NonNull
        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder setToken(@NonNull String str);

        @NonNull
        public abstract Builder setTokenExpirationTimestamp(long j);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class ResponseCode {
        public static final ResponseCode AUTH_ERROR;
        public static final ResponseCode BAD_CONFIG;

        /* renamed from: OK */
        public static final ResponseCode f15622OK;

        /* renamed from: a */
        public static final /* synthetic */ ResponseCode[] f15623a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, com.google.firebase.installations.remote.TokenResult$ResponseCode] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, com.google.firebase.installations.remote.TokenResult$ResponseCode] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, com.google.firebase.installations.remote.TokenResult$ResponseCode] */
        static {
            ?? r3 = new Enum("OK", 0);
            f15622OK = r3;
            ?? r4 = new Enum("BAD_CONFIG", 1);
            BAD_CONFIG = r4;
            ?? r5 = new Enum("AUTH_ERROR", 2);
            AUTH_ERROR = r5;
            f15623a = new ResponseCode[]{r3, r4, r5};
        }

        public static ResponseCode valueOf(String str) {
            return (ResponseCode) Enum.valueOf(ResponseCode.class, str);
        }

        public static ResponseCode[] values() {
            return (ResponseCode[]) f15623a.clone();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.installations.remote.TokenResult$Builder, com.google.firebase.installations.remote.c] */
    @NonNull
    public static Builder builder() {
        ?? builder = new Builder();
        builder.f15635b = 0L;
        return builder;
    }

    @Nullable
    public abstract ResponseCode getResponseCode();

    @Nullable
    public abstract String getToken();

    @NonNull
    public abstract long getTokenExpirationTimestamp();

    @NonNull
    public abstract Builder toBuilder();
}
