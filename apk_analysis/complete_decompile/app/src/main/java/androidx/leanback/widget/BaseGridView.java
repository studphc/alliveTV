package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import p000.C1352jf;
import p000.C1389kf;
import p000.C1509lf;
import p000.C1617oc;
import p000.m53;
import p000.mt2;
import p000.tx0;
import p000.ux0;
import p000.wx0;

/* loaded from: classes.dex */
public abstract class BaseGridView extends RecyclerView {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_ALIGNED = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_ITEM = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_PAGE = 2;
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    public static final int SAVE_ALL_CHILD = 3;
    public static final int SAVE_LIMITED_CHILD = 2;
    public static final int SAVE_NO_CHILD = 0;
    public static final int SAVE_ON_SCREEN_CHILD = 1;
    public static final int WINDOW_ALIGN_BOTH_EDGE = 3;
    public static final int WINDOW_ALIGN_HIGH_EDGE = 2;
    public static final int WINDOW_ALIGN_LOW_EDGE = 1;
    public static final int WINDOW_ALIGN_NO_EDGE = 0;
    public static final float WINDOW_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;

    /* renamed from: M0 */
    public GridLayoutManager f5584M0;

    /* renamed from: N0 */
    public SmoothScrollByBehavior f5585N0;

    /* renamed from: O0 */
    public boolean f5586O0;

    /* renamed from: P0 */
    public boolean f5587P0;

    /* renamed from: Q0 */
    public RecyclerView.ItemAnimator f5588Q0;

    /* renamed from: R0 */
    public OnTouchInterceptListener f5589R0;

    /* renamed from: S0 */
    public OnMotionInterceptListener f5590S0;

    /* renamed from: T0 */
    public OnKeyInterceptListener f5591T0;

    /* renamed from: U0 */
    public OnUnhandledKeyListener f5592U0;

    /* renamed from: V0 */
    public int f5593V0;

    /* renamed from: W0 */
    public int f5594W0;

