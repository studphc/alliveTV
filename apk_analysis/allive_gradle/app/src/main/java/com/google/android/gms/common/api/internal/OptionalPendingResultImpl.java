package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
/* loaded from: classes.dex */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* renamed from: a */
    public final BasePendingResult f13144a;

    public OptionalPendingResultImpl(@NonNull PendingResult pendingResult) {
        this.f13144a = (BasePendingResult) pendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(@NonNull PendingResult.StatusListener statusListener) {
        this.f13144a.addStatusListener(statusListener);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final R await() {
        return (R) this.f13144a.await();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        this.f13144a.cancel();
    }

    @Override // com.google.android.gms.common.api.OptionalPendingResult
    @NonNull
    public final R get() {
        BasePendingResult basePendingResult = this.f13144a;
        if (basePendingResult.isReady()) {
            return (R) basePendingResult.await(0L, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        return this.f13144a.isCanceled();
    }

    @Override // com.google.android.gms.common.api.OptionalPendingResult
    public final boolean isDone() {
        return this.f13144a.isReady();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(@NonNull ResultCallback<? super R> resultCallback) {
        this.f13144a.setResultCallback(resultCallback);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        return this.f13144a.then(resultTransform);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final R await(long j, @NonNull TimeUnit timeUnit) {
        return (R) this.f13144a.await(j, timeUnit);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        this.f13144a.setResultCallback(resultCallback, j, timeUnit);
    }
}
