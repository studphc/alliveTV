package p000;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* loaded from: classes.dex */
public final class ve2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ScrollingTabContainerView f27754a;

    public ve2(ScrollingTabContainerView scrollingTabContainerView) {
        this.f27754a = scrollingTabContainerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        ((we2) view).f28160a.select();
        ScrollingTabContainerView scrollingTabContainerView = this.f27754a;
        int childCount = scrollingTabContainerView.f1349c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = scrollingTabContainerView.f1349c.getChildAt(i);
            if (childAt == view) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }
}
