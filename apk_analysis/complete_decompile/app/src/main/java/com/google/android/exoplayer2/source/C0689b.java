package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import p000.t60;

/* renamed from: com.google.android.exoplayer2.source.b */
/* loaded from: classes.dex */
public final class C0689b implements MediaSourceEventListener, DrmSessionEventListener {

    /* renamed from: a */
    public final Object f11126a;

    /* renamed from: b */
    public MediaSourceEventListener.EventDispatcher f11127b;

    /* renamed from: c */
    public DrmSessionEventListener.EventDispatcher f11128c;

    /* renamed from: d */
    public final /* synthetic */ CompositeMediaSource f11129d;

    public C0689b(CompositeMediaSource compositeMediaSource, Object obj) {
        this.f11129d = compositeMediaSource;
        this.f11127b = compositeMediaSource.createEventDispatcher(null);
        this.f11128c = compositeMediaSource.createDrmEventDispatcher(null);
        this.f11126a = obj;
    }

    /* renamed from: a */
    public final boolean m2762a(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2;
        Object obj = this.f11126a;
        CompositeMediaSource compositeMediaSource = this.f11129d;
        if (mediaPeriodId != null) {
            mediaPeriodId2 = compositeMediaSource.getMediaPeriodIdForChildMediaPeriodId(obj, mediaPeriodId);
            if (mediaPeriodId2 == null) {
                return false;
            }
        } else {
            mediaPeriodId2 = null;
        }
        int windowIndexForChildWindowIndex = compositeMediaSource.getWindowIndexForChildWindowIndex(obj, i);
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f11127b;
        if (eventDispatcher.windowIndex != windowIndexForChildWindowIndex || !Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
            this.f11127b = compositeMediaSource.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2, 0L);
        }
        DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f11128c;
        if (eventDispatcher2.windowIndex != windowIndexForChildWindowIndex || !Util.areEqual(eventDispatcher2.mediaPeriodId, mediaPeriodId2)) {
            this.f11128c = compositeMediaSource.createDrmEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2);
            return true;
        }
        return true;
    }

    /* renamed from: b */
    public final MediaLoadData m2763b(MediaLoadData mediaLoadData) {
        long j = mediaLoadData.mediaStartTimeMs;
        CompositeMediaSource compositeMediaSource = this.f11129d;
        Object obj = this.f11126a;
        long mediaTimeForChildMediaTime = compositeMediaSource.getMediaTimeForChildMediaTime(obj, j);
        long mediaTimeForChildMediaTime2 = compositeMediaSource.getMediaTimeForChildMediaTime(obj, mediaLoadData.mediaEndTimeMs);
        if (mediaTimeForChildMediaTime == mediaLoadData.mediaStartTimeMs && mediaTimeForChildMediaTime2 == mediaLoadData.mediaEndTimeMs) {
            return mediaLoadData;
        }
        return new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11127b.downstreamFormatChanged(m2763b(mediaLoadData));
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11128c.drmKeysLoaded();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11128c.drmKeysRemoved();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11128c.drmKeysRestored();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        t60.m7462d(this, i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11128c.drmSessionManagerError(exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11128c.drmSessionReleased();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11127b.loadCanceled(loadEventInfo, m2763b(mediaLoadData));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11127b.loadCompleted(loadEventInfo, m2763b(mediaLoadData));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11127b.loadError(loadEventInfo, m2763b(mediaLoadData), iOException, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11127b.loadStarted(loadEventInfo, m2763b(mediaLoadData));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11127b.upstreamDiscarded(m2763b(mediaLoadData));
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        if (m2762a(i, mediaPeriodId)) {
            this.f11128c.drmSessionAcquired(i2);
        }
    }
}
