package androidx.leanback.widget;

import android.view.KeyEvent;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.ListRowPresenter;

/* renamed from: androidx.leanback.widget.j1 */
/* loaded from: classes.dex */
public final class C0350j1 implements BaseGridView.OnUnhandledKeyListener {

    /* renamed from: a */
    public final /* synthetic */ ListRowPresenter.ViewHolder f6312a;

    public C0350j1(ListRowPresenter.ViewHolder viewHolder) {
        this.f6312a = viewHolder;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
    public final boolean onUnhandledKey(KeyEvent keyEvent) {
        ListRowPresenter.ViewHolder viewHolder = this.f6312a;
        if (viewHolder.getOnKeyListener() != null && viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        return false;
    }
}
