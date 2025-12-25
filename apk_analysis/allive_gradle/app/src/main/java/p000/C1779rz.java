package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: rz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1779rz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f26188a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f26189b;

    /* renamed from: c */
    public final /* synthetic */ boolean f26190c;

    /* renamed from: d */
    public final /* synthetic */ int f26191d;

    public /* synthetic */ C1779rz(AnalyticsListener.EventTime eventTime, int i, boolean z) {
        this.f26188a = 2;
        this.f26189b = eventTime;
        this.f26191d = i;
        this.f26190c = z;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f26188a) {
            case 0:
                analyticsListener.onPlayerStateChanged(this.f26189b, this.f26190c, this.f26191d);
                return;
            case 1:
                analyticsListener.onPlayWhenReadyChanged(this.f26189b, this.f26190c, this.f26191d);
                return;
            default:
                analyticsListener.onDeviceVolumeChanged(this.f26189b, this.f26191d, this.f26190c);
                return;
        }
    }

    public /* synthetic */ C1779rz(AnalyticsListener.EventTime eventTime, boolean z, int i, int i2) {
        this.f26188a = i2;
        this.f26189b = eventTime;
        this.f26190c = z;
        this.f26191d = i;
    }
}
