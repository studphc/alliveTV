package androidx.leanback.widget;

import android.view.KeyEvent;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.DetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.u */
/* loaded from: classes.dex */
public final class C0391u implements BaseGridView.OnUnhandledKeyListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsOverviewRowPresenter.ViewHolder f6418a;

    public C0391u(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6418a = viewHolder;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
    public final boolean onUnhandledKey(KeyEvent keyEvent) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6418a;
        if (viewHolder.getOnKeyListener() != null && viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        return false;
    }
}
