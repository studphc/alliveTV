package androidx.leanback.app;

import android.animation.Animator;
import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;

/* renamed from: androidx.leanback.app.q */
/* loaded from: classes.dex */
public final class C0283q implements Animator.AnimatorListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f5347a;

    public C0283q(PlaybackFragment playbackFragment) {
        this.f5347a = playbackFragment;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ItemBridgeAdapter.ViewHolder viewHolder;
        PlaybackFragment playbackFragment = this.f5347a;
        if (playbackFragment.f5107G > 0) {
            if (playbackFragment.m1321b() != null) {
                playbackFragment.m1321b().setAnimateChildLayout(true);
            }
            PlaybackFragment.OnFadeCompleteListener onFadeCompleteListener = playbackFragment.f5101A;
            if (onFadeCompleteListener != null) {
                onFadeCompleteListener.onFadeInComplete();
                return;
            }
            return;
        }
        VerticalGridView m1321b = playbackFragment.m1321b();
        if (m1321b != null && m1321b.getSelectedPosition() == 0 && (viewHolder = (ItemBridgeAdapter.ViewHolder) m1321b.findViewHolderForAdapterPosition(0)) != null && (viewHolder.getPresenter() instanceof PlaybackRowPresenter)) {
            ((PlaybackRowPresenter) viewHolder.getPresenter()).onReappear((RowPresenter.ViewHolder) viewHolder.getViewHolder());
        }
        PlaybackFragment.OnFadeCompleteListener onFadeCompleteListener2 = playbackFragment.f5101A;
        if (onFadeCompleteListener2 != null) {
            onFadeCompleteListener2.onFadeOutComplete();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        PlaybackFragment playbackFragment = this.f5347a;
        if (playbackFragment.m1321b() != null) {
            playbackFragment.m1321b().setAnimateChildLayout(false);
        }
    }
}
