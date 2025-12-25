package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1986xk;
import p000.C2023yk;
import p000.b51;

@Metadata(m5568d1 = {}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class JobKt {
    @NotNull
    public static final CompletableJob Job(@Nullable Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return Job(job);
    }

    public static final void cancel(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancel(coroutineContext, cancellationException);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object join = job.join(continuation);
        if (join != b51.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return join;
    }

    public static final void cancelChildren(@NotNull Job job, @Nullable CancellationException cancellationException) {
        Iterator<Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancelChildren(job, cancellationException);
    }

    public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Future<?> future) {
        cancellableContinuation.invokeOnCancellation(new C1986xk(0, future));
    }

    @InternalCoroutinesApi
    @NotNull
    public static final DisposableHandle cancelFutureOnCompletion(@NotNull Job job, @NotNull Future<?> future) {
        return job.invokeOnCompletion(new C2023yk(future));
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new DisposeOnCompletion(disposableHandle));
    }

    public static final void ensureActive(@NotNull Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean isActive(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    /* renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ Job m8853Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return Job(job);
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        cancel(job, str, th);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(job, th);
    }

    public static final void ensureActive(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            ensureActive(job);
        }
    }

    public static final void cancel(@NotNull Job job, @NotNull String str, @Nullable Throwable th) {
        job.cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return cancel(coroutineContext, th);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        CoroutineContext.Element element = coroutineContext.get(Job.INSTANCE);
        JobSupport jobSupport = element instanceof JobSupport ? (JobSupport) element : null;
        if (jobSupport == null) {
            return false;
        }
        if (th == null) {
            th = new JobCancellationException("Job was cancelled", null, jobSupport);
        }
        jobSupport.cancelInternal(th);
        return true;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(Job job, Throwable th) {
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(th == null ? new JobCancellationException("Job was cancelled", null, job) : th);
            }
        }
    }

    public static final void cancelChildren(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Sequence<Job> children;
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        Iterator<Job> it = children.iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(th == null ? new JobCancellationException("Job was cancelled", null, job) : th);
            }
        }
    }
}
