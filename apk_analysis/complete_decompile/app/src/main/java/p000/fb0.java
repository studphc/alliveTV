package p000;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.TrackSelectionDialogBuilder;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class fb0 implements ListenerSet.Event, TrackSelectionDialogBuilder.DialogCallback {

    /* renamed from: a */
    public final /* synthetic */ int f17197a;

    /* renamed from: b */
    public final /* synthetic */ Object f17198b;

    public /* synthetic */ fb0(int i, Object obj) {
        this.f17198b = obj;
        this.f17197a = i;
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).onMediaItemTransition((MediaItem) this.f17198b, this.f17197a);
    }

    @Override // com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback
    public void onTracksSelected(boolean z, Map map) {
        Player player = (Player) this.f17198b;
        TrackSelectionParameters.Builder buildUpon = player.getTrackSelectionParameters().buildUpon();
        int i = this.f17197a;
        buildUpon.setTrackTypeDisabled(i, z);
        buildUpon.clearOverridesOfType(i);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            buildUpon.addOverride((TrackSelectionOverride) it.next());
        }
        player.setTrackSelectionParameters(buildUpon.build());
    }
}
