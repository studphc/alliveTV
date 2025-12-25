package p000;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuItemWrapperICS;

/* loaded from: classes.dex */
public final class fn1 implements MenuItem.OnActionExpandListener {

    /* renamed from: a */
    public final MenuItem.OnActionExpandListener f17343a;

    /* renamed from: b */
    public final /* synthetic */ MenuItemWrapperICS f17344b;

    public fn1(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f17344b = menuItemWrapperICS;
        this.f17343a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f17343a.onMenuItemActionCollapse(this.f17344b.m6346a(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f17343a.onMenuItemActionExpand(this.f17344b.m6346a(menuItem));
    }
}
