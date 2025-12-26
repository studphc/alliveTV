package p000;

import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class cz0 extends Scheduler {

    /* renamed from: c */
    public final Handler f16183c;

    /* renamed from: d */
    public final boolean f16184d;

    public cz0(Handler handler, boolean z) {
        this.f16183c = handler;
        this.f16184d = z;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public final Scheduler.Worker createWorker() {
        return new az0(this.f16183c, this.f16184d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
                Handler handler = this.f16183c;
                bz0 bz0Var = new bz0(handler, onSchedule);
                Message obtain = Message.obtain(handler, bz0Var);
                if (this.f16184d) {
                    obtain.setAsynchronous(true);
                }
                handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                return bz0Var;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }
}
