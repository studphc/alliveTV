package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class AbstractConcatenatedTimeline extends Timeline {

    /* renamed from: a */
    public final int f9246a;

    /* renamed from: b */
    public final ShuffleOrder f9247b;

    /* renamed from: c */
    public final boolean f9248c;

    public AbstractConcatenatedTimeline(boolean z, ShuffleOrder shuffleOrder) {
        this.f9248c = z;
        this.f9247b = shuffleOrder;
        this.f9246a = shuffleOrder.getLength();
    }

    public static Object getChildPeriodUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object getChildTimelineUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object getConcatenatedUid(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    /* renamed from: b */
    public final int m2410b(int i, boolean z) {
        if (z) {
            return this.f9247b.getNextIndex(i);
        }
        if (i < this.f9246a - 1) {
            return i + 1;
        }
        return -1;
    }

    /* renamed from: c */
    public final int m2411c(int i, boolean z) {
        if (z) {
            return this.f9247b.getPreviousIndex(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract int getChildIndexByChildUid(Object obj);

    public abstract int getChildIndexByPeriodIndex(int i);

    public abstract int getChildIndexByWindowIndex(int i);

    public abstract Object getChildUidByChildIndex(int i);

    public abstract int getFirstPeriodIndexByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        if (this.f9246a == 0) {
            return -1;
        }
        int i = 0;
        if (this.f9248c) {
            z = false;
        }
        if (z) {
            i = this.f9247b.getFirstIndex();
        }
        while (getTimelineByChildIndex(i).isEmpty()) {
            i = m2410b(i, z);
            if (i == -1) {
                return -1;
            }
        }
        return getTimelineByChildIndex(i).getFirstWindowIndex(z) + getFirstWindowIndexByChildIndex(i);
    }

    public abstract int getFirstWindowIndexByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(childPeriodUidFromConcatenatedUid)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        int i;
        int i2 = this.f9246a;
        if (i2 == 0) {
            return -1;
        }
        if (this.f9248c) {
            z = false;
        }
        if (z) {
            i = this.f9247b.getLastIndex();
        } else {
            i = i2 - 1;
        }
        while (getTimelineByChildIndex(i).isEmpty()) {
            i = m2411c(i, z);
            if (i == -1) {
                return -1;
            }
        }
        return getTimelineByChildIndex(i).getLastWindowIndex(z) + getFirstWindowIndexByChildIndex(i);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.f9248c) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i4 = i - firstWindowIndexByChildIndex;
        if (i2 != 2) {
            i3 = i2;
        }
        int nextWindowIndex = timelineByChildIndex.getNextWindowIndex(i4, i3, z);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int m2410b = m2410b(childIndexByWindowIndex, z);
        while (m2410b != -1 && getTimelineByChildIndex(m2410b).isEmpty()) {
            m2410b = m2410b(m2410b, z);
        }
        if (m2410b != -1) {
            return getTimelineByChildIndex(m2410b).getFirstWindowIndex(z) + getFirstWindowIndexByChildIndex(m2410b);
        }
        if (i2 != 2) {
            return -1;
        }
        return getFirstWindowIndex(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z) {
            period.uid = getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), Assertions.checkNotNull(period.uid));
        }
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).getPeriodByUid(childPeriodUidFromConcatenatedUid, period);
        period.windowIndex += firstWindowIndexByChildIndex;
        period.uid = obj;
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.f9248c) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i4 = i - firstWindowIndexByChildIndex;
        if (i2 != 2) {
            i3 = i2;
        }
        int previousWindowIndex = timelineByChildIndex.getPreviousWindowIndex(i4, i3, z);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int m2411c = m2411c(childIndexByWindowIndex, z);
        while (m2411c != -1 && getTimelineByChildIndex(m2411c).isEmpty()) {
            m2411c = m2411c(m2411c, z);
        }
        if (m2411c != -1) {
            return getTimelineByChildIndex(m2411c).getLastWindowIndex(z) + getFirstWindowIndexByChildIndex(m2411c);
        }
        if (i2 != 2) {
            return -1;
        }
        return getLastWindowIndex(z);
    }

    public abstract Timeline getTimelineByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public final Object getUidOfPeriod(int i) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        return getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).getUidOfPeriod(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i - firstWindowIndexByChildIndex, window, j);
        Object childUidByChildIndex = getChildUidByChildIndex(childIndexByWindowIndex);
        if (!Timeline.Window.SINGLE_WINDOW_UID.equals(window.uid)) {
            childUidByChildIndex = getConcatenatedUid(childUidByChildIndex, window.uid);
        }
        window.uid = childUidByChildIndex;
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}
