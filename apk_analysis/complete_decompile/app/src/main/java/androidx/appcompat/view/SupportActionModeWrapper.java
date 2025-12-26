package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* renamed from: a */
    public final Context f797a;

    /* renamed from: b */
    public final ActionMode f798b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a */
        public final ActionMode.Callback f799a;

        /* renamed from: b */
        public final Context f800b;

        /* renamed from: c */
        public final ArrayList f801c = new ArrayList();

        /* renamed from: d */
        public final SimpleArrayMap f802d = new SimpleArrayMap();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f800b = context;
            this.f799a = callback;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            ArrayList arrayList = this.f801c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) arrayList.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f798b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f800b, actionMode);
            arrayList.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f799a.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.f800b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            android.view.ActionMode actionModeWrapper = getActionModeWrapper(actionMode);
            SimpleArrayMap simpleArrayMap = this.f802d;
            Menu menu2 = (Menu) simpleArrayMap.get(menu);
            if (menu2 == null) {
                menu2 = new MenuWrapperICS(this.f800b, (SupportMenu) menu);
                simpleArrayMap.put(menu, menu2);
            }
            return this.f799a.onCreateActionMode(actionModeWrapper, menu2);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f799a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            android.view.ActionMode actionModeWrapper = getActionModeWrapper(actionMode);
            SimpleArrayMap simpleArrayMap = this.f802d;
            Menu menu2 = (Menu) simpleArrayMap.get(menu);
            if (menu2 == null) {
                menu2 = new MenuWrapperICS(this.f800b, (SupportMenu) menu);
                simpleArrayMap.put(menu, menu2);
            }
            return this.f799a.onPrepareActionMode(actionModeWrapper, menu2);
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f797a = context;
        this.f798b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f798b.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f798b.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f797a, (SupportMenu) this.f798b.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f798b.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f798b.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f798b.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f798b.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f798b.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f798b.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f798b.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f798b.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f798b.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f798b.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f798b.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f798b.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f798b.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f798b.setTitle(i);
    }
}
