package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* loaded from: classes.dex */
public final /* synthetic */ class b00 implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f7827a = 0;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f7828b;

    /* renamed from: c */
    public final /* synthetic */ long f7829c;

    /* renamed from: d */
    public final /* synthetic */ int f7830d;

    public /* synthetic */ b00(AnalyticsListener.EventTime eventTime, int i, long j) {
        this.f7828b = eventTime;
        this.f7830d = i;
        this.f7829c = j;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f7827a) {
            case 0:
                analyticsListener.onDroppedVideoFrames(this.f7828b, this.f7830d, this.f7829c);
                return;
            default:
                analyticsListener.onVideoFrameProcessingOffset(this.f7828b, this.f7829c, this.f7830d);
                return;
        }
    }

    public /* synthetic */ b00(AnalyticsListener.EventTime eventTime, long j, int i) {
        this.f7828b = eventTime;
        this.f7829c = j;
        this.f7830d = i;
    }
}
