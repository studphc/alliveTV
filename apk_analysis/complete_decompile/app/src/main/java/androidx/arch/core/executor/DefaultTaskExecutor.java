package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p000.j10;
import p000.k10;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    public final Object f1635a = new Object();

    /* renamed from: b */
    public final ExecutorService f1636b = Executors.newFixedThreadPool(4, new j10(0));

    /* renamed from: c */
    public volatile Handler f1637c;

    /* renamed from: a */
    public static Handler m323a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return k10.m5475a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable runnable) {
        this.f1636b.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable runnable) {
        if (this.f1637c == null) {
            synchronized (this.f1635a) {
                try {
                    if (this.f1637c == null) {
                        this.f1637c = m323a(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f1637c.post(runnable);
    }
}
