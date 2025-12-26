package androidx.leanback.widget;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

/* renamed from: androidx.leanback.widget.b */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0316b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractDetailsDescriptionPresenter.ViewHolder f6269a;

    public ViewTreeObserverOnPreDrawListenerC0316b(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder) {
        this.f6269a = viewHolder;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        int i;
        AbstractDetailsDescriptionPresenter.ViewHolder viewHolder = this.f6269a;
        int visibility = viewHolder.f5518c.getVisibility();
        TextView textView = viewHolder.f5517b;
        if (visibility == 0 && viewHolder.f5518c.getTop() > viewHolder.view.getHeight() && textView.getLineCount() > 1) {
            textView.setMaxLines(textView.getLineCount() - 1);
            return false;
        }
        if (textView.getLineCount() > 1) {
            i = viewHolder.f5526k;
        } else {
            i = viewHolder.f5525j;
        }
        TextView textView2 = viewHolder.f5519d;
        if (textView2.getMaxLines() != i) {
            textView2.setMaxLines(i);
            return false;
        }
        if (viewHolder.f5531p != null) {
            viewHolder.view.getViewTreeObserver().removeOnPreDrawListener(viewHolder.f5531p);
            viewHolder.f5531p = null;
        }
        return true;
    }
}
