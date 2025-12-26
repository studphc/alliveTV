package p000;

import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* renamed from: h9 */
/* loaded from: classes.dex */
public final class C1261h9 implements MenuPresenter.Callback {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f17979a;

    public C1261h9(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f17979a = layoutInflaterFactory2C0084e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        boolean z2;
        int i;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState;
        MenuBuilder rootMenu = menuBuilder.getRootMenu();
        int i2 = 0;
        if (rootMenu != menuBuilder) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            menuBuilder = rootMenu;
        }
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f17979a;
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = layoutInflaterFactory2C0084e.f698M;
        if (appCompatDelegateImpl$PanelFeatureStateArr != null) {
            i = appCompatDelegateImpl$PanelFeatureStateArr.length;
        } else {
            i = 0;
        }
        while (true) {
            if (i2 < i) {
                appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArr[i2];
                if (appCompatDelegateImpl$PanelFeatureState != null && appCompatDelegateImpl$PanelFeatureState.f610h == menuBuilder) {
                    break;
                } else {
                    i2++;
                }
            } else {
                appCompatDelegateImpl$PanelFeatureState = null;
                break;
            }
        }
        if (appCompatDelegateImpl$PanelFeatureState != null) {
            if (z2) {
                layoutInflaterFactory2C0084e.m181i(appCompatDelegateImpl$PanelFeatureState.f603a, appCompatDelegateImpl$PanelFeatureState, rootMenu);
                layoutInflaterFactory2C0084e.m183k(appCompatDelegateImpl$PanelFeatureState, true);
            } else {
                layoutInflaterFactory2C0084e.m183k(appCompatDelegateImpl$PanelFeatureState, z);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback callback;
        if (menuBuilder == menuBuilder.getRootMenu()) {
            LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f17979a;
            if (layoutInflaterFactory2C0084e.f692G && (callback = layoutInflaterFactory2C0084e.f722l.getCallback()) != null && !layoutInflaterFactory2C0084e.f703R) {
                callback.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
        return true;
    }
}
