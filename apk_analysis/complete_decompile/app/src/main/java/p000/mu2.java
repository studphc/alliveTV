package p000;

import androidx.appcompat.app.C0086g;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* loaded from: classes.dex */
public final class mu2 implements MenuPresenter.Callback {

    /* renamed from: a */
    public boolean f23132a;

    /* renamed from: b */
    public final /* synthetic */ C0086g f23133b;

    public mu2(C0086g c0086g) {
        this.f23133b = c0086g;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f23132a) {
            return;
        }
        this.f23132a = true;
        C0086g c0086g = this.f23133b;
        c0086g.f738a.dismissPopupMenus();
        c0086g.f739b.onPanelClosed(108, menuBuilder);
        this.f23132a = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        this.f23133b.f739b.onMenuOpened(108, menuBuilder);
        return true;
    }
}
