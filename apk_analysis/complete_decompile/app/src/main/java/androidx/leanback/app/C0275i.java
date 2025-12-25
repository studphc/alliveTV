package androidx.leanback.app;

import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;

/* renamed from: androidx.leanback.app.i */
/* loaded from: classes.dex */
public final class C0275i implements HeadersSupportFragment.OnHeaderViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseSupportFragment f5330a;

    public C0275i(BrowseSupportFragment browseSupportFragment) {
        this.f5330a = browseSupportFragment;
    }

    @Override // androidx.leanback.app.HeadersSupportFragment.OnHeaderViewSelectedListener
    public final void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
        BrowseSupportFragment browseSupportFragment = this.f5330a;
        int selectedPosition = browseSupportFragment.f4852K0.getSelectedPosition();
        if (browseSupportFragment.f4864W0) {
            browseSupportFragment.f4877j1.m90a(selectedPosition, 0, true);
        }
    }
}
