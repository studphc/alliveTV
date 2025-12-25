package p000;

import com.google.android.exoplayer2.source.ForwardingTimeline;

/* loaded from: classes.dex */
public final class je1 extends ForwardingTimeline {
    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final int getNextWindowIndex(int i, int i2, boolean z) {
        int nextWindowIndex = this.timeline.getNextWindowIndex(i, i2, z);
        if (nextWindowIndex == -1) {
            return getFirstWindowIndex(z);
        }
        return nextWindowIndex;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final int getPreviousWindowIndex(int i, int i2, boolean z) {
        int previousWindowIndex = this.timeline.getPreviousWindowIndex(i, i2, z);
        if (previousWindowIndex == -1) {
            return getLastWindowIndex(z);
        }
        return previousWindowIndex;
    }
}
