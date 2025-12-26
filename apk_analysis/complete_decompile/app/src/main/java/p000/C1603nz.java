package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: nz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1603nz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f23537a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f23538b;

    /* renamed from: c */
    public final /* synthetic */ int f23539c;

    /* renamed from: d */
    public final /* synthetic */ long f23540d;

    /* renamed from: e */
    public final /* synthetic */ long f23541e;

    public /* synthetic */ C1603nz(AnalyticsListener.EventTime eventTime, int i, long j, long j2, int i2) {
        this.f23537a = i2;
        this.f23538b = eventTime;
        this.f23539c = i;
        this.f23540d = j;
        this.f23541e = j2;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        switch (this.f23537a) {
            case 0:
                ((AnalyticsListener) obj).onAudioUnderrun(this.f23538b, this.f23539c, this.f23540d, this.f23541e);
                return;
            default:
                ((AnalyticsListener) obj).onBandwidthEstimate(this.f23538b, this.f23539c, this.f23540d, this.f23541e);
                return;
        }
    }
}
