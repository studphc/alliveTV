package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {

    /* renamed from: A */
    public static final int[] f886A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    public final Context f887a;

    /* renamed from: b */
    public final Resources f888b;

    /* renamed from: c */
    public boolean f889c;

    /* renamed from: d */
    public boolean f890d;

    /* renamed from: e */
    public Callback f891e;

    /* renamed from: m */
    public ContextMenu.ContextMenuInfo f899m;

    /* renamed from: n */
    public CharSequence f900n;

    /* renamed from: o */
    public Drawable f901o;

    /* renamed from: p */
    public View f902p;

    /* renamed from: x */
    public MenuItemImpl f910x;

    /* renamed from: z */
    public boolean f912z;

    /* renamed from: l */
    public int f898l = 0;

    /* renamed from: q */
    public boolean f903q = false;

    /* renamed from: r */
    public boolean f904r = false;

    /* renamed from: s */
    public boolean f905s = false;

    /* renamed from: t */
    public boolean f906t = false;

    /* renamed from: u */
    public boolean f907u = false;

    /* renamed from: v */
    public final ArrayList f908v = new ArrayList();

    /* renamed from: w */
    public final CopyOnWriteArrayList f909w = new CopyOnWriteArrayList();

    /* renamed from: y */
    public boolean f911y = false;

    /* renamed from: f */
    public final ArrayList f892f = new ArrayList();

    /* renamed from: g */
    public final ArrayList f893g = new ArrayList();

    /* renamed from: h */
    public boolean f894h = true;

    /* renamed from: i */
    public final ArrayList f895i = new ArrayList();

    /* renamed from: j */
    public final ArrayList f896j = new ArrayList();

    /* renamed from: k */
    public boolean f897k = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f887a = context;
        this.f888b = context.getResources();
        m217f(true);
    }

    /* renamed from: a */
    public boolean mo212a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        Callback callback = this.f891e;
        if (callback != null && callback.onMenuItemSelected(menuBuilder, menuItemImpl)) {
            return true;
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        Intent intent2;
        int i6;
        PackageManager packageManager = this.f887a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i5 = queryIntentActivityOptions.size();
        } else {
            i5 = 0;
        }
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i7 = 0; i7 < i5; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            if (i8 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i8];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent4;
            }
        }
        return i5;
    }

    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 >= 0 && i5 < 6) {
            int i6 = (f886A[i5] << 16) | (65535 & i3);
            MenuItemImpl menuItemImpl = new MenuItemImpl(this, i, i2, i3, i6, charSequence, this.f898l);
            ContextMenu.ContextMenuInfo contextMenuInfo = this.f899m;
            if (contextMenuInfo != null) {
                menuItemImpl.f917E = contextMenuInfo;
            }
            ArrayList arrayList = this.f892f;
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (((MenuItemImpl) arrayList.get(size)).getOrdering() <= i6) {
                        i4 = size + 1;
                        break;
                    }
                    size--;
                } else {
                    i4 = 0;
                    break;
                }
            }
            arrayList.add(i4, menuItemImpl);
            onItemsChanged(true);
            return menuItemImpl;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.f887a);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* renamed from: b */
    public final MenuItemImpl m213b(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList arrayList = this.f908v;
        arrayList.clear();
        m214c(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (MenuItemImpl) arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (isQwertyMode) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((numericShortcut == cArr[0] && (metaState & 2) == 0) || ((numericShortcut == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && numericShortcut == '\b' && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final void m214c(ArrayList arrayList, int i, KeyEvent keyEvent) {
        char numericShortcut;
        int numericModifiers;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && i != 67) {
            return;
        }
        ArrayList arrayList2 = this.f892f;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList2.get(i2);
            if (menuItemImpl.hasSubMenu()) {
                ((MenuBuilder) menuItemImpl.getSubMenu()).m214c(arrayList, i, keyEvent);
            }
            if (isQwertyMode) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            if (isQwertyMode) {
                numericModifiers = menuItemImpl.getAlphabeticModifiers();
            } else {
                numericModifiers = menuItemImpl.getNumericModifiers();
            }
            if ((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == (numericModifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) && numericShortcut != 0) {
                char[] cArr = keyData.meta;
                if (numericShortcut != cArr[0] && numericShortcut != cArr[2]) {
                    if (isQwertyMode && numericShortcut == '\b') {
                        if (i != 67) {
                        }
                    }
                }
                if (menuItemImpl.isEnabled()) {
                    arrayList.add(menuItemImpl);
                }
            }
        }
    }

    public void changeMenuMode() {
        Callback callback = this.f891e;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.f910x;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.f892f.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.f903q = true;
        clear();
        clearHeader();
        this.f909w.clear();
        this.f903q = false;
        this.f904r = false;
        this.f905s = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.f901o = null;
        this.f900n = null;
        this.f902p = null;
        onItemsChanged(false);
    }

    public final void close(boolean z) {
        if (this.f907u) {
            return;
        }
        this.f907u = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                menuPresenter.onCloseMenu(this, z);
            }
        }
        this.f907u = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
        boolean z = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f910x == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.f910x = null;
            }
        }
        return z;
    }

    /* renamed from: d */
    public final void m215d(int i, boolean z) {
        if (i >= 0) {
            ArrayList arrayList = this.f892f;
            if (i < arrayList.size()) {
                arrayList.remove(i);
                if (z) {
                    onItemsChanged(true);
                }
            }
        }
    }

    /* renamed from: e */
    public final void m216e(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.f902p = view;
            this.f900n = null;
            this.f901o = null;
        } else {
            if (i > 0) {
                this.f900n = this.f888b.getText(i);
            } else if (charSequence != null) {
                this.f900n = charSequence;
            }
            if (i2 > 0) {
                this.f901o = ContextCompat.getDrawable(getContext(), i2);
            } else if (drawable != null) {
                this.f901o = drawable;
            }
            this.f902p = null;
        }
        onItemsChanged(false);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
        boolean z = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.f910x = menuItemImpl;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
    
        if (androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(android.view.ViewConfiguration.get(r3), r3) != false) goto L9;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m217f(boolean z) {
        boolean z2;
        if (z) {
            z2 = true;
            if (this.f888b.getConfiguration().keyboard != 1) {
                Context context = this.f887a;
            }
        }
        z2 = false;
        this.f890d = z2;
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f892f.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((MenuItemImpl) this.f892f.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (!this.f897k) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z |= menuPresenter.flagActionItems();
            }
        }
        ArrayList arrayList = this.f895i;
        ArrayList arrayList2 = this.f896j;
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            int size = visibleItems.size();
            for (int i = 0; i < size; i++) {
                MenuItemImpl menuItemImpl = visibleItems.get(i);
                if (menuItemImpl.isActionButton()) {
                    arrayList.add(menuItemImpl);
                } else {
                    arrayList2.add(menuItemImpl);
                }
            }
        } else {
            arrayList.clear();
            arrayList2.clear();
            arrayList2.addAll(getVisibleItems());
        }
        this.f897k = false;
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.f895i;
    }

    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return this.f887a;
    }

    public MenuItemImpl getExpandedItem() {
        return this.f910x;
    }

    public Drawable getHeaderIcon() {
        return this.f901o;
    }

    public CharSequence getHeaderTitle() {
        return this.f900n;
    }

    public View getHeaderView() {
        return this.f902p;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return (MenuItem) this.f892f.get(i);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.f896j;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        boolean z = this.f894h;
        ArrayList<MenuItemImpl> arrayList = this.f893g;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f892f;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList2.get(i);
            if (menuItemImpl.isVisible()) {
                arrayList.add(menuItemImpl);
            }
        }
        this.f894h = false;
        this.f897k = true;
        return arrayList;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f912z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((MenuItemImpl) this.f892f.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDispatchingItemsChanged() {
        return !this.f903q;
    }

    public boolean isGroupDividerEnabled() {
        return this.f911y;
    }

    public boolean isQwertyMode() {
        return this.f889c;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        if (m213b(i, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.f890d;
    }

    public void onItemsChanged(boolean z) {
        if (!this.f903q) {
            if (z) {
                this.f894h = true;
                this.f897k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
            if (!copyOnWriteArrayList.isEmpty()) {
                stopDispatchingItemsChanged();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                    if (menuPresenter == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        menuPresenter.updateMenuView(z);
                    }
                }
                startDispatchingItemsChanged();
                return;
            }
            return;
        }
        this.f904r = true;
        if (z) {
            this.f905s = true;
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, null, i);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        boolean z;
        MenuItemImpl m213b = m213b(i, keyEvent);
        if (m213b != null) {
            z = performItemAction(m213b, i2);
        } else {
            z = false;
        }
        if ((i2 & 2) != 0) {
            close(true);
        }
        return z;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            ArrayList arrayList = this.f892f;
            int size = arrayList.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((MenuItemImpl) arrayList.get(findGroupIndex)).getGroupId() != i) {
                    break;
                }
                m215d(findGroupIndex, false);
                i2 = i3;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m215d(findItemIndex(i), true);
    }

    public void removeItemAt(int i) {
        m215d(i, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 > 0 && (findItem = findItem(i2)) != null) {
            findItem.expandActionView();
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
            if (!copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                    if (menuPresenter == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        int id = menuPresenter.getId();
                        if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                            menuPresenter.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        Parcelable onSaveInstanceState;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
        if (!copyOnWriteArrayList.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public void setCallback(Callback callback) {
        this.f891e = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f899m = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        this.f898l = i;
        return this;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.f892f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f911y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.f892f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int i2;
        ArrayList arrayList = this.f892f;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i3);
            if (menuItemImpl.getGroupId() == i) {
                int i4 = menuItemImpl.f942y;
                int i5 = i4 & (-9);
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                int i6 = i5 | i2;
                menuItemImpl.f942y = i6;
                if (i4 != i6) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        m216e(0, null, 0, drawable, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        m216e(0, charSequence, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View view) {
        m216e(0, null, 0, null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z) {
        this.f906t = z;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.f912z = z;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f889c = z;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z) {
        if (this.f890d == z) {
            return;
        }
        m217f(z);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f892f.size();
    }

    public void startDispatchingItemsChanged() {
        this.f903q = false;
        if (this.f904r) {
            this.f904r = false;
            onItemsChanged(this.f905s);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.f903q) {
            this.f903q = true;
            this.f904r = false;
            this.f905s = false;
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return addInternal(0, 0, 0, this.f888b.getString(i));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.f909w.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.f897k = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f888b.getString(i));
    }

    public int findGroupIndex(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((MenuItemImpl) this.f892f.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f909w;
            if (!copyOnWriteArrayList.isEmpty()) {
                r0 = menuPresenter != null ? menuPresenter.onSubMenuSelected(subMenuBuilder) : false;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
                    if (menuPresenter2 == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!r0) {
                        r0 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
                    }
                }
            }
            invoke |= r0;
            if (!invoke) {
                close(true);
            }
        } else if ((i & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    public MenuBuilder setHeaderIconInt(int i) {
        m216e(0, null, i, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int i) {
        m216e(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f887a, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.f888b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f888b.getString(i4));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }
}
