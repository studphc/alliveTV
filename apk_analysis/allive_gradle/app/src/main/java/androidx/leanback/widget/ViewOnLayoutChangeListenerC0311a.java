package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

/* renamed from: androidx.leanback.widget.a */
/* loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC0311a implements View.OnLayoutChangeListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractDetailsDescriptionPresenter.ViewHolder f6262a;

    public ViewOnLayoutChangeListenerC0311a(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder) {
        this.f6262a = viewHolder;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AbstractDetailsDescriptionPresenter.ViewHolder viewHolder = this.f6262a;
        if (viewHolder.f5531p == null) {
            viewHolder.f5531p = new ViewTreeObserverOnPreDrawListenerC0316b(viewHolder);
            viewHolder.view.getViewTreeObserver().addOnPreDrawListener(viewHolder.f5531p);
        }
    }
}
