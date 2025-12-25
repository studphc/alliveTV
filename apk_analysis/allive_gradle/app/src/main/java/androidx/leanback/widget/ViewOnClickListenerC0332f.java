package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.AbstractMediaItemPresenter;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.f */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0332f implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ Presenter.ViewHolder f6285a;

    /* renamed from: b */
    public final /* synthetic */ int f6286b;

    /* renamed from: c */
    public final /* synthetic */ AbstractMediaItemPresenter.ViewHolder f6287c;

    public ViewOnClickListenerC0332f(AbstractMediaItemPresenter.ViewHolder viewHolder, Presenter.ViewHolder viewHolder2, int i) {
        this.f6287c = viewHolder;
        this.f6285a = viewHolder2;
        this.f6286b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractMediaItemPresenter.ViewHolder viewHolder = this.f6287c;
        if (viewHolder.getOnItemViewClickedListener() != null) {
            viewHolder.getOnItemViewClickedListener().onItemClicked(this.f6285a, viewHolder.f5552z[this.f6286b], viewHolder, viewHolder.getRowObject());
        }
    }
}
