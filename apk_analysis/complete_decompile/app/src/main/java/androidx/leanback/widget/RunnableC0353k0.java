package androidx.leanback.widget;

import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.k0 */
/* loaded from: classes.dex */
public final class RunnableC0353k0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ FullWidthDetailsOverviewRowPresenter.ViewHolder f6314a;

    public RunnableC0353k0(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6314a = viewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6314a;
        Row row = viewHolder.getRow();
        if (row == null) {
            return;
        }
        FullWidthDetailsOverviewRowPresenter.this.f5646f.onBindViewHolder(viewHolder.f5659r, row);
    }
}
