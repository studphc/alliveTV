package com.google.android.gms.common.util.concurrent;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executor;

@KeepForSdk
/* loaded from: classes.dex */
public class HandlerExecutor implements Executor {

    /* renamed from: a */
    public final zzh f13667a;

    @KeepForSdk
    public HandlerExecutor(@NonNull Looper looper) {
        this.f13667a = new zzh(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        this.f13667a.post(runnable);
    }
}
