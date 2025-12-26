package androidx.leanback.widget;

import androidx.leanback.widget.DetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.x */
/* loaded from: classes.dex */
public final class RunnableC0403x implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ DetailsOverviewRowPresenter.ViewHolder f6435a;

    public RunnableC0403x(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6435a = viewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6435a;
        DetailsOverviewRowPresenter.this.m1388c(viewHolder);
    }
}
