package p000;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.leanback.app.PlaybackSupportFragment;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class v52 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f27655a;

    public v52(PlaybackSupportFragment playbackSupportFragment) {
        this.f27655a = playbackSupportFragment;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        View view;
        PlaybackSupportFragment playbackSupportFragment = this.f27655a;
        if (playbackSupportFragment.getVerticalGridView() != null && (findViewHolderForAdapterPosition = playbackSupportFragment.getVerticalGridView().findViewHolderForAdapterPosition(0)) != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            view.setAlpha(floatValue);
            view.setTranslationY((1.0f - floatValue) * playbackSupportFragment.f5153D0);
        }
    }
}
