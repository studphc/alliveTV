package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import p000.C1182f4;
import p000.RunnableC1145e4;
import p000.c12;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {

    /* renamed from: C */
    public static final int[] f1040C = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: D */
    public static final WindowInsetsCompat f1041D = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.m828of(0, 1, 0, 1)).build();

    /* renamed from: E */
    public static final Rect f1042E = new Rect();

    /* renamed from: A */
    public final NestedScrollingParentHelper f1043A;

    /* renamed from: B */
    public final C1182f4 f1044B;

    /* renamed from: a */
    public int f1045a;

    /* renamed from: b */
    public int f1046b;

    /* renamed from: c */
    public ContentFrameLayout f1047c;

    /* renamed from: d */
    public ActionBarContainer f1048d;

    /* renamed from: e */
    public DecorToolbar f1049e;

    /* renamed from: f */
    public Drawable f1050f;

    /* renamed from: g */
    public boolean f1051g;

    /* renamed from: h */
    public boolean f1052h;

    /* renamed from: i */
    public boolean f1053i;

    /* renamed from: j */
    public boolean f1054j;

    /* renamed from: k */
    public int f1055k;

    /* renamed from: l */
    public int f1056l;

    /* renamed from: m */
    public final Rect f1057m;

    /* renamed from: n */
    public final Rect f1058n;

    /* renamed from: o */
    public final Rect f1059o;

    /* renamed from: p */
    public final Rect f1060p;

    /* renamed from: q */
    public WindowInsetsCompat f1061q;

    /* renamed from: r */
    public WindowInsetsCompat f1062r;

    /* renamed from: s */
    public WindowInsetsCompat f1063s;

    /* renamed from: t */
    public WindowInsetsCompat f1064t;

    /* renamed from: u */
    public ActionBarVisibilityCallback f1065u;

    /* renamed from: v */
    public OverScroller f1066v;

    /* renamed from: w */
    public ViewPropertyAnimator f1067w;

    /* renamed from: x */
    public final c12 f1068x;

    /* renamed from: y */
    public final RunnableC1145e4 f1069y;

    /* renamed from: z */
    public final RunnableC1145e4 f1070z;

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static boolean m234a(View view, Rect rect, boolean z) {
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    /* renamed from: b */
    public final void m235b() {
        removeCallbacks(this.f1069y);
        removeCallbacks(this.f1070z);
        ViewPropertyAnimator viewPropertyAnimator = this.f1067w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: c */
    public final void m236c(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1040C);
        boolean z = false;
        this.f1045a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1050f = drawable;
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
        this.f1066v = new OverScroller(context);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        m237d();
        return this.f1049e.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: d */
    public final void m237d() {
        DecorToolbar wrapper;
        if (this.f1047c == null) {
            this.f1047c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1048d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof DecorToolbar) {
                wrapper = (DecorToolbar) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f1049e = wrapper;
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        m237d();
        this.f1049e.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f1050f != null) {
            if (this.f1048d.getVisibility() == 0) {
                i = (int) (this.f1048d.getTranslationY() + this.f1048d.getBottom() + 0.5f);
            } else {
                i = 0;
            }
            this.f1050f.setBounds(0, i, getWidth(), this.f1050f.getIntrinsicHeight() + i);
            this.f1050f.draw(canvas);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1048d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f1043A.getNestedScrollAxes();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public CharSequence getTitle() {
        m237d();
        return this.f1049e.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasIcon() {
        m237d();
        return this.f1049e.hasIcon();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasLogo() {
        m237d();
        return this.f1049e.hasLogo();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        m237d();
        return this.f1049e.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int i) {
        m237d();
        if (i != 2) {
            if (i != 5) {
                if (i == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            this.f1049e.initIndeterminateProgress();
            return;
        }
        this.f1049e.initProgress();
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1053i;
    }

    public boolean isInOverlayMode() {
        return this.f1051g;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        m237d();
        return this.f1049e.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        m237d();
        return this.f1049e.isOverflowMenuShowing();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        m237d();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        boolean m234a = m234a(this.f1048d, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), false);
        Rect rect = this.f1057m;
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, rect);
        WindowInsetsCompat inset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.f1061q = inset;
        boolean z = true;
        if (!this.f1062r.equals(inset)) {
            this.f1062r = this.f1061q;
            m234a = true;
        }
        Rect rect2 = this.f1058n;
        if (!rect2.equals(rect)) {
            rect2.set(rect);
        } else {
            z = m234a;
        }
        if (z) {
            requestLayout();
        }
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m236c(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m235b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00e3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        int measuredHeight;
        m237d();
        measureChildWithMargins(this.f1048d, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1048d.getLayoutParams();
        int max = Math.max(0, this.f1048d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.f1048d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1048d.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            measuredHeight = this.f1045a;
            if (this.f1052h && this.f1048d.getTabContainer() != null) {
                measuredHeight += this.f1045a;
            }
        } else {
            measuredHeight = this.f1048d.getVisibility() != 8 ? this.f1048d.getMeasuredHeight() : 0;
        }
        Rect rect = this.f1057m;
        Rect rect2 = this.f1059o;
        rect2.set(rect);
        this.f1063s = this.f1061q;
        if (!this.f1051g && !z) {
            C1182f4 c1182f4 = this.f1044B;
            WindowInsetsCompat windowInsetsCompat = f1041D;
            Rect rect3 = this.f1060p;
            ViewCompat.computeSystemWindowInsets(c1182f4, windowInsetsCompat, rect3);
            if (!rect3.equals(f1042E)) {
                rect2.top += measuredHeight;
                rect2.bottom = rect2.bottom;
                this.f1063s = this.f1063s.inset(0, measuredHeight, 0, 0);
                m234a(this.f1047c, rect2, true);
                if (!this.f1064t.equals(this.f1063s)) {
                    WindowInsetsCompat windowInsetsCompat2 = this.f1063s;
                    this.f1064t = windowInsetsCompat2;
                    ViewCompat.dispatchApplyWindowInsets(this.f1047c, windowInsetsCompat2);
                }
                measureChildWithMargins(this.f1047c, i, 0, i2, 0);
                LayoutParams layoutParams2 = (LayoutParams) this.f1047c.getLayoutParams();
                int max3 = Math.max(max, this.f1047c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                int max4 = Math.max(max2, this.f1047c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1047c.getMeasuredState());
                setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
            }
        }
        this.f1063s = new WindowInsetsCompat.Builder(this.f1063s).setSystemWindowInsets(Insets.m828of(this.f1063s.getSystemWindowInsetLeft(), this.f1063s.getSystemWindowInsetTop() + measuredHeight, this.f1063s.getSystemWindowInsetRight(), this.f1063s.getSystemWindowInsetBottom())).build();
        m234a(this.f1047c, rect2, true);
        if (!this.f1064t.equals(this.f1063s)) {
        }
        measureChildWithMargins(this.f1047c, i, 0, i2, 0);
        LayoutParams layoutParams22 = (LayoutParams) this.f1047c.getLayoutParams();
        int max32 = Math.max(max, this.f1047c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams22).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams22).rightMargin);
        int max42 = Math.max(max2, this.f1047c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams22).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams22).bottomMargin);
        int combineMeasuredStates22 = View.combineMeasuredStates(combineMeasuredStates, this.f1047c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max32, getSuggestedMinimumWidth()), i, combineMeasuredStates22), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max42, getSuggestedMinimumHeight()), i2, combineMeasuredStates22 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.f1053i && z) {
            this.f1066v.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (this.f1066v.getFinalY() > this.f1048d.getHeight()) {
                m235b();
                this.f1070z.run();
            } else {
                m235b();
                this.f1069y.run();
            }
            this.f1054j = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        super.onWindowSystemUiVisibilityChanged(i);
        m237d();
        int i2 = this.f1056l ^ i;
        this.f1056l = i;
        boolean z2 = false;
        if ((i & 4) == 0) {
            z = true;
        } else {
            z = false;
        }
        if ((i & 256) != 0) {
            z2 = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1065u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.enableContentAnimations(!z2);
            if (!z && z2) {
                this.f1065u.hideForSystem();
            } else {
                this.f1065u.showForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.f1065u != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1046b = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1065u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        m237d();
        this.f1049e.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        m237d();
        this.f1049e.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int i) {
        m235b();
        this.f1048d.setTranslationY(-Math.max(0, Math.min(i, this.f1048d.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f1065u = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f1065u.onWindowVisibilityChanged(this.f1046b);
            int i = this.f1056l;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1052h = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1053i) {
            this.f1053i = z;
            if (!z) {
                m235b();
                setActionBarHideOffset(0);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int i) {
        m237d();
        this.f1049e.setIcon(i);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int i) {
        m237d();
        this.f1049e.setLogo(i);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        m237d();
        this.f1049e.setMenu(menu, callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        m237d();
        this.f1049e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.f1051g = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int i) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        m237d();
        this.f1049e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        m237d();
        this.f1049e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        m237d();
        return this.f1049e.showOverflowMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.view.View, f4] */
    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1046b = 0;
        this.f1057m = new Rect();
        this.f1058n = new Rect();
        this.f1059o = new Rect();
        this.f1060p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.f1061q = windowInsetsCompat;
        this.f1062r = windowInsetsCompat;
        this.f1063s = windowInsetsCompat;
        this.f1064t = windowInsetsCompat;
        this.f1068x = new c12(3, this);
        this.f1069y = new RunnableC1145e4(this, 0);
        this.f1070z = new RunnableC1145e4(this, 1);
        m236c(context);
        this.f1043A = new NestedScrollingParentHelper(this);
        ?? view = new View(context);
        view.setWillNotDraw(true);
        this.f1044B = view;
        addView(view);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1043A.onNestedScrollAccepted(view, view2, i);
        this.f1055k = getActionBarHideOffset();
        m235b();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1065u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1048d.getVisibility() != 0) {
            return false;
        }
        return this.f1053i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f1053i && !this.f1054j) {
            if (this.f1055k <= this.f1048d.getHeight()) {
                m235b();
                postDelayed(this.f1069y, 600L);
            } else {
                m235b();
                postDelayed(this.f1070z, 600L);
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1065u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f1055k + i2;
        this.f1055k = i5;
        setActionBarHideOffset(i5);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable drawable) {
        m237d();
        this.f1049e.setIcon(drawable);
    }
}
