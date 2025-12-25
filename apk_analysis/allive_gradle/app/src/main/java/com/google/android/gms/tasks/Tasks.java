package com.google.android.gms.tasks;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.aa3;
import p000.ai2;
import p000.d40;
import p000.ed3;
import p000.ef3;
import p000.i93;
import p000.n93;

/* loaded from: classes.dex */
public final class Tasks {
    /* renamed from: a */
    public static Object m3751a(Task task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) m3751a(task);
        }
        ai2 ai2Var = new ai2(18);
        d40 d40Var = TaskExecutors.f14453a;
        task.addOnSuccessListener(d40Var, ai2Var);
        task.addOnFailureListener(d40Var, ai2Var);
        task.addOnCanceledListener(d40Var, ai2Var);
        ((CountDownLatch) ai2Var.f216b).await();
        return (TResult) m3751a(task);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> forCanceled() {
        ef3 ef3Var = new ef3();
        ef3Var.m4715c();
        return ef3Var;
    }

    @NonNull
    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        ef3 ef3Var = new ef3();
        ef3Var.m4713a(exc);
        return ef3Var;
    }

    @NonNull
    public static <TResult> Task<TResult> forResult(TResult tresult) {
        ef3 ef3Var = new ef3();
        ef3Var.m4714b(tresult);
        return ef3Var;
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> collection) {
        if (collection != null && !collection.isEmpty()) {
            Iterator<? extends Task<?>> it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new NullPointerException("null tasks are not accepted");
                }
            }
            ef3 ef3Var = new ef3();
            n93 n93Var = new n93(collection.size(), ef3Var);
            for (Task<?> task : collection) {
                d40 d40Var = TaskExecutors.f14453a;
                task.addOnSuccessListener(d40Var, n93Var);
                task.addOnFailureListener(d40Var, n93Var);
                task.addOnCanceledListener(d40Var, n93Var);
            }
            return ef3Var;
        }
        return forResult(null);
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> collection) {
        return whenAllComplete(TaskExecutors.MAIN_THREAD, collection);
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task> collection) {
        return whenAllSuccess(TaskExecutors.MAIN_THREAD, collection);
    }

    @NonNull
    public static <T> Task<T> withTimeout(@NonNull Task<T> task, long j, @NonNull TimeUnit timeUnit) {
        boolean z;
        Preconditions.checkNotNull(task, "Task must not be null");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Timeout must be positive");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        final aa3 aa3Var = new aa3();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(aa3Var);
        final zza zzaVar = new zza(Looper.getMainLooper());
        zzaVar.postDelayed(new Runnable() { // from class: com.google.android.gms.tasks.zzx
            @Override // java.lang.Runnable
            public final void run() {
                TaskCompletionSource.this.trySetException(new TimeoutException());
            }
        }, timeUnit.toMillis(j));
        task.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.tasks.zzy
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zza.this.removeCallbacksAndMessages(null);
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (task2.isSuccessful()) {
                    taskCompletionSource2.trySetResult(task2.getResult());
                } else {
                    if (task2.isCanceled()) {
                        aa3Var.f103a.m4716d(null);
                        return;
                    }
                    Exception exception = task2.getException();
                    exception.getClass();
                    taskCompletionSource2.trySetException(exception);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        ef3 ef3Var = new ef3();
        executor.execute(new ed3(5, ef3Var, callable, false));
        return ef3Var;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@NonNull Executor executor, @Nullable Collection<? extends Task<?>> collection) {
        if (collection != null && !collection.isEmpty()) {
            return whenAll(collection).continueWithTask(executor, new i93(collection, 1));
        }
        return forResult(Collections.emptyList());
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@NonNull Executor executor, @Nullable Collection<? extends Task> collection) {
        if (collection != null && !collection.isEmpty()) {
            return (Task<List<TResult>>) whenAll((Collection<? extends Task<?>>) collection).continueWith(executor, new i93(collection, 0));
        }
        return forResult(Collections.emptyList());
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@NonNull Executor executor, @Nullable Task<?>... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAllComplete(executor, Arrays.asList(taskArr));
        }
        return forResult(Collections.emptyList());
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@NonNull Executor executor, @Nullable Task... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAllSuccess(executor, Arrays.asList(taskArr));
        }
        return forResult(Collections.emptyList());
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAllComplete(Arrays.asList(taskArr));
        }
        return forResult(Collections.emptyList());
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAllSuccess(Arrays.asList(taskArr));
        }
        return forResult(Collections.emptyList());
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Task<?>... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAll(Arrays.asList(taskArr));
        }
        return forResult(null);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) m3751a(task);
        }
        ai2 ai2Var = new ai2(18);
        d40 d40Var = TaskExecutors.f14453a;
        task.addOnSuccessListener(d40Var, ai2Var);
        task.addOnFailureListener(d40Var, ai2Var);
        task.addOnCanceledListener(d40Var, ai2Var);
        if (((CountDownLatch) ai2Var.f216b).await(j, timeUnit)) {
            return (TResult) m3751a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
