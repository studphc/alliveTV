package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.C1236gl;
import p000.ViewOnAttachStateChangeListenerC1162el;
import p000.ViewTreeObserverOnGlobalLayoutListenerC1933w4;
import p000.b01;
import p000.gn1;
import p000.hn1;

/* renamed from: androidx.appcompat.view.menu.b */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0088b extends gn1 implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B */
    public static final int f962B = R.layout.abc_cascading_menu_item_layout;

    /* renamed from: A */
    public boolean f963A;

    /* renamed from: b */
    public final Context f964b;

    /* renamed from: c */
    public final int f965c;

    /* renamed from: d */
    public final int f966d;

    /* renamed from: e */
    public final int f967e;

    /* renamed from: f */
    public final boolean f968f;

    /* renamed from: g */
    public final Handler f969g;

    /* renamed from: o */
    public View f977o;

    /* renamed from: p */
    public View f978p;

    /* renamed from: q */
    public int f979q;

    /* renamed from: r */
    public boolean f980r;

    /* renamed from: s */
    public boolean f981s;

    /* renamed from: t */
    public int f982t;

    /* renamed from: u */
    public int f983u;

    /* renamed from: w */
    public boolean f985w;

    /* renamed from: x */
    public MenuPresenter.Callback f986x;

    /* renamed from: y */
    public ViewTreeObserver f987y;

    /* renamed from: z */
    public hn1 f988z;

    /* renamed from: h */
    public final ArrayList f970h = new ArrayList();

    /* renamed from: i */
    public final ArrayList f971i = new ArrayList();

    /* renamed from: j */
    public final ViewTreeObserverOnGlobalLayoutListenerC1933w4 f972j = new ViewTreeObserverOnGlobalLayoutListenerC1933w4(3, this);

    /* renamed from: k */
    public final ViewOnAttachStateChangeListenerC1162el f973k = new ViewOnAttachStateChangeListenerC1162el(0, this);

    /* renamed from: l */
    public final b01 f974l = new b01(6, this);

    /* renamed from: m */
    public int f975m = 0;

    /* renamed from: n */
    public int f976n = 0;

    /* renamed from: v */
    public boolean f984v = false;

    public ViewOnKeyListenerC0088b(Context context, View view, int i, int i2, boolean z) {
        this.f964b = context;
        this.f977o = view;
        this.f966d = i;
        this.f967e = i2;
        this.f968f = z;
        this.f979q = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f965c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f969g = new Handler();
    }

    @Override // p000.gn1
    /* renamed from: a */
    public final void mo221a(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.f964b);
        if (isShowing()) {
            m229j(menuBuilder);
        } else {
            this.f970h.add(menuBuilder);
        }
    }

    @Override // p000.gn1
    /* renamed from: c */
    public final void mo222c(View view) {
        if (this.f977o != view) {
            this.f977o = view;
            this.f976n = GravityCompat.getAbsoluteGravity(this.f975m, view.getLayoutDirection());
        }
    }

    @Override // p000.gn1
    /* renamed from: d */
    public final void mo223d(boolean z) {
        this.f984v = z;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        ArrayList arrayList = this.f971i;
        int size = arrayList.size();
        if (size > 0) {
            C1236gl[] c1236glArr = (C1236gl[]) arrayList.toArray(new C1236gl[size]);
            for (int i = size - 1; i >= 0; i--) {
                C1236gl c1236gl = c1236glArr[i];
                if (c1236gl.f17746a.isShowing()) {
                    c1236gl.f17746a.dismiss();
                }
            }
        }
    }

    @Override // p000.gn1
    /* renamed from: e */
    public final void mo224e(int i) {
        if (this.f975m != i) {
            this.f975m = i;
            this.f976n = GravityCompat.getAbsoluteGravity(i, this.f977o.getLayoutDirection());
        }
    }

    @Override // p000.gn1
    /* renamed from: f */
    public final void mo225f(int i) {
        this.f980r = true;
        this.f982t = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // p000.gn1
    /* renamed from: g */
    public final void mo226g(PopupWindow.OnDismissListener onDismissListener) {
        this.f988z = (hn1) onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView getListView() {
        ArrayList arrayList = this.f971i;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C1236gl) AbstractC1726qj.m7053i(arrayList, 1)).f17746a.getListView();
    }

    @Override // p000.gn1
    /* renamed from: h */
    public final void mo227h(boolean z) {
        this.f985w = z;
    }

    @Override // p000.gn1
    /* renamed from: i */
    public final void mo228i(int i) {
        this.f981s = true;
        this.f983u = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        ArrayList arrayList = this.f971i;
        if (arrayList.size() <= 0 || !((C1236gl) arrayList.get(0)).f17746a.isShowing()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0136, code lost:
    
        if (((r7.getWidth() + r11[0]) + r5) > r10.right) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0138, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013b, code lost:
    
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0140, code lost:
    
        if ((r11[0] - r5) < 0) goto L60;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m229j(MenuBuilder menuBuilder) {
        boolean z;
        View view;
        C1236gl c1236gl;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        MenuItem menuItem;
        MenuAdapter menuAdapter;
        int i5;
        int firstVisiblePosition;
        Context context = this.f964b;
        LayoutInflater from = LayoutInflater.from(context);
        MenuAdapter menuAdapter2 = new MenuAdapter(menuBuilder, from, this.f968f, f962B);
        if (!isShowing() && this.f984v) {
            menuAdapter2.setForceShowIcon(true);
        } else if (isShowing()) {
            int size = menuBuilder.size();
            int i6 = 0;
            while (true) {
                if (i6 < size) {
                    MenuItem item = menuBuilder.getItem(i6);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i6++;
                } else {
                    z = false;
                    break;
                }
            }
            menuAdapter2.setForceShowIcon(z);
        }
        int m4959b = gn1.m4959b(menuAdapter2, context, this.f965c);
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(context, null, this.f966d, this.f967e);
        menuPopupWindow.setHoverListener(this.f974l);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.f977o);
        menuPopupWindow.setDropDownGravity(this.f976n);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        menuPopupWindow.setAdapter(menuAdapter2);
        menuPopupWindow.setContentWidth(m4959b);
        menuPopupWindow.setDropDownGravity(this.f976n);
        ArrayList arrayList = this.f971i;
        if (arrayList.size() > 0) {
            c1236gl = (C1236gl) AbstractC1726qj.m7053i(arrayList, 1);
            MenuBuilder menuBuilder2 = c1236gl.f17747b;
            int size2 = menuBuilder2.size();
            int i7 = 0;
            while (true) {
                if (i7 < size2) {
                    menuItem = menuBuilder2.getItem(i7);
                    if (menuItem.hasSubMenu() && menuBuilder == menuItem.getSubMenu()) {
                        break;
                    } else {
                        i7++;
                    }
                } else {
                    menuItem = null;
                    break;
                }
            }
            if (menuItem == null) {
                view = null;
            } else {
                ListView listView = c1236gl.f17746a.getListView();
                ListAdapter adapter = listView.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i5 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i5 = 0;
                }
                int count = menuAdapter.getCount();
                int i8 = 0;
                while (true) {
                    if (i8 < count) {
                        if (menuItem == menuAdapter.getItem(i8)) {
                            break;
                        } else {
                            i8++;
                        }
                    } else {
                        i8 = -1;
                        break;
                    }
                }
                if (i8 == -1 || (firstVisiblePosition = (i8 + i5) - listView.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= listView.getChildCount()) {
                    view = null;
                } else {
                    view = listView.getChildAt(firstVisiblePosition);
                }
            }
        } else {
            view = null;
            c1236gl = null;
        }
        if (view != null) {
            menuPopupWindow.setTouchModal(false);
            menuPopupWindow.setEnterTransition(null);
            ListView listView2 = ((C1236gl) arrayList.get(arrayList.size() - 1)).f17746a.getListView();
            int[] iArr = new int[2];
            listView2.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            this.f978p.getWindowVisibleDisplayFrame(rect);
            if (this.f979q == 1) {
            }
            if (i == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f979q = i;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindow.setAnchorView(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr2 = new int[2];
                this.f977o.getLocationOnScreen(iArr2);
                int[] iArr3 = new int[2];
                view.getLocationOnScreen(iArr3);
                if ((this.f976n & 7) == 5) {
                    iArr2[0] = this.f977o.getWidth() + iArr2[0];
                    iArr3[0] = view.getWidth() + iArr3[0];
                }
                i2 = iArr3[0] - iArr2[0];
                i3 = iArr3[1] - iArr2[1];
            }
            if ((this.f976n & 5) == 5) {
                if (z2) {
                    i4 = i2 + m4959b;
                } else {
                    i4 = i2 - view.getWidth();
                }
            } else if (z2) {
                i4 = i2 + view.getWidth();
            } else {
                i4 = i2 - m4959b;
            }
            menuPopupWindow.setHorizontalOffset(i4);
            menuPopupWindow.setOverlapAnchor(true);
            menuPopupWindow.setVerticalOffset(i3);
        } else {
            if (this.f980r) {
                menuPopupWindow.setHorizontalOffset(this.f982t);
            }
            if (this.f981s) {
                menuPopupWindow.setVerticalOffset(this.f983u);
            }
            menuPopupWindow.setEpicenterBounds(this.f17775a);
        }
        arrayList.add(new C1236gl(menuPopupWindow, menuBuilder, this.f979q));
        menuPopupWindow.show();
        ListView listView3 = menuPopupWindow.getListView();
        listView3.setOnKeyListener(this);
        if (c1236gl == null && this.f985w && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.getHeaderTitle());
            listView3.addHeaderView(frameLayout, null, false);
            menuPopupWindow.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int i;
        ArrayList arrayList = this.f971i;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                if (menuBuilder == ((C1236gl) arrayList.get(i2)).f17747b) {
                    break;
                } else {
                    i2++;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 < 0) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 < arrayList.size()) {
            ((C1236gl) arrayList.get(i3)).f17747b.close(false);
        }
        C1236gl c1236gl = (C1236gl) arrayList.remove(i2);
        c1236gl.f17747b.removeMenuPresenter(this);
        boolean z2 = this.f963A;
        MenuPopupWindow menuPopupWindow = c1236gl.f17746a;
        if (z2) {
            menuPopupWindow.setExitTransition(null);
            menuPopupWindow.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f979q = ((C1236gl) arrayList.get(size2 - 1)).f17748c;
        } else {
            if (this.f977o.getLayoutDirection() == 1) {
                i = 0;
            } else {
                i = 1;
            }
            this.f979q = i;
        }
        if (size2 == 0) {
            dismiss();
            MenuPresenter.Callback callback = this.f986x;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, true);
            }
            ViewTreeObserver viewTreeObserver = this.f987y;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.f987y.removeGlobalOnLayoutListener(this.f972j);
                }
                this.f987y = null;
            }
            this.f978p.removeOnAttachStateChangeListener(this.f973k);
            this.f988z.onDismiss();
            return;
        }
        if (z) {
            ((C1236gl) arrayList.get(0)).f17747b.close(false);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C1236gl c1236gl;
        ArrayList arrayList = this.f971i;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                c1236gl = (C1236gl) arrayList.get(i);
                if (!c1236gl.f17746a.isShowing()) {
                    break;
                } else {
                    i++;
                }
            } else {
                c1236gl = null;
                break;
            }
        }
        if (c1236gl != null) {
            c1236gl.f17747b.close(false);
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
        Iterator it = this.f971i.iterator();
        while (it.hasNext()) {
            C1236gl c1236gl = (C1236gl) it.next();
            if (subMenuBuilder == c1236gl.f17747b) {
                c1236gl.f17746a.getListView().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            mo221a(subMenuBuilder);
            MenuPresenter.Callback callback = this.f986x;
            if (callback != null) {
                callback.onOpenSubMenu(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.f986x = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        boolean z;
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.f970h;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m229j((MenuBuilder) it.next());
        }
        arrayList.clear();
        View view = this.f977o;
        this.f978p = view;
        if (view != null) {
            if (this.f987y == null) {
                z = true;
            } else {
                z = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f987y = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f972j);
            }
            this.f978p.addOnAttachStateChangeListener(this.f973k);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z) {
        Iterator it = this.f971i.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C1236gl) it.next()).f17746a.getListView().getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
