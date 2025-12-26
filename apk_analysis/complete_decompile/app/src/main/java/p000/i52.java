package p000;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.leanback.app.PlaybackFragment;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class i52 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f18305a;

    public i52(PlaybackFragment playbackFragment) {
        this.f18305a = playbackFragment;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        View view;
        PlaybackFragment playbackFragment = this.f18305a;
        if (playbackFragment.m1321b() != null && (findViewHolderForAdapterPosition = playbackFragment.m1321b().findViewHolderForAdapterPosition(0)) != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            view.setAlpha(floatValue);
            view.setTranslationY((1.0f - floatValue) * playbackFragment.f5147z);
        }
    }
}
