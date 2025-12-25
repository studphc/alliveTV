package p000;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0088b;

/* loaded from: classes.dex */
public abstract class gn1 implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Rect f17775a;

    /* renamed from: b */
    public static int m4959b(ListAdapter listAdapter, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public abstract void mo221a(MenuBuilder menuBuilder);

    /* renamed from: c */
    public abstract void mo222c(View view);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: d */
    public abstract void mo223d(boolean z);

    /* renamed from: e */
    public abstract void mo224e(int i);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: f */
    public abstract void mo225f(int i);

    /* renamed from: g */
    public abstract void mo226g(PopupWindow.OnDismissListener onDismissListener);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    /* renamed from: h */
    public abstract void mo227h(boolean z);

    /* renamed from: i */
    public abstract void mo228i(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        MenuAdapter menuAdapter;
        int i2;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) listAdapter;
        }
        MenuBuilder menuBuilder = menuAdapter.f880a;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i);
        if (!(this instanceof ViewOnKeyListenerC0088b)) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        menuBuilder.performItemAction(menuItem, this, i2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
    }
}
