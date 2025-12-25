package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: a */
    public Context f870a;

    /* renamed from: b */
    public LayoutInflater f871b;

    /* renamed from: c */
    public MenuBuilder f872c;

    /* renamed from: d */
    public ExpandedMenuView f873d;

    /* renamed from: e */
    public int f874e;

    /* renamed from: f */
    public final int f875f;

    /* renamed from: g */
    public final int f876g;

    /* renamed from: h */
    public MenuPresenter.Callback f877h;

    /* renamed from: i */
    public C0089c f878i;

    /* renamed from: j */
    public int f879j;

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f870a = context;
        this.f871b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.f878i == null) {
            this.f878i = new C0089c(this);
        }
        return this.f878i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f879j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f873d == null) {
            this.f873d = (ExpandedMenuView) this.f871b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f878i == null) {
                this.f878i = new C0089c(this);
            }
            this.f873d.setAdapter((ListAdapter) this.f878i);
            this.f873d.setOnItemClickListener(this);
        }
        return this.f873d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        int i = this.f875f;
        if (i != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            this.f870a = contextThemeWrapper;
            this.f871b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f870a != null) {
            this.f870a = context;
            if (this.f871b == null) {
                this.f871b = LayoutInflater.from(context);
            }
        }
        this.f872c = menuBuilder;
        C0089c c0089c = this.f878i;
        if (c0089c != null) {
            c0089c.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f877h;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f872c.performItemAction(this.f878i.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.f873d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.view.menu.MenuPresenter$Callback, android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnKeyListener, java.lang.Object, androidx.appcompat.view.menu.d, android.content.DialogInterface$OnDismissListener] */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        ?? obj = new Object();
        obj.f991a = subMenuBuilder;
        AlertDialog.Builder builder = new AlertDialog.Builder(subMenuBuilder.getContext());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R.layout.abc_list_menu_item_layout);
        obj.f993c = listMenuPresenter;
        listMenuPresenter.setCallback(obj);
        subMenuBuilder.addMenuPresenter(obj.f993c);
        builder.setAdapter(obj.f993c.getAdapter(), obj);
        View headerView = subMenuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(subMenuBuilder.getHeaderIcon()).setTitle(subMenuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(obj);
        AlertDialog create = builder.create();
        obj.f992b = create;
        create.setOnDismissListener(obj);
        WindowManager.LayoutParams attributes = obj.f992b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        obj.f992b.show();
        MenuPresenter.Callback callback = this.f877h;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
            return true;
        }
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f873d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f873d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f877h = callback;
    }

    public void setId(int i) {
        this.f879j = i;
    }

    public void setItemIndexOffset(int i) {
        this.f874e = i;
        if (this.f873d != null) {
            updateMenuView(false);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        C0089c c0089c = this.f878i;
        if (c0089c != null) {
            c0089c.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i, int i2) {
        this.f876g = i;
        this.f875f = i2;
    }
}
