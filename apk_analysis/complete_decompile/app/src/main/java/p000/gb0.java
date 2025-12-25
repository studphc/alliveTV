package p000;

import com.google.android.exoplayer2.C0658d;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdateListener;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

/* loaded from: classes.dex */
public final /* synthetic */ class gb0 implements ListenerSet.Event, ListenerSet.IterationFinishedEvent, ExoPlayerImplInternal$PlaybackInfoUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ int f17628a;

    /* renamed from: b */
    public final /* synthetic */ C0658d f17629b;

    public /* synthetic */ gb0(C0658d c0658d, int i) {
        this.f17628a = i;
        this.f17629b = c0658d;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
        C0658d c0658d = this.f17629b;
        c0658d.getClass();
        ((Player.Listener) obj).onEvents(c0658d.f9874e, new Player.Events(flagSet));
    }

    @Override // com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdateListener
    public void onPlaybackInfoUpdate(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        C0658d c0658d = this.f17629b;
        c0658d.getClass();
        c0658d.f9880h.post(new RunnableC0583c7(19, c0658d, exoPlayerImplInternal$PlaybackInfoUpdate));
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f17628a) {
            case 0:
                listener.onPlaylistMetadataChanged(this.f17629b.f9856Q);
                return;
            default:
                listener.onAvailableCommandsChanged(this.f17629b.f9854O);
                return;
        }
    }
}
