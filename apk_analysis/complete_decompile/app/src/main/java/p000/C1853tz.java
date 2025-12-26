package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: tz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1853tz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f27034a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f27035b;

    /* renamed from: c */
    public final /* synthetic */ int f27036c;

    public /* synthetic */ C1853tz(AnalyticsListener.EventTime eventTime, int i, int i2) {
        this.f27034a = i2;
        this.f27035b = eventTime;
        this.f27036c = i;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f27034a) {
            case 0:
                analyticsListener.onAudioSessionIdChanged(this.f27035b, this.f27036c);
                return;
            case 1:
                analyticsListener.onPlaybackStateChanged(this.f27035b, this.f27036c);
                return;
            case 2:
                analyticsListener.onRepeatModeChanged(this.f27035b, this.f27036c);
                return;
            case 3:
                analyticsListener.onPlaybackSuppressionReasonChanged(this.f27035b, this.f27036c);
                return;
            case 4:
                analyticsListener.onTimelineChanged(this.f27035b, this.f27036c);
                return;
            default:
                AnalyticsListener.EventTime eventTime = this.f27035b;
                analyticsListener.onDrmSessionAcquired(eventTime);
                analyticsListener.onDrmSessionAcquired(eventTime, this.f27036c);
                return;
        }
    }
}
