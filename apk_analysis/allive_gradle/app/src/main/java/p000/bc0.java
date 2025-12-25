package p000;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.FadeAndShortSlide;

/* loaded from: classes.dex */
public final class bc0 extends yy2 {

    /* renamed from: p */
    public final /* synthetic */ FadeAndShortSlide f7962p;

    public bc0(FadeAndShortSlide fadeAndShortSlide) {
        this.f7962p = fadeAndShortSlide;
    }

    @Override // p000.yy2
    /* renamed from: u */
    public final float mo49u(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        int centerY;
        int height = (view.getHeight() / 2) + iArr[1];
        viewGroup.getLocationOnScreen(iArr);
        Rect epicenter = this.f7962p.getEpicenter();
        if (epicenter == null) {
            centerY = (viewGroup.getHeight() / 2) + iArr[1];
        } else {
            centerY = epicenter.centerY();
        }
        if (height < centerY) {
            return view.getTranslationY() - fadeAndShortSlide.m1372b(viewGroup);
        }
        return fadeAndShortSlide.m1372b(viewGroup) + view.getTranslationY();
    }
}
