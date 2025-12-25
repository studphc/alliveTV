package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;
import p000.AbstractC1583nf;
import p000.dn1;
import p000.en1;
import p000.fn1;
import p000.xq2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuItemWrapperICS extends AbstractC1583nf implements MenuItem {

    /* renamed from: d */
    public final SupportMenuItem f944d;

    /* renamed from: e */
    public Method f945e;

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.f944d = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f944d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f944d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = this.f944d.getSupportActionProvider();
        if (supportActionProvider instanceof dn1) {
            return ((dn1) supportActionProvider).f16443e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f944d.getActionView();
        if (actionView instanceof en1) {
            return (View) ((en1) actionView).f16916a;
        }
        return actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f944d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f944d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f944d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f944d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f944d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f944d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f944d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f944d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f944d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f944d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f944d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f944d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f944d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m6347b(this.f944d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f944d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f944d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f944d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f944d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f944d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f944d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f944d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f944d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f944d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        dn1 dn1Var = new dn1(this, this.f23344a, actionProvider);
        if (actionProvider == null) {
            dn1Var = null;
        }
        this.f944d.setSupportActionProvider(dn1Var);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new en1(view);
        }
        this.f944d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f944d.setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f944d.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f944d.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f944d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f944d.setEnabled(z);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            Method method = this.f945e;
            SupportMenuItem supportMenuItem = this.f944d;
            if (method == null) {
                this.f945e = supportMenuItem.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f945e.invoke(supportMenuItem, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f944d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f944d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f944d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f944d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f944d.setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        fn1 fn1Var;
        if (onActionExpandListener != null) {
            fn1Var = new fn1(this, onActionExpandListener);
        } else {
            fn1Var = null;
        }
        this.f944d.setOnActionExpandListener(fn1Var);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        xq2 xq2Var;
        if (onMenuItemClickListener != null) {
            xq2Var = new xq2(this, onMenuItemClickListener);
        } else {
            xq2Var = null;
        }
        this.f944d.setOnMenuItemClickListener(xq2Var);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f944d.setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f944d.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f944d.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f944d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f944d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f944d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f944d.setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f944d.setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f944d.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f944d.setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f944d.setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f944d.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        SupportMenuItem supportMenuItem = this.f944d;
        supportMenuItem.setActionView(i);
        View actionView = supportMenuItem.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            supportMenuItem.setActionView(new en1(actionView));
        }
        return this;
    }
}
