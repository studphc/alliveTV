package p000;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: p0 */
/* loaded from: classes2.dex */
public abstract class AbstractC1670p0 extends AbstractFuture implements InterfaceC1605o0 {
    @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        super.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @CanIgnoreReturnValue
    public final boolean cancel(boolean z) {
        return super.cancel(z);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @CanIgnoreReturnValue
    public final Object get() {
        return super.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final boolean isCancelled() {
        return super.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final boolean isDone() {
        return super.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @CanIgnoreReturnValue
    public final Object get(long j, TimeUnit timeUnit) {
        return super.get(j, timeUnit);
    }
}
