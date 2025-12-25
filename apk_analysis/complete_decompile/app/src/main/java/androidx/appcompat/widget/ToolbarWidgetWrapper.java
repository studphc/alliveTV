package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.ou2;
import p000.pu2;
import p000.ye0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a */
    public final Toolbar f1566a;

    /* renamed from: b */
    public int f1567b;

    /* renamed from: c */
    public ScrollingTabContainerView f1568c;

    /* renamed from: d */
    public AppCompatSpinner f1569d;

    /* renamed from: e */
    public View f1570e;

    /* renamed from: f */
    public Drawable f1571f;

    /* renamed from: g */
    public Drawable f1572g;

    /* renamed from: h */
    public Drawable f1573h;

    /* renamed from: i */
    public boolean f1574i;

    /* renamed from: j */
    public CharSequence f1575j;

    /* renamed from: k */
    public CharSequence f1576k;

    /* renamed from: l */
    public CharSequence f1577l;

    /* renamed from: m */
    public Window.Callback f1578m;

    /* renamed from: n */
    public boolean f1579n;

    /* renamed from: o */
    public C0095d f1580o;

    /* renamed from: p */
    public int f1581p;

    /* renamed from: q */
    public int f1582q;

    /* renamed from: r */
    public Drawable f1583r;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    /* renamed from: a */
    public final void m299a() {
        if (this.f1569d == null) {
            this.f1569d = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
            this.f1569d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200L);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    /* renamed from: b */
    public final void m300b() {
        if ((this.f1567b & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f1577l);
            Toolbar toolbar = this.f1566a;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f1582q);
            } else {
                toolbar.setNavigationContentDescription(this.f1577l);
            }
        }
    }

    /* renamed from: c */
    public final void m301c() {
        int i = this.f1567b & 4;
        Toolbar toolbar = this.f1566a;
        if (i != 0) {
            Drawable drawable = this.f1573h;
            if (drawable == null) {
                drawable = this.f1583r;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        toolbar.setNavigationIcon((Drawable) null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.f1566a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f1566a.collapseActionView();
    }

    /* renamed from: d */
    public final void m302d() {
        Drawable drawable;
        int i = this.f1567b;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                drawable = this.f1572g;
                if (drawable == null) {
                    drawable = this.f1571f;
                }
            } else {
                drawable = this.f1571f;
            }
        } else {
            drawable = null;
        }
        this.f1566a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.f1566a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f1566a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.f1570e;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.f1567b;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        AppCompatSpinner appCompatSpinner = this.f1569d;
        if (appCompatSpinner != null) {
            return appCompatSpinner.getCount();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        AppCompatSpinner appCompatSpinner = this.f1569d;
        if (appCompatSpinner != null) {
            return appCompatSpinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.f1566a.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.f1566a.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.f1581p;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.f1566a.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f1566a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.f1566a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.f1566a.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        if (this.f1568c != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.f1566a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        if (this.f1571f != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        if (this.f1572g != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.f1566a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.f1566a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.f1566a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.f1566a.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1566a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1566a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable drawable) {
        this.f1566a.setBackground(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        this.f1566a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View view) {
        View view2 = this.f1570e;
        Toolbar toolbar = this.f1566a;
        if (view2 != null && (this.f1567b & 16) != 0) {
            toolbar.removeView(view2);
        }
        this.f1570e = view;
        if (view != null && (this.f1567b & 16) != 0) {
            toolbar.addView(view);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i) {
        if (i == this.f1582q) {
            return;
        }
        this.f1582q = i;
        if (TextUtils.isEmpty(this.f1566a.getNavigationContentDescription())) {
            setNavigationContentDescription(this.f1582q);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.f1583r != drawable) {
            this.f1583r = drawable;
            m301c();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.f1567b ^ i;
        this.f1567b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m300b();
                }
                m301c();
            }
            if ((i2 & 3) != 0) {
                m302d();
            }
            int i3 = i2 & 8;
            Toolbar toolbar = this.f1566a;
            if (i3 != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.f1575j);
                    toolbar.setSubtitle(this.f1576k);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.f1570e) != null) {
                if ((i & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        m299a();
        this.f1569d.setAdapter(spinnerAdapter);
        this.f1569d.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i) {
        AppCompatSpinner appCompatSpinner = this.f1569d;
        if (appCompatSpinner != null) {
            appCompatSpinner.setSelection(i);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f1568c;
        Toolbar toolbar = this.f1566a;
        if (scrollingTabContainerView2 != null && scrollingTabContainerView2.getParent() == toolbar) {
            toolbar.removeView(this.f1568c);
        }
        this.f1568c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f1581p == 2) {
            toolbar.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1568c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        C0095d c0095d = this.f1580o;
        Toolbar toolbar = this.f1566a;
        if (c0095d == null) {
            C0095d c0095d2 = new C0095d(toolbar.getContext());
            this.f1580o = c0095d2;
            c0095d2.setId(R.id.action_menu_presenter);
        }
        this.f1580o.setCallback(callback);
        toolbar.setMenu((MenuBuilder) menu, this.f1580o);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1566a.setMenuCallbacks(callback, callback2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.f1579n = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        this.f1577l = charSequence;
        m300b();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        this.f1573h = drawable;
        m301c();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int i) {
        ScrollingTabContainerView scrollingTabContainerView;
        int i2 = this.f1581p;
        if (i != i2) {
            Toolbar toolbar = this.f1566a;
            if (i2 != 1) {
                if (i2 == 2 && (scrollingTabContainerView = this.f1568c) != null && scrollingTabContainerView.getParent() == toolbar) {
                    toolbar.removeView(this.f1568c);
                }
            } else {
                AppCompatSpinner appCompatSpinner = this.f1569d;
                if (appCompatSpinner != null && appCompatSpinner.getParent() == toolbar) {
                    toolbar.removeView(this.f1569d);
                }
            }
            this.f1581p = i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        ScrollingTabContainerView scrollingTabContainerView2 = this.f1568c;
                        if (scrollingTabContainerView2 != null) {
                            toolbar.addView(scrollingTabContainerView2, 0);
                            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1568c.getLayoutParams();
                            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                            layoutParams.gravity = 8388691;
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException(ye0.m8291k(i, "Invalid navigation mode "));
                }
                m299a();
                toolbar.addView(this.f1569d, 0);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence charSequence) {
        this.f1576k = charSequence;
        if ((this.f1567b & 8) != 0) {
            this.f1566a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.f1574i = true;
        this.f1575j = charSequence;
        if ((this.f1567b & 8) != 0) {
            Toolbar toolbar = this.f1566a;
            toolbar.setTitle(charSequence);
            if (this.f1574i) {
                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i) {
        this.f1566a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.f1578m = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1574i) {
            this.f1575j = charSequence;
            if ((this.f1567b & 8) != 0) {
                Toolbar toolbar = this.f1566a;
                toolbar.setTitle(charSequence);
                if (this.f1574i) {
                    ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        float f;
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.f1566a);
        if (i == 0) {
            f = 1.0f;
        } else {
            f = RecyclerView.f7068F0;
        }
        return animate.alpha(f).setDuration(j).setListener(new pu2(this, i));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.f1566a.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        int i3;
        Drawable drawable;
        this.f1581p = 0;
        this.f1582q = 0;
        this.f1566a = toolbar;
        this.f1575j = toolbar.getTitle();
        this.f1576k = toolbar.getSubtitle();
        this.f1574i = this.f1575j != null;
        this.f1573h = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f1583r = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.f1573h == null && (drawable = this.f1583r) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false));
                setDisplayOptions(this.f1567b | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                toolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                toolbar.setTitleTextAppearance(toolbar.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                toolbar.setSubtitleTextAppearance(toolbar.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f1583r = toolbar.getNavigationIcon();
                i3 = 15;
            } else {
                i3 = 11;
            }
            this.f1567b = i3;
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.f1577l = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new ou2(this));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f1571f = drawable;
        m302d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable drawable) {
        this.f1572g = drawable;
        m302d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }
}
