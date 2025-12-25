package androidx.leanback.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.leanback.widget.BrowseFrameLayout;

/* renamed from: androidx.leanback.widget.w2 */
/* loaded from: classes.dex */
public final class C0402w2 implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ TitleHelper f6434a;

    public C0402w2(TitleHelper titleHelper) {
        this.f6434a = titleHelper;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        int i2;
        TitleHelper titleHelper = this.f6434a;
        View view2 = titleHelper.f6237b;
        if (view != view2 && i == 33) {
            return view2;
        }
        if (ViewCompat.getLayoutDirection(view) == 1) {
            i2 = 17;
        } else {
            i2 = 66;
        }
        if (titleHelper.f6237b.hasFocus()) {
            if (i == 130 || i == i2) {
                return titleHelper.f6236a;
            }
            return null;
        }
        return null;
    }
}
