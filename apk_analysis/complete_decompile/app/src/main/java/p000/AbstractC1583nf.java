package p000;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* renamed from: nf */
/* loaded from: classes.dex */
public abstract class AbstractC1583nf {

    /* renamed from: a */
    public final Context f23344a;

    /* renamed from: b */
    public SimpleArrayMap f23345b;

    /* renamed from: c */
    public SimpleArrayMap f23346c;

    public AbstractC1583nf(Context context) {
        this.f23344a = context;
    }

    /* renamed from: a */
    public final MenuItem m6346a(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.f23345b == null) {
                this.f23345b = new SimpleArrayMap();
            }
            MenuItem menuItem2 = (MenuItem) this.f23345b.get(supportMenuItem);
            if (menuItem2 == null) {
                MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f23344a, supportMenuItem);
                this.f23345b.put(supportMenuItem, menuItemWrapperICS);
                return menuItemWrapperICS;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* renamed from: b */
    public final SubMenu m6347b(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.f23346c == null) {
                this.f23346c = new SimpleArrayMap();
            }
            SubMenu subMenu2 = (SubMenu) this.f23346c.get(supportSubMenu);
            if (subMenu2 == null) {
                vp2 vp2Var = new vp2(this.f23344a, supportSubMenu);
                this.f23346c.put(supportSubMenu, vp2Var);
                return vp2Var;
            }
            return subMenu2;
        }
        return subMenu;
    }
}
