package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;

/* renamed from: androidx.leanback.widget.p2 */
/* loaded from: classes.dex */
public final class C0375p2 extends Presenter.ViewHolder {

    /* renamed from: b */
    public final RowPresenter.ViewHolder f6344b;

    public C0375p2(RowContainerView rowContainerView, RowPresenter.ViewHolder viewHolder) {
        super(rowContainerView);
        rowContainerView.addView(viewHolder.view);
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.f6111c;
        if (viewHolder2 != null) {
            View view = viewHolder2.view;
            ViewGroup viewGroup = rowContainerView.f6096a;
            if (viewGroup.indexOfChild(view) < 0) {
                viewGroup.addView(view, 0);
            }
        }
        this.f6344b = viewHolder;
        viewHolder.f6110b = this;
    }
}
