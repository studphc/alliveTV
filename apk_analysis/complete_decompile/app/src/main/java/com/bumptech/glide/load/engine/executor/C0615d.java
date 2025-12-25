package com.bumptech.glide.load.engine.executor;

import android.util.Log;
import com.bumptech.glide.load.engine.executor.GlideExecutor;

/* renamed from: com.bumptech.glide.load.engine.executor.d */
/* loaded from: classes.dex */
public final class C0615d implements GlideExecutor.UncaughtThrowableStrategy {
    @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
    public final void handle(Throwable th) {
        if (th != null && Log.isLoggable("GlideExecutor", 6)) {
            Log.e("GlideExecutor", "Request threw uncaught throwable", th);
        }
    }
}
