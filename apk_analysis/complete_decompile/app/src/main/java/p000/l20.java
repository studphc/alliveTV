package p000;

import androidx.leanback.media.PlaybackGlue;

/* loaded from: classes.dex */
public final class l20 extends PlaybackGlue.PlayerCallback {

    /* renamed from: a */
    public final /* synthetic */ m20 f22301a;

    public l20(m20 m20Var) {
        this.f22301a = m20Var;
    }

    @Override // androidx.leanback.media.PlaybackGlue.PlayerCallback
    public final void onPreparedStateChanged(PlaybackGlue playbackGlue) {
        if (playbackGlue.isPrepared()) {
            m20 m20Var = this.f22301a;
            PlaybackGlue playbackGlue2 = m20Var.f22775f;
            if (playbackGlue2 != null) {
                playbackGlue2.play();
            }
            m20Var.f22770a.getRecyclerView().postDelayed(new RunnableC1104d(11, m20Var), 1000L);
        }
    }
}
