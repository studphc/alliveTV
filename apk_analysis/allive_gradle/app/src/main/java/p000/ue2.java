package p000;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* loaded from: classes.dex */
public final class ue2 extends BaseAdapter {

    /* renamed from: a */
    public final /* synthetic */ ScrollingTabContainerView f27241a;

    public ue2(ScrollingTabContainerView scrollingTabContainerView) {
        this.f27241a = scrollingTabContainerView;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f27241a.f1349c.getChildCount();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return ((we2) this.f27241a.f1349c.getChildAt(i)).f28160a;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f27241a.m260a((ActionBar.Tab) getItem(i), true);
        }
        we2 we2Var = (we2) view;
        we2Var.f28160a = (ActionBar.Tab) getItem(i);
        we2Var.m8056a();
        return view;
    }
}
