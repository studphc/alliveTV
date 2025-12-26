package p000;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.leanback.widget.SearchOrbView;
import com.google.android.exoplayer2.p003ui.DefaultTimeBar;

/* loaded from: classes.dex */
public final /* synthetic */ class jf2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ int f20488a;

    /* renamed from: b */
    public final /* synthetic */ View f20489b;

    public /* synthetic */ jf2(View view, int i) {
        this.f20488a = i;
        this.f20489b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f20489b;
        switch (this.f20488a) {
            case 0:
                int i = SearchOrbView.f6153s;
                SearchOrbView searchOrbView = (SearchOrbView) view;
                searchOrbView.getClass();
                searchOrbView.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            case 1:
                int i2 = SearchOrbView.f6153s;
                SearchOrbView searchOrbView2 = (SearchOrbView) view;
                searchOrbView2.getClass();
                searchOrbView2.setSearchOrbZ(valueAnimator.getAnimatedFraction());
                return;
            default:
                int i3 = DefaultTimeBar.DEFAULT_BAR_HEIGHT_DP;
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                defaultTimeBar.getClass();
                defaultTimeBar.f12017F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f12027a);
                return;
        }
    }
}
