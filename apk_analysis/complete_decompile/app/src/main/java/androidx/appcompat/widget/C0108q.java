package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.q */
/* loaded from: classes.dex */
public final class C0108q implements MenuPresenter {

    /* renamed from: a */
    public MenuBuilder f1627a;

    /* renamed from: b */
    public MenuItemImpl f1628b;

    /* renamed from: c */
    public final /* synthetic */ Toolbar f1629c;

    public C0108q(Toolbar toolbar) {
        this.f1629c = toolbar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        Toolbar toolbar = this.f1629c;
        KeyEvent.Callback callback = toolbar.f1524i;
        if (callback instanceof CollapsibleActionView) {
            ((CollapsibleActionView) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f1524i);
        toolbar.removeView(toolbar.f1523h);
        toolbar.f1524i = null;
        ArrayList arrayList = toolbar.f1500E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f1628b = null;
        toolbar.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        toolbar.m298q();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        Toolbar toolbar = this.f1629c;
        toolbar.m286c();
        ViewParent parent = toolbar.f1523h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f1523h);
            }
            toolbar.addView(toolbar.f1523h);
        }
        View actionView = menuItemImpl.getActionView();
        toolbar.f1524i = actionView;
        this.f1628b = menuItemImpl;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f1524i);
            }
            Toolbar.LayoutParams generateDefaultLayoutParams = toolbar.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (toolbar.f1529n & 112) | GravityCompat.START;
            generateDefaultLayoutParams.f1563a = 2;
            toolbar.f1524i.setLayoutParams(generateDefaultLayoutParams);
            toolbar.addView(toolbar.f1524i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((Toolbar.LayoutParams) childAt.getLayoutParams()).f1563a != 2 && childAt != toolbar.f1516a) {
                toolbar.removeViewAt(childCount);
                toolbar.f1500E.add(childAt);
            }
        }
        toolbar.requestLayout();
        menuItemImpl.setActionViewExpanded(true);
        KeyEvent.Callback callback = toolbar.f1524i;
        if (callback instanceof CollapsibleActionView) {
            ((CollapsibleActionView) callback).onActionViewExpanded();
        }
        toolbar.m298q();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final MenuView getMenuView(ViewGroup viewGroup) {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        MenuItemImpl menuItemImpl;
        MenuBuilder menuBuilder2 = this.f1627a;
        if (menuBuilder2 != null && (menuItemImpl = this.f1628b) != null) {
            menuBuilder2.collapseItemActionView(menuItemImpl);
        }
        this.f1627a = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z) {
        if (this.f1628b != null) {
            MenuBuilder menuBuilder = this.f1627a;
            if (menuBuilder != null) {
                int size = menuBuilder.size();
                for (int i = 0; i < size; i++) {
                    if (this.f1627a.getItem(i) == this.f1628b) {
                        return;
                    }
                }
            }
            collapseItemActionView(this.f1627a, this.f1628b);
        }
    }
}
