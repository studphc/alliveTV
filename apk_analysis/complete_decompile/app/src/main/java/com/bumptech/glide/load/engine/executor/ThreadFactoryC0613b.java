package com.bumptech.glide.load.engine.executor;

import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.bumptech.glide.load.engine.executor.b */
/* loaded from: classes.dex */
public final class ThreadFactoryC0613b implements ThreadFactory {

    /* renamed from: a */
    public final String f8759a;

    /* renamed from: b */
    public final GlideExecutor.UncaughtThrowableStrategy f8760b;

    /* renamed from: c */
    public final boolean f8761c;

    /* renamed from: d */
    public int f8762d;

    public ThreadFactoryC0613b(String str, GlideExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
        this.f8759a = str;
        this.f8760b = uncaughtThrowableStrategy;
        this.f8761c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable runnable) {
        C0612a c0612a;
        c0612a = new C0612a(this, runnable, "glide-" + this.f8759a + "-thread-" + this.f8762d);
        this.f8762d = this.f8762d + 1;
        return c0612a;
    }
}
