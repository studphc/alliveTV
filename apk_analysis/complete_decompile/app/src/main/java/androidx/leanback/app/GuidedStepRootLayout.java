package androidx.leanback.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.leanback.widget.Util;

/* loaded from: classes.dex */
class GuidedStepRootLayout extends LinearLayout {

    /* renamed from: a */
    public boolean f5006a;

    /* renamed from: b */
    public boolean f5007b;

    public GuidedStepRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5006a = false;
        this.f5007b = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        View focusSearch = super.focusSearch(view, i);
        if (i == 17 || i == 66) {
            if (Util.isDescendant(this, focusSearch)) {
                return focusSearch;
            }
            if (getLayoutDirection() != 0 ? i == 66 : i == 17) {
                if (!this.f5006a) {
                    return view;
                }
            } else if (!this.f5007b) {
                return view;
            }
        }
        return focusSearch;
    }
}
