package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {

    /* renamed from: o */
    public int f13017o;

    /* renamed from: p */
    public boolean f13018p;

    /* renamed from: q */
    public boolean f13019q;

    /* renamed from: r */
    public final PendingResult[] f13020r;

    /* renamed from: s */
    public final Object f13021s;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final ArrayList f13022a = new ArrayList();

        /* renamed from: b */
        public final GoogleApiClient f13023b;

        public Builder(@NonNull GoogleApiClient googleApiClient) {
            this.f13023b = googleApiClient;
        }

        @NonNull
        @ResultIgnorabilityUnspecified
        public <R extends Result> BatchResultToken<R> add(@NonNull PendingResult<R> pendingResult) {
            ArrayList arrayList = this.f13022a;
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(arrayList.size());
            arrayList.add(pendingResult);
            return batchResultToken;
        }

        @NonNull
        public Batch build() {
            return new Batch(this.f13022a, this.f13023b);
        }
    }

    public /* synthetic */ Batch(ArrayList arrayList, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f13021s = new Object();
        int size = arrayList.size();
        this.f13017o = size;
        PendingResult[] pendingResultArr = new PendingResult[size];
        this.f13020r = pendingResultArr;
        if (!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                PendingResult pendingResult = (PendingResult) arrayList.get(i);
                this.f13020r[i] = pendingResult;
                pendingResult.addStatusListener(new C0742a(this));
            }
            return;
        }
        setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        int i = 0;
        while (true) {
            PendingResult[] pendingResultArr = this.f13020r;
            if (i < pendingResultArr.length) {
                pendingResultArr[i].cancel();
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    @NonNull
    public BatchResult createFailedResult(@NonNull Status status) {
        return new BatchResult(status, this.f13020r);
    }
}
