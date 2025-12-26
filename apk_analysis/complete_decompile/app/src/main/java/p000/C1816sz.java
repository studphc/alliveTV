package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: sz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1816sz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f26629a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f26630b;

    public /* synthetic */ C1816sz(AnalyticsListener.EventTime eventTime, int i) {
        this.f26629a = i;
        this.f26630b = eventTime;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f26629a) {
            case 0:
                analyticsListener.onSeekStarted(this.f26630b);
                return;
            case 1:
                analyticsListener.onSeekProcessed(this.f26630b);
                return;
            case 2:
                analyticsListener.onDrmKeysLoaded(this.f26630b);
                return;
            case 3:
                analyticsListener.onDrmSessionReleased(this.f26630b);
                return;
            case 4:
                analyticsListener.onDrmKeysRestored(this.f26630b);
                return;
            case 5:
                analyticsListener.onPlayerReleased(this.f26630b);
                return;
            default:
                analyticsListener.onDrmKeysRemoved(this.f26630b);
                return;
        }
    }
}
