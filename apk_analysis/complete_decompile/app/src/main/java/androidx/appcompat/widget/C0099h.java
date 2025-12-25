package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.PopupMenu;

/* renamed from: androidx.appcompat.widget.h */
/* loaded from: classes.dex */
public final class C0099h implements MenuBuilder.Callback {

    /* renamed from: a */
    public final /* synthetic */ PopupMenu f1620a;

    public C0099h(PopupMenu popupMenu) {
        this.f1620a = popupMenu;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PopupMenu.OnMenuItemClickListener onMenuItemClickListener = this.f1620a.f1333e;
        if (onMenuItemClickListener != null) {
            return onMenuItemClickListener.onMenuItemClick(menuItem);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
