package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import p000.v60;

/* renamed from: com.google.android.exoplayer2.drm.h */
/* loaded from: classes.dex */
public final class C0666h implements DrmSessionManager {
    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        if (format.drmInitData == null) {
            return null;
        }
        return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final int getCryptoType(Format format) {
        if (format.drmInitData != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final /* synthetic */ DrmSessionManager.DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return v60.m7807a(this, eventDispatcher, format);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final /* synthetic */ void prepare() {
        v60.m7808b(this);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final /* synthetic */ void release() {
        v60.m7809c(this);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void setPlayer(Looper looper, PlayerId playerId) {
    }
}
