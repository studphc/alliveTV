package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaSource;

/* renamed from: com.google.android.exoplayer2.analytics.a */
/* loaded from: classes.dex */
public final class C0645a {

    /* renamed from: a */
    public final String f9575a;

    /* renamed from: b */
    public int f9576b;

    /* renamed from: c */
    public long f9577c;

    /* renamed from: d */
    public final MediaSource.MediaPeriodId f9578d;

    /* renamed from: e */
    public boolean f9579e;

    /* renamed from: f */
    public boolean f9580f;

    /* renamed from: g */
    public final /* synthetic */ DefaultPlaybackSessionManager f9581g;

    public C0645a(DefaultPlaybackSessionManager defaultPlaybackSessionManager, String str, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        long j;
        this.f9581g = defaultPlaybackSessionManager;
        this.f9575a = str;
        this.f9576b = i;
        if (mediaPeriodId == null) {
            j = -1;
        } else {
            j = mediaPeriodId.windowSequenceNumber;
        }
        this.f9577c = j;
        if (mediaPeriodId != null && mediaPeriodId.isAd()) {
            this.f9578d = mediaPeriodId;
        }
    }

    /* renamed from: a */
    public final boolean m2430a(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId == null) {
            if (i != this.f9576b) {
                return false;
            }
            return true;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = this.f9578d;
        if (mediaPeriodId2 == null) {
            if (mediaPeriodId.isAd() || mediaPeriodId.windowSequenceNumber != this.f9577c) {
                return false;
            }
            return true;
        }
        if (mediaPeriodId.windowSequenceNumber != mediaPeriodId2.windowSequenceNumber || mediaPeriodId.adGroupIndex != mediaPeriodId2.adGroupIndex || mediaPeriodId.adIndexInAdGroup != mediaPeriodId2.adIndexInAdGroup) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public final boolean m2431b(AnalyticsListener.EventTime eventTime) {
        long j = this.f9577c;
        if (j == -1) {
            return false;
        }
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId == null) {
            if (this.f9576b == eventTime.windowIndex) {
                return false;
            }
            return true;
        }
        if (mediaPeriodId.windowSequenceNumber > j) {
            return true;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = this.f9578d;
        if (mediaPeriodId2 == null) {
            return false;
        }
        int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(mediaPeriodId2.periodUid);
        MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
        if (mediaPeriodId3.windowSequenceNumber < mediaPeriodId2.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
            return false;
        }
        if (indexOfPeriod > indexOfPeriod2) {
            return true;
        }
        if (mediaPeriodId3.isAd()) {
            MediaSource.MediaPeriodId mediaPeriodId4 = eventTime.mediaPeriodId;
            int i = mediaPeriodId4.adGroupIndex;
            int i2 = mediaPeriodId4.adIndexInAdGroup;
            int i3 = mediaPeriodId2.adGroupIndex;
            if (i <= i3 && (i != i3 || i2 <= mediaPeriodId2.adIndexInAdGroup)) {
                return false;
            }
            return true;
        }
        int i4 = eventTime.mediaPeriodId.nextAdGroupIndex;
        if (i4 != -1 && i4 <= mediaPeriodId2.adGroupIndex) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r0 < r7.getWindowCount()) goto L15;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m2432c(Timeline timeline, Timeline timeline2) {
        int i = this.f9576b;
        if (i < timeline.getWindowCount()) {
            DefaultPlaybackSessionManager defaultPlaybackSessionManager = this.f9581g;
            timeline.getWindow(i, defaultPlaybackSessionManager.f9522a);
            Timeline.Window window = defaultPlaybackSessionManager.f9522a;
            for (int i2 = window.firstPeriodIndex; i2 <= window.lastPeriodIndex; i2++) {
                int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
                if (indexOfPeriod != -1) {
                    i = timeline2.getPeriod(indexOfPeriod, defaultPlaybackSessionManager.f9523b).windowIndex;
                    break;
                }
            }
            i = -1;
        }
        this.f9576b = i;
        if (i == -1) {
            return false;
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.f9578d;
        if (mediaPeriodId != null && timeline2.getIndexOfPeriod(mediaPeriodId.periodUid) == -1) {
            return false;
        }
        return true;
    }
}
