package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class nn1 extends ForwardingTimeline {

    /* renamed from: a */
    public final long[] f23424a;

    /* renamed from: b */
    public final long[] f23425b;

    public nn1(Timeline timeline, HashMap hashMap) {
        super(timeline);
        int windowCount = timeline.getWindowCount();
        this.f23425b = new long[timeline.getWindowCount()];
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < windowCount; i++) {
            this.f23425b[i] = timeline.getWindow(i, window).durationUs;
        }
        int periodCount = timeline.getPeriodCount();
        this.f23424a = new long[periodCount];
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < periodCount; i2++) {
            timeline.getPeriod(i2, period, true);
            long longValue = ((Long) Assertions.checkNotNull((Long) hashMap.get(period.uid))).longValue();
            long[] jArr = this.f23424a;
            longValue = longValue == Long.MIN_VALUE ? period.durationUs : longValue;
            jArr[i2] = longValue;
            long j = period.durationUs;
            if (j != C0643C.TIME_UNSET) {
                long[] jArr2 = this.f23425b;
                int i3 = period.windowIndex;
                jArr2[i3] = jArr2[i3] - (j - longValue);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        super.getPeriod(i, period, z);
        period.durationUs = this.f23424a[i];
        return period;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        long j2;
        super.getWindow(i, window, j);
        long j3 = this.f23425b[i];
        window.durationUs = j3;
        if (j3 != C0643C.TIME_UNSET) {
            long j4 = window.defaultPositionUs;
            if (j4 != C0643C.TIME_UNSET) {
                j2 = Math.min(j4, j3);
                window.defaultPositionUs = j2;
                return window;
            }
        }
        j2 = window.defaultPositionUs;
        window.defaultPositionUs = j2;
        return window;
    }
}
