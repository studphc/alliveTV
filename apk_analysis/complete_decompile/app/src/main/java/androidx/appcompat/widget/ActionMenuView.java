package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.C1256h4;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {

    /* renamed from: A */
    public OnMenuItemClickListener f1072A;

    /* renamed from: p */
    public MenuBuilder f1073p;

    /* renamed from: q */
    public Context f1074q;

    /* renamed from: r */
    public int f1075r;

    /* renamed from: s */
    public boolean f1076s;

    /* renamed from: t */
    public C0095d f1077t;

    /* renamed from: u */
    public MenuPresenter.Callback f1078u;

    /* renamed from: v */
    public MenuBuilder.Callback f1079v;

    /* renamed from: w */
    public boolean f1080w;

    /* renamed from: x */
    public int f1081x;

    /* renamed from: y */
    public final int f1082y;

    /* renamed from: z */
    public final int f1083z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a */
        public boolean f1084a;

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        C0095d c0095d = this.f1077t;
        if (c0095d != null) {
            c0095d.m312h();
            C1256h4 c1256h4 = c0095d.f1608p;
            if (c1256h4 != null) {
                c1256h4.dismiss();
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Menu getMenu() {
        if (this.f1073p == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1073p = menuBuilder;
            menuBuilder.setCallback(new C0096e(this));
            C0095d c0095d = new C0095d(context);
            this.f1077t = c0095d;
            c0095d.f1600h = true;
            c0095d.f1601i = true;
            MenuPresenter.Callback callback = this.f1078u;
            MenuPresenter.Callback callback2 = callback;
            if (callback == null) {
                callback2 = new Object();
            }
            c0095d.setCallback(callback2);
            this.f1073p.addMenuPresenter(this.f1077t, this.f1074q);
            this.f1077t.m315k(this);
        }
        return this.f1073p;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        C0095d c0095d = this.f1077t;
        C0093b c0093b = c0095d.f1597e;
        if (c0093b != null) {
            return c0093b.getDrawable();
        }
        if (c0095d.f1599g) {
            return c0095d.f1598f;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f1075r;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean hasSupportDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (i > 0 && (childAt2 instanceof ActionMenuChildView)) {
            return z | ((ActionMenuChildView) childAt2).needsDividerBefore();
        }
        return z;
    }

    public boolean hideOverflowMenu() {
        C0095d c0095d = this.f1077t;
        if (c0095d != null && c0095d.m312h()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder menuBuilder) {
        this.f1073p = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.f1073p.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        C0095d c0095d = this.f1077t;
        if (c0095d != null && (c0095d.f1609q != null || c0095d.m313i())) {
            return true;
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        C0095d c0095d = this.f1077t;
        if (c0095d != null && c0095d.m313i()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.f1076s;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0095d c0095d = this.f1077t;
        if (c0095d != null) {
            c0095d.updateMenuView(false);
            if (this.f1077t.m313i()) {
                this.f1077t.m312h();
                this.f1077t.m316l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        if (!this.f1080w) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i6 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = i6 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        i6 = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i6, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    hasSupportDividerBeforeChildAt(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i5 = paddingRight / i15;
        } else {
            i5 = 0;
        }
        int max = Math.max(0, i5);
        if (isLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i20 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + max + i20;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        int i6;
        int i7;
        int i8;
        ?? r4;
        boolean z6;
        int i9;
        int i10;
        int i11;
        ActionMenuItemView actionMenuItemView;
        boolean z7;
        int i12;
        boolean z8;
        MenuBuilder menuBuilder;
        boolean z9 = this.f1080w;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.f1080w = z;
        if (z9 != z) {
            this.f1081x = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f1080w && (menuBuilder = this.f1073p) != null && size != this.f1081x) {
            this.f1081x = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.f1080w && childCount > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i2);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
            int i13 = size2 - paddingRight;
            int i14 = this.f1082y;
            int i15 = i13 / i14;
            int i16 = i13 % i14;
            if (i15 == 0) {
                setMeasuredDimension(i13, 0);
                return;
            }
            int i17 = (i16 / i15) + i14;
            int childCount2 = getChildCount();
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            boolean z10 = false;
            int i22 = 0;
            long j = 0;
            while (true) {
                i3 = this.f1083z;
                if (i21 >= childCount2) {
                    break;
                }
                View childAt = getChildAt(i21);
                int i23 = size3;
                int i24 = i13;
                if (childAt.getVisibility() == 8) {
                    i10 = mode;
                    i11 = paddingBottom;
                } else {
                    boolean z11 = childAt instanceof ActionMenuItemView;
                    int i25 = i19 + 1;
                    if (z11) {
                        childAt.setPadding(i3, 0, i3, 0);
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f1084a = false;
                    layoutParams.extraPixels = 0;
                    layoutParams.cellsUsed = 0;
                    layoutParams.expandable = false;
                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
                    if (z11 && ((ActionMenuItemView) childAt).hasText()) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    layoutParams.preventEdgeOffset = z6;
                    if (layoutParams.isOverflowButton) {
                        i9 = 1;
                    } else {
                        i9 = i15;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    i10 = mode;
                    i11 = paddingBottom;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    if (z11) {
                        actionMenuItemView = (ActionMenuItemView) childAt;
                    } else {
                        actionMenuItemView = null;
                    }
                    if (actionMenuItemView != null && actionMenuItemView.hasText()) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (i9 > 0 && (!z7 || i9 >= 2)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i9 * i17, Integer.MIN_VALUE), makeMeasureSpec);
                        int measuredWidth = childAt.getMeasuredWidth();
                        i12 = measuredWidth / i17;
                        if (measuredWidth % i17 != 0) {
                            i12++;
                        }
                        if (z7 && i12 < 2) {
                            i12 = 2;
                        }
                    } else {
                        i12 = 0;
                    }
                    if (!layoutParams2.isOverflowButton && z7) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    layoutParams2.expandable = z8;
                    layoutParams2.cellsUsed = i12;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i12 * i17, 1073741824), makeMeasureSpec);
                    i20 = Math.max(i20, i12);
                    if (layoutParams.expandable) {
                        i22++;
                    }
                    if (layoutParams.isOverflowButton) {
                        z10 = true;
                    }
                    i15 -= i12;
                    i18 = Math.max(i18, childAt.getMeasuredHeight());
                    if (i12 == 1) {
                        j |= 1 << i21;
                    }
                    i19 = i25;
                }
                i21++;
                size3 = i23;
                i13 = i24;
                paddingBottom = i11;
                mode = i10;
            }
            int i26 = mode;
            int i27 = i13;
            int i28 = size3;
            if (z10 && i19 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z12 = false;
            while (i22 > 0 && i15 > 0) {
                int i29 = Integer.MAX_VALUE;
                int i30 = 0;
                int i31 = 0;
                long j2 = 0;
                while (i31 < childCount2) {
                    LayoutParams layoutParams3 = (LayoutParams) getChildAt(i31).getLayoutParams();
                    boolean z13 = z12;
                    if (layoutParams3.expandable) {
                        int i32 = layoutParams3.cellsUsed;
                        if (i32 < i29) {
                            j2 = 1 << i31;
                            i29 = i32;
                            i30 = 1;
                        } else if (i32 == i29) {
                            j2 |= 1 << i31;
                            i30++;
                        }
                    }
                    i31++;
                    z12 = z13;
                }
                z3 = z12;
                j |= j2;
                if (i30 > i15) {
                    break;
                }
                int i33 = i29 + 1;
                int i34 = 0;
                while (i34 < childCount2) {
                    View childAt2 = getChildAt(i34);
                    LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                    int i35 = i18;
                    int i36 = childMeasureSpec;
                    int i37 = childCount2;
                    long j3 = 1 << i34;
                    if ((j2 & j3) == 0) {
                        if (layoutParams4.cellsUsed == i33) {
                            j |= j3;
                        }
                    } else {
                        if (z2 && layoutParams4.preventEdgeOffset) {
                            r4 = 1;
                            r4 = 1;
                            if (i15 == 1) {
                                childAt2.setPadding(i3 + i17, 0, i3, 0);
                            }
                        } else {
                            r4 = 1;
                        }
                        layoutParams4.cellsUsed += r4;
                        layoutParams4.f1084a = r4;
                        i15--;
                    }
                    i34++;
                    childMeasureSpec = i36;
                    i18 = i35;
                    childCount2 = i37;
                }
                z12 = true;
            }
            z3 = z12;
            int i38 = i18;
            int i39 = childMeasureSpec;
            int i40 = childCount2;
            if (!z10 && i19 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i15 <= 0 || j == 0 || (i15 >= i19 - 1 && !z4 && i20 <= 1)) {
                i4 = i40;
                z5 = z3;
            } else {
                float bitCount = Long.bitCount(j);
                if (!z4) {
                    if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                    int i41 = i40 - 1;
                    if ((j & (1 << i41)) != 0 && !((LayoutParams) getChildAt(i41).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > RecyclerView.f7068F0) {
                    i8 = (int) ((i15 * i17) / bitCount);
                } else {
                    i8 = 0;
                }
                boolean z14 = z3;
                i4 = i40;
                for (int i42 = 0; i42 < i4; i42++) {
                    if ((j & (1 << i42)) != 0) {
                        View childAt3 = getChildAt(i42);
                        LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            layoutParams5.extraPixels = i8;
                            layoutParams5.f1084a = true;
                            if (i42 == 0 && !layoutParams5.preventEdgeOffset) {
                                ((LinearLayout.LayoutParams) layoutParams5).leftMargin = (-i8) / 2;
                            }
                            z14 = true;
                        } else {
                            if (layoutParams5.isOverflowButton) {
                                layoutParams5.extraPixels = i8;
                                layoutParams5.f1084a = true;
                                ((LinearLayout.LayoutParams) layoutParams5).rightMargin = (-i8) / 2;
                                z14 = true;
                            } else {
                                if (i42 != 0) {
                                    ((LinearLayout.LayoutParams) layoutParams5).leftMargin = i8 / 2;
                                }
                                if (i42 != i4 - 1) {
                                    ((LinearLayout.LayoutParams) layoutParams5).rightMargin = i8 / 2;
                                }
                            }
                        }
                    }
                }
                z5 = z14;
            }
            if (z5) {
                int i43 = 0;
                while (i43 < i4) {
                    View childAt4 = getChildAt(i43);
                    LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                    if (!layoutParams6.f1084a) {
                        i7 = i39;
                    } else {
                        i7 = i39;
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams6.cellsUsed * i17) + layoutParams6.extraPixels, 1073741824), i7);
                    }
                    i43++;
                    i39 = i7;
                }
            }
            if (i26 != 1073741824) {
                i6 = i27;
                i5 = i38;
            } else {
                i5 = i28;
                i6 = i27;
            }
            setMeasuredDimension(i6, i5);
            return;
        }
        for (int i44 = 0; i44 < childCount; i44++) {
            LayoutParams layoutParams7 = (LayoutParams) getChildAt(i44).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams7).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams7).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.f1073p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1077t.f1605m = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1078u = callback;
        this.f1079v = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1072A = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        C0095d c0095d = this.f1077t;
        C0093b c0093b = c0095d.f1597e;
        if (c0093b != null) {
            c0093b.setImageDrawable(drawable);
        } else {
            c0095d.f1599g = true;
            c0095d.f1598f = drawable;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z) {
        this.f1076s = z;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f1075r != i) {
            this.f1075r = i;
            if (i == 0) {
                this.f1074q = getContext();
            } else {
                this.f1074q = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(C0095d c0095d) {
        this.f1077t = c0095d;
        c0095d.m315k(this);
    }

    public boolean showOverflowMenu() {
        C0095d c0095d = this.f1077t;
        if (c0095d != null && c0095d.m316l()) {
            return true;
        }
        return false;
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1082y = (int) (56.0f * f);
        this.f1083z = (int) (f * 4.0f);
        this.f1074q = context;
        this.f1075r = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
                ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }
}
