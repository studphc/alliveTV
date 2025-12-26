package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.AbstractMediaItemPresenter;

/* renamed from: androidx.leanback.widget.d */
/* loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC0324d implements View.OnFocusChangeListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractMediaItemPresenter.ViewHolder f6277a;

    public ViewOnFocusChangeListenerC0324d(AbstractMediaItemPresenter.ViewHolder viewHolder) {
        this.f6277a = viewHolder;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        AbstractMediaItemPresenter.ViewHolder viewHolder = this.f6277a;
        viewHolder.f5539B = AbstractMediaItemPresenter.m1381c(viewHolder.f5541o, view, viewHolder.f5539B, true);
    }
}
