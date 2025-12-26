package p000;

import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class az0 extends Scheduler.Worker {

    /* renamed from: a */
    public final Handler f7816a;

    /* renamed from: b */
    public final boolean f7817b;

    /* renamed from: c */
    public volatile boolean f7818c;

    public az0(Handler handler, boolean z) {
        this.f7816a = handler;
        this.f7817b = z;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f7818c = true;
        this.f7816a.removeCallbacksAndMessages(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f7818c;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                if (this.f7818c) {
                    return g50.m4919a();
                }
                Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
                Handler handler = this.f7816a;
                bz0 bz0Var = new bz0(handler, onSchedule);
                Message obtain = Message.obtain(handler, bz0Var);
                obtain.obj = this;
                if (this.f7817b) {
                    obtain.setAsynchronous(true);
                }
                this.f7816a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.f7818c) {
                    this.f7816a.removeCallbacks(bz0Var);
                    return g50.m4919a();
                }
                return bz0Var;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }
}
