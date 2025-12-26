package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1851tx;
import p000.i83;
import p000.y83;
import p000.ye0;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {

    /* renamed from: n */
    public static final C1851tx f13088n = new C1851tx(4);
    public static final /* synthetic */ int zad = 0;

    /* renamed from: a */
    public final Object f13089a;

    /* renamed from: b */
    public final CountDownLatch f13090b;

    /* renamed from: c */
    public final ArrayList f13091c;

    /* renamed from: d */
    public ResultCallback f13092d;

    /* renamed from: e */
    public final AtomicReference f13093e;

    /* renamed from: f */
    public Result f13094f;

    /* renamed from: g */
    public Status f13095g;

    /* renamed from: h */
    public volatile boolean f13096h;

    /* renamed from: i */
    public boolean f13097i;

    /* renamed from: j */
    public boolean f13098j;

    /* renamed from: k */
    public ICancelToken f13099k;

    /* renamed from: l */
    public volatile zada f13100l;

    /* renamed from: m */
    public boolean f13101m;

    @KeepName
    private y83 resultGuardian;

    @NonNull
    protected final CallbackHandler zab;

    @NonNull
    protected final WeakReference zac;

    @KeepForSdk
    @Deprecated
    public BasePendingResult(@NonNull Looper looper) {
        this.f13089a = new Object();
        this.f13090b = new CountDownLatch(1);
        this.f13091c = new ArrayList();
        this.f13093e = new AtomicReference();
        this.f13101m = false;
        this.zab = new CallbackHandler(looper);
        this.zac = new WeakReference(null);
    }

    public static void zal(@Nullable Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    /* renamed from: a */
    public final Result m3084a() {
        Result result;
        synchronized (this.f13089a) {
            Preconditions.checkState(!this.f13096h, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            result = this.f13094f;
            this.f13094f = null;
            this.f13092d = null;
            this.f13096h = true;
        }
        i83 i83Var = (i83) this.f13093e.getAndSet(null);
        if (i83Var != null) {
            i83Var.f18338a.f13294a.remove(this);
        }
        return (Result) Preconditions.checkNotNull(result);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(@NonNull PendingResult.StatusListener statusListener) {
        boolean z;
        if (statusListener != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Callback cannot be null.");
        synchronized (this.f13089a) {
            try {
                if (isReady()) {
                    statusListener.onComplete(this.f13095g);
                } else {
                    this.f13091c.add(statusListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    @ResultIgnorabilityUnspecified
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        Preconditions.checkState(!this.f13096h, "Result has already been consumed");
        Preconditions.checkState(this.f13100l == null, "Cannot await if then() has been called.");
        try {
            this.f13090b.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return (R) m3084a();
    }

    /* renamed from: b */
    public final void m3085b(Result result) {
        this.f13094f = result;
        this.f13095g = result.getStatus();
        this.f13099k = null;
        this.f13090b.countDown();
        if (this.f13097i) {
            this.f13092d = null;
        } else {
            ResultCallback resultCallback = this.f13092d;
            if (resultCallback == null) {
                if (this.f13094f instanceof Releasable) {
                    this.resultGuardian = new y83(this);
                }
            } else {
                this.zab.removeMessages(2);
                this.zab.zaa(resultCallback, m3084a());
            }
        }
        ArrayList arrayList = this.f13091c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((PendingResult.StatusListener) arrayList.get(i)).onComplete(this.f13095g);
        }
        arrayList.clear();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void cancel() {
        synchronized (this.f13089a) {
            if (!this.f13097i && !this.f13096h) {
                ICancelToken iCancelToken = this.f13099k;
                if (iCancelToken != null) {
                    try {
                        iCancelToken.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zal(this.f13094f);
                this.f13097i = true;
                m3085b(createFailedResult(Status.RESULT_CANCELED));
            }
        }
    }

    @NonNull
    @KeepForSdk
    public abstract R createFailedResult(@NonNull Status status);

    @KeepForSdk
    @Deprecated
    public final void forceFailureUnlessReady(@NonNull Status status) {
        synchronized (this.f13089a) {
            try {
                if (!isReady()) {
                    setResult(createFailedResult(status));
                    this.f13098j = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        boolean z;
        synchronized (this.f13089a) {
            z = this.f13097i;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isReady() {
        if (this.f13090b.getCount() == 0) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public final void setCancelToken(@NonNull ICancelToken iCancelToken) {
        synchronized (this.f13089a) {
            this.f13099k = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(@NonNull R r) {
        synchronized (this.f13089a) {
            try {
                if (!this.f13098j && !this.f13097i) {
                    isReady();
                    Preconditions.checkState(!isReady(), "Results have already been set");
                    Preconditions.checkState(!this.f13096h, "Result has already been consumed");
                    m3085b(r);
                    return;
                }
                zal(r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(@Nullable ResultCallback<? super R> resultCallback) {
        synchronized (this.f13089a) {
            try {
                if (resultCallback == null) {
                    this.f13092d = null;
                    return;
                }
                boolean z = true;
                Preconditions.checkState(!this.f13096h, "Result has already been consumed.");
                if (this.f13100l != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.zaa(resultCallback, m3084a());
                } else {
                    this.f13092d = resultCallback;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z;
        TransformedResult<S> then;
        Preconditions.checkState(!this.f13096h, "Result has already been consumed.");
        synchronized (this.f13089a) {
            try {
                boolean z2 = false;
                if (this.f13100l == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot call then() twice.");
                if (this.f13092d == null) {
                    z2 = true;
                }
                Preconditions.checkState(z2, "Cannot call then() if callbacks are set.");
                Preconditions.checkState(!this.f13097i, "Cannot call then() if result was canceled.");
                this.f13101m = true;
                this.f13100l = new zada(this.zac);
                then = this.f13100l.then(resultTransform);
                if (isReady()) {
                    this.zab.zaa(this.f13100l, m3084a());
                } else {
                    this.f13092d = this.f13100l;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return then;
    }

    public final void zak() {
        boolean z = true;
        if (!this.f13101m && !((Boolean) f13088n.get()).booleanValue()) {
            z = false;
        }
        this.f13101m = z;
    }

    public final boolean zam() {
        boolean isCanceled;
        synchronized (this.f13089a) {
            try {
                if (((GoogleApiClient) this.zac.get()) != null) {
                    if (!this.f13101m) {
                    }
                    isCanceled = isCanceled();
                }
                cancel();
                isCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return isCanceled;
    }

    public final void zan(@Nullable i83 i83Var) {
        this.f13093e.set(i83Var);
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class CallbackHandler<R extends Result> extends com.google.android.gms.internal.base.zau {
        public CallbackHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("BasePendingResult", ye0.m8291k(i, "Don't know how to handle message: "), new Exception());
                    return;
                } else {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
                    return;
                }
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.onResult(result);
            } catch (RuntimeException e) {
                BasePendingResult.zal(result);
                throw e;
            }
        }

        public final void zaa(@NonNull ResultCallback resultCallback, @NonNull Result result) {
            C1851tx c1851tx = BasePendingResult.f13088n;
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.checkNotNull(resultCallback), result)));
        }

        public CallbackHandler(@NonNull Looper looper) {
            super(looper);
        }
    }

    @KeepForSdk
    public BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.f13089a = new Object();
        this.f13090b = new CountDownLatch(1);
        this.f13091c = new ArrayList();
        this.f13093e = new AtomicReference();
        this.f13101m = false;
        this.zab = new CallbackHandler(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zac = new WeakReference(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    @ResultIgnorabilityUnspecified
    public final R await(long j, @NonNull TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.checkState(!this.f13096h, "Result has already been consumed.");
        Preconditions.checkState(this.f13100l == null, "Cannot await if then() has been called.");
        try {
            if (!this.f13090b.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return (R) m3084a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        synchronized (this.f13089a) {
            try {
                if (resultCallback == null) {
                    this.f13092d = null;
                    return;
                }
                boolean z = true;
                Preconditions.checkState(!this.f13096h, "Result has already been consumed.");
                if (this.f13100l != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.zaa(resultCallback, m3084a());
                } else {
                    this.f13092d = resultCallback;
                    CallbackHandler callbackHandler = this.zab;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public BasePendingResult(@NonNull CallbackHandler<R> callbackHandler) {
        this.f13089a = new Object();
        this.f13090b = new CountDownLatch(1);
        this.f13091c = new ArrayList();
        this.f13093e = new AtomicReference();
        this.f13101m = false;
        this.zab = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zac = new WeakReference(null);
    }
}
