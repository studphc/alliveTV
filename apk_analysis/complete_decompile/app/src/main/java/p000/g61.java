package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class g61 extends ForwardingFuture implements ListenableFuture {

    /* renamed from: e */
    public static final ExecutorService f17555e = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build());

    /* renamed from: a */
    public final Executor f17556a;

    /* renamed from: b */
    public final ExecutionList f17557b = new ExecutionList();

    /* renamed from: c */
    public final AtomicBoolean f17558c = new AtomicBoolean(false);

    /* renamed from: d */
    public final Future f17559d;

    public g61(Future future, Executor executor) {
        this.f17559d = (Future) Preconditions.checkNotNull(future);
        this.f17556a = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        ExecutionList executionList = this.f17557b;
        executionList.add(runnable, executor);
        if (this.f17558c.compareAndSet(false, true)) {
            if (this.f17559d.isDone()) {
                executionList.execute();
            } else {
                this.f17556a.execute(new RunnableC0006a5(22, this));
            }
        }
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f17559d;
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    public final Future delegate() {
        return this.f17559d;
    }
}
