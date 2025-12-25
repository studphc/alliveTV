package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import p000.C1255h3;

/* loaded from: classes.dex */
public interface DrmSessionManager {
    public static final DrmSessionManager DRM_UNSUPPORTED;

    @Deprecated
    public static final DrmSessionManager DUMMY;

    /* loaded from: classes.dex */
    public interface DrmSessionReference {
        public static final DrmSessionReference EMPTY = new C1255h3(22);

        void release();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.exoplayer2.drm.DrmSessionManager] */
    static {
        ?? obj = new Object();
        DRM_UNSUPPORTED = obj;
        DUMMY = obj;
    }

    @Nullable
    DrmSession acquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int getCryptoType(Format format);

    DrmSessionReference preacquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    void prepare();

    void release();

    void setPlayer(Looper looper, PlayerId playerId);
}
