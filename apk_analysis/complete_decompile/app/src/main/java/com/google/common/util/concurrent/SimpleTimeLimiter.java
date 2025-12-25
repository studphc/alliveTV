package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.li2;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class SimpleTimeLimiter implements TimeLimiter {

    /* renamed from: a */
    public final ExecutorService f15341a;

    public SimpleTimeLimiter(ExecutorService executorService) {
        this.f15341a = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* renamed from: a */
    public static void m4343a(long j) {
        boolean z;
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "timeout must be positive: %s", j);
    }

    /* renamed from: b */
    public static void m4344b(Exception exc, boolean z) {
        Throwable cause = exc.getCause();
        if (cause != null) {
            if (z) {
                cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
            }
            if (!(cause instanceof Exception)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw exc;
            }
            throw ((Exception) cause);
        }
        throw exc;
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        m4343a(j);
        Future<T> submit = this.f15341a.submit(callable);
        try {
            return (T) Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof Error)) {
                if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                }
                throw new ExecutionException(cause);
            }
            throw new ExecutionError((Error) cause);
        } catch (TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        m4343a(j);
        Future<T> submit = this.f15341a.submit(callable);
        try {
            return submit.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof Error)) {
                if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                }
                throw new ExecutionException(cause);
            }
            throw new ExecutionError((Error) cause);
        } catch (TimeoutException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        m4343a(j);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        HashSet newHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            int length = exceptionTypes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (exceptionTypes[i] == InterruptedException.class) {
                    newHashSet.add(method);
                    break;
                }
                i++;
            }
        }
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new li2(this, t, j, timeUnit, newHashSet)));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        m4343a(j);
        Future<?> submit = this.f15341a.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            }
            throw new UncheckedExecutionException(cause);
        } catch (TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        m4343a(j);
        Future<?> submit = this.f15341a.submit(runnable);
        try {
            submit.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            }
            throw new UncheckedExecutionException(cause);
        } catch (TimeoutException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        }
    }
}
