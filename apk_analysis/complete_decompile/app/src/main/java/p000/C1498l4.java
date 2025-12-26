package p000;

import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.C0095d;

/* renamed from: l4 */
/* loaded from: classes.dex */
public final class C1498l4 implements MenuPresenter.Callback {

    /* renamed from: a */
    public final /* synthetic */ C0095d f22319a;

    public C1498l4(C0095d c0095d) {
        this.f22319a = c0095d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder instanceof SubMenuBuilder) {
            menuBuilder.getRootMenu().close(false);
        }
        MenuPresenter.Callback callback = this.f22319a.getCallback();
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        MenuBuilder menuBuilder2;
        C0095d c0095d = this.f22319a;
        menuBuilder2 = ((BaseMenuPresenter) c0095d).mMenu;
        if (menuBuilder == menuBuilder2) {
            return false;
        }
        c0095d.f1612t = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
        MenuPresenter.Callback callback = c0095d.getCallback();
        if (callback == null) {
            return false;
        }
        return callback.onOpenSubMenu(menuBuilder);
    }
}
