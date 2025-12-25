package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.C1256h4;
import p000.RunnableC1104d;
import p000.ViewOnClickListenerC1109d4;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0092a {

    /* renamed from: c */
    public CharSequence f1028c;

    /* renamed from: d */
    public CharSequence f1029d;

    /* renamed from: e */
    public View f1030e;

    /* renamed from: f */
    public View f1031f;

    /* renamed from: g */
    public View f1032g;

    /* renamed from: h */
    public LinearLayout f1033h;

    /* renamed from: i */
    public TextView f1034i;

    /* renamed from: j */
    public TextView f1035j;

    /* renamed from: k */
    public final int f1036k;

    /* renamed from: l */
    public final int f1037l;

    /* renamed from: m */
    public boolean f1038m;

    /* renamed from: n */
    public final int f1039n;

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    public void animateToVisibility(int i) {
        setupAnimatorToVisibility(i, 200L).start();
    }

    /* renamed from: c */
    public final void m233c() {
        int i;
        if (this.f1033h == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1033h = linearLayout;
            this.f1034i = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f1035j = (TextView) this.f1033h.findViewById(R.id.action_bar_subtitle);
            int i2 = this.f1036k;
            if (i2 != 0) {
                this.f1034i.setTextAppearance(getContext(), i2);
            }
            int i3 = this.f1037l;
            if (i3 != 0) {
                this.f1035j.setTextAppearance(getContext(), i3);
            }
        }
        this.f1034i.setText(this.f1028c);
        this.f1035j.setText(this.f1029d);
        boolean isEmpty = TextUtils.isEmpty(this.f1028c);
        boolean isEmpty2 = TextUtils.isEmpty(this.f1029d);
        TextView textView = this.f1035j;
        int i4 = 8;
        if (!isEmpty2) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout2 = this.f1033h;
        if (!isEmpty || !isEmpty2) {
            i4 = 0;
        }
        linearLayout2.setVisibility(i4);
        if (this.f1033h.getParent() == null) {
            addView(this.f1033h);
        }
    }

    public boolean canShowOverflowMenu() {
        if (isOverflowReserved() && getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void closeMode() {
        if (this.f1030e == null) {
            killMode();
        }
    }

    public void dismissPopupMenus() {
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null) {
            c0095d.m312h();
            C1256h4 c1256h4 = c0095d.f1608p;
            if (c1256h4 != null) {
                c1256h4.dismiss();
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim != null) {
            return this.mVisAnimListener.f1016b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public CharSequence getSubtitle() {
        return this.f1029d;
    }

    public CharSequence getTitle() {
        return this.f1028c;
    }

    public boolean hideOverflowMenu() {
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null) {
            return c0095d.m312h();
        }
        return false;
    }

    public void initForMode(ActionMode actionMode) {
        View view = this.f1030e;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f1039n, (ViewGroup) this, false);
            this.f1030e = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f1030e);
        }
        View findViewById = this.f1030e.findViewById(R.id.action_mode_close_button);
        this.f1031f = findViewById;
        findViewById.setOnClickListener(new ViewOnClickListenerC1109d4(0, actionMode));
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null) {
            c0095d.m312h();
            C1256h4 c1256h4 = c0095d.f1608p;
            if (c1256h4 != null) {
                c1256h4.dismiss();
            }
        }
        C0095d c0095d2 = new C0095d(getContext());
        this.mActionMenuPresenter = c0095d2;
        c0095d2.f1600h = true;
        c0095d2.f1601i = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.mMenuView, layoutParams);
    }

    public boolean isOverflowMenuShowPending() {
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d == null) {
            return false;
        }
        if (c0095d.f1609q == null && !c0095d.m313i()) {
            return false;
        }
        return true;
    }

    public boolean isOverflowMenuShowing() {
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null) {
            return c0095d.m313i();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null && c0095d.f1600h) {
            return true;
        }
        return false;
    }

    public boolean isTitleOptional() {
        return this.f1038m;
    }

    public void killMode() {
        removeAllViews();
        this.f1032g = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View view = this.f1031f;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null) {
            c0095d.m312h();
            C1256h4 c1256h4 = this.mActionMenuPresenter.f1608p;
            if (c1256h4 != null) {
                c1256h4.dismiss();
            }
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0092a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingRight;
        int i5;
        int i6;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            paddingLeft = (i3 - i) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1030e;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1030e.getLayoutParams();
            if (isLayoutRtl) {
                i5 = marginLayoutParams.rightMargin;
            } else {
                i5 = marginLayoutParams.leftMargin;
            }
            if (isLayoutRtl) {
                i6 = marginLayoutParams.leftMargin;
            } else {
                i6 = marginLayoutParams.rightMargin;
            }
            int next = AbstractC0092a.next(paddingLeft, i5, isLayoutRtl);
            paddingLeft = AbstractC0092a.next(next + positionChild(this.f1030e, next, paddingTop, paddingTop2, isLayoutRtl), i6, isLayoutRtl);
        }
        int i7 = paddingLeft;
        LinearLayout linearLayout = this.f1033h;
        if (linearLayout != null && this.f1032g == null && linearLayout.getVisibility() != 8) {
            i7 += positionChild(this.f1033h, i7, paddingTop, paddingTop2, isLayoutRtl);
        }
        int i8 = i7;
        View view2 = this.f1032g;
        if (view2 != null) {
            positionChild(view2, i8, paddingTop, paddingTop2, isLayoutRtl);
        }
        if (isLayoutRtl) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i3 - i) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            positionChild(actionMenuView, paddingRight, paddingTop, paddingTop2, !isLayoutRtl);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5 = 1073741824;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i2) != 0) {
                int size = View.MeasureSpec.getSize(i);
                int i6 = this.mContentHeight;
                if (i6 <= 0) {
                    i6 = View.MeasureSpec.getSize(i2);
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i7 = i6 - paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
                View view = this.f1030e;
                if (view != null) {
                    int measureChildView = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1030e.getLayoutParams();
                    paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.mMenuView;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f1033h;
                if (linearLayout != null && this.f1032g == null) {
                    if (this.f1038m) {
                        this.f1033h.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f1033h.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f1033h;
                        if (z) {
                            i4 = 0;
                        } else {
                            i4 = 8;
                        }
                        linearLayout2.setVisibility(i4);
                    } else {
                        paddingLeft = measureChildView(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f1032g;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i8 = layoutParams.width;
                    if (i8 != -2) {
                        i3 = 1073741824;
                    } else {
                        i3 = Integer.MIN_VALUE;
                    }
                    if (i8 >= 0) {
                        paddingLeft = Math.min(i8, paddingLeft);
                    }
                    int i9 = layoutParams.height;
                    if (i9 == -2) {
                        i5 = Integer.MIN_VALUE;
                    }
                    if (i9 >= 0) {
                        i7 = Math.min(i9, i7);
                    }
                    this.f1032g.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(i7, i5));
                }
                if (this.mContentHeight <= 0) {
                    int childCount = getChildCount();
                    int i10 = 0;
                    for (int i11 = 0; i11 < childCount; i11++) {
                        int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingBottom;
                        if (measuredHeight > i10) {
                            i10 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i10);
                    return;
                }
                setMeasuredDimension(size, i6);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // androidx.appcompat.widget.AbstractC0092a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void postShowOverflowMenu() {
        post(new RunnableC1104d(0, this));
    }

    @Override // androidx.appcompat.widget.AbstractC0092a
    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1032g;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1032g = view;
        if (view != null && (linearLayout = this.f1033h) != null) {
            removeView(linearLayout);
            this.f1033h = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1029d = charSequence;
        m233c();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1028c = charSequence;
        m233c();
        ViewCompat.setAccessibilityPaneTitle(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1038m) {
            requestLayout();
        }
        this.f1038m = z;
    }

    @Override // androidx.appcompat.widget.AbstractC0092a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(RecyclerView.f7068F0);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(j);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
            return alpha;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(RecyclerView.f7068F0);
        alpha2.setDuration(j);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
        return alpha2;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        C0095d c0095d = this.mActionMenuPresenter;
        if (c0095d != null) {
            return c0095d.m316l();
        }
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, i, 0);
        setBackground(obtainStyledAttributes.getDrawable(R.styleable.ActionMode_background));
        this.f1036k = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.f1037l = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.f1039n = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
