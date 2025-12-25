package com.google.android.exoplayer2.upstream;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class Loader implements LoaderErrorThrower {

    /* renamed from: a */
    public final ExecutorService f12511a;

    /* renamed from: b */
    public HandlerC0734b f12512b;

    /* renamed from: c */
    public IOException f12513c;
    public static final LoadErrorAction RETRY = createRetryAction(false, C0643C.TIME_UNSET);
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, C0643C.TIME_UNSET);
    public static final LoadErrorAction DONT_RETRY = new LoadErrorAction(2, C0643C.TIME_UNSET);
    public static final LoadErrorAction DONT_RETRY_FATAL = new LoadErrorAction(3, C0643C.TIME_UNSET);

    /* loaded from: classes.dex */
    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t, long j, long j2, boolean z);

        void onLoadCompleted(T t, long j, long j2);

        LoadErrorAction onLoadError(T t, long j, long j2, IOException iOException, int i);
    }

    /* loaded from: classes.dex */
    public static final class LoadErrorAction {

        /* renamed from: a */
        public final int f12514a;

        /* renamed from: b */
        public final long f12515b;

        public LoadErrorAction(int i, long j) {
            this.f12514a = i;
            this.f12515b = j;
        }

        public boolean isRetry() {
            int i = this.f12514a;
            if (i == 0 || i == 1) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface Loadable {
        void cancelLoad();

        void load();
    }

    /* loaded from: classes.dex */
    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    /* loaded from: classes.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.f12511a = Util.newSingleThreadExecutor("ExoPlayer:Loader:" + str);
    }

    public static LoadErrorAction createRetryAction(boolean z, long j) {
        return new LoadErrorAction(z ? 1 : 0, j);
    }

    public void cancelLoading() {
        ((HandlerC0734b) Assertions.checkStateNotNull(this.f12512b)).m2989a(false);
    }

    public void clearFatalError() {
        this.f12513c = null;
    }

    public boolean hasFatalError() {
        if (this.f12513c != null) {
            return true;
        }
        return false;
    }

    public boolean isLoading() {
        if (this.f12512b != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void release() {
        release(null);
    }

    public <T extends Loadable> long startLoading(T t, Callback<T> callback, int i) {
        boolean z;
        Looper looper = (Looper) Assertions.checkStateNotNull(Looper.myLooper());
        this.f12513c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HandlerC0734b handlerC0734b = new HandlerC0734b(this, looper, t, callback, i, elapsedRealtime);
        if (this.f12512b == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f12512b = handlerC0734b;
        handlerC0734b.f12573e = null;
        this.f12511a.execute((Runnable) Assertions.checkNotNull(handlerC0734b));
        return elapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) {
        IOException iOException = this.f12513c;
        if (iOException == null) {
            HandlerC0734b handlerC0734b = this.f12512b;
            if (handlerC0734b != null) {
                if (i == Integer.MIN_VALUE) {
                    i = handlerC0734b.f12569a;
                }
                IOException iOException2 = handlerC0734b.f12573e;
                if (iOException2 != null && handlerC0734b.f12574f > i) {
                    throw iOException2;
                }
                return;
            }
            return;
        }
        throw iOException;
    }

    public void release(@Nullable ReleaseCallback releaseCallback) {
        HandlerC0734b handlerC0734b = this.f12512b;
        if (handlerC0734b != null) {
            handlerC0734b.m2989a(true);
        }
        ExecutorService executorService = this.f12511a;
        if (releaseCallback != null) {
            executorService.execute(new RunnableC0735c(releaseCallback));
        }
        executorService.shutdown();
    }
}
