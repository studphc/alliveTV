package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a */
    public final RequestCoordinator f9088a;

    /* renamed from: b */
    public final Object f9089b;

    /* renamed from: c */
    public volatile Request f9090c;

    /* renamed from: d */
    public volatile Request f9091d;

    /* renamed from: e */
    public RequestCoordinator.RequestState f9092e;

    /* renamed from: f */
    public RequestCoordinator.RequestState f9093f;

    /* renamed from: g */
    public boolean f9094g;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f9092e = requestState;
        this.f9093f = requestState;
        this.f9089b = obj;
        this.f9088a = requestCoordinator;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.f9089b) {
            try {
                this.f9094g = true;
                try {
                    if (this.f9092e != RequestCoordinator.RequestState.SUCCESS) {
                        RequestCoordinator.RequestState requestState = this.f9093f;
                        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState != requestState2) {
                            this.f9093f = requestState2;
                            this.f9091d.begin();
                        }
                    }
                    if (this.f9094g) {
                        RequestCoordinator.RequestState requestState3 = this.f9092e;
                        RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState3 != requestState4) {
                            this.f9092e = requestState4;
                            this.f9090c.begin();
                        }
                    }
                    this.f9094g = false;
                } catch (Throwable th) {
                    this.f9094g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.f9089b) {
            try {
                RequestCoordinator requestCoordinator = this.f9088a;
                z = true;
                if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
                    z2 = false;
                    if (z2 || !request.equals(this.f9090c) || this.f9092e == RequestCoordinator.RequestState.PAUSED) {
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
        synchronized (this.f9089b) {
            try {
                RequestCoordinator requestCoordinator = this.f9088a;
                z = true;
                if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
                    z2 = false;
                    if (z2 || !request.equals(this.f9090c) || isAnyResourceSet()) {
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
        synchronized (this.f9089b) {
            try {
                RequestCoordinator requestCoordinator = this.f9088a;
                z = true;
                if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
                    z2 = false;
                    if (z2 || (!request.equals(this.f9090c) && this.f9092e == RequestCoordinator.RequestState.SUCCESS)) {
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
        synchronized (this.f9089b) {
            this.f9094g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f9092e = requestState;
            this.f9093f = requestState;
            this.f9091d.clear();
            this.f9090c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f9089b) {
            try {
                RequestCoordinator requestCoordinator2 = this.f9088a;
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
        synchronized (this.f9089b) {
            try {
                if (!this.f9091d.isAnyResourceSet() && !this.f9090c.isAnyResourceSet()) {
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
        synchronized (this.f9089b) {
            if (this.f9092e == RequestCoordinator.RequestState.CLEARED) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.f9089b) {
            if (this.f9092e == RequestCoordinator.RequestState.SUCCESS) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        if (this.f9090c == null) {
            if (thumbnailRequestCoordinator.f9090c != null) {
                return false;
            }
        } else if (!this.f9090c.isEquivalentTo(thumbnailRequestCoordinator.f9090c)) {
            return false;
        }
        if (this.f9091d == null) {
            if (thumbnailRequestCoordinator.f9091d != null) {
                return false;
            }
        } else if (!this.f9091d.isEquivalentTo(thumbnailRequestCoordinator.f9091d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.f9089b) {
            if (this.f9092e == RequestCoordinator.RequestState.RUNNING) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.f9089b) {
            try {
                if (!request.equals(this.f9090c)) {
                    this.f9093f = RequestCoordinator.RequestState.FAILED;
                    return;
                }
                this.f9092e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f9088a;
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
        synchronized (this.f9089b) {
            try {
                if (request.equals(this.f9091d)) {
                    this.f9093f = RequestCoordinator.RequestState.SUCCESS;
                    return;
                }
                this.f9092e = RequestCoordinator.RequestState.SUCCESS;
                RequestCoordinator requestCoordinator = this.f9088a;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestSuccess(this);
                }
                if (!this.f9093f.f9041a) {
                    this.f9091d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.f9089b) {
            try {
                if (!this.f9093f.f9041a) {
                    this.f9093f = RequestCoordinator.RequestState.PAUSED;
                    this.f9091d.pause();
                }
                if (!this.f9092e.f9041a) {
                    this.f9092e = RequestCoordinator.RequestState.PAUSED;
                    this.f9090c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.f9090c = request;
        this.f9091d = request2;
    }
}
