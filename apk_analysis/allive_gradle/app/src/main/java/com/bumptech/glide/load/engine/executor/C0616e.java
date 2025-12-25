package com.bumptech.glide.load.engine.executor;

import com.bumptech.glide.load.engine.executor.GlideExecutor;

/* renamed from: com.bumptech.glide.load.engine.executor.e */
/* loaded from: classes.dex */
public final class C0616e implements GlideExecutor.UncaughtThrowableStrategy {
    @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
    public final void handle(Throwable th) {
        if (th == null) {
        } else {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
