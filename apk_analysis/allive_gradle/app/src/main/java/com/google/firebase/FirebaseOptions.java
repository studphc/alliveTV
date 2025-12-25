package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* loaded from: classes2.dex */
public final class FirebaseOptions {

    /* renamed from: a */
    public final String f15464a;

    /* renamed from: b */
    public final String f15465b;

    /* renamed from: c */
    public final String f15466c;

    /* renamed from: d */
    public final String f15467d;

    /* renamed from: e */
    public final String f15468e;

    /* renamed from: f */
    public final String f15469f;

    /* renamed from: g */
    public final String f15470g;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public String f15471a;

        /* renamed from: b */
        public String f15472b;

        /* renamed from: c */
        public String f15473c;

        /* renamed from: d */
        public String f15474d;

        /* renamed from: e */
        public String f15475e;

        /* renamed from: f */
        public String f15476f;

        /* renamed from: g */
        public String f15477g;

        public Builder() {
        }

        @NonNull
        public FirebaseOptions build() {
            return new FirebaseOptions(this.f15472b, this.f15471a, this.f15473c, this.f15474d, this.f15475e, this.f15476f, this.f15477g);
        }

        @NonNull
        public Builder setApiKey(@NonNull String str) {
            this.f15471a = Preconditions.checkNotEmpty(str, "ApiKey must be set.");
            return this;
        }

        @NonNull
        public Builder setApplicationId(@NonNull String str) {
            this.f15472b = Preconditions.checkNotEmpty(str, "ApplicationId must be set.");
            return this;
        }

        @NonNull
        public Builder setDatabaseUrl(@Nullable String str) {
            this.f15473c = str;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setGaTrackingId(@Nullable String str) {
            this.f15474d = str;
            return this;
        }

        @NonNull
        public Builder setGcmSenderId(@Nullable String str) {
            this.f15475e = str;
            return this;
        }

        @NonNull
        public Builder setProjectId(@Nullable String str) {
            this.f15477g = str;
            return this;
        }

        @NonNull
        public Builder setStorageBucket(@Nullable String str) {
            this.f15476f = str;
            return this;
        }

        public Builder(@NonNull FirebaseOptions firebaseOptions) {
            this.f15472b = firebaseOptions.f15465b;
            this.f15471a = firebaseOptions.f15464a;
            this.f15473c = firebaseOptions.f15466c;
            this.f15474d = firebaseOptions.f15467d;
            this.f15475e = firebaseOptions.f15468e;
            this.f15476f = firebaseOptions.f15469f;
            this.f15477g = firebaseOptions.f15470g;
        }
    }

    public FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f15465b = str;
        this.f15464a = str2;
        this.f15466c = str3;
        this.f15467d = str4;
        this.f15468e = str5;
        this.f15469f = str6;
        this.f15470g = str7;
    }

    @Nullable
    public static FirebaseOptions fromResource(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!Objects.equal(this.f15465b, firebaseOptions.f15465b) || !Objects.equal(this.f15464a, firebaseOptions.f15464a) || !Objects.equal(this.f15466c, firebaseOptions.f15466c) || !Objects.equal(this.f15467d, firebaseOptions.f15467d) || !Objects.equal(this.f15468e, firebaseOptions.f15468e) || !Objects.equal(this.f15469f, firebaseOptions.f15469f) || !Objects.equal(this.f15470g, firebaseOptions.f15470g)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getApiKey() {
        return this.f15464a;
    }

    @NonNull
    public String getApplicationId() {
        return this.f15465b;
    }

    @Nullable
    public String getDatabaseUrl() {
        return this.f15466c;
    }

    @Nullable
    @KeepForSdk
    public String getGaTrackingId() {
        return this.f15467d;
    }

    @Nullable
    public String getGcmSenderId() {
        return this.f15468e;
    }

    @Nullable
    public String getProjectId() {
        return this.f15470g;
    }

    @Nullable
    public String getStorageBucket() {
        return this.f15469f;
    }

    public int hashCode() {
        return Objects.hashCode(this.f15465b, this.f15464a, this.f15466c, this.f15467d, this.f15468e, this.f15469f, this.f15470g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f15465b).add("apiKey", this.f15464a).add("databaseUrl", this.f15466c).add("gcmSenderId", this.f15468e).add("storageBucket", this.f15469f).add("projectId", this.f15470g).toString();
    }
}
