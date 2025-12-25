package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
/* loaded from: classes.dex */
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {

    @NonNull
    public static final TelemetryLoggingOptions zaa = builder().build();

    /* renamed from: a */
    public final String f13474a;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public String f13475a;

        @NonNull
        @KeepForSdk
        public TelemetryLoggingOptions build() {
            return new TelemetryLoggingOptions(this.f13475a);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder setApi(@Nullable String str) {
            this.f13475a = str;
            return this;
        }
    }

    public /* synthetic */ TelemetryLoggingOptions(String str) {
        this.f13474a = str;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.common.internal.TelemetryLoggingOptions$Builder, java.lang.Object] */
    @NonNull
    @KeepForSdk
    public static Builder builder() {
        return new Object();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        return Objects.equal(this.f13474a, ((TelemetryLoggingOptions) obj).f13474a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f13474a);
    }

    @NonNull
    public final Bundle zaa() {
        Bundle bundle = new Bundle();
        String str = this.f13474a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }
}
