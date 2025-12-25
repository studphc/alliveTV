package p000;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public final class cn1 implements ActionProvider.VisibilityListener {

    /* renamed from: a */
    public final /* synthetic */ MenuItemImpl f8426a;

    public cn1(MenuItemImpl menuItemImpl) {
        this.f8426a = menuItemImpl;
    }

    @Override // androidx.core.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        MenuBuilder menuBuilder = this.f8426a.f931n;
        menuBuilder.f894h = true;
        menuBuilder.onItemsChanged(true);
    }
}
