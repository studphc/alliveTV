package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.util.Util;

/* renamed from: com.google.android.exoplayer2.source.a */
/* loaded from: classes.dex */
public final class C0686a extends ForwardingTimeline {

    /* renamed from: a */
    public final long f11092a;

    /* renamed from: b */
    public final long f11093b;

    /* renamed from: c */
    public final long f11094c;

    /* renamed from: d */
    public final boolean f11095d;

    public C0686a(Timeline timeline, long j, long j2) {
        super(timeline);
        long max;
        long j3;
        boolean z = false;
        if (timeline.getPeriodCount() == 1) {
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
            long max2 = Math.max(0L, j);
            if (!window.isPlaceholder && max2 != 0 && !window.isSeekable) {
                throw new ClippingMediaSource.IllegalClippingException(1);
            }
            if (j2 == Long.MIN_VALUE) {
                max = window.durationUs;
            } else {
                max = Math.max(0L, j2);
            }
            long j4 = window.durationUs;
            if (j4 != C0643C.TIME_UNSET) {
                max = max > j4 ? j4 : max;
                if (max2 > max) {
                    throw new ClippingMediaSource.IllegalClippingException(2);
                }
            }
            this.f11092a = max2;
            this.f11093b = max;
            if (max == C0643C.TIME_UNSET) {
                j3 = -9223372036854775807L;
            } else {
                j3 = max - max2;
            }
            this.f11094c = j3;
            if (window.isDynamic && (max == C0643C.TIME_UNSET || (j4 != C0643C.TIME_UNSET && max == j4))) {
                z = true;
            }
            this.f11095d = z;
            return;
        }
        throw new ClippingMediaSource.IllegalClippingException(0);
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        long j;
        this.timeline.getPeriod(0, period, z);
        long positionInWindowUs = period.getPositionInWindowUs() - this.f11092a;
        long j2 = this.f11094c;
        if (j2 == C0643C.TIME_UNSET) {
            j = -9223372036854775807L;
        } else {
            j = j2 - positionInWindowUs;
        }
        return period.set(period.f9497id, period.uid, 0, j, positionInWindowUs);
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        this.timeline.getWindow(0, window, 0L);
        long j2 = window.positionInFirstPeriodUs;
        long j3 = this.f11092a;
        window.positionInFirstPeriodUs = j2 + j3;
        window.durationUs = this.f11094c;
        window.isDynamic = this.f11095d;
        long j4 = window.defaultPositionUs;
        if (j4 != C0643C.TIME_UNSET) {
            long max = Math.max(j4, j3);
            window.defaultPositionUs = max;
            long j5 = this.f11093b;
            if (j5 != C0643C.TIME_UNSET) {
                max = Math.min(max, j5);
            }
            window.defaultPositionUs = max - j3;
        }
        long usToMs = Util.usToMs(j3);
        long j6 = window.presentationStartTimeMs;
        if (j6 != C0643C.TIME_UNSET) {
            window.presentationStartTimeMs = j6 + usToMs;
        }
        long j7 = window.windowStartTimeMs;
        if (j7 != C0643C.TIME_UNSET) {
            window.windowStartTimeMs = j7 + usToMs;
        }
        return window;
    }
}
