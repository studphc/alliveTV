package p000;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final class ju2 implements MenuBuilder.Callback {

    /* renamed from: a */
    public final /* synthetic */ Toolbar f20641a;

    public ju2(Toolbar toolbar) {
        this.f20641a = toolbar;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuBuilder.Callback callback = this.f20641a.f1510O;
        if (callback != null && callback.onMenuItemSelected(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        Toolbar toolbar = this.f20641a;
        if (!toolbar.f1516a.isOverflowMenuShowing()) {
            toolbar.f1502G.onPrepareMenu(menuBuilder);
        }
        MenuBuilder.Callback callback = toolbar.f1510O;
        if (callback != null) {
            callback.onMenuModeChange(menuBuilder);
        }
    }
}
