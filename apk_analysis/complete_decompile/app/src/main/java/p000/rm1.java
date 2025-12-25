package p000;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
public final class rm1 implements MediaSourceEventListener, DrmSessionEventListener {

    /* renamed from: a */
    public final tm1 f26026a;

    /* renamed from: b */
    public MediaSourceEventListener.EventDispatcher f26027b;

    /* renamed from: c */
    public DrmSessionEventListener.EventDispatcher f26028c;

    /* renamed from: d */
    public final /* synthetic */ um1 f26029d;

    public rm1(um1 um1Var, tm1 tm1Var) {
        this.f26029d = um1Var;
        this.f26027b = um1Var.f27368f;
        this.f26028c = um1Var.f27369g;
        this.f26026a = tm1Var;
    }

    /* renamed from: a */
    public final boolean m7287a(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        tm1 tm1Var = this.f26026a;
        MediaSource.MediaPeriodId mediaPeriodId2 = null;
        if (mediaPeriodId != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= tm1Var.f26878c.size()) {
                    break;
                }
                if (((MediaSource.MediaPeriodId) tm1Var.f26878c.get(i2)).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                    mediaPeriodId2 = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getConcatenatedUid(tm1Var.f26877b, mediaPeriodId.periodUid));
                    break;
                }
                i2++;
            }
            if (mediaPeriodId2 == null) {
                return false;
            }
        }
        int i3 = i + tm1Var.f26879d;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f26027b;
        int i4 = eventDispatcher.windowIndex;
        um1 um1Var = this.f26029d;
        if (i4 != i3 || !Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
            this.f26027b = um1Var.f27368f.withParameters(i3, mediaPeriodId2, 0L);
        }
        DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f26028c;
        if (eventDispatcher2.windowIndex != i3 || !Util.areEqual(eventDispatcher2.mediaPeriodId, mediaPeriodId2)) {
            this.f26028c = um1Var.f27369g.withParameters(i3, mediaPeriodId2);
            return true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26027b.downstreamFormatChanged(mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26028c.drmKeysLoaded();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26028c.drmKeysRemoved();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26028c.drmKeysRestored();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        t60.m7462d(this, i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26028c.drmSessionManagerError(exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26028c.drmSessionReleased();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26027b.loadCanceled(loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26027b.loadCompleted(loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26027b.loadError(loadEventInfo, mediaLoadData, iOException, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26027b.loadStarted(loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26027b.upstreamDiscarded(mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        if (m7287a(i, mediaPeriodId)) {
            this.f26028c.drmSessionAcquired(i2);
        }
    }
}
