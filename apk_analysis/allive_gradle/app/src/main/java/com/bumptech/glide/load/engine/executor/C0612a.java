package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;

/* renamed from: com.bumptech.glide.load.engine.executor.a */
/* loaded from: classes.dex */
public final class C0612a extends Thread {

    /* renamed from: a */
    public final /* synthetic */ ThreadFactoryC0613b f8758a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0612a(ThreadFactoryC0613b threadFactoryC0613b, Runnable runnable, String str) {
        super(runnable, str);
        this.f8758a = threadFactoryC0613b;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(9);
        ThreadFactoryC0613b threadFactoryC0613b = this.f8758a;
        if (threadFactoryC0613b.f8761c) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            threadFactoryC0613b.f8760b.handle(th);
        }
    }
}
