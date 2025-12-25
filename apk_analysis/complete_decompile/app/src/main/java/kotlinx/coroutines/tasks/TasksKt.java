package kotlinx.coroutines.tasks;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1294i5;
import p000.C1725qi;
import p000.b51;
import p000.d40;
import p000.hs2;
import p000.is2;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t\u001a#\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5569d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "Lcom/google/android/gms/tasks/Task;", "asTask", "(Lkotlinx/coroutines/Deferred;)Lcom/google/android/gms/tasks/Task;", "asDeferred", "(Lcom/google/android/gms/tasks/Task;)Lkotlinx/coroutines/Deferred;", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "cancellationTokenSource", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;)Lkotlinx/coroutines/Deferred;", "await", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-play-services"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nTasks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tasks.kt\nkotlinx/coroutines/tasks/TasksKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,167:1\n314#2,11:168\n*S KotlinDebug\n*F\n+ 1 Tasks.kt\nkotlinx/coroutines/tasks/TasksKt\n*L\n139#1:168,11\n*E\n"})
/* loaded from: classes2.dex */
public final class TasksKt {
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.tasks.TasksKt$asDeferredImpl$3] */
    /* renamed from: a */
    public static final TasksKt$asDeferredImpl$3 m5753a(Task task, CancellationTokenSource cancellationTokenSource) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception == null) {
                if (task.isCanceled()) {
                    Job.DefaultImpls.cancel$default((Job) CompletableDeferred$default, (CancellationException) null, 1, (Object) null);
                } else {
                    CompletableDeferred$default.complete(task.getResult());
                }
            } else {
                CompletableDeferred$default.completeExceptionally(exception);
            }
        } else {
            task.addOnCompleteListener(d40.f16238b, new C1294i5(20, CompletableDeferred$default));
        }
        if (cancellationTokenSource != null) {
            CompletableDeferred$default.invokeOnCompletion(new hs2(cancellationTokenSource, 0));
        }
        return new Deferred<Object>() { // from class: kotlinx.coroutines.tasks.TasksKt$asDeferredImpl$3
            @Override // kotlinx.coroutines.Job
            @InternalCoroutinesApi
            @NotNull
            public ChildHandle attachChild(@NotNull ChildJob child) {
                return CompletableDeferred.this.attachChild(child);
            }

            @Override // kotlinx.coroutines.Deferred
            @Nullable
            public Object await(@NotNull Continuation<? super Object> continuation) {
                return CompletableDeferred.this.await(continuation);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
            public /* synthetic */ void cancel() {
                CompletableDeferred.this.cancel();
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <R> R fold(R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
                return (R) CompletableDeferred.this.fold(initial, operation);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            @Nullable
            public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
                return (E) CompletableDeferred.this.get(key);
            }

            @Override // kotlinx.coroutines.Job
            @InternalCoroutinesApi
            @NotNull
            public CancellationException getCancellationException() {
                return CompletableDeferred.this.getCancellationException();
            }

            @Override // kotlinx.coroutines.Job
            @NotNull
            public Sequence<Job> getChildren() {
                return CompletableDeferred.this.getChildren();
            }

            @Override // kotlinx.coroutines.Deferred
            @ExperimentalCoroutinesApi
            public Object getCompleted() {
                return CompletableDeferred.this.getCompleted();
            }

            @Override // kotlinx.coroutines.Deferred
            @ExperimentalCoroutinesApi
            @Nullable
            public Throwable getCompletionExceptionOrNull() {
                return CompletableDeferred.this.getCompletionExceptionOrNull();
            }

            @Override // kotlin.coroutines.CoroutineContext.Element
            @NotNull
            public CoroutineContext.Key<?> getKey() {
                return CompletableDeferred.this.getKey();
            }

            @Override // kotlinx.coroutines.Deferred
            @NotNull
            public SelectClause1<Object> getOnAwait() {
                return CompletableDeferred.this.getOnAwait();
            }

            @Override // kotlinx.coroutines.Job
            @NotNull
            public SelectClause0 getOnJoin() {
                return CompletableDeferred.this.getOnJoin();
            }

            @Override // kotlinx.coroutines.Job
            @Nullable
            public Job getParent() {
                return CompletableDeferred.this.getParent();
            }

            @Override // kotlinx.coroutines.Job
            @NotNull
            public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
                return CompletableDeferred.this.invokeOnCompletion(handler);
            }

            @Override // kotlinx.coroutines.Job
            public boolean isActive() {
                return CompletableDeferred.this.isActive();
            }

            @Override // kotlinx.coroutines.Job
            public boolean isCancelled() {
                return CompletableDeferred.this.isCancelled();
            }

            @Override // kotlinx.coroutines.Job
            public boolean isCompleted() {
                return CompletableDeferred.this.isCompleted();
            }

            @Override // kotlinx.coroutines.Job
            @Nullable
            public Object join(@NotNull Continuation<? super Unit> continuation) {
                return CompletableDeferred.this.join(continuation);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            @NotNull
            public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
                return CompletableDeferred.this.minusKey(key);
            }

            @Override // kotlin.coroutines.CoroutineContext
            @NotNull
            public CoroutineContext plus(@NotNull CoroutineContext context) {
                return CompletableDeferred.this.plus(context);
            }

            @Override // kotlinx.coroutines.Job
            public boolean start() {
                return CompletableDeferred.this.start();
            }

            @Override // kotlinx.coroutines.Job
            public void cancel(@Nullable CancellationException cause) {
                CompletableDeferred.this.cancel(cause);
            }

            @Override // kotlinx.coroutines.Job
            @InternalCoroutinesApi
            @NotNull
            public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
                return CompletableDeferred.this.invokeOnCompletion(onCancelling, invokeImmediately, handler);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
            @NotNull
            public Job plus(@NotNull Job other) {
                return CompletableDeferred.this.plus(other);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
            public /* synthetic */ boolean cancel(Throwable cause) {
                return CompletableDeferred.this.cancel(cause);
            }
        };
    }

    @NotNull
    public static final <T> Deferred<T> asDeferred(@NotNull Task<T> task) {
        return m5753a(task, null);
    }

    @NotNull
    public static final <T> Task<T> asTask(@NotNull Deferred<? extends T> deferred) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        deferred.invokeOnCompletion(new C1725qi(cancellationTokenSource, deferred, taskCompletionSource, 2));
        return taskCompletionSource.getTask();
    }

    @Nullable
    public static final <T> Object await(@NotNull Task<T> task, @NotNull Continuation<? super T> continuation) {
        return m5754b(task, null, continuation);
    }

    /* renamed from: b */
    public static final Object m5754b(Task task, CancellationTokenSource cancellationTokenSource, Continuation continuation) {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception == null) {
                if (!task.isCanceled()) {
                    return task.getResult();
                }
                throw new CancellationException("Task " + task + " was cancelled normally.");
            }
            throw exception;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        task.addOnCompleteListener(d40.f16238b, new is2(cancellableContinuationImpl));
        if (cancellationTokenSource != null) {
            cancellableContinuationImpl.invokeOnCancellation(new hs2(cancellationTokenSource, 1));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Deferred<T> asDeferred(@NotNull Task<T> task, @NotNull CancellationTokenSource cancellationTokenSource) {
        return m5753a(task, cancellationTokenSource);
    }

    @ExperimentalCoroutinesApi
    @Nullable
    public static final <T> Object await(@NotNull Task<T> task, @NotNull CancellationTokenSource cancellationTokenSource, @NotNull Continuation<? super T> continuation) {
        return m5754b(task, cancellationTokenSource, continuation);
    }
}
