package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import p000.RunnableC0583c7;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5569d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "<init>", "()V", "", "pause", "resume", "finish", "drainQueue", "", "canRun", "()Z", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "runnable", "dispatchAndEnqueue", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "lifecycle-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class DispatchQueue {

    /* renamed from: b */
    public boolean f6478b;

    /* renamed from: c */
    public boolean f6479c;

    /* renamed from: a */
    public boolean f6477a = true;

    /* renamed from: d */
    public final ArrayDeque f6480d = new ArrayDeque();

    @MainThread
    public final boolean canRun() {
        if (!this.f6478b && this.f6477a) {
            return false;
        }
        return true;
    }

    @AnyThread
    public final void dispatchAndEnqueue(@NotNull CoroutineContext context, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        if (!immediate.isDispatchNeeded(context) && !canRun()) {
            if (this.f6480d.offer(runnable)) {
                drainQueue();
                return;
            }
            throw new IllegalStateException("cannot enqueue any more runnables");
        }
        immediate.dispatch(context, new RunnableC0583c7(14, this, runnable));
    }

    @MainThread
    public final void drainQueue() {
        if (this.f6479c) {
            return;
        }
        try {
            this.f6479c = true;
            while (true) {
                ArrayDeque arrayDeque = this.f6480d;
                if (arrayDeque.isEmpty() || !canRun()) {
                    break;
                }
                Runnable runnable = (Runnable) arrayDeque.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } finally {
            this.f6479c = false;
        }
    }

    @MainThread
    public final void finish() {
        this.f6478b = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.f6477a = true;
    }

    @MainThread
    public final void resume() {
        if (!this.f6477a) {
            return;
        }
        if (!this.f6478b) {
            this.f6477a = false;
            drainQueue();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher");
    }
}
