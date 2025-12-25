package p000;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.leanback.app.PlaybackFragment;

/* loaded from: classes.dex */
public final class h52 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ int f17944a;

    /* renamed from: b */
    public final /* synthetic */ PlaybackFragment f17945b;

    public /* synthetic */ h52(PlaybackFragment playbackFragment, int i) {
        this.f17944a = i;
        this.f17945b = playbackFragment;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f17944a) {
            case 0:
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                PlaybackFragment playbackFragment = this.f17945b;
                playbackFragment.f5107G = intValue;
                View view = playbackFragment.f5139r;
                if (view != null) {
                    view.getBackground().setAlpha(intValue);
                    return;
                }
                return;
            default:
                PlaybackFragment playbackFragment2 = this.f17945b;
                if (playbackFragment2.m1321b() != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int childCount = playbackFragment2.m1321b().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = playbackFragment2.m1321b().getChildAt(i);
                        if (playbackFragment2.m1321b().getChildAdapterPosition(childAt) > 0) {
                            childAt.setAlpha(floatValue);
                            childAt.setTranslationY((1.0f - floatValue) * playbackFragment2.f5147z);
                        }
                    }
                    return;
                }
                return;
        }
    }
}
