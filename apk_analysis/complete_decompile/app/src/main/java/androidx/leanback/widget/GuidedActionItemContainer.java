package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class GuidedActionItemContainer extends NonOverlappingLinearLayoutWithForeground {

    /* renamed from: a */
    public boolean f5787a;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        if (!this.f5787a && Util.isDescendant(this, view)) {
            View focusSearch = super.focusSearch(view, i);
            if (Util.isDescendant(this, focusSearch)) {
                return focusSearch;
            }
            return null;
        }
        return super.focusSearch(view, i);
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5787a = true;
    }
}
