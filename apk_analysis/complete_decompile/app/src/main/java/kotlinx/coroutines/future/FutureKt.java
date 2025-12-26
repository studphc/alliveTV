package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1807sq;
import p000.C1809ss;
import p000.C1891v;
import p000.b51;
import p000.ew0;
import p000.hd0;
import p000.ki0;

@Metadata(m5568d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a]\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b*\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013\u001a#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m5569d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "Ljava/util/concurrent/CompletableFuture;", "future", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "Lkotlinx/coroutines/Deferred;", "asCompletableFuture", "(Lkotlinx/coroutines/Deferred;)Ljava/util/concurrent/CompletableFuture;", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/Job;)Ljava/util/concurrent/CompletableFuture;", "Ljava/util/concurrent/CompletionStage;", "asDeferred", "(Ljava/util/concurrent/CompletionStage;)Lkotlinx/coroutines/Deferred;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
/* loaded from: classes2.dex */
public final class FutureKt {
    @NotNull
    public static final <T> CompletableFuture<T> asCompletableFuture(@NotNull Deferred<? extends T> deferred) {
        CompletableFuture<T> m5542j = ki0.m5542j();
        m5542j.handle((BiFunction) new ew0(1, deferred));
        deferred.invokeOnCompletion(new C1807sq(1, m5542j, deferred));
        return m5542j;
    }

    @NotNull
    public static final <T> Deferred<T> asDeferred(@NotNull CompletionStage<T> completionStage) {
        CompletableFuture completableFuture;
        boolean isDone;
        ExecutionException executionException;
        Throwable cause;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (isDone) {
            try {
                obj = completableFuture.get();
                return CompletableDeferredKt.CompletableDeferred(obj);
            } catch (Throwable th) {
                th = th;
                if (th instanceof ExecutionException) {
                    executionException = (ExecutionException) th;
                } else {
                    executionException = null;
                }
                if (executionException != null && (cause = executionException.getCause()) != null) {
                    th = cause;
                }
                CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                CompletableDeferred$default.completeExceptionally(th);
                return CompletableDeferred$default;
            }
        }
        CompletableDeferred CompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        completionStage.handle(new ew0(0, new hd0(2, CompletableDeferred$default2)));
        JobKt.cancelFutureOnCompletion(CompletableDeferred$default2, completableFuture);
        return CompletableDeferred$default2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [gw, java.util.function.BiFunction, java.lang.Object] */
    @Nullable
    public static final <T> Object await(@NotNull CompletionStage<T> completionStage, @NotNull Continuation<? super T> continuation) {
        CompletableFuture completableFuture;
        boolean isDone;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (isDone) {
            try {
                obj = completableFuture.get();
                return obj;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ?? obj2 = new Object();
        obj2.cont = cancellableContinuationImpl;
        completionStage.handle(obj2);
        cancellableContinuationImpl.invokeOnCancellation(new C1807sq(2, completableFuture, obj2));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public static final <T> CompletableFuture<T> future(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (!coroutineStart.isLazy()) {
            CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
            CompletableFuture<T> m5542j = ki0.m5542j();
            C1809ss c1809ss = new C1809ss(newCoroutineContext, m5542j);
            m5542j.handle((BiFunction) c1809ss);
            c1809ss.start(coroutineStart, c1809ss, function2);
            return m5542j;
        }
        throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @NotNull
    public static final CompletableFuture<Unit> asCompletableFuture(@NotNull Job job) {
        CompletableFuture<Unit> m5542j = ki0.m5542j();
        m5542j.handle((BiFunction<? super Unit, Throwable, ? extends U>) ((BiFunction) new ew0(1, job)));
        job.invokeOnCompletion(new C1891v(6, m5542j));
        return m5542j;
    }
}
