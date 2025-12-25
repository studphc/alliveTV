package p000;

import android.os.Handler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class bz0 implements Runnable, Disposable {

    /* renamed from: a */
    public final Handler f8199a;

    /* renamed from: b */
    public final Runnable f8200b;

    /* renamed from: c */
    public volatile boolean f8201c;

    public bz0(Handler handler, Runnable runnable) {
        this.f8199a = handler;
        this.f8200b = runnable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f8199a.removeCallbacks(this);
        this.f8201c = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f8201c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f8200b.run();
        } catch (Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }
}
