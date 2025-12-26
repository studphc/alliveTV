package p000;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.ViewUtils;
import androidx.leanback.widget.RecyclerViewParallax;

/* loaded from: classes.dex */
public final class h92 implements View.OnLayoutChangeListener {

    /* renamed from: a */
    public final /* synthetic */ int f17990a;

    /* renamed from: b */
    public final /* synthetic */ Object f17991b;

    public /* synthetic */ h92(int i, Object obj) {
        this.f17990a = i;
        this.f17991b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        switch (this.f17990a) {
            case 0:
                ((RecyclerViewParallax) this.f17991b).updateValues();
                return;
            default:
                SearchView searchView = (SearchView) this.f17991b;
                View view2 = searchView.f1401x;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f1395r.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(searchView);
                    if (searchView.f1375P) {
                        i9 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
                    } else {
                        i9 = 0;
                    }
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f1393p;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    if (isLayoutRtl) {
                        i10 = -rect.left;
                    } else {
                        i10 = paddingLeft - (rect.left + i9);
                    }
                    searchAutoComplete.setDropDownHorizontalOffset(i10);
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + i9) - paddingLeft);
                    return;
                }
                return;
        }
    }
}
