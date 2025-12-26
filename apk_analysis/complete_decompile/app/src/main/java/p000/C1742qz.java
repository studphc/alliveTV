package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: qz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1742qz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f25808a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f25809b;

    /* renamed from: c */
    public final /* synthetic */ LoadEventInfo f25810c;

    /* renamed from: d */
    public final /* synthetic */ MediaLoadData f25811d;

    public /* synthetic */ C1742qz(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i) {
        this.f25808a = i;
        this.f25809b = eventTime;
        this.f25810c = loadEventInfo;
        this.f25811d = mediaLoadData;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f25808a) {
            case 0:
                analyticsListener.onLoadCompleted(this.f25809b, this.f25810c, this.f25811d);
                return;
            case 1:
                analyticsListener.onLoadStarted(this.f25809b, this.f25810c, this.f25811d);
                return;
            default:
                analyticsListener.onLoadCanceled(this.f25809b, this.f25810c, this.f25811d);
                return;
        }
    }
}
