package androidx.core.view;

import android.view.MenuItem;
import androidx.core.view.MenuItemCompat;

/* renamed from: androidx.core.view.c */
/* loaded from: classes.dex */
public final class MenuItemOnActionExpandListenerC0205c implements MenuItem.OnActionExpandListener {

    /* renamed from: a */
    public final /* synthetic */ MenuItemCompat.OnActionExpandListener f3972a;

    public MenuItemOnActionExpandListenerC0205c(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        this.f3972a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f3972a.onMenuItemActionCollapse(menuItem);
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f3972a.onMenuItemActionExpand(menuItem);
    }
}
