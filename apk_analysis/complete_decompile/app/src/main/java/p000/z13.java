package p000;

import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class z13 implements OnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ VerticalGridSupportFragment f29220a;

    public z13(VerticalGridSupportFragment verticalGridSupportFragment) {
        this.f29220a = verticalGridSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        Row row2 = row;
        VerticalGridSupportFragment verticalGridSupportFragment = this.f29220a;
        int selectedPosition = verticalGridSupportFragment.f5299F0.getGridView().getSelectedPosition();
        if (selectedPosition != verticalGridSupportFragment.f5303J0) {
            verticalGridSupportFragment.f5303J0 = selectedPosition;
            verticalGridSupportFragment.m1354n();
        }
        OnItemViewSelectedListener onItemViewSelectedListener = verticalGridSupportFragment.f5300G0;
        if (onItemViewSelectedListener != null) {
            onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row2);
        }
    }
}
