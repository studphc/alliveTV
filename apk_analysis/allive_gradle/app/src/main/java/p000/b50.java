package p000;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes2.dex */
public final class b50 implements Executor {

    /* renamed from: a */
    public final CoroutineDispatcher f7901a;

    public b50(CoroutineDispatcher coroutineDispatcher) {
        this.f7901a = coroutineDispatcher;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineDispatcher coroutineDispatcher = this.f7901a;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            coroutineDispatcher.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public final String toString() {
        return this.f7901a.toString();
    }
}
