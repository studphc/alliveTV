package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* renamed from: androidx.appcompat.widget.p */
/* loaded from: classes.dex */
public final class C0107p implements ActionMenuView.OnMenuItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ Toolbar f1626a;

    public C0107p(Toolbar toolbar) {
        this.f1626a = toolbar;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar toolbar = this.f1626a;
        if (toolbar.f1502G.onMenuItemSelected(menuItem)) {
            return true;
        }
        Toolbar.OnMenuItemClickListener onMenuItemClickListener = toolbar.f1504I;
        if (onMenuItemClickListener != null) {
            return onMenuItemClickListener.onMenuItemClick(menuItem);
        }
        return false;
    }
}
