package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;
import p000.e70;
import p000.in1;
import p000.jn1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {

    /* renamed from: K */
    public static final Method f1323K;

    /* renamed from: J */
    public MenuItemHoverListener f1324J;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class MenuDropDownListView extends e70 {

        /* renamed from: m */
        public final int f1325m;

        /* renamed from: n */
        public final int f1326n;

        /* renamed from: o */
        public MenuItemHoverListener f1327o;

        /* renamed from: p */
        public MenuItemImpl f1328p;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1325m = 21;
                this.f1326n = 22;
            } else {
                this.f1325m = 22;
                this.f1326n = 21;
            }
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // p000.e70, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // p000.e70, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // p000.e70, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // p000.e70, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // p000.e70
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i, boolean z) {
            return super.lookForSelectablePosition(i, z);
        }

        @Override // p000.e70
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
            return super.measureHeightOfChildrenCompat(i, i2, i3, i4, i5);
        }

        @Override // p000.e70
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i) {
            return super.onForwardedEvent(motionEvent, i);
        }

        @Override // p000.e70, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            MenuAdapter menuAdapter;
            int i;
            MenuItemImpl menuItemImpl;
            int pointToPosition;
            int i2;
            if (this.f1327o != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i = 0;
                }
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < menuAdapter.getCount()) {
                    menuItemImpl = menuAdapter.getItem(i2);
                } else {
                    menuItemImpl = null;
                }
                MenuItemImpl menuItemImpl2 = this.f1328p;
                if (menuItemImpl2 != menuItemImpl) {
                    MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItemImpl2 != null) {
                        this.f1327o.onItemHoverExit(adapterMenu, menuItemImpl2);
                    }
                    this.f1328p = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.f1327o.onItemHoverEnter(adapterMenu, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            MenuAdapter menuAdapter;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f1325m) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.f1326n) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                }
                menuAdapter.getAdapterMenu().close(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // p000.e70, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.f1327o = menuItemHoverListener;
        }

        @Override // p000.e70, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1323K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    /* renamed from: e */
    public final e70 mo251e(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.f1324J;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.f1324J;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverExit(menuBuilder, menuItem);
        }
    }

    public void setEnterTransition(Object obj) {
        in1.m5249a(this.f1296F, (Transition) obj);
    }

    public void setExitTransition(Object obj) {
        in1.m5250b(this.f1296F, (Transition) obj);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.f1324J = menuItemHoverListener;
    }

    public void setTouchModal(boolean z) {
        int i = Build.VERSION.SDK_INT;
        PopupWindow popupWindow = this.f1296F;
        if (i <= 28) {
            Method method = f1323K;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        jn1.m5444a(popupWindow, z);
    }
}
