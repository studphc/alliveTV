package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import p000.ExecutorC0582c6;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: c */
    public static volatile ArchTaskExecutor f1630c;

    /* renamed from: d */
    public static final ExecutorC0582c6 f1631d = new ExecutorC0582c6(2);

    /* renamed from: e */
    public static final ExecutorC0582c6 f1632e = new ExecutorC0582c6(3);

    /* renamed from: a */
    public TaskExecutor f1633a;

    /* renamed from: b */
    public final DefaultTaskExecutor f1634b;

    public ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f1634b = defaultTaskExecutor;
        this.f1633a = defaultTaskExecutor;
    }

    @NonNull
    public static Executor getIOThreadExecutor() {
        return f1632e;
    }

    @NonNull
    public static ArchTaskExecutor getInstance() {
        if (f1630c != null) {
            return f1630c;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (f1630c == null) {
                    f1630c = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f1630c;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return f1631d;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable runnable) {
        this.f1633a.executeOnDiskIO(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.f1633a.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable runnable) {
        this.f1633a.postToMainThread(runnable);
    }

    public void setDelegate(@Nullable TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.f1634b;
        }
        this.f1633a = taskExecutor;
    }
}
