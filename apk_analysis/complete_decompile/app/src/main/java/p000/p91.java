package p000;

import android.widget.AbsListView;
import androidx.appcompat.widget.ListPopupWindow;

/* loaded from: classes.dex */
public final class p91 implements AbsListView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ ListPopupWindow f25076a;

    public p91(ListPopupWindow listPopupWindow) {
        this.f25076a = listPopupWindow;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            ListPopupWindow listPopupWindow = this.f25076a;
            if (!listPopupWindow.isInputMethodNotNeeded() && listPopupWindow.f1296F.getContentView() != null) {
                listPopupWindow.f1292B.removeCallbacks(listPopupWindow.f1319w);
                listPopupWindow.f1319w.run();
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
