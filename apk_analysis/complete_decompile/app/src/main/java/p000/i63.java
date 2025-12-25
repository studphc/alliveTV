package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.C0994g;
import com.google.common.util.concurrent.Callables;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class i63 implements ExecutorService {

    /* renamed from: a */
    public final ExecutorService f18322a;

    public i63(ScheduledExecutorService scheduledExecutorService) {
        this.f18322a = (ExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
    }

    /* renamed from: a */
    public final ImmutableList m5169a(Collection collection) {
        ImmutableList.Builder builder = ImmutableList.builder();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Callable callable = (Callable) it.next();
            C0994g c0994g = ((to1) this).f26911c;
            Preconditions.checkNotNull(c0994g);
            Preconditions.checkNotNull(callable);
            builder.add((ImmutableList.Builder) new CallableC1764rk(0, c0994g, callable));
        }
        return builder.build();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f18322a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f18322a.execute(Callables.m4318a(runnable, ((to1) this).f26911c));
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection) {
        return this.f18322a.invokeAll(m5169a(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection) {
        return this.f18322a.invokeAny(m5169a(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f18322a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f18322a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f18322a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.f18322a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Callable callable) {
        Callable callable2 = (Callable) Preconditions.checkNotNull(callable);
        C0994g c0994g = ((to1) this).f26911c;
        Preconditions.checkNotNull(c0994g);
        Preconditions.checkNotNull(callable2);
        return this.f18322a.submit(new CallableC1764rk(0, c0994g, callable2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.f18322a.invokeAll(m5169a(collection), j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.f18322a.invokeAny(m5169a(collection), j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        return this.f18322a.submit(Callables.m4318a(runnable, ((to1) this).f26911c));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable, Object obj) {
        return this.f18322a.submit(Callables.m4318a(runnable, ((to1) this).f26911c), obj);
    }
}
