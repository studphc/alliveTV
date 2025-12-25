package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import p000.ai2;
import p000.ef3;

/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {

    /* renamed from: a */
    public final ef3 f14452a = new ef3();

    public TaskCompletionSource() {
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.f14452a;
    }

    public void setException(@NonNull Exception exc) {
        this.f14452a.m4713a(exc);
    }

    public void setResult(@Nullable TResult tresult) {
        this.f14452a.m4714b(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        ef3 ef3Var = this.f14452a;
        ef3Var.getClass();
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (ef3Var.f16794a) {
            try {
                if (ef3Var.f16796c) {
                    return false;
                }
                ef3Var.f16796c = true;
                ef3Var.f16799f = exc;
                ef3Var.f16795b.m7902d(ef3Var);
                return true;
            } finally {
            }
        }
    }

    public boolean trySetResult(@Nullable TResult tresult) {
        return this.f14452a.m4716d(tresult);
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new ai2(25, this));
    }
}
