package p000;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: zz */
/* loaded from: classes.dex */
public final /* synthetic */ class C2075zz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f29575a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f29576b;

    /* renamed from: c */
    public final /* synthetic */ DecoderCounters f29577c;

    public /* synthetic */ C2075zz(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        this.f29575a = i;
        this.f29576b = eventTime;
        this.f29577c = decoderCounters;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f29575a) {
            case 0:
                AnalyticsListener.EventTime eventTime = this.f29576b;
                DecoderCounters decoderCounters = this.f29577c;
                analyticsListener.onVideoEnabled(eventTime, decoderCounters);
                analyticsListener.onDecoderEnabled(eventTime, 2, decoderCounters);
                return;
            case 1:
                AnalyticsListener.EventTime eventTime2 = this.f29576b;
                DecoderCounters decoderCounters2 = this.f29577c;
                analyticsListener.onAudioDisabled(eventTime2, decoderCounters2);
                analyticsListener.onDecoderDisabled(eventTime2, 1, decoderCounters2);
                return;
            case 2:
                AnalyticsListener.EventTime eventTime3 = this.f29576b;
                DecoderCounters decoderCounters3 = this.f29577c;
                analyticsListener.onVideoDisabled(eventTime3, decoderCounters3);
                analyticsListener.onDecoderDisabled(eventTime3, 2, decoderCounters3);
                return;
            default:
                AnalyticsListener.EventTime eventTime4 = this.f29576b;
                DecoderCounters decoderCounters4 = this.f29577c;
                analyticsListener.onAudioEnabled(eventTime4, decoderCounters4);
                analyticsListener.onDecoderEnabled(eventTime4, 1, decoderCounters4);
                return;
        }
    }
}
