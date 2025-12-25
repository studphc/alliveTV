package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a */
    public final int f816a;

    /* renamed from: b */
    public final int f817b;

    /* renamed from: c */
    public final int f818c;

    /* renamed from: d */
    public CharSequence f819d;

    /* renamed from: e */
    public CharSequence f820e;

    /* renamed from: f */
    public Intent f821f;

    /* renamed from: g */
    public char f822g;

    /* renamed from: i */
    public char f824i;

    /* renamed from: k */
    public Drawable f826k;

    /* renamed from: l */
    public final Context f827l;

    /* renamed from: m */
    public MenuItem.OnMenuItemClickListener f828m;

    /* renamed from: n */
    public CharSequence f829n;

    /* renamed from: o */
    public CharSequence f830o;

    /* renamed from: h */
    public int f823h = 4096;

    /* renamed from: j */
    public int f825j = 4096;

    /* renamed from: p */
    public ColorStateList f831p = null;

    /* renamed from: q */
    public PorterDuff.Mode f832q = null;

    /* renamed from: r */
    public boolean f833r = false;

    /* renamed from: s */
    public boolean f834s = false;

    /* renamed from: t */
    public int f835t = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f827l = context;
        this.f816a = i2;
        this.f817b = i;
        this.f818c = i4;
        this.f819d = charSequence;
    }

    /* renamed from: a */
    public final void m208a() {
        Drawable drawable = this.f826k;
        if (drawable != null) {
            if (this.f833r || this.f834s) {
                Drawable wrap = DrawableCompat.wrap(drawable);
                this.f826k = wrap;
                Drawable mutate = wrap.mutate();
                this.f826k = mutate;
                if (this.f833r) {
                    DrawableCompat.setTintList(mutate, this.f831p);
                }
                if (this.f834s) {
                    DrawableCompat.setTintMode(this.f826k, this.f832q);
                }
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f825j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f824i;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f829n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f817b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f826k;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f831p;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f832q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f821f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f816a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f823h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f822g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f818c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f819d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f820e;
        if (charSequence == null) {
            return this.f819d;
        }
        return charSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f830o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f828m;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.f821f;
        if (intent != null) {
            this.f827l.startActivity(intent);
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f835t & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f835t & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f835t & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.f835t & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f824i = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f835t = (z ? 1 : 0) | (this.f835t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        int i;
        int i2 = this.f835t & (-3);
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f835t = i | i2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        int i;
        int i2 = this.f835t & (-17);
        if (z) {
            i = 16;
        } else {
            i = 0;
        }
        this.f835t = i | i2;
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z) {
        int i;
        int i2 = this.f835t & (-5);
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        this.f835t = i | i2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f826k = drawable;
        m208a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f831p = colorStateList;
        this.f833r = true;
        m208a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f832q = mode;
        this.f834s = true;
        m208a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f821f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f822g = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f828m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f822g = c;
        this.f824i = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f819d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f820e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f835t & 8;
        if (z) {
            i = 0;
        }
        this.f835t = i2 | i;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f824i = Character.toLowerCase(c);
        this.f825j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f829n = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c, int i) {
        this.f822g = c;
        this.f823h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f819d = this.f827l.getResources().getString(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f830o = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f826k = ContextCompat.getDrawable(this.f827l, i);
        m208a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f822g = c;
        this.f823h = KeyEvent.normalizeMetaState(i);
        this.f824i = Character.toLowerCase(c2);
        this.f825j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }
}
