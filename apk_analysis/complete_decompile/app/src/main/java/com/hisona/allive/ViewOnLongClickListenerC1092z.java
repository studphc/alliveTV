package com.hisona.allive;

import android.view.View;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* renamed from: com.hisona.allive.z */
/* loaded from: classes2.dex */
public final class ViewOnLongClickListenerC1092z implements View.OnLongClickListener {

    /* renamed from: a */
    public final /* synthetic */ Presenter.ViewHolder f16022a;

    /* renamed from: b */
    public final /* synthetic */ Object f16023b;

    /* renamed from: c */
    public final /* synthetic */ RowPresenter.ViewHolder f16024c;

    /* renamed from: d */
    public final /* synthetic */ Row f16025d;

    /* renamed from: e */
    public final /* synthetic */ TvBaseRowsSupportFragment f16026e;

    public ViewOnLongClickListenerC1092z(TvBaseRowsSupportFragment tvBaseRowsSupportFragment, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        this.f16026e = tvBaseRowsSupportFragment;
        this.f16022a = viewHolder;
        this.f16023b = obj;
        this.f16024c = viewHolder2;
        this.f16025d = row;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        OnItemViewLongClickedListener onItemViewLongClickedListener = this.f16026e.mLongClickedListener;
        if (onItemViewLongClickedListener != null) {
            return onItemViewLongClickedListener.onItemLongClicked(this.f16022a, this.f16023b, this.f16024c, this.f16025d);
        }
        return false;
    }
}
