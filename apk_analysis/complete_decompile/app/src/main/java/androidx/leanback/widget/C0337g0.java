package androidx.leanback.widget;

import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.RowHeaderPresenter;
import p000.ss0;

/* renamed from: androidx.leanback.widget.g0 */
/* loaded from: classes.dex */
public final class C0337g0 extends ss0 {

    /* renamed from: k */
    public ItemBridgeAdapter.ViewHolder f6298k;

    @Override // p000.ss0
    /* renamed from: b */
    public final void mo1498b(float f) {
        ItemBridgeAdapter.ViewHolder viewHolder = this.f6298k;
        Presenter presenter = viewHolder.getPresenter();
        if (presenter instanceof RowHeaderPresenter) {
            ((RowHeaderPresenter) presenter).setSelectLevel((RowHeaderPresenter.ViewHolder) viewHolder.getViewHolder(), f);
        }
        super.mo1498b(f);
    }
}
