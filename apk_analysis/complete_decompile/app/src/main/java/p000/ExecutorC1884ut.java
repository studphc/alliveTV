package p000;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.activity.ComponentActivity;
import java.util.concurrent.Executor;

/* renamed from: ut */
/* loaded from: classes.dex */
public final class ExecutorC1884ut implements Executor, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: b */
    public Runnable f27432b;

    /* renamed from: d */
    public final /* synthetic */ ComponentActivity f27434d;

    /* renamed from: a */
    public final long f27431a = SystemClock.uptimeMillis() + 10000;

    /* renamed from: c */
    public boolean f27433c = false;

    public ExecutorC1884ut(ComponentActivity componentActivity) {
        this.f27434d = componentActivity;
    }

    /* renamed from: a */
    public final void m7767a(View view) {
        if (!this.f27433c) {
            this.f27433c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f27432b = runnable;
        View decorView = this.f27434d.getWindow().getDecorView();
        if (this.f27433c) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
                return;
            } else {
                decorView.postInvalidate();
                return;
            }
        }
        decorView.postOnAnimation(new RunnableC0006a5(5, this));
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        Runnable runnable = this.f27432b;
        ComponentActivity componentActivity = this.f27434d;
        if (runnable != null) {
            runnable.run();
            this.f27432b = null;
            if (componentActivity.f467k.isFullyDrawnReported()) {
                this.f27433c = false;
                componentActivity.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        if (SystemClock.uptimeMillis() > this.f27431a) {
            this.f27433c = false;
            componentActivity.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27434d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
