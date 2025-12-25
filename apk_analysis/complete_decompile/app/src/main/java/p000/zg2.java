package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableMap;

/* loaded from: classes.dex */
public final class zg2 extends ForwardingTimeline {

    /* renamed from: a */
    public final ImmutableMap f29372a;

    public zg2(Timeline timeline, ImmutableMap immutableMap) {
        super(timeline);
        boolean z;
        if (timeline.getWindowCount() == 1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Timeline.Period period = new Timeline.Period();
        for (int i = 0; i < timeline.getPeriodCount(); i++) {
            timeline.getPeriod(i, period, true);
            Assertions.checkState(immutableMap.containsKey(Assertions.checkNotNull(period.uid)));
        }
        this.f29372a = immutableMap;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        long mediaPeriodPositionUsForContent;
        super.getPeriod(i, period, true);
        Object obj = period.uid;
        ImmutableMap immutableMap = this.f29372a;
        AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) immutableMap.get(obj));
        long j = period.durationUs;
        if (j == C0643C.TIME_UNSET) {
            mediaPeriodPositionUsForContent = adPlaybackState.contentDurationUs;
        } else {
            mediaPeriodPositionUsForContent = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(j, -1, adPlaybackState);
        }
        Timeline.Period period2 = new Timeline.Period();
        long j2 = 0;
        for (int i2 = 0; i2 < i + 1; i2++) {
            this.timeline.getPeriod(i2, period2, true);
            AdPlaybackState adPlaybackState2 = (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) immutableMap.get(period2.uid));
            if (i2 == 0) {
                j2 = -ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(-period2.getPositionInWindowUs(), -1, adPlaybackState2);
            }
            if (i2 != i) {
                j2 = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(period2.durationUs, -1, adPlaybackState2) + j2;
            }
        }
        period.set(period.f9497id, period.uid, period.windowIndex, mediaPeriodPositionUsForContent, j2, adPlaybackState, period.isPlaceholder);
        return period;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        super.getWindow(i, window, j);
        int i2 = window.firstPeriodIndex;
        Timeline.Period period = new Timeline.Period();
        getPeriod(i2, period, true);
        AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f29372a.get(Assertions.checkNotNull(period.uid)));
        long mediaPeriodPositionUsForContent = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(window.positionInFirstPeriodUs, -1, adPlaybackState);
        long j2 = window.durationUs;
        long j3 = C0643C.TIME_UNSET;
        if (j2 == C0643C.TIME_UNSET) {
            long j4 = adPlaybackState.contentDurationUs;
            if (j4 != C0643C.TIME_UNSET) {
                window.durationUs = j4 - mediaPeriodPositionUsForContent;
            }
        } else {
            Timeline.Period period2 = getPeriod(window.lastPeriodIndex, new Timeline.Period());
            long j5 = period2.durationUs;
            if (j5 != C0643C.TIME_UNSET) {
                j3 = period2.positionInWindowUs + j5;
            }
            window.durationUs = j3;
        }
        window.positionInFirstPeriodUs = mediaPeriodPositionUsForContent;
        return window;
    }
}