    /* loaded from: classes.dex */
    public interface OnKeyInterceptListener {
        boolean onInterceptKeyEvent(@NonNull KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public interface OnLayoutCompletedListener {
        void onLayoutCompleted(@NonNull RecyclerView.State state);
    }

    /* loaded from: classes.dex */
    public interface OnMotionInterceptListener {
        boolean onInterceptMotionEvent(@NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface OnTouchInterceptListener {
        boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyListener {
        boolean onUnhandledKey(@NonNull KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public interface SmoothScrollByBehavior {
        int configSmoothScrollByDuration(int i, int i2);

        @Nullable
        Interpolator configSmoothScrollByInterpolator(int i, int i2);
    }

    public BaseGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5586O0 = true;
        this.f5587P0 = true;
        this.f5593V0 = 4;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);
        this.f5584M0 = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((SimpleItemAnimator) getItemAnimator()).setSupportsChangeAnimations(false);
        super.addRecyclerListener(new C1352jf(this));
    }

    public void addOnChildViewHolderSelectedListener(@NonNull OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (gridLayoutManager.f5679F == null) {
            gridLayoutManager.f5679F = new ArrayList();
        }
        gridLayoutManager.f5679F.add(onChildViewHolderSelectedListener);
    }

    public final void addOnLayoutCompletedListener(@NonNull OnLayoutCompletedListener onLayoutCompletedListener) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (gridLayoutManager.f5680G == null) {
            gridLayoutManager.f5680G = new ArrayList();
        }
        gridLayoutManager.f5680G.add(onLayoutCompletedListener);
    }

    public void animateIn() {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i = gridLayoutManager.f5677D;
        if ((i & 64) != 0) {
            gridLayoutManager.f5677D = i & (-65);
            int i2 = gridLayoutManager.f5682I;
            if (i2 >= 0) {
                gridLayoutManager.m1412Q(i2, gridLayoutManager.f5683J, gridLayoutManager.f5687N, true);
            } else {
                gridLayoutManager.f5677D = i & (-193);
                gridLayoutManager.requestLayout();
            }
            int i3 = gridLayoutManager.f5677D;
            if ((i3 & 128) != 0) {
                gridLayoutManager.f5677D = i3 & (-129);
                if (gridLayoutManager.f5714s.getScrollState() == 0 && !gridLayoutManager.isSmoothScrolling()) {
                    gridLayoutManager.requestLayout();
                } else {
                    gridLayoutManager.f5714s.addOnScrollListener(new wx0(gridLayoutManager));
                }
            }
        }
    }

    public void animateOut() {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i = gridLayoutManager.f5677D;
        if ((i & 64) == 0) {
            gridLayoutManager.f5677D = i | 64;
            if (gridLayoutManager.getChildCount() != 0) {
                if (gridLayoutManager.f5715t == 1) {
                    gridLayoutManager.f5714s.smoothScrollBy(0, gridLayoutManager.m1434y(), new AccelerateDecelerateInterpolator());
                } else {
                    gridLayoutManager.f5714s.smoothScrollBy(gridLayoutManager.m1434y(), 0, new AccelerateDecelerateInterpolator());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchGenericFocusedEvent(@NonNull MotionEvent motionEvent) {
        OnMotionInterceptListener onMotionInterceptListener = this.f5590S0;
        if (onMotionInterceptListener != null && onMotionInterceptListener.onInterceptMotionEvent(motionEvent)) {
            return true;
        }
        return super.dispatchGenericFocusedEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        OnKeyInterceptListener onKeyInterceptListener = this.f5591T0;
        if ((onKeyInterceptListener != null && onKeyInterceptListener.onInterceptKeyEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        OnUnhandledKeyListener onUnhandledKeyListener = this.f5592U0;
        if (onUnhandledKeyListener != null && onUnhandledKeyListener.onUnhandledKey(keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        OnTouchInterceptListener onTouchInterceptListener = this.f5589R0;
        if (onTouchInterceptListener != null && onTouchInterceptListener.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: f0 */
    public final void m1384f0(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseGridView);
        this.f5584M0.setFocusOutAllowed(obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutFront, false), obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutEnd, false));
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideStart, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideEnd, true);
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i3 = gridLayoutManager.f5677D & (-24577);
        if (z) {
            i = 8192;
        } else {
            i = 0;
        }
        int i4 = i | i3;
        if (z2) {
            i2 = 16384;
        } else {
            i2 = 0;
        }
        gridLayoutManager.f5677D = i4 | i2;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_verticalSpacing, obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_verticalMargin, 0));
        if (gridLayoutManager.f5715t == 1) {
            gridLayoutManager.f5695V = dimensionPixelSize;
            gridLayoutManager.f5696W = dimensionPixelSize;
        } else {
            gridLayoutManager.f5695V = dimensionPixelSize;
            gridLayoutManager.f5697X = dimensionPixelSize;
        }
        GridLayoutManager gridLayoutManager2 = this.f5584M0;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_horizontalSpacing, obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_horizontalMargin, 0));
        if (gridLayoutManager2.f5715t == 0) {
            gridLayoutManager2.f5694U = dimensionPixelSize2;
            gridLayoutManager2.f5696W = dimensionPixelSize2;
        } else {
            gridLayoutManager2.f5694U = dimensionPixelSize2;
            gridLayoutManager2.f5697X = dimensionPixelSize2;
        }
        int i5 = R.styleable.lbBaseGridView_android_gravity;
        if (obtainStyledAttributes.hasValue(i5)) {
            setGravity(obtainStyledAttributes.getInt(i5, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    @Nullable
    public View focusSearch(int i) {
        if (isFocused()) {
            GridLayoutManager gridLayoutManager = this.f5584M0;
            View findViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.f5682I);
            if (findViewByPosition != null) {
                return focusSearch(findViewByPosition, i);
            }
        }
        return super.focusSearch(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int indexOfChild;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        View findViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.f5682I);
        if (findViewByPosition != null && i2 >= (indexOfChild = indexOfChild(findViewByPosition))) {
            if (i2 < i - 1) {
                return ((indexOfChild + i) - 1) - i2;
            }
            return indexOfChild;
        }
        return i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getExtraLayoutSpace() {
        return this.f5584M0.f5706g0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getFocusScrollStrategy() {
        return this.f5584M0.f5702c0;
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.f5584M0.f5694U;
    }

    public int getHorizontalSpacing() {
        return this.f5584M0.f5694U;
    }

    public int getInitialPrefetchItemCount() {
        return this.f5593V0;
    }

    public int getItemAlignmentOffset() {
        return ((C0334f1) this.f5584M0.f5704e0.f20700d).getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return ((C0334f1) this.f5584M0.f5704e0.f20700d).getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return ((C0334f1) this.f5584M0.f5704e0.f20700d).getItemAlignmentViewId();
    }

    @Nullable
    public OnUnhandledKeyListener getOnUnhandledKeyListener() {
        return this.f5592U0;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.f5584M0.f5708i0.f23760b;
    }

    public final int getSaveChildrenPolicy() {
        return this.f5584M0.f5708i0.f23759a;
    }

    public int getSelectedPosition() {
        return this.f5584M0.f5682I;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getSelectedSubPosition() {
        return this.f5584M0.f5683J;
    }

    @Nullable
    public SmoothScrollByBehavior getSmoothScrollByBehavior() {
        return this.f5585N0;
    }

    public final int getSmoothScrollMaxPendingMoves() {
        return this.f5584M0.f5713r;
    }

    public final float getSmoothScrollSpeedFactor() {
        return this.f5584M0.f5712q;
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.f5584M0.f5695V;
    }

    public int getVerticalSpacing() {
        return this.f5584M0.f5695V;
    }

    public void getViewSelectedOffsets(@NonNull View view, @NonNull int[] iArr) {
        int top;
        int i;
        int top2;
        int i2;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i3 = gridLayoutManager.f5715t;
        mt2 mt2Var = gridLayoutManager.f5703d0;
        if (i3 == 0) {
            m53 m53Var = (m53) mt2Var.f23109d;
            if (i3 == 0) {
                C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
                c0377q0.getClass();
                top2 = view.getLeft() + c0377q0.f6398e;
                i2 = c0377q0.f6402i;
            } else {
                C0377q0 c0377q02 = (C0377q0) view.getLayoutParams();
                c0377q02.getClass();
                top2 = view.getTop() + c0377q02.f6399f;
                i2 = c0377q02.f6403j;
            }
            iArr[0] = m53Var.m6080b(top2 + i2);
            iArr[1] = gridLayoutManager.m1432w(view);
            return;
        }
        m53 m53Var2 = (m53) mt2Var.f23109d;
        if (i3 == 0) {
            C0377q0 c0377q03 = (C0377q0) view.getLayoutParams();
            c0377q03.getClass();
            top = view.getLeft() + c0377q03.f6398e;
            i = c0377q03.f6402i;
        } else {
            C0377q0 c0377q04 = (C0377q0) view.getLayoutParams();
            c0377q04.getClass();
            top = view.getTop() + c0377q04.f6399f;
            i = c0377q04.f6403j;
        }
        iArr[1] = m53Var2.m6080b(top + i);
        iArr[0] = gridLayoutManager.m1432w(view);
    }

    public int getWindowAlignment() {
        return ((m53) this.f5584M0.f5703d0.f23109d).f22811f;
    }

    public int getWindowAlignmentOffset() {
        return ((m53) this.f5584M0.f5703d0.f23109d).f22812g;
    }

    public float getWindowAlignmentOffsetPercent() {
        return ((m53) this.f5584M0.f5703d0.f23109d).f22813h;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.f5587P0;
    }

    public boolean hasPreviousViewInSameRow(int i) {
        int i2;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        ux0 ux0Var = gridLayoutManager.f5701b0;
        if (ux0Var == null || i == -1 || (i2 = ux0Var.f27517f) < 0) {
            return false;
        }
        if (i2 <= 0) {
            int i3 = ux0Var.mo7277k(i).f27011a;
            for (int childCount = gridLayoutManager.getChildCount() - 1; childCount >= 0; childCount--) {
                int m1394p = GridLayoutManager.m1394p(gridLayoutManager.getChildAt(childCount));
                tx0 mo7277k = gridLayoutManager.f5701b0.mo7277k(m1394p);
                if (mo7277k == null || mo7277k.f27011a != i3 || m1394p >= i) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean isChildLayoutAnimated() {
        return this.f5586O0;
    }

    public boolean isFocusDrawingOrderEnabled() {
        return super.isChildrenDrawingOrderEnabled();
    }

    public final boolean isFocusSearchDisabled() {
        if ((this.f5584M0.f5677D & 32768) != 0) {
            return true;
        }
        return false;
    }

    public boolean isItemAlignmentOffsetWithPadding() {
        return ((C0334f1) this.f5584M0.f5704e0.f20700d).isItemAlignmentOffsetWithPadding();
    }

    public boolean isScrollEnabled() {
        if ((this.f5584M0.f5677D & 131072) != 0) {
            return true;
        }
        return false;
    }

    public boolean isWindowAlignmentPreferKeyLineOverHighEdge() {
        if ((((m53) this.f5584M0.f5703d0.f23109d).f22810e & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isWindowAlignmentPreferKeyLineOverLowEdge() {
        if ((((m53) this.f5584M0.f5703d0.f23109d).f22810e & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (z) {
            int i2 = gridLayoutManager.f5682I;
            while (true) {
                View findViewByPosition = gridLayoutManager.findViewByPosition(i2);
                if (findViewByPosition != null) {
                    if (findViewByPosition.getVisibility() == 0 && findViewByPosition.hasFocusable()) {
                        findViewByPosition.requestFocus();
                        return;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            gridLayoutManager.getClass();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, @Nullable Rect rect) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        if ((this.f5594W0 & 1) == 1) {
            return false;
        }
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i5 = gridLayoutManager.f5702c0;
        if (i5 != 1 && i5 != 2) {
            View findViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.f5682I);
            if (findViewByPosition == null) {
                return false;
            }
            return findViewByPosition.requestFocus(i, rect);
        }
        int childCount = gridLayoutManager.getChildCount();
        if ((i & 2) != 0) {
            i4 = 1;
            i3 = childCount;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        m53 m53Var = (m53) gridLayoutManager.f5703d0.f23109d;
        int i6 = m53Var.f22815j;
        int i7 = ((m53Var.f22814i - i6) - m53Var.f22816k) + i6;
        while (true) {
            if (i2 != i3) {
                View childAt = gridLayoutManager.getChildAt(i2);
                if (childAt.getVisibility() == 0 && gridLayoutManager.f5716u.getDecoratedStart(childAt) >= i6 && gridLayoutManager.f5716u.getDecoratedEnd(childAt) <= i7 && childAt.requestFocus(i, rect)) {
                    break;
                }
                i2 += i4;
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        int i2;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (gridLayoutManager != null) {
            boolean z = false;
            if (gridLayoutManager.f5715t == 0) {
                if (i == 1) {
                    i2 = 262144;
                }
                i2 = 0;
            } else {
                if (i == 1) {
                    i2 = 524288;
                }
                i2 = 0;
            }
            int i3 = gridLayoutManager.f5677D;
            if ((786432 & i3) != i2) {
                gridLayoutManager.f5677D = i2 | (i3 & (-786433)) | 256;
                m53 m53Var = (m53) gridLayoutManager.f5703d0.f23108c;
                if (i == 1) {
                    z = true;
                }
                m53Var.f22817l = z;
            }
        }
    }

    public void removeOnChildViewHolderSelectedListener(@NonNull OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        ArrayList arrayList = this.f5584M0.f5679F;
        if (arrayList != null) {
            arrayList.remove(onChildViewHolderSelectedListener);
        }
    }

    public final void removeOnLayoutCompletedListener(@NonNull OnLayoutCompletedListener onLayoutCompletedListener) {
        ArrayList arrayList = this.f5584M0.f5680G;
        if (arrayList != null) {
            arrayList.remove(onLayoutCompletedListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View view) {
        boolean z;
        if (view.hasFocus() && isFocusable()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f5594W0 = 1 | this.f5594W0;
            requestFocus();
        }
        super.removeView(view);
        if (z) {
            this.f5594W0 ^= -2;
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        boolean hasFocus = getChildAt(i).hasFocus();
        if (hasFocus) {
            this.f5594W0 |= 1;
            requestFocus();
        }
        super.removeViewAt(i);
        if (hasFocus) {
            this.f5594W0 ^= -2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if ((gridLayoutManager.f5677D & 64) != 0) {
            gridLayoutManager.m1416U(i, 0, 0, false);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setAnimateChildLayout(boolean z) {
        if (this.f5586O0 != z) {
            this.f5586O0 = z;
            if (!z) {
                this.f5588Q0 = getItemAnimator();
                super.setItemAnimator(null);
            } else {
                super.setItemAnimator(this.f5588Q0);
            }
        }
    }

    public void setChildrenVisibility(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        gridLayoutManager.f5688O = i;
        if (i != -1) {
            int childCount = gridLayoutManager.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                gridLayoutManager.getChildAt(i2).setVisibility(gridLayoutManager.f5688O);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExtraLayoutSpace(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i2 = gridLayoutManager.f5706g0;
        if (i2 != i) {
            if (i2 >= 0) {
                gridLayoutManager.f5706g0 = i;
                gridLayoutManager.requestLayout();
                return;
            }
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
    }

    public void setFocusDrawingOrderEnabled(boolean z) {
        super.setChildrenDrawingOrderEnabled(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setFocusScrollStrategy(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Invalid scrollStrategy");
        }
        this.f5584M0.f5702c0 = i;
        requestLayout();
    }

    public final void setFocusSearchDisabled(boolean z) {
        int i;
        int i2;
        if (z) {
            i = 393216;
        } else {
            i = 262144;
        }
        setDescendantFocusability(i);
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i3 = gridLayoutManager.f5677D & (-32769);
        if (z) {
            i2 = 32768;
        } else {
            i2 = 0;
        }
        gridLayoutManager.f5677D = i2 | i3;
    }

    public void setGravity(int i) {
        this.f5584M0.f5698Y = i;
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z) {
        this.f5587P0 = z;
    }

    @Deprecated
    public void setHorizontalMargin(int i) {
        setHorizontalSpacing(i);
    }

    public void setHorizontalSpacing(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (gridLayoutManager.f5715t == 0) {
            gridLayoutManager.f5694U = i;
            gridLayoutManager.f5696W = i;
        } else {
            gridLayoutManager.f5694U = i;
            gridLayoutManager.f5697X = i;
        }
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i) {
        this.f5593V0 = i;
    }

    public void setItemAlignmentOffset(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        ((C0334f1) gridLayoutManager.f5704e0.f20700d).setItemAlignmentOffset(i);
        gridLayoutManager.m1417V();
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        ((C0334f1) gridLayoutManager.f5704e0.f20700d).setItemAlignmentOffsetPercent(f);
        gridLayoutManager.m1417V();
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        ((C0334f1) gridLayoutManager.f5704e0.f20700d).setItemAlignmentOffsetWithPadding(z);
        gridLayoutManager.m1417V();
        requestLayout();
    }

    public void setItemAlignmentViewId(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        ((C0334f1) gridLayoutManager.f5704e0.f20700d).setItemAlignmentViewId(i);
        gridLayoutManager.m1417V();
    }

    @Deprecated
    public void setItemMargin(int i) {
        setItemSpacing(i);
    }

    public void setItemSpacing(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        gridLayoutManager.f5694U = i;
        gridLayoutManager.f5695V = i;
        gridLayoutManager.f5697X = i;
        gridLayoutManager.f5696W = i;
        requestLayout();
    }

    public void setLayoutEnabled(boolean z) {
        boolean z2;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i = gridLayoutManager.f5677D;
        int i2 = 0;
        if ((i & 512) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            int i3 = i & (-513);
            if (z) {
                i2 = 512;
            }
            gridLayoutManager.f5677D = i3 | i2;
            gridLayoutManager.requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        if (layoutManager == null) {
            super.setLayoutManager(null);
            GridLayoutManager gridLayoutManager = this.f5584M0;
            if (gridLayoutManager != null) {
                gridLayoutManager.f5714s = null;
                gridLayoutManager.f5701b0 = null;
            }
            this.f5584M0 = null;
            return;
        }
        GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager;
        this.f5584M0 = gridLayoutManager2;
        gridLayoutManager2.f5714s = this;
        gridLayoutManager2.f5701b0 = null;
        super.setLayoutManager(layoutManager);
    }

    public void setOnChildLaidOutListener(@Nullable OnChildLaidOutListener onChildLaidOutListener) {
        this.f5584M0.f5681H = onChildLaidOutListener;
    }

    @SuppressLint({"ReferencesDeprecated"})
    public void setOnChildSelectedListener(@Nullable OnChildSelectedListener onChildSelectedListener) {
        this.f5584M0.f5678E = onChildSelectedListener;
    }

    public void setOnChildViewHolderSelectedListener(@Nullable OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (onChildViewHolderSelectedListener == null) {
            gridLayoutManager.f5679F = null;
            return;
        }
        ArrayList arrayList = gridLayoutManager.f5679F;
        if (arrayList == null) {
            gridLayoutManager.f5679F = new ArrayList();
        } else {
            arrayList.clear();
        }
        gridLayoutManager.f5679F.add(onChildViewHolderSelectedListener);
    }

    public void setOnKeyInterceptListener(@Nullable OnKeyInterceptListener onKeyInterceptListener) {
        this.f5591T0 = onKeyInterceptListener;
    }

    public void setOnMotionInterceptListener(@Nullable OnMotionInterceptListener onMotionInterceptListener) {
        this.f5590S0 = onMotionInterceptListener;
    }

    public void setOnTouchInterceptListener(@Nullable OnTouchInterceptListener onTouchInterceptListener) {
        this.f5589R0 = onTouchInterceptListener;
    }

    public void setOnUnhandledKeyListener(@Nullable OnUnhandledKeyListener onUnhandledKeyListener) {
        this.f5592U0 = onUnhandledKeyListener;
    }

    public void setPruneChild(boolean z) {
        boolean z2;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i = gridLayoutManager.f5677D;
        int i2 = 65536;
        if ((i & 65536) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            int i3 = i & (-65537);
            if (!z) {
                i2 = 0;
            }
            gridLayoutManager.f5677D = i3 | i2;
            if (z) {
                gridLayoutManager.requestLayout();
            }
        }
    }

    public final void setSaveChildrenLimitNumber(int i) {
        C1617oc c1617oc = this.f5584M0.f5708i0;
        c1617oc.f23760b = i;
        c1617oc.m6560d();
    }

    public final void setSaveChildrenPolicy(int i) {
        C1617oc c1617oc = this.f5584M0.f5708i0;
        c1617oc.f23759a = i;
        c1617oc.m6560d();
    }

    public void setScrollEnabled(boolean z) {
        boolean z2;
        int i;
        GridLayoutManager gridLayoutManager = this.f5584M0;
        int i2 = gridLayoutManager.f5677D;
        int i3 = 0;
        if ((i2 & 131072) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            int i4 = i2 & (-131073);
            if (z) {
                i3 = 131072;
            }
            int i5 = i4 | i3;
            gridLayoutManager.f5677D = i5;
            if ((i5 & 131072) != 0 && gridLayoutManager.f5702c0 == 0 && (i = gridLayoutManager.f5682I) != -1) {
                gridLayoutManager.m1412Q(i, gridLayoutManager.f5683J, gridLayoutManager.f5687N, true);
            }
        }
    }

    public void setSelectedPosition(int i) {
        this.f5584M0.m1416U(i, 0, 0, false);
    }

    public void setSelectedPositionSmooth(int i) {
        this.f5584M0.m1416U(i, 0, 0, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionSmoothWithSub(int i, int i2) {
        this.f5584M0.m1416U(i, i2, 0, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionWithSub(int i, int i2) {
        this.f5584M0.m1416U(i, i2, 0, false);
    }

    public final void setSmoothScrollByBehavior(@Nullable SmoothScrollByBehavior smoothScrollByBehavior) {
        this.f5585N0 = smoothScrollByBehavior;
    }

    public final void setSmoothScrollMaxPendingMoves(int i) {
        this.f5584M0.f5713r = i;
    }

    public final void setSmoothScrollSpeedFactor(float f) {
        this.f5584M0.f5712q = f;
    }

    @Deprecated
    public void setVerticalMargin(int i) {
        setVerticalSpacing(i);
    }

    public void setVerticalSpacing(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (gridLayoutManager.f5715t == 1) {
            gridLayoutManager.f5695V = i;
            gridLayoutManager.f5696W = i;
        } else {
            gridLayoutManager.f5695V = i;
            gridLayoutManager.f5697X = i;
        }
        requestLayout();
    }

    public void setWindowAlignment(int i) {
        ((m53) this.f5584M0.f5703d0.f23109d).f22811f = i;
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i) {
        ((m53) this.f5584M0.f5703d0.f23109d).f22812g = i;
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f) {
        m53 m53Var = (m53) this.f5584M0.f5703d0.f23109d;
        m53Var.getClass();
        if ((f >= RecyclerView.f7068F0 && f <= 100.0f) || f == -1.0f) {
            m53Var.f22813h = f;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z) {
        int i;
        m53 m53Var = (m53) this.f5584M0.f5703d0.f23109d;
        if (z) {
            i = m53Var.f22810e | 2;
        } else {
            i = m53Var.f22810e & (-3);
        }
        m53Var.f22810e = i;
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z) {
        int i;
        m53 m53Var = (m53) this.f5584M0.f5703d0.f23109d;
        if (z) {
            i = m53Var.f22810e | 1;
        } else {
            i = m53Var.f22810e & (-2);
        }
        m53Var.f22810e = i;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i, int i2) {
        SmoothScrollByBehavior smoothScrollByBehavior = this.f5585N0;
        if (smoothScrollByBehavior != null) {
            smoothScrollBy(i, i2, smoothScrollByBehavior.configSmoothScrollByInterpolator(i, i2), this.f5585N0.configSmoothScrollByDuration(i, i2));
        } else {
            smoothScrollBy(i, i2, null, Integer.MIN_VALUE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if ((gridLayoutManager.f5677D & 64) != 0) {
            gridLayoutManager.m1416U(i, 0, 0, false);
        } else {
            super.smoothScrollToPosition(i);
        }
    }

    public void setSelectedPosition(int i, int i2) {
        this.f5584M0.m1416U(i, 0, i2, false);
    }

    public void setSelectedPositionSmooth(int i, @Nullable ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder findViewHolderForPosition = findViewHolderForPosition(i);
            if (findViewHolderForPosition != null && !hasPendingAdapterUpdates()) {
                viewHolderTask.run(findViewHolderForPosition);
            } else {
                addOnChildViewHolderSelectedListener(new C1389kf(this, i, viewHolderTask));
            }
        }
        setSelectedPositionSmooth(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionWithSub(int i, int i2, int i3) {
        this.f5584M0.m1416U(i, i2, i3, false);
    }

    public void setSelectedPosition(int i, @Nullable ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder findViewHolderForPosition = findViewHolderForPosition(i);
            if (findViewHolderForPosition != null && !hasPendingAdapterUpdates()) {
                viewHolderTask.run(findViewHolderForPosition);
            } else {
                addOnChildViewHolderSelectedListener(new C1509lf(this, i, viewHolderTask));
            }
        }
        setSelectedPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i, int i2, @Nullable Interpolator interpolator) {
        SmoothScrollByBehavior smoothScrollByBehavior = this.f5585N0;
        if (smoothScrollByBehavior != null) {
            smoothScrollBy(i, i2, interpolator, smoothScrollByBehavior.configSmoothScrollByDuration(i, i2));
        } else {
            smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
        }
    }
}
