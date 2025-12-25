package com.google.android.exoplayer2.analytics;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import p000.e10;

/* loaded from: classes.dex */
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final Supplier<String> DEFAULT_SESSION_ID_GENERATOR = new e10(0);

    /* renamed from: h */
    public static final Random f9521h = new Random();

    /* renamed from: a */
    public final Timeline.Window f9522a;

    /* renamed from: b */
    public final Timeline.Period f9523b;

    /* renamed from: c */
    public final HashMap f9524c;

    /* renamed from: d */
    public final Supplier f9525d;

    /* renamed from: e */
    public PlaybackSessionManager.Listener f9526e;

    /* renamed from: f */
    public Timeline f9527f;

    /* renamed from: g */
    public String f9528g;

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    /* renamed from: a */
    public final C0645a m2423a(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        HashMap hashMap = this.f9524c;
        C0645a c0645a = null;
        long j = Long.MAX_VALUE;
        for (C0645a c0645a2 : hashMap.values()) {
            if (c0645a2.f9577c == -1 && i == c0645a2.f9576b && mediaPeriodId != null) {
                c0645a2.f9577c = mediaPeriodId.windowSequenceNumber;
            }
            if (c0645a2.m2430a(i, mediaPeriodId)) {
                long j2 = c0645a2.f9577c;
                if (j2 != -1 && j2 >= j) {
                    if (j2 == j && ((C0645a) Util.castNonNull(c0645a)).f9578d != null && c0645a2.f9578d != null) {
                        c0645a = c0645a2;
                    }
                } else {
                    c0645a = c0645a2;
                    j = j2;
                }
            }
        }
        if (c0645a == null) {
            String str = (String) this.f9525d.get();
            C0645a c0645a3 = new C0645a(this, str, i, mediaPeriodId);
            hashMap.put(str, c0645a3);
            return c0645a3;
        }
        return c0645a;
    }

    /* renamed from: b */
    public final void m2424b(AnalyticsListener.EventTime eventTime) {
        MediaSource.MediaPeriodId mediaPeriodId;
        if (eventTime.timeline.isEmpty()) {
            this.f9528g = null;
            return;
        }
        C0645a c0645a = (C0645a) this.f9524c.get(this.f9528g);
        String str = m2423a(eventTime.windowIndex, eventTime.mediaPeriodId).f9575a;
        this.f9528g = str;
        updateSessions(eventTime);
        MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (c0645a != null) {
                long j = c0645a.f9577c;
                MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
                if (j == mediaPeriodId3.windowSequenceNumber && (mediaPeriodId = c0645a.f9578d) != null && mediaPeriodId.adGroupIndex == mediaPeriodId3.adGroupIndex && mediaPeriodId.adIndexInAdGroup == mediaPeriodId3.adIndexInAdGroup) {
                    return;
                }
            }
            MediaSource.MediaPeriodId mediaPeriodId4 = eventTime.mediaPeriodId;
            this.f9526e.onAdPlaybackStarted(eventTime, m2423a(eventTime.windowIndex, new MediaSource.MediaPeriodId(mediaPeriodId4.periodUid, mediaPeriodId4.windowSequenceNumber)).f9575a, str);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        C0645a c0645a = (C0645a) this.f9524c.get(str);
        if (c0645a == null) {
            return false;
        }
        int i = eventTime.windowIndex;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (c0645a.f9577c == -1 && i == c0645a.f9576b && mediaPeriodId != null) {
            c0645a.f9577c = mediaPeriodId.windowSequenceNumber;
        }
        return c0645a.m2430a(i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void finishAllSessions(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        this.f9528g = null;
        Iterator it = this.f9524c.values().iterator();
        while (it.hasNext()) {
            C0645a c0645a = (C0645a) it.next();
            it.remove();
            if (c0645a.f9579e && (listener = this.f9526e) != null) {
                listener.onSessionFinished(eventTime, c0645a.f9575a, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    @Nullable
    public synchronized String getActiveSessionId() {
        return this.f9528g;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return m2423a(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.f9523b).windowIndex, mediaPeriodId).f9575a;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void setListener(PlaybackSessionManager.Listener listener) {
        this.f9526e = listener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r3.windowSequenceNumber < r4) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:4:0x0005, B:9:0x0014, B:12:0x0024, B:14:0x002c, B:19:0x0036, B:22:0x003e, B:24:0x0048, B:25:0x004c, B:27:0x0051, B:29:0x0057, B:31:0x006e, B:32:0x00c9, B:34:0x00cd, B:35:0x00dc, B:37:0x00e6, B:39:0x00ea), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateSessions(AnalyticsListener.EventTime eventTime) {
        C0645a c0645a;
        AnalyticsListener.EventTime eventTime2;
        try {
            Assertions.checkNotNull(this.f9526e);
        } finally {
        }
        if (eventTime.timeline.isEmpty()) {
            return;
        }
        C0645a c0645a2 = (C0645a) this.f9524c.get(this.f9528g);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null && c0645a2 != null) {
            long j = c0645a2.f9577c;
            if (j == -1) {
                if (c0645a2.f9576b != eventTime.windowIndex) {
                    return;
                }
            }
        }
        C0645a m2423a = m2423a(eventTime.windowIndex, mediaPeriodId);
        if (this.f9528g == null) {
            this.f9528g = m2423a.f9575a;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
            MediaSource.MediaPeriodId mediaPeriodId4 = new MediaSource.MediaPeriodId(mediaPeriodId3.periodUid, mediaPeriodId3.windowSequenceNumber, mediaPeriodId3.adGroupIndex);
            C0645a m2423a2 = m2423a(eventTime.windowIndex, mediaPeriodId4);
            if (!m2423a2.f9579e) {
                m2423a2.f9579e = true;
                eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.f9523b);
                this.f9526e.onSessionCreated(new AnalyticsListener.EventTime(eventTime.realtimeMs, eventTime.timeline, eventTime.windowIndex, mediaPeriodId4, Math.max(0L, Util.usToMs(this.f9523b.getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex)) + this.f9523b.getPositionInWindowMs()), eventTime.currentTimeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs), m2423a2.f9575a);
                c0645a = m2423a;
                if (c0645a.f9579e) {
                    c0645a.f9579e = true;
                    eventTime2 = eventTime;
                    this.f9526e.onSessionCreated(eventTime2, c0645a.f9575a);
                } else {
                    eventTime2 = eventTime;
                }
                if (c0645a.f9575a.equals(this.f9528g) && !c0645a.f9580f) {
                    c0645a.f9580f = true;
                    this.f9526e.onSessionActive(eventTime2, c0645a.f9575a);
                }
            }
        }
        c0645a = m2423a;
        if (c0645a.f9579e) {
        }
        if (c0645a.f9575a.equals(this.f9528g)) {
            c0645a.f9580f = true;
            this.f9526e.onSessionActive(eventTime2, c0645a.f9575a);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        boolean z;
        boolean z2;
        try {
            Assertions.checkNotNull(this.f9526e);
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            Iterator it = this.f9524c.values().iterator();
            while (it.hasNext()) {
                C0645a c0645a = (C0645a) it.next();
                if (c0645a.m2431b(eventTime)) {
                    it.remove();
                    if (c0645a.f9579e) {
                        boolean equals = c0645a.f9575a.equals(this.f9528g);
                        if (z && equals && c0645a.f9580f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (equals) {
                            this.f9528g = null;
                        }
                        this.f9526e.onSessionFinished(eventTime, c0645a.f9575a, z2);
                    }
                }
            }
            m2424b(eventTime);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithTimelineChange(AnalyticsListener.EventTime eventTime) {
        try {
            Assertions.checkNotNull(this.f9526e);
            Timeline timeline = this.f9527f;
            this.f9527f = eventTime.timeline;
            Iterator it = this.f9524c.values().iterator();
            while (it.hasNext()) {
                C0645a c0645a = (C0645a) it.next();
                if (c0645a.m2432c(timeline, this.f9527f) && !c0645a.m2431b(eventTime)) {
                }
                it.remove();
                if (c0645a.f9579e) {
                    if (c0645a.f9575a.equals(this.f9528g)) {
                        this.f9528g = null;
                    }
                    this.f9526e.onSessionFinished(eventTime, c0645a.f9575a, false);
                }
            }
            m2424b(eventTime);
        } catch (Throwable th) {
            throw th;
        }
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.f9525d = supplier;
        this.f9522a = new Timeline.Window();
        this.f9523b = new Timeline.Period();
        this.f9524c = new HashMap();
        this.f9527f = Timeline.EMPTY;
    }
}
