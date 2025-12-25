package androidx.leanback.widget;

import android.view.KeyEvent;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.h0 */
/* loaded from: classes.dex */
public final class C0341h0 implements BaseGridView.OnUnhandledKeyListener {

    /* renamed from: a */
    public final /* synthetic */ FullWidthDetailsOverviewRowPresenter.ViewHolder f6302a;

    public C0341h0(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6302a = viewHolder;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
    public final boolean onUnhandledKey(KeyEvent keyEvent) {
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6302a;
        if (viewHolder.getOnKeyListener() != null) {
            return viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent);
        }
        return false;
    }
}
