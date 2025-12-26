package p000;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public final class dn1 extends ActionProvider implements ActionProvider.VisibilityListener {

    /* renamed from: d */
    public ActionProvider.VisibilityListener f16442d;

    /* renamed from: e */
    public final android.view.ActionProvider f16443e;

    /* renamed from: f */
    public final /* synthetic */ MenuItemWrapperICS f16444f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn1(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
        super(context);
        this.f16444f = menuItemWrapperICS;
        this.f16443e = actionProvider;
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean hasSubMenu() {
        return this.f16443e.hasSubMenu();
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean isVisible() {
        return this.f16443e.isVisible();
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        ActionProvider.VisibilityListener visibilityListener = this.f16442d;
        if (visibilityListener != null) {
            visibilityListener.onActionProviderVisibilityChanged(z);
        }
    }

    @Override // androidx.core.view.ActionProvider
    public final View onCreateActionView(MenuItem menuItem) {
        return this.f16443e.onCreateActionView(menuItem);
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean onPerformDefaultAction() {
        return this.f16443e.onPerformDefaultAction();
    }

    @Override // androidx.core.view.ActionProvider
    public final void onPrepareSubMenu(SubMenu subMenu) {
        this.f16443e.onPrepareSubMenu(this.f16444f.m6347b(subMenu));
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean overridesItemVisibility() {
        return this.f16443e.overridesItemVisibility();
    }

    @Override // androidx.core.view.ActionProvider
    public final void refreshVisibility() {
        this.f16443e.refreshVisibility();
    }

    @Override // androidx.core.view.ActionProvider
    public final void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
        dn1 dn1Var;
        this.f16442d = visibilityListener;
        if (visibilityListener != null) {
            dn1Var = this;
        } else {
            dn1Var = null;
        }
        this.f16443e.setVisibilityListener(dn1Var);
    }

    @Override // androidx.core.view.ActionProvider
    public final View onCreateActionView() {
        return this.f16443e.onCreateActionView();
    }
}
