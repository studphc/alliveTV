package androidx.leanback.app;

import android.animation.Animator;
import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;

/* renamed from: androidx.leanback.app.r */
/* loaded from: classes.dex */
public final class C0284r implements Animator.AnimatorListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f5348a;

    public C0284r(PlaybackSupportFragment playbackSupportFragment) {
        this.f5348a = playbackSupportFragment;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ItemBridgeAdapter.ViewHolder viewHolder;
        PlaybackSupportFragment playbackSupportFragment = this.f5348a;
        if (playbackSupportFragment.f5160K0 > 0) {
            if (playbackSupportFragment.getVerticalGridView() != null) {
                playbackSupportFragment.getVerticalGridView().setAnimateChildLayout(true);
            }
            PlaybackSupportFragment.OnFadeCompleteListener onFadeCompleteListener = playbackSupportFragment.f5154E0;
            if (onFadeCompleteListener != null) {
                onFadeCompleteListener.onFadeInComplete();
                return;
            }
            return;
        }
        VerticalGridView verticalGridView = playbackSupportFragment.getVerticalGridView();
        if (verticalGridView != null && verticalGridView.getSelectedPosition() == 0 && (viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(0)) != null && (viewHolder.getPresenter() instanceof PlaybackRowPresenter)) {
            ((PlaybackRowPresenter) viewHolder.getPresenter()).onReappear((RowPresenter.ViewHolder) viewHolder.getViewHolder());
        }
        PlaybackSupportFragment.OnFadeCompleteListener onFadeCompleteListener2 = playbackSupportFragment.f5154E0;
        if (onFadeCompleteListener2 != null) {
            onFadeCompleteListener2.onFadeOutComplete();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        PlaybackSupportFragment playbackSupportFragment = this.f5348a;
        if (playbackSupportFragment.getVerticalGridView() != null) {
            playbackSupportFragment.getVerticalGridView().setAnimateChildLayout(false);
        }
    }
}
