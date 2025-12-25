package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.DetailsFragmentBackgroundController;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class w20 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsFragment f28047h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w20(DetailsFragment detailsFragment) {
        super("STATE_ON_SAFE_START");
        this.f28047h = detailsFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsFragmentBackgroundController detailsFragmentBackgroundController = this.f28047h.f4919Y;
        if (detailsFragmentBackgroundController != null) {
            if (!detailsFragmentBackgroundController.f4932h) {
                detailsFragmentBackgroundController.f4932h = true;
                PlaybackGlue playbackGlue = detailsFragmentBackgroundController.f4928d;
                if (playbackGlue != null) {
                    PlaybackGlueHost onCreateGlueHost = detailsFragmentBackgroundController.onCreateGlueHost();
                    if (detailsFragmentBackgroundController.f4933i) {
                        onCreateGlueHost.showControlsOverlay(false);
                    } else {
                        onCreateGlueHost.hideControlsOverlay(false);
                    }
                    playbackGlue.setHost(onCreateGlueHost);
                    detailsFragmentBackgroundController.f4934j = detailsFragmentBackgroundController.findOrCreateVideoFragment();
                }
            }
            PlaybackGlue playbackGlue2 = detailsFragmentBackgroundController.f4928d;
            if (playbackGlue2 != null && playbackGlue2.isPrepared()) {
                detailsFragmentBackgroundController.f4928d.play();
            }
        }
    }
}
