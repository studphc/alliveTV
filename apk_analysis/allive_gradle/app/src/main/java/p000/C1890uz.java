package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: uz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1890uz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f27553a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f27554b;

    /* renamed from: c */
    public final /* synthetic */ MediaLoadData f27555c;

    public /* synthetic */ C1890uz(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData, int i) {
        this.f27553a = i;
        this.f27554b = eventTime;
        this.f27555c = mediaLoadData;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f27553a) {
            case 0:
                analyticsListener.onDownstreamFormatChanged(this.f27554b, this.f27555c);
                return;
            default:
                analyticsListener.onUpstreamDiscarded(this.f27554b, this.f27555c);
                return;
        }
    }
}
