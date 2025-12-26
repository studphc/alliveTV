package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.internal.c */
/* loaded from: classes.dex */
public final class C0756c implements PendingResult.StatusListener {

    /* renamed from: a */
    public final /* synthetic */ PendingResult f13478a;

    /* renamed from: b */
    public final /* synthetic */ TaskCompletionSource f13479b;

    /* renamed from: c */
    public final /* synthetic */ PendingResultUtil.ResultConverter f13480c;

    public C0756c(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter) {
        this.f13478a = pendingResult;
        this.f13479b = taskCompletionSource;
        this.f13480c = resultConverter;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        boolean isSuccess = status.isSuccess();
        TaskCompletionSource taskCompletionSource = this.f13479b;
        if (isSuccess) {
            taskCompletionSource.setResult(this.f13480c.convert(this.f13478a.await(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
    }
}
