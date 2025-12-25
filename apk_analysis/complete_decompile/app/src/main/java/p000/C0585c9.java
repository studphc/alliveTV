package p000;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState;
import androidx.appcompat.app.C0086g;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.List;

/* renamed from: c9 */
/* loaded from: classes.dex */
public final class C0585c9 extends WindowCallbackWrapper {

    /* renamed from: b */
    public ai2 f8288b;

    /* renamed from: c */
    public boolean f8289c;

    /* renamed from: d */
    public boolean f8290d;

    /* renamed from: e */
    public boolean f8291e;

    /* renamed from: f */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f8292f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0585c9(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e, Window.Callback callback) {
        super(callback);
        this.f8292f = layoutInflaterFactory2C0084e;
    }

    /* renamed from: a */
    public final void m2209a(Window.Callback callback) {
        try {
            this.f8289c = true;
            callback.onContentChanged();
        } finally {
            this.f8289c = false;
        }
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f8290d) {
            return getWrapped().dispatchKeyEvent(keyEvent);
        }
        if (!this.f8292f.m184m(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f8292f;
        layoutInflaterFactory2C0084e.m191u();
        ActionBar actionBar = layoutInflaterFactory2C0084e.f725o;
        if (actionBar != null && actionBar.onKeyShortcut(keyCode, keyEvent)) {
            return true;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = layoutInflaterFactory2C0084e.f699N;
        if (appCompatDelegateImpl$PanelFeatureState != null && layoutInflaterFactory2C0084e.m195y(appCompatDelegateImpl$PanelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState2 = layoutInflaterFactory2C0084e.f699N;
            if (appCompatDelegateImpl$PanelFeatureState2 == null) {
                return true;
            }
            appCompatDelegateImpl$PanelFeatureState2.f614l = true;
            return true;
        }
        if (layoutInflaterFactory2C0084e.f699N == null) {
            AppCompatDelegateImpl$PanelFeatureState m190t = layoutInflaterFactory2C0084e.m190t(0);
            layoutInflaterFactory2C0084e.m196z(m190t, keyEvent);
            boolean m195y = layoutInflaterFactory2C0084e.m195y(m190t, keyEvent.getKeyCode(), keyEvent);
            m190t.f613k = false;
            if (m195y) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f8289c) {
            getWrapped().onContentChanged();
        }
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0 && !(menu instanceof MenuBuilder)) {
            return false;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        View view;
        ai2 ai2Var = this.f8288b;
        if (ai2Var != null) {
            if (i == 0) {
                view = new View(((C0086g) ai2Var.f216b).f738a.getContext());
            } else {
                view = null;
            }
            if (view != null) {
                return view;
            }
        }
        return super.onCreatePanelView(i);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f8292f;
        if (i == 108) {
            layoutInflaterFactory2C0084e.m191u();
            ActionBar actionBar = layoutInflaterFactory2C0084e.f725o;
            if (actionBar != null) {
                actionBar.dispatchMenuVisibilityChanged(true);
            }
        } else {
            layoutInflaterFactory2C0084e.getClass();
        }
        return true;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.f8291e) {
            getWrapped().onPanelClosed(i, menu);
            return;
        }
        super.onPanelClosed(i, menu);
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f8292f;
        if (i == 108) {
            layoutInflaterFactory2C0084e.m191u();
            ActionBar actionBar = layoutInflaterFactory2C0084e.f725o;
            if (actionBar != null) {
                actionBar.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i == 0) {
            AppCompatDelegateImpl$PanelFeatureState m190t = layoutInflaterFactory2C0084e.m190t(i);
            if (m190t.f615m) {
                layoutInflaterFactory2C0084e.m183k(m190t, false);
                return;
            }
            return;
        }
        layoutInflaterFactory2C0084e.getClass();
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        MenuBuilder menuBuilder;
        if (menu instanceof MenuBuilder) {
            menuBuilder = (MenuBuilder) menu;
        } else {
            menuBuilder = null;
        }
        if (i == 0 && menuBuilder == null) {
            return false;
        }
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(true);
        }
        ai2 ai2Var = this.f8288b;
        if (ai2Var != null && i == 0) {
            C0086g c0086g = (C0086g) ai2Var.f216b;
            if (!c0086g.f741d) {
                c0086g.f738a.setMenuPrepared();
                c0086g.f741d = true;
            }
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(false);
        }
        return onPreparePanel;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        MenuBuilder menuBuilder = this.f8292f.m190t(0).f610h;
        if (menuBuilder != null) {
            super.onProvideKeyboardShortcuts(list, menuBuilder, i);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f8292f;
        if (layoutInflaterFactory2C0084e.f736z && i == 0) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(layoutInflaterFactory2C0084e.f721k, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = layoutInflaterFactory2C0084e.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }
        return super.onWindowStartingActionMode(callback, i);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
