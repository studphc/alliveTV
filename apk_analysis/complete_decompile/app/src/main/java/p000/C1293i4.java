package p000;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.C0095d;

/* renamed from: i4 */
/* loaded from: classes.dex */
public final class C1293i4 extends ActionMenuItemView.PopupCallback {

    /* renamed from: a */
    public final /* synthetic */ C0095d f18281a;

    public C1293i4(C0095d c0095d) {
        this.f18281a = c0095d;
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
    public final ShowableListMenu getPopup() {
        C1256h4 c1256h4 = this.f18281a.f1608p;
        if (c1256h4 != null) {
            return c1256h4.getPopup();
        }
        return null;
    }
}
