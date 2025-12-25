package p000;

import android.view.Window;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* renamed from: w8 */
/* loaded from: classes.dex */
public final class C1937w8 implements MenuPresenter.Callback {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f28096a;

    public C1937w8(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f28096a = layoutInflaterFactory2C0084e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        this.f28096a.m182j(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback callback = this.f28096a.f722l.getCallback();
        if (callback != null) {
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
        return true;
    }
}
