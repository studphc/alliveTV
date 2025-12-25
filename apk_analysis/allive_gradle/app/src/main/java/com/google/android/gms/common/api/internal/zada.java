package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import p000.p73;
import p000.xy1;

/* loaded from: classes.dex */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* renamed from: g */
    public final WeakReference f13291g;

    /* renamed from: h */
    public final p73 f13292h;

    /* renamed from: a */
    public ResultTransform f13285a = null;

    /* renamed from: b */
    public zada f13286b = null;

    /* renamed from: c */
    public volatile ResultCallbacks f13287c = null;

    /* renamed from: d */
    public PendingResult f13288d = null;

    /* renamed from: e */
    public final Object f13289e = new Object();

    /* renamed from: f */
    public Status f13290f = null;

    /* renamed from: i */
    public boolean f13293i = false;

    public zada(WeakReference weakReference) {
        Looper mainLooper;
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.f13291g = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        if (googleApiClient != null) {
            mainLooper = googleApiClient.getLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.f13292h = new p73(this, mainLooper, 2);
    }

    /* renamed from: d */
    public static final void m3123d(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    /* renamed from: a */
    public final void m3124a(Status status) {
        synchronized (this.f13289e) {
            this.f13290f = status;
            m3126c(status);
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z;
        synchronized (this.f13289e) {
            boolean z2 = false;
            if (this.f13287c == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call andFinally() twice.");
            if (this.f13285a == null) {
                z2 = true;
            }
            Preconditions.checkState(z2, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f13287c = resultCallbacks;
            m3125b();
        }
    }

    /* renamed from: b */
    public final void m3125b() {
        if (this.f13285a != null || this.f13287c != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f13291g.get();
            if (!this.f13293i && this.f13285a != null && googleApiClient != null) {
                googleApiClient.zao(this);
                this.f13293i = true;
            }
            Status status = this.f13290f;
            if (status != null) {
                m3126c(status);
                return;
            }
            PendingResult pendingResult = this.f13288d;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    /* renamed from: c */
    public final void m3126c(Status status) {
        boolean z;
        synchronized (this.f13289e) {
            try {
                ResultTransform resultTransform = this.f13285a;
                if (resultTransform != null) {
                    ((zada) Preconditions.checkNotNull(this.f13286b)).m3124a((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
                } else {
                    GoogleApiClient googleApiClient = (GoogleApiClient) this.f13291g.get();
                    if (this.f13287c != null && googleApiClient != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ((ResultCallbacks) Preconditions.checkNotNull(this.f13287c)).onFailure(status);
                    }
                }
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        boolean z;
        synchronized (this.f13289e) {
            try {
                if (result.getStatus().isSuccess()) {
                    if (this.f13285a != null) {
                        zaco.zaa().submit(new xy1(21, this, result));
                    } else {
                        GoogleApiClient googleApiClient = (GoogleApiClient) this.f13291g.get();
                        if (this.f13287c != null && googleApiClient != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            ((ResultCallbacks) Preconditions.checkNotNull(this.f13287c)).onSuccess(result);
                        }
                    }
                } else {
                    m3124a(result.getStatus());
                    m3123d(result);
                }
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z;
        zada zadaVar;
        synchronized (this.f13289e) {
            boolean z2 = false;
            if (this.f13285a == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() twice.");
            if (this.f13287c == null) {
                z2 = true;
            }
            Preconditions.checkState(z2, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f13285a = resultTransform;
            zadaVar = new zada(this.f13291g);
            this.f13286b = zadaVar;
            m3125b();
        }
        return zadaVar;
    }

    public final void zai(PendingResult pendingResult) {
        synchronized (this.f13289e) {
            this.f13288d = pendingResult;
            m3125b();
        }
    }
}
