package com.hisona.allive;

import android.view.View;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes2.dex */
public final class z implements View.OnLongClickListener {
    public final /* synthetic */ Presenter.ViewHolder a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ RowPresenter.ViewHolder c;
    public final /* synthetic */ Row d;
    public final /* synthetic */ TvBaseRowsSupportFragment e;

    public z(TvBaseRowsSupportFragment tvBaseRowsSupportFragment, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        this.e = tvBaseRowsSupportFragment;
        this.a = viewHolder;
        this.b = obj;
        this.c = viewHolder2;
        this.d = row;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        OnItemViewLongClickedListener onItemViewLongClickedListener = this.e.mLongClickedListener;
        if (onItemViewLongClickedListener != null) {
            return onItemViewLongClickedListener.onItemLongClicked(this.a, this.b, this.c, this.d);
        }
        return false;
    }
}
