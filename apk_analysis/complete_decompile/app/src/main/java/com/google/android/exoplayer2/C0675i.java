package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;

/* renamed from: com.google.android.exoplayer2.i */
/* loaded from: classes.dex */
public final class C0675i extends Timeline {
    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getPeriodCount() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Object getUidOfPeriod(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getWindowCount() {
        return 0;
    }
}
