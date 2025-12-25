package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000.ai2;
import p000.s53;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: F */
    public static final AccelerateInterpolator f632F = new AccelerateInterpolator();

    /* renamed from: G */
    public static final DecelerateInterpolator f633G = new DecelerateInterpolator();

    /* renamed from: A */
    public boolean f634A;

    /* renamed from: B */
    public boolean f635B;

    /* renamed from: a */
    public Context f639a;

    /* renamed from: b */
    public Context f640b;

    /* renamed from: c */
    public final Activity f641c;

    /* renamed from: d */
    public ActionBarOverlayLayout f642d;

    /* renamed from: e */
    public ActionBarContainer f643e;

    /* renamed from: f */
    public DecorToolbar f644f;

    /* renamed from: g */
    public ActionBarContextView f645g;

    /* renamed from: h */
    public final View f646h;

    /* renamed from: i */
    public ScrollingTabContainerView f647i;

    /* renamed from: k */
    public TabImpl f649k;

    /* renamed from: m */
    public boolean f651m;

    /* renamed from: n */
    public ActionModeImpl f652n;

    /* renamed from: o */
    public ActionModeImpl f653o;

    /* renamed from: p */
    public ActionMode.Callback f654p;

    /* renamed from: q */
    public boolean f655q;

    /* renamed from: s */
    public boolean f657s;

    /* renamed from: v */
    public boolean f660v;

    /* renamed from: w */
    public boolean f661w;

    /* renamed from: x */
    public boolean f662x;

    /* renamed from: z */
    public ViewPropertyAnimatorCompatSet f664z;

    /* renamed from: j */
    public final ArrayList f648j = new ArrayList();

    /* renamed from: l */
    public int f650l = -1;

    /* renamed from: r */
    public final ArrayList f656r = new ArrayList();

    /* renamed from: t */
    public int f658t = 0;

    /* renamed from: u */
    public boolean f659u = true;

    /* renamed from: y */
    public boolean f663y = true;

    /* renamed from: C */
    public final s53 f636C = new s53(this, 0);

    /* renamed from: D */
    public final s53 f637D = new s53(this, 1);

    /* renamed from: E */
    public final ai2 f638E = new ai2(13, this);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: c */
        public final Context f665c;

        /* renamed from: d */
        public final MenuBuilder f666d;

        /* renamed from: e */
        public ActionMode.Callback f667e;

        /* renamed from: f */
        public WeakReference f668f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f665c = context;
            this.f667e = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f666d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            MenuBuilder menuBuilder = this.f666d;
            menuBuilder.stopDispatchingItemsChanged();
            try {
                return this.f667e.onCreateActionMode(this, menuBuilder);
            } finally {
                menuBuilder.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f652n != this) {
                return;
            }
            boolean z = windowDecorActionBar.f660v;
            boolean z2 = windowDecorActionBar.f661w;
            if (!z && !z2) {
                this.f667e.onDestroyActionMode(this);
            } else {
                windowDecorActionBar.f653o = this;
                windowDecorActionBar.f654p = this.f667e;
            }
            this.f667e = null;
            windowDecorActionBar.animateToMode(false);
            windowDecorActionBar.f645g.closeMode();
            windowDecorActionBar.f642d.setHideOnContentScrollEnabled(windowDecorActionBar.f635B);
            windowDecorActionBar.f652n = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference weakReference = this.f668f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu getMenu() {
            return this.f666d;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.f665c);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.f645g.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            return WindowDecorActionBar.this.f645g.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.f652n != this) {
                return;
            }
            MenuBuilder menuBuilder = this.f666d;
            menuBuilder.stopDispatchingItemsChanged();
            try {
                this.f667e.onPrepareActionMode(this, menuBuilder);
            } finally {
                menuBuilder.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.f645g.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.f667e;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            if (this.f667e == null) {
                return;
            }
            invalidate();
            WindowDecorActionBar.this.f645g.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.f667e == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.f645g.setCustomView(view);
            this.f668f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f645g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f645g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.f645g.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.f639a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.f639a.getResources().getString(i));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: a */
        public ActionBar.TabListener f670a;

        /* renamed from: b */
        public Object f671b;

        /* renamed from: c */
        public Drawable f672c;

        /* renamed from: d */
        public CharSequence f673d;

        /* renamed from: e */
        public CharSequence f674e;

        /* renamed from: f */
        public int f675f = -1;

        /* renamed from: g */
        public View f676g;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.f670a;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.f674e;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            return this.f676g;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.f672c;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            return this.f675f;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            return this.f671b;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            return this.f673d;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.f639a.getResources().getText(i));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            this.f676g = view;
            int i = this.f675f;
            if (i >= 0) {
                WindowDecorActionBar.this.f647i.updateTab(i);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            this.f672c = drawable;
            int i = this.f675f;
            if (i >= 0) {
                WindowDecorActionBar.this.f647i.updateTab(i);
            }
            return this;
        }

        public void setPosition(int i) {
            this.f675f = i;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.f670a = tabListener;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.f671b = obj;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            this.f673d = charSequence;
            int i = this.f675f;
            if (i >= 0) {
                WindowDecorActionBar.this.f647i.updateTab(i);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.f674e = charSequence;
            int i = this.f675f;
            if (i >= 0) {
                WindowDecorActionBar.this.f647i.updateTab(i);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.f639a, i));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.f639a.getResources().getText(i));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f641c = activity;
        View decorView = activity.getWindow().getDecorView();
        m171d(decorView);
        if (z) {
            return;
        }
        this.f646h = decorView.findViewById(R.id.content);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f656r.add(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.f648j.isEmpty());
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            if (!this.f662x) {
                this.f662x = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f642d;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                m173f(false);
            }
        } else if (this.f662x) {
            this.f662x = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f642d;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            m173f(false);
        }
        if (this.f643e.isLaidOut()) {
            if (z) {
                viewPropertyAnimatorCompat2 = this.f644f.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.f645g.setupAnimatorToVisibility(0, 200L);
            } else {
                viewPropertyAnimatorCompat = this.f644f.setupAnimatorToVisibility(0, 200L);
                viewPropertyAnimatorCompat2 = this.f645g.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
            return;
        }
        if (z) {
            this.f644f.setVisibility(4);
            this.f645g.setVisibility(0);
        } else {
            this.f644f.setVisibility(0);
            this.f645g.setVisibility(8);
        }
    }

    /* renamed from: b */
    public final void m169b(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i);
            ArrayList arrayList = this.f648j;
            arrayList.add(i, tabImpl);
            int size = arrayList.size();
            while (true) {
                i++;
                if (i < size) {
                    ((TabImpl) arrayList.get(i)).setPosition(i);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    /* renamed from: c */
    public final void m170c() {
        if (this.f647i != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f639a);
        if (this.f657s) {
            scrollingTabContainerView.setVisibility(0);
            this.f644f.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            if (getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f642d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.f643e.setTabContainer(scrollingTabContainerView);
        }
        this.f647i = scrollingTabContainerView;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.f644f;
        if (decorToolbar != null && decorToolbar.hasExpandedActionView()) {
            this.f644f.collapseActionView();
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public final void m171d(View view) {
        String str;
        DecorToolbar wrapper;
        boolean z;
        boolean z2;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.f642d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(androidx.appcompat.R.id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            wrapper = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.f644f = wrapper;
        this.f645g = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.f643e = actionBarContainer;
        DecorToolbar decorToolbar = this.f644f;
        if (decorToolbar != null && this.f645g != null && actionBarContainer != null) {
            this.f639a = decorToolbar.getContext();
            if ((this.f644f.getDisplayOptions() & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.f651m = true;
            }
            ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f639a);
            if (!actionBarPolicy.enableHomeButtonByDefault() && !z) {
                z2 = false;
            } else {
                z2 = true;
            }
            setHomeButtonEnabled(z2);
            m172e(actionBarPolicy.hasEmbeddedTabs());
            TypedArray obtainStyledAttributes = this.f639a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
                setHideOnContentScrollEnabled(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                setElevation(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with a compatible window decor layout"));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.f655q) {
            return;
        }
        this.f655q = z;
        ArrayList arrayList = this.f656r;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ActionBar.OnMenuVisibilityListener) arrayList.get(i)).onMenuVisibilityChanged(z);
        }
    }

    public void doHide(boolean z) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f664z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        int i = this.f658t;
        s53 s53Var = this.f636C;
        if (i == 0 && (this.f634A || z)) {
            this.f643e.setAlpha(1.0f);
            this.f643e.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            float f = -this.f643e.getHeight();
            if (z) {
                this.f643e.getLocationInWindow(new int[]{0, 0});
                f -= r6[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f643e).translationY(f);
            translationY.setUpdateListener(this.f638E);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.f659u && (view = this.f646h) != null) {
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(f632F);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(s53Var);
            this.f664z = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
            return;
        }
        s53Var.onAnimationEnd(null);
    }

    public void doShow(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f664z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.f643e.setVisibility(0);
        int i = this.f658t;
        View view = this.f646h;
        s53 s53Var = this.f637D;
        if (i == 0 && (this.f634A || z)) {
            this.f643e.setTranslationY(RecyclerView.f7068F0);
            float f = -this.f643e.getHeight();
            if (z) {
                this.f643e.getLocationInWindow(new int[]{0, 0});
                f -= r7[1];
            }
            this.f643e.setTranslationY(f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f643e).translationY(RecyclerView.f7068F0);
            translationY.setUpdateListener(this.f638E);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.f659u && view != null) {
                view.setTranslationY(f);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(RecyclerView.f7068F0));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(f633G);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(s53Var);
            this.f664z = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        } else {
            this.f643e.setAlpha(1.0f);
            this.f643e.setTranslationY(RecyclerView.f7068F0);
            if (this.f659u && view != null) {
                view.setTranslationY(RecyclerView.f7068F0);
            }
            s53Var.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f642d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    /* renamed from: e */
    public final void m172e(boolean z) {
        boolean z2;
        boolean z3;
        this.f657s = z;
        if (!z) {
            this.f644f.setEmbeddedTabView(null);
            this.f643e.setTabContainer(this.f647i);
        } else {
            this.f643e.setTabContainer(null);
            this.f644f.setEmbeddedTabView(this.f647i);
        }
        boolean z4 = true;
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.f647i;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f642d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f644f;
        if (!this.f657s && z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        decorToolbar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f642d;
        if (this.f657s || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z4);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        this.f659u = z;
    }

    /* renamed from: f */
    public final void m173f(boolean z) {
        boolean z2 = this.f660v;
        boolean z3 = this.f661w;
        if (this.f662x || (!z2 && !z3)) {
            if (!this.f663y) {
                this.f663y = true;
                doShow(z);
                return;
            }
            return;
        }
        if (this.f663y) {
            this.f663y = false;
            doHide(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.f644f.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.f644f.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.f643e);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.f643e.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        return this.f642d.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        int navigationMode = this.f644f.getNavigationMode();
        if (navigationMode != 1) {
            if (navigationMode != 2) {
                return 0;
            }
            return this.f648j.size();
        }
        return this.f644f.getDropdownItemCount();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return this.f644f.getNavigationMode();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.f644f.getNavigationMode();
        if (navigationMode != 1) {
            if (navigationMode != 2 || (tabImpl = this.f649k) == null) {
                return -1;
            }
            return tabImpl.getPosition();
        }
        return this.f644f.getDropdownSelectedPosition();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.f649k;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.f644f.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        return (ActionBar.Tab) this.f648j.get(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.f648j.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.f640b == null) {
            TypedValue typedValue = new TypedValue();
            this.f639a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f640b = new ContextThemeWrapper(this.f639a, i);
            } else {
                this.f640b = this.f639a;
            }
        }
        return this.f640b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.f644f.getTitle();
    }

    public boolean hasIcon() {
        return this.f644f.hasIcon();
    }

    public boolean hasLogo() {
        return this.f644f.hasLogo();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        if (!this.f660v) {
            this.f660v = true;
            m173f(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.f661w) {
            this.f661w = true;
            m173f(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.f642d.isHideOnContentScrollEnabled();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        if (this.f663y && (height == 0 || getHideOffset() < height)) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.f644f;
        if (decorToolbar != null && decorToolbar.isTitleTruncated()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        m172e(ActionBarPolicy.get(this.f639a).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f664z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.f664z = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu;
        int i2;
        ActionModeImpl actionModeImpl = this.f652n;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i2 = keyEvent.getDeviceId();
        } else {
            i2 = -1;
        }
        boolean z = true;
        if (KeyCharacterMap.load(i2).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i) {
        this.f658t = i;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        if (this.f649k != null) {
            selectTab(null);
        }
        this.f648j.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.f647i;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.f650l = -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f656r.remove(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int i) {
        int i2;
        ActionBar.Tab tab;
        if (this.f647i == null) {
            return;
        }
        TabImpl tabImpl = this.f649k;
        if (tabImpl != null) {
            i2 = tabImpl.getPosition();
        } else {
            i2 = this.f650l;
        }
        this.f647i.removeTabAt(i);
        ArrayList arrayList = this.f648j;
        TabImpl tabImpl2 = (TabImpl) arrayList.remove(i);
        if (tabImpl2 != null) {
            tabImpl2.setPosition(-1);
        }
        int size = arrayList.size();
        for (int i3 = i; i3 < size; i3++) {
            ((TabImpl) arrayList.get(i3)).setPosition(i3);
        }
        if (i2 == i) {
            if (arrayList.isEmpty()) {
                tab = null;
            } else {
                tab = (ActionBar.Tab) arrayList.get(Math.max(0, i - 1));
            }
            selectTab(tab);
        }
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.f644f.getViewGroup();
        if (viewGroup != null && !viewGroup.hasFocus()) {
            viewGroup.requestFocus();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        int i = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.f650l = i;
            return;
        }
        Activity activity = this.f641c;
        if ((activity instanceof FragmentActivity) && !this.f644f.getViewGroup().isInEditMode()) {
            fragmentTransaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        } else {
            fragmentTransaction = null;
        }
        TabImpl tabImpl = this.f649k;
        if (tabImpl == tab) {
            if (tabImpl != null) {
                tabImpl.getCallback().onTabReselected(this.f649k, fragmentTransaction);
                this.f647i.animateToTab(tab.getPosition());
            }
        } else {
            ScrollingTabContainerView scrollingTabContainerView = this.f647i;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            TabImpl tabImpl2 = this.f649k;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.f649k, fragmentTransaction);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.f649k = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.f649k, fragmentTransaction);
            }
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.f643e.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f644f.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.f651m) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f651m = true;
        }
        this.f644f.setDisplayOptions(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        int i;
        if (z) {
            i = 16;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        int i;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        setDisplayOptions(i, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float f) {
        ViewCompat.setElevation(this.f643e, f);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int i) {
        if (i != 0 && !this.f642d.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.f642d.setActionBarHideOffset(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.f642d.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f635B = z;
        this.f642d.setHideOnContentScrollEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f644f.setNavigationContentDescription(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f644f.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        this.f644f.setHomeButtonEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i) {
        this.f644f.setIcon(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f644f.setDropdownParams(spinnerAdapter, new C0085f(onNavigationListener));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int i) {
        this.f644f.setLogo(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i) {
        boolean z;
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.f644f.getNavigationMode();
        if (navigationMode == 2) {
            this.f650l = getSelectedNavigationIndex();
            selectTab(null);
            this.f647i.setVisibility(8);
        }
        if (navigationMode != i && !this.f657s && (actionBarOverlayLayout = this.f642d) != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.f644f.setNavigationMode(i);
        boolean z2 = false;
        if (i == 2) {
            m170c();
            this.f647i.setVisibility(0);
            int i2 = this.f650l;
            if (i2 != -1) {
                setSelectedNavigationItem(i2);
                this.f650l = -1;
            }
        }
        DecorToolbar decorToolbar = this.f644f;
        if (i == 2 && !this.f657s) {
            z = true;
        } else {
            z = false;
        }
        decorToolbar.setCollapsible(z);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f642d;
        if (i == 2 && !this.f657s) {
            z2 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        int navigationMode = this.f644f.getNavigationMode();
        if (navigationMode != 1) {
            if (navigationMode == 2) {
                selectTab((ActionBar.Tab) this.f648j.get(i));
                return;
            }
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
        this.f644f.setDropdownSelectedPosition(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f634A = z;
        if (!z && (viewPropertyAnimatorCompatSet = this.f664z) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f643e.setStackedBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int i) {
        setSubtitle(this.f639a.getString(i));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i) {
        setTitle(this.f639a.getString(i));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.f644f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        if (this.f660v) {
            this.f660v = false;
            m173f(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.f661w) {
            this.f661w = false;
            m173f(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f652n;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.f642d.setHideOnContentScrollEnabled(false);
        this.f645g.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f645g.getContext(), callback);
        if (actionModeImpl2.dispatchOnCreate()) {
            this.f652n = actionModeImpl2;
            actionModeImpl2.invalidate();
            this.f645g.initForMode(actionModeImpl2);
            animateToMode(true);
            return actionModeImpl2;
        }
        return null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.f648j.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.f644f.setNavigationContentDescription(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.f644f.setNavigationIcon(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.f644f.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.f644f.setLogo(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.f644f.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.f644f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        m170c();
        this.f647i.addTab(tab, z);
        m169b(tab, this.f648j.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.f644f.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f651m = true;
        }
        this.f644f.setDisplayOptions((i & i2) | ((~i2) & displayOptions));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view) {
        this.f644f.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f644f.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        m170c();
        this.f647i.addTab(tab, i, z);
        m169b(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        m171d(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        m171d(view);
    }
}
