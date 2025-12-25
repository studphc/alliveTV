package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import p000.AbstractC1583nf;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuWrapperICS extends AbstractC1583nf implements Menu {

    /* renamed from: d */
    public final SupportMenu f958d;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.f958d = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m6346a(this.f958d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.f958d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m6346a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m6347b(this.f958d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        SimpleArrayMap simpleArrayMap = this.f23345b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap simpleArrayMap2 = this.f23346c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
        this.f958d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f958d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return m6346a(this.f958d.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return m6346a(this.f958d.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f958d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f958d.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f958d.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f958d.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        if (this.f23345b != null) {
            int i2 = 0;
            while (i2 < this.f23345b.getF1755c()) {
                if (((SupportMenuItem) this.f23345b.keyAt(i2)).getGroupId() == i) {
                    this.f23345b.removeAt(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.f958d.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        if (this.f23345b != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f23345b.getF1755c()) {
                    break;
                }
                if (((SupportMenuItem) this.f23345b.keyAt(i2)).getItemId() == i) {
                    this.f23345b.removeAt(i2);
                    break;
                }
                i2++;
            }
        }
        this.f958d.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f958d.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f958d.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f958d.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f958d.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f958d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m6346a(this.f958d.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return m6347b(this.f958d.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m6346a(this.f958d.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m6347b(this.f958d.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m6346a(this.f958d.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m6347b(this.f958d.addSubMenu(i, i2, i3, i4));
    }
}
