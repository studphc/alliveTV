package io.reactivex.rxjava3.android;

import android.os.Looper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.RunnableC0006a5;

/* loaded from: classes2.dex */
public abstract class MainThreadDisposable implements Disposable {

    /* renamed from: a */
    public final AtomicBoolean f18480a = new AtomicBoolean();

    public static void verifyMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f18480a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                onDispose();
            } else {
                AndroidSchedulers.mainThread().scheduleDirect(new RunnableC0006a5(24, this));
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18480a.get();
    }

    public abstract void onDispose();
}
