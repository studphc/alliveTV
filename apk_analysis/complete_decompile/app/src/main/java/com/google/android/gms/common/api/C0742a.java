package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* renamed from: com.google.android.gms.common.api.a */
/* loaded from: classes.dex */
public final class C0742a implements PendingResult.StatusListener {

    /* renamed from: a */
    public final /* synthetic */ Batch f13076a;

    public C0742a(Batch batch) {
        this.f13076a = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Status status2;
        synchronized (this.f13076a.f13021s) {
            try {
                if (this.f13076a.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.f13076a.f13019q = true;
                } else if (!status.isSuccess()) {
                    this.f13076a.f13018p = true;
                }
                Batch batch = this.f13076a;
                int i = batch.f13017o - 1;
                batch.f13017o = i;
                if (i == 0) {
                    if (batch.f13019q) {
                        super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                    } else {
                        if (batch.f13018p) {
                            status2 = new Status(13);
                        } else {
                            status2 = Status.RESULT_SUCCESS;
                        }
                        Batch batch2 = this.f13076a;
                        batch2.setResult(new BatchResult(status2, batch2.f13020r));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
