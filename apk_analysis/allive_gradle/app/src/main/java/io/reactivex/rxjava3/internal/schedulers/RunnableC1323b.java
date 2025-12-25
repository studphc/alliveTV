package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.reactivex.rxjava3.internal.schedulers.b */
/* loaded from: classes2.dex */
public final class RunnableC1323b extends AtomicBoolean implements Runnable, Disposable {
    private static final long serialVersionUID = -2421395018820541164L;

    /* renamed from: a */
    public final Runnable f19881a;

    public RunnableC1323b(Runnable runnable) {
        this.f19881a = runnable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        lazySet(true);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get()) {
            return;
        }
        try {
            this.f19881a.run();
        } finally {
        }
    }
}
