package p000;

import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* renamed from: yz */
/* loaded from: classes.dex */
public final /* synthetic */ class C2038yz implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f29192a = 1;

    /* renamed from: b */
    public final /* synthetic */ int f29193b;

    /* renamed from: c */
    public final /* synthetic */ Object f29194c;

    /* renamed from: d */
    public final /* synthetic */ Bundleable f29195d;

    public /* synthetic */ C2038yz(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        this.f29193b = i;
        this.f29194c = positionInfo;
        this.f29195d = positionInfo2;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        switch (this.f29192a) {
            case 0:
                ((AnalyticsListener) obj).onMediaItemTransition((AnalyticsListener.EventTime) this.f29194c, (MediaItem) this.f29195d, this.f29193b);
                return;
            default:
                Player.Listener listener = (Player.Listener) obj;
                int i = this.f29193b;
                listener.onPositionDiscontinuity(i);
                listener.onPositionDiscontinuity((Player.PositionInfo) this.f29194c, (Player.PositionInfo) this.f29195d, i);
                return;
        }
    }

    public /* synthetic */ C2038yz(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        this.f29194c = eventTime;
        this.f29195d = mediaItem;
        this.f29193b = i;
    }
}
