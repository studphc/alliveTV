package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.AbstractMediaItemPresenter;
import androidx.leanback.widget.RowPresenter;

/* renamed from: androidx.leanback.widget.c */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0320c implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractMediaItemPresenter.ViewHolder f6273a;

    public ViewOnClickListenerC0320c(AbstractMediaItemPresenter.ViewHolder viewHolder) {
        this.f6273a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RowPresenter.ViewHolder viewHolder = this.f6273a;
        if (viewHolder.getOnItemViewClickedListener() != null) {
            viewHolder.getOnItemViewClickedListener().onItemClicked(null, null, viewHolder, viewHolder.getRowObject());
        }
    }
}
