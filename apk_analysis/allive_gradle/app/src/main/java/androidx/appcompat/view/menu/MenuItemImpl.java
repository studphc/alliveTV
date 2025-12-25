package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;
import p000.cn1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: A */
    public View f913A;

    /* renamed from: B */
    public ActionProvider f914B;

    /* renamed from: C */
    public MenuItem.OnActionExpandListener f915C;

    /* renamed from: E */
    public ContextMenu.ContextMenuInfo f917E;

    /* renamed from: a */
    public final int f918a;

    /* renamed from: b */
    public final int f919b;

    /* renamed from: c */
    public final int f920c;

    /* renamed from: d */
    public final int f921d;

    /* renamed from: e */
    public CharSequence f922e;

    /* renamed from: f */
    public CharSequence f923f;

    /* renamed from: g */
    public Intent f924g;

    /* renamed from: h */
    public char f925h;

    /* renamed from: j */
    public char f927j;

    /* renamed from: l */
    public Drawable f929l;

    /* renamed from: n */
    public final MenuBuilder f931n;

    /* renamed from: o */
    public SubMenuBuilder f932o;

    /* renamed from: p */
    public Runnable f933p;

    /* renamed from: q */
    public MenuItem.OnMenuItemClickListener f934q;

    /* renamed from: r */
    public CharSequence f935r;

    /* renamed from: s */
    public CharSequence f936s;

    /* renamed from: z */
    public int f943z;

    /* renamed from: i */
    public int f926i = 4096;

    /* renamed from: k */
    public int f928k = 4096;

    /* renamed from: m */
    public int f930m = 0;

    /* renamed from: t */
    public ColorStateList f937t = null;

    /* renamed from: u */
    public PorterDuff.Mode f938u = null;

    /* renamed from: v */
    public boolean f939v = false;

    /* renamed from: w */
    public boolean f940w = false;

    /* renamed from: x */
    public boolean f941x = false;

    /* renamed from: y */
    public int f942y = 16;

    /* renamed from: D */
    public boolean f916D = false;

    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f931n = menuBuilder;
        this.f918a = i2;
        this.f919b = i;
        this.f920c = i3;
        this.f921d = i4;
        this.f922e = charSequence;
        this.f943z = i5;
    }

    /* renamed from: a */
    public static void m218a(int i, int i2, String str, StringBuilder sb) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public void actionFormatChanged() {
        MenuBuilder menuBuilder = this.f931n;
        menuBuilder.f897k = true;
        menuBuilder.onItemsChanged(true);
    }

    /* renamed from: b */
    public final Drawable m219b(Drawable drawable) {
        if (drawable != null && this.f941x && (this.f939v || this.f940w)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.f939v) {
                DrawableCompat.setTintList(drawable, this.f937t);
            }
            if (this.f940w) {
                DrawableCompat.setTintMode(drawable, this.f938u);
            }
            this.f941x = false;
        }
        return drawable;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f943z & 8) == 0) {
            return false;
        }
        if (this.f913A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f915C;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f931n.collapseItemActionView(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f915C;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.f931n.expandItemActionView(this);
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.f913A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.f914B;
        if (actionProvider != null) {
            View onCreateActionView = actionProvider.onCreateActionView(this);
            this.f913A = onCreateActionView;
            return onCreateActionView;
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f928k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f927j;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f935r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f919b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f929l;
        if (drawable != null) {
            return m219b(drawable);
        }
        if (this.f930m != 0) {
            Drawable drawable2 = AppCompatResources.getDrawable(this.f931n.getContext(), this.f930m);
            this.f930m = 0;
            this.f929l = drawable2;
            return m219b(drawable2);
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f937t;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f938u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f924g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f918a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f917E;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f926i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f925h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f920c;
    }

    public int getOrdering() {
        return this.f921d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f932o;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.f914B;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f922e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f923f;
        if (charSequence == null) {
            return this.f922e;
        }
        return charSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f936s;
    }

    public boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.f943z & 8) == 0) {
            return false;
        }
        if (this.f913A == null && (actionProvider = this.f914B) != null) {
            this.f913A = actionProvider.onCreateActionView(this);
        }
        if (this.f913A == null) {
            return false;
        }
        return true;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.f932o != null) {
            return true;
        }
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f934q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f931n;
        if (menuBuilder.mo212a(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.f933p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f924g != null) {
            try {
                menuBuilder.getContext().startActivity(this.f924g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        ActionProvider actionProvider = this.f914B;
        if (actionProvider != null && actionProvider.onPerformDefaultAction()) {
            return true;
        }
        return false;
    }

    public boolean isActionButton() {
        if ((this.f942y & 32) == 32) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f916D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f942y & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f942y & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f942y & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isExclusiveCheckable() {
        if ((this.f942y & 4) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.f914B;
        if (actionProvider != null && actionProvider.overridesItemVisibility()) {
            if ((this.f942y & 8) != 0 || !this.f914B.isVisible()) {
                return false;
            }
            return true;
        }
        if ((this.f942y & 8) != 0) {
            return false;
        }
        return true;
    }

    public boolean requestsActionButton() {
        if ((this.f943z & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        if ((this.f943z & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        if (!requiresActionButton() && !requestsActionButton()) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z) {
        this.f916D = z;
        this.f931n.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f927j == c) {
            return this;
        }
        this.f927j = Character.toLowerCase(c);
        this.f931n.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.f933p = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f942y;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.f942y = i2;
        if (i != i2) {
            this.f931n.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        boolean z2;
        int i;
        int i2 = this.f942y;
        int i3 = 2;
        if ((i2 & 4) != 0) {
            MenuBuilder menuBuilder = this.f931n;
            menuBuilder.getClass();
            int groupId = getGroupId();
            ArrayList arrayList = menuBuilder.f892f;
            int size = arrayList.size();
            menuBuilder.stopDispatchingItemsChanged();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i4);
                if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                    if (menuItemImpl == this) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i5 = menuItemImpl.f942y;
                    int i6 = i5 & (-3);
                    if (z2) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    int i7 = i | i6;
                    menuItemImpl.f942y = i7;
                    if (i5 != i7) {
                        menuItemImpl.f931n.onItemsChanged(false);
                    }
                }
            }
            menuBuilder.startDispatchingItemsChanged();
        } else {
            int i8 = i2 & (-3);
            if (!z) {
                i3 = 0;
            }
            int i9 = i8 | i3;
            this.f942y = i9;
            if (i2 != i9) {
                this.f931n.onItemsChanged(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f942y |= 16;
        } else {
            this.f942y &= -17;
        }
        this.f931n.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        int i;
        int i2 = this.f942y & (-5);
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        this.f942y = i | i2;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f930m = 0;
        this.f929l = drawable;
        this.f941x = true;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f937t = colorStateList;
        this.f939v = true;
        this.f941x = true;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f938u = mode;
        this.f940w = true;
        this.f941x = true;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f924g = intent;
        return this;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.f942y |= 32;
        } else {
            this.f942y &= -33;
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f925h == c) {
            return this;
        }
        this.f925h = c;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f915C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f934q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f925h = c;
        this.f927j = Character.toLowerCase(c2);
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f943z = i;
        MenuBuilder menuBuilder = this.f931n;
        menuBuilder.f897k = true;
        menuBuilder.onItemsChanged(true);
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.f932o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.f914B;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.f913A = null;
        this.f914B = actionProvider;
        this.f931n.onItemsChanged(true);
        ActionProvider actionProvider3 = this.f914B;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new cn1(this));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f922e = charSequence;
        this.f931n.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.f932o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f923f = charSequence;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        int i;
        int i2 = this.f942y;
        int i3 = i2 & (-9);
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        int i4 = i | i3;
        this.f942y = i4;
        if (i2 != i4) {
            MenuBuilder menuBuilder = this.f931n;
            menuBuilder.f894h = true;
            menuBuilder.onItemsChanged(true);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        return this.f931n.f906t;
    }

    public boolean showsTextAsAction() {
        if ((this.f943z & 4) == 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        CharSequence charSequence = this.f922e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f935r = charSequence;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f936s = charSequence;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(View view) {
        int i;
        this.f913A = view;
        this.f914B = null;
        if (view != null && view.getId() == -1 && (i = this.f918a) > 0) {
            view.setId(i);
        }
        MenuBuilder menuBuilder = this.f931n;
        menuBuilder.f897k = true;
        menuBuilder.onItemsChanged(true);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f927j == c && this.f928k == i) {
            return this;
        }
        this.f927j = Character.toLowerCase(c);
        this.f928k = KeyEvent.normalizeMetaState(i);
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f925h == c && this.f926i == i) {
            return this;
        }
        this.f925h = c;
        this.f926i = KeyEvent.normalizeMetaState(i);
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f925h = c;
        this.f926i = KeyEvent.normalizeMetaState(i);
        this.f927j = Character.toLowerCase(c2);
        this.f928k = KeyEvent.normalizeMetaState(i2);
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f929l = null;
        this.f930m = i;
        this.f941x = true;
        this.f931n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f931n.getContext().getString(i));
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(int i) {
        Context context = this.f931n.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }
}
