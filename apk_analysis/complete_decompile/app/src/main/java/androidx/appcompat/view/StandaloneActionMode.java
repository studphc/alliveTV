package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: c */
    public final Context f790c;

    /* renamed from: d */
    public final ActionBarContextView f791d;

    /* renamed from: e */
    public final ActionMode.Callback f792e;

    /* renamed from: f */
    public WeakReference f793f;

    /* renamed from: g */
    public boolean f794g;

    /* renamed from: h */
    public final boolean f795h;

    /* renamed from: i */
    public final MenuBuilder f796i;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f790c = context;
        this.f791d = actionBarContextView;
        this.f792e = callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f796i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f795h = z;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void finish() {
        if (this.f794g) {
            return;
        }
        this.f794g = true;
        this.f792e.onDestroyActionMode(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View getCustomView() {
        WeakReference weakReference = this.f793f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu getMenu() {
        return this.f796i;
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f791d.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f791d.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getTitle() {
        return this.f791d.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void invalidate() {
        this.f792e.onPrepareActionMode(this, this.f796i);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isTitleOptional() {
        return this.f791d.isTitleOptional();
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isUiFocusable() {
        return this.f795h;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return this.f792e.onActionItemClicked(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        invalidate();
        this.f791d.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f791d.getContext(), subMenuBuilder).show();
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setCustomView(View view) {
        WeakReference weakReference;
        this.f791d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = null;
        }
        this.f793f = weakReference;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f791d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f791d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.f791d.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(int i) {
        setSubtitle(this.f790c.getString(i));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(int i) {
        setTitle(this.f790c.getString(i));
    }
}
