package p000;

import androidx.leanback.app.VerticalGridFragment;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class x13 implements OnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ VerticalGridFragment f28423a;

    public x13(VerticalGridFragment verticalGridFragment) {
        this.f28423a = verticalGridFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        Row row2 = row;
        VerticalGridFragment verticalGridFragment = this.f28423a;
        int selectedPosition = verticalGridFragment.f5288B.getGridView().getSelectedPosition();
        if (selectedPosition != verticalGridFragment.f5292F) {
            verticalGridFragment.f5292F = selectedPosition;
            verticalGridFragment.m1353c();
        }
        OnItemViewSelectedListener onItemViewSelectedListener = verticalGridFragment.f5289C;
        if (onItemViewSelectedListener != null) {
            onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row2);
        }
    }
}
