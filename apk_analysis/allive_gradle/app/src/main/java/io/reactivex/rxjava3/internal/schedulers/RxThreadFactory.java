package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import p000.AbstractC1726qj;

/* loaded from: classes2.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: a */
    public final String f19860a;

    /* renamed from: b */
    public final int f19861b;

    /* renamed from: c */
    public final boolean f19862c;

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        Thread thread;
        String str = this.f19860a + '-' + incrementAndGet();
        if (this.f19862c) {
            thread = new Thread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.f19861b);
        thread.setDaemon(true);
        return thread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return AbstractC1726qj.m7061q(new StringBuilder("RxThreadFactory["), this.f19860a, "]");
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.f19860a = str;
        this.f19861b = i;
        this.f19862c = z;
    }
}
