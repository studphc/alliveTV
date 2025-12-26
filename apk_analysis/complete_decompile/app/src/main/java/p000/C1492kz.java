package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: kz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1492kz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f22249a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f22250b;

    /* renamed from: c */
    public final /* synthetic */ boolean f22251c;

    public /* synthetic */ C1492kz(AnalyticsListener.EventTime eventTime, int i, boolean z) {
        this.f22249a = i;
        this.f22250b = eventTime;
        this.f22251c = z;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f22249a) {
            case 0:
                analyticsListener.onSkipSilenceEnabledChanged(this.f22250b, this.f22251c);
                return;
            case 1:
                analyticsListener.onIsPlayingChanged(this.f22250b, this.f22251c);
                return;
            case 2:
                analyticsListener.onShuffleModeChanged(this.f22250b, this.f22251c);
                return;
            default:
                AnalyticsListener.EventTime eventTime = this.f22250b;
                boolean z = this.f22251c;
                analyticsListener.onLoadingChanged(eventTime, z);
                analyticsListener.onIsLoadingChanged(eventTime, z);
                return;
        }
    }
}
