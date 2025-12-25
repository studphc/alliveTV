package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class m30 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsSupportFragment f22782h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m30(DetailsSupportFragment detailsSupportFragment) {
        super("STATE_ON_SAFE_START");
        this.f22782h = detailsSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController = this.f22782h.f4960c1;
        if (detailsSupportFragmentBackgroundController != null) {
            if (!detailsSupportFragmentBackgroundController.f4972h) {
                detailsSupportFragmentBackgroundController.f4972h = true;
                PlaybackGlue playbackGlue = detailsSupportFragmentBackgroundController.f4968d;
                if (playbackGlue != null) {
                    PlaybackGlueHost onCreateGlueHost = detailsSupportFragmentBackgroundController.onCreateGlueHost();
                    if (detailsSupportFragmentBackgroundController.f4973i) {
                        onCreateGlueHost.showControlsOverlay(false);
                    } else {
                        onCreateGlueHost.hideControlsOverlay(false);
                    }
                    playbackGlue.setHost(onCreateGlueHost);
                    detailsSupportFragmentBackgroundController.f4974j = detailsSupportFragmentBackgroundController.findOrCreateVideoSupportFragment();
                }
            }
            PlaybackGlue playbackGlue2 = detailsSupportFragmentBackgroundController.f4968d;
            if (playbackGlue2 != null && playbackGlue2.isPrepared()) {
                detailsSupportFragmentBackgroundController.f4968d.play();
            }
        }
    }
}
