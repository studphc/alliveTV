package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* renamed from: B */
    public final MenuBuilder f959B;

    /* renamed from: C */
    public final MenuItemImpl f960C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f959B = menuBuilder;
        this.f960C = menuItemImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    /* renamed from: a */
    public final boolean mo212a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        if (!super.mo212a(menuBuilder, menuItemImpl) && !this.f959B.mo212a(menuBuilder, menuItemImpl)) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.f959B.collapseItemActionView(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.f959B.expandItemActionView(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        int i;
        MenuItemImpl menuItemImpl = this.f960C;
        if (menuItemImpl != null) {
            i = menuItemImpl.getItemId();
        } else {
            i = 0;
        }
        if (i == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + i;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f960C;
    }

    public Menu getParentMenu() {
        return this.f959B;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.f959B.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isGroupDividerEnabled() {
        return this.f959B.isGroupDividerEnabled();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.f959B.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.f959B.isShortcutsVisible();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback callback) {
        this.f959B.setCallback(callback);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f959B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f960C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f959B.setQwertyMode(z);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean z) {
        this.f959B.setShortcutsVisible(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f960C.setIcon(i);
        return this;
    }
}
