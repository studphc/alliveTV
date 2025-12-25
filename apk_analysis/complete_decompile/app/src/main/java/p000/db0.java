package p000;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* loaded from: classes.dex */
public final /* synthetic */ class db0 implements ListenerSet.Event {

    /* renamed from: a */
    public final /* synthetic */ int f16327a;

    /* renamed from: b */
    public final /* synthetic */ boolean f16328b;

    public /* synthetic */ db0(boolean z, int i) {
        this.f16327a = i;
        this.f16328b = z;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f16327a) {
            case 0:
                listener.onShuffleModeEnabledChanged(this.f16328b);
                return;
            case 1:
                listener.onSkipSilenceEnabledChanged(this.f16328b);
                return;
            default:
                listener.onSkipSilenceEnabledChanged(this.f16328b);
                return;
        }
    }
}
