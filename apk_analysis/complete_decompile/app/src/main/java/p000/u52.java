package p000;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.leanback.app.PlaybackSupportFragment;

/* loaded from: classes.dex */
public final class u52 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ int f27117a;

    /* renamed from: b */
    public final /* synthetic */ PlaybackSupportFragment f27118b;

    public /* synthetic */ u52(PlaybackSupportFragment playbackSupportFragment, int i) {
        this.f27117a = i;
        this.f27118b = playbackSupportFragment;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f27117a) {
            case 0:
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                PlaybackSupportFragment playbackSupportFragment = this.f27118b;
                playbackSupportFragment.f5160K0 = intValue;
                View view = playbackSupportFragment.f5192v0;
                if (view != null) {
                    view.getBackground().setAlpha(intValue);
                    return;
                }
                return;
            default:
                PlaybackSupportFragment playbackSupportFragment2 = this.f27118b;
                if (playbackSupportFragment2.getVerticalGridView() != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int childCount = playbackSupportFragment2.getVerticalGridView().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = playbackSupportFragment2.getVerticalGridView().getChildAt(i);
                        if (playbackSupportFragment2.getVerticalGridView().getChildAdapterPosition(childAt) > 0) {
                            childAt.setAlpha(floatValue);
                            childAt.setTranslationY((1.0f - floatValue) * playbackSupportFragment2.f5153D0);
                        }
                    }
                    return;
                }
                return;
        }
    }
}
