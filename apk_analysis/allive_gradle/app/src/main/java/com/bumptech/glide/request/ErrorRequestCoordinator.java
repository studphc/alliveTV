package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a */
    public final Object f9034a;

    /* renamed from: b */
    public final RequestCoordinator f9035b;

    /* renamed from: c */
    public volatile Request f9036c;

    /* renamed from: d */
    public volatile Request f9037d;

    /* renamed from: e */
    public RequestCoordinator.RequestState f9038e;

    /* renamed from: f */
    public RequestCoordinator.RequestState f9039f;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f9038e = requestState;
        this.f9039f = requestState;
        this.f9034a = obj;
        this.f9035b = requestCoordinator;
    }

    /* renamed from: a */
    public final boolean m2385a(Request request) {
        if (!request.equals(this.f9036c) && (this.f9038e != RequestCoordinator.RequestState.FAILED || !request.equals(this.f9037d))) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.f9034a) {
            try {
                RequestCoordinator.RequestState requestState = this.f9038e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f9038e = requestState2;
                    this.f9036c.begin();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator requestCoordinator = this.f9035b;
                z = true;
                if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
                    z2 = false;
                    if (z2 || !m2385a(request)) {
                        z = false;
                    }
                }
                z2 = true;
                if (z2) {
                }
                z = false;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator requestCoordinator = this.f9035b;
                z = true;
                if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
                    z2 = false;
                    if (z2 || !m2385a(request)) {
                        z = false;
                    }
                }
                z2 = true;
                if (z2) {
                }
                z = false;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator requestCoordinator = this.f9035b;
                z = true;
                if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
                    z2 = false;
                    if (z2 || !m2385a(request)) {
                        z = false;
                    }
                }
                z2 = true;
                if (z2) {
                }
                z = false;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f9034a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.f9038e = requestState;
                this.f9036c.clear();
                if (this.f9039f != requestState) {
                    this.f9039f = requestState;
                    this.f9037d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator requestCoordinator2 = this.f9035b;
                if (requestCoordinator2 != null) {
                    requestCoordinator = requestCoordinator2.getRoot();
                } else {
                    requestCoordinator = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return requestCoordinator;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.f9034a) {
            try {
                if (!this.f9036c.isAnyResourceSet() && !this.f9037d.isAnyResourceSet()) {
                    z = false;
                }
                z = true;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator.RequestState requestState = this.f9038e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                if (requestState == requestState2 && this.f9039f == requestState2) {
                    z = true;
                } else {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator.RequestState requestState = this.f9038e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                if (requestState != requestState2 && this.f9039f != requestState2) {
                    z = false;
                }
                z = true;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.f9036c.isEquivalentTo(errorRequestCoordinator.f9036c) || !this.f9037d.isEquivalentTo(errorRequestCoordinator.f9037d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.f9034a) {
            try {
                RequestCoordinator.RequestState requestState = this.f9038e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2 && this.f9039f != requestState2) {
                    z = false;
                }
                z = true;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.f9034a) {
            try {
                if (!request.equals(this.f9037d)) {
                    this.f9038e = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator.RequestState requestState = this.f9039f;
                    RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState != requestState2) {
                        this.f9039f = requestState2;
                        this.f9037d.begin();
                    }
                    return;
                }
                this.f9039f = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f9035b;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestFailed(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        synchronized (this.f9034a) {
            try {
                if (request.equals(this.f9036c)) {
                    this.f9038e = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.f9037d)) {
                    this.f9039f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.f9035b;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestSuccess(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.f9034a) {
            try {
                RequestCoordinator.RequestState requestState = this.f9038e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.f9038e = RequestCoordinator.RequestState.PAUSED;
                    this.f9036c.pause();
                }
                if (this.f9039f == requestState2) {
                    this.f9039f = RequestCoordinator.RequestState.PAUSED;
                    this.f9037d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.f9036c = request;
        this.f9037d = request2;
    }
}
