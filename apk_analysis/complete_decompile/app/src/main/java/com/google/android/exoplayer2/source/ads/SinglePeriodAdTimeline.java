package com.google.android.exoplayer2.source.ads;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

@VisibleForTesting(otherwise = 3)
/* loaded from: classes.dex */
public final class SinglePeriodAdTimeline extends ForwardingTimeline {

    /* renamed from: a */
    public final AdPlaybackState f11120a;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        boolean z;
        if (timeline.getPeriodCount() == 1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Assertions.checkState(timeline.getWindowCount() == 1);
        this.f11120a = adPlaybackState;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        long j = period.durationUs;
        if (j == C0643C.TIME_UNSET) {
            j = this.f11120a.contentDurationUs;
        }
        period.set(period.f9497id, period.uid, period.windowIndex, j, period.getPositionInWindowUs(), this.f11120a, period.isPlaceholder);
        return period;
    }
}
