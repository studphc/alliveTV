package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.AbstractMediaItemPresenter;

/* renamed from: androidx.leanback.widget.e */
/* loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC0328e implements View.OnFocusChangeListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractMediaItemPresenter.ViewHolder f6281a;

    public ViewOnFocusChangeListenerC0328e(AbstractMediaItemPresenter.ViewHolder viewHolder) {
        this.f6281a = viewHolder;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        AbstractMediaItemPresenter.ViewHolder viewHolder = this.f6281a;
        viewHolder.f5539B = AbstractMediaItemPresenter.m1381c(viewHolder.f5541o, view, viewHolder.f5539B, false);
    }
}
