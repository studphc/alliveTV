package p000;

import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.app.C0086g;
import androidx.appcompat.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public final class nu2 implements MenuBuilder.Callback {

    /* renamed from: a */
    public final /* synthetic */ C0086g f23503a;

    public nu2(C0086g c0086g) {
        this.f23503a = c0086g;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        C0086g c0086g = this.f23503a;
        boolean isOverflowMenuShowing = c0086g.f738a.isOverflowMenuShowing();
        Window.Callback callback = c0086g.f739b;
        if (isOverflowMenuShowing) {
            callback.onPanelClosed(108, menuBuilder);
        } else if (callback.onPreparePanel(0, null, menuBuilder)) {
            callback.onMenuOpened(108, menuBuilder);
        }
    }
}
