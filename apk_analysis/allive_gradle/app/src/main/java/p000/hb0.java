package p000;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* loaded from: classes.dex */
public final /* synthetic */ class hb0 implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f18001a;

    /* renamed from: b */
    public final /* synthetic */ int f18002b;

    public /* synthetic */ hb0(int i, int i2) {
        this.f18001a = i2;
        this.f18002b = i;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f18001a) {
            case 0:
                listener.onRepeatModeChanged(this.f18002b);
                return;
            default:
                listener.onAudioSessionIdChanged(this.f18002b);
                return;
        }
    }
}
