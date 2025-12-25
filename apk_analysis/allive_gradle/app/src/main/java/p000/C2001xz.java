package p000;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: xz */
/* loaded from: classes.dex */
public final /* synthetic */ class C2001xz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f28768a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f28769b;

    /* renamed from: c */
    public final /* synthetic */ PlaybackException f28770c;

    public /* synthetic */ C2001xz(AnalyticsListener.EventTime eventTime, PlaybackException playbackException, int i) {
        this.f28768a = i;
        this.f28769b = eventTime;
        this.f28770c = playbackException;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f28768a) {
            case 0:
                analyticsListener.onPlayerError(this.f28769b, this.f28770c);
                return;
            default:
                analyticsListener.onPlayerErrorChanged(this.f28769b, this.f28770c);
                return;
        }
    }
}
