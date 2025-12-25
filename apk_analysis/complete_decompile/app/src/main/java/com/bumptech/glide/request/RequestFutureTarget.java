package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: a */
    public final int f9042a;

    /* renamed from: b */
    public final int f9043b;

    /* renamed from: c */
    public Object f9044c;

    /* renamed from: d */
    public Request f9045d;

    /* renamed from: e */
    public boolean f9046e;

    /* renamed from: f */
    public boolean f9047f;

    /* renamed from: g */
    public boolean f9048g;

    /* renamed from: h */
    public GlideException f9049h;

    public RequestFutureTarget(int i, int i2) {
        this.f9042a = i;
        this.f9043b = i2;
    }

    /* renamed from: a */
    public final synchronized Object m2386a(Long l) {
        try {
            if (!isDone()) {
                Util.assertBackgroundThread();
            }
            if (!this.f9046e) {
                if (!this.f9048g) {
                    if (this.f9047f) {
                        return this.f9044c;
                    }
                    if (l == null) {
                        wait(0L);
                    } else if (l.longValue() > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long longValue = l.longValue() + currentTimeMillis;
                        while (!isDone() && currentTimeMillis < longValue) {
                            wait(longValue - currentTimeMillis);
                            currentTimeMillis = System.currentTimeMillis();
                        }
                    }
                    if (!Thread.interrupted()) {
                        if (!this.f9048g) {
                            if (!this.f9046e) {
                                if (this.f9047f) {
                                    return this.f9044c;
                                }
                                throw new TimeoutException();
                            }
                            throw new CancellationException();
                        }
                        throw new ExecutionException(this.f9049h);
                    }
                    throw new InterruptedException();
                }
                throw new ExecutionException(this.f9049h);
            }
            throw new CancellationException();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f9046e = true;
                notifyAll();
                Request request = null;
                if (z) {
                    Request request2 = this.f9045d;
                    this.f9045d = null;
                    request = request2;
                }
                if (request != null) {
                    request.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return (R) m2386a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public synchronized Request getRequest() {
        return this.f9045d;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f9042a, this.f9043b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f9046e;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f9046e && !this.f9047f) {
            if (!this.f9048g) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@NonNull R r, @Nullable Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(@Nullable Request request) {
        this.f9045d = request;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.f9048g = true;
        this.f9049h = glideException;
        notifyAll();
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.f9047f = true;
        this.f9044c = r;
        notifyAll();
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) {
        return (R) m2386a(Long.valueOf(timeUnit.toMillis(j)));
    }
}
