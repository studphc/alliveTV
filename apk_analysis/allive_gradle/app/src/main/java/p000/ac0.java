package p000;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.FadeAndShortSlide;

/* loaded from: classes.dex */
public final class ac0 extends yy2 {

    /* renamed from: p */
    public final /* synthetic */ int f118p;

    public /* synthetic */ ac0(int i) {
        this.f118p = i;
    }

    @Override // p000.yy2
    /* renamed from: t */
    public float mo48t(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        int centerX;
        switch (this.f118p) {
            case 0:
                if (viewGroup.getLayoutDirection() == 1) {
                    return fadeAndShortSlide.m1371a(viewGroup) + view.getTranslationX();
                }
                return view.getTranslationX() - fadeAndShortSlide.m1371a(viewGroup);
            case 1:
                if (viewGroup.getLayoutDirection() == 1) {
                    return view.getTranslationX() - fadeAndShortSlide.m1371a(viewGroup);
                }
                return view.getTranslationX() + fadeAndShortSlide.m1371a(viewGroup);
            case 2:
                int width = (view.getWidth() / 2) + iArr[0];
                viewGroup.getLocationOnScreen(iArr);
                Rect epicenter = fadeAndShortSlide.getEpicenter();
                if (epicenter == null) {
                    centerX = (viewGroup.getWidth() / 2) + iArr[0];
                } else {
                    centerX = epicenter.centerX();
                }
                if (width < centerX) {
                    return view.getTranslationX() - fadeAndShortSlide.m1371a(viewGroup);
                }
                return view.getTranslationX() + fadeAndShortSlide.m1371a(viewGroup);
            default:
                return super.mo48t(fadeAndShortSlide, viewGroup, view, iArr);
        }
    }

    @Override // p000.yy2
    /* renamed from: u */
    public float mo49u(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        switch (this.f118p) {
            case 3:
                return fadeAndShortSlide.m1372b(viewGroup) + view.getTranslationY();
            case 4:
                return view.getTranslationY() - fadeAndShortSlide.m1372b(viewGroup);
            default:
                return super.mo49u(fadeAndShortSlide, viewGroup, view, iArr);
        }
    }
}
