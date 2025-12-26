package p000;

import com.google.android.exoplayer2.drm.DrmSession;

/* loaded from: classes.dex */
public abstract /* synthetic */ class s60 {
    /* renamed from: a */
    public static boolean m7332a(DrmSession drmSession) {
        return false;
    }

    /* renamed from: b */
    public static void m7333b(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }
}
