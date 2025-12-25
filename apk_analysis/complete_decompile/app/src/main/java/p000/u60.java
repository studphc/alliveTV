package p000;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* loaded from: classes.dex */
public final /* synthetic */ class u60 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f27119a;

    /* renamed from: b */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f27120b;

    /* renamed from: c */
    public final /* synthetic */ DrmSessionEventListener f27121c;

    public /* synthetic */ u60(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i) {
        this.f27119a = i;
        this.f27120b = eventDispatcher;
        this.f27121c = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f27119a) {
            case 0:
                DrmSessionEventListener.EventDispatcher eventDispatcher = this.f27120b;
                this.f27121c.onDrmKeysRemoved(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                return;
            case 1:
                DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f27120b;
                this.f27121c.onDrmKeysRestored(eventDispatcher2.windowIndex, eventDispatcher2.mediaPeriodId);
                return;
            case 2:
                DrmSessionEventListener.EventDispatcher eventDispatcher3 = this.f27120b;
                this.f27121c.onDrmKeysLoaded(eventDispatcher3.windowIndex, eventDispatcher3.mediaPeriodId);
                return;
            default:
                DrmSessionEventListener.EventDispatcher eventDispatcher4 = this.f27120b;
                this.f27121c.onDrmSessionReleased(eventDispatcher4.windowIndex, eventDispatcher4.mediaPeriodId);
                return;
        }
    }
}
