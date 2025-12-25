package p000;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: pz */
/* loaded from: classes.dex */
public final /* synthetic */ class C1705pz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f25343a;

    /* renamed from: b */
    public final /* synthetic */ AnalyticsListener.EventTime f25344b;

    /* renamed from: c */
    public final /* synthetic */ MediaMetadata f25345c;

    public /* synthetic */ C1705pz(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata, int i) {
        this.f25343a = i;
        this.f25344b = eventTime;
        this.f25345c = mediaMetadata;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f25343a) {
            case 0:
                analyticsListener.onMediaMetadataChanged(this.f25344b, this.f25345c);
                return;
            default:
                analyticsListener.onPlaylistMetadataChanged(this.f25344b, this.f25345c);
                return;
        }
    }
}
