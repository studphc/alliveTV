package p000;

import android.view.View;
import androidx.appcompat.widget.ListPopupWindow;

/* loaded from: classes.dex */
public final class k91 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f20794a;

    /* renamed from: b */
    public final /* synthetic */ ListPopupWindow f20795b;

    public /* synthetic */ k91(ListPopupWindow listPopupWindow, int i) {
        this.f20794a = i;
        this.f20795b = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20794a) {
            case 0:
                ListPopupWindow listPopupWindow = this.f20795b;
                View anchorView = listPopupWindow.getAnchorView();
                if (anchorView != null && anchorView.getWindowToken() != null) {
                    listPopupWindow.show();
                    return;
                }
                return;
            case 1:
                this.f20795b.clearListSelection();
                return;
            default:
                ListPopupWindow listPopupWindow2 = this.f20795b;
                e70 e70Var = listPopupWindow2.f1299c;
                if (e70Var != null && e70Var.isAttachedToWindow() && listPopupWindow2.f1299c.getCount() > listPopupWindow2.f1299c.getChildCount() && listPopupWindow2.f1299c.getChildCount() <= listPopupWindow2.f1311o) {
                    listPopupWindow2.f1296F.setInputMethodMode(2);
                    listPopupWindow2.show();
                    return;
                }
                return;
        }
    }
}
