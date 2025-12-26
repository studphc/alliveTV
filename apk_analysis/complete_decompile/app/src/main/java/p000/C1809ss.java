package p000;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

/* renamed from: ss */
/* loaded from: classes2.dex */
public final class C1809ss extends AbstractCoroutine implements BiFunction {

    /* renamed from: d */
    public final CompletableFuture f26541d;

    public C1809ss(CoroutineContext coroutineContext, CompletableFuture completableFuture) {
        super(coroutineContext, true, true);
        this.f26541d = completableFuture;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        Job.DefaultImpls.cancel$default((Job) this, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        this.f26541d.completeExceptionally(th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Object obj) {
        this.f26541d.complete(obj);
    }
}
