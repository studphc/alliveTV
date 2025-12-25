package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.DetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.c0 */
/* loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC0321c0 implements View.OnLayoutChangeListener {

    /* renamed from: a */
    public final /* synthetic */ C0333f0 f6274a;

    public ViewOnLayoutChangeListenerC0321c0(C0333f0 c0333f0) {
        this.f6274a = c0333f0;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        view.removeOnLayoutChangeListener(this);
        C0333f0 c0333f0 = this.f6274a;
        DetailsOverviewRowPresenter.ViewHolder viewHolder = (DetailsOverviewRowPresenter.ViewHolder) c0333f0.f6288b.get();
        if (viewHolder != null) {
            ViewGroup viewGroup = viewHolder.f5630q;
            c0333f0.f6292f = viewGroup.getWidth();
            c0333f0.f6293g = viewGroup.getHeight();
        }
    }
}
