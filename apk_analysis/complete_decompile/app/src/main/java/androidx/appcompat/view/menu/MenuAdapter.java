package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a */
    public final MenuBuilder f880a;

    /* renamed from: b */
    public int f881b = -1;

    /* renamed from: c */
    public boolean f882c;

    /* renamed from: d */
    public final boolean f883d;

    /* renamed from: e */
    public final LayoutInflater f884e;

    /* renamed from: f */
    public final int f885f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.f883d = z;
        this.f884e = layoutInflater;
        this.f880a = menuBuilder;
        this.f885f = i;
        m211a();
    }

    /* renamed from: a */
    public final void m211a() {
        MenuBuilder menuBuilder = this.f880a;
        MenuItemImpl expandedItem = menuBuilder.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = menuBuilder.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f881b = i;
                    return;
                }
            }
        }
        this.f881b = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.f880a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> visibleItems;
        boolean z = this.f883d;
        MenuBuilder menuBuilder = this.f880a;
        if (z) {
            visibleItems = menuBuilder.getNonActionItems();
        } else {
            visibleItems = menuBuilder.getVisibleItems();
        }
        if (this.f881b < 0) {
            return visibleItems.size();
        }
        return visibleItems.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.f882c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z;
        if (view == null) {
            view = this.f884e.inflate(this.f885f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i3 = i - 1;
        if (i3 >= 0) {
            i2 = getItem(i3).getGroupId();
        } else {
            i2 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f880a.isGroupDividerEnabled() && groupId != i2) {
            z = true;
        } else {
            z = false;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f882c) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m211a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z) {
        this.f882c = z;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        boolean z = this.f883d;
        MenuBuilder menuBuilder = this.f880a;
        ArrayList<MenuItemImpl> nonActionItems = z ? menuBuilder.getNonActionItems() : menuBuilder.getVisibleItems();
        int i2 = this.f881b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }
}
