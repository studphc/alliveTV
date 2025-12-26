package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: lz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1529lz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f22721a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f22722b;

    /* renamed from: c */
    public final /* synthetic */ Exception f22723c;

    public /* synthetic */ C1529lz(AnalyticsListener.EventTime eventTime, Exception exc, int i) {
        this.f22721a = i;
        this.f22722b = eventTime;
        this.f22723c = exc;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f22721a) {
            case 0:
                analyticsListener.onVideoCodecError(this.f22722b, this.f22723c);
                return;
            case 1:
                analyticsListener.onAudioCodecError(this.f22722b, this.f22723c);
                return;
            case 2:
                analyticsListener.onAudioSinkError(this.f22722b, this.f22723c);
                return;
            default:
                analyticsListener.onDrmSessionManagerError(this.f22722b, this.f22723c);
                return;
        }
    }
}
