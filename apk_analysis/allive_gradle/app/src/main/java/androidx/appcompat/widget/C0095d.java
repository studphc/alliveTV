package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;
import p000.C1256h4;
import p000.C1293i4;
import p000.C1378k4;
import p000.C1498l4;
import p000.xy1;

/* renamed from: androidx.appcompat.widget.d */
/* loaded from: classes.dex */
public final class C0095d extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {

    /* renamed from: e */
    public C0093b f1597e;

    /* renamed from: f */
    public Drawable f1598f;

    /* renamed from: g */
    public boolean f1599g;

    /* renamed from: h */
    public boolean f1600h;

    /* renamed from: i */
    public boolean f1601i;

    /* renamed from: j */
    public int f1602j;

    /* renamed from: k */
    public int f1603k;

    /* renamed from: l */
    public int f1604l;

    /* renamed from: m */
    public boolean f1605m;

    /* renamed from: n */
    public final SparseBooleanArray f1606n;

    /* renamed from: o */
    public C1378k4 f1607o;

    /* renamed from: p */
    public C1256h4 f1608p;

    /* renamed from: q */
    public xy1 f1609q;

    /* renamed from: r */
    public C1293i4 f1610r;

    /* renamed from: s */
    public final C1498l4 f1611s;

    /* renamed from: t */
    public int f1612t;

    public C0095d(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f1606n = new SparseBooleanArray();
        this.f1611s = new C1498l4(this);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.f1610r == null) {
            this.f1610r = new C1293i4(this);
        }
        actionMenuItemView.setPopupCallback(this.f1610r);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1597e) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        ArrayList<MenuItemImpl> arrayList;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        MenuBuilder menuBuilder = this.mMenu;
        View view = null;
        boolean z5 = false;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i2 = this.f1604l;
        int i3 = this.f1603k;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        int i4 = 0;
        boolean z6 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            z = true;
            if (i4 >= i) {
                break;
            }
            MenuItemImpl menuItemImpl = arrayList.get(i4);
            if (menuItemImpl.requiresActionButton()) {
                i5++;
            } else if (menuItemImpl.requestsActionButton()) {
                i6++;
            } else {
                z6 = true;
            }
            if (this.f1605m && menuItemImpl.isActionViewExpanded()) {
                i2 = 0;
            }
            i4++;
        }
        if (this.f1600h && (z6 || i6 + i5 > i2)) {
            i2--;
        }
        int i7 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = this.f1606n;
        sparseBooleanArray.clear();
        int i8 = 0;
        int i9 = 0;
        while (i8 < i) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i8);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = getItemView(menuItemImpl2, view, viewGroup);
                itemView.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = itemView.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i9 == 0) {
                    i9 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, z);
                }
                menuItemImpl2.setIsActionButton(z);
                z2 = z5;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z7 = sparseBooleanArray.get(groupId2);
                if ((i7 > 0 || z7) && i3 > 0) {
                    z3 = z;
                } else {
                    z3 = z5;
                }
                if (z3) {
                    View itemView2 = getItemView(menuItemImpl2, view, viewGroup);
                    itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i9 == 0) {
                        i9 = measuredWidth2;
                    }
                    if (i3 + i9 > 0) {
                        z4 = z;
                    } else {
                        z4 = false;
                    }
                    z3 &= z4;
                }
                boolean z8 = z3;
                if (z8 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, z);
                } else if (z7) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i10 = 0; i10 < i8; i10++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i10);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i7++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z8) {
                    i7--;
                }
                menuItemImpl2.setIsActionButton(z8);
                z2 = false;
            } else {
                z2 = z5;
                menuItemImpl2.setIsActionButton(z2);
            }
            i8++;
            z5 = z2;
            view = null;
            z = true;
        }
        return z;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        int i;
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        if (menuItemImpl.isActionViewExpanded()) {
            i = 8;
        } else {
            i = 0;
        }
        actionView.setVisibility(i);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    /* renamed from: h */
    public final boolean m312h() {
        Object obj;
        xy1 xy1Var = this.f1609q;
        if (xy1Var != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(xy1Var);
            this.f1609q = null;
            return true;
        }
        C1378k4 c1378k4 = this.f1607o;
        if (c1378k4 != null) {
            c1378k4.dismiss();
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public final boolean m313i() {
        C1378k4 c1378k4 = this.f1607o;
        if (c1378k4 != null && c1378k4.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.f1601i) {
            this.f1600h = actionBarPolicy.showsOverflowMenuButton();
        }
        this.f1602j = actionBarPolicy.getEmbeddedMenuWidthLimit();
        this.f1604l = actionBarPolicy.getMaxActionButtons();
        int i = this.f1602j;
        if (this.f1600h) {
            if (this.f1597e == null) {
                C0093b c0093b = new C0093b(this, this.mSystemContext);
                this.f1597e = c0093b;
                if (this.f1599g) {
                    c0093b.setImageDrawable(this.f1598f);
                    this.f1598f = null;
                    this.f1599g = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1597e.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1597e.getMeasuredWidth();
        } else {
            this.f1597e = null;
        }
        this.f1603k = i;
        float f = resources.getDisplayMetrics().density;
    }

    /* renamed from: j */
    public final void m314j() {
        this.f1604l = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    /* renamed from: k */
    public final void m315k(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    /* renamed from: l */
    public final boolean m316l() {
        MenuBuilder menuBuilder;
        if (this.f1600h && !m313i() && (menuBuilder = this.mMenu) != null && this.mMenuView != null && this.f1609q == null && !menuBuilder.getNonActionItems().isEmpty()) {
            xy1 xy1Var = new xy1(1, this, new C1378k4(this, this.mContext, this.mMenu, this.f1597e));
            this.f1609q = xy1Var;
            ((View) this.mMenuView).post(xy1Var);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        m312h();
        C1256h4 c1256h4 = this.f1608p;
        if (c1256h4 != null) {
            c1256h4.dismiss();
        }
        super.onCloseMenu(menuBuilder, z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof ActionMenuPresenter$SavedState) && (i = ((ActionMenuPresenter$SavedState) parcelable).f1071a) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, java.lang.Object, androidx.appcompat.widget.ActionMenuPresenter$SavedState] */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        ?? obj = new Object();
        obj.f1071a = this.f1612t;
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        MenuItem item = subMenuBuilder2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == item) {
                    view = childAt;
                    break;
                }
                i++;
            }
        }
        if (view == null) {
            return false;
        }
        this.f1612t = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item2 = subMenuBuilder.getItem(i2);
            if (item2.isVisible() && item2.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        C1256h4 c1256h4 = new C1256h4(this, this.mContext, subMenuBuilder, view);
        this.f1608p = c1256h4;
        c1256h4.setForceShowIcon(z);
        this.f1608p.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public final void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z) {
        ArrayList<MenuItemImpl> arrayList;
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder = this.mMenu;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null) {
            arrayList = menuBuilder2.getNonActionItems();
        } else {
            arrayList = null;
        }
        if (this.f1600h && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1597e == null) {
                this.f1597e = new C0093b(this, this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1597e.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1597e);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.f1597e, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            C0093b c0093b = this.f1597e;
            if (c0093b != null) {
                Object parent = c0093b.getParent();
                Object obj = this.mMenuView;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1597e);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.f1600h);
    }
}
