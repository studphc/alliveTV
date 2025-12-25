package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import java.util.ArrayList;
import p000.b01;
import p000.jr1;
import p000.kr1;
import p000.ye0;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {

    /* renamed from: A */
    public static final float f4051A = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: B */
    public static final jr1 f4052B = new AccessibilityDelegateCompat();

    /* renamed from: C */
    public static final int[] f4053C = {R.attr.fillViewport};

    /* renamed from: a */
    public final float f4054a;

    /* renamed from: b */
    public long f4055b;

    /* renamed from: c */
    public final Rect f4056c;

    /* renamed from: d */
    public final OverScroller f4057d;

    /* renamed from: e */
    public int f4058e;

    /* renamed from: f */
    public boolean f4059f;

    /* renamed from: g */
    public boolean f4060g;

    /* renamed from: h */
    public View f4061h;

    /* renamed from: i */
    public boolean f4062i;

    /* renamed from: j */
    public VelocityTracker f4063j;

    /* renamed from: k */
    public boolean f4064k;

    /* renamed from: l */
    public boolean f4065l;

    /* renamed from: m */
    public final int f4066m;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowBottom;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowTop;

    /* renamed from: n */
    public final int f4067n;

    /* renamed from: o */
    public final int f4068o;

    /* renamed from: p */
    public int f4069p;

    /* renamed from: q */
    public final int[] f4070q;

    /* renamed from: r */
    public final int[] f4071r;

    /* renamed from: s */
    public int f4072s;

    /* renamed from: t */
    public int f4073t;

    /* renamed from: u */
    public SavedState f4074u;

    /* renamed from: v */
    public final NestedScrollingParentHelper f4075v;

    /* renamed from: w */
    public final NestedScrollingChildHelper f4076w;

    /* renamed from: x */
    public float f4077x;

    /* renamed from: y */
    public OnScrollChangeListener f4078y;

    /* renamed from: z */
    public final DifferentialMotionFlingController f4079z;

    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
        void onScrollChange(@NonNull NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public int f4080a;

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return ye0.m8298r(sb, "}", this.f4080a);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4080a);
        }
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static boolean m1017a(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        if ((parent instanceof ViewGroup) && m1017a((View) parent, nestedScrollView)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && m1018b(findNextFocus, maxScrollAmount, getHeight())) {
            Rect rect = this.f4056c;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            m1023g(computeScrollDeltaToGetChildRectOnScreen(rect), 0, 1, true);
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m1023g(maxScrollAmount, 0, 1, true);
        }
        if (findFocus != null && findFocus.isFocused() && !m1018b(findFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* renamed from: b */
    public final boolean m1018b(View view, int i, int i2) {
        Rect rect = this.f4056c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        if (rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i2) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final void m1019c(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f4076w.dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void computeScroll() {
        int round;
        int i;
        if (this.f4057d.isFinished()) {
            return;
        }
        this.f4057d.computeScrollOffset();
        int currY = this.f4057d.getCurrY();
        int i2 = currY - this.f4073t;
        int height = getHeight();
        if (i2 > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != RecyclerView.f7068F0) {
            round = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-i2) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
            if (round != i2) {
                this.mEdgeGlowTop.finish();
            }
        } else {
            if (i2 < 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != RecyclerView.f7068F0) {
                float f = height;
                round = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (i2 * 4.0f) / f, 0.5f) * (f / 4.0f));
                if (round != i2) {
                    this.mEdgeGlowBottom.finish();
                }
            }
            this.f4073t = currY;
            int[] iArr = this.f4071r;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i2, iArr, null, 1);
            i = i2 - iArr[1];
            int scrollRange = getScrollRange();
            if (i != 0) {
                int scrollY = getScrollY();
                m1021e(i, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i - scrollY2;
                iArr[1] = 0;
                dispatchNestedScroll(0, scrollY2, 0, i3, this.f4070q, 1, iArr);
                i = i3 - iArr[1];
            }
            if (i != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i < 0) {
                        if (this.mEdgeGlowTop.isFinished()) {
                            this.mEdgeGlowTop.onAbsorb((int) this.f4057d.getCurrVelocity());
                        }
                    } else if (this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onAbsorb((int) this.f4057d.getCurrVelocity());
                    }
                }
                this.f4057d.abortAnimation();
                stopNestedScroll(1);
            }
            if (this.f4057d.isFinished()) {
                postInvalidateOnAnimation();
                return;
            } else {
                stopNestedScroll(1);
                return;
            }
        }
        i2 -= round;
        this.f4073t = currY;
        int[] iArr2 = this.f4071r;
        iArr2[1] = 0;
        dispatchNestedPreScroll(0, i2, iArr2, null, 1);
        i = i2 - iArr2[1];
        int scrollRange2 = getScrollRange();
        if (i != 0) {
        }
        if (i != 0) {
        }
        if (this.f4057d.isFinished()) {
        }
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i;
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i = i4 - verticalFadingEdgeLength;
        } else {
            i = i4;
        }
        int i5 = rect.bottom;
        if (i5 > i && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i;
            }
            return Math.min(i3, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        }
        if (rect.top >= scrollY || i5 >= i) {
            return 0;
        }
        if (rect.height() > height) {
            i2 = 0 - (i - rect.bottom);
        } else {
            i2 = 0 - (scrollY - rect.top);
        }
        return Math.max(i2, -getScrollY());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    /* renamed from: d */
    public final void m1020d(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4069p) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f4058e = (int) motionEvent.getY(i);
            this.f4069p = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f4063j;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f4076w.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f4076w.dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        return this.f4076w.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NonNull int[] iArr2) {
        this.f4076w.dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i2 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (kr1.m5782a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i = getPaddingLeft();
            } else {
                i = 0;
            }
            if (kr1.m5782a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i, min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        if (!this.mEdgeGlowBottom.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (kr1.m5782a(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i2 = getPaddingLeft();
            }
            if (kr1.m5782a(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate(i2 - width2, max);
            canvas.rotate(180.0f, width2, RecyclerView.f7068F0);
            this.mEdgeGlowBottom.setSize(width2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    /* renamed from: e */
    public final boolean m1021e(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i5 = i3 + i;
        if (i2 > 0 || i2 < 0) {
            i2 = 0;
            z = true;
        } else {
            z = false;
        }
        if (i5 <= i4) {
            if (i5 < 0) {
                i4 = 0;
            } else {
                i4 = i5;
                z2 = false;
                if (z2 && !hasNestedScrollingParent(1)) {
                    this.f4057d.springBack(i2, i4, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i2, i4, z, z2);
                if (z && !z2) {
                    return false;
                }
            }
        }
        z2 = true;
        if (z2) {
            this.f4057d.springBack(i2, i4, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i2, i4, z, z2);
        return z ? true : true;
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        this.f4056c.setEmpty();
        int childCount = getChildCount();
        int i = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        if (childCount > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 19) {
                    if (keyCode != 20) {
                        if (keyCode != 62) {
                            if (keyCode != 92) {
                                if (keyCode != 93) {
                                    if (keyCode != 122) {
                                        if (keyCode != 123) {
                                            return false;
                                        }
                                        pageScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                                        return false;
                                    }
                                    pageScroll(33);
                                    return false;
                                }
                                return fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                            }
                            return fullScroll(33);
                        }
                        if (keyEvent.isShiftPressed()) {
                            i = 33;
                        }
                        pageScroll(i);
                        return false;
                    }
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                    }
                    return arrowScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                }
                if (keyEvent.isAltPressed()) {
                    return fullScroll(33);
                }
                return arrowScroll(33);
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final boolean m1022f(int i, int i2, int i3) {
        boolean z;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        if (i == 33) {
            z = true;
        } else {
            z = false;
        }
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = focusables.get(i6);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                if (i2 < top && bottom < i3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (view == null) {
                    view = view2;
                    z5 = z3;
                } else {
                    if ((z && top < view.getTop()) || (!z && bottom > view.getBottom())) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z5) {
                        if (z3) {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z5 = true;
                    } else {
                        if (!z4) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i2 >= scrollY && i3 <= i5) {
            z2 = false;
        } else {
            if (z) {
                i4 = i2 - scrollY;
            } else {
                i4 = i3 - i5;
            }
            m1023g(i4, 0, 1, true);
            z2 = true;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z2;
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            this.f4057d.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            startNestedScroll(2, 1);
            this.f4073t = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public boolean fullScroll(int i) {
        boolean z;
        int childCount;
        if (i == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.f4056c;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            rect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.top = rect.bottom - height;
        }
        return m1022f(i, rect.top, rect.bottom);
    }

    /* renamed from: g */
    public final int m1023g(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        VelocityTracker velocityTracker;
        if (i3 == 1) {
            startNestedScroll(2, i3);
        }
        boolean dispatchNestedPreScroll = dispatchNestedPreScroll(0, i, this.f4071r, this.f4070q, i3);
        int[] iArr = this.f4071r;
        int[] iArr2 = this.f4070q;
        if (dispatchNestedPreScroll) {
            i4 = i - iArr[1];
            i5 = iArr2[1];
        } else {
            i4 = i;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        if ((overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (m1021e(i4, 0, scrollY, scrollRange) && !hasNestedScrollingParent(i3)) {
            z3 = true;
        } else {
            z3 = false;
        }
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, this.f4070q, i3, iArr);
        int i6 = i5 + iArr2[1];
        int i7 = i4 - iArr[1];
        int i8 = scrollY + i7;
        if (i8 < 0) {
            if (z2) {
                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-i7) / getHeight(), i2 / getWidth());
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (i8 > scrollRange && z2) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i7 / getHeight(), 1.0f - (i2 / getWidth()));
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (this.mEdgeGlowTop.isFinished() && this.mEdgeGlowBottom.isFinished()) {
            z4 = z3;
        } else {
            postInvalidateOnAnimation();
            z4 = false;
        }
        if (z4 && i3 == 0 && (velocityTracker = this.f4063j) != null) {
            velocityTracker.clear();
        }
        if (i3 == 1) {
            stopNestedScroll(i3);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return i6;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return RecyclerView.f7068F0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f4075v.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return RecyclerView.f7068F0;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @VisibleForTesting
    public float getVerticalScrollFactorCompat() {
        if (this.f4077x == RecyclerView.f7068F0) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.f4077x = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f4077x;
    }

    /* renamed from: h */
    public final boolean m1024h(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float distance = EdgeEffectCompat.getDistance(edgeEffect) * getHeight();
        float abs = Math.abs(-i) * 0.35f;
        float f = this.f4054a * 0.015f;
        double log = Math.log(abs / f);
        double d = f4051A;
        if (((float) (Math.exp((d / (d - 1.0d)) * log) * f)) < distance) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return this.f4076w.hasNestedScrollingParent(i);
    }

    /* renamed from: i */
    public final void m1025i(int i, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f4055b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f4057d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, i3);
            if (z) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.f4073t = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f4057d.isFinished()) {
                this.f4057d.abortAnimation();
                stopNestedScroll(1);
            }
            scrollBy(i, i2);
        }
        this.f4055b = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean isFillViewport() {
        return this.f4064k;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f4076w.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.f4065l;
    }

    /* renamed from: j */
    public final boolean m1026j(MotionEvent motionEvent) {
        boolean z;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != RecyclerView.f7068F0) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, RecyclerView.f7068F0, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != RecyclerView.f7068F0) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, RecyclerView.f7068F0, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void measureChild(@NonNull View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4060g = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        int i;
        int i2;
        float f;
        if (motionEvent.getAction() == 8 && !this.f4062i) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i = 9;
                f = motionEvent.getAxisValue(9);
                i2 = (int) motionEvent.getX();
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                float axisValue = motionEvent.getAxisValue(26);
                i2 = getWidth() / 2;
                i = 26;
                f = axisValue;
            } else {
                i = 0;
                i2 = 0;
                f = 0.0f;
            }
            if (f != RecyclerView.f7068F0) {
                m1023g(-((int) (getVerticalScrollFactorCompat() * f)), i2, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                if (i != 0) {
                    this.f4079z.onMotionEvent(motionEvent, i);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.f4062i) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6) {
                            m1020d(motionEvent);
                        }
                    }
                } else {
                    int i2 = this.f4069p;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f4058e) > this.f4066m && (2 & getNestedScrollAxes()) == 0) {
                                this.f4062i = true;
                                this.f4058e = y;
                                if (this.f4063j == null) {
                                    this.f4063j = VelocityTracker.obtain();
                                }
                                this.f4063j.addMovement(motionEvent);
                                this.f4072s = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f4062i = false;
            this.f4069p = -1;
            VelocityTracker velocityTracker = this.f4063j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4063j = null;
            }
            if (this.f4057d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else {
            int y2 = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y2 >= childAt.getTop() - scrollY && y2 < childAt.getBottom() - scrollY && x >= childAt.getLeft() && x < childAt.getRight()) {
                    this.f4058e = y2;
                    this.f4069p = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.f4063j;
                    if (velocityTracker2 == null) {
                        this.f4063j = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.f4063j.addMovement(motionEvent);
                    this.f4057d.computeScrollOffset();
                    if (!m1026j(motionEvent) && this.f4057d.isFinished()) {
                        z = false;
                    }
                    this.f4062i = z;
                    startNestedScroll(2, 0);
                }
            }
            if (!m1026j(motionEvent) && this.f4057d.isFinished()) {
                z = false;
            }
            this.f4062i = z;
            VelocityTracker velocityTracker3 = this.f4063j;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f4063j = null;
            }
        }
        return this.f4062i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = 0;
        this.f4059f = false;
        View view = this.f4061h;
        if (view != null && m1017a(view, this)) {
            View view2 = this.f4061h;
            Rect rect = this.f4056c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        this.f4061h = null;
        if (!this.f4060g) {
            if (this.f4074u != null) {
                scrollTo(getScrollX(), this.f4074u.f4080a);
                this.f4074u = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i5 = 0;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i5 && scrollY >= 0) {
                i6 = paddingTop + scrollY > i5 ? i5 - paddingTop : scrollY;
            }
            if (i6 != scrollY) {
                scrollTo(getScrollX(), i6);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f4060g = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4064k && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        if (!z) {
            dispatchNestedFling(RecyclerView.f7068F0, f2, true);
            fling((int) f2);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        m1019c(i4, i5, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
        this.f4075v.onNestedScrollAccepted(view, view2, i, i2);
        startNestedScroll(2, i2);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || !m1018b(findNextFocusFromRect, 0, getHeight())) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4074u = savedState;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, androidx.core.widget.NestedScrollView$SavedState, android.os.Parcelable] */
    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f4080a = getScrollY();
        return baseSavedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.f4078y;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m1018b(findFocus, 0, i4)) {
            Rect rect = this.f4056c;
            findFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findFocus, rect);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                if (this.f4065l) {
                    smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                } else {
                    scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                }
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i) {
        this.f4075v.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0153  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        ViewParent parent;
        float onPullDistance;
        int round;
        int i;
        ViewParent parent2;
        if (this.f4063j == null) {
            this.f4063j = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4072s = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        float f = this.f4072s;
        float f2 = RecyclerView.f7068F0;
        obtain.offsetLocation(RecyclerView.f7068F0, f);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                m1020d(motionEvent);
                                this.f4058e = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f4069p));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f4058e = (int) motionEvent.getY(actionIndex);
                            this.f4069p = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.f4062i && getChildCount() > 0 && this.f4057d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            postInvalidateOnAnimation();
                        }
                        this.f4069p = -1;
                        this.f4062i = false;
                        VelocityTracker velocityTracker = this.f4063j;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.f4063j = null;
                        }
                        stopNestedScroll(0);
                        this.mEdgeGlowTop.onRelease();
                        this.mEdgeGlowBottom.onRelease();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f4069p);
                    if (findPointerIndex == -1) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + this.f4069p + " in onTouchEvent");
                    } else {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int i2 = this.f4058e - y;
                        float x = motionEvent.getX(findPointerIndex) / getWidth();
                        float height = i2 / getHeight();
                        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != RecyclerView.f7068F0) {
                            onPullDistance = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -height, x);
                            if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == RecyclerView.f7068F0) {
                                this.mEdgeGlowTop.onRelease();
                            }
                        } else {
                            if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != RecyclerView.f7068F0) {
                                onPullDistance = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, height, 1.0f - x);
                                if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == RecyclerView.f7068F0) {
                                    this.mEdgeGlowBottom.onRelease();
                                }
                            }
                            round = Math.round(f2 * getHeight());
                            if (round != 0) {
                                invalidate();
                            }
                            i = i2 - round;
                            if (!this.f4062i && Math.abs(i) > this.f4066m) {
                                parent2 = getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                                this.f4062i = true;
                                i = i <= 0 ? i - this.f4066m : i + this.f4066m;
                            }
                            if (this.f4062i) {
                                int m1023g = m1023g(i, (int) motionEvent.getX(findPointerIndex), 0, false);
                                this.f4058e = y - m1023g;
                                this.f4072s += m1023g;
                            }
                        }
                        f2 = onPullDistance;
                        round = Math.round(f2 * getHeight());
                        if (round != 0) {
                        }
                        i = i2 - round;
                        if (!this.f4062i) {
                            parent2 = getParent();
                            if (parent2 != null) {
                            }
                            this.f4062i = true;
                            if (i <= 0) {
                            }
                        }
                        if (this.f4062i) {
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker2 = this.f4063j;
                velocityTracker2.computeCurrentVelocity(1000, this.f4068o);
                int yVelocity = (int) velocityTracker2.getYVelocity(this.f4069p);
                if (Math.abs(yVelocity) >= this.f4067n) {
                    if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != RecyclerView.f7068F0) {
                        if (m1024h(this.mEdgeGlowTop, yVelocity)) {
                            this.mEdgeGlowTop.onAbsorb(yVelocity);
                        } else {
                            fling(-yVelocity);
                        }
                    } else if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != RecyclerView.f7068F0) {
                        int i3 = -yVelocity;
                        if (m1024h(this.mEdgeGlowBottom, i3)) {
                            this.mEdgeGlowBottom.onAbsorb(i3);
                        } else {
                            fling(i3);
                        }
                    } else {
                        int i4 = -yVelocity;
                        float f3 = i4;
                        if (!dispatchNestedPreFling(RecyclerView.f7068F0, f3)) {
                            dispatchNestedFling(RecyclerView.f7068F0, f3, true);
                            fling(i4);
                        }
                    }
                } else if (this.f4057d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f4069p = -1;
                this.f4062i = false;
                VelocityTracker velocityTracker3 = this.f4063j;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f4063j = null;
                }
                stopNestedScroll(0);
                this.mEdgeGlowTop.onRelease();
                this.mEdgeGlowBottom.onRelease();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f4062i && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f4057d.isFinished()) {
                this.f4057d.abortAnimation();
                stopNestedScroll(1);
            }
            int y2 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.f4058e = y2;
            this.f4069p = pointerId;
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker4 = this.f4063j;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public boolean pageScroll(int i) {
        boolean z;
        if (i == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.f4056c;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            rect.top = getScrollY() - height;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        int i2 = rect.top;
        int i3 = height + i2;
        rect.bottom = i3;
        return m1022f(i, i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f4059f) {
            Rect rect = this.f4056c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        } else {
            this.f4061h = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z) {
        boolean z2;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.f4063j) != null) {
            velocityTracker.recycle();
            this.f4063j = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f4059f = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width < width2 && i >= 0) {
                if (width + i > width2) {
                    i = width2 - width;
                }
            } else {
                i = 0;
            }
            if (height < height2 && i2 >= 0) {
                if (height + i2 > height2) {
                    i2 = height2 - height;
                }
            } else {
                i2 = 0;
            }
            if (i != getScrollX() || i2 != getScrollY()) {
                super.scrollTo(i, i2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f4064k) {
            this.f4064k = z;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f4076w.setNestedScrollingEnabled(z);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener onScrollChangeListener) {
        this.f4078y = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f4065l = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2) {
        m1025i(i, i2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollTo(int i, int i2) {
        m1025i(i - getScrollX(), i2 - getScrollY(), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return this.f4076w.startNestedScroll(i, i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        this.f4076w.stopNestedScroll(i);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.R.attr.nestedScrollViewStyle);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        return this.f4076w.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5) {
        m1019c(i4, i5, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public final void smoothScrollBy(int i, int i2, int i3) {
        m1025i(i, i2, i3, false);
    }

    public final void smoothScrollTo(int i, int i2, int i3) {
        m1025i(i - getScrollX(), i2 - getScrollY(), i3, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4056c = new Rect();
        this.f4059f = true;
        this.f4060g = false;
        this.f4061h = null;
        this.f4062i = false;
        this.f4065l = true;
        this.f4069p = -1;
        this.f4070q = new int[2];
        this.f4071r = new int[2];
        this.f4079z = new DifferentialMotionFlingController(getContext(), new b01(26, this));
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attributeSet);
        this.f4054a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f4057d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f4066m = viewConfiguration.getScaledTouchSlop();
        this.f4067n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4068o = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4053C, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f4075v = new NestedScrollingParentHelper(this);
        this.f4076w = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, f4052B);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return this.f4076w.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4) {
        m1019c(i4, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
