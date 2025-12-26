package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: oz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1668oz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f24961a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f24962b;

    /* renamed from: c */
    public final /* synthetic */ String f24963c;

    /* renamed from: d */
    public final /* synthetic */ long f24964d;

    /* renamed from: e */
    public final /* synthetic */ long f24965e;

    public /* synthetic */ C1668oz(AnalyticsListener.EventTime eventTime, String str, long j, long j2, int i) {
        this.f24961a = i;
        this.f24962b = eventTime;
        this.f24963c = str;
        this.f24964d = j;
        this.f24965e = j2;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        switch (this.f24961a) {
            case 0:
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                AnalyticsListener.EventTime eventTime = this.f24962b;
                String str = this.f24963c;
                long j = this.f24964d;
                analyticsListener.onAudioDecoderInitialized(eventTime, str, j);
                analyticsListener.onAudioDecoderInitialized(eventTime, str, this.f24965e, j);
                analyticsListener.onDecoderInitialized(eventTime, 1, str, j);
                return;
            default:
                AnalyticsListener analyticsListener2 = (AnalyticsListener) obj;
                AnalyticsListener.EventTime eventTime2 = this.f24962b;
                String str2 = this.f24963c;
                long j2 = this.f24964d;
                analyticsListener2.onVideoDecoderInitialized(eventTime2, str2, j2);
                analyticsListener2.onVideoDecoderInitialized(eventTime2, str2, this.f24965e, j2);
                analyticsListener2.onDecoderInitialized(eventTime2, 2, str2, j2);
                return;
        }
    }
}
