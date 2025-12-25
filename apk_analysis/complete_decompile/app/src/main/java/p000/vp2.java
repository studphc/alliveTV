package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: classes.dex */
public final class vp2 extends MenuWrapperICS implements SubMenu {

    /* renamed from: e */
    public final SupportSubMenu f27913e;

    public vp2(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.f27913e = supportSubMenu;
    }

    @Override // android.view.SubMenu
    public final void clearHeader() {
        this.f27913e.clearHeader();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return m6346a(this.f27913e.getItem());
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        this.f27913e.setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        this.f27913e.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        this.f27913e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.f27913e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        this.f27913e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f27913e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f27913e.setIcon(drawable);
        return this;
    }
}
