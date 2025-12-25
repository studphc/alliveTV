package androidx.leanback.widget;

import android.os.Handler;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.y */
/* loaded from: classes.dex */
public final class C0407y extends DetailsOverviewRow.Listener {

    /* renamed from: a */
    public final /* synthetic */ DetailsOverviewRowPresenter.ViewHolder f6438a;

    public C0407y(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6438a = viewHolder;
    }

    @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
    public final void onActionsAdapterChanged(DetailsOverviewRow detailsOverviewRow) {
        this.f6438a.m1389a(detailsOverviewRow.getActionsAdapter());
    }

    @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
    public final void onImageDrawableChanged(DetailsOverviewRow detailsOverviewRow) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6438a;
        Handler handler = viewHolder.f5637x;
        RunnableC0403x runnableC0403x = viewHolder.f5638y;
        handler.removeCallbacks(runnableC0403x);
        viewHolder.f5637x.post(runnableC0403x);
    }

    @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
    public final void onItemChanged(DetailsOverviewRow detailsOverviewRow) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6438a;
        Presenter.ViewHolder viewHolder2 = viewHolder.mDetailsDescriptionViewHolder;
        if (viewHolder2 != null) {
            DetailsOverviewRowPresenter.this.f5619e.onUnbindViewHolder(viewHolder2);
        }
        DetailsOverviewRowPresenter.this.f5619e.onBindViewHolder(viewHolder.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
    }
}
