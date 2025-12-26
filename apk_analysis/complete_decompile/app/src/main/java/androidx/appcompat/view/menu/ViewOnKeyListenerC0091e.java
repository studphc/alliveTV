package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import p000.ViewOnAttachStateChangeListenerC1162el;
import p000.ViewTreeObserverOnGlobalLayoutListenerC1933w4;
import p000.gn1;
import p000.hn1;

/* renamed from: androidx.appcompat.view.menu.e */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0091e extends gn1 implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: v */
    public static final int f994v = R.layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    public final Context f995b;

    /* renamed from: c */
    public final MenuBuilder f996c;

    /* renamed from: d */
    public final MenuAdapter f997d;

    /* renamed from: e */
    public final boolean f998e;

    /* renamed from: f */
    public final int f999f;

    /* renamed from: g */
    public final int f1000g;

    /* renamed from: h */
    public final int f1001h;

    /* renamed from: i */
    public final MenuPopupWindow f1002i;

    /* renamed from: l */
    public hn1 f1005l;

    /* renamed from: m */
    public View f1006m;

    /* renamed from: n */
    public View f1007n;

    /* renamed from: o */
    public MenuPresenter.Callback f1008o;

    /* renamed from: p */
    public ViewTreeObserver f1009p;

    /* renamed from: q */
    public boolean f1010q;

    /* renamed from: r */
    public boolean f1011r;

    /* renamed from: s */
    public int f1012s;

    /* renamed from: u */
    public boolean f1014u;

    /* renamed from: j */
    public final ViewTreeObserverOnGlobalLayoutListenerC1933w4 f1003j = new ViewTreeObserverOnGlobalLayoutListenerC1933w4(4, this);

    /* renamed from: k */
    public final ViewOnAttachStateChangeListenerC1162el f1004k = new ViewOnAttachStateChangeListenerC1162el(3, this);

    /* renamed from: t */
    public int f1013t = 0;

    public ViewOnKeyListenerC0091e(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f995b = context;
        this.f996c = menuBuilder;
        this.f998e = z;
        this.f997d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, f994v);
        this.f1000g = i;
        this.f1001h = i2;
        Resources resources = context.getResources();
        this.f999f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1006m = view;
        this.f1002i = new MenuPopupWindow(context, null, i, i2);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // p000.gn1
    /* renamed from: a */
    public final void mo221a(MenuBuilder menuBuilder) {
    }

    @Override // p000.gn1
    /* renamed from: c */
    public final void mo222c(View view) {
        this.f1006m = view;
    }

    @Override // p000.gn1
    /* renamed from: d */
    public final void mo223d(boolean z) {
        this.f997d.setForceShowIcon(z);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        if (isShowing()) {
            this.f1002i.dismiss();
        }
    }

    @Override // p000.gn1
    /* renamed from: e */
    public final void mo224e(int i) {
        this.f1013t = i;
    }

    @Override // p000.gn1
    /* renamed from: f */
    public final void mo225f(int i) {
        this.f1002i.setHorizontalOffset(i);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // p000.gn1
    /* renamed from: g */
    public final void mo226g(PopupWindow.OnDismissListener onDismissListener) {
        this.f1005l = (hn1) onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView getListView() {
        return this.f1002i.getListView();
    }

    @Override // p000.gn1
    /* renamed from: h */
    public final void mo227h(boolean z) {
        this.f1014u = z;
    }

    @Override // p000.gn1
    /* renamed from: i */
    public final void mo228i(int i) {
        this.f1002i.setVerticalOffset(i);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        if (!this.f1010q && this.f1002i.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f996c) {
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.f1008o;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f1010q = true;
        this.f996c.close();
        ViewTreeObserver viewTreeObserver = this.f1009p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1009p = this.f1007n.getViewTreeObserver();
            }
            this.f1009p.removeGlobalOnLayoutListener(this.f1003j);
            this.f1009p = null;
        }
        this.f1007n.removeOnAttachStateChangeListener(this.f1004k);
        hn1 hn1Var = this.f1005l;
        if (hn1Var != null) {
            hn1Var.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
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
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f995b, subMenuBuilder, this.f1007n, this.f998e, this.f1000g, this.f1001h);
            menuPopupHelper.setPresenterCallback(this.f1008o);
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    MenuItem item = subMenuBuilder.getItem(i);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            menuPopupHelper.setForceShowIcon(z);
            menuPopupHelper.setOnDismissListener(this.f1005l);
            this.f1005l = null;
            this.f996c.close(false);
            MenuPopupWindow menuPopupWindow = this.f1002i;
            int horizontalOffset = menuPopupWindow.getHorizontalOffset();
            int verticalOffset = menuPopupWindow.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.f1013t, this.f1006m.getLayoutDirection()) & 7) == 5) {
                horizontalOffset += this.f1006m.getWidth();
            }
            if (menuPopupHelper.tryShow(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.f1008o;
                if (callback != null) {
                    callback.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.f1008o = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        View view;
        boolean z;
        if (!isShowing()) {
            if (!this.f1010q && (view = this.f1006m) != null) {
                this.f1007n = view;
                MenuPopupWindow menuPopupWindow = this.f1002i;
                menuPopupWindow.setOnDismissListener(this);
                menuPopupWindow.setOnItemClickListener(this);
                menuPopupWindow.setModal(true);
                View view2 = this.f1007n;
                if (this.f1009p == null) {
                    z = true;
                } else {
                    z = false;
                }
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f1009p = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f1003j);
                }
                view2.addOnAttachStateChangeListener(this.f1004k);
                menuPopupWindow.setAnchorView(view2);
                menuPopupWindow.setDropDownGravity(this.f1013t);
                boolean z2 = this.f1011r;
                Context context = this.f995b;
                MenuAdapter menuAdapter = this.f997d;
                if (!z2) {
                    this.f1012s = gn1.m4959b(menuAdapter, context, this.f999f);
                    this.f1011r = true;
                }
                menuPopupWindow.setContentWidth(this.f1012s);
                menuPopupWindow.setInputMethodMode(2);
                menuPopupWindow.setEpicenterBounds(this.f17775a);
                menuPopupWindow.show();
                ListView listView = menuPopupWindow.getListView();
                listView.setOnKeyListener(this);
                if (this.f1014u) {
                    MenuBuilder menuBuilder = this.f996c;
                    if (menuBuilder.getHeaderTitle() != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
                        TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                        if (textView != null) {
                            textView.setText(menuBuilder.getHeaderTitle());
                        }
                        frameLayout.setEnabled(false);
                        listView.addHeaderView(frameLayout, null, false);
                    }
                }
                menuPopupWindow.setAdapter(menuAdapter);
                menuPopupWindow.show();
                return;
            }
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z) {
        this.f1011r = false;
        MenuAdapter menuAdapter = this.f997d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
