package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class BatchResult implements Result {

    /* renamed from: a */
    public final Status f13024a;

    /* renamed from: b */
    public final PendingResult[] f13025b;

    public BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.f13024a = status;
        this.f13025b = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f13024a;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public <R extends Result> R take(@NonNull BatchResultToken<R> batchResultToken) {
        boolean z;
        int i = batchResultToken.mId;
        PendingResult[] pendingResultArr = this.f13025b;
        if (i < pendingResultArr.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "The result token does not belong to this batch");
        return (R) pendingResultArr[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
