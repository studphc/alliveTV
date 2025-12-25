package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* loaded from: classes.dex */
public final /* synthetic */ class a00 implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f4a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f5b;

    /* renamed from: c */
    public final /* synthetic */ String f6c;

    public /* synthetic */ a00(AnalyticsListener.EventTime eventTime, String str, int i) {
        this.f4a = i;
        this.f5b = eventTime;
        this.f6c = str;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f4a) {
            case 0:
                analyticsListener.onAudioDecoderReleased(this.f5b, this.f6c);
                return;
            default:
                analyticsListener.onVideoDecoderReleased(this.f5b, this.f6c);
                return;
        }
    }
}
