package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.c */
/* loaded from: classes.dex */
public final class C0089c extends BaseAdapter {

    /* renamed from: a */
    public int f989a = -1;

    /* renamed from: b */
    public final /* synthetic */ ListMenuPresenter f990b;

    public C0089c(ListMenuPresenter listMenuPresenter) {
        this.f990b = listMenuPresenter;
        m230a();
    }

    /* renamed from: a */
    public final void m230a() {
        ListMenuPresenter listMenuPresenter = this.f990b;
        MenuItemImpl expandedItem = listMenuPresenter.f872c.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = listMenuPresenter.f872c.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f989a = i;
                    return;
                }
            }
        }
        this.f989a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final MenuItemImpl getItem(int i) {
        ListMenuPresenter listMenuPresenter = this.f990b;
        ArrayList<MenuItemImpl> nonActionItems = listMenuPresenter.f872c.getNonActionItems();
        int i2 = i + listMenuPresenter.f874e;
        int i3 = this.f989a;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return nonActionItems.get(i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ListMenuPresenter listMenuPresenter = this.f990b;
        int size = listMenuPresenter.f872c.getNonActionItems().size() - listMenuPresenter.f874e;
        if (this.f989a < 0) {
            return size;
        }
        return size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            ListMenuPresenter listMenuPresenter = this.f990b;
            view = listMenuPresenter.f871b.inflate(listMenuPresenter.f876g, viewGroup, false);
        }
        ((MenuView.ItemView) view).initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        m230a();
        super.notifyDataSetChanged();
    }
}
