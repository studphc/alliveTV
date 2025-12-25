package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import p000.m83;

/* loaded from: classes.dex */
public final class PendingResults {
    @NonNull
    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(@NonNull R r, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        m83 m83Var = new m83(r, googleApiClient);
        m83Var.setResult(r);
        return m83Var;
    }

    @NonNull
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@NonNull R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        BasePendingResult basePendingResult = new BasePendingResult((GoogleApiClient) null);
        basePendingResult.setResult(r);
        return new OptionalPendingResultImpl(basePendingResult);
    }

    @NonNull
    public static <R extends Result> PendingResult<R> canceledPendingResult(@NonNull R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        m83 m83Var = new m83(r);
        m83Var.cancel();
        return m83Var;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@NonNull R r, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        BasePendingResult basePendingResult = new BasePendingResult(googleApiClient);
        basePendingResult.setResult(r);
        return new OptionalPendingResultImpl(basePendingResult);
    }

    @NonNull
    public static PendingResult<Status> immediatePendingResult(@NonNull Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(@NonNull Status status, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
