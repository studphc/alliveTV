package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;

/* renamed from: com.google.android.exoplayer2.source.g */
/* loaded from: classes.dex */
public final class C0698g extends AbstractConcatenatedTimeline {

    /* renamed from: d */
    public final Timeline f11368d;

    /* renamed from: e */
    public final int f11369e;

    /* renamed from: f */
    public final int f11370f;

    /* renamed from: g */
    public final int f11371g;

    public C0698g(Timeline timeline, int i) {
        super(false, new ShuffleOrder.UnshuffledShuffleOrder(i));
        this.f11368d = timeline;
        int periodCount = timeline.getPeriodCount();
        this.f11369e = periodCount;
        this.f11370f = timeline.getWindowCount();
        this.f11371g = i;
        if (periodCount > 0) {
            Assertions.checkState(i <= Integer.MAX_VALUE / periodCount, "LoopingMediaSource contains too many periods");
        }
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByChildUid(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByPeriodIndex(int i) {
        return i / this.f11369e;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByWindowIndex(int i) {
        return i / this.f11370f;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final Object getChildUidByChildIndex(int i) {
        return Integer.valueOf(i);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getFirstPeriodIndexByChildIndex(int i) {
        return i * this.f11369e;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getFirstWindowIndexByChildIndex(int i) {
        return i * this.f11370f;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getPeriodCount() {
        return this.f11369e * this.f11371g;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final Timeline getTimelineByChildIndex(int i) {
        return this.f11368d;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getWindowCount() {
        return this.f11370f * this.f11371g;
    }
}
