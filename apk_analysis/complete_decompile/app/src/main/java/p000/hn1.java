package p000;

import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPopupHelper;

/* loaded from: classes.dex */
public final class hn1 implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ MenuPopupHelper f18106a;

    public hn1(MenuPopupHelper menuPopupHelper) {
        this.f18106a = menuPopupHelper;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f18106a.onDismiss();
    }
}
