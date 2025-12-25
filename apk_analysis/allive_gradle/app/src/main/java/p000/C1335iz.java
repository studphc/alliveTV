package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: iz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1335iz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f20309a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f20310b;

    /* renamed from: c */
    public final /* synthetic */ long f20311c;

    public /* synthetic */ C1335iz(AnalyticsListener.EventTime eventTime, long j, int i) {
        this.f20309a = i;
        this.f20310b = eventTime;
        this.f20311c = j;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f20309a) {
            case 0:
                analyticsListener.onSeekForwardIncrementChanged(this.f20310b, this.f20311c);
                return;
            case 1:
                analyticsListener.onSeekBackIncrementChanged(this.f20310b, this.f20311c);
                return;
            case 2:
                analyticsListener.onAudioPositionAdvancing(this.f20310b, this.f20311c);
                return;
            default:
                analyticsListener.onMaxSeekToPreviousPositionChanged(this.f20310b, this.f20311c);
                return;
        }
    }
}
