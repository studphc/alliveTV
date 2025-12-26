package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: mz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1566mz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f23164a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f23165b;

    /* renamed from: c */
    public final /* synthetic */ Format f23166c;

    /* renamed from: d */
    public final /* synthetic */ DecoderReuseEvaluation f23167d;

    public /* synthetic */ C1566mz(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, int i) {
        this.f23164a = i;
        this.f23165b = eventTime;
        this.f23166c = format;
        this.f23167d = decoderReuseEvaluation;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f23164a) {
            case 0:
                AnalyticsListener.EventTime eventTime = this.f23165b;
                Format format = this.f23166c;
                analyticsListener.onAudioInputFormatChanged(eventTime, format);
                analyticsListener.onAudioInputFormatChanged(eventTime, format, this.f23167d);
                analyticsListener.onDecoderInputFormatChanged(eventTime, 1, format);
                return;
            default:
                AnalyticsListener.EventTime eventTime2 = this.f23165b;
                Format format2 = this.f23166c;
                analyticsListener.onVideoInputFormatChanged(eventTime2, format2);
                analyticsListener.onVideoInputFormatChanged(eventTime2, format2, this.f23167d);
                analyticsListener.onDecoderInputFormatChanged(eventTime2, 2, format2);
                return;
        }
    }
}
