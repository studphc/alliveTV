package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class bt0 extends FluentFuture {

    /* renamed from: h */
    public final ListenableFuture f8150h;

    public bt0(ListenableFuture listenableFuture) {
        this.f8150h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.f8150h.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f8150h.cancel(z);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final Object get() {
        return this.f8150h.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f8150h.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final boolean isDone() {
        return this.f8150h.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String toString() {
        return this.f8150h.toString();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.f8150h.get(j, timeUnit);
    }
}
