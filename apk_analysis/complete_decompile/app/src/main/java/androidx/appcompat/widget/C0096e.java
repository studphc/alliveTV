package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;

/* renamed from: androidx.appcompat.widget.e */
/* loaded from: classes.dex */
public final class C0096e implements MenuBuilder.Callback {

    /* renamed from: a */
    public final /* synthetic */ ActionMenuView f1613a;

    public C0096e(ActionMenuView actionMenuView) {
        this.f1613a = actionMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        ActionMenuView.OnMenuItemClickListener onMenuItemClickListener = this.f1613a.f1072A;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem)) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        MenuBuilder.Callback callback = this.f1613a.f1079v;
        if (callback != null) {
            callback.onMenuModeChange(menuBuilder);
        }
    }
}
