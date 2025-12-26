package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;

/* renamed from: com.google.android.exoplayer2.source.h */
/* loaded from: classes.dex */
public final class C0699h extends ForwardingTimeline {

    /* renamed from: c */
    public static final Object f11372c = new Object();

    /* renamed from: a */
    public final Object f11373a;

    /* renamed from: b */
    public final Object f11374b;

    public C0699h(Timeline timeline, Object obj, Object obj2) {
        super(timeline);
        this.f11373a = obj;
        this.f11374b = obj2;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        Object obj2;
        Timeline timeline = this.timeline;
        if (f11372c.equals(obj) && (obj2 = this.f11374b) != null) {
            obj = obj2;
        }
        return timeline.getIndexOfPeriod(obj);
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        if (Util.areEqual(period.uid, this.f11374b) && z) {
            period.uid = f11372c;
        }
        return period;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Object getUidOfPeriod(int i) {
        Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
        if (Util.areEqual(uidOfPeriod, this.f11374b)) {
            return f11372c;
        }
        return uidOfPeriod;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        this.timeline.getWindow(i, window, j);
        if (Util.areEqual(window.uid, this.f11373a)) {
            window.uid = Timeline.Window.SINGLE_WINDOW_UID;
        }
        return window;
    }
}
