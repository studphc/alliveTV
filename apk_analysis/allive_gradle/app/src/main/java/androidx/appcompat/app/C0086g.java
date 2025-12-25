package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import p000.ai2;
import p000.lu2;
import p000.mu2;
import p000.nu2;
import p000.sn1;

/* renamed from: androidx.appcompat.app.g */
/* loaded from: classes.dex */
public final class C0086g extends ActionBar {

    /* renamed from: a */
    public final ToolbarWidgetWrapper f738a;

    /* renamed from: b */
    public final Window.Callback f739b;

    /* renamed from: c */
    public final ai2 f740c;

    /* renamed from: d */
    public boolean f741d;

    /* renamed from: e */
    public boolean f742e;

    /* renamed from: f */
    public boolean f743f;

    /* renamed from: g */
    public final ArrayList f744g = new ArrayList();

    /* renamed from: h */
    public final sn1 f745h = new sn1(11, this);

    public C0086g(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        lu2 lu2Var = new lu2(this);
        Preconditions.checkNotNull(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f738a = toolbarWidgetWrapper;
        this.f739b = (Window.Callback) Preconditions.checkNotNull(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(lu2Var);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f740c = new ai2(6, this);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: a */
    public final void mo154a() {
        this.f738a.getViewGroup().removeCallbacks(this.f745h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f744g.add(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean closeOptionsMenu() {
        return this.f738a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean collapseActionView() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        if (toolbarWidgetWrapper.hasExpandedActionView()) {
            toolbarWidgetWrapper.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.f743f) {
            return;
        }
        this.f743f = z;
        ArrayList arrayList = this.f744g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ActionBar.OnMenuVisibilityListener) arrayList.get(i)).onMenuVisibilityChanged(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final View getCustomView() {
        return this.f738a.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getDisplayOptions() {
        return this.f738a.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final float getElevation() {
        return ViewCompat.getElevation(this.f738a.getViewGroup());
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getHeight() {
        return this.f738a.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getNavigationItemCount() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getNavigationMode() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getSelectedNavigationIndex() {
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final CharSequence getSubtitle() {
        return this.f738a.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionBar.Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getTabCount() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context getThemedContext() {
        return this.f738a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final CharSequence getTitle() {
        return this.f738a.getTitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void hide() {
        this.f738a.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean invalidateOptionsMenu() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        ViewGroup viewGroup = toolbarWidgetWrapper.getViewGroup();
        sn1 sn1Var = this.f745h;
        viewGroup.removeCallbacks(sn1Var);
        ViewCompat.postOnAnimation(toolbarWidgetWrapper.getViewGroup(), sn1Var);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean isShowing() {
        if (this.f738a.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        int i2;
        boolean z = this.f742e;
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        boolean z2 = true;
        if (!z) {
            toolbarWidgetWrapper.setMenuCallbacks(new mu2(this), new nu2(this));
            this.f742e = true;
        }
        Menu menu = toolbarWidgetWrapper.getMenu();
        if (menu == null) {
            return false;
        }
        if (keyEvent != null) {
            i2 = keyEvent.getDeviceId();
        } else {
            i2 = -1;
        }
        if (KeyCharacterMap.load(i2).getKeyboardType() == 1) {
            z2 = false;
        }
        menu.setQwertyMode(z2);
        return menu.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean openOptionsMenu() {
        return this.f738a.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f744g.remove(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setBackgroundDrawable(Drawable drawable) {
        this.f738a.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayHomeAsUpEnabled(boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayShowCustomEnabled(boolean z) {
        int i;
        if (z) {
            i = 16;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayShowHomeEnabled(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayShowTitleEnabled(boolean z) {
        int i;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setElevation(float f) {
        ViewCompat.setElevation(this.f738a.getViewGroup(), f);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeActionContentDescription(CharSequence charSequence) {
        this.f738a.setNavigationContentDescription(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeAsUpIndicator(Drawable drawable) {
        this.f738a.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeButtonEnabled(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setIcon(int i) {
        this.f738a.setIcon(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f738a.setDropdownParams(spinnerAdapter, new C0085f(onNavigationListener));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setLogo(int i) {
        this.f738a.setLogo(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setNavigationMode(int i) {
        if (i != 2) {
            this.f738a.setNavigationMode(i);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setSelectedNavigationItem(int i) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        if (toolbarWidgetWrapper.getNavigationMode() == 1) {
            toolbarWidgetWrapper.setDropdownSelectedPosition(i);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setShowHideAnimationEnabled(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setStackedBackgroundDrawable(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setSubtitle(CharSequence charSequence) {
        this.f738a.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setTitle(CharSequence charSequence) {
        this.f738a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        this.f738a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void show() {
        this.f738a.setVisibility(0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void addTab(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f738a.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayOptions(int i, int i2) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        toolbarWidgetWrapper.setDisplayOptions((i & i2) | ((~i2) & toolbarWidgetWrapper.getDisplayOptions()));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeActionContentDescription(int i) {
        this.f738a.setNavigationContentDescription(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeAsUpIndicator(int i) {
        this.f738a.setNavigationIcon(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setIcon(Drawable drawable) {
        this.f738a.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setLogo(Drawable drawable) {
        this.f738a.setLogo(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setSubtitle(int i) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        toolbarWidgetWrapper.setSubtitle(i != 0 ? toolbarWidgetWrapper.getContext().getText(i) : null);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setTitle(int i) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        toolbarWidgetWrapper.setTitle(i != 0 ? toolbarWidgetWrapper.getContext().getText(i) : null);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void addTab(ActionBar.Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void addTab(ActionBar.Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setCustomView(int i) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f738a;
        setCustomView(LayoutInflater.from(toolbarWidgetWrapper.getContext()).inflate(i, toolbarWidgetWrapper.getViewGroup(), false));
    }
}
