package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;

/* loaded from: classes.dex */
public abstract /* synthetic */ class v60 {
    /* renamed from: a */
    public static DrmSessionManager.DrmSessionReference m7807a(DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionManager.DrmSessionReference.EMPTY;
    }

    /* renamed from: d */
    public static DrmSessionManager m7810d() {
        return DrmSessionManager.DRM_UNSUPPORTED;
    }

    /* renamed from: b */
    public static void m7808b(DrmSessionManager drmSessionManager) {
    }

    /* renamed from: c */
    public static void m7809c(DrmSessionManager drmSessionManager) {
    }
}
